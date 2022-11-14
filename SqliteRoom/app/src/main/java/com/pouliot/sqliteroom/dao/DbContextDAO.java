package com.pouliot.sqliteroom.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.pouliot.sqliteroom.models.Person;
import com.pouliot.sqliteroom.models.StopDate;

import java.util.List;

@Dao
public abstract class DbContextDAO {
    // RESUME DATE TABLE
    @Insert
    public abstract Long createDate(StopDate date);

    @Query(value = "SELECT * FROM StopDate ORDER BY 'id' DESC LIMIT 1 ")
    public abstract StopDate getLastDate();

    // PERSON TABLE
    @Insert
    public abstract Long createPerson(Person person);

    @Query("SELECT * FROM Person WHERE sex = :sex")
    public abstract List<Person> getPersonsBySex(Person.Sextype sex);

    @Query("SELECT * FROM Person")
    public abstract List<Person> getAllPersons();

}
