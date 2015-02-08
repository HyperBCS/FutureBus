package com.hyperbcs.brandon.futurebus;

/**
 * Created by Brandon on 2/7/15.
 */
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CollegeAveFragment extends Fragment {

    public CollegeAveFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_collegeave, container, false);

        return rootView;
    }
}