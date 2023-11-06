package medicalPackage;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Treatment implements Serializable {
    private static final long serialVersionUID = 1L;
    private LocalDate dateOfTreatment ;

    private int animalID;

    public Treatment(){
        this.dateOfTreatment=null;
    }

    public Treatment(LocalDate dateOfTreatment, int animalID){
        this.dateOfTreatment=dateOfTreatment;
        this.animalID=animalID;
    }

    public Treatment(LocalDate dateOfTreatment) {
    }

    public int getAnimalID(){return animalID;}
    public LocalDate getDateOfTreatment() {
        return dateOfTreatment;
    }
    public void setDateOfTreatment(LocalDate dateOfTreatment) {
        this.dateOfTreatment = dateOfTreatment;
    }

    public void setAnimalID(int animalID1){this.animalID=animalID1;}
    @Override
    public String toString() {
        return new StringBuffer ("Date Of Treatment: ").append(this.dateOfTreatment).toString();
    }
}