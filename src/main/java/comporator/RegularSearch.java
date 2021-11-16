package comporator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularSearch extends Searcher {
    @Override
    public boolean Search(String fileName) {
        Pattern pattern = Pattern.compile(getInputMask());
        Matcher matcher = pattern.matcher(fileName);
        if (matcher.find())
            return true;
        return false;
    }
}