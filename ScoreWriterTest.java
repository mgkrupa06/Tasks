package Studentlogger;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import org.junit.jupiter.api.*;

public class ScoreWriterTest {
    private static final String TEST_FILE = "test_scores.csv";
    private ScoreWriter writer;

    @BeforeEach
    void setup() {
        writer = new ScoreWriter(TEST_FILE);
        new File(TEST_FILE).delete();
    }

    @Test
    void testWriteScoreToFile() throws Exception {
        Student s = new Student("TestStudent", 999, 88);
        writer.writeScore(s);

        List<String> lines = Files.readAllLines(new File(TEST_FILE).toPath());
        assertTrue(lines.get(0).contains("TestStudent,999,88"));
    }

    @Test
    void testThreadCompletion() throws Exception {
        Student s1 = new Student("A", 1, 90);
        Student s2 = new Student("B", 2, 80);

        Thread t1 = new StudentThread(s1, writer);
        Thread t2 = new StudentThread(s2, writer);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        assertFalse(t1.isAlive());
        assertFalse(t2.isAlive());
    }
}