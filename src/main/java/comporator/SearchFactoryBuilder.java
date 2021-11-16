package comporator;
import Exception.ArgumentException;
import constant.XConstant;

public class SearchFactoryBuilder {
    public static   Searcher getSearcher(XConstant.SearchType type){
        switch (type){
            case Full: return new FullSearch();
            case Regular: return new RegularSearch();
            case Equals: return new EqualsSearch();
            case Mask: return new MaskSearch();
            default: throw new ArgumentException("can't resolve mask type" + type);
        }
    }
}
