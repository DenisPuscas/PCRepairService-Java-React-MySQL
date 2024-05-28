package com.example.project.service;

import com.example.project.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment saveAppointment(Appointment appointment);
    List<Appointment> saveAppointments(List<Appointment> appointments);
    Appointment getAppointmentById(int id);
    List<Appointment> getAppointments();
    Appointment updateAppointment(Appointment appointment);
    String deleteAppointment(int id);
}
