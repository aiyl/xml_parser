import model.MyNode;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//https://javarush.ru/groups/posts/650-konkurs-osnovih-xml-dlja-java-programmista---chastjh-31-iz-3---sax

public class MySaxParser /*extends DefaultHandler */ {
    public ArrayList<MyNode> nodes = new ArrayList<>();
    /* private static ArrayList<Non_use.Enities> enitiesArrayList = new ArrayList<Non_use.Enities>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // Создание фабрики и образца парсера
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XMLHandler handler = new XMLHandler();
        parser.parse(new File("src/main/resources/test-files.xml"), handler);
    }

    private static class XMLHandler extends DefaultHandler {
        private String name, lastElementName;
        private boolean isFile;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String information = new String(ch, start, length);

            information = information.replace("\n", "").trim();

            if (!information.isEmpty()) {
                if (lastElementName.equals("name"))
                    name = information;
                if (lastElementName.equals("child"))
                    isFile = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (name != null && !name.isEmpty() )  {
                enitiesArrayList.add(new Non_use.Enities(name, isFile));
                name = null;
                isFile = false;
            }
        }
    } */

    public MyNode parse(){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            System.out.println("Open Sax parser error" + e.toString());
            return null;
        }

        File file = new File("src/main/resources/test-files.xml");
        try {
            parser.parse(file, handler);
        } catch (SAXException e) {
            System.out.println("Sax parsing error" + e.toString());
            return null;
        } catch (IOException e) {
            System.out.println("IO parsing error" + e.toString());
            return null;
        }
        nodes = handler.getNodes();
        return handler.getMyNode();
    }
}
