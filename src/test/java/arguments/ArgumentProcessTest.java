package arguments;
import Exception.ArgumentException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ArgumentProcessTest {
    private String path = System.getProperty("user.dir") + "\\src\\test\\resources\\test-files.xml";
    ArgumentProcess argumentProcess = new ArgumentProcess(new String[]{"-f", "test-files.xml"});

    @Test
    void getFilePath() {
        String actual = argumentProcess.getFile_path();
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    void getSearchType() {
    }

    @Test
    void getInput() {
    }
}