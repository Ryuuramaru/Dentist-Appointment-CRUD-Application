package service;

import domain.Appointment;
import domain.Clinic;
import domain.Dentist;
import domain.RepoException;

import java.time.LocalDate;
import java.util.ArrayList;

final public class ClinicService {
    public static void addDentist(Clinic clinic, Dentist... dentist) throws RepoException {
        for (Dentist d : dentist)
            if (!clinic.dentists.add(d))
                throw new RepoException("Dentist already exists!");
    }

    static public void removeDentist(Clinic clinic, Dentist... dentist) throws RepoException {
        for (Dentist d : dentist)
            if (!clinic.dentists.remove(d))
                throw new RepoException("Dentist does not exist");
    }

    static public void removeDentistID(Clinic clinic, String... ids) throws RepoException {
        for (String id : ids)
            if (!clinic.dentists.remove(new Dentist(id, null, null, null)))
                throw new RepoException("Dentist does not exist");
    }

    static public int getDentistCount(Clinic clinic) {
        return clinic.dentists.getAll().size();
    }

    static public ArrayList<Appointment> appointments(Clinic clinic) {
        return clinic.appointments.getAll();
    }

    static public void cleanAppointments(Clinic clinic) {
        ArrayList<Appointment> temp = new ArrayList<>();
        for (Appointment a : clinic.appointments.getAll())
            if (a.getDate().isAfter(LocalDate.now()) && a.getDentist() != null && a.getPatient() != null)
                temp.add(a);
        clinic.appointments.setAll(temp);
    }

    static public ArrayList<Appointment> appointmentsOn(Clinic clinic, LocalDate date) {
        ArrayList<Appointment> ap = new ArrayList<>();
        for (Appointment a : clinic.appointments.getAll())
            if (a.getDate() == date)
                ap.add(a);
        return ap;
    }
}
