package edu.itvo.roompersistence.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.itvo.roompersistence.data.local.entity.VenueEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VenueDao {

    /*
    =========================================
    INSERT VENUE
    =========================================
     */

    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    suspend fun insertVenue(
        venue: VenueEntity
    )

    /*
    =========================================
    GET VENUES
    =========================================
     */

    @Query(
        "SELECT * FROM venues ORDER BY name ASC"
    )
    fun getVenues(): Flow<List<VenueEntity>>

    /*
    =========================================
    GET VENUE BY ID
    =========================================
     */

    @Query(
        "SELECT * FROM venues WHERE id = :venueId"
    )
    suspend fun getVenueById(
        venueId: Long
    ): VenueEntity?

    /*
    =========================================
    DELETE VENUE
    =========================================
     */

    @Delete
    suspend fun deleteVenue(
        venue: VenueEntity
    )
}
