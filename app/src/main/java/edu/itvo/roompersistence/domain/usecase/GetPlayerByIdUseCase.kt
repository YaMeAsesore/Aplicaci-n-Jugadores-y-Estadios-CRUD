package edu.itvo.roompersistence.domain.usecase

import edu.itvo.roompersistence.domain.repository.PlayerRepository
import javax.inject.Inject

class GetPlayerByIdUseCase @Inject constructor(
    private val repository: PlayerRepository
) {

    suspend operator fun invoke(
        playerId: Long
    ) = repository.getPlayerById(playerId)
}
