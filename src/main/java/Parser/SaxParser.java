package Parser;

import comporator.Searcher;
import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxParser {
    private String xml_file_path;
    private Searcher comporator;
    public SaxParser(String xml_file_path, Searcher searcher){
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
        }

        File file = new File(xml_file_path);
        try {
            parser.parse(file, handler);
        } catch (SAXException e) {
            System.out.println("Sax parsing error" + e.toString());
        } catch (IOException e) {
            System.out.println("IO parsing error" + e.toString());
        }
    }
}
