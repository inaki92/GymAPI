package com.example.gymapi.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gymapi.Model.ExerciseCategory.ExerciseList;
import com.example.gymapi.R;

import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder> {

    private static final String TAG = ExerciseAdapter.class.getSimpleName();

    Context mCtx;
    List<ExerciseList> ExerciseList;

    public ExerciseAdapter(Context mCtx, List<ExerciseList> excersiseList){
        this.mCtx = mCtx;
        this.ExerciseList = excersiseList;

    }

    class ExerciseViewHolder extends RecyclerView.ViewHolder{

        TextView muscleName;

        public ExerciseViewHolder(@NonNull View itemView) {
            super(itemView);

            muscleName = itemView.findViewById(R.id.muscle_name);

            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mCtx,BioActivity.class);
                    intent.putExtra("bio",heroBio);
                    intent.putExtra("realname",heroRealName);
                    mCtx.startActivity(intent);
                }
            });*/
        }
    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recycler_exercises_category,viewGroup,false);
        Log.d(TAG, "onCreate: inflate");
        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseAdapter.ExerciseViewHolder exerciseViewHolder, int i) {
        final ExerciseList exersise =ExerciseList.get(i);

        exerciseViewHolder.muscleName.setText(ExerciseList.get(i).getResults().get(i).getName());
        Log.d(TAG, "onCreate: holder");
    }

    @Override
    public int getItemCount() {
        return ExerciseList.size();
    }
}
