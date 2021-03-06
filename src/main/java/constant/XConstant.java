package constant;

public class XConstant {
    public static final String KEY_MACK_REGULAR = "-S";
    public static final String KEY_MACK = "-s";
    public static final String IS_FILE = "is-file";
    public static final String TRUE = "true";
    public static final String ACTIVE_NODE = "name";
    public static final String CHILDREN_NODE = "children";
    public static final String SPLIT_DIR = "/";
    public static final String APOSTROPHE1 = "‘";
    public static final String APOSTROPHE2 = "’";

    public enum SearchType {
        Equals, // конкретный файл
        Full, // ввесь список файлов
        Regular, //регулярные выражения
        Mask // расширешие
    }

}

