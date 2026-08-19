public class BinaryNode {
    private Object data;
    private BinaryNode leftChild;
    private BinaryNode rightChild;

    public BinaryNode(Object data) {
        this(data, null, null);
    }

    public BinaryNode(Object data, BinaryNode left, BinaryNode right) {
        this.data = data;
        this.leftChild = left;
        this.rightChild = right;
    }

    public Object getData() { return data; }
    public BinaryNode getLeftChild() { return leftChild; }
    public BinaryNode getRightChild() { return rightChild; }

    public boolean isLeaf() {
        return (leftChild == null) && (rightChild == null);
    }
}