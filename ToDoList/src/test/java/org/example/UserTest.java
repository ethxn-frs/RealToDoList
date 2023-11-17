package org.example;

import org.example.entity.ToDoList;
import org.example.entity.User;
import org.junit.Before;
import org.junit.Test;


import java.time.LocalDateTime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {
    public User u;
    public ToDoList toDoList;

    @Before
    public void setup() {
        this.u = new User(1,
                "email@esgi.fr",
                "T3stTest11",
                "soso",
                "maness",
                LocalDateTime.now().minusYears(20),
                toDoList);
    }

    @Test
    public void testUserNominal() {
        assertTrue(u.isValid());
    }

    @Test
    public void testUserBadEmail() {
        u.setEmail("test");
        assertFalse(u.isValid());
    }

    @Test
    public void testBadUserFname() {
        u.setFName("");
        assertFalse(u.isValid());
    }

    @Test
    public void testBadUserLname() {
        u.setLName("");
        assertFalse(u.isValid());
    }

    @Test
    public void testUserBadBirthdate() {
        this.u.setBdate(LocalDateTime.now().minusYears(10));
        assertFalse(u.isValid());
    }

    @Test
    public void testUserBadPassword() {
        this.u.setPassword("zzzz");
        assertFalse(u.isValid());
    }

}
