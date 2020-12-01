package com.dvach.lab2.recyclerAdapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ \u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ \u0010\u0014\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ(\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/dvach/lab2/recyclerAdapter/InputValidation;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "hideKeyboardFrom", "", "view", "Landroid/view/View;", "isEditTextFilled", "", "editText", "Landroid/widget/EditText;", "message", "", "isInputEditTextEmail", "textInputEditText", "Lcom/google/android/material/textfield/TextInputEditText;", "textInputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "isInputEditTextFilled", "isInputEditTextMatches", "textInputEditText1", "textInputEditText2", "isSpinnerFilled", "spinner", "Landroid/widget/Spinner;", "app_debug"})
public final class InputValidation {
    private final android.content.Context context = null;
    
    public final boolean isInputEditTextFilled(@org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputEditText textInputEditText, @org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputLayout textInputLayout, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
        return false;
    }
    
    public final boolean isEditTextFilled(@org.jetbrains.annotations.NotNull()
    android.widget.EditText editText, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
        return false;
    }
    
    public final boolean isInputEditTextEmail(@org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputEditText textInputEditText, @org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputLayout textInputLayout, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
        return false;
    }
    
    public final boolean isInputEditTextMatches(@org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputEditText textInputEditText1, @org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputEditText textInputEditText2, @org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputLayout textInputLayout, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
        return false;
    }
    
    public final boolean isSpinnerFilled(@org.jetbrains.annotations.NotNull()
    android.widget.Spinner spinner, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
        return false;
    }
    
    private final void hideKeyboardFrom(android.view.View view) {
    }
    
    public InputValidation(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}