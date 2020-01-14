package com.example.codeassignment.presentation.mainActivity;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.MutableLiveData;

public class ProgressBarView_Handler extends BaseObservable {


    public MutableLiveData<Boolean> progressBarView_animation = new MutableLiveData<>(false);


    private boolean isProgressBarVisible = true;


    /**
     * Set ProgressBarView visibility.
     *
     * @return The visibility state
     *
     */
    @Bindable
    public boolean getProgressBarVisibility () {

        return isProgressBarVisible;
    }

    public void setProgressBarVisibility (boolean state) {

        isProgressBarVisible = state;

        notifyPropertyChanged(BR.progressBarVisibility);

        // Trigger animation to close View.
        //
        progressBarView_animation.setValue(isProgressBarVisible);

    }
}
