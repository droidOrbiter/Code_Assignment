package com.example.codeassignment.presentation.view;

import androidx.appcompat.app.ActionBar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;


import com.example.codeassignment.R;
import com.example.codeassignment.databinding.ActivityMainBinding;
import com.example.codeassignment.presentation.viewModel.MainActivityViewModel;
import com.example.codeassignment.presentation.viewModel.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;


public class MainActivity extends DaggerAppCompatActivity {


    @Inject
    ViewModelProviderFactory providerFactory;

    private MainActivityViewModel viewModel;

    private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Display custom action menu title layout.
        //
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.menu_title_activity_main);
        }

        // Set ViewModel.
        //
        viewModel =
                ViewModelProviders.of(this, providerFactory).get(MainActivityViewModel.class);

        // Set DataBinding.
        //
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Initialize RecycleView.
        //
        RecyclerView recyclerView = binding.listRecycler;

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(viewModel.getRecyclerViewAdapter());

        binding.setViewModel(viewModel);


        // Observe ProgressBarView visibility stage to trigger animation.
        //
        viewModel.getProgressBarView_handler().progressBarView_animation.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isVisible) {

                setProgressBar_animation(isVisible);
            }
        });


        // Observe RecyclerView clicks.
        //
        viewModel.viewHolderClicked.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

                if (aBoolean) {
                    Toast.makeText(MainActivity.this,
                            getResources().getString(R.string.MainActivity_RecyclerView_Clicked), Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    /**
     * Handle ProgressBarView animation on Gone.
     *
     */
    private void setProgressBar_animation(boolean isVisible) {

        // HIDE ProgressBarView and TextView.
        //
        if (isVisible) {

            Animation progressBarView  = AnimationUtils.loadAnimation(this, R.anim.progressbar_gone);

            binding.mainActivityProgressBar.startAnimation(progressBarView);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        viewModel.disposeThread();
    }

}
