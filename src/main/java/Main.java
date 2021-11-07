import model.MyNode;

public class Main {
    public static void main (String[] args){
        MySaxParser parser = new MySaxParser();
        MyNode node = parser.parse();
        //System.out.println("MyNode " + node.toString());
        //System.out.println(parser.nodes);
    }
}
