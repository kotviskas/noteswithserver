package com.dvach.lab2.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0004\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001b\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u001b\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0004\u001a\u00020\u0018H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u001b\u0010\u001a\u001a\u00020\u00172\b\b\u0001\u0010\u0004\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ%\u0010\u001d\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0004\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/dvach/lab2/models/RepoApi;", "", "createCategory", "Lcom/dvach/lab2/pojo/Category;", "form", "Lcom/dvach/lab2/pojo/CategoryForm;", "(Lcom/dvach/lab2/pojo/CategoryForm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createTask", "Lcom/dvach/lab2/pojo/Task;", "Lcom/dvach/lab2/pojo/TaskForm;", "(Lcom/dvach/lab2/pojo/TaskForm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTask", "", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllCategories", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPriorities", "Lcom/dvach/lab2/pojo/Priority;", "getAllTasks", "loginUser", "Lcom/dvach/lab2/pojo/User;", "Lcom/dvach/lab2/pojo/UserLoginForm;", "(Lcom/dvach/lab2/pojo/UserLoginForm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerUser", "Lcom/dvach/lab2/pojo/UserRegistrationForm;", "(Lcom/dvach/lab2/pojo/UserRegistrationForm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTask", "(ILcom/dvach/lab2/pojo/TaskForm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface RepoApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "register")
    public abstract java.lang.Object registerUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.dvach.lab2.pojo.UserRegistrationForm form, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dvach.lab2.pojo.User> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "login")
    public abstract java.lang.Object loginUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.dvach.lab2.pojo.UserLoginForm form, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dvach.lab2.pojo.User> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "categories")
    public abstract java.lang.Object getAllCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dvach.lab2.pojo.Category>> p0);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "priorities")
    public abstract java.lang.Object getAllPriorities(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dvach.lab2.pojo.Priority>> p0);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "tasks")
    public abstract java.lang.Object getAllTasks(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dvach.lab2.pojo.Task>> p0);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "tasks")
    public abstract java.lang.Object createTask(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.dvach.lab2.pojo.TaskForm form, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dvach.lab2.pojo.Task> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "categories")
    public abstract java.lang.Object createCategory(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.dvach.lab2.pojo.CategoryForm form, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dvach.lab2.pojo.Category> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.PATCH(value = "tasks/{id}")
    public abstract java.lang.Object updateTask(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.dvach.lab2.pojo.TaskForm form, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dvach.lab2.pojo.Task> p2);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.DELETE(value = "tasks/{id}")
    public abstract java.lang.Object deleteTask(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
}