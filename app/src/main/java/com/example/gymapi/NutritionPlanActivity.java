package com.example.gymapi;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.gymapi.Adapter.NutritionAdapter;
import com.example.gymapi.Model.NutritionPlan.NutritionObject;
import com.example.gymapi.ViewModel.NutritionPlanViewModel;

public class NutritionPlanActivity extends AppCompatActivity {

    public static final String TAG = NutritionPlanActivity.class.getSimpleName();

    RecyclerView nutRecycler;
    NutritionAdapter nutAdapter;

    NutritionObject nutritionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        nutRecycler = findViewById(R.id.cat_recycler);
        nutRecycler.setHasFixedSize(true);
        nutRecycler.setLayoutManager(new LinearLayoutManager(this));

        NutritionPlanViewModel model = ViewModelProviders.of(this).get(NutritionPlanViewModel.class);

        model.getNutritionPlans().observe(this, new Observer<NutritionObject>() {
            @Override
            public void onChanged(@Nullable NutritionObject nutritionPlanList) {

                nutritionList = nutritionPlanList;
                Log.d(TAG, "onChanged: "+ nutritionList.getResults().size());

                nutAdapter = new NutritionAdapter(NutritionPlanActivity.this, nutritionList);
                nutRecycler.setAdapter(nutAdapter);
            }
        });
    }
}
