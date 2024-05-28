package com.example.project.serviceimp;

import com.example.project.data.UserData;
import com.example.project.entity.User;
import com.example.project.observer.Subject;
import com.example.project.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Aceasta clasa furnizeaza o implementare a interfetei UserService.
 * Ea comunica cu nivelul de date UserData pentru a efectua operatii legate de utilizatori.
 * In plus, implementeaza interfata Subject pentru a sustine sablonul observer.
 */
@Service
public class UserServiceImp implements UserService, Subject {

    private final UserData data;

    /**
     * Construieste o noua instanta a clasei UserServiceImp cu UserData specificat.
     *
     * @param data Obiectul UserData care va fi utilizat pentru accesul la date.
     */
    public UserServiceImp(UserData data) { this.data = data; }

    /**
     * Salveaza un utilizator in sistem.
     *
     * @param user Obiectul utilizatorului de salvat.
     * @return Obiectul utilizatorului salvat.
     */
    public User saveUser(User user) {return data.saveUser(user);}

    /**
     * Salveaza o lista de utilizatori in sistem.
     *
     * @param users Lista obiectelor de utilizatori de salvat.
     * @return Lista obiectelor de utilizatori salvate.
     */
    public List<User> saveUsers(List<User> users) {
        return data.saveUsers(users);
    }

    /**
     * Recupereaza toti utilizatorii din sistem.
     *
     * @return O lista cu toti obiectele de utilizatori.
     */
    public List<User> getUsers() {
        return data.getUsers();
    }

    /**
     * Recupereaza un utilizator dupa ID-ul sau.
     *
     * @param id ID-ul utilizatorului de recuperat.
     * @return Obiectul utilizatorului corespunzator ID-ului furnizat, sau null daca nu a fost gasit.
     */
    public User getUserById(int id) {
        return data.getUserById(id);
    }

    /**
     * Recupereaza un utilizator dupa adresa sa de email.
     *
     * @param email Adresa de email a utilizatorului de recuperat.
     * @return Obiectul utilizatorului corespunzator adresei de email furnizate, sau null daca nu a fost gasit.
     */
    public User getUserByEmail(String email) {
        return data.getUserByEmail(email);
    }

    /**
     * Sterge un utilizator din sistem dupa ID-ul sau.
     *
     * @param id ID-ul utilizatorului de sters.
     * @return Un mesaj care indica rezultatul operatiei.
     */
    public String deleteUser(int id) {
        return data.deleteUser(id);
    }

    /**
     * Actualizeaza informatiile unui utilizator existent.
     *
     * @param user Obiectul utilizatorului actualizat.
     * @return Obiectul utilizatorului actualizat, sau null daca utilizatorul nu a fost gasit.
     */
    public User updateUser(User user) {
        User existingUser = data.getUserById(user.getId());
        if (existingUser == null) {
            System.out.println("User not found!");
            return null;
        }
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setPhone(user.getPhone());
        existingUser.setAddress(user.getAddress());
        return data.updateUser(existingUser);
    }

    /**
     * Anunta un utilizator cu ID-ul furnizat despre un mesaj.
     *
     * @param id  ID-ul utilizatorului de anuntat.
     * @param msg Mesajul de anuntat utilizatorului.
     */
    @Override
    public void notify(Integer id, String msg){

        User subj = getUserById(id);
        if (subj != null){
            subj.update(msg);
        } else{
            System.out.println("Client not found!");
        }
    }
}
