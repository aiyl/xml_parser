package comporator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EqualsSearch extends Searcher {

    @Override
    public boolean Search(String fileName) {
        String mask = getInputMask();
        return fileName.equals(mask);
    }

}
