import Parser.SaxParser;
import arguments.ArgumentProcess;
import comporator.SearchFactoryBuilder;
import comporator.Searcher;
import org.junit.jupiter.api.Test;

class applicationTest {
    @Test
    void fullSearchTest(){
        ArgumentProcess argumentProcess = new ArgumentProcess(new String[] {"-f", "\\src\\test\\resources\\test-files.xml"});

        SearchFactoryBuilder searchFactoryBuilder = new SearchFactoryBuilder();
        Searcher searcher = searchFactoryBuilder.getSearcher(argumentProcess.getSearchType());
        searcher.setInputMask(argumentProcess.getInput());

        SaxParser parser = new SaxParser(argumentProcess.getFile_path(), searcher);
        parser.parse();
    }

    @Test
    void equalSearchTest(){
        ArgumentProcess argumentProcess = new ArgumentProcess(new String[] {"-f", "\\src\\test\\resources\\test-files.xml", "-s", "file-1498940214.xhtml"});

        SearchFactoryBuilder searchFactoryBuilder = new SearchFactoryBuilder();
        Searcher searcher = searchFactoryBuilder.getSearcher(argumentProcess.getSearchType());
        searcher.setInputMask(argumentProcess.getInput());

        SaxParser parser = new SaxParser(argumentProcess.getFile_path(), searcher);
        parser.parse();
    }

    @Test
    void maskSearchTest(){
        ArgumentProcess argumentProcess = new ArgumentProcess(new String[] {"-f", "\\src\\test\\resources\\test-files.xml", "-s", "*.java"});

        SearchFactoryBuilder searchFactoryBuilder = new SearchFactoryBuilder();
        Searcher searcher = searchFactoryBuilder.getSearcher(argumentProcess.getSearchType());
        searcher.setInputMask(argumentProcess.getInput());

        SaxParser parser = new SaxParser(argumentProcess.getFile_path(), searcher);
        parser.parse();
    }

    @Test
    void regularSearchTest(){
        ArgumentProcess argumentProcess = new ArgumentProcess(new String[] {"-f", "\\src\\test\\resources\\test-files.xml", "-S", ".*?[a-z]{4}-\\\\d+\\.[a-z]+"});

        SearchFactoryBuilder searchFactoryBuilder = new SearchFactoryBuilder();
        Searcher searcher = searchFactoryBuilder.getSearcher(argumentProcess.getSearchType());
        searcher.setInputMask(argumentProcess.getInput());

        SaxParser parser = new SaxParser(argumentProcess.getFile_path(), searcher);
        parser.parse();
    }

}
