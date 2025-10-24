package Studentlogger;

public class Main {
    public static void main(String[] args) {
        String fileName = "student_scores.csv";
        ScoreWriter writer = new ScoreWriter(fileName);

        Student s1 = new Student("Asha", 101, 85);
        Student s2 = new Student("Kiran", 102, 92);
        Student s3 = new Student("Manu", 103, 78);

        Thread t1 = new StudentThread(s1, writer);
        Thread t2 = new StudentThread(s2, writer);
        Thread t3 = new StudentThread(s3, writer);

        t1.start();
        t2.start();
        t3.start();

        try {
           
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All student scores logged successfully!");
    }
}