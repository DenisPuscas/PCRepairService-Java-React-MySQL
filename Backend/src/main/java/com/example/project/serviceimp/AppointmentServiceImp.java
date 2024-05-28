package com.example.project.serviceimp;

import com.example.project.data.AppointmentData;
import com.example.project.entity.Appointment;
import com.example.project.enumeration.Status;
import com.example.project.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Această clasă oferă o implementare a interfeței AppointmentService.
 * Ea comunică cu stratul de date AppointmentData pentru a efectua operații legate de programări.
 */
@Service
public class AppointmentServiceImp implements AppointmentService {

    private final AppointmentData data;

    /**
     * Construiește o nouă instanță a clasei AppointmentServiceImp cu AppointmentData specificat.
     *
     * @param data Obiectul AppointmentData care va fi utilizat pentru accesul la date.
     */
    public AppointmentServiceImp(AppointmentData data) {
        this.data = data;
    }

    @Autowired
    private UserServiceImp userService;

    /**
     * Salvează o programare în sistem.
     *
     * @param appointment Obiectul programării de salvat.
     * @return Obiectul programării salvate.
     */
    public Appointment saveAppointment(Appointment appointment) {
        if (appointment.getStatus() == null){
            appointment.setStatus(Status.PENDING);
        }
        return data.saveAppointment(appointment);
    }

    /**
     * Salvează o listă de programări în sistem.
     *
     * @param appointments Lista obiectelor de programări de salvat.
     * @return Lista obiectelor de programări salvate.
     */
    public List<Appointment> saveAppointments(List<Appointment> appointments) {
        return data.saveAppointments(appointments);
    }

    /**
     * Recuperează toate programările din sistem.
     *
     * @return O listă cu toate obiectele de programări.
     */
    public List<Appointment> getAppointments() {
        return data.getAppointments();
    }

    /**
     * Recuperează o programare după ID-ul său.
     *
     * @param id ID-ul programării de recuperat.
     * @return Obiectul programării corespunzător ID-ului furnizat, sau null dacă nu a fost găsită.
     */
    public Appointment getAppointmentById(int id) {
        return data.getAppointmentById(id);
    }

    /**
     * Șterge o programare din sistem după ID-ul său.
     *
     * @param id ID-ul programării de șters.
     * @return Un mesaj care indică rezultatul operației.
     */
    public String deleteAppointment(int id) {
        return data.deleteAppointment(id);
    }

    /**
     * Actualizează informațiile unei programări existente.
     *
     * @param appointment Obiectul programării actualizate.
     * @return Obiectul programării actualizate, sau null dacă programarea nu a fost găsită.
     */
    public Appointment updateAppointment(Appointment appointment) {
        Appointment existingAppointment = data.getAppointmentById(appointment.getId());
        if (existingAppointment == null){
            System.out.println("Programarea nu a fost găsită!");
            return null;
        }
        existingAppointment.setIdUser(appointment.getIdUser());
        existingAppointment.setDescription(appointment.getDescription());
        existingAppointment.setDate(appointment.getDate());

        if (existingAppointment.getStatus() != Status.FIXED && appointment.getStatus() == Status.FIXED){
            userService.notify(appointment.getIdUser(), "Dispozitivul dumneavoastră este reparat!");
        }

        existingAppointment.setStatus(appointment.getStatus());

        return data.updateAppointment(existingAppointment);
    }
}
