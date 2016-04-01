package com.example.jenis_000.practical4;

//import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddingSeries extends AppCompatActivity implements EditNameDialogListener {

    TextView mov;
    DBHelper db;
    FragmentTransaction fragmentTransaction;
    Fragment frag;
    Button add_series;
    Button show_series;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_series);
    mov= (TextView)findViewById(R.id.text_add_movies);
        add_series =(Button)findViewById(R.id.add_movie);

        show_series=(Button)findViewById(R.id.show_movie);
        show_series.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Bundle b = new Bundle(this);
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                frag = new SeriesFragment();
                //frag.setArguments(b);
                fragmentTransaction.replace(R.id.linlay, frag);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        add_series.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditDialog();
            }
        });
    }
    public void showEditDialog(){
        //FragmentManager fm = getSupportFragmentManager();
        EditNameDialog editNameDialog = new EditNameDialog();
        editNameDialog.show(getFragmentManager(), "activity_edit_name_dialog");
    }

    public void onFinishEditDialog(String name){
        db = new DBHelper(this);
        db.open();
        db.insertEntry(name);
        db.close();
        finish();
        Toast.makeText(this, "Series Name-" + name +" Added!", Toast.LENGTH_LONG).show();
    }
}
