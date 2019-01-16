package com.example.gymapi;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.gymapi.Adapter.ExerciseAdapter;
import com.example.gymapi.Model.ExerciseCategory.ExerciseList;
import com.example.gymapi.Model.ExerciseCategory.Result;
import com.example.gymapi.ViewModel.ExerciseViewModel;

import java.util.List;

public class CategoryActivity extends AppCompatActivity {
public static final String TAG = CategoryActivity.class.getSimpleName();
    RecyclerView mRecycler;
    ExerciseAdapter mAdapter;

    ExerciseList exercisesCATList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        mRecycler = findViewById(R.id.cat_recycler);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new GridLayoutManager(this,2));

        ExerciseViewModel model = ViewModelProviders.of(this).get(ExerciseViewModel.class);

        model.getExercises().observe(this, new Observer<ExerciseList>() {
            @Override
            public void onChanged(@Nullable ExerciseList exerciseList) {
                Log.d(TAG, "onChanged: "+ exerciseList.getResults().size());
                exercisesCATList = exerciseList;
                mAdapter = new ExerciseAdapter(CategoryActivity.this, exercisesCATList);
                mRecycler.setAdapter(mAdapter);
            }
        });
    }

}
