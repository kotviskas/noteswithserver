package com.dvach.lab2;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;

import com.dvach.lab2.models.Category;
import com.dvach.lab2.models.CategoryDao;
import com.dvach.lab2.models.CategoryWithNotes;
import com.dvach.lab2.models.Note;
import com.dvach.lab2.models.User;

import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        return "INSERT OR REPLACE INTO `Category` (`categoryName`,`userName`,`email`,`password`,`userId`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Category value) {
        if (value.getCategoryName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCategoryName());
        }
        final User _tmpCategoryUser = value.categoryUser;
        if(_tmpCategoryUser != null) {
          if (_tmpCategoryUser.getUserName() == null) {
            stmt.bindNull(2);
          } else {
            stmt.bindString(2, _tmpCategoryUser.getUserName());
          }
          if (_tmpCategoryUser.getEmail() == null) {
            stmt.bindNull(3);
          } else {
            stmt.bindString(3, _tmpCategoryUser.getEmail());
          }
          if (_tmpCategoryUser.getPassword() == null) {
            stmt.bindNull(4);
          } else {
            stmt.bindString(4, _tmpCategoryUser.getPassword());
          }
          stmt.bindLong(5, _tmpCategoryUser.getUserId());
        } else {
          stmt.bindNull(2);
          stmt.bindNull(3);
          stmt.bindNull(4);
          stmt.bindNull(5);
        }
      }
    };
    this.__deletionAdapterOfCategory = new EntityDeletionOrUpdateAdapter<Category>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Category` WHERE `categoryName` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Category value) {
        if (value.getCategoryName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCategoryName());
        }
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
    final String _sql = "SELECT * FROM Category WHERE categoryName = ?";
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
      final int _cursorIndexOfCategoryName = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryName");
      final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "userName");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
      final Category _result;
      if(_cursor.moveToFirst()) {
        final User _tmpCategoryUser;
        if (! (_cursor.isNull(_cursorIndexOfUserName) && _cursor.isNull(_cursorIndexOfEmail) && _cursor.isNull(_cursorIndexOfPassword) && _cursor.isNull(_cursorIndexOfUserId))) {
          _tmpCategoryUser = new User();
          final String _tmpUserName;
          _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
          _tmpCategoryUser.setUserName(_tmpUserName);
          final String _tmpEmail;
          _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
          _tmpCategoryUser.setEmail(_tmpEmail);
          final String _tmpPassword;
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
          _tmpCategoryUser.setPassword(_tmpPassword);
          final long _tmpUserId;
          _tmpUserId = _cursor.getLong(_cursorIndexOfUserId);
          _tmpCategoryUser.setUserId(_tmpUserId);
        }  else  {
          _tmpCategoryUser = null;
        }
        _result = new Category();
        final String _tmpCategoryName;
        _tmpCategoryName = _cursor.getString(_cursorIndexOfCategoryName);
        _result.setCategoryName(_tmpCategoryName);
        _result.categoryUser = _tmpCategoryUser;
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
  public List<String> getAllNames(final long userId) {
    final String _sql = "SELECT categoryName FROM Category WHERE userId =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item;
        _item = _cursor.getString(0);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<CategoryWithNotes> getCategoriesWithNotes(final long userId) {
    final String _sql = "SELECT * FROM Category WHERE userId =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
      try {
        final int _cursorIndexOfCategoryName = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryName");
        final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "userName");
        final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
        final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
        final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
        final ArrayMap<String, ArrayList<Note>> _collectionNotes = new ArrayMap<String, ArrayList<Note>>();
        while (_cursor.moveToNext()) {
          final String _tmpKey = _cursor.getString(_cursorIndexOfCategoryName);
          ArrayList<Note> _tmpNotesCollection = _collectionNotes.get(_tmpKey);
          if (_tmpNotesCollection == null) {
            _tmpNotesCollection = new ArrayList<Note>();
            _collectionNotes.put(_tmpKey, _tmpNotesCollection);
          }
        }
        _cursor.moveToPosition(-1);
        __fetchRelationshipNoteAscomDvachLab2Note(_collectionNotes);
        final List<CategoryWithNotes> _result = new ArrayList<CategoryWithNotes>(_cursor.getCount());
        while(_cursor.moveToNext()) {
          final CategoryWithNotes _item;
          final Category _tmpCategory;
          if (! (_cursor.isNull(_cursorIndexOfCategoryName) && _cursor.isNull(_cursorIndexOfUserName) && _cursor.isNull(_cursorIndexOfEmail) && _cursor.isNull(_cursorIndexOfPassword) && _cursor.isNull(_cursorIndexOfUserId))) {
            final User _tmpCategoryUser;
            if (! (_cursor.isNull(_cursorIndexOfUserName) && _cursor.isNull(_cursorIndexOfEmail) && _cursor.isNull(_cursorIndexOfPassword) && _cursor.isNull(_cursorIndexOfUserId))) {
              _tmpCategoryUser = new User();
              final String _tmpUserName;
              _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
              _tmpCategoryUser.setUserName(_tmpUserName);
              final String _tmpEmail;
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
              _tmpCategoryUser.setEmail(_tmpEmail);
              final String _tmpPassword;
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
              _tmpCategoryUser.setPassword(_tmpPassword);
              final long _tmpUserId;
              _tmpUserId = _cursor.getLong(_cursorIndexOfUserId);
              _tmpCategoryUser.setUserId(_tmpUserId);
            }  else  {
              _tmpCategoryUser = null;
            }
            _tmpCategory = new Category();
            final String _tmpCategoryName;
            _tmpCategoryName = _cursor.getString(_cursorIndexOfCategoryName);
            _tmpCategory.setCategoryName(_tmpCategoryName);
            _tmpCategory.categoryUser = _tmpCategoryUser;
          }  else  {
            _tmpCategory = null;
          }
          ArrayList<Note> _tmpNotesCollection_1 = null;
          final String _tmpKey_1 = _cursor.getString(_cursorIndexOfCategoryName);
          _tmpNotesCollection_1 = _collectionNotes.get(_tmpKey_1);
          if (_tmpNotesCollection_1 == null) {
            _tmpNotesCollection_1 = new ArrayList<Note>();
          }
          _item = new CategoryWithNotes(_tmpCategory,_tmpNotesCollection_1);
          _result.add(_item);
        }
        __db.setTransactionSuccessful();
        return _result;
      } finally {
        _cursor.close();
        _statement.release();
      }
    } finally {
      __db.endTransaction();
    }
  }

  private void __fetchRelationshipNoteAscomDvachLab2Note(final ArrayMap<String, ArrayList<Note>> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      ArrayMap<String, ArrayList<Note>> _tmpInnerMap = new ArrayMap<String, ArrayList<Note>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), _map.valueAt(_mapIndex));
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipNoteAscomDvachLab2Note(_tmpInnerMap);
          _tmpInnerMap = new ArrayMap<String, ArrayList<Note>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipNoteAscomDvachLab2Note(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `name`,`text`,`date`,`category`,`prioritet`,`check`,`color`,`id`,`userName`,`email`,`password`,`userId` FROM `Note` WHERE `category` IN (");
    final int _inputSize = __mapKeySet.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : __mapKeySet) {
      if (_item == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "category");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfName = CursorUtil.getColumnIndex(_cursor, "name");
      final int _cursorIndexOfText = CursorUtil.getColumnIndex(_cursor, "text");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndex(_cursor, "date");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndex(_cursor, "category");
      final int _cursorIndexOfPrioritet = CursorUtil.getColumnIndex(_cursor, "prioritet");
      final int _cursorIndexOfCheck = CursorUtil.getColumnIndex(_cursor, "check");
      final int _cursorIndexOfColor = CursorUtil.getColumnIndex(_cursor, "color");
      final int _cursorIndexOfId = CursorUtil.getColumnIndex(_cursor, "id");
      final int _cursorIndexOfUserName = CursorUtil.getColumnIndex(_cursor, "userName");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndex(_cursor, "email");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndex(_cursor, "password");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndex(_cursor, "userId");
      while(_cursor.moveToNext()) {
        final String _tmpKey = _cursor.getString(_itemKeyIndex);
        ArrayList<Note> _tmpRelation = _map.get(_tmpKey);
        if (_tmpRelation != null) {
          final Note _item_1;
          final User _tmpUser;
          if (! (( _cursorIndexOfUserName == -1 || _cursor.isNull(_cursorIndexOfUserName)) && ( _cursorIndexOfEmail == -1 || _cursor.isNull(_cursorIndexOfEmail)) && ( _cursorIndexOfPassword == -1 || _cursor.isNull(_cursorIndexOfPassword)) && ( _cursorIndexOfUserId == -1 || _cursor.isNull(_cursorIndexOfUserId)))) {
            _tmpUser = new User();
            if (_cursorIndexOfUserName != -1) {
              final String _tmpUserName;
              _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
              _tmpUser.setUserName(_tmpUserName);
            }
            if (_cursorIndexOfEmail != -1) {
              final String _tmpEmail;
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
              _tmpUser.setEmail(_tmpEmail);
            }
            if (_cursorIndexOfPassword != -1) {
              final String _tmpPassword;
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
              _tmpUser.setPassword(_tmpPassword);
            }
            if (_cursorIndexOfUserId != -1) {
              final long _tmpUserId;
              _tmpUserId = _cursor.getLong(_cursorIndexOfUserId);
              _tmpUser.setUserId(_tmpUserId);
            }
          }  else  {
            _tmpUser = null;
          }
          _item_1 = new Note();
          if (_cursorIndexOfName != -1) {
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item_1.setName(_tmpName);
          }
          if (_cursorIndexOfText != -1) {
            final String _tmpText;
            _tmpText = _cursor.getString(_cursorIndexOfText);
            _item_1.setText(_tmpText);
          }
          if (_cursorIndexOfDate != -1) {
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item_1.setDate(_tmpDate);
          }
          if (_cursorIndexOfCategory != -1) {
            final String _tmpCategory;
            _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            _item_1.setCategory(_tmpCategory);
          }
          if (_cursorIndexOfPrioritet != -1) {
            final String _tmpPrioritet;
            _tmpPrioritet = _cursor.getString(_cursorIndexOfPrioritet);
            _item_1.setPrioritet(_tmpPrioritet);
          }
          if (_cursorIndexOfCheck != -1) {
            final boolean _tmpCheck;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfCheck);
            _tmpCheck = _tmp != 0;
            _item_1.setCheck(_tmpCheck);
          }
          if (_cursorIndexOfColor != -1) {
            final int _tmpColor;
            _tmpColor = _cursor.getInt(_cursorIndexOfColor);
            _item_1.setColor(_tmpColor);
          }
          if (_cursorIndexOfId != -1) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            _item_1.setId(_tmpId);
          }
          _item_1.user = _tmpUser;
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
