package com.pouliot.sqliteroom.dao;

import androidx.room.Insert;
import androidx.room.Query;

import com.pouliot.sqliteroom.models.StopDate;

public interface StopDateDAO {
    @Insert
    public abstract Long createDate(StopDate date);

    @Query(value = "SELECT * FROM StopDate ORDER BY 'id' DESC LIMIT 1 ")
    public abstract StopDate getLastDate();
}
