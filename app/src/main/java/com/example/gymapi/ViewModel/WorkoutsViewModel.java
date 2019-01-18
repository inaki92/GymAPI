package com.example.gymapi.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.gymapi.API_Connection.API_Request;
import com.example.gymapi.Model.Workout.Wresult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WorkoutsViewModel extends ViewModel {

    public static final String TAG = WorkoutsViewModel.class.getSimpleName();

    private MutableLiveData<Wresult> WorkoutsList;

    public LiveData<Wresult> getWorkouts(){

        if (WorkoutsList == null){
            WorkoutsList = new MutableLiveData<Wresult>();
            loadWorkouts();
        }
        return WorkoutsList;
    }

    private void loadWorkouts(){

        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_Request.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API_Request workoutsAPI = retrofit.create(API_Request.class);
        Call<Wresult> callWorkout = workoutsAPI.getWorkouts();

        callWorkout.enqueue(new Callback<Wresult>() {
            @Override
            public void onResponse(Call<Wresult> call, Response<Wresult> response) {
                //setting the list to our MutableLiveData
                WorkoutsList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Wresult> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}
