package arguments;

import Exception.ArgumentException;
import constant.XConstant.SearchType;
import constant.XConstant;
import java.io.File;

public class ArgumentProcess {
    private String file_path, input;
    private SearchType searchType;

    public  ArgumentProcess(String[] args) throws ArgumentException{
        validator(args);
    }

    private void validator(String[] args){
        switch (args.length){
            case 2:
                this.file_path = fileExists(args[1]);
                searchType = SearchType.Full;
                break;
            case 4:
                this.file_path = fileExists(args[1]);
                if (maskTypeExist(args[2])){
                    this.input = args[3];
                    this.searchType = searchType(args[2], args[3]);
                }
                break;
            default:
                throw new ArgumentException("not enough or too much argument");
        }
    }



    private SearchType searchType(String key, String input){
        if(key.equals(XConstant.KEY_MACK) ){
            if(input.contains("*"))
                return  SearchType.Mask;
            if(input.contains("file"))
                return SearchType.Equals;
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

    private String fileExists(String fileName) throws ArgumentException{
        String path = System.getProperty("user.dir");
        File f = new File(path + File.separator + fileName);
        if(f.exists() && f.isFile()){
            return f.getAbsolutePath();
        }else{
            throw new ArgumentException("input file doesn't exists " + fileName);
        }

    }

    public String getFile_path() {
        return file_path;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public String getInput() {
        return input;
    }
}
