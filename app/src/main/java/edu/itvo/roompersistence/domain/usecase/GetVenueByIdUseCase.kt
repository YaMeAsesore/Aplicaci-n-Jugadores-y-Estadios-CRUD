package edu.itvo.roompersistence.domain.usecase

import edu.itvo.roompersistence.domain.repository.VenueRepository
import javax.inject.Inject

class GetVenueByIdUseCase @Inject constructor(
    private val repository: VenueRepository
) {

    suspend operator fun invoke(
        venueId: Long
    ) = repository.getVenueById(venueId)
}
