import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Patient {
    private int patientId;
    private String name;
    private int age;
    private String disease;
    private String doctor;

    public Patient(int patientId, String name, int age,
                   String disease, String doctor) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.doctor = doctor;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDisease() {
        return disease;
    }

    public String getDoctor() {
        return doctor;
    }

    public void displayPatient() {
        System.out.println("Patient ID : " + patientId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Disease    : " + disease);
        System.out.println("Doctor     : " + doctor);
        System.out.println("----------------------------");
    }
}

public class HospitalManagementSystem {

    // Week 2: HashMap storage
    static HashMap<Integer, Patient> patients = new HashMap<>();

    static Scanner sc = new Scanner(System.in);

    // Add Patient
    static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        // Prevent duplicate Patient IDs
        if (patients.containsKey(id)) {
            System.out.println("Patient ID already exists!");
            return;
        }

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = sc.nextLine();

        Patient patient =
            new Patient(id, name, age, disease, doctor);

        patients.put(id, patient);

        System.out.println("Patient added successfully!");
    }

    // Search Patient using HashMap key
    static void searchPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();

        Patient patient = patients.get(id);

        if (patient != null) {
            System.out.println("\nPatient Found:");
            patient.displayPatient();
        } else {
            System.out.println("Patient not found!");
        }
    }

    // Remove Patient
    static void removePatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();

        if (patients.containsKey(id)) {
            patients.remove(id);
            System.out.println("Patient removed successfully!");
        } else {
            System.out.println("Patient not found!");
        }
    }

    // View all patients
    static void viewAllPatients() {

        if (patients.isEmpty()) {
            System.out.println("No patient records available.");
            return;
        }

        System.out.println("\n===== ALL PATIENTS =====");

        for (Map.Entry<Integer, Patient> entry : patients.entrySet()) {
            entry.getValue().displayPatient();
        }
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Remove Patient");
            System.out.println("4. View All Patients");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    searchPatient();
                    break;

                case 3:
                    removePatient();
                    break;

                case 4:
                    viewAllPatients();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}