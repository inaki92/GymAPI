package com.example.gymapi;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.gymapi.Adapter.WorkoutsAdapter;
import com.example.gymapi.Model.Workout.Wresult;
import com.example.gymapi.ViewModel.ExerciseViewModel;

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

        ExerciseViewModel Wmodel = ViewModelProviders.of(this).get(ExerciseViewModel.class);

        Wmodel.getWorkouts().observe(this, new Observer<Wresult>() {
            @Override
            public void onChanged(@Nullable Wresult WorkoutsList) {
                Log.d(TAG, "onChangelkd: "+ workoutsList.getResults().size());
                workoutsList = WorkoutsList;
                msAdapter = new WorkoutsAdapter(WorkoutActivity.this,workoutsList);
                msRecycler.setAdapter(msAdapter);
            }
        });
    }

}
