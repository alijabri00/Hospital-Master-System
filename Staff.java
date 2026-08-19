public class Staff extends Person {
    private String jobTitle;
    private String department;
    private double salary;

    public Staff(String name, String govID, String location, String birthDate, String sex, 
                String jobTitle, String department, double salary) {
        super(name, govID, location, birthDate, sex);
        this.jobTitle = jobTitle;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "[Staff] " + super.toString() + " | Job: " + jobTitle + " | Dept: " + department + " | Salary: " + salary;
    }
}