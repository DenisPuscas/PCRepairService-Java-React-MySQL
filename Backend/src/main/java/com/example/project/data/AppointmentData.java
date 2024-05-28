package com.example.project.data;

import com.example.project.entity.Appointment;
import com.example.project.enumeration.Status;

import java.util.List;

public interface AppointmentData {

    Appointment saveAppointment(Appointment appointment);
    List<Appointment> saveAppointments(List<Appointment> appointments);
    List<Appointment> getAppointments();
    Appointment getAppointmentById(int id);
    String deleteAppointment(int id);
    Appointment updateAppointment(Appointment appointment);
}
