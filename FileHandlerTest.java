package Studentlogger;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import org.junit.jupiter.api.*;

public class FileHandlerTest {
    private static final String TEST_FILE = "check_scores.csv";
    private FileHandler handler;

    @BeforeEach
    void setup() {
        handler = new FileHandler(TEST_FILE);
        new File(TEST_FILE).delete();
    }

    @Test
    void checkFileWrite() throws Exception {
        Student s = new Student("Tester", 999, 88);
        handler.writeToFile(s);
        List<String> lines = Files.readAllLines(new File(TEST_FILE).toPath());
        assertTrue(lines.get(0).contains("Tester,999,88"));
    }

    @Test
    void checkThreads() throws Exception {
        Student s1 = new Student("A", 1, 99);
        Student s2 = new Student("B", 2, 98);

        Thread t1 = new StudentTask(s1, handler);
        Thread t2 = new StudentTask(s2, handler);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        assertFalse(t1.isAlive());
        assertFalse(t2.isAlive());
    }
}