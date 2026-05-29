package edu.itvo.roompersistence.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.itvo.roompersistence.data.local.dao.VenueDao;
import edu.itvo.roompersistence.data.local.database.AppDatabase;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class DatabaseModule_ProvideVenueDaoFactory implements Factory<VenueDao> {
  private final Provider<AppDatabase> databaseProvider;

  private DatabaseModule_ProvideVenueDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public VenueDao get() {
    return provideVenueDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideVenueDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvideVenueDaoFactory(databaseProvider);
  }

  public static VenueDao provideVenueDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideVenueDao(database));
  }
}
