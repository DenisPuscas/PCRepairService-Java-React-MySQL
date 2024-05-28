package com.example.project.dataTests;

import com.example.project.data.AppointmentData;
import com.example.project.dataimp.AppointmentDataImp;
import com.example.project.entity.Appointment;
import com.example.project.enumeration.Status;
import com.example.project.repository.AppointmentRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class AppointmentDataImpTests {

    @Mock
    private AppointmentRepository repo;

    private AppointmentData appointmentData;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        appointmentData = new AppointmentDataImp(repo);
    }

    @Test
    public void testSaveAppointment(){
        Appointment appointment = new Appointment(10, 10, "Pasta termoconductoare",
                LocalDateTime.of(2010, 10, 10, 12, 0), Status.PENDING);

        appointmentData.saveAppointment(appointment);

        Mockito.verify(repo).save(appointment);
    }

    @Test
    public void testSaveAppointments(){
        Appointment appointment1 = new Appointment(10, 10, "Pasta termoconductoare",
                LocalDateTime.of(2010, 10, 10, 12, 0), Status.PENDING);
        Appointment appointment2 = new Appointment(11, 11, "Pasta termoconductoare",
                LocalDateTime.of(2010, 10, 10, 12, 0), Status.PENDING);
        List<Appointment> appointments = List.of(appointment1, appointment2);

        appointmentData.saveAppointments(appointments);

        Mockito.verify(repo).saveAll(appointments);
    }

    @Test
    public void testGetAppointments(){
        appointmentData.getAppointments();

        Mockito.verify(repo).findAll();
    }

    @Test
    public void testGetAppointmentById(){
        int id = 10;

        appointmentData.getAppointmentById(id);

        Mockito.verify(repo).findById(id);
    }

    @Test
    public void testDeleteAppointment(){
        int id = 10;

        appointmentData.deleteAppointment(id);

        Mockito.verify(repo).deleteById(id);
    }

    @Test
    public void testUpdateAppointment(){
        Appointment appointment = new Appointment(10, 10, "Pasta termoconductoare",
                LocalDateTime.of(2010, 10, 10, 12, 0), Status.PENDING);

        appointmentData.updateAppointment(appointment);

        Mockito.verify(repo).save(appointment);
    }
}
