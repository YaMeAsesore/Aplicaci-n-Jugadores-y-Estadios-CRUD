package edu.itvo.roompersistence.domain.usecase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.itvo.roompersistence.domain.repository.PlayerRepository;
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
public final class AddPlayerUseCase_Factory implements Factory<AddPlayerUseCase> {
  private final Provider<PlayerRepository> repositoryProvider;

  private AddPlayerUseCase_Factory(Provider<PlayerRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public AddPlayerUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static AddPlayerUseCase_Factory create(Provider<PlayerRepository> repositoryProvider) {
    return new AddPlayerUseCase_Factory(repositoryProvider);
  }

  public static AddPlayerUseCase newInstance(PlayerRepository repository) {
    return new AddPlayerUseCase(repository);
  }
}
