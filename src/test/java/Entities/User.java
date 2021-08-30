package Entities;

public class User {

    private String firstName;
    private String lastName;

    public User(String firstName, String lastName, int subjectId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjectId = subjectId;
    }

    private int subjectId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

}
