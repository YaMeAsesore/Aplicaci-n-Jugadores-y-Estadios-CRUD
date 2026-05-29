package edu.itvo.roompersistence.presentation.venue.viewmodel;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.itvo.roompersistence.domain.usecase.VenueUseCases;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AddVenueViewModel_Factory implements Factory<AddVenueViewModel> {
  private final Provider<Context> contextProvider;

  private final Provider<VenueUseCases> useCasesProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private AddVenueViewModel_Factory(Provider<Context> contextProvider,
      Provider<VenueUseCases> useCasesProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.contextProvider = contextProvider;
    this.useCasesProvider = useCasesProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public AddVenueViewModel get() {
    return newInstance(contextProvider.get(), useCasesProvider.get(), savedStateHandleProvider.get());
  }

  public static AddVenueViewModel_Factory create(Provider<Context> contextProvider,
      Provider<VenueUseCases> useCasesProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new AddVenueViewModel_Factory(contextProvider, useCasesProvider, savedStateHandleProvider);
  }

  public static AddVenueViewModel newInstance(Context context, VenueUseCases useCases,
      SavedStateHandle savedStateHandle) {
    return new AddVenueViewModel(context, useCases, savedStateHandle);
  }
}
