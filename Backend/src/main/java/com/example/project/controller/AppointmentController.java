package com.example.project.controller;

import com.example.project.entity.Appointment;
import com.example.project.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AppointmentController {

    /**
     * Instanta a obiectului Service care ne pune la dispozitie metodele pentru interactiunea cu baza de date.
     */
    @Autowired
    private AppointmentService service;

    /**
     * Adauga o programare in baza de date.
     * @param appointment programarea care urmeaza sa fie adaugata
     * @return Appointment
     */
    @PostMapping("/addAppointment")
    public Appointment addAppointment(@RequestBody Appointment appointment){
        return service.saveAppointment(appointment);
    }

    /**
     * Adauga mai multe programari in baza de date.
     * @param appointments lista de programari care urmeaza sa fie adaugate
     * @return lista programarilor adaugate
     */
    @PostMapping("/addAppointments")
    public List<Appointment> addAppointments(@RequestBody List<Appointment> appointments){
        return service.saveAppointments(appointments);
    }

    /**
     * Cauta toate programarile in baza de date.
     * @return lista programarilor gasite
     */
    @GetMapping("/appointments")
    public List<Appointment> findAllAppointments(){
        return service.getAppointments();
    }

    /**
     * Cauta o programare dupa id-ul dat.
     * @param id id-ul programarii care urmeaza sa fie cautata
     * @return programare gasita
     */
    @GetMapping("/appointment/{id}")
    public Appointment findAppointmentById(@PathVariable int id){
        return service.getAppointmentById(id);
    }

    /**
     * Actualizeaza o anumita programare.
     * @param appointment programare care urmeaza sa fie actualizata
     * @return programare actualizata
     */
    @PutMapping("/updateAppointment")
    public Appointment updateAppointment(@RequestBody Appointment appointment){
        return service.updateAppointment(appointment);
    }

    /**
     * Sterge o anumita programare.
     * @param id id-ul programarii care urmeaza sa fie stearsa
     * @return mesaj de succes sau eroare
     */
    @DeleteMapping("/deleteAppointment/{id}")
    public String deleteAppointment(@PathVariable int id){
        return service.deleteAppointment(id);
    }
}
