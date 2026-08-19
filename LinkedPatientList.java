public class LinkedPatientList implements ListInterface {
    private Node firstNode;
    private int length;

    private class Node {
        private Object data;
        private Node next;
        private Node(Object d) { this(d, null); }
        private Node(Object d, Node n) { data = d; next = n; }
    }

    public void add(Object newEntry) { add(length + 1, newEntry); }

    public boolean add(int position, Object newEntry) {
        if (position >= 1 && position <= length + 1) {
            Node newNode = new Node(newEntry);
            if (position == 1) {
                newNode.next = firstNode;
                firstNode = newNode;
            } else {
                Node nodeBefore = getNodeAt(position - 1);
                newNode.next = nodeBefore.next;
                nodeBefore.next = newNode;
            }
            length++;
            return true;
        }
        return false;
    }

    public Object remove(int position) {
        if (position >= 1 && position <= length) {
            Object result;
            if (position == 1) {
                result = firstNode.data;
                firstNode = firstNode.next;
            } else {
                Node nodeBefore = getNodeAt(position - 1);
                Node nodeToRemove = nodeBefore.next;
                result = nodeToRemove.data;
                nodeBefore.next = nodeToRemove.next;
            }
            length--;
            return result;
        }
        return null;
    }

    public Object replace(int position, Object newEntry) {
        if (position >= 1 && position <= length) {
            Node desiredNode = getNodeAt(position);
            Object oldEntry = desiredNode.data;
            desiredNode.data = newEntry;
            return oldEntry;
        }
        return null;
    }

    public Object getEntry(int position) {
        if (position >= 1 && position <= length) return getNodeAt(position).data;
        return null;
    }

    private Node getNodeAt(int pos) {
        Node curr = firstNode;
        for (int i = 1; i < pos; i++) curr = curr.next;
        return curr;
    }

    public void display() {
        Node curr = firstNode;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public int getLength() { return length; }
    public boolean isEmpty() { return length == 0; }
    public boolean isFull() { return false; }
    public void clear() { firstNode = null; length = 0; }
}