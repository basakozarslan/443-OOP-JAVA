package animalsPackage;
import medicalPackage.Medication;
import medicalPackage.Treatment;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Animal implements Serializable {

    //default serialVersion id
    private static final long serialVersionUID = 1L;
    int tagNo;
    String gender;
    LocalDate dateOfBirth;
    boolean purchased;
    Map<LocalDate, Double> milking = new HashMap<LocalDate, Double>();

    private ArrayList<Treatment> treatments = new ArrayList<Treatment>();
    private ArrayList<Medication> medications = new ArrayList<Medication>();


    public Animal(){
        this.tagNo=0;
        this.gender= String.valueOf('F');
        this.dateOfBirth=null;
        this.purchased=false;
        //this.milking=null;
    }

    public Animal(int tagNo, char gender, LocalDate dateOfBirth, boolean purchased, HashMap milking){
        this.tagNo=tagNo;
        this.gender= String.valueOf(gender);
        this.dateOfBirth=dateOfBirth;
        this.purchased=purchased;
        this.milking=milking;
    }

    public Animal(char gender, LocalDate dateOfBirth, boolean purchased, HashMap milking){
        this.gender= String.valueOf(gender);
        this.dateOfBirth=dateOfBirth;
        this.purchased=purchased;
        this.milking=milking;
    }

    public Animal (int tagNo){this.tagNo=tagNo;}

    public int getTagNo(){
        return this.tagNo;
    }
    public String getGender(){
        return this.gender;
    }
    public boolean isPurchased(){
        return this.purchased;
    }
    public LocalDate getDateOfBirth(){return this.dateOfBirth;}
    public Map<LocalDate, Double> getMilking(){ return this.milking;}


    public void setTagNo(int tagNo1){
        this.tagNo = tagNo1;
    }
    public void setGender(String gender1){
        this.gender = gender1;
    }
    public void setDateOfBirth(LocalDate dateOfBirth1){
        this.dateOfBirth=dateOfBirth1;
    }
    public void setPurchased(boolean purchased1){
        this.purchased = purchased1;
    }
    /*public void setMilking(String milking1){
        this.milking=milking1;
    }*/

    public void setTreatments(Treatment treatment1){treatments.add(treatment1);}
    public void setMedications(Medication medication1){medications.add(medication1);}
    public ArrayList<Treatment> getTreatments(){
        return treatments;
    }
    public ArrayList<Medication> getMedications() {
        return medications;
    }
    public void newTreatments (Treatment treatment) { treatments.add(treatment); }
    public void newMedications(Medication medication) {
        medications.add(medication);
    }


    public int getAge(LocalDate dateOfBirth){
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }

    public abstract void feeding();

    @Override
    public String toString() {
        return new StringBuffer ("TagNo: ").append(this.getTagNo())
                .append("Gender: ").append(this.getGender())
                .append("Purchased:").append(this.isPurchased())
                .append("Milking:").append(this.getMilking())
                .append("Date Of Birth ").append(this.getDateOfBirth()).toString();
    }

}
