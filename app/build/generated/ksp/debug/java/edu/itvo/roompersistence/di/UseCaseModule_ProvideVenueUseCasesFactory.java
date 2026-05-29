package edu.itvo.roompersistence.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.itvo.roompersistence.domain.repository.VenueRepository;
import edu.itvo.roompersistence.domain.usecase.VenueUseCases;
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
public final class UseCaseModule_ProvideVenueUseCasesFactory implements Factory<VenueUseCases> {
  private final Provider<VenueRepository> repositoryProvider;

  private UseCaseModule_ProvideVenueUseCasesFactory(Provider<VenueRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public VenueUseCases get() {
    return provideVenueUseCases(repositoryProvider.get());
  }

  public static UseCaseModule_ProvideVenueUseCasesFactory create(
      Provider<VenueRepository> repositoryProvider) {
    return new UseCaseModule_ProvideVenueUseCasesFactory(repositoryProvider);
  }

  public static VenueUseCases provideVenueUseCases(VenueRepository repository) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.provideVenueUseCases(repository));
  }
}
