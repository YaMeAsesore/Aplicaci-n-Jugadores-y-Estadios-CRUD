package edu.itvo.roompersistence.domain.repository

import edu.itvo.roompersistence.domain.model.Venue
import kotlinx.coroutines.flow.Flow

interface VenueRepository {

    suspend fun insertVenue(
        venue: Venue
    )

    fun getVenues(): Flow<List<Venue>>

    suspend fun getVenueById(
        venueId: Long
    ): Venue?

    suspend fun deleteVenue(
        venue: Venue
    )
}
