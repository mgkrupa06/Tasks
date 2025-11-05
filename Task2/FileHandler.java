package Studentlogger;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    private String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }
    public synchronized void writeToFile(Student s) {
        try (FileWriter fw = new FileWriter(filePath, true)) {
            fw.write(s.getDetails() + "\n");
            System.out.println("Written: " + s.getDetails());
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e.getMessage());
        }
    }

}
