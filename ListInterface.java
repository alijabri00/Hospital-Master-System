public interface ListInterface {
    void add(Object newEntry);
    boolean add(int position, Object newEntry);
    Object remove(int position);
    Object replace(int position, Object newEntry);
    Object getEntry(int position);
    void display();
    int getLength();
    boolean isEmpty();
    boolean isFull();
    void clear();
}