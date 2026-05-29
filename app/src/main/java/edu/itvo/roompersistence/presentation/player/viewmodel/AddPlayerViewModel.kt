package edu.itvo.roompersistence.presentation.player.viewmodel

import android.content.Context
import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import edu.itvo.roompersistence.core.copyImageToPersistentStorage
import edu.itvo.roompersistence.domain.model.Player
import edu.itvo.roompersistence.domain.usecase.PlayerUseCases
import edu.itvo.roompersistence.presentation.player.event.AddPlayerEvent
import edu.itvo.roompersistence.presentation.player.event.AddPlayerUiEvent
import edu.itvo.roompersistence.presentation.player.state.AddPlayerUiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddPlayerViewModel @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val useCases: PlayerUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val playerId: Long? = savedStateHandle["playerId"]

    private val _uiState =
        MutableStateFlow(AddPlayerUiState())

    val uiState =
        _uiState.asStateFlow()

    private val _uiEvent =
        Channel<AddPlayerUiEvent>()

    val uiEvent =
        _uiEvent.receiveAsFlow()

    init {
        loadPlayerIfEditing()
    }

    fun onEvent(
        event: AddPlayerEvent
    ) {

        when (event) {

            is AddPlayerEvent.OnFullNameChanged -> {

                _uiState.update {
                    it.copy(
                        fullName = event.value
                    )
                }
            }

            is AddPlayerEvent.OnNickNameChanged -> {

                _uiState.update {
                    it.copy(
                        nickName = event.value
                    )
                }
            }

            is AddPlayerEvent.OnNationalityChanged -> {

                _uiState.update {
                    it.copy(
                        nationality = event.value
                    )
                }
            }

            is AddPlayerEvent.OnGenderChanged -> {

                _uiState.update {
                    it.copy(
                        gender = event.value
                    )
                }
            }

            is AddPlayerEvent.OnBirthDateChanged -> {

                _uiState.update {
                    it.copy(
                        birthDate = event.value
                    )
                }
            }

            is AddPlayerEvent.OnPositionChanged -> {

                _uiState.update {
                    it.copy(
                        position = event.value
                    )
                }
            }

            is AddPlayerEvent.OnPhotoSelected -> {

                val persistentUri = event.value?.let {
                    copyImageToPersistentStorage(context, Uri.parse(it))
                }

                _uiState.update {
                    it.copy(
                        photoUri = persistentUri
                    )
                }
            }

            AddPlayerEvent.SavePlayer -> {

                savePlayer()
            }
        }
    }

    private fun loadPlayerIfEditing() {

        if (playerId != null) {

            viewModelScope.launch {

                val player = useCases.getPlayerById(playerId)

                if (player != null) {

                    _uiState.update {
                        it.copy(
                            fullName = player.fullName,
                            nickName = player.nickName,
                            nationality = player.nationality,
                            gender = player.gender,
                            birthDate = player.birthDate,
                            position = player.position,
                            photoUri = player.photo
                        )
                    }
                }
            }
        }
    }

    private fun savePlayer() {

        viewModelScope.launch {

            val state = uiState.value

            /*
            =========================================
            VALIDATIONS
            =========================================
             */

            if (state.fullName.isBlank()) {

                _uiEvent.send(
                    AddPlayerUiEvent.ShowSnackbar(
                        message = "Full name is required"
                    )
                )

                return@launch
            }

            if (state.birthDate == null) {

                _uiEvent.send(
                    AddPlayerUiEvent.ShowSnackbar(
                        message = "Please select birth date"
                    )
                )

                return@launch
            }

            /*
            =========================================
            SAVE PLAYER
            =========================================
             */

            useCases.addPlayer(
                Player(
                    id = playerId ?: 0L,
                    fullName = state.fullName,
                    nickName = state.nickName,
                    nationality = state.nationality,
                    gender = state.gender,
                    birthDate = state.birthDate,
                    photo = state.photoUri,
                    position = state.position
                )
            )

            /*
            =========================================
            SUCCESS EVENT
            =========================================
             */

            _uiEvent.send(
                AddPlayerUiEvent.ShowSnackbar(
                    message = "Player saved successfully",
                    navigateBack = true
                )
            )
        }
    }
}