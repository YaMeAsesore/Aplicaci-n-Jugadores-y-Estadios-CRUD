package edu.itvo.roompersistence.presentation.venue.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
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
public final class VenueListViewModel_Factory implements Factory<VenueListViewModel> {
  private final Provider<VenueUseCases> useCasesProvider;

  private VenueListViewModel_Factory(Provider<VenueUseCases> useCasesProvider) {
    this.useCasesProvider = useCasesProvider;
  }

  @Override
  public VenueListViewModel get() {
    return newInstance(useCasesProvider.get());
  }

  public static VenueListViewModel_Factory create(Provider<VenueUseCases> useCasesProvider) {
    return new VenueListViewModel_Factory(useCasesProvider);
  }

  public static VenueListViewModel newInstance(VenueUseCases useCases) {
    return new VenueListViewModel(useCases);
  }
}
