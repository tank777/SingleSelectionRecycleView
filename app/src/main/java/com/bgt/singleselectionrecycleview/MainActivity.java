package com.bgt.singleselectionrecycleview;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bgt.singleselectionrecycleview.adapter.CustomViewAdapter;
import com.bgt.singleselectionrecycleview.model.CustomViewModel;
import com.bgt.singleselectionrecycleview.view.CustomView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    CustomViewAdapter customViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,3);
        recycleView.setLayoutManager(gridLayoutManager);
        List<CustomViewModel> customViewModels = new ArrayList<>();
        customViewModels.add(new CustomViewModel("Camera", ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_action_camera), ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_action_select_camera)));
        customViewModels.add(new CustomViewModel("Gallery", ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_action_gallery), ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_action_selected_gallery)));
        customViewModels.add(new CustomViewModel("Emoji", ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_action_emoji), ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_action_selected_emoji)));
        customViewAdapter = new CustomViewAdapter(getApplicationContext(),customViewModels);
        recycleView.setAdapter(customViewAdapter);
    }
}
