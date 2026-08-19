public class DecisionTree {
    private BinaryNode root;
    private BinaryNode currentNode;

    public DecisionTree(BinaryNode root) {
        this.root = root;
        this.currentNode = root;
    }

    public void reset() {
        currentNode = root;
    }

    public Object getCurrentData() {
        return currentNode.getData();
    }

    public boolean isAnswer() {
        return currentNode.isLeaf();
    }

    public void advanceToNo() {
        if (currentNode.getLeftChild() != null)
            currentNode = currentNode.getLeftChild();
    }

    public void advanceToYes() {
        if (currentNode.getRightChild() != null)
            currentNode = currentNode.getRightChild();
    }
}