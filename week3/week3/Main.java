import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

// Patient Class
class Patient {
    int patientId;
    String name;
    int age;
    String disease;

    Patient(int patientId, String name, int age, String disease) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }
}

// DAO Class
class PatientDAO {
    private LinkedHashMap<Integer, Patient> patients = new LinkedHashMap<>();

    public void addPatient(Patient patient) {
        patients.put(patient.patientId, patient);
    }

    public Patient getPatient(int patientId) {
        return patients.get(patientId);
    }

    public LinkedHashMap<Integer, Patient> getAllPatients() {
        return patients;
    }
}

// Service Class
class PatientService {
    private PatientDAO dao = new PatientDAO();

    public void registerPatient(int id, String name, int age, String disease) {

        if (dao.getPatient(id) != null) {
            System.out.println("Patient already exists!");
            return;
        }

        Patient patient = new Patient(id, name, age, disease);
        dao.addPatient(patient);

        System.out.println("Patient registered successfully!");
    }

    public void viewPatient(int id) {

        Patient patient = dao.getPatient(id);

        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.println("\nPatient ID : " + patient.patientId);
        System.out.println("Name       : " + patient.name);
        System.out.println("Age        : " + patient.age);
        System.out.println("Disease    : " + patient.disease);
    }

    public void viewAllPatients() {

        if (dao.getAllPatients().isEmpty()) {
            System.out.println("No patients available!");
            return;
        }

        System.out.println("\n--- All Patients ---");

        // LinkedHashMap preserves insertion order
        for (Map.Entry<Integer, Patient> entry :
                dao.getAllPatients().entrySet()) {

            Patient patient = entry.getValue();

            System.out.println(
                    "ID: " + patient.patientId +
                    ", Name: " + patient.name +
                    ", Age: " + patient.age +
                    ", Disease: " + patient.disease
            );
        }
    }
}

// Main Class
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PatientService service = new PatientService();

        while (true) {

            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Patient");
            System.out.println("2. View Patient");
            System.out.println("3. View All Patients");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter Disease: ");
                    String disease = sc.next();

                    service.registerPatient(id, name, age, disease);
                    break;

                case 2:
                    System.out.print("Enter Patient ID: ");
                    id = sc.nextInt();

                    service.viewPatient(id);
                    break;

                case 3:
                    service.viewAllPatients();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}