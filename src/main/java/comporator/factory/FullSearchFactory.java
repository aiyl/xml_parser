package comporator.factory;

import comporator.FullSearch;
import comporator.Searcher;

public class FullSearchFactory extends SearcherFactory {
    @Override
    public Searcher createSearcher() {
        return new FullSearch();
    }
}
