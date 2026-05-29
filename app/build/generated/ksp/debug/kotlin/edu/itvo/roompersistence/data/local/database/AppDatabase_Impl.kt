package edu.itvo.roompersistence.`data`.local.database

import androidx.room.InvalidationTracker
import androidx.room.RoomOpenDelegate
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import edu.itvo.roompersistence.`data`.local.dao.PlayerDao
import edu.itvo.roompersistence.`data`.local.dao.PlayerDao_Impl
import edu.itvo.roompersistence.`data`.local.dao.VenueDao
import edu.itvo.roompersistence.`data`.local.dao.VenueDao_Impl
import javax.`annotation`.processing.Generated
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.collections.MutableSet
import kotlin.collections.Set
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import kotlin.collections.mutableSetOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class AppDatabase_Impl : AppDatabase() {
  private val _playerDao: Lazy<PlayerDao> = lazy {
    PlayerDao_Impl(this)
  }

  private val _venueDao: Lazy<VenueDao> = lazy {
    VenueDao_Impl(this)
  }

  protected override fun createOpenDelegate(): RoomOpenDelegate {
    val _openDelegate: RoomOpenDelegate = object : RoomOpenDelegate(2, "b67fbf4ac6bcd2a1f7b7eecbe7dcdb31", "60a66d09f8e1639016e30c20b32e33e6") {
      public override fun createAllTables(connection: SQLiteConnection) {
        connection.execSQL("CREATE TABLE IF NOT EXISTS `players` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fullName` TEXT NOT NULL, `nickName` TEXT NOT NULL, `nationality` TEXT NOT NULL, `gender` TEXT NOT NULL, `birthDate` TEXT NOT NULL, `photo` TEXT, `position` TEXT NOT NULL)")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `venues` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `location` TEXT NOT NULL, `country` TEXT NOT NULL, `capacity` INTEGER NOT NULL, `photo` TEXT)")
        connection.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        connection.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'b67fbf4ac6bcd2a1f7b7eecbe7dcdb31')")
      }

      public override fun dropAllTables(connection: SQLiteConnection) {
        connection.execSQL("DROP TABLE IF EXISTS `players`")
        connection.execSQL("DROP TABLE IF EXISTS `venues`")
      }

      public override fun onCreate(connection: SQLiteConnection) {
      }

      public override fun onOpen(connection: SQLiteConnection) {
        internalInitInvalidationTracker(connection)
      }

      public override fun onPreMigrate(connection: SQLiteConnection) {
        dropFtsSyncTriggers(connection)
      }

      public override fun onPostMigrate(connection: SQLiteConnection) {
      }

      public override fun onValidateSchema(connection: SQLiteConnection): RoomOpenDelegate.ValidationResult {
        val _columnsPlayers: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsPlayers.put("id", TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsPlayers.put("fullName", TableInfo.Column("fullName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsPlayers.put("nickName", TableInfo.Column("nickName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsPlayers.put("nationality", TableInfo.Column("nationality", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsPlayers.put("gender", TableInfo.Column("gender", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsPlayers.put("birthDate", TableInfo.Column("birthDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsPlayers.put("photo", TableInfo.Column("photo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsPlayers.put("position", TableInfo.Column("position", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysPlayers: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesPlayers: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoPlayers: TableInfo = TableInfo("players", _columnsPlayers, _foreignKeysPlayers, _indicesPlayers)
        val _existingPlayers: TableInfo = read(connection, "players")
        if (!_infoPlayers.equals(_existingPlayers)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |players(edu.itvo.roompersistence.data.local.entity.PlayerEntity).
              | Expected:
              |""".trimMargin() + _infoPlayers + """
              |
              | Found:
              |""".trimMargin() + _existingPlayers)
        }
        val _columnsVenues: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsVenues.put("id", TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsVenues.put("name", TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsVenues.put("location", TableInfo.Column("location", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsVenues.put("country", TableInfo.Column("country", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsVenues.put("capacity", TableInfo.Column("capacity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsVenues.put("photo", TableInfo.Column("photo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysVenues: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesVenues: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoVenues: TableInfo = TableInfo("venues", _columnsVenues, _foreignKeysVenues, _indicesVenues)
        val _existingVenues: TableInfo = read(connection, "venues")
        if (!_infoVenues.equals(_existingVenues)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |venues(edu.itvo.roompersistence.data.local.entity.VenueEntity).
              | Expected:
              |""".trimMargin() + _infoVenues + """
              |
              | Found:
              |""".trimMargin() + _existingVenues)
        }
        return RoomOpenDelegate.ValidationResult(true, null)
      }
    }
    return _openDelegate
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: MutableMap<String, String> = mutableMapOf()
    val _viewTables: MutableMap<String, Set<String>> = mutableMapOf()
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "players", "venues")
  }

  public override fun clearAllTables() {
    super.performClear(false, "players", "venues")
  }

  protected override fun getRequiredTypeConverterClasses(): Map<KClass<*>, List<KClass<*>>> {
    val _typeConvertersMap: MutableMap<KClass<*>, List<KClass<*>>> = mutableMapOf()
    _typeConvertersMap.put(PlayerDao::class, PlayerDao_Impl.getRequiredConverters())
    _typeConvertersMap.put(VenueDao::class, VenueDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecClasses(): Set<KClass<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: MutableSet<KClass<out AutoMigrationSpec>> = mutableSetOf()
    return _autoMigrationSpecsSet
  }

  public override fun createAutoMigrations(autoMigrationSpecs: Map<KClass<out AutoMigrationSpec>, AutoMigrationSpec>): List<Migration> {
    val _autoMigrations: MutableList<Migration> = mutableListOf()
    return _autoMigrations
  }

  public override fun playerDao(): PlayerDao = _playerDao.value

  public override fun venueDao(): VenueDao = _venueDao.value
}
