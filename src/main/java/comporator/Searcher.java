package comporator;

import Non_use.NodeParser;
import model.SearchType;

import java.util.regex.Pattern;

public abstract class Searcher {
    private String inputMask = ".*?[a-z]{4}-\\d+\\.[a-z]+";
    //protected abstract SearchType searchType();
    public abstract boolean Search(String fileName);
    public String getInputMask() {
        return inputMask;
    }

    public void setInputMask(String inputMask) {
        this.inputMask = inputMask;
    }
}
