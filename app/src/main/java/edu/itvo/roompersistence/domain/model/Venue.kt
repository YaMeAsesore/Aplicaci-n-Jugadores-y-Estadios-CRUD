package edu.itvo.roompersistence.domain.model

data class Venue(
    val id: Long = 0L,
    val name: String,
    val location: String,
    val country: String,
    val capacity: Int,
    val photo: String?
)
