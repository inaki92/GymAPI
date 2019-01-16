package com.example.gymapi.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.gymapi.API_Connection.API_Request;
import com.example.gymapi.Model.ExerciseCategory.ExerciseList;
import com.example.gymapi.Model.ExerciseCategory.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExerciseViewModel extends ViewModel {

    private MutableLiveData<List<Result>> ExerciseList;

    public LiveData<List<Result>> getExercises(){

        if (ExerciseList == null){
            ExerciseList = new MutableLiveData<List<Result>>();
            loadExercises();
        }
        return ExerciseList;
    }

    private void loadExercises(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_Request.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API_Request api = retrofit.create(API_Request.class);
        Call<List<Result>> call = api.getExercises();

        call.enqueue(new Callback<List<Result>>() {
            @Override
            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                //setting the list to our MutableLiveData
                ExerciseList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Result>> call, Throwable t) {

            }
        });
    }
}
