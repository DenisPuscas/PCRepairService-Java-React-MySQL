package com.example.project.controller;

import com.example.project.entity.User;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    /**
     * Instanta a obiectului Service care ne pune la dispozitie metodele pentru interactiunea cu baza de date.
     */
    @Autowired
    private UserService service;

    /**
     * Adauga un client in baza de date.
     * @param user clientul care urmeaza sa fie adaugat
     * @return clientul adaugat
     */
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }
    /**
     * Adauga mai multi clienti in baza de date.
     * @param users lista cu clientii care urmeaza sa fie adaugati
     * @return lista clientilor adaugati
     */
    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> users){
        return service.saveUsers(users);
    }
    /**
     * Cauta toti clientii in baza de date.
     * @return lista clientilor gasiti
     */
    @GetMapping("/users")
    public List<User> findAllUsers(){
        return service.getUsers();
    }
    /**
     * Cauta un client dupa id-ul dat.
     * @param id id-ul clientului care urmeaza sa fie cautat
     * @return clientul gasit
     */
    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable int id){
        return service.getUserById(id);
    }
    /**
     * Cauta un client dupa email-ul dat.
     * @param email email-ul clientului care urmeaza sa fie cautat
     * @return clientul gasit
     */
    @GetMapping("/userEmail/{email}")
    public User findUserByEmail(@PathVariable String email){
        return service.getUserByEmail(email);
    }
    /**
     * Actualizeaza un anumit client.
     * @param user clientul care urmeaza sa fie actualizat
     * @return clientul actualizat
     */
    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }
    /**
     * Sterge un anumit client.
     * @param id id-ul clientului care urmeaza sa fie stears
     * @return mesaj de succes sau eroare
     */
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        return service.deleteUser(id);
    }
}
