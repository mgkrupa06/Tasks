package Studentlogger;

public class StudentTask extends Thread {
    private Student student;
    private FileHandler handler;

    public StudentTask(Student student, FileHandler handler) {
        this.student = student;
        this.handler = handler;
    }

    @Override
    public void run() {
        handler.writeToFile(student);
    }
}
