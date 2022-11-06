
import domain.Clinic;
import domain.Dentist;
import domain.Patient;
import domain.RepoException;
import repository.EntityRepository;
import service.AppointmentService;
import service.ClinicService;
import service.PatientDBService;
import ui.UI;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Clinic clinic1 = new Clinic("1", "Policlinica Marasti", "Cluj-Napoca", "+40712345678");

        Dentist dentist1 = new Dentist("1d1", "Harry Styles", "hstyle@mail.com", "+40741234567");
        Dentist dentist2 = new Dentist("1d2", "Joseph Mourinho", "fifafan@mail.com", "+40741234567");
        Dentist dentist3 = new Dentist("1d3", "Sam Smith", "smithy@mail.com", "+40741234567");
        Dentist dentist4 = new Dentist("1d4", "Denis Lewis", "hyoyo@mail.com", "+40741234567");
        Dentist dentist5 = new Dentist("1d5", "Dogg Snooping", "greenstuff@mail.com", "+40741234567");

        try {
            ClinicService.addDentist(clinic1, dentist1, dentist2, dentist3, dentist4, dentist5);
        } catch (RepoException e) {
            System.out.println(e.getMessage());
        }

        Patient patient1 = new Patient("1p1", "John Doe", "+40749123123", 9);
        Patient patient2 = new Patient("1p2", "Jane Doe", "+40749123123", 38);
        Patient patient3 = new Patient("1p3", "John Smith", "+40749123123", 32);
        Patient patient4 = new Patient("1p4", "Jane Smith", "+40749123123", 28);
        Patient patient5 = new Patient("1p5", "John Lewis", "+40749123123", 12);

        PatientDBService patientDB = new PatientDBService(new EntityRepository<Patient>());

        try {
            patientDB.add(patient1, patient2, patient3, patient4, patient5);
        } catch (RepoException e) {
            System.out.println(e.getMessage());
        }

        try {
            AppointmentService.book(clinic1, dentist3, patient1, LocalDate.of(2022, 12, 3));
            AppointmentService.book(clinic1, dentist2, patient2, LocalDate.of(2022, 9, 14));
            AppointmentService.book(clinic1, dentist1, patient3, LocalDate.of(2023, 11, 16));
            AppointmentService.book(clinic1, dentist4, patient4, LocalDate.of(2023, 10, 1));
            AppointmentService.book(clinic1, dentist5, patient5, LocalDate.of(2023, 9, 10));
        } catch (RepoException e) {
            System.out.println(e.getMessage());
        }

        UI ui = new UI(clinic1, patientDB);
        ui.run();

    }
}
