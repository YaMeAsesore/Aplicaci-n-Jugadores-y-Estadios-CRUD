package edu.itvo.roompersistence.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.itvo.roompersistence.data.local.dao.PlayerDao;
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
public final class DatabaseModule_ProvidePlayerDaoFactory implements Factory<PlayerDao> {
  private final Provider<AppDatabase> databaseProvider;

  private DatabaseModule_ProvidePlayerDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public PlayerDao get() {
    return providePlayerDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvidePlayerDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvidePlayerDaoFactory(databaseProvider);
  }

  public static PlayerDao providePlayerDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.providePlayerDao(database));
  }
}
