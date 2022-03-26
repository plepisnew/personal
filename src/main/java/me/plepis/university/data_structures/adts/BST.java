package me.plepis.university.data_structures.adts;

public class BST<Key extends Comparable<Key>> {

    Node root;

    static int level = 1;

    private class Node{

        private Node left;
        private Node right;
        private Key key;

        Node(Node left, Node right, Key key){
            this.left = left;
            this.right = right;
            this.key = key;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Key getKey() {
            return key;
        }

        public void setKey(Key key) {
            this.key = key;
        }

        public String toString(){
            String left = this.left == null ? "null" : this.left.toString();
            String right = this.right == null ? "null" : this.right.toString();
            String indent = " ".repeat(1);
            level++;
            return "Key: " + this.key + "\n" + indent + "Left: " + left + "\n" + indent + "Right: " + right;
        }
    }

    private Node get(Node tree, Key key){
        if(tree == null){
            return null;
        }
        if(tree.getKey().compareTo(key) > 0){
            return get(tree.left, key);
        }else if(tree.getKey().compareTo(key) < 0){
            return get(tree.right, key);
        }else{
            return tree;
        }
    }

    private Node put(Node tree, Key key){
        if(this.root == null){
            this.root = new Node(null, null, key);
            return root;
        }

        if(tree == null){
            return new Node(null, null, key);
        }
        if(tree.getKey().compareTo(key) > 0){
            tree.setLeft(put(tree.getLeft(), key));
        }else if(tree.getKey().compareTo(key) < 0){
            tree.setRight(put(tree.getRight(), key));
        }else{
            return tree;
        }
        return tree;
    }

    private void putAll(Key... keys){
        for(Key key: keys){
            put(this.root, key);
        }
    }

    private void printSorted(Node tree){
        if(tree != null){
            printSorted(tree.left);
            System.out.print(tree.key + " ");
            printSorted(tree.right);
        }
    }

    private void printValues(){
        printSorted(this.root);
        System.out.println();
    }

    private void printTree(){
        System.out.println(this);
    }

    public BST(Key key){
        this.root = new Node(null, null, key);
    }

    public BST(){

    }

    @Override
    public String toString(){
        return this.root.toString();
    }

    public static<Key extends Comparable<Key>> BST<Key> of(Key... keys){
        BST<Key> bst = new BST<>();
        bst.putAll(keys);
        return bst;
    }

    public static void main(String[] args) {

//        BST<Integer> bst = new BST<>(9);
//        bst.putAll(5, 11, 3, 20, 10, 4, 2);
//        bst.printTree();
        BST<Integer> bst = BST.of(7, 6, 5, 4, 9, 8, 10);
        bst.put(bst.root, 11);
        bst.printTree();
        bst.printValues();
//        print(bst.get(bst.root, 5));
    }

    static<T> void print(T stuff){
        System.out.println(stuff);
    }
}
