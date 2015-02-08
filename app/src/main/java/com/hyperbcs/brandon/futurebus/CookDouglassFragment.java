package com.hyperbcs.brandon.futurebus;

/**
 * Created by Brandon on 2/7/15.
 */
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CookDouglassFragment extends Fragment {

    public CookDouglassFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_cookdoug, container, false);

        return rootView;
    }
}