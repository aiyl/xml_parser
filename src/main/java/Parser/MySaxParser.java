package Parser;

import comporator.Searcher;
import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
//https://javarush.ru/groups/posts/650-konkurs-osnovih-xml-dlja-java-programmista---chastjh-31-iz-3---sax

public class MySaxParser {
    private String xml_file_path;
    private Searcher comporator;
    public MySaxParser(String xml_file_path, Searcher searcher){
        this.xml_file_path = xml_file_path;
        this.comporator= searcher;
    }

    public void parse(){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler(comporator);
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            System.out.println("Open Sax parser error" + e.toString());
            //return null;
        }

        File file = new File(xml_file_path);
        try {
            parser.parse(file, handler);
        } catch (SAXException e) {
            System.out.println("Sax parsing error" + e.toString());
            //return null;
        } catch (IOException e) {
            System.out.println("IO parsing error" + e.toString());
            //return null;
        }
    }
}
