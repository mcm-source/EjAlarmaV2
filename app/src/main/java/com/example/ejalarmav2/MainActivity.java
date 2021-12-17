package com.example.ejalarmav2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtn(View view) {
        createAlarm();


    }

    private void createAlarm() {
        TimePicker timePicker = findViewById(R.id.timePicker);
        Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
        i.putExtra(AlarmClock.EXTRA_HOUR, obtenerHoraAlarma(timePicker));
        i.putExtra(AlarmClock.EXTRA_MINUTES, obtenerMiutosAlarma(timePicker));
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        } else {
            Toast.makeText(this, "NO HAY ACTIVITY DISPONIBLE", Toast.LENGTH_LONG).show();
        }


    }

    private Integer obtenerHoraAlarma(TimePicker timePicker){
        return timePicker.getCurrentHour();


    }

    private Integer obtenerMiutosAlarma(TimePicker timePicker){
        return timePicker.getCurrentMinute();



    }
}