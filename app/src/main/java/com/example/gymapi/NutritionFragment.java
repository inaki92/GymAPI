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

import com.example.gymapi.Adapter.NutritionAdapter;
import com.example.gymapi.Model.NutritionPlan.NutritionObject;
import com.example.gymapi.ViewModel.FullViewModel;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NutritionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class NutritionFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    RecyclerView nutRecycler;
    NutritionAdapter nutAdapter;

    NutritionObject nutritionList;

    public NutritionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View nutView = inflater.inflate(R.layout.fragment_nutrition, container, false);

        nutRecycler = nutView.findViewById(R.id.nutrition_recycler);
        nutRecycler.setHasFixedSize(true);
        nutRecycler.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));

        FullViewModel model = ViewModelProviders.of(this).get(FullViewModel.class);

        model.getNutritionPlans().observe(this, new Observer<NutritionObject>() {
            @Override
            public void onChanged(@Nullable NutritionObject nutritionPlanList) {

                nutritionList = nutritionPlanList;
                nutAdapter = new NutritionAdapter(getContext(), nutritionList);
                nutRecycler.setAdapter(nutAdapter);
            }
        });

        return nutView;
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
