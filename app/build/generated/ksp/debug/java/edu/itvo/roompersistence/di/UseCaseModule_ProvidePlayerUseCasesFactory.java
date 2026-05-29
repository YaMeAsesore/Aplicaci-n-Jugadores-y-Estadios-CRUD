package edu.itvo.roompersistence.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.itvo.roompersistence.domain.repository.PlayerRepository;
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
public final class UseCaseModule_ProvidePlayerUseCasesFactory implements Factory<PlayerUseCases> {
  private final Provider<PlayerRepository> repositoryProvider;

  private UseCaseModule_ProvidePlayerUseCasesFactory(
      Provider<PlayerRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public PlayerUseCases get() {
    return providePlayerUseCases(repositoryProvider.get());
  }

  public static UseCaseModule_ProvidePlayerUseCasesFactory create(
      Provider<PlayerRepository> repositoryProvider) {
    return new UseCaseModule_ProvidePlayerUseCasesFactory(repositoryProvider);
  }

  public static PlayerUseCases providePlayerUseCases(PlayerRepository repository) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.providePlayerUseCases(repository));
  }
}
