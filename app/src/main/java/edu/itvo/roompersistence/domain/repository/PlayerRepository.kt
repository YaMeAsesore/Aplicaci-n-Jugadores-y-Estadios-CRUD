package edu.itvo.roompersistence.domain.repository

import edu.itvo.roompersistence.domain.model.Player
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {

    suspend fun insertPlayer(
        player: Player
    )

    fun getPlayers(): Flow<List<Player>>

    suspend fun getPlayerById(
        playerId: Long
    ): Player?

    suspend fun deletePlayer(
        player: Player
    )
}