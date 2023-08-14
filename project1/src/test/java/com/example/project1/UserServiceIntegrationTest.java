package com.example.project1;

import com.example.project1.api.model.Gender;
import com.example.project1.api.model.User;
import com.example.project1.repository.UserRepository;
import com.example.project1.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class UserServiceIntegrationTest {

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @Test
    void testSaveUser() {
        User user = new User("12345", "John", "Doe", LocalDate.of(1995, 1, 1), Gender.MALE);

        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userService.save(user);

        assertEquals("John", savedUser.getFirstName());
        verify(userRepository).save(user);
    }


}
