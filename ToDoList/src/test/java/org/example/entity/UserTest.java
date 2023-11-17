package org.example.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {

    private User u;
    private ToDoList toDoList;

    @Before
    public void setup() {
        this.u = new User(1,
                "test@esgi.fr",
                "T3sttestEsgi",
                "Test",
                "Esgi",
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
    public void testUserFname() {
        u.setFName("");
        assertFalse(u.isValid());
    }

    @Test
    public void testUserBadBirthdate() {
        this.u.setBdate(LocalDateTime.now().minusYears(10));
        assertFalse(u.isValid());
    }
}