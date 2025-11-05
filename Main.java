package Studentlogger;

public class Main {
    public static void main(String[] args) {

        String file = "student_scores.csv";
        FileHandler handler = new FileHandler(file);

        Student s1 = new Student("Krupa", 1, 100);
        Student s2 = new Student("Amogh", 2, 99);
        Student s3 = new Student("Dhanya", 3, 98);

        Thread t1 = new StudentTask(s1, handler);
        Thread t2 = new StudentTask(s2, handler);
        Thread t3 = new StudentTask(s3, handler);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        System.out.println("Students scores logged successfully");
    }
}