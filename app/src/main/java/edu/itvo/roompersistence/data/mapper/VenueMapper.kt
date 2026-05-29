package edu.itvo.roompersistence.data.mapper

import edu.itvo.roompersistence.data.local.entity.VenueEntity
import edu.itvo.roompersistence.domain.model.Venue

fun VenueEntity.toDomain(): Venue {

    return Venue(
        id = id,
        name = name,
        location = location,
        country = country,
        capacity = capacity,
        photo = photo
    )
}

fun Venue.toEntity(): VenueEntity {

    return VenueEntity(
        id = id,
        name = name,
        location = location,
        country = country,
        capacity = capacity,
        photo = photo
    )
}
