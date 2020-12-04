package com.dvach.lab2.pojo;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NoteDao_Impl implements NoteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Task> __insertionAdapterOfTask;

  private final EntityDeletionOrUpdateAdapter<Task> __deletionAdapterOfTask;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public NoteDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTask = new EntityInsertionAdapter<Task>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Task` (`title`,`description`,`done`,`deadline`,`created`,`id`,`nameCategory`,`idCategory`,`idPriority`,`namePriority`,`color`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Task value) {
        if (value.getTitle() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDescription());
        }
        stmt.bindLong(3, value.getDone());
        stmt.bindLong(4, value.getDeadline());
        stmt.bindLong(5, value.getCreated());
        stmt.bindLong(6, value.getId());
        final Category _tmpCategory = value.getCategory();
        if(_tmpCategory != null) {
          if (_tmpCategory.getNameCategory() == null) {
            stmt.bindNull(7);
          } else {
            stmt.bindString(7, _tmpCategory.getNameCategory());
          }
          stmt.bindLong(8, _tmpCategory.getIdCategory());
        } else {
          stmt.bindNull(7);
          stmt.bindNull(8);
        }
        final Priority _tmpPriority = value.getPriority();
        if(_tmpPriority != null) {
          stmt.bindLong(9, _tmpPriority.getIdPriority());
          if (_tmpPriority.getNamePriority() == null) {
            stmt.bindNull(10);
          } else {
            stmt.bindString(10, _tmpPriority.getNamePriority());
          }
          if (_tmpPriority.getColor() == null) {
            stmt.bindNull(11);
          } else {
            stmt.bindString(11, _tmpPriority.getColor());
          }
        } else {
          stmt.bindNull(9);
          stmt.bindNull(10);
          stmt.bindNull(11);
        }
      }
    };
    this.__deletionAdapterOfTask = new EntityDeletionOrUpdateAdapter<Task>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Task` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Task value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Task";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Task task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTask.insert(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final ArrayList<Task> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTask.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Task task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTask.handle(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public Task getByName() {
    final String _sql = "SELECT * FROM Task";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfDone = CursorUtil.getColumnIndexOrThrow(_cursor, "done");
      final int _cursorIndexOfDeadline = CursorUtil.getColumnIndexOrThrow(_cursor, "deadline");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNameCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "nameCategory");
      final int _cursorIndexOfIdCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "idCategory");
      final int _cursorIndexOfIdPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "idPriority");
      final int _cursorIndexOfNamePriority = CursorUtil.getColumnIndexOrThrow(_cursor, "namePriority");
      final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
      final Task _result;
      if(_cursor.moveToFirst()) {
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        final int _tmpDone;
        _tmpDone = _cursor.getInt(_cursorIndexOfDone);
        final long _tmpDeadline;
        _tmpDeadline = _cursor.getLong(_cursorIndexOfDeadline);
        final int _tmpCreated;
        _tmpCreated = _cursor.getInt(_cursorIndexOfCreated);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final Category _tmpCategory;
        if (! (_cursor.isNull(_cursorIndexOfNameCategory) && _cursor.isNull(_cursorIndexOfIdCategory))) {
          final String _tmpNameCategory;
          _tmpNameCategory = _cursor.getString(_cursorIndexOfNameCategory);
          final int _tmpIdCategory;
          _tmpIdCategory = _cursor.getInt(_cursorIndexOfIdCategory);
          _tmpCategory = new Category(_tmpNameCategory,_tmpIdCategory);
        }  else  {
          _tmpCategory = null;
        }
        final Priority _tmpPriority;
        if (! (_cursor.isNull(_cursorIndexOfIdPriority) && _cursor.isNull(_cursorIndexOfNamePriority) && _cursor.isNull(_cursorIndexOfColor))) {
          final int _tmpIdPriority;
          _tmpIdPriority = _cursor.getInt(_cursorIndexOfIdPriority);
          final String _tmpNamePriority;
          _tmpNamePriority = _cursor.getString(_cursorIndexOfNamePriority);
          final String _tmpColor;
          _tmpColor = _cursor.getString(_cursorIndexOfColor);
          _tmpPriority = new Priority(_tmpIdPriority,_tmpNamePriority,_tmpColor);
        }  else  {
          _tmpPriority = null;
        }
        _result = new Task(_tmpTitle,_tmpDescription,_tmpDone,_tmpDeadline,_tmpCategory,_tmpPriority,_tmpCreated,_tmpId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Task> getAllTitles() {
    final String _sql = "SELECT * FROM Task";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfDone = CursorUtil.getColumnIndexOrThrow(_cursor, "done");
      final int _cursorIndexOfDeadline = CursorUtil.getColumnIndexOrThrow(_cursor, "deadline");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNameCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "nameCategory");
      final int _cursorIndexOfIdCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "idCategory");
      final int _cursorIndexOfIdPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "idPriority");
      final int _cursorIndexOfNamePriority = CursorUtil.getColumnIndexOrThrow(_cursor, "namePriority");
      final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
      final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Task _item;
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        final int _tmpDone;
        _tmpDone = _cursor.getInt(_cursorIndexOfDone);
        final long _tmpDeadline;
        _tmpDeadline = _cursor.getLong(_cursorIndexOfDeadline);
        final int _tmpCreated;
        _tmpCreated = _cursor.getInt(_cursorIndexOfCreated);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final Category _tmpCategory;
        if (! (_cursor.isNull(_cursorIndexOfNameCategory) && _cursor.isNull(_cursorIndexOfIdCategory))) {
          final String _tmpNameCategory;
          _tmpNameCategory = _cursor.getString(_cursorIndexOfNameCategory);
          final int _tmpIdCategory;
          _tmpIdCategory = _cursor.getInt(_cursorIndexOfIdCategory);
          _tmpCategory = new Category(_tmpNameCategory,_tmpIdCategory);
        }  else  {
          _tmpCategory = null;
        }
        final Priority _tmpPriority;
        if (! (_cursor.isNull(_cursorIndexOfIdPriority) && _cursor.isNull(_cursorIndexOfNamePriority) && _cursor.isNull(_cursorIndexOfColor))) {
          final int _tmpIdPriority;
          _tmpIdPriority = _cursor.getInt(_cursorIndexOfIdPriority);
          final String _tmpNamePriority;
          _tmpNamePriority = _cursor.getString(_cursorIndexOfNamePriority);
          final String _tmpColor;
          _tmpColor = _cursor.getString(_cursorIndexOfColor);
          _tmpPriority = new Priority(_tmpIdPriority,_tmpNamePriority,_tmpColor);
        }  else  {
          _tmpPriority = null;
        }
        _item = new Task(_tmpTitle,_tmpDescription,_tmpDone,_tmpDeadline,_tmpCategory,_tmpPriority,_tmpCreated,_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
