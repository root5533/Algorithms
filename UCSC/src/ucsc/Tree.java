
package ucsc;

import java.util.ArrayList;

public class Tree {
    
    Node root;
    
    public Tree(String name, int val) {
        Node node = new Node(name,val);
        this.root = node;
    }
    
    public void traverse(Node n) {
        Node pointer = n;
        while (pointer != null) {
            System.out.println(pointer.getName());
            if (pointer.getSibling() != null) {
                traverse(pointer.getSibling());
            }
            pointer = pointer.getChild();
        }
    }
    
    public Node search(String name) {        
        ArrayList<Node> array = new ArrayList<Node>();
        array.add(root);
        while (!array.isEmpty()) {
            Node x = array.remove(0);
            if (x.getName().equals(name)) {
                return x;
            }
            while (x != null) {
                array.add(x.sibling);
                x = x.sibling;
            }

        }
    }
    
    
}
