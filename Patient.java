public class Patient extends Person {
    private String department;
    private String doctorName;
    private boolean isFollowUp;

    public Patient(String name, String govID, String location, String birthDate, String sex, 
                String department, String doctorName, boolean isFollowUp) {
        super(name, govID, location, birthDate, sex);
        this.department = department;
        this.doctorName = doctorName;
        this.isFollowUp = isFollowUp;
    }

    @Override
    public String toString() {
        String type = isFollowUp ? "Follow-up" : "New Patient";
        return "[Patient] " + super.toString() + " | Dept: " + department + " | Dr: " + doctorName + " | Type: " + type;
    }
}