/**
 * @author Ilya
 * @date 29.03.2026
 */

public class DoctorMain {
    public static void main(String[] args) {
        Patient patient = new Patient(1); // пробуй 1,2,3
        Therapist therapist = new Therapist();
        therapist.assignDoctor(patient);
    }
}
