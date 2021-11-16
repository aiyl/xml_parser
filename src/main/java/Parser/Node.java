package Parser;

public class Node {
    private String fileName;
    private String pathToFile = null;

    public void setName(String name) {
        this.fileName = name;
    }
    public void setPathToFile(String pathToFile){
        this.pathToFile = pathToFile;
    }


    @Override
    public String toString() {
        return  pathToFile + fileName + "\n";
    }

}
