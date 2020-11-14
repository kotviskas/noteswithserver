package com.dvach.lab2;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\'J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\bH\'J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\'\u00a8\u0006\u000e"}, d2 = {"Lcom/dvach/lab2/UserDao;", "", "getById", "Lcom/dvach/lab2/User;", "id", "", "getUser", "email", "", "password", "getUserByEmail", "insert", "", "user", "app_debug"})
public abstract interface UserDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM User WHERE userId = :id")
    public abstract com.dvach.lab2.User getById(long id);
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.Nullable()
    com.dvach.lab2.User user);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM User WHERE email=:email AND password=:password")
    public abstract com.dvach.lab2.User getUser(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM User WHERE email=:email")
    public abstract com.dvach.lab2.User getUserByEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email);
}