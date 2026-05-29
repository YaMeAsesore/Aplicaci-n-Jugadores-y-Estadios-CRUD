package edu.itvo.roompersistence.`data`.local.dao

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import edu.itvo.roompersistence.`data`.local.entity.PlayerEntity
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
public class PlayerDao_Impl(
  __db: RoomDatabase,
) : PlayerDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfPlayerEntity: EntityInsertAdapter<PlayerEntity>

  private val __deleteAdapterOfPlayerEntity: EntityDeleteOrUpdateAdapter<PlayerEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfPlayerEntity = object : EntityInsertAdapter<PlayerEntity>() {
      protected override fun createQuery(): String = "INSERT OR REPLACE INTO `players` (`id`,`fullName`,`nickName`,`nationality`,`gender`,`birthDate`,`photo`,`position`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: PlayerEntity) {
        statement.bindLong(1, entity.id)
        statement.bindText(2, entity.fullName)
        statement.bindText(3, entity.nickName)
        statement.bindText(4, entity.nationality)
        statement.bindText(5, entity.gender)
        statement.bindText(6, entity.birthDate)
        val _tmpPhoto: String? = entity.photo
        if (_tmpPhoto == null) {
          statement.bindNull(7)
        } else {
          statement.bindText(7, _tmpPhoto)
        }
        statement.bindText(8, entity.position)
      }
    }
    this.__deleteAdapterOfPlayerEntity = object : EntityDeleteOrUpdateAdapter<PlayerEntity>() {
      protected override fun createQuery(): String = "DELETE FROM `players` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: PlayerEntity) {
        statement.bindLong(1, entity.id)
      }
    }
  }

  public override suspend fun insertPlayer(player: PlayerEntity): Unit = performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfPlayerEntity.insert(_connection, player)
  }

  public override suspend fun deletePlayer(player: PlayerEntity): Unit = performSuspending(__db, false, true) { _connection ->
    __deleteAdapterOfPlayerEntity.handle(_connection, player)
  }

  public override fun getPlayers(): Flow<List<PlayerEntity>> {
    val _sql: String = "SELECT * FROM players ORDER BY fullName ASC"
    return createFlow(__db, false, arrayOf("players")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfFullName: Int = getColumnIndexOrThrow(_stmt, "fullName")
        val _columnIndexOfNickName: Int = getColumnIndexOrThrow(_stmt, "nickName")
        val _columnIndexOfNationality: Int = getColumnIndexOrThrow(_stmt, "nationality")
        val _columnIndexOfGender: Int = getColumnIndexOrThrow(_stmt, "gender")
        val _columnIndexOfBirthDate: Int = getColumnIndexOrThrow(_stmt, "birthDate")
        val _columnIndexOfPhoto: Int = getColumnIndexOrThrow(_stmt, "photo")
        val _columnIndexOfPosition: Int = getColumnIndexOrThrow(_stmt, "position")
        val _result: MutableList<PlayerEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: PlayerEntity
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpFullName: String
          _tmpFullName = _stmt.getText(_columnIndexOfFullName)
          val _tmpNickName: String
          _tmpNickName = _stmt.getText(_columnIndexOfNickName)
          val _tmpNationality: String
          _tmpNationality = _stmt.getText(_columnIndexOfNationality)
          val _tmpGender: String
          _tmpGender = _stmt.getText(_columnIndexOfGender)
          val _tmpBirthDate: String
          _tmpBirthDate = _stmt.getText(_columnIndexOfBirthDate)
          val _tmpPhoto: String?
          if (_stmt.isNull(_columnIndexOfPhoto)) {
            _tmpPhoto = null
          } else {
            _tmpPhoto = _stmt.getText(_columnIndexOfPhoto)
          }
          val _tmpPosition: String
          _tmpPosition = _stmt.getText(_columnIndexOfPosition)
          _item = PlayerEntity(_tmpId,_tmpFullName,_tmpNickName,_tmpNationality,_tmpGender,_tmpBirthDate,_tmpPhoto,_tmpPosition)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getPlayerById(playerId: Long): PlayerEntity? {
    val _sql: String = "SELECT * FROM players WHERE id = ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, playerId)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfFullName: Int = getColumnIndexOrThrow(_stmt, "fullName")
        val _columnIndexOfNickName: Int = getColumnIndexOrThrow(_stmt, "nickName")
        val _columnIndexOfNationality: Int = getColumnIndexOrThrow(_stmt, "nationality")
        val _columnIndexOfGender: Int = getColumnIndexOrThrow(_stmt, "gender")
        val _columnIndexOfBirthDate: Int = getColumnIndexOrThrow(_stmt, "birthDate")
        val _columnIndexOfPhoto: Int = getColumnIndexOrThrow(_stmt, "photo")
        val _columnIndexOfPosition: Int = getColumnIndexOrThrow(_stmt, "position")
        val _result: PlayerEntity?
        if (_stmt.step()) {
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpFullName: String
          _tmpFullName = _stmt.getText(_columnIndexOfFullName)
          val _tmpNickName: String
          _tmpNickName = _stmt.getText(_columnIndexOfNickName)
          val _tmpNationality: String
          _tmpNationality = _stmt.getText(_columnIndexOfNationality)
          val _tmpGender: String
          _tmpGender = _stmt.getText(_columnIndexOfGender)
          val _tmpBirthDate: String
          _tmpBirthDate = _stmt.getText(_columnIndexOfBirthDate)
          val _tmpPhoto: String?
          if (_stmt.isNull(_columnIndexOfPhoto)) {
            _tmpPhoto = null
          } else {
            _tmpPhoto = _stmt.getText(_columnIndexOfPhoto)
          }
          val _tmpPosition: String
          _tmpPosition = _stmt.getText(_columnIndexOfPosition)
          _result = PlayerEntity(_tmpId,_tmpFullName,_tmpNickName,_tmpNationality,_tmpGender,_tmpBirthDate,_tmpPhoto,_tmpPosition)
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
