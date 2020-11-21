package com.dvach.lab2;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020 H\u0016J\u001a\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006/"}, d2 = {"Lcom/dvach/lab2/HomeFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/dvach/lab2/adapter/RecyclerAdapter$onItemClick;", "Lcom/dvach/lab2/adapter/RecyclerAdapter$onCheck;", "()V", "adapter", "Lcom/dvach/lab2/adapter/RecyclerAdapter;", "getAdapter", "()Lcom/dvach/lab2/adapter/RecyclerAdapter;", "setAdapter", "(Lcom/dvach/lab2/adapter/RecyclerAdapter;)V", "flag", "", "getFlag", "()Z", "setFlag", "(Z)V", "items", "Ljava/util/ArrayList;", "Lcom/dvach/lab2/models/Item;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "sPref", "Landroid/content/SharedPreferences;", "getSPref", "()Landroid/content/SharedPreferences;", "setSPref", "(Landroid/content/SharedPreferences;)V", "changeCheck", "", "note", "Lcom/dvach/lab2/models/Note;", "noteClick", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment implements com.dvach.lab2.adapter.RecyclerAdapter.onItemClick, com.dvach.lab2.adapter.RecyclerAdapter.onCheck {
    @org.jetbrains.annotations.NotNull()
    public android.content.SharedPreferences sPref;
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
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void noteClick(@org.jetbrains.annotations.NotNull()
    com.dvach.lab2.models.Note note) {
    }
    
    @java.lang.Override()
    public void changeCheck(@org.jetbrains.annotations.NotNull()
    com.dvach.lab2.models.Note note) {
    }
    
    public HomeFragment() {
        super();
    }
}