package comporator;

public abstract class Searcher {
    private String inputMask ;//= ".*?[a-z]{4}-\\d+\\.[a-z]+";

    public abstract boolean Search(String inputMask);

    public void setInputMask(String inputMask) {
        this.inputMask = inputMask;
    }

    public String getInputMask() {
        return inputMask;
    }

}
