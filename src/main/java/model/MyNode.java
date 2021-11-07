package model;

import java.util.ArrayList;

public class MyNode {
    private String fileName;
    private ArrayList<String> pathToFile = new ArrayList <String>();

    public void setName(String name) {
        this.fileName = name;
    }

    public void setPathToFile(ArrayList<String> pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public String toString() {
        return "MyNode{"+
                "name'" + fileName + '\'' +
                ", pathToFile" + pathToFile +
                '}';
    }
}
