package com.example.codeassignment.presentation.viewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.codeassignment.adapter_util.RecyclerViewAdapter;
import com.example.codeassignment.data.entity.RepoEntity;
import com.example.codeassignment.domain.Repository_UseCase;
import com.example.codeassignment.presentation.MyBindingAdapters;
import com.example.codeassignment.presentation.mainActivity.ProgressBarView_Handler;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivityViewModel extends ViewModel implements RecyclerViewAdapter.OnSlideListener{


    private static final String TAG = MainActivityViewModel.class.getName();


    public MutableLiveData<Boolean> viewHolderClicked = new MutableLiveData<>(false);


    private ProgressBarView_Handler progressBarView_handler;


    private Repository_UseCase repository_useCase;

    private Disposable disposable;


    private RecyclerViewAdapter recyclerView_Adapter;

    private List<RepoEntity> dataSet_Array;




    @Inject
    public MainActivityViewModel(Repository_UseCase repository_useCase) {

        // Initialize custom Binding Adapter.
        //
        new MyBindingAdapters();

        // Access the rxJava Repositories Stream.
        //
        this.repository_useCase = repository_useCase;

        // Get instance to handle view's visibility.
        //
        progressBarView_handler = new ProgressBarView_Handler();

        dataSet_Array = new ArrayList<>();

        setRecyclerView();

        loadRepositories();
    }


    /**
     * Provide to UI the ProgressBarView handler.
     *
     * @return The instance of ProgressBarView_Handler
     *
     */
    public ProgressBarView_Handler getProgressBarView_handler () {

        return progressBarView_handler;
    }


    /**
     * Stop background task.
     *
     */
    public void disposeThread () {

        disposable.dispose();
    }


    /**
     * Initialize and provide RecyclerViewAdapter.
     *
     */
    private void setRecyclerView () {

        recyclerView_Adapter = new RecyclerViewAdapter(dataSet_Array, this);
    }

    public RecyclerViewAdapter getRecyclerViewAdapter () {

        return recyclerView_Adapter;
    }


    /**
     * Get all Repositories via asynchronous stream.
     *
     */
    private void loadRepositories () {

        repository_useCase.getRepositories()

                .subscribeOn(Schedulers.io())

                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(new SingleObserver<List<RepoEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                        // Show ProgressBarView.
                        //
                        progressBarView_handler.setProgressBarVisibility(true);

                        disposable = d;

                        Log.i(TAG, "onSubscribe");
                    }

                    @Override
                    public void onSuccess(List<RepoEntity> repoEntities) {

                        dataSet_Array.addAll(repoEntities);

                        recyclerView_Adapter.notifyDataSetChanged();

                        // Hide ProgressBarView.
                        //
                        progressBarView_handler.setProgressBarVisibility(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                        if (e.getMessage() != null) {

                            Log.e(TAG, e.getMessage());
                        }

                    }
                });
    }




    /**
     *  RecyclerViewAdapter Interface
     *
     *  Observe : User Clicks.
     *
     */

    @Override
    public void onSlideClick(int position) {

        viewHolderClicked.setValue(true);
    }

    @Override
    public void onTitleClick(int position) {

        viewHolderClicked.setValue(true);
    }
}
