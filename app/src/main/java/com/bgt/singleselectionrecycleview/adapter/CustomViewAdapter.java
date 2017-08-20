package com.bgt.singleselectionrecycleview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bgt.singleselectionrecycleview.R;
import com.bgt.singleselectionrecycleview.model.CustomViewModel;
import com.bgt.singleselectionrecycleview.view.CustomView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bhavesh on 20-08-2017.
 */

public class CustomViewAdapter extends RecyclerView.Adapter<CustomViewAdapter.MyViewHolder> {

    private Context context;
    private List<CustomViewModel> customViewModels;
    private CustomView lastSelectedCustomView;

    public CustomViewAdapter(Context context, List<CustomViewModel> customViewModels) {
        this.context = context;
        this.customViewModels = customViewModels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_custom_view, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        CustomViewModel customViewModel = customViewModels.get(position);
        holder.customView.setTitleText(customViewModel.getTitle());
        holder.customView.setSelectImage(customViewModel.getSelectedDrawable());
        holder.customView.setUnselectImage(customViewModel.getUnselectedDrawable());
        if (position==0){
            holder.customView.setViewSelected(true);
            lastSelectedCustomView = holder.customView;
        }
        else {
            holder.customView.setViewSelected(false);
        }
    }

    @Override
    public int getItemCount() {
        return customViewModels != null ? customViewModels.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.custom_view)
        CustomView customView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            customView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    lastSelectedCustomView.setViewSelected(false);
                    customView.setViewSelected(true);
                    lastSelectedCustomView = customView;
                }
            });
        }
    }

}
