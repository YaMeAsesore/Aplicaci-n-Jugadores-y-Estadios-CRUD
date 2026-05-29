package edu.itvo.roompersistence.domain.usecase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.itvo.roompersistence.domain.repository.VenueRepository;
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
public final class GetVenuesUseCase_Factory implements Factory<GetVenuesUseCase> {
  private final Provider<VenueRepository> repositoryProvider;

  private GetVenuesUseCase_Factory(Provider<VenueRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetVenuesUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetVenuesUseCase_Factory create(Provider<VenueRepository> repositoryProvider) {
    return new GetVenuesUseCase_Factory(repositoryProvider);
  }

  public static GetVenuesUseCase newInstance(VenueRepository repository) {
    return new GetVenuesUseCase(repository);
  }
}
