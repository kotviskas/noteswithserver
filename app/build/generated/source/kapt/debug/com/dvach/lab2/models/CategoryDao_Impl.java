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
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CategoryDao_Impl implements CategoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Category> __insertionAdapterOfCategory;

  private final EntityDeletionOrUpdateAdapter<Category> __deletionAdapterOfCategory;

  public CategoryDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCategory = new EntityInsertionAdapter<Category>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Category` (`nameCategory`,`idCategory`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Category value) {
        if (value.getNameCategory() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNameCategory());
        }
        stmt.bindLong(2, value.getIdCategory());
      }
    };
    this.__deletionAdapterOfCategory = new EntityDeletionOrUpdateAdapter<Category>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Category` WHERE `idCategory` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Category value) {
        stmt.bindLong(1, value.getIdCategory());
      }
    };
  }

  @Override
  public void insert(final Category category) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCategory.insert(category);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Category category) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCategory.handle(category);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Category getByName(final String name) {
    final String _sql = "SELECT * FROM Category WHERE nameCategory = ?";
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
      final int _cursorIndexOfNameCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "nameCategory");
      final int _cursorIndexOfIdCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "idCategory");
      final Category _result;
      if(_cursor.moveToFirst()) {
        final String _tmpNameCategory;
        _tmpNameCategory = _cursor.getString(_cursorIndexOfNameCategory);
        final int _tmpIdCategory;
        _tmpIdCategory = _cursor.getInt(_cursorIndexOfIdCategory);
        _result = new Category(_tmpNameCategory,_tmpIdCategory);
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
  public List<Category> getAllNames() {
    final String _sql = "SELECT * FROM Category";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfNameCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "nameCategory");
      final int _cursorIndexOfIdCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "idCategory");
      final List<Category> _result = new ArrayList<Category>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Category _item;
        final String _tmpNameCategory;
        _tmpNameCategory = _cursor.getString(_cursorIndexOfNameCategory);
        final int _tmpIdCategory;
        _tmpIdCategory = _cursor.getInt(_cursorIndexOfIdCategory);
        _item = new Category(_tmpNameCategory,_tmpIdCategory);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
