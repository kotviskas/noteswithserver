package com.dvach.lab2;

import java.lang.System;

@androidx.room.Entity()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/dvach/lab2/Category;", "", "()V", "categoryName", "", "getCategoryName", "()Ljava/lang/String;", "setCategoryName", "(Ljava/lang/String;)V", "categoryUser", "Lcom/dvach/lab2/User;", "getCategoryUser", "()Lcom/dvach/lab2/User;", "setCategoryUser", "(Lcom/dvach/lab2/User;)V", "app_debug"})
public final class Category {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.PrimaryKey()
    private java.lang.String categoryName = "";
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Embedded()
    public com.dvach.lab2.User categoryUser;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCategoryName() {
        return null;
    }
    
    public final void setCategoryName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dvach.lab2.User getCategoryUser() {
        return null;
    }
    
    public final void setCategoryUser(@org.jetbrains.annotations.NotNull()
    com.dvach.lab2.User p0) {
    }
    
    public Category() {
        super();
    }
}