package com.dvach.lab2;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020&2\u0006\u0010\'\u001a\u00020(H\u0016J\u0012\u0010*\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020&H\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006."}, d2 = {"Lcom/dvach/lab2/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/dvach/lab2/adapter/RecyclerAdapter$onItemClick;", "Lcom/dvach/lab2/adapter/RecyclerAdapter$onCheck;", "()V", "adapter", "Lcom/dvach/lab2/adapter/RecyclerAdapter;", "getAdapter", "()Lcom/dvach/lab2/adapter/RecyclerAdapter;", "setAdapter", "(Lcom/dvach/lab2/adapter/RecyclerAdapter;)V", "flag", "", "getFlag", "()Z", "setFlag", "(Z)V", "items", "Ljava/util/ArrayList;", "Lcom/dvach/lab2/models/Item;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "sPref", "Landroid/content/SharedPreferences;", "getSPref", "()Landroid/content/SharedPreferences;", "setSPref", "(Landroid/content/SharedPreferences;)V", "user", "Lcom/dvach/lab2/models/User;", "getUser", "()Lcom/dvach/lab2/models/User;", "setUser", "(Lcom/dvach/lab2/models/User;)V", "changeCheck", "", "note", "Lcom/dvach/lab2/models/Note;", "noteClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements com.dvach.lab2.adapter.RecyclerAdapter.onItemClick, com.dvach.lab2.adapter.RecyclerAdapter.onCheck {
    @org.jetbrains.annotations.NotNull()
    public android.content.SharedPreferences sPref;
    @org.jetbrains.annotations.NotNull()
    public com.dvach.lab2.models.User user;
    private boolean flag = false;
    @org.jetbrains.annotations.NotNull()
    public java.util.ArrayList<com.dvach.lab2.models.Item> items;
    @org.jetbrains.annotations.NotNull()
    public com.dvach.lab2.adapter.RecyclerAdapter adapter;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getSPref() {
        return null;
    }
    
    public final void setSPref(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dvach.lab2.models.User getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.NotNull()
    com.dvach.lab2.models.User p0) {
    }
    
    public final boolean getFlag() {
        return false;
    }
    
    public final void setFlag(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.dvach.lab2.models.Item> getItems() {
        return null;
    }
    
    public final void setItems(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.dvach.lab2.models.Item> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dvach.lab2.adapter.RecyclerAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.dvach.lab2.adapter.RecyclerAdapter p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    public void noteClick(@org.jetbrains.annotations.NotNull()
    com.dvach.lab2.models.Note note) {
    }
    
    @java.lang.Override()
    public void changeCheck(@org.jetbrains.annotations.NotNull()
    com.dvach.lab2.models.Note note) {
    }
    
    public MainActivity() {
        super();
    }
}