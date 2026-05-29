package edu.itvo.roompersistence.presentation.player.viewmodel;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.itvo.roompersistence.domain.usecase.PlayerUseCases;
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
public final class AddPlayerViewModel_Factory implements Factory<AddPlayerViewModel> {
  private final Provider<Context> contextProvider;

  private final Provider<PlayerUseCases> useCasesProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private AddPlayerViewModel_Factory(Provider<Context> contextProvider,
      Provider<PlayerUseCases> useCasesProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.contextProvider = contextProvider;
    this.useCasesProvider = useCasesProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public AddPlayerViewModel get() {
    return newInstance(contextProvider.get(), useCasesProvider.get(), savedStateHandleProvider.get());
  }

  public static AddPlayerViewModel_Factory create(Provider<Context> contextProvider,
      Provider<PlayerUseCases> useCasesProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new AddPlayerViewModel_Factory(contextProvider, useCasesProvider, savedStateHandleProvider);
  }

  public static AddPlayerViewModel newInstance(Context context, PlayerUseCases useCases,
      SavedStateHandle savedStateHandle) {
    return new AddPlayerViewModel(context, useCases, savedStateHandle);
  }
}
