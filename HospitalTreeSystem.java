import java.util.Scanner;

public class HospitalTreeSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LQueue waitingRoom = new LQueue();
        DecisionTree receptionLogic = HospitalTree.buildProfessionalTree();
        System.out.println("=== HOSPITAL EXPERT RECEPTIONIST ===");
        while (!receptionLogic.isAnswer()) {
            System.out.println(receptionLogic.getCurrentData() + " (yes/no)");
            String response = scanner.nextLine().toLowerCase().trim();
            
            if (response.equals("yes")) {
                receptionLogic.advanceToYes();
            } else if (response.equals("no")) {
                receptionLogic.advanceToNo();
            } else {
                System.out.println("Invalid input. Type 'yes' or 'no'.");
            }
        }
        String result = (String) receptionLogic.getCurrentData();
        System.out.println("\n" + result);
        if (result.contains("waiting room")) {
            System.out.print("Enter patient name for the queue: ");
            String name = scanner.nextLine();
            waitingRoom.enqueue(name);
            System.out.println("SUCCESS: " + name + " is now next in line: " + waitingRoom.getFront());
        }
        scanner.close();
    }
}