package edu.itvo.roompersistence.data.repository

import edu.itvo.roompersistence.data.local.dao.VenueDao
import edu.itvo.roompersistence.data.mapper.toDomain
import edu.itvo.roompersistence.data.mapper.toEntity
import edu.itvo.roompersistence.domain.model.Venue
import edu.itvo.roompersistence.domain.repository.VenueRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class VenueRepositoryImpl @Inject constructor(
    private val venueDao: VenueDao
) : VenueRepository {

    override suspend fun insertVenue(
        venue: Venue
    ) {

        venueDao.insertVenue(
            venue.toEntity()
        )
    }

    override fun getVenues(): Flow<List<Venue>> {

        return venueDao.getVenues()
            .map { entities ->

                entities.map { entity ->
                    entity.toDomain()
                }
            }
    }

    override suspend fun getVenueById(
        venueId: Long
    ): Venue? {

        return venueDao.getVenueById(venueId)?.toDomain()
    }

    override suspend fun deleteVenue(
        venue: Venue
    ) {

        venueDao.deleteVenue(
            venue.toEntity()
        )
    }
}
