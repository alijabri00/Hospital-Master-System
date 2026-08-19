public class HospitalDequeue {
    private Node frontNode;
    private Node backNode;

    private class Node {
        private String data;
        private Node next;
        private Node prev;
        private Node(String d) { data = d; }
    }

    public void addBack(String name) { 
        Node newNode = new Node(name);
        if (isEmpty()) { frontNode = newNode; } 
        else { backNode.next = newNode; newNode.prev = backNode; }
        backNode = newNode;
    }

    public void addFront(String name) { 
        Node newNode = new Node(name);
        if (isEmpty()) { backNode = newNode; } 
        else { frontNode.prev = newNode; newNode.next = frontNode; }
        frontNode = newNode;
    }

    public String removeFront() { 
        if (isEmpty()) return null;
        String result = frontNode.data;
        frontNode = frontNode.next;
        if (frontNode == null) backNode = null;
        else frontNode.prev = null;
        return result;
    }

    public String removeBack() { 
        if (isEmpty()) return null;
        String result = backNode.data;
        backNode = backNode.prev;
        if (backNode == null) frontNode = null;
        else backNode.next = null;
        return result;
    }

    public boolean isEmpty() { return frontNode == null; }
}