import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    int id;
    String name;
    int age;
    String disease;

    Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }
}

public class HospitalManagementSystem {

    static ArrayList<Patient> patients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        patients.add(new Patient(id, name, age, disease));
        System.out.println("Patient Added Successfully.");
    }

    public static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No Patient Records.");
            return;
        }

        System.out.println("\nPatient Records");
        for (Patient p : patients) {
            System.out.println("----------------------------");
            System.out.println("ID : " + p.id);
            System.out.println("Name : " + p.name);
            System.out.println("Age : " + p.age);
            System.out.println("Disease : " + p.disease);
        }
    }

    public static void updatePatient() {
        System.out.print("Enter Patient ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Patient p : patients) {
            if (p.id == id) {

                System.out.print("Enter New Name: ");
                p.name = sc.nextLine();

                System.out.print("Enter New Age: ");
                p.age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Disease: ");
                p.disease = sc.nextLine();

                System.out.println("Patient Updated Successfully.");
                return;
            }
        }

        System.out.println("Patient Not Found.");
    }

    public static void deletePatient() {
        System.out.print("Enter Patient ID to Delete: ");
        int id = sc.nextInt();

        for (Patient p : patients) {
            if (p.id == id) {
                patients.remove(p);
                System.out.println("Patient Deleted Successfully.");
                return;
            }
        }

        System.out.println("Patient Not Found.");
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== Hospital Management System =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    viewPatients();
                    break;

                case 3:
                    updatePatient();
                    break;

                case 4:
                    deletePatient();
                    break;

                case 5:
                    System.out.println("Thank You...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}