import Parser.MySaxParser;
import arguments.ArgumentProcess;
import comporator.SearchFactoryBuilder;
import comporator.Searcher;

import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {
        ArgumentProcess argumentProcess = new ArgumentProcess(args);

        SearchFactoryBuilder searchFactoryBuilder = new SearchFactoryBuilder();
        Searcher searcher = searchFactoryBuilder.getSearcher(argumentProcess.getSearchType());
        searcher.setInputMask(argumentProcess.getInput());

        MySaxParser parser = new MySaxParser(argumentProcess.getFile_path(), searcher);
        parser.parse();
    }
}
