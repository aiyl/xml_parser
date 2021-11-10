import comporator.Searcher;
import model.MyNode;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//https://javarush.ru/groups/posts/650-konkurs-osnovih-xml-dlja-java-programmista---chastjh-31-iz-3---sax

public class MySaxParser {
    private String xml_file_path;
    private Searcher startSearch;
    MySaxParser(ArgumentProcess args){
        this.xml_file_path = args.getFile_path();
        this.startSearch = args.getSearchFromParamsStore();
    }

    public ArrayList<MyNode> parse(){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler(startSearch);
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            System.out.println("Open Sax parser error" + e.toString());
            return null;
        }

        File file = new File(xml_file_path);
        try {
            parser.parse(file, handler);
        } catch (SAXException e) {
            System.out.println("Sax parsing error" + e.toString());
            return null;
        } catch (IOException e) {
            System.out.println("IO parsing error" + e.toString());
            return null;
        }
        return handler.getNodes();
    }
}
