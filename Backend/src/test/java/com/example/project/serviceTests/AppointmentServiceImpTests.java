package com.example.project.serviceTests;

import com.example.project.data.AppointmentData;
import com.example.project.service.AppointmentService;
import com.example.project.serviceimp.AppointmentServiceImp;
import com.example.project.entity.Appointment;
import com.example.project.enumeration.Status;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class AppointmentServiceImpTests {

    @Mock
    private AppointmentData data;

    private AppointmentService appointmentService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        appointmentService = new AppointmentServiceImp(data);
    }

    @Test
    public void testSaveAppointment(){
        Appointment appointment = new Appointment(10, 10, "Pasta termoconductoare",
                LocalDateTime.of(2010, 10, 10, 12, 0), Status.PENDING);

        appointmentService.saveAppointment(appointment);

        Mockito.verify(data).saveAppointment(appointment);
    }

    @Test
    public void testSaveAppointments(){
        Appointment appointment1 = new Appointment(10, 10, "Pasta termoconductoare",
                LocalDateTime.of(2010, 10, 10, 12, 0), Status.PENDING);
        Appointment appointment2 = new Appointment(11, 11, "Pasta termoconductoare",
                LocalDateTime.of(2010, 10, 10, 12, 0), Status.PENDING);
        List<Appointment> appointments = List.of(appointment1, appointment2);

        appointmentService.saveAppointments(appointments);

        Mockito.verify(data).saveAppointments(appointments);
    }

    @Test
    public void testGetAppointments(){
        appointmentService.getAppointments();

        Mockito.verify(data).getAppointments();
    }

    @Test
    public void testGetAppointmentById(){
        int id = 10;

        appointmentService.getAppointmentById(id);

        Mockito.verify(data).getAppointmentById(id);
    }

    @Test
    public void testDeleteAppointment(){
        int id = 10;

        appointmentService.deleteAppointment(id);

        Mockito.verify(data).deleteAppointment(id);
    }

    @Test
    public void testUpdateAppointment(){
        Appointment appointment = new Appointment(10, 10, "Pasta termoconductoare",
                LocalDateTime.of(2010, 10, 10, 12, 0), Status.PENDING);
        when(data.getAppointmentById(appointment.getId())).thenReturn(appointment);

        appointmentService.updateAppointment(appointment);

        Mockito.verify(data).updateAppointment(appointment);
    }
}
