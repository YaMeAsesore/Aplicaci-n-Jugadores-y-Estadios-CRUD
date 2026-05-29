package edu.itvo.roompersistence.domain.usecase

import edu.itvo.roompersistence.domain.repository.VenueRepository
import javax.inject.Inject

class GetVenuesUseCase @Inject constructor(
    private val repository: VenueRepository
) {

    operator fun invoke() = repository.getVenues()
}
