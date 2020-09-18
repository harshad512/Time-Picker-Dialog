package com.example.timepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    static final int DIALOG_ID = 0;
    int hour_x,minute_x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showTimePickerDialog();
    }

    public void showTimePickerDialog(){
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if (id == DIALOG_ID)
            return new TimePickerDialog(MainActivity.this,kTimePickerListner,hour_x,minute_x,false);
        return null;
    }

    protected TimePickerDialog.OnTimeSetListener kTimePickerListner = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hour_x = hourOfDay;
            minute_x = minute;
            Toast.makeText(MainActivity.this,hour_x + " : " + minute_x,Toast.LENGTH_LONG).show();
        }
    };
}