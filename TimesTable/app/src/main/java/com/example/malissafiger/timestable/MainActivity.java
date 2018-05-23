package com.example.malissafiger.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {
    ListView tableslist;
    public void generatetimestable(int timestable ){

        final ArrayList<String> arraylist= new ArrayList<String>();

        for(int i= 1; i <= 10; i ++){
            arraylist.add(Integer.toString(timestable * i));
        }

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraylist );

        tableslist.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SeekBar seekBar= (SeekBar)findViewById(R.id.seekBar);
        seekBar.setMax(20);
        seekBar.setProgress(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int timestable;

                if(progress<min){
                    timestable =min;
                    seekBar.setProgress(min);
                }else {
                    timestable=progress;
                }
                generatetimestable(timestable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        tableslist= (ListView) findViewById(R.id.tableslist);

        generatetimestable(10);






    }
}
