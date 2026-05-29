package edu.itvo.roompersistence.di

import edu.itvo.roompersistence.domain.repository.PlayerRepository
import edu.itvo.roompersistence.domain.repository.VenueRepository
import edu.itvo.roompersistence.domain.usecase.AddPlayerUseCase
import edu.itvo.roompersistence.domain.usecase.AddVenueUseCase
import edu.itvo.roompersistence.domain.usecase.DeletePlayerUseCase
import edu.itvo.roompersistence.domain.usecase.DeleteVenueUseCase
import edu.itvo.roompersistence.domain.usecase.GetPlayersUseCase
import edu.itvo.roompersistence.domain.usecase.GetPlayerByIdUseCase
import edu.itvo.roompersistence.domain.usecase.GetVenuesUseCase
import edu.itvo.roompersistence.domain.usecase.GetVenueByIdUseCase
import edu.itvo.roompersistence.domain.usecase.PlayerUseCases
import edu.itvo.roompersistence.domain.usecase.VenueUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun providePlayerUseCases(
        repository: PlayerRepository
    ): PlayerUseCases {

        return PlayerUseCases(
            addPlayer = AddPlayerUseCase(repository),
            getPlayers = GetPlayersUseCase(repository),
            getPlayerById = GetPlayerByIdUseCase(repository),
            deletePlayer = DeletePlayerUseCase(repository)
        )
    }

    @Provides
    fun provideVenueUseCases(
        repository: VenueRepository
    ): VenueUseCases {

        return VenueUseCases(
            addVenue = AddVenueUseCase(repository),
            getVenues = GetVenuesUseCase(repository),
            getVenueById = GetVenueByIdUseCase(repository),
            deleteVenue = DeleteVenueUseCase(repository)
        )
    }
}