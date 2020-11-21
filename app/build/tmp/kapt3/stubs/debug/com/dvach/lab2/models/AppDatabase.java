package com.dvach.lab2.models;

import java.lang.System;

@androidx.room.Database(entities = {com.dvach.lab2.models.User.class, com.dvach.lab2.models.Note.class, com.dvach.lab2.models.Category.class}, version = 1)
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/dvach/lab2/models/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "CategoryDao", "Lcom/dvach/lab2/models/CategoryDao;", "NoteDao", "Lcom/dvach/lab2/models/NoteDao;", "userDao", "Lcom/dvach/lab2/models/UserDao;", "Companion", "app_debug"})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    private static volatile com.dvach.lab2.models.AppDatabase INSTANCE;
    public static final com.dvach.lab2.models.AppDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.dvach.lab2.models.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.dvach.lab2.models.NoteDao NoteDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.dvach.lab2.models.CategoryDao CategoryDao();
    
    public AppDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/dvach/lab2/models/AppDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/dvach/lab2/models/AppDatabase;", "getDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.dvach.lab2.models.AppDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}