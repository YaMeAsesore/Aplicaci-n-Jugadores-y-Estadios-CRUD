package edu.itvo.roompersistence.presentation.venue.event

sealed interface AddVenueEvent {

    data class OnNameChanged(
        val value: String
    ) : AddVenueEvent

    data class OnLocationChanged(
        val value: String
    ) : AddVenueEvent

    data class OnCountryChanged(
        val value: String
    ) : AddVenueEvent

    data class OnCapacityChanged(
        val value: String
    ) : AddVenueEvent

    data class OnPhotoSelected(
        val value: String
    ) : AddVenueEvent

    data object SaveVenue : AddVenueEvent
}
