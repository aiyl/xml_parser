package model;

import java.util.ArrayList;

public class MyNode {
    private String fileName;
   //private ArrayList<MyNode> children = new ArrayList <MyNode>();
    private MyFile pathToFile = null;

    public void setName(String name) {
        this.fileName = name;
    }
    public void setPathToFile(MyFile pathToFile){
        this.pathToFile = pathToFile;
    }

    /*public void setChildren(ArrayList<MyNode> children) {
        this.children = children;
    }*/


    @Override
    public String toString() {
        return "MyNode{"+
                "name'" + fileName + '\'' +
                ", path To file" + pathToFile.getPath() +
                '}';
    }

}
