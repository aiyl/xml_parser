package comporator;

public class FullSearch extends Searcher {
    private String inputMask = super.getInputMask();
    @Override
    public boolean Search(String fileName) {
        return fileName.equals(inputMask);
    }
}
