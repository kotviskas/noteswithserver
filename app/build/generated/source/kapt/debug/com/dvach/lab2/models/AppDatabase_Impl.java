package com.dvach.lab2.models;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UserDao _userDao;

  private volatile NoteDao _noteDao;

  private volatile CategoryDao _categoryDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `User` (`name` TEXT NOT NULL, `email` TEXT NOT NULL, `api_token` TEXT NOT NULL, `userId` INTEGER NOT NULL, PRIMARY KEY(`userId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Task` (`title` TEXT NOT NULL, `description` TEXT NOT NULL, `done` INTEGER NOT NULL, `deadline` INTEGER NOT NULL, `created` INTEGER NOT NULL, `id` INTEGER NOT NULL, `nameCategory` TEXT NOT NULL, `idCategory` INTEGER NOT NULL, `idPriority` INTEGER NOT NULL, `namePriority` TEXT NOT NULL, `color` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Category` (`nameCategory` TEXT NOT NULL, `idCategory` INTEGER NOT NULL, PRIMARY KEY(`idCategory`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '0739eada2dbb147312be3f205a158fd3')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `User`");
        _db.execSQL("DROP TABLE IF EXISTS `Task`");
        _db.execSQL("DROP TABLE IF EXISTS `Category`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUser = new HashMap<String, TableInfo.Column>(4);
        _columnsUser.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("api_token", new TableInfo.Column("api_token", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("userId", new TableInfo.Column("userId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUser = new TableInfo("User", _columnsUser, _foreignKeysUser, _indicesUser);
        final TableInfo _existingUser = TableInfo.read(_db, "User");
        if (! _infoUser.equals(_existingUser)) {
          return new RoomOpenHelper.ValidationResult(false, "User(com.dvach.lab2.models.User).\n"
                  + " Expected:\n" + _infoUser + "\n"
                  + " Found:\n" + _existingUser);
        }
        final HashMap<String, TableInfo.Column> _columnsTask = new HashMap<String, TableInfo.Column>(11);
        _columnsTask.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("done", new TableInfo.Column("done", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("deadline", new TableInfo.Column("deadline", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("created", new TableInfo.Column("created", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("nameCategory", new TableInfo.Column("nameCategory", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("idCategory", new TableInfo.Column("idCategory", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("idPriority", new TableInfo.Column("idPriority", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("namePriority", new TableInfo.Column("namePriority", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTask.put("color", new TableInfo.Column("color", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTask = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTask = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTask = new TableInfo("Task", _columnsTask, _foreignKeysTask, _indicesTask);
        final TableInfo _existingTask = TableInfo.read(_db, "Task");
        if (! _infoTask.equals(_existingTask)) {
          return new RoomOpenHelper.ValidationResult(false, "Task(com.dvach.lab2.models.Task).\n"
                  + " Expected:\n" + _infoTask + "\n"
                  + " Found:\n" + _existingTask);
        }
        final HashMap<String, TableInfo.Column> _columnsCategory = new HashMap<String, TableInfo.Column>(2);
        _columnsCategory.put("nameCategory", new TableInfo.Column("nameCategory", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategory.put("idCategory", new TableInfo.Column("idCategory", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCategory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCategory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCategory = new TableInfo("Category", _columnsCategory, _foreignKeysCategory, _indicesCategory);
        final TableInfo _existingCategory = TableInfo.read(_db, "Category");
        if (! _infoCategory.equals(_existingCategory)) {
          return new RoomOpenHelper.ValidationResult(false, "Category(com.dvach.lab2.models.Category).\n"
                  + " Expected:\n" + _infoCategory + "\n"
                  + " Found:\n" + _existingCategory);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "0739eada2dbb147312be3f205a158fd3", "078ba4514a4f9571bfa2b9f95d726f1c");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "User","Task","Category");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `User`");
      _db.execSQL("DELETE FROM `Task`");
      _db.execSQL("DELETE FROM `Category`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public NoteDao NoteDao() {
    if (_noteDao != null) {
      return _noteDao;
    } else {
      synchronized(this) {
        if(_noteDao == null) {
          _noteDao = new NoteDao_Impl(this);
        }
        return _noteDao;
      }
    }
  }

  @Override
  public CategoryDao CategoryDao() {
    if (_categoryDao != null) {
      return _categoryDao;
    } else {
      synchronized(this) {
        if(_categoryDao == null) {
          _categoryDao = new CategoryDao_Impl(this);
        }
        return _categoryDao;
      }
    }
  }
}
