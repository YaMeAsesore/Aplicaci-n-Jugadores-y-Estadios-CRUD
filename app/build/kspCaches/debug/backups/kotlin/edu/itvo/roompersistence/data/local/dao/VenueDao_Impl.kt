package edu.itvo.roompersistence.`data`.local.dao

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import edu.itvo.roompersistence.`data`.local.entity.VenueEntity
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class VenueDao_Impl(
  __db: RoomDatabase,
) : VenueDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfVenueEntity: EntityInsertAdapter<VenueEntity>

  private val __deleteAdapterOfVenueEntity: EntityDeleteOrUpdateAdapter<VenueEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfVenueEntity = object : EntityInsertAdapter<VenueEntity>() {
      protected override fun createQuery(): String = "INSERT OR REPLACE INTO `venues` (`id`,`name`,`location`,`country`,`capacity`,`photo`) VALUES (nullif(?, 0),?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: VenueEntity) {
        statement.bindLong(1, entity.id)
        statement.bindText(2, entity.name)
        statement.bindText(3, entity.location)
        statement.bindText(4, entity.country)
        statement.bindLong(5, entity.capacity.toLong())
        val _tmpPhoto: String? = entity.photo
        if (_tmpPhoto == null) {
          statement.bindNull(6)
        } else {
          statement.bindText(6, _tmpPhoto)
        }
      }
    }
    this.__deleteAdapterOfVenueEntity = object : EntityDeleteOrUpdateAdapter<VenueEntity>() {
      protected override fun createQuery(): String = "DELETE FROM `venues` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: VenueEntity) {
        statement.bindLong(1, entity.id)
      }
    }
  }

  public override suspend fun insertVenue(venue: VenueEntity): Unit = performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfVenueEntity.insert(_connection, venue)
  }

  public override suspend fun deleteVenue(venue: VenueEntity): Unit = performSuspending(__db, false, true) { _connection ->
    __deleteAdapterOfVenueEntity.handle(_connection, venue)
  }

  public override fun getVenues(): Flow<List<VenueEntity>> {
    val _sql: String = "SELECT * FROM venues ORDER BY name ASC"
    return createFlow(__db, false, arrayOf("venues")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _columnIndexOfLocation: Int = getColumnIndexOrThrow(_stmt, "location")
        val _columnIndexOfCountry: Int = getColumnIndexOrThrow(_stmt, "country")
        val _columnIndexOfCapacity: Int = getColumnIndexOrThrow(_stmt, "capacity")
        val _columnIndexOfPhoto: Int = getColumnIndexOrThrow(_stmt, "photo")
        val _result: MutableList<VenueEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: VenueEntity
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpName: String
          _tmpName = _stmt.getText(_columnIndexOfName)
          val _tmpLocation: String
          _tmpLocation = _stmt.getText(_columnIndexOfLocation)
          val _tmpCountry: String
          _tmpCountry = _stmt.getText(_columnIndexOfCountry)
          val _tmpCapacity: Int
          _tmpCapacity = _stmt.getLong(_columnIndexOfCapacity).toInt()
          val _tmpPhoto: String?
          if (_stmt.isNull(_columnIndexOfPhoto)) {
            _tmpPhoto = null
          } else {
            _tmpPhoto = _stmt.getText(_columnIndexOfPhoto)
          }
          _item = VenueEntity(_tmpId,_tmpName,_tmpLocation,_tmpCountry,_tmpCapacity,_tmpPhoto)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getVenueById(venueId: Long): VenueEntity? {
    val _sql: String = "SELECT * FROM venues WHERE id = ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, venueId)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _columnIndexOfLocation: Int = getColumnIndexOrThrow(_stmt, "location")
        val _columnIndexOfCountry: Int = getColumnIndexOrThrow(_stmt, "country")
        val _columnIndexOfCapacity: Int = getColumnIndexOrThrow(_stmt, "capacity")
        val _columnIndexOfPhoto: Int = getColumnIndexOrThrow(_stmt, "photo")
        val _result: VenueEntity?
        if (_stmt.step()) {
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpName: String
          _tmpName = _stmt.getText(_columnIndexOfName)
          val _tmpLocation: String
          _tmpLocation = _stmt.getText(_columnIndexOfLocation)
          val _tmpCountry: String
          _tmpCountry = _stmt.getText(_columnIndexOfCountry)
          val _tmpCapacity: Int
          _tmpCapacity = _stmt.getLong(_columnIndexOfCapacity).toInt()
          val _tmpPhoto: String?
          if (_stmt.isNull(_columnIndexOfPhoto)) {
            _tmpPhoto = null
          } else {
            _tmpPhoto = _stmt.getText(_columnIndexOfPhoto)
          }
          _result = VenueEntity(_tmpId,_tmpName,_tmpLocation,_tmpCountry,_tmpCapacity,_tmpPhoto)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
