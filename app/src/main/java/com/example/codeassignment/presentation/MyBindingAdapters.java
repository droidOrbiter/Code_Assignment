package com.example.codeassignment.presentation;

import android.view.View;

import androidx.databinding.BindingAdapter;

public class MyBindingAdapters {


    /**
     * View visibility.
     *
     * @param view Actual View.
     *
     * @param visible The visibility state
     *
     */
    @BindingAdapter("android:visibility")
    public static void setVisibility(View view, Boolean visible){

        view.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
    }

}
