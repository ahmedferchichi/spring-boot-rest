package com.devglan.service;

// this static must add manually !
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.devglan.dao.UserDao;
import com.devglan.model.user.User;
import com.devglan.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    // use the implementation not the interface !
    UserServiceImpl userServiceImpl;

    @Mock
    UserDao userDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testService() {
        when(userDao.findById(1)).thenReturn(java.util.Optional.of(new User(1, "Ahmed", "FERCHICHI", "ferchichy.ahmed@gmail.com", "password", "typeUser")));

        User user = userServiceImpl.findById(1);
        assertEquals("ferchichy.ahmed@gmail.com", user.getEmail());
        assertEquals("Ahmed",user.getFirstName());
        assertEquals("FERCHICHI",user.getLastName());

        System.out.println("Test userService : "+ user.getId());

    }
}
