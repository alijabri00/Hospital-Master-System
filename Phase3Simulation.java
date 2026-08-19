public class Phase3Simulation {
    public static void main(String[] args) {
        System.out.println("=== SMART HOSPITAL: PRIORITY QUEUE SIMULATION ===");
        HospitalPriorityQueue erQueue = new HospitalPriorityQueue();

        System.out.println("Registering 10 patients...\n");
        erQueue.enqueue("patient 1 (Routine)", 3);
        erQueue.enqueue("patient 2 (Normal)", 2);
        erQueue.enqueue("patient 3 (Emergency!)", 1);
        erQueue.enqueue("patient 4 (Normal)", 2);
        erQueue.enqueue("patient 5 (Routine)", 3);
        erQueue.enqueue("patient 6 (Emergency!)", 1);
        erQueue.enqueue("patient 7 (Routine)", 3);
        erQueue.enqueue("patient 8 (Normal)", 2);
        erQueue.enqueue("patient 9 (Emergency!)", 1);
        erQueue.enqueue("patient 10 (Routine)", 3);

        System.out.println("Processing Patients (Notice how strict FIFO is broken for emergencies):");
        int count = 1;
        while (!erQueue.isEmpty()) {
            System.out.println(count + ". Doctor is seeing: " + erQueue.dequeue());
            count++;
        }
    }
}