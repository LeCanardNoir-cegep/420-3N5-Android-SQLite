package com.pouliot.sqliteroom.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.pouliot.sqliteroom.models.Person;
import com.pouliot.sqliteroom.models.StopDate;

import java.util.List;

@Dao
public abstract class DbContextDAO implements PersonDAO, StopDateDAO {
    @Override
    @Transaction
    public Long addFriends(Person person, List<Person> ps) {
        for (Person p: ps) {
            this.createPerson(p);
            person.friendsId.add(p.id);
        }
        return this.createPerson(person);
    }
}
