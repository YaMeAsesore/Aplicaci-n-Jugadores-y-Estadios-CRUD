package edu.itvo.roompersistence.presentation.venue.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.itvo.roompersistence.domain.model.Venue
import edu.itvo.roompersistence.domain.usecase.VenueUseCases
import edu.itvo.roompersistence.presentation.venue.event.VenueListEvent
import edu.itvo.roompersistence.presentation.venue.state.VenueListUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VenueListViewModel @Inject constructor(
    private val useCases: VenueUseCases
) : ViewModel() {

    private val _uiState =
        MutableStateFlow(VenueListUiState())

    val uiState =
        _uiState.asStateFlow()

    init {
        observeVenues()
    }

    fun onEvent(
        event: VenueListEvent
    ) {

        when (event) {

            is VenueListEvent.DeleteVenue -> {

                deleteVenue(event.venue)
            }
        }
    }

    private fun observeVenues() {

        useCases
            .getVenues()
            .onEach { venues ->

                _uiState.update {
                    it.copy(venues = venues)
                }
            }
            .launchIn(viewModelScope)
    }

    private fun deleteVenue(
        venue: Venue
    ) {

        viewModelScope.launch {
            useCases.deleteVenue(venue)
        }
    }
}
