package edu.itvo.roompersistence.presentation.player.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.itvo.roompersistence.domain.usecase.PlayerUseCases;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class PlayerListViewModel_Factory implements Factory<PlayerListViewModel> {
  private final Provider<PlayerUseCases> useCasesProvider;

  private PlayerListViewModel_Factory(Provider<PlayerUseCases> useCasesProvider) {
    this.useCasesProvider = useCasesProvider;
  }

  @Override
  public PlayerListViewModel get() {
    return newInstance(useCasesProvider.get());
  }

  public static PlayerListViewModel_Factory create(Provider<PlayerUseCases> useCasesProvider) {
    return new PlayerListViewModel_Factory(useCasesProvider);
  }

  public static PlayerListViewModel newInstance(PlayerUseCases useCases) {
    return new PlayerListViewModel(useCases);
  }
}
