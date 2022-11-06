package ui;

import java.util.Scanner;

import domain.Clinic;
import service.PatientDBService;

public class UI {

    Clinic clinic;
    PatientDBService patientDB;
    Scanner console;

    public UI(Clinic clinic, PatientDBService patientDB) {
        this.clinic = clinic;
        this.patientDB = patientDB;
    }

    public void run() {
        // TODO: implement
    }
}
