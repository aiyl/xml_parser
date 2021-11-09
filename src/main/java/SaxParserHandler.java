import comporator.FullSearch;
import comporator.RegularSearch;
import comporator.Searcher;
import comporator.SimpleSearch;
import model.MyFile;
import model.MyNode;
import model.XConstant;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;

public class SaxParserHandler extends DefaultHandler {
    private  String currentTagName;
    private MyFile myFile;
    private MyNode myNode = null;
    private boolean isFile = false;
    private ArrayList<MyNode> nodes = new ArrayList<>();
    private String currFolder = "";

    private FullSearch fullSearch = new FullSearch();
    private SimpleSearch simpleSearch = new SimpleSearch();
    private RegularSearch regularSearch = new RegularSearch();

    public ArrayList<MyNode> getNodes() {
        return nodes;
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
            myFile = new MyFile();
            myFile.setPath(currFolder);
            myNode = new MyNode();
            //if (fullSearch.Search(name)) {
            if (regularSearch.Search(name)) {
                myNode.setName(name);
                myNode.setPathToFile(myFile);
                nodes.add(myNode);
            }
            //System.out.println(myNode.toString());
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
