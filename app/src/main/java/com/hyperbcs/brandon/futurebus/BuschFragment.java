package com.hyperbcs.brandon.futurebus;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Brandon on 2/7/15.
 */
public class BuschFragment extends Fragment {

    public BuschFragment(){}
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_busch, container, false);
        expListView = (ExpandableListView) rootView.findViewById(R.id.buschList);

        // preparing list data
        AsyncTaskRunner task = new AsyncTaskRunner();
        System.out.println("I GOT HERE");
        //start(task.AsyncTaskRunner());
        start();
        //task.execute();
        return rootView;
    }
    public void start(){
        String[] times;
        times = new String[3];
        times[0] = "1";
        times[1] = "2";
        times[2] = "3";
        System.out.println("I GOT HERE");
        prepareListData();

        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

    }

    public void prepareListData() {
        try {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        //AsyncTaskRunner[] task = new AsyncTaskRunner[6];
        AsyncTaskRunner task1 = new AsyncTaskRunner();
        String[] minute1 = task1.execute("wknd1", "hillw").get();
        AsyncTaskRunner task2 = new AsyncTaskRunner();
            String[] minute2 = task2.execute("wknd1", "science").get();
        AsyncTaskRunner task3 = new AsyncTaskRunner();
            String[] minute3 = task3.execute("wknd1", "buschse").get();
            AsyncTaskRunner task4 = new AsyncTaskRunner();
            String[] minute4 = task4.execute("wknd1", "werblinback").get();
        // Adding child data
        listDataHeader.add("Hill Center");
        listDataHeader.add("Science Building");
        listDataHeader.add("Busch Suites");
            listDataHeader.add("Werblin Back Entrance");

        // Adding child data
            String[] times1;
            times1 = new String[minute1.length];
        List<String> hillw = new ArrayList<String>();
        for (int i = 0;i < times1.length;i++) {
            hillw.add("Weekend 1: "+minute1[i]+" Minutes");
        }

            String[] times2;
            times2 = new String[minute2.length];
        List<String> science = new ArrayList<String>();
        for (int i = 0;i < times2.length;i++) {
            science.add("Weekend 1: "+minute2[i]+" Minutes");
        }

            String[] times3;
            times3 = new String[minute3.length];
        List<String> buschse = new ArrayList<String>();
        for (int i = 0;i < times3.length;i++) {
            buschse.add("Weekend 1: "+minute3[i]+" Minutes");
        }

            String[] times4;
            times4 = new String[minute4.length];
        List<String> werblinback = new ArrayList<String>();
        for (int i = 0;i < times4.length;i++) {
            werblinback.add("Weekend 1: "+minute4[i]+" Minutes");
        }



        listDataChild.put(listDataHeader.get(0), hillw); // Header, Child data
        listDataChild.put(listDataHeader.get(1), science);
            listDataChild.put(listDataHeader.get(2), buschse); // Header, Child data
            listDataChild.put(listDataHeader.get(3), werblinback);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
