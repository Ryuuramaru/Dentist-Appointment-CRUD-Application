package domain;

import repository.EntityRepository;

public class Clinic extends Identifiable implements Comparable<Clinic> {
    private String name;
    private String address;
    private String phone;
    public EntityRepository<Dentist> dentists;
    public EntityRepository<Appointment> appointments;

    public Clinic(String id, String name, String address, String phone) {
        super(id);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.dentists = new EntityRepository<Dentist>();
        this.appointments = new EntityRepository<Appointment>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "id='" + this.getID() + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public int compareTo(Clinic o) {
        if (this.name.compareTo(o.name) > 0) {
            return 1;
        } else if (this.name.compareTo(o.name) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
