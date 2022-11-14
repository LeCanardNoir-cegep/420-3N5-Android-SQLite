package com.pouliot.sqliteroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.pouliot.sqliteroom.dao.DbContext;
import com.pouliot.sqliteroom.models.Person;
import com.pouliot.sqliteroom.models.StopDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Bruno";
    private DbContext db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(getApplicationContext(), DbContext.class, "sqlite_data")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        resumeDate((TextView) findViewById(R.id.resume));

        /*try {
            addPerson();
        } catch (ParseException e) {
            Log.e(TAG, "onCreate: Person: \n" + e.getMessage() );
            e.printStackTrace();
        }*/
    }

    @Override
    protected void onStop() {
        super.onStop();
        saveDate();
    }

    private void saveDate(){
        StopDate sd = new StopDate();
        sd.date = new Date();
        db.dao().createDate(sd);
    }

    private void resumeDate(TextView tv){
        if(db.dao().getLastDate() == null){
            Toast.makeText(getApplicationContext(), "Premier démarrage", Toast.LENGTH_SHORT).show();
            Log.i(TAG, "resumeDate: first start");
        }else{
            Date lastDate = db.dao().getLastDate().date;
            tv.setText("Dernière utilisation\n" + lastDate);
        }
    }

    private void addPerson() throws ParseException {
        Person p = new Person("Bruno", new SimpleDateFormat("yyyy/mm/dd").parse("1976/01/06"), Person.Sextype.Homme);
        db.dao().createPerson(p);
    }
}