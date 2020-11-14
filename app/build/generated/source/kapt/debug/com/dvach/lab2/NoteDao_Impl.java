package com.dvach.lab2;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;

import com.dvach.lab2.models.Note;
import com.dvach.lab2.models.NoteDao;
import com.dvach.lab2.models.User;

import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NoteDao_Impl implements NoteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Note> __insertionAdapterOfNote;

  private final EntityDeletionOrUpdateAdapter<Note> __deletionAdapterOfNote;

  public NoteDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNote = new EntityInsertionAdapter<Note>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Note` (`name`,`text`,`date`,`category`,`prioritet`,`check`,`color`,`id`,`userName`,`email`,`password`,`userId`) VALUES (?,?,?,?,?,?,?,nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Note value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        if (value.getText() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getText());
        }
        if (value.getDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDate());
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
        final User _tmpUser = value.user;
        if(_tmpUser != null) {
          if (_tmpUser.getUserName() == null) {
            stmt.bindNull(9);
          } else {
            stmt.bindString(9, _tmpUser.getUserName());
          }
          if (_tmpUser.getEmail() == null) {
            stmt.bindNull(10);
          } else {
            stmt.bindString(10, _tmpUser.getEmail());
          }
          if (_tmpUser.getPassword() == null) {
            stmt.bindNull(11);
          } else {
            stmt.bindString(11, _tmpUser.getPassword());
          }
          stmt.bindLong(12, _tmpUser.getUserId());
        } else {
          stmt.bindNull(9);
          stmt.bindNull(10);
          stmt.bindNull(11);
          stmt.bindNull(12);
        }
      }
    };
    this.__deletionAdapterOfNote = new EntityDeletionOrUpdateAdapter<Note>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Note` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Note value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void insert(final Note note) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfNote.insert(note);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Note note) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfNote.handle(note);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Note getByName(final String name) {
    final String _sql = "SELECT * FROM Note WHERE userName = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
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
      final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "userName");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
      final Note _result;
      if(_cursor.moveToFirst()) {
        final User _tmpUser;
        if (! (_cursor.isNull(_cursorIndexOfUserName) && _cursor.isNull(_cursorIndexOfEmail) && _cursor.isNull(_cursorIndexOfPassword) && _cursor.isNull(_cursorIndexOfUserId))) {
          _tmpUser = new User();
          final String _tmpUserName;
          _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
          _tmpUser.setUserName(_tmpUserName);
          final String _tmpEmail;
          _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
          _tmpUser.setEmail(_tmpEmail);
          final String _tmpPassword;
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
          _tmpUser.setPassword(_tmpPassword);
          final long _tmpUserId;
          _tmpUserId = _cursor.getLong(_cursorIndexOfUserId);
          _tmpUser.setUserId(_tmpUserId);
        }  else  {
          _tmpUser = null;
        }
        _result = new Note();
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _result.setName(_tmpName);
        final String _tmpText;
        _tmpText = _cursor.getString(_cursorIndexOfText);
        _result.setText(_tmpText);
        final String _tmpDate;
        _tmpDate = _cursor.getString(_cursorIndexOfDate);
        _result.setDate(_tmpDate);
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
        _result.user = _tmpUser;
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
