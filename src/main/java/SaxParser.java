import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//https://javarush.ru/groups/posts/650-konkurs-osnovih-xml-dlja-java-programmista---chastjh-31-iz-3---sax

public class SaxParser extends DefaultHandler {
    private static ArrayList<Enities> enitiesArrayList = new ArrayList<Enities>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // Создание фабрики и образца парсера
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XMLHandler handler = new XMLHandler();
        parser.parse(new File("resources/file1.xml"), handler);
    }

    private static class XMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("employee")) {
                String name = attributes.getValue("name");
                //boolean job = attributes.getValue("job");
                enitiesArrayList.add(new Enities(name, false));
            }
        }
    }
}
