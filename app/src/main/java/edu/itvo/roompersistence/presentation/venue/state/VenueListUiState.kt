package edu.itvo.roompersistence.presentation.venue.state

import edu.itvo.roompersistence.domain.model.Venue

data class VenueListUiState(

    val venues: List<Venue> = emptyList()
)
