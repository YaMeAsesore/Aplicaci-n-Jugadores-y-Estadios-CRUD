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
public final class GetPlayerByIdUseCase_Factory implements Factory<GetPlayerByIdUseCase> {
  private final Provider<PlayerRepository> repositoryProvider;

  private GetPlayerByIdUseCase_Factory(Provider<PlayerRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetPlayerByIdUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetPlayerByIdUseCase_Factory create(Provider<PlayerRepository> repositoryProvider) {
    return new GetPlayerByIdUseCase_Factory(repositoryProvider);
  }

  public static GetPlayerByIdUseCase newInstance(PlayerRepository repository) {
    return new GetPlayerByIdUseCase(repository);
  }
}
