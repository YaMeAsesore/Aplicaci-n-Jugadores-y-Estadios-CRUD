package edu.itvo.roompersistence.data.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.itvo.roompersistence.data.local.dao.PlayerDao;
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
public final class PlayerRepositoryImpl_Factory implements Factory<PlayerRepositoryImpl> {
  private final Provider<PlayerDao> playerDaoProvider;

  private PlayerRepositoryImpl_Factory(Provider<PlayerDao> playerDaoProvider) {
    this.playerDaoProvider = playerDaoProvider;
  }

  @Override
  public PlayerRepositoryImpl get() {
    return newInstance(playerDaoProvider.get());
  }

  public static PlayerRepositoryImpl_Factory create(Provider<PlayerDao> playerDaoProvider) {
    return new PlayerRepositoryImpl_Factory(playerDaoProvider);
  }

  public static PlayerRepositoryImpl newInstance(PlayerDao playerDao) {
    return new PlayerRepositoryImpl(playerDao);
  }
}
