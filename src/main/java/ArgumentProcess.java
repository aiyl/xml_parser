import Exception.ArgumentException;
import comporator.ParamsStore;
import comporator.SearchType;
import comporator.Searcher;
import model.XConstant;
import java.io.File;
import java.io.IOException;

public class ArgumentProcess {
    private String file_path, input;
    private SearchType searchType;
    private ParamsStore paramsStore;

    public ArgumentProcess(String[] args) throws ArgumentException, IOException {
        switch (args.length){
            case 2:
                this.file_path = fileExists(args[1]);
                paramsStore = new ParamsStore(file_path);
                break;
            case 4:
                this.file_path = fileExists(args[1]);
                if (maskTypeExist(args[2])){
                    this.input = args[3];
                    this.searchType = searchType(args[2], args[3]);
                    paramsStore = new ParamsStore(searchType, input, file_path);
                }
                break;
            default:
                throw new ArgumentException("not enough or too much argument");
        }
    }

    public Searcher getSearchFromParamsStore() {
        return paramsStore.getSearcher();
    }

    public String getFile_path() {
        return file_path;
    }

    private SearchType searchType(String key, String input){
        if(key.equals(XConstant.KEY_MACK) ){
            if(input.contains("file"))
                return SearchType.Full;
            if(input.contains("*"))
                return  SearchType.Simple;
        }
        else {
            return SearchType.Regular;
        }
        throw new ArgumentException("can't resolve search type" );
    }

    private boolean maskTypeExist(String s){
        if (s.equals(XConstant.KEY_MACK_REGULAR) || s.equals(XConstant.KEY_MACK))
            return true;
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
