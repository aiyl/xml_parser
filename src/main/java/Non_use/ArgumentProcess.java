package Non_use;

import java.io.File;
import java.io.IOException;

public class ArgumentProcess {
    /*public Non_use.ArgumentProcess(String[] args) throws Non_use.ArgumentException, IOException {
        validator(args);
        storeParams(args);
    }*/
    private String fileExists(String fileName) throws ArgumentException, IOException {
        String path = System.getProperty("user.dir");
        File f = new File(path + File.separator + fileName);
        if(f.exists() && f.isFile()){
            return f.getAbsolutePath();
        }else{
            throw new ArgumentException("input file doesn't exists");
        }

    }
}
