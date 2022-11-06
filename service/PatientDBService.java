package service;

import domain.Patient;
import domain.RepoException;
import repository.EntityRepository;

public class PatientDBService {
    EntityRepository<Patient> patients;

    public PatientDBService(EntityRepository<Patient> patients) {
        this.patients = patients;
    }

    public void add(Patient... patient) throws RepoException {
        for (Patient p : patient)
            if (!patients.add(p))
                throw new RepoException("Patient already exists!");
    }

    public void remove(Patient... patient) throws RepoException {
        for (Patient p : patient) {
            if (!patients.remove(p))
                throw new RepoException("Patient does not exist");
        }

    }
}
