package edu.itvo.roompersistence.presentation.venue.event

sealed interface AddVenueUiEvent {

    data class ShowSnackbar(
        val message: String,
        val navigateBack: Boolean = false
    ) : AddVenueUiEvent
}
