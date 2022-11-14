package com.pouliot.sqliteroom.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.pouliot.sqliteroom.models.Person;
import com.pouliot.sqliteroom.models.StopDate;

@Database(entities = {StopDate.class, Person.class}, version = 4, exportSchema = false)
@TypeConverters({Converter.class})
public abstract class DbContext extends RoomDatabase {
    public abstract DbContextDAO dao();
}
