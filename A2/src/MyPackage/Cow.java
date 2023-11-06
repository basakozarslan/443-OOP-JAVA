package MyPackage;

import java.time.LocalDate;
import java.util.ArrayList;
/**
 * Cow class that extends Animal
 */
public class Cow extends Animal {
    private double weight;
    private ArrayList<Treatment> treatments = new ArrayList<>();
    private ArrayList<HealthTreatment> healthTreatments = new ArrayList<>();
    private ArrayList<CleaningTreatment> cleaningTreatments = new ArrayList<>();
    private ArrayList<Medication> medications = new ArrayList<>();

    /**
     * Constructors of Veterinary
     */
    public Cow() {
        this.weight=0.0;
    }

    public Cow(double weight) {
        this.weight=weight;
    }

    public Cow(int tagNo, String gender, LocalDate dateOfBirth, boolean purchased, double weight) {
        this.setTagNo(tagNo);
        this.setGender(gender);
        this.setDateOfBirth(dateOfBirth);
        this.setPurchased(purchased);
        this.weight = weight;
    }
    public ArrayList<HealthTreatment> getHTreatments(){
        return healthTreatments;
    }
    public ArrayList<CleaningTreatment> getCTreatments(){
        return cleaningTreatments;
    }
    public ArrayList<Treatment> getTreatments(){
        return treatments;
    }

    /**
     * getters and setters of Veterinary
     */

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight1) {
        this.weight = weight1;
    }

    public void newTreatments (Treatment treatment) { treatments.add(treatment); }

    public ArrayList<Medication> getMedications() {
        return medications;
    }

    public void newMedications(Medication medication) {
        medications.add(medication);
    }

    /**
     * feeding method of Animals for cow
     */
    @Override
    public void feeding() {
        if(getAge(getDateOfBirth())<3){
            System.out.println("Fed with grass");
        }
        else if(getAge(getDateOfBirth())>5 && getWeight()<500){
            System.out.println("TMR diets");
        }
        else if(getAge(getDateOfBirth())>10){
            System.out.println("Fed with grains and oilseed");
        }
        else{
            System.out.println("Fed with grass and grains");
        }
    }

}

