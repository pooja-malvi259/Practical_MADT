package com.example.jenis_000.practical4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Jenis_000 on 3/11/2016.
 */
public class SeriesFragment extends Fragment {
    View rootView;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String[] S_name;
    ContextMenu menu;
    int[] img_res={R.drawable.arrow,R.drawable.breakingbad,R.drawable.got,R.drawable.metalist,
            R.drawable.quantico,R.drawable.sherlock,R.drawable.onetreehill,R.drawable.prisonbreak,R.drawable.vampirediaris};
    ArrayList<DataProvider> arrayList=new ArrayList<DataProvider>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.series,container,false);
        S_name=getResources().getStringArray(R.array.series_names);

        int i=0;
        for(String name: S_name){
            DataProvider dataProvider=new DataProvider(img_res[i],name);
            arrayList.add(dataProvider);
            i++;
        } recyclerView=(RecyclerView)rootView.findViewById(R.id.seriesView);
        adapter=new RecyclerAdapter(arrayList);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        registerForContextMenu(recyclerView);

        return rootView;
    }

}

