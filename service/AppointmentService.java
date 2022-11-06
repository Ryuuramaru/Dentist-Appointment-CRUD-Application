package service;

import domain.Dentist;
import domain.Appointment;
import domain.Patient;
import domain.RepoException;
import domain.Clinic;

import java.time.LocalDate;

final public class AppointmentService {
    public static Appointment book(Clinic clinic, Dentist dentist, Patient patient, LocalDate date)
            throws RepoException {
        for (Appointment a : clinic.appointments.getAll()) {
            if (a.getDate() == date && a.getDentist() == dentist)
                throw new RepoException("Dentist already has an appointment on that date!");
            if (a.getDate() == date && a.getPatient() == patient)
                throw new RepoException("Patient already has an appointment on that date!");
        }
        Appointment appointment = new Appointment(dentist, patient, date);
        return appointment;
    }

    public void cancel(Appointment appointment) {
        appointment.setDentist(null);
        appointment.setPatient(null);
        appointment.setDate(null);
    }
}
