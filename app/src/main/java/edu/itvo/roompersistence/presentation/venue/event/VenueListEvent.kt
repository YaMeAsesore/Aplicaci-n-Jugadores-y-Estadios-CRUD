package edu.itvo.roompersistence.presentation.venue.event

import edu.itvo.roompersistence.domain.model.Venue

sealed interface VenueListEvent {

    data class DeleteVenue(
        val venue: Venue
    ) : VenueListEvent
}
