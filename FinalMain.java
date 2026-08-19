public class FinalMain {
    public static void main(String[] args) {
        System.out.println("=== PHASE 5: MERGE SORT TEST ===");
        String[] patients = {"Zaid", "Ahmad", "Yazan", "Mohammad", "Sara", "Ali"};
        PatientSorter.mergeSort(patients, 0, patients.length - 1);
        System.out.println("Sorted Patients: " + java.util.Arrays.toString(patients));

        System.out.println("\n===  HOSPITAL MAP ===");
        HospitalGraph map = new HospitalGraph();
        
        map.addRoad(0, 1, 2); 
        map.addRoad(0, 2, 5); 
        map.addRoad(1, 3, 1); 
        map.addRoad(2, 4, 3); 
        map.addRoad(3, 5, 4); 
        map.addRoad(4, 6, 2); 
        map.addRoad(5, 7, 6); 
        map.addRoad(6, 7, 1); 

        map.DFS(0); 
        map.BFS(0); 
        map.floydWarshall(); 
    }
}