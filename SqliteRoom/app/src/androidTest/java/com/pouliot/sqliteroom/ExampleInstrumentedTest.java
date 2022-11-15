package com.pouliot.sqliteroom;


import org.junit.Test;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.pouliot.sqliteroom.dao.DbContext;
import com.pouliot.sqliteroom.models.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExampleInstrumentedTest {
    @Test
    public void checkTestInstallation() {
        assertEquals(true, true);
    }

    @Test
    public void testPerson(){
        Context context = ApplicationProvider.getApplicationContext();
        DbContext db = Room.inMemoryDatabaseBuilder(context, DbContext.class).build();
        int nb = 10;
        for(int i = 0; i < nb; i++){
            Person p = new Person("Bruno_" + i, new Date(), Person.Sextype.Homme);
            db.dao().createPerson(p);
        }
        List<Person> persons = db.dao().getAllPersons();
        assertEquals(nb, persons.size());
        db.close();
    }

    @Test
    public void testManyPerson(){
        Context context = ApplicationProvider.getApplicationContext();
        DbContext db = Room.inMemoryDatabaseBuilder(context, DbContext.class).build();
        int nb = 100;
        for(int i = 0; i < nb; i++){
            Person p = new Person("Bruno_" + i, new Date(), Person.Sextype.Homme);
            db.dao().createPerson(p);
        }
        List<Person> persons = db.dao().getAllPersons();
        assertEquals(nb, persons.size());
        db.close();
    }

    @Test
    public void testTransaction(){
        Context context = ApplicationProvider.getApplicationContext();
        DbContext db = Room.inMemoryDatabaseBuilder(context, DbContext.class).build();

        int nb = 100;
        List<Person> pList = new ArrayList<>();
        for (int i = 0; i < nb; i++) {
            Person p = new Person("Bruno-" + i, new Date(), Person.Sextype.Homme);
            pList.add(p);
        }
        Person p = new Person("toto", new Date(), Person.Sextype.Femme);
        db.dao().addFriends(p, pList);
        //assertEquals(nb, db.dao().getPersonsBySex(Person.Sextype.Homme).size());
        assertEquals(pList.get(0).id, db.dao().getPersonsByName(p.name).friendsId.get(0));

    }

}
