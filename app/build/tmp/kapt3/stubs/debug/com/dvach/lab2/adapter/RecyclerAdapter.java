package com.dvach.lab2.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004$%&\'B-\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001bH\u0016R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006("}, d2 = {"Lcom/dvach/lab2/adapter/RecyclerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "listItems", "Ljava/util/ArrayList;", "Lcom/dvach/lab2/models/Item;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/dvach/lab2/adapter/RecyclerAdapter$onItemClick;", "listener2", "Lcom/dvach/lab2/adapter/RecyclerAdapter$onCheck;", "(Ljava/util/ArrayList;Lcom/dvach/lab2/adapter/RecyclerAdapter$onItemClick;Lcom/dvach/lab2/adapter/RecyclerAdapter$onCheck;)V", "getListItems", "()Ljava/util/ArrayList;", "setListItems", "(Ljava/util/ArrayList;)V", "getListener", "()Lcom/dvach/lab2/adapter/RecyclerAdapter$onItemClick;", "setListener", "(Lcom/dvach/lab2/adapter/RecyclerAdapter$onItemClick;)V", "getListener2", "()Lcom/dvach/lab2/adapter/RecyclerAdapter$onCheck;", "setListener2", "(Lcom/dvach/lab2/adapter/RecyclerAdapter$onCheck;)V", "deleteItem", "", "position", "", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "HeadViewHolder", "NoteViewHolder", "onCheck", "onItemClick", "app_debug"})
public final class RecyclerAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.dvach.lab2.models.Item> listItems;
    @org.jetbrains.annotations.NotNull()
    private com.dvach.lab2.adapter.RecyclerAdapter.onItemClick listener;
    @org.jetbrains.annotations.NotNull()
    private com.dvach.lab2.adapter.RecyclerAdapter.onCheck listener2;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void deleteItem(int position) {
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.dvach.lab2.models.Item> getListItems() {
        return null;
    }
    
    public final void setListItems(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.dvach.lab2.models.Item> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dvach.lab2.adapter.RecyclerAdapter.onItemClick getListener() {
        return null;
    }
    
    public final void setListener(@org.jetbrains.annotations.NotNull()
    com.dvach.lab2.adapter.RecyclerAdapter.onItemClick p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dvach.lab2.adapter.RecyclerAdapter.onCheck getListener2() {
        return null;
    }
    
    public final void setListener2(@org.jetbrains.annotations.NotNull()
    com.dvach.lab2.adapter.RecyclerAdapter.onCheck p0) {
    }
    
    public RecyclerAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.dvach.lab2.models.Item> listItems, @org.jetbrains.annotations.NotNull()
    com.dvach.lab2.adapter.RecyclerAdapter.onItemClick listener, @org.jetbrains.annotations.NotNull()
    com.dvach.lab2.adapter.RecyclerAdapter.onCheck listener2) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/dvach/lab2/adapter/RecyclerAdapter$onItemClick;", "", "noteClick", "", "note", "Lcom/dvach/lab2/Note;", "app_debug"})
    public static abstract interface onItemClick {
        
        public abstract void noteClick(@org.jetbrains.annotations.NotNull()
        com.dvach.lab2.Note note);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/dvach/lab2/adapter/RecyclerAdapter$onCheck;", "", "changeCheck", "", "note", "Lcom/dvach/lab2/Note;", "app_debug"})
    public static abstract interface onCheck {
        
        public abstract void changeCheck(@org.jetbrains.annotations.NotNull()
        com.dvach.lab2.Note note);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\"\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/dvach/lab2/adapter/RecyclerAdapter$NoteViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "headText", "Landroid/widget/TextView;", "getHeadText", "()Landroid/widget/TextView;", "setHeadText", "(Landroid/widget/TextView;)V", "textText", "getTextText", "setTextText", "SetNote", "", "note", "Lcom/dvach/lab2/Note;", "app_debug"})
    public static final class NoteViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private android.widget.TextView headText;
        private android.widget.TextView textText;
        private android.widget.CheckBox checkBox;
        
        public final android.widget.TextView getHeadText() {
            return null;
        }
        
        public final void setHeadText(android.widget.TextView p0) {
        }
        
        public final android.widget.TextView getTextText() {
            return null;
        }
        
        public final void setTextText(android.widget.TextView p0) {
        }
        
        public final android.widget.CheckBox getCheckBox() {
            return null;
        }
        
        public final void setCheckBox(android.widget.CheckBox p0) {
        }
        
        public final void SetNote(@org.jetbrains.annotations.NotNull()
        com.dvach.lab2.Note note) {
        }
        
        public NoteViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\"\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/dvach/lab2/adapter/RecyclerAdapter$HeadViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "headText", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getHeadText", "()Landroid/widget/TextView;", "setHeadText", "(Landroid/widget/TextView;)V", "SetText", "", "category", "Lcom/dvach/lab2/Category;", "app_debug"})
    public static final class HeadViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private android.widget.TextView headText;
        
        public final android.widget.TextView getHeadText() {
            return null;
        }
        
        public final void setHeadText(android.widget.TextView p0) {
        }
        
        public final void SetText(@org.jetbrains.annotations.NotNull()
        com.dvach.lab2.Category category) {
        }
        
        public HeadViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}