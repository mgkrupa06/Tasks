package Studentlogger;

import java.io.FileWriter;
import java.io.IOException;

public class ScoreWriter {
    private final String fileName;

    public ScoreWriter(String fileName) {
        this.fileName = fileName;
    }

    // synchronized ensures thread safety while writing
    public synchronized void writeScore(Student s) {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write(s.toCSV() + "\n");
            System.out.println("Written: " + s.toCSV());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
