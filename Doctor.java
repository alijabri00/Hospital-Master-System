public class Doctor extends Person {
    private String certificates;
    private String department;
    private double salary;

    public Doctor(String name, String govID, String location, String birthDate, String sex,
                String certificates, String department, double salary) {
        super(name, govID, location, birthDate, sex);
        this.certificates = certificates;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "[Doctor] " + super.toString() + " | Dept: " + department + " | Certs: " + certificates + " | Salary: " + salary;
    }
}