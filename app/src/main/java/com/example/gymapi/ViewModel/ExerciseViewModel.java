package com.example.gymapi.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.gymapi.API_Connection.API_Request;
import com.example.gymapi.Model.ExerciseCategory.ExerciseList;
import com.example.gymapi.Model.Workout.Wresult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExerciseViewModel extends ViewModel {
    public static final String TAG = ExerciseViewModel.class.getSimpleName();

    private MutableLiveData<ExerciseList> ExerciseList;

    public LiveData<ExerciseList> getExercises(){

        if (ExerciseList == null){
            ExerciseList = new MutableLiveData<ExerciseList>();
            loadExercises();
        }
        return ExerciseList;
    }

    private void loadExercises(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_Request.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API_Request api = retrofit.create(API_Request.class);
        Call<ExerciseList> call = api.getExercises();

        call.enqueue(new Callback<ExerciseList>() {
            @Override
            public void onResponse(Call<ExerciseList> call, Response<ExerciseList> response) {
                //setting the list to our MutableLiveData
                ExerciseList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ExerciseList> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}
