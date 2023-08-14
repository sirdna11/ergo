package com.example.project1;



import com.example.project1.api.model.Gender;
import com.example.project1.api.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("12345", "John", "Doe", LocalDate.of(1995, 1, 1), Gender.MALE);
    }

    @Test
    void testPersonalId() {
        assertEquals("12345", user.getPersonalID());
        user.setPersonalID("67890");
        assertEquals("67890", user.getPersonalID());
    }

    @Test
    void testFirstName() {
        assertEquals("John", user.getFirstName());
        user.setFirstName("Jane");
        assertEquals("Jane", user.getFirstName());
    }



    @Test
    void testEquals() {
        User anotherUser = new User("12345", "John", "Doe", LocalDate.of(1995, 1, 1), Gender.MALE);
        assertEquals(anotherUser, user);
    }


}

