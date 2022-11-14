package com.pouliot.sqliteroom.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {

    public enum Sextype {Homme, Femme, Complexe};

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo
    public String name;

    @ColumnInfo
    public Date birthday;

    @ColumnInfo
    public Sextype sex;

    public Person(String name, Date birthday, Sextype sex) {
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
    }
}
