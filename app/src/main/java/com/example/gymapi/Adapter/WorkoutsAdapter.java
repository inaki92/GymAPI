package com.example.gymapi.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gymapi.Model.Workout.Wresult;
import com.example.gymapi.R;

public class WorkoutsAdapter extends RecyclerView.Adapter<WorkoutsAdapter.WorkoutViewHolder> {

    Context mCtx;
    Wresult workoutList;

    public WorkoutsAdapter(Context mCtx, Wresult workoutList){
        this.mCtx = mCtx;
        this.workoutList = workoutList;

    }

    class WorkoutViewHolder extends RecyclerView.ViewHolder{

        TextView routineName;

        public WorkoutViewHolder(@NonNull View itemView) {
            super(itemView);

            routineName = itemView.findViewById(R.id.workout_name);

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
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recycler_workouts,viewGroup,false);
        return new WorkoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutsAdapter.WorkoutViewHolder workoutViewHolder, int i) {
        if(workoutList != null) {
            workoutViewHolder.routineName.setText(workoutList.getResults().get(i).getComment());
        }

    }

    @Override
    public int getItemCount() {
        if(workoutList != null)
            return workoutList.getResults().size();
        else
            return 0;
    }
}
