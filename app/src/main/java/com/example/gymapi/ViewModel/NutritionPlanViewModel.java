package com.example.gymapi.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.gymapi.API_Connection.API_Request;
import com.example.gymapi.Model.ExerciseCategory.ExerciseList;
import com.example.gymapi.Model.NutritionPlan.NutritionObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NutritionPlanViewModel extends ViewModel {

    public static final String TAG = NutritionPlanViewModel.class.getSimpleName();

    private MutableLiveData<NutritionObject> DietList;

    public LiveData<NutritionObject> getNutritionPlans(){

        if (DietList == null){
            DietList = new MutableLiveData<NutritionObject>();
            loadPlans();
        }
        return DietList;
    }

    private void loadPlans(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_Request.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API_Request nutritionAPI = retrofit.create(API_Request.class);
        Call<NutritionObject> call = nutritionAPI.getNutritionPlans();

        call.enqueue(new Callback<NutritionObject>() {
            @Override
            public void onResponse(Call<NutritionObject> call, Response<NutritionObject> response) {
                //setting the list to our MutableLiveData
                DietList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<NutritionObject> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}
