package domain;

//import java.lang.annotation.Inherited;

public class Patient extends Identifiable implements Comparable<Patient> {
    // String id; changed to Identifiable class
    private String name;
    private String phone;
    private int age;

    public Patient(String id, String name, String phone, int age) {
        super(id);
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + this.getID() + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Patient o) {
        if (this.age > o.age) {
            return 1;
        } else if (this.age < o.age) {
            return -1;
        } else {
            return 0;
        }
        // return 0;
    }
}
