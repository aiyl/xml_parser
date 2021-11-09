import Non_use.ArgumentException;
import comporator.Params;
import comporator.Searcher;
import model.XConstant;
import java.io.File;
import java.io.IOException;

public class ArgumentProcess {
    private String file_path, maskType, input;

    public ArgumentProcess(String[] args) throws ArgumentException, IOException {

        switch (args.length){
            case 2:
                this.file_path = fileExists(args[1]);
                break;
            case 4:
                this.file_path = fileExists(args[1]);
                this.maskType = maskTypeExist(args[2]);
                this.input = args[3];
                break;
            default:
                throw new ArgumentException("not enough or too much argument");
        }

        Params params = new Params();

    }

    public String getFile_path() {
        return file_path;
    }


    private String maskTypeExist(String s){
        if (s.equals(XConstant.KEY_MACK_REGULAR) || s.equals(XConstant.KEY_MACK))
            return s;
        else
            throw new ArgumentException("not supported key: " + s);
    }

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
