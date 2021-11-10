package comporator.factory;

import comporator.Searcher;
import comporator.SimpleSearch;

public class SimpleSearchFactory extends SearcherFactory {
    @Override
    public Searcher createSearcher() {
        return new SimpleSearch();
    }
}
