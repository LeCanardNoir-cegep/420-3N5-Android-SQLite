package com.pouliot.sqliteroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.pouliot.sqliteroom.dao.StopDateBD;
import com.pouliot.sqliteroom.models.StopDate;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Bruno";
    private StopDateBD BD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resumeDate();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
        saveDate();
    }

    private void saveDate(){
        StopDate sd = new StopDate();
        sd.date = new Date();
        BD.dao().createDate(sd);
    }

    private void resumeDate(){
        BD = Room.databaseBuilder(getApplicationContext(), StopDateBD.class, "StopDate")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        if(BD.dao().getLastDate() != null){
            Date lastDate = BD.dao().getLastDate().date;
            Toast.makeText(getApplicationContext(), "Dernière utilisation\n" + lastDate, Toast.LENGTH_SHORT).show();
            Log.i(TAG, "onCreate: " + lastDate);
        }}
}