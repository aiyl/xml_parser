package Parser;

import comporator.*;
import org.junit.jupiter.api.Test;

class SaxParserHandlerTest {
    private String path = System.getProperty("user.dir");
    private String xml_file = path+ "\\src\\test\\resources\\test-files.xml";

    @Test
    void fullSearchTest () {
        Searcher fullSearch = new FullSearch();
        fullSearch.setInputMask("");
        SaxParser parser = new SaxParser(xml_file, fullSearch);
        parser.parse();
    }

    @Test
    void equalsSearchTest(){
        Searcher equalsSearch = new EqualsSearch();
        equalsSearch.setInputMask("file-1272239243.txt");
        SaxParser parser = new SaxParser(xml_file, equalsSearch);
        parser.parse();

    }

    @Test
    void maskSearchTest(){
        Searcher maskSearch = new MaskSearch();
        maskSearch.setInputMask("*.java");
        SaxParser parser = new SaxParser(xml_file, maskSearch);
        parser.parse();
    }

    @Test
    void regularSearchTest (){
        Searcher regularSearch = new RegularSearch();
        regularSearch.setInputMask(".*?[a-z]{4}-\\d+.[a-z]+");
        SaxParser parser = new SaxParser(xml_file, regularSearch);
        parser.parse();
    }
}