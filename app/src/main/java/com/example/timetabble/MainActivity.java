package com.example.timetabble;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTableListView;

    public void generateTimesTables(int timesTablesNumber) {
        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int j = 1; j <= 100; j++) {
            timesTableContent.add(Integer.toString(j * timesTablesNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        timesTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTablesSeekBar = findViewById(R.id.seekBar);
        timesTableListView = findViewById(R.id.timesTablesListView);

        int max = 20;
        int startingPosition = 10;

        timesTablesSeekBar.setMax(max);
        timesTablesSeekBar.setProgress(10);

        generateTimesTables(10);

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTablesNumber;

                if (i < min) {
                    timesTablesNumber = min;
                    timesTablesSeekBar.setProgress(min);

                } else {
                    timesTablesNumber = i;
                }

                Log.i("Seekbar Value ", Integer.toString(timesTablesNumber));

                generateTimesTables(timesTablesNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}