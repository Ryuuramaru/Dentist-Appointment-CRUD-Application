package domain;

import java.time.LocalDate;

public class Appointment extends Identifiable implements Comparable<Appointment> {
    // String id; using generic class Identifiable
    private Dentist dentist;
    private Patient patient;
    private LocalDate date;

    // Constructor
    public Appointment(Dentist dentist, Patient patient, LocalDate date) {
        super(dentist.getID() + patient.getID() + date.toString());
        this.dentist = dentist;
        this.patient = patient;
        this.date = date;
    }

    // Getters

    public Dentist getDentist() {
        return dentist;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDate getDate() {
        return date;
    }

    // Setters
    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public void setPatient(Patient namePatient) {
        this.patient = namePatient;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // toString
    @Override
    public String toString() {
        return "Appointment{" +
                "id ='" + this.getID() + '\'' +
                ", Doctor='" + dentist.toString() + '\'' +
                ", Patient='" + patient.toString() + '\'' +
                ", date ='" + date + '\'' +
                '}';
    }

    @Override
    public int compareTo(Appointment o) {
        if (this.date.compareTo(o.date) > 0) {
            return 1;
        } else if (this.date.compareTo(o.date) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
