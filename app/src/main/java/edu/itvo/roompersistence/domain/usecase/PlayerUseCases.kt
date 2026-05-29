package edu.itvo.roompersistence.domain.usecase

data class PlayerUseCases(

    val addPlayer: AddPlayerUseCase,
    val getPlayers: GetPlayersUseCase,
    val getPlayerById: GetPlayerByIdUseCase,
    val deletePlayer: DeletePlayerUseCase
)