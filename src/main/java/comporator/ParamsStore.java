package comporator;
import Exception.ArgumentException;
import comporator.factory.*;

public class ParamsStore {
    Searcher searcher;
    private SearchType key;
    String inputMask;

    public ParamsStore(SearchType key, String inputMask, String xmlFilePath){
        this.key = key;
        this.inputMask = inputMask;
    }
    public ParamsStore(String xmlFilePath){
        searcher = null;
    }

    public Searcher getSearcher() {
        SearcherFactory searcherFactory = createSearcherByArg(key);
        searcher = searcherFactory.createSearcher();
        searcher.setInputMask(inputMask);
        return searcher;
    }

    private static SearcherFactory createSearcherByArg(SearchType keyMask) throws ArgumentException {
        switch (keyMask){
            case Simple:
                return new SimpleSearchFactory();
            case Full:
                return new FullSearchFactory();
            case Regular:
                return new RegularSearchFactory();
        }
        throw new ArgumentException("not supported key:");
    }
}
