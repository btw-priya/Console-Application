# Hospital Management System

## Week 2 – HashMap Storage

### Algorithm

1. **Start**
2. Create a `HashMap<Integer, Patient>` to store patient records.
3. Display the following menu:
   - Add Patient
   - Search Patient
   - Remove Patient
   - View All Patients
   - Exit
4. Read the user's choice.

### Add Patient

5. Read the Patient ID.
6. Check whether the Patient ID already exists using `containsKey()`.
7. If the ID exists:
   - Display "Patient ID already exists".
8. Otherwise:
   - Read patient name.
   - Read patient age.
   - Read disease.
   - Read doctor name.
   - Create a `Patient` object.
   - Store the patient using `put(id, patient)`.
9. Display "Patient added successfully".

### Search Patient

10. Read the Patient ID.
11. Retrieve the patient directly using `get(id)`.
12. If the patient exists:
    - Display patient details.
13. Otherwise:
    - Display "Patient not found".

### Remove Patient

14. Read the Patient ID.
15. Check whether the ID exists using `containsKey()`.
16. If the ID exists:
    - Remove the patient using `remove(id)`.
    - Display "Patient removed successfully".
17. Otherwise:
    - Display "Patient not found".

### View All Patients

18. Check whether the `HashMap` is empty.
19. If it is empty, display "No patient records available".
20. Otherwise, iterate through the `HashMap` using `entrySet()`.
21. Display the details of every patient.

### Exit

22. If the user selects Exit, terminate the program.
23. Otherwise, return to the main menu.
24. **Stop.**

## Key Week 2 Requirement

- Use `HashMap<Integer, Patient>` for storage.
- Use the **Patient ID as the key**.
- Use `get()` for direct patient lookup.
- Do not use manual search loops for finding a patient.
- Use `containsKey()` to prevent duplicate Patient IDs.
- Data is lost when the program is restarted because there is no persistence.