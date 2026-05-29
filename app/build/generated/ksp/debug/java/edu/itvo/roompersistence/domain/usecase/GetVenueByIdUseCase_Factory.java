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
public final class GetVenueByIdUseCase_Factory implements Factory<GetVenueByIdUseCase> {
  private final Provider<VenueRepository> repositoryProvider;

  private GetVenueByIdUseCase_Factory(Provider<VenueRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetVenueByIdUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetVenueByIdUseCase_Factory create(Provider<VenueRepository> repositoryProvider) {
    return new GetVenueByIdUseCase_Factory(repositoryProvider);
  }

  public static GetVenueByIdUseCase newInstance(VenueRepository repository) {
    return new GetVenueByIdUseCase(repository);
  }
}
