package ucsc;

public class TreeTest {
    
    public static void main(String[] args) {
        String name1 = "Alpha";
        int val_1 = 10;
        Tree tree = new Tree(name1,val_1);
        tree.root.child = new Node("Beta",7);
        tree.root.child.sibling = new Node("Cairo",9);
        tree.root.child.sibling.sibling = new Node("Dunkirk",45);
        tree.root.child.child = new Node("Ellen",12);
        tree.root.child.sibling.child = new Node("Fella",22);
        tree.traverse(tree.root);
        
    }
    
}
