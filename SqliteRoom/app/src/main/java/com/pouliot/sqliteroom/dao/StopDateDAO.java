package com.pouliot.sqliteroom.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.pouliot.sqliteroom.models.StopDate;

@Dao
public abstract class StopDateDAO {
    @Insert
    public abstract Long createDate(StopDate date);

    @Query(value = "SELECT * FROM StopDate ORDER BY 'id' DESC LIMIT 1 ")
    public abstract StopDate getLastDate();

}
