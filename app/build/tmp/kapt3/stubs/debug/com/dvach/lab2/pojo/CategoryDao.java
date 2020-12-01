package com.dvach.lab2.pojo;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\'J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\'\u00a8\u0006\f"}, d2 = {"Lcom/dvach/lab2/pojo/CategoryDao;", "", "delete", "", "category", "Lcom/dvach/lab2/pojo/Category;", "getAllNames", "", "getByName", "name", "", "insert", "app_debug"})
public abstract interface CategoryDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM Category WHERE nameCategory = :name")
    public abstract com.dvach.lab2.pojo.Category getByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.Nullable()
    com.dvach.lab2.pojo.Category category);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Category")
    public abstract java.util.List<com.dvach.lab2.pojo.Category> getAllNames();
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.dvach.lab2.pojo.Category category);
}