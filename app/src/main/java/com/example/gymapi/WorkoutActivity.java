package com.example.gymapi;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.gymapi.Adapter.WorkoutsAdapter;
import com.example.gymapi.Model.Workout.Wresult;
import com.example.gymapi.ViewModel.WorkoutsViewModel;

public class WorkoutActivity extends AppCompatActivity {
    public static final String TAG = WorkoutActivity.class.getSimpleName();

    RecyclerView msRecycler;
    WorkoutsAdapter msAdapter;

    Wresult workoutsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);

        msRecycler = findViewById(R.id.wrokout_recycler);
        msRecycler.setHasFixedSize(true);
        msRecycler.setLayoutManager(new LinearLayoutManager(this));

        WorkoutsViewModel model = ViewModelProviders.of(this).get(WorkoutsViewModel.class);

        model.getWorkouts().observe(this, new Observer<Wresult>() {
            @Override
            public void onChanged(@Nullable Wresult workoutList) {
                workoutsList = workoutList;
                Log.d(TAG, "onChanged: "+ workoutsList.getResults().size());
                msAdapter = new WorkoutsAdapter(WorkoutActivity.this,workoutsList);
                msRecycler.setAdapter(msAdapter);
            }
        });
    }

}
