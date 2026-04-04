/**
 * @author Ilya
 * @date 29.03.2026
 */

public class Therapist extends Doctor{
    public void assignDoctor(Patient patient) {
        int plan = patient.getTreatmentPlan();
        if (plan == 1) {
            Surgeon surgeon = new Surgeon();
            patient.setDoctor(surgeon);
            surgeon.treat();
        } else if (plan ==2) {
            Dentist dentist = new Dentist();
            patient.setDoctor(dentist);
            dentist.treat();
        } else {
            patient.setDoctor(this);
            this.treat();
        }
    }
    @Override
    public void treat() {
        System.out.println("Терапевт проводит общее лечение");
    }
}
