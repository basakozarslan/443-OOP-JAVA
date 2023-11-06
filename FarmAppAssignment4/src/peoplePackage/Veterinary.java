package peoplePackage;
import medicalPackage.Medication;
import medicalPackage.Treatment;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Veterinary extends Employee implements Serializable {
    //default serialVersion id
    private static final long serialVersionUID = 1L;
    private boolean BScDegree;
    private LocalDate dateOfGraduation ;
    private int expertiseLevel;

    private ArrayList<Medication> medications = new ArrayList<>();
    private ArrayList<Treatment> treatments = new ArrayList<>();


    public Veterinary(){
        super();
        this.BScDegree=false;
        this.dateOfGraduation=null;
        this.expertiseLevel=0;
    }

    public Veterinary(int empID, String gender, LocalDate dateOfBirth,boolean BScDegree, LocalDate dateOfGraduation, int expertiseLevel){
        super(empID,gender,dateOfBirth);
        this.BScDegree=BScDegree;
        this.dateOfGraduation=dateOfGraduation;
        this.expertiseLevel=expertiseLevel;
    }

    public Veterinary(int empID){super(empID);}

    public ArrayList<Treatment> getTreatments(){return treatments;}
    public ArrayList<Medication> getMedications(){return medications;}
    public boolean isBScDegree(){
        return this.BScDegree;
    }
    public LocalDate getDateOfGraduation(){
        return this.dateOfGraduation;
    }
    public int getExpertiseLevel(){
        return this.expertiseLevel;
    }

    public void setBScDegree(boolean BScDegree1){
        this.BScDegree=BScDegree1;
    }
    public void setDateOfGraduation(LocalDate dateOfGraduation1){
        this.dateOfGraduation=dateOfGraduation1;
    }
    public void setExpertiseLevel(int expertiseLevel1){
        this.expertiseLevel=expertiseLevel1;
    }

    public void setMedications(Medication medication){medications.add(medication);}
    public void setTreatments(Treatment treatment){treatments.add(treatment);}

    @Override
    public double getSalary() {
        LocalDate dateOfGrad = this.dateOfGraduation ;
        LocalDate currentDate = LocalDate.now();
        double gradYear= Period.between(dateOfGrad, currentDate).getYears();
        return (Payment.grossSalary)+((Payment.grossSalary*10)/100)*gradYear;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return new StringBuffer ("empID: ").append(this.getEmpID())
                .append("Gender: ").append(this.getGender())
                .append("BScDegree: ").append(this.BScDegree)
                .append("Expertise Level: ").append(this.expertiseLevel)
                .append("Date Of Graduation ").append(this.getDateOfGraduation())
                .append("Date Of Birth ").append(this.getDateOfBirth()).toString();
    }
}

