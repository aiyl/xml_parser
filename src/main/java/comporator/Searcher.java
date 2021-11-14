package comporator;

public abstract class Searcher {
    private String inputMask;

    public abstract boolean Search(String inputMask);

    public String getInputMask() {
        return inputMask;
    }

    public void setInputMask(String inputMask) {
        this.inputMask = inputMask;
    }
}
