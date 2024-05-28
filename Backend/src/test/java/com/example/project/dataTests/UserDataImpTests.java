package com.example.project.dataTests;

import com.example.project.data.UserData;
import com.example.project.dataimp.UserDataImp;
import com.example.project.entity.User;
import com.example.project.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
public class UserDataImpTests {

    @Mock
    private UserRepository repo;

    private UserData userData;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        userData = new UserDataImp(repo);
    }

    @Test
    public void testSaveUser(){
        // given
        User user = new User(10, "Pintea", "David", "dpintea@gmail.com",
                "david1234", "0752459121", "Sibiu");
        when(repo.save(user)).thenReturn(user);

        // when
        User result = userData.saveUser(user);

        // then
        Mockito.verify(repo).save(user);
        assertEquals(user, result);
    }

    @Test
    public void testSaveUsers(){
        User user1 = new User(10, "Pintea", "David", "dpintea@gmail.com",
                "david1234", "0752459121", "Sibiu");
        User user2 = new User(11, "Veres", "Liviu", "veresliviu@gmail.com",
                "liviu2004", "0755325646", "Bacau");
        List<User> users = List.of(user1, user2);

        userData.saveUsers(users);

        Mockito.verify(repo).saveAll(users);
    }

    @Test
    public void testGetUsers(){
        userData.getUsers();

        Mockito.verify(repo).findAll();
    }

    @Test
    public void testGetUserById(){
        int id = 10;

        userData.getUserById(id);

        Mockito.verify(repo).findById(id);
    }


    @Test
    public void testGetUserByEmail(){
        String email = "rusmircea@gmail.com";

        userData.getUserByEmail(email);

        Mockito.verify(repo).getByEmail(email);
    }

    @Test
    public void testDeleteUser(){
        int id = 10;

        userData.deleteUser(id);

        Mockito.verify(repo).deleteById(id);
    }

    @Test
    public void testUpdateUser(){
        User user = new User(10, "Pintea", "David", "dpintea@gmail.com",
                "david1234", "0752459121", "Sibiu");

        userData.updateUser(user);

        Mockito.verify(repo).save(user);
    }

}
