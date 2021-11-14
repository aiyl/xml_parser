package comporator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaskSearch extends Searcher{
    private Pattern pattern;

    @Override
    public boolean Search(String fileName) {
        String mask = processingMask(getInputMask());
        pattern = Pattern.compile(mask);
        Matcher m = pattern.matcher(fileName);
        return m.matches();
    }

    private String processingMask(String mask){
        StringBuilder stringMask = new StringBuilder();
        char[] chars = mask.toCharArray();
        for (char ch: chars){
            switch (ch){
                case '.'    : stringMask.append("\\."); break;
                case '?'    : stringMask.append("."); break;
                case  '*'   : stringMask.append(".*"); break;
                default     : stringMask.append(ch); break;
            }
        }
        return stringMask.toString();
    }


}
