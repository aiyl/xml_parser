package comporator.factory;

import comporator.RegularSearch;
import comporator.Searcher;

public class RegularSearchFactory extends SearcherFactory {
    @Override
    public Searcher createSearcher() {
        return new RegularSearch();
    }
}
