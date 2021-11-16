package arguments;
import Exception.ArgumentException;
import constant.XConstant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ArgumentProcessTest {
    private String path = "\\src\\test\\resources\\test-files.xml";
    private ArgumentProcess argumentProcess = new ArgumentProcess(new String[]{"-f", path});

    @Test
    void getFilePathFull() {
        String actual = argumentProcess.getFile_path();
        String expected = "D:\\download\\xmlParser\\src\\test\\resources\\test-files.xml";
        assertEquals(expected, actual);
    }

    @Test
    void getSearchTypeFull() {
        XConstant.SearchType actual = argumentProcess.getSearchType();
        XConstant.SearchType expected = XConstant.SearchType.Full;
        assertEquals(actual, expected);
    }

    @Test
    void getInputFull() {
        String actual = argumentProcess.getInput();
        assertEquals(null, actual);
    }
}