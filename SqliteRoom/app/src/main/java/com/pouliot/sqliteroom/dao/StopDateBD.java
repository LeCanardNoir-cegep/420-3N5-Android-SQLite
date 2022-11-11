package com.pouliot.sqliteroom.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.pouliot.sqliteroom.models.StopDate;

@Database(entities = {StopDate.class}, version = 3, exportSchema = false)
@TypeConverters({Converter.class})
public abstract class StopDateBD extends RoomDatabase {
    public abstract StopDateDAO dao();
}
