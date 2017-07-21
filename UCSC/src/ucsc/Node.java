package ucsc;

public class Node {
        String name;
        Node child, sibling;
        int val;
        
        public Node(String name, int val) {
            this.name = name;
            this.val = val;
            child = null;
            sibling = null;
        }
        
        public String getName(){
            return name;
        }
        
        public Node getChild() {
            return child;
        }
        
        public Node getSibling() {
            return sibling;
        }
        
        public void setChild(String name, int val) {
            Node newNode = new Node(name, val);
            this.child = newNode;
        }
        
        public void setSibling(String name, int val) {
            Node newNode = new Node(name,val);
            this.sibling = newNode;
        }
}
