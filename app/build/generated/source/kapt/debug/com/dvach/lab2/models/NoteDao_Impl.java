package com.dvach.lab2.models;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NoteDao_Impl implements NoteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Task> __insertionAdapterOfNote;

  private final EntityDeletionOrUpdateAdapter<Task> __deletionAdapterOfNote;

  public NoteDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNote = new EntityInsertionAdapter<Task>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Note` (`name`,`text`,`date`,`category`,`prioritet`,`check`,`color`,`id`) VALUES (?,?,?,?,?,?,?,nullif(?, 0))";
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
        if (value.getDone() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDone());
        }
        if (value.getCategory() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCategory());
        }
        if (value.getPrioritet() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPrioritet());
        }
        final int _tmp;
        _tmp = value.getCheck() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        stmt.bindLong(7, value.getColor());
        stmt.bindLong(8, value.getId());
      }
    };
    this.__deletionAdapterOfNote = new EntityDeletionOrUpdateAdapter<Task>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Note` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Task value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void insert(final Task task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfNote.insert(task);
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
      __deletionAdapterOfNote.handle(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Task getByName() {
    final String _sql = "SELECT * FROM Note";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfText = CursorUtil.getColumnIndexOrThrow(_cursor, "text");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfPrioritet = CursorUtil.getColumnIndexOrThrow(_cursor, "prioritet");
      final int _cursorIndexOfCheck = CursorUtil.getColumnIndexOrThrow(_cursor, "check");
      final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final Task _result;
      if(_cursor.moveToFirst()) {
        _result = new Task();
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _result.setTitle(_tmpName);
        final String _tmpText;
        _tmpText = _cursor.getString(_cursorIndexOfText);
        _result.setDescription(_tmpText);
        final String _tmpDate;
        _tmpDate = _cursor.getString(_cursorIndexOfDate);
        _result.setDone(_tmpDate);
        final String _tmpCategory;
        _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        _result.setCategory(_tmpCategory);
        final String _tmpPrioritet;
        _tmpPrioritet = _cursor.getString(_cursorIndexOfPrioritet);
        _result.setPrioritet(_tmpPrioritet);
        final boolean _tmpCheck;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfCheck);
        _tmpCheck = _tmp != 0;
        _result.setCheck(_tmpCheck);
        final int _tmpColor;
        _tmpColor = _cursor.getInt(_cursorIndexOfColor);
        _result.setColor(_tmpColor);
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _result.setId(_tmpId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
