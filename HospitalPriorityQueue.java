public class HospitalPriorityQueue {
    private Node frontNode;

    private class Node {
        private String patientName;
        private int priority; // 1 = Emergency, 2 = Normal, 3 = Routine
        private Node next;

        private Node(String name, int p) {
            this.patientName = name;
            this.priority = p;
            this.next = null;
        }
    }

    public void enqueue(String name, int priority) {
        Node newNode = new Node(name, priority);
        if (frontNode == null || priority < frontNode.priority) {
            newNode.next = frontNode;
            frontNode = newNode;
        } else {
            Node current = frontNode;
            while (current.next != null && current.next.priority <= priority) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public String dequeue() {
        if (frontNode == null) return null;
        String result = frontNode.patientName;
        frontNode = frontNode.next;
        return result;
    }

    public boolean isEmpty() {
        return frontNode == null;
    }
}