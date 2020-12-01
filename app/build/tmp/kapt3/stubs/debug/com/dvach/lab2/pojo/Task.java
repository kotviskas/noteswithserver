package com.dvach.lab2.pojo;

import java.lang.System;

@androidx.room.Entity()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u000fJ\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0006H\u00c6\u0003J\t\u0010+\u001a\u00020\bH\u00c6\u0003J\t\u0010,\u001a\u00020\nH\u00c6\u0003J\t\u0010-\u001a\u00020\fH\u00c6\u0003J\t\u0010.\u001a\u00020\u0006H\u00c6\u0003J\t\u0010/\u001a\u00020\u0006H\u00c6\u0003JY\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u00c6\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u00d6\u0003J\t\u00105\u001a\u00020\u0006H\u00d6\u0001J\t\u00106\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010 R\u0016\u0010\u000e\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b\'\u0010\u001d\u00a8\u00067"}, d2 = {"Lcom/dvach/lab2/pojo/Task;", "Ljava/io/Serializable;", "title", "", "description", "done", "", "deadline", "", "category", "Lcom/dvach/lab2/pojo/Category;", "priority", "Lcom/dvach/lab2/pojo/Priority;", "created", "id", "(Ljava/lang/String;Ljava/lang/String;IJLcom/dvach/lab2/pojo/Category;Lcom/dvach/lab2/pojo/Priority;II)V", "getCategory", "()Lcom/dvach/lab2/pojo/Category;", "setCategory", "(Lcom/dvach/lab2/pojo/Category;)V", "getCreated", "()I", "getDeadline", "()J", "setDeadline", "(J)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getDone", "setDone", "(I)V", "getId", "getPriority", "()Lcom/dvach/lab2/pojo/Priority;", "setPriority", "(Lcom/dvach/lab2/pojo/Priority;)V", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toString", "app_debug"})
public final class Task implements java.io.Serializable {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String title;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String description;
    private int done;
    private long deadline;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Embedded()
    private com.dvach.lab2.pojo.Category category;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Embedded()
    private com.dvach.lab2.pojo.Priority priority;
    private final int created = 0;
    @androidx.room.PrimaryKey()
    private final int id = 0;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getDone() {
        return 0;
    }
    
    public final void setDone(int p0) {
    }
    
    public final long getDeadline() {
        return 0L;
    }
    
    public final void setDeadline(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dvach.lab2.pojo.Category getCategory() {
        return null;
    }
    
    public final void setCategory(@org.jetbrains.annotations.NotNull()
    com.dvach.lab2.pojo.Category p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dvach.lab2.pojo.Priority getPriority() {
        return null;
    }
    
    public final void setPriority(@org.jetbrains.annotations.NotNull()
    com.dvach.lab2.pojo.Priority p0) {
    }
    
    public final int getCreated() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    public Task(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, int done, long deadline, @org.jetbrains.annotations.NotNull()
    com.dvach.lab2.pojo.Category category, @org.jetbrains.annotations.NotNull()
    com.dvach.lab2.pojo.Priority priority, int created, int id) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final long component4() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dvach.lab2.pojo.Category component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dvach.lab2.pojo.Priority component6() {
        return null;
    }
    
    public final int component7() {
        return 0;
    }
    
    public final int component8() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dvach.lab2.pojo.Task copy(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, int done, long deadline, @org.jetbrains.annotations.NotNull()
    com.dvach.lab2.pojo.Category category, @org.jetbrains.annotations.NotNull()
    com.dvach.lab2.pojo.Priority priority, int created, int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}