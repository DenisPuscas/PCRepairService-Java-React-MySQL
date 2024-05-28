package com.example.project.dataimp;

import com.example.project.data.AppointmentData;
import com.example.project.entity.Appointment;
import com.example.project.repository.AppointmentRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Această clasă oferă o implementare a interfeței AppointmentData.
 * Ea comunică cu repository-ul AppointmentRepository pentru a efectua operații legate de programări.
 */
@Component
public class AppointmentDataImp implements AppointmentData {

    private final AppointmentRepository repo;

    /**
     * Construiește o nouă instanță a clasei AppointmentDataImp cu AppointmentRepository specificat.
     *
     * @param repo Obiectul AppointmentRepository care va fi utilizat pentru accesul la date.
     */
    public AppointmentDataImp(AppointmentRepository repo) {
        this.repo = repo;
    }

    /**
     * Salvează o programare în sistem.
     *
     * @param appointment Obiectul programării de salvat.
     * @return Obiectul programării salvate.
     */
    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return repo.save(appointment);
    }

    /**
     * Salvează o listă de programări în sistem.
     *
     * @param appointments Lista obiectelor de programări de salvat.
     * @return Lista obiectelor de programări salvate.
     */
    @Override
    public List<Appointment> saveAppointments(List<Appointment> appointments) {
        return repo.saveAll(appointments);
    }

    /**
     * Recuperează toate programările din sistem.
     *
     * @return O listă cu toate obiectele de programări.
     */
    @Override
    public List<Appointment> getAppointments() {
        return repo.findAll();
    }

    /**
     * Recuperează o programare după ID-ul său.
     *
     * @param id ID-ul programării de recuperat.
     * @return Obiectul programării corespunzător ID-ului furnizat, sau null dacă nu a fost găsit.
     */
    @Override
    public Appointment getAppointmentById(int id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Șterge o programare din sistem după ID-ul său.
     *
     * @param id ID-ul programării de șters.
     * @return Un mesaj care indică rezultatul operației.
     */
    @Override
    public String deleteAppointment(int id) {
        repo.deleteById(id);
        return "Appointment " + id + " deleted!";
    }

    /**
     * Actualizează informațiile unei programări existente.
     *
     * @param appointment Obiectul programării actualizate.
     * @return Obiectul programării actualizate.
     */
    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return repo.save(appointment);
    }
}
