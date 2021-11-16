package Parser;

import comporator.Searcher;
import constant.XConstant;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParserHandler extends DefaultHandler {
    private  String currentTagName;
    private String myFile;
    private Node node = null;
    private boolean isFile = false;
    private String currFolder = "";
    private Searcher startSearch;

    public SaxParserHandler(Searcher startSearch){
        this.startSearch = startSearch;
    }


    private String getParent(){
        String str = currFolder.substring(0, currFolder.lastIndexOf(XConstant.SPLIT_DIR));
        return str.substring(0, str.lastIndexOf(XConstant.SPLIT_DIR) + 1);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTagName = qName;
        String attGetValue = attributes.getValue(XConstant.IS_FILE);

        if (attGetValue == null){
            return;
        }

        if (attGetValue.equals(XConstant.TRUE)){
            isFile = true;
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String name = new String(ch, start, length);
        if(currentTagName == null){
            return;
        }

        if(currentTagName.equals(XConstant.ACTIVE_NODE) && !isFile){
            currFolder += name;
            if (!name.equals("/"))
                currFolder += '/';

        }

        if(currentTagName.equals(XConstant.ACTIVE_NODE) && isFile){
            myFile = currFolder;
            if (startSearch.Search(name)) {
                node = new Node();
                node.setName(name);
                node.setPathToFile(myFile);
                System.out.println(node.toString());
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals(XConstant.CHILDREN_NODE)){
            currFolder = this.getParent();
        }
        if(currentTagName == null){
            return;
        }

        isFile = false;
        currentTagName = null;
    }

}
