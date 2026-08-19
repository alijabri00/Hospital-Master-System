import java.util.Arrays;

public class ArrayPatientList implements ListInterface {
    private Object[] entry;
    private int length;
    private static final int DEFAULT_CAPACITY = 25;

    public ArrayPatientList() {
        entry = new Object[DEFAULT_CAPACITY];
        length = 0;
    }

    public void add(Object newEntry) { add(length + 1, newEntry); }

    public boolean add(int position, Object newEntry) {
        if (position >= 1 && position <= length + 1) {
            if (isFull()) doubleArray();
            makeRoom(position);
            entry[position - 1] = newEntry;
            length++;
            return true;
        }
        return false;
    }

    public Object remove(int position) {
        if (position >= 1 && position <= length) {
            Object result = entry[position - 1];
            removeGap(position);
            length--;
            return result;
        }
        return null;
    }

    public Object replace(int position, Object newEntry) {
        if (position >= 1 && position <= length) {
            Object oldEntry = entry[position - 1];
            entry[position - 1] = newEntry;
            return oldEntry;
        }
        return null;
    }

    public Object getEntry(int position) {
        if (position >= 1 && position <= length) return entry[position - 1];
        return null;
    }

    public void display() {
        for (int i = 0; i < length; i++) System.out.println(entry[i]);
    }

    public int getLength() { return length; }
    public boolean isEmpty() { return length == 0; }
    public boolean isFull() { return length >= entry.length; }
    public void clear() { length = 0; }

    private void makeRoom(int pos) {
        for (int i = length; i >= pos; i--) entry[i] = entry[i - 1];
    }
    private void removeGap(int pos) {
        for (int i = pos - 1; i < length - 1; i++) entry[i] = entry[i + 1];
        entry[length - 1] = null;
    }
    private void doubleArray() { entry = Arrays.copyOf(entry, entry.length * 2); }
}