package edu.itvo.roompersistence.data.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.itvo.roompersistence.data.local.dao.VenueDao;
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
public final class VenueRepositoryImpl_Factory implements Factory<VenueRepositoryImpl> {
  private final Provider<VenueDao> venueDaoProvider;

  private VenueRepositoryImpl_Factory(Provider<VenueDao> venueDaoProvider) {
    this.venueDaoProvider = venueDaoProvider;
  }

  @Override
  public VenueRepositoryImpl get() {
    return newInstance(venueDaoProvider.get());
  }

  public static VenueRepositoryImpl_Factory create(Provider<VenueDao> venueDaoProvider) {
    return new VenueRepositoryImpl_Factory(venueDaoProvider);
  }

  public static VenueRepositoryImpl newInstance(VenueDao venueDao) {
    return new VenueRepositoryImpl(venueDao);
  }
}
