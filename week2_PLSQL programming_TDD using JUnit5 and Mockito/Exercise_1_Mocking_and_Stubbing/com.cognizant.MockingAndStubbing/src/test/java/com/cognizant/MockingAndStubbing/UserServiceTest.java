package com.cognizant.MockingAndStubbing;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void testGetUserEmail() {
        UserRepository mockRepo = mock(UserRepository.class);
        UserService userService = new UserService(mockRepo);
        when(mockRepo.findByUsername("moushmi")).thenReturn(new User("moushmi", "moushmi@gmail.com"));
        String email = userService.getUserEmail("moushmi");
        assertEquals("moushmi@gmail.com", email);
        verify(mockRepo).findByUsername("moushmi");
    }

    @Test
    void testGetUserEmail_UserNotFound() {
        UserRepository mockRepo = mock(UserRepository.class);
        UserService userService = new UserService(mockRepo);
        when(mockRepo.findByUsername("unknown")).thenReturn(null);
        String email = userService.getUserEmail("unknown");
        assertNull(email);
    }
}