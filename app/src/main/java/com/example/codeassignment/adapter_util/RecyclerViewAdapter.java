package com.example.codeassignment.adapter_util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.example.codeassignment.R;
import com.example.codeassignment.data.entity.RepoEntity;
import com.example.codeassignment.databinding.RecyclerviewItemBinding;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private OnSlideListener onSlideListener;

    private List<RepoEntity> mDataSet;


    // Data is passed into the constructor.
    //
    public RecyclerViewAdapter(List<RepoEntity> myDataset, OnSlideListener onSlideListener) {

        this.mDataSet = myDataset;
        this.onSlideListener = onSlideListener;
    }



    // Inflates the cell layout from xml when needed.
    //
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        LayoutInflater inflater= LayoutInflater.from(viewGroup.getContext());

        RecyclerviewItemBinding binding = DataBindingUtil.inflate(
                inflater,
                R.layout.recyclerview_item,
                viewGroup,
                false
        );

        return new MyViewHolder(binding, onSlideListener);
    }



    // Binds the data to the TextView in each cell.
    //
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //String title = mDataSet.get(position);
        RepoEntity repoEntity = mDataSet.get(position);

        holder.bind(repoEntity);
    }



    // Return the size of your dataSet (invoked by the layout manager).
    //
    @Override
    public int getItemCount() {

       if (mDataSet != null) {

            return mDataSet.size();
        }
       else return 0;
    }



    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        RecyclerviewItemBinding binding;

        OnSlideListener onSlideListener;

        public MyViewHolder(RecyclerviewItemBinding binding, OnSlideListener onSlideListener) {

            super(binding.getRoot());

            this.binding = binding;
            this.onSlideListener = onSlideListener;
        }

        public void bind (RepoEntity repoEntity) {

            // Set clickListener to entire background of Container.
            //
            binding.getRoot().setOnClickListener(this);

            binding.name.setOnClickListener(this);

            binding.setRecyclerView(repoEntity);

            this.binding.executePendingBindings();
        }


        @Override
        public void onClick(View view) {

            // Entire background of container Clicked.
            //
            if (view.getId() == binding.getRoot().getId()) {

                onSlideListener.onSlideClick(getAdapterPosition() );
            }
            // Title Clicked.
            //
            else if (view.getId() == binding.name.getId()) {

                onSlideListener.onTitleClick(getAdapterPosition() );
            }

        }
    }


    // Capture user clicks.
    //
    public interface OnSlideListener {

        void onSlideClick(int position);

        void onTitleClick(int position);
    }



}
