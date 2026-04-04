/**
 * @author Ilya
 * @date 29.03.2026
 */

public class Patient {
    private int treatmentPlan;
    private Doctor doctor;

    public Patient(int treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public int getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}

