package com.example.project.dataimp;

import com.example.project.data.UserData;
import com.example.project.entity.User;
import com.example.project.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Această clasă oferă o implementare a interfeței UserData.
 * Ea comunică cu repository-ul UserRepository pentru a efectua operații legate de utilizatori.
 */
@Component
public class UserDataImp implements UserData {

    private final UserRepository repo;

    /**
     * Construiește o nouă instanță a clasei UserDataImp cu UserRepository specificat.
     *
     * @param repo Obiectul UserRepository care va fi utilizat pentru accesul la date.
     */
    public UserDataImp(UserRepository repo){
        this.repo = repo;
    }

    /**
     * Salvează un utilizator în sistem.
     *
     * @param user Obiectul utilizatorului de salvat.
     * @return Obiectul utilizatorului salvat.
     */
    @Override
    public User saveUser(User user) {
        return repo.save(user);
    }

    /**
     * Salvează o listă de utilizatori în sistem.
     *
     * @param users Lista obiectelor de utilizatori de salvat.
     * @return Lista obiectelor de utilizatori salvate.
     */
    @Override
    public List<User> saveUsers(List<User> users) {
        return repo.saveAll(users);
    }

    /**
     * Recuperează toți utilizatorii din sistem.
     *
     * @return O listă cu toți utilizatorii.
     */
    @Override
    public List<User> getUsers() {
        return repo.findAll();
    }

    /**
     * Recuperează un utilizator după ID-ul său.
     *
     * @param id ID-ul utilizatorului de recuperat.
     * @return Obiectul utilizatorului corespunzător ID-ului furnizat, sau null dacă nu a fost găsit.
     */
    @Override
    public User getUserById(int id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Recuperează un utilizator după adresa de email.
     *
     * @param email Adresa de email a utilizatorului de recuperat.
     * @return Obiectul utilizatorului corespunzător adresei de email furnizate, sau null dacă nu a fost găsit.
     */
    @Override
    public User getUserByEmail(String email) {
        return repo.getByEmail(email);
    }

    /**
     * Șterge un utilizator din sistem după ID-ul său.
     *
     * @param id ID-ul utilizatorului de șters.
     * @return Un mesaj care indică rezultatul operației.
     */
    @Override
    public String deleteUser(int id) {
        repo.deleteById(id);
        return "User " + id + " deleted!";
    }

    /**
     * Actualizează informațiile unui utilizator existent.
     *
     * @param user Obiectul utilizatorului actualizat.
     * @return Obiectul utilizatorului actualizat.
     */
    @Override
    public User updateUser(User user) {
        return repo.save(user);
    }
}
