public class LQueue implements QueueInterface {
    private Node frontNode;
    private Node backNode;
    private class Node {
        private Object data;
        private Node next;
        private Node(Object d, Node n) { data = d; next = n; }
    }
    public void enqueue(Object newEntry) {
        Node newNode = new Node(newEntry, null);
        if (isEmpty()) frontNode = newNode;
        else backNode.next = newNode;
        backNode = newNode;
    }
    public Object dequeue() {
        Object result = getFront();
        if (frontNode != null) {
            frontNode = frontNode.next;
            if (frontNode == null) backNode = null;
        }
        return result;
    }
    public Object getFront() { return isEmpty() ? null : frontNode.data; }
    public boolean isEmpty() { return frontNode == null; }
    public void clear() { frontNode = null; backNode = null; }
}

