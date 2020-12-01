package com.dvach.lab2.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ%\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ%\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u001b\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u0006\u001a\u00020\u001aH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\u00192\b\b\u0001\u0010\u0006\u001a\u00020\u001dH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ/\u0010\u001f\u001a\u00020\n2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0006\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 \u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/dvach/lab2/models/RepoApi;", "", "createCategory", "Lcom/dvach/lab2/pojo/Category;", "token", "", "form", "Lcom/dvach/lab2/pojo/CategoryForm;", "(Ljava/lang/String;Lcom/dvach/lab2/pojo/CategoryForm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createTask", "Lcom/dvach/lab2/pojo/Task;", "Lcom/dvach/lab2/pojo/TaskForm;", "(Ljava/lang/String;Lcom/dvach/lab2/pojo/TaskForm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTask", "", "id", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllCategories", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPriorities", "Lcom/dvach/lab2/pojo/Priority;", "getAllTasks", "loginUser", "Lcom/dvach/lab2/pojo/User;", "Lcom/dvach/lab2/pojo/UserLoginForm;", "(Lcom/dvach/lab2/pojo/UserLoginForm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerUser", "Lcom/dvach/lab2/pojo/UserRegistrationForm;", "(Lcom/dvach/lab2/pojo/UserRegistrationForm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTask", "(Ljava/lang/String;ILcom/dvach/lab2/pojo/TaskForm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
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
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dvach.lab2.pojo.Category>> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "priorities")
    public abstract java.lang.Object getAllPriorities(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dvach.lab2.pojo.Priority>> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "tasks")
    public abstract java.lang.Object getAllTasks(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dvach.lab2.pojo.Task>> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "tasks")
    public abstract java.lang.Object createTask(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.dvach.lab2.pojo.TaskForm form, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dvach.lab2.pojo.Task> p2);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "categories")
    public abstract java.lang.Object createCategory(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.dvach.lab2.pojo.CategoryForm form, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dvach.lab2.pojo.Category> p2);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.PATCH(value = "task/{id}")
    public abstract java.lang.Object updateTask(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.dvach.lab2.pojo.TaskForm form, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.dvach.lab2.pojo.Task> p3);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.DELETE(value = "tasks/{id}")
    public abstract java.lang.Object deleteTask(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2);
}