package edu.itvo.roompersistence.domain.usecase

data class VenueUseCases(
    val addVenue: AddVenueUseCase,
    val getVenues: GetVenuesUseCase,
    val getVenueById: GetVenueByIdUseCase,
    val deleteVenue: DeleteVenueUseCase
)
