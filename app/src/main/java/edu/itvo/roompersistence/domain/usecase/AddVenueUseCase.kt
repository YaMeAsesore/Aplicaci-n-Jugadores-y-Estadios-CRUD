package edu.itvo.roompersistence.domain.usecase

import edu.itvo.roompersistence.domain.model.Venue
import edu.itvo.roompersistence.domain.repository.VenueRepository
import javax.inject.Inject

class AddVenueUseCase @Inject constructor(
    private val repository: VenueRepository
) {

    suspend operator fun invoke(
        venue: Venue
    ) {

        repository.insertVenue(venue)
    }
}
