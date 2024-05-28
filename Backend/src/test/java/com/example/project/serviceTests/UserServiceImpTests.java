package com.example.project.serviceTests;

import com.example.project.data.UserData;
import com.example.project.entity.User;
import com.example.project.serviceimp.UserServiceImp;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceImpTests {

    @Mock
    private UserData data;
    @Mock
    private User userMock;
    
    private UserServiceImp userService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImp(data);
    }

    @Test
    public void testSaveUser(){
        User user = new User(10, "Pintea", "David", "dpintea@gmail.com",
                "david1234", "0752459121", "Sibiu");

        userService.saveUser(user);

        Mockito.verify(data).saveUser(user);
    }

    @Test
    public void testSaveUsers(){
        User user1 = new User(10, "Pintea", "David", "dpintea@gmail.com",
                "david1234", "0752459121", "Sibiu");
        User user2 = new User(11, "Veres", "Liviu", "veresliviu@gmail.com",
                "liviu2004", "0755325646", "Bacau");
        List<User> users = List.of(user1, user2);

        userService.saveUsers(users);

        Mockito.verify(data).saveUsers(users);
    }

    @Test
    public void testGetUsers(){
        userService.getUsers();

        Mockito.verify(data).getUsers();
    }

    @Test
    public void testGetUserById(){
        int id = 10;

        userService.getUserById(id);

        Mockito.verify(data).getUserById(id);
    }


    @Test
    public void testGetUserByEmail(){
        String email = "rusmircea@gmail.com";

        userService.getUserByEmail(email);

        Mockito.verify(data).getUserByEmail(email);
    }

    @Test
    public void testDeleteUser(){
        int id = 10;

        userService.deleteUser(id);

        Mockito.verify(data).deleteUser(id);
    }

    @Test
    public void testUpdateUser(){
        User user = new User(10, "Pintea", "David", "dpintea@gmail.com",
                "david1234", "0752459121", "Sibiu");
        when(data.getUserById(user.getId())).thenReturn(user);

        userService.updateUser(user);

        Mockito.verify(data).updateUser(user);
    }

    @Test
    public void testNotifyUser(){
        int id = 10;
        String msg = "Notified user!";
        when(userService.getUserById(id)).thenReturn(userMock);

        userService.notify(id, msg);

        Mockito.verify(userMock).update(msg);
    }

}
