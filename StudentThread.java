
package Studentlogger;

public class StudentThread extends Thread {
    private final Student student;
    private final ScoreWriter writer;

    public StudentThread(Student student, ScoreWriter writer) {
        this.student = student;
        this.writer = writer;
    }

    @Override
    public void run() {
        writer.writeScore(student);
    }
}