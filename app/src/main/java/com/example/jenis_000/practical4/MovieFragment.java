package com.example.jenis_000.practical4;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jenis_000 on 3/11/2016.
 */
public class MovieFragment extends Fragment implements AdapterView.OnItemClickListener{
    View rootView;
    private ArrayList<String> myList;
    private ArrayList<Integer> idList;
    ListAdapter la;
    ListView lv;
    DBHelper dhelper;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.movies,container,false);
        myList = new ArrayList<String>();
        idList = new ArrayList<Integer>();
        dhelper = new DBHelper(rootView.getContext());
        dhelper.open();
        Cursor c = dhelper.getAllEntries();
        c.moveToFirst();
        for (int i =0; i<c.getCount();i++)
        {
            idList.add(c.getInt(0));
            myList.add(c.getString(1));
            c.moveToNext();
        }
        c.close();
        la = new ArrayAdapter<>(rootView.getContext(),android.R.layout.simple_expandable_list_item_1,myList);
        lv.setAdapter(la);
        lv.setOnItemClickListener(this);
        return rootView;
    }

        @Override
        public void onResume() {
        super.onResume();
        dhelper = new DBHelper(rootView.getContext());
        dhelper.open();
        idList.clear();
        myList.clear();
        Cursor c1 = dhelper.getAllEntries();
        c1.moveToFirst();
        for (int i =0; i<c1.getCount();i++)
        {
            idList.add(c1.getInt(0));
            myList.add(c1.getString(1));
            c1.moveToNext();
        }
        lv = (ListView)rootView.findViewById(R.id.listView);
        dhelper.close();
        la = new ArrayAdapter<>(rootView.getContext(),android.R.layout.simple_expandable_list_item_1,myList);
        lv.setAdapter(la);
        lv.setOnItemClickListener(this);
    }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        final int indexvalue = idList.get(i);
        dhelper = new DBHelper(rootView.getContext());
        dhelper.open();
        AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
        dialog.setTitle("Delete");
        dialog.setMessage("Do you want to delete "+ myList.get(i) + " " + indexvalue);
        dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                boolean result = dhelper.removeEntry(indexvalue);
                dhelper.close();
                onResume();
            }
        });

        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onResume();
            }
        });

        dialog.create();
        dialog.show();

    }
}

