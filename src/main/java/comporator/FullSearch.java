package comporator;

import model.SearchType;
import model.XConstant;

public class FullSearch extends Searcher {
    private String inputMask = super.getInputMask();
    @Override
    public boolean Search(String fileName) {
        return fileName.equals(inputMask);
    }
}
