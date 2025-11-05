package Studentlogger;

public class Student {
    private String name;
    private int roll;
    private int marks;

    public Student(String name, int roll, int marks) {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
    }

    public String getDetails() {
        return name + "," + roll + "," + marks;
    }
}