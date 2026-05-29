package edu.itvo.roompersistence.presentation.venue.viewmodel

import android.content.Context
import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import edu.itvo.roompersistence.core.copyImageToPersistentStorage
import edu.itvo.roompersistence.domain.model.Venue
import edu.itvo.roompersistence.domain.usecase.VenueUseCases
import edu.itvo.roompersistence.presentation.venue.event.AddVenueEvent
import edu.itvo.roompersistence.presentation.venue.event.AddVenueUiEvent
import edu.itvo.roompersistence.presentation.venue.state.AddVenueUiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddVenueViewModel @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val useCases: VenueUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val venueId: Long? = savedStateHandle["venueId"]

    private val _uiState =
        MutableStateFlow(AddVenueUiState())

    val uiState =
        _uiState.asStateFlow()

    private val _uiEvent =
        Channel<AddVenueUiEvent>()

    val uiEvent =
        _uiEvent.receiveAsFlow()

    init {
        loadVenueIfEditing()
    }

    fun onEvent(
        event: AddVenueEvent
    ) {

        when (event) {

            is AddVenueEvent.OnNameChanged -> {

                _uiState.update {
                    it.copy(name = event.value)
                }
            }

            is AddVenueEvent.OnLocationChanged -> {

                _uiState.update {
                    it.copy(location = event.value)
                }
            }

            is AddVenueEvent.OnCountryChanged -> {

                _uiState.update {
                    it.copy(country = event.value)
                }
            }

            is AddVenueEvent.OnCapacityChanged -> {

                // Solo permitir dígitos en el campo
                if (event.value.all { it.isDigit() }) {

                    _uiState.update {
                        it.copy(capacity = event.value)
                    }
                }
            }

            is AddVenueEvent.OnPhotoSelected -> {

                val persistentUri = event.value?.let {
                    copyImageToPersistentStorage(context, Uri.parse(it))
                }

                _uiState.update {
                    it.copy(photoUri = persistentUri)
                }
            }

            AddVenueEvent.SaveVenue -> {

                saveVenue()
            }
        }
    }

    private fun loadVenueIfEditing() {

        if (venueId != null) {

            viewModelScope.launch {

                val venue = useCases.getVenueById(venueId)

                if (venue != null) {

                    _uiState.update {
                        it.copy(
                            name = venue.name,
                            location = venue.location,
                            country = venue.country,
                            capacity = venue.capacity.toString(),
                            photoUri = venue.photo
                        )
                    }
                }
            }
        }
    }

    private fun saveVenue() {

        viewModelScope.launch {

            val state = uiState.value

            /*
            =========================================
            VALIDACIONES
            =========================================
             */

            if (state.name.isBlank()) {

                _uiEvent.send(
                    AddVenueUiEvent.ShowSnackbar(
                        message = "El nombre del estadio es obligatorio"
                    )
                )

                return@launch
            }

            if (state.location.isBlank()) {

                _uiEvent.send(
                    AddVenueUiEvent.ShowSnackbar(
                        message = "La ubicación es obligatoria"
                    )
                )

                return@launch
            }

            if (state.capacity.isBlank()) {

                _uiEvent.send(
                    AddVenueUiEvent.ShowSnackbar(
                        message = "La capacidad es obligatoria"
                    )
                )

                return@launch
            }

            /*
            =========================================
            GUARDAR
            =========================================
             */

            useCases.addVenue(
                Venue(
                    id = venueId ?: 0L,
                    name = state.name,
                    location = state.location,
                    country = state.country,
                    capacity = state.capacity.toIntOrNull() ?: 0,
                    photo = state.photoUri
                )
            )

            val message = if (venueId != null) {
                "Estadio actualizado correctamente"
            } else {
                "Estadio guardado correctamente"
            }

            _uiEvent.send(
                AddVenueUiEvent.ShowSnackbar(
                    message = message,
                    navigateBack = true
                )
            )
        }
    }
}
