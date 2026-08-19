public class HospitalSystem {
    public static void main(String[] args) {
        ListInterface arrayList = new ArrayPatientList();
        ListInterface linkedList = new LinkedPatientList();

        Patient p1 = new Patient("Ali Jabri", "2001114845", "Amman", "2004-07-02", "Male", "Digestive", "Dr. Sami", false);
        Doctor d1 = new Doctor("Dr. Sami", "9981049758", "Amman", "1975-10-15", "Male", "PhD", "Digestive", 4500.0);
        Staff s1 = new Staff("Bashar", "2001114875", "Zarqa", "2005-08-03", "Male", "Receptionist", "Front Desk", 800.0);
        
        System.out.println("--- ARRAY LIST PERFORMANCE ---");
        long startA = System.nanoTime();
        arrayList.add(p1);
        arrayList.add(1, d1);
        arrayList.add(s1);
        long endA = System.nanoTime();
        arrayList.display();
        System.out.println("Execution Time: " + (endA - startA) + " ns\n");

        System.out.println("--- LINKED LIST PERFORMANCE ---");
        long startL = System.nanoTime();
        linkedList.add(p1);
        linkedList.add(1, d1);
        linkedList.add(s1);
        long endL = System.nanoTime();
        linkedList.display();
        System.out.println("Execution Time: " + (endL - startL) + " ns\n");
    }
}