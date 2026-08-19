public class Person {
    protected String name;
    protected String govID;
    protected String location;
    protected String birthDate;
    protected String sex;

    public Person(String name, String govID, String location, String birthDate, String sex) {
        this.name = name;
        this.govID = govID;
        this.location = location;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Name: " + name + " | ID: " + govID + " | Birth: " + birthDate + " | Sex: " + sex + " | Loc: " + location;
    }
}