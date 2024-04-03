package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView p1, l1;
    Spinner spin;
    Button remove;

    boolean removeElements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");

        p1 = findViewById(R.id.textView2);
        l1 = findViewById(R.id.textView);
        remove = findViewById(R.id.button);
        spin = findViewById(R.id.spinner);

        Log.d("tag", getResources().getConfiguration().orientation + "");

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "You are in Portrait Mode", Toast.LENGTH_SHORT);
            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    spin.setAdapter(null);
                    removeElements = true;
                }
            });

            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
            spin.setAdapter(spinnerAdapter);

            spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    p1.setText(spin.getTooltipText());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    if(removeElements){
                        p1.setText("All Elements Removed");
                    }
                }
            });
        }
        else {
            Toast.makeText(this, "You are in Landscape Mode", Toast.LENGTH_SHORT);
        }

    }
}