package comporator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EqualsSearch extends Searcher {
    private String inputMask = super.getInputMask();
    @Override
    public boolean Search(String fileName) {
        return fileName.equals(inputMask);
    }
}
