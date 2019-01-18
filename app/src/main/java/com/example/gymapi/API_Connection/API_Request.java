package com.example.gymapi.API_Connection;

import com.example.gymapi.Model.ExerciseCategory.ExerciseList;
import com.example.gymapi.Model.ExerciseCategory.Result;
import com.example.gymapi.Model.NutritionPlan.NutritionObject;
import com.example.gymapi.Model.Workout.Wresult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface API_Request {

    String BASE_URL = "https://wger.de/";
    String Exercises_url = "api/v2/exercisecategory/";
    String Workout_url = "api/v2/workout/";
    String Diets_url = "api/v2/nutritionplan/";

    @GET(Exercises_url)
    Call<ExerciseList> getExercises();

    @Headers("Authorization: Token 3c89a48079cf871cd0afa83d368eef78fca86219")
    @GET(Workout_url)
    Call<Wresult> getWorkouts();

    @Headers("Authorization: Token 3c89a48079cf871cd0afa83d368eef78fca86219")
    @GET(Diets_url)
    Call<NutritionObject> getNutritionPlans();
}
