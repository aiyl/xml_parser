import model.MyNode;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) throws IOException {
        ArgumentProcess argumentProcess = new ArgumentProcess(args);
        MySaxParser parser = new MySaxParser(argumentProcess);
        ArrayList<MyNode> nodes = parser.parse();
        System.out.println(nodes.toString());
    }
}
