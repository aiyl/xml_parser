package comporator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleSearch extends Searcher {
    private String inputMask = super.getInputMask();
    @Override
    public boolean Search(String fileName) {
        Pattern pattern = Pattern.compile(inputMask);
        Matcher matcher = pattern.matcher(fileName);
        if (matcher.find())
            return true;
        return false;
    }
}
