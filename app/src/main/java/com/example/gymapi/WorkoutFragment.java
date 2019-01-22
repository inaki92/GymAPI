package com.example.gymapi;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gymapi.Adapter.WorkoutsAdapter;
import com.example.gymapi.Model.Workout.Wresult;
import com.example.gymapi.ViewModel.FullViewModel;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WorkoutFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class WorkoutFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public WorkoutFragment() {
        // Required empty public constructor
    }

    RecyclerView msRecycler;
    WorkoutsAdapter msAdapter;

    Wresult workoutsList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View workoutView = inflater.inflate(R.layout.fragment_workout, container, false);

        msRecycler = workoutView.findViewById(R.id.wrokout_recycler);
        msRecycler.setHasFixedSize(true);
        msRecycler.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));

        FullViewModel model = ViewModelProviders.of(this).get(FullViewModel.class);

        model.getWorkouts().observe(this, new Observer<Wresult>() {
            @Override
            public void onChanged(@Nullable Wresult workoutList) {

                workoutsList = workoutList;
                msAdapter = new WorkoutsAdapter(getContext(),workoutsList);
                msRecycler.setAdapter(msAdapter);
            }
        });

        return workoutView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
