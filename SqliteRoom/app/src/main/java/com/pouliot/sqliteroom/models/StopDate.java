package com.pouliot.sqliteroom.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class StopDate {
    @PrimaryKey(autoGenerate = true)
    public Long id;

    @ColumnInfo
    public Date date;
}
