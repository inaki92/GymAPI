package com.example.gymapi.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gymapi.Model.NutritionPlan.NutritionObject;
import com.example.gymapi.R;

public class NutritionAdapter extends RecyclerView.Adapter<NutritionAdapter.DietViewHolder> {

    private static final String TAG = NutritionAdapter.class.getSimpleName();

    Context mCtx;
    NutritionObject nutritionObject;

    public NutritionAdapter(Context mCtx, NutritionObject nutritionList){
        this.mCtx = mCtx;
        this.nutritionObject = nutritionList;

    }

    class DietViewHolder extends RecyclerView.ViewHolder{

        TextView planName;

        public DietViewHolder(@NonNull View itemView) {
            super(itemView);

            planName = itemView.findViewById(R.id.workout_name);
        }
    }

    @NonNull
    @Override
    public DietViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recycler_workouts,viewGroup,false);
        Log.d(TAG, "onCreate: inflate");
        return new DietViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DietViewHolder dietViewHolder, int i) {

        dietViewHolder.planName.setText(nutritionObject.getResults().get(i).getDescription());
        Log.d(TAG, "onCreate: holder dietplan "+nutritionObject.getResults().get(i).getDescription());

    }

    @Override
    public int getItemCount() {
        return nutritionObject.getResults().size();
    }
}
