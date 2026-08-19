public class HospitalTree {
    public static DecisionTree buildProfessionalTree() {
        BinaryNode erAction = new BinaryNode("EMERGENCY: Immediate admission to ER.");
        BinaryNode registration = new BinaryNode("DECISION: Proceed to the registration desk.");
        BinaryNode checkIn = new BinaryNode("DECISION: Proceed to the waiting room queue.");
        BinaryNode billing = new BinaryNode("DECISION: Please visit the billing office first.");
        BinaryNode insuranceCheck = new BinaryNode("Do you have active insurance?", billing, checkIn);
        BinaryNode appointmentCheck = new BinaryNode("Do you have an appointment?", registration, insuranceCheck);
        BinaryNode rootNode = new BinaryNode("Is this a life-threatening emergency?", appointmentCheck, erAction);
        return new DecisionTree(rootNode);
    }
}