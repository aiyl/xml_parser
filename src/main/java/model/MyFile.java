package model;
import java.io.File;
import java.util.ArrayList;

public class MyFile{
    String path;

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String getParent(){
        String str = path.substring(0, path.lastIndexOf(XConstant.SPLIT_DIR));
        return str.substring(0, str.lastIndexOf(XConstant.SPLIT_DIR) + 1);
    }
}
