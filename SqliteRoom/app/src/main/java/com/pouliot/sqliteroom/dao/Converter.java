package com.pouliot.sqliteroom.dao;

import androidx.room.TypeConverter;

import java.util.Date;

public class Converter {
    @TypeConverter
    public Date fromLongToDate(Long value){
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public Long fromDateToLong(Date date){
        return date == null ? null : date.getTime();
    }

}
