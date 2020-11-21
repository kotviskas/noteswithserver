package com.dvach.lab2.models;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\'J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\bH\'J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\'J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\'\u00a8\u0006\u000e"}, d2 = {"Lcom/dvach/lab2/models/CategoryDao;", "", "delete", "", "category", "Lcom/dvach/lab2/models/Category;", "getAllNames", "", "", "getByName", "name", "getCategoriesWithNotes", "Lcom/dvach/lab2/models/CategoryWithNotes;", "insert", "app_debug"})
public abstract interface CategoryDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM Category WHERE categoryName = :name")
    public abstract com.dvach.lab2.models.Category getByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.Nullable()
    com.dvach.lab2.models.Category category);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT categoryName FROM Category")
    public abstract java.util.List<java.lang.String> getAllNames();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Category")
    @androidx.room.Transaction()
    public abstract java.util.List<com.dvach.lab2.models.CategoryWithNotes> getCategoriesWithNotes();
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.dvach.lab2.models.Category category);
}