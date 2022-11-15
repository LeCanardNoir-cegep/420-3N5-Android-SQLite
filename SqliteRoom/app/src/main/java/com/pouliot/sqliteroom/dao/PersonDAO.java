package com.pouliot.sqliteroom.dao;

import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.pouliot.sqliteroom.models.Person;

import java.util.List;

public interface PersonDAO {
    @Insert
    public abstract Long createPerson(Person person);

    @Query("SELECT * FROM Person WHERE sex = :sex")
    public abstract List<Person> getPersonsBySex(Person.Sextype sex);

    @Query("SELECT * FROM Person")
    public abstract List<Person> getAllPersons();

    @Query("SELECT * FROM Person WHERE id = :name LIMIT 1")
    public abstract Person getPersonsByName(String name);

    @Transaction
    public abstract Long addFriends(Person person, List<Person> ps);
}
