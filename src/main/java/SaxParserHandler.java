import model.MyNode;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class SaxParserHandler extends DefaultHandler {
    private  String currentTagName;
    private MyNode myNode = new MyNode();
    private boolean isFile = false;
    private boolean childIsOpen = false;
    private ArrayList<String> pathToFile= new ArrayList<String>();
    private ArrayList<MyNode> nodes = new ArrayList<>();

    public MyNode getMyNode(){
        return myNode;
    }

    public ArrayList<MyNode> getNodes() {
        return nodes;
    }

    @Override
    public void endDocument() throws SAXException {
        //myNode.setPathToFile(pathToFile);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        currentTagName = qName;
        String attGetValue = attributes.getValue(XConstant.IS_FILE);

        //System.out.println("start element " + qName + " " + attGetValue);

        if (attGetValue == null){
            return;
        }

        if (attGetValue.equals(XConstant.TRUE)){
            isFile = true;
        }

        switch (currentTagName){
            case XConstant.INCLUDE_NODE:
                if (isFile){
                    childIsOpen = true;
                }

        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        //System.out.println("End element " + qName);

        if (childIsOpen){
            myNode.setPathToFile(pathToFile);
            nodes.add(myNode);
            childIsOpen = false;
            System.out.println("path to file" + pathToFile);
            pathToFile.clear();
            System.out.println("path to file clear");
        }

        isFile = false;
        currentTagName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String name = new String(ch, start, length);
        if(currentTagName == null){
            return;
        }

        if(currentTagName.equals(XConstant.ACTIVE_NODE)){
            myNode.setName(new String(ch, start, length));
            if (pathToFile != null)
                pathToFile.add(name);
        }


        //System.out.println("characters " + new String(ch, start, length));

    }
}
