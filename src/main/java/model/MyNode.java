package model;

public class MyNode {
    private String fileName;
    private MyFile pathToFile = null;

    public void setName(String name) {
        this.fileName = name;
    }
    public void setPathToFile(MyFile pathToFile){
        this.pathToFile = pathToFile;
    }


    @Override
    public String toString() {
        return "MyNode{"+
                "name'" + fileName + '\'' +
                ", path To file" + pathToFile.getPath() +
                '}' + "\n";
    }

}
