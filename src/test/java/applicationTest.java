import Parser.SaxParser;
import arguments.ArgumentProcess;
import comporator.SearchFactoryBuilder;
import comporator.Searcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class applicationTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void fullSearchTest(){
        ArgumentProcess argumentProcess = new ArgumentProcess(new String[] {"-f", "\\src\\test\\resources\\test-files.xml"});

        SearchFactoryBuilder searchFactoryBuilder = new SearchFactoryBuilder();
        Searcher searcher = searchFactoryBuilder.getSearcher(argumentProcess.getSearchType());
        searcher.setInputMask(argumentProcess.getInput());

        SaxParser parser = new SaxParser(argumentProcess.getFile_path(), searcher);
        parser.parse();
        String expected = "/file-776194140.xml" + System.lineSeparator() +
                "/dir-880176375/file-1073842118.java" + System.lineSeparator() +
                "/dir-880176375/dir-2145307015/file-1498940214.xhtml";

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void equalSearchTest(){
        ArgumentProcess argumentProcess = new ArgumentProcess(new String[] {"-f", "\\src\\test\\resources\\test-files.xml", "-s", "file-1498940214.xhtml"});

        SearchFactoryBuilder searchFactoryBuilder = new SearchFactoryBuilder();
        Searcher searcher = searchFactoryBuilder.getSearcher(argumentProcess.getSearchType());
        searcher.setInputMask(argumentProcess.getInput());

        SaxParser parser = new SaxParser(argumentProcess.getFile_path(), searcher);
        parser.parse();
        assertEquals("/dir-880176375/dir-2145307015/file-1498940214.xhtml", outputStreamCaptor.toString().trim());

    }

    @Test
    void maskSearchTest(){
        ArgumentProcess argumentProcess = new ArgumentProcess(new String[] {"-f", "\\src\\test\\resources\\test-files.xml", "-s", "*.java"});

        SearchFactoryBuilder searchFactoryBuilder = new SearchFactoryBuilder();
        Searcher searcher = searchFactoryBuilder.getSearcher(argumentProcess.getSearchType());
        searcher.setInputMask(argumentProcess.getInput());

        SaxParser parser = new SaxParser(argumentProcess.getFile_path(), searcher);
        parser.parse();
        assertEquals("/dir-880176375/file-1073842118.java", outputStreamCaptor.toString().trim());
    }

    @Test
    void regularSearchTest(){
        ArgumentProcess argumentProcess = new ArgumentProcess(new String[] {"-f", "\\src\\test\\resources\\test-files.xml", "-S", ".*?[a-z]{4}-\\d+.[a-z]+"});

        SearchFactoryBuilder searchFactoryBuilder = new SearchFactoryBuilder();
        Searcher searcher = searchFactoryBuilder.getSearcher(argumentProcess.getSearchType());
        searcher.setInputMask(argumentProcess.getInput());

        SaxParser parser = new SaxParser(argumentProcess.getFile_path(), searcher);
        parser.parse();
        String expected = "/file-776194140.xml" + System.lineSeparator() +
                          "/dir-880176375/file-1073842118.java" + System.lineSeparator() +
                          "/dir-880176375/dir-2145307015/file-1498940214.xhtml";

        assertEquals(expected, outputStreamCaptor.toString().trim());

    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}
