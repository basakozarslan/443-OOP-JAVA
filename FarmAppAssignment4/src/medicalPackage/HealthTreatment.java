package medicalPackage;
import peoplePackage.FarmWorker;
import peoplePackage.Veterinary;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class HealthTreatment extends Treatment implements Serializable {
    //default serialVersion id
    private static final long serialVersionUID = 1L;
    private boolean emergency;
    private Veterinary hgivenby;

    private Medication medication;

    public HealthTreatment(){
        super();
        this.emergency=false;
        this.hgivenby=null;
        this.medication=null;
    }

    public HealthTreatment(LocalDate dateOfTreatment, boolean emergency, Veterinary hgivenby, Medication medication
    ){
        super(dateOfTreatment);
        this.emergency=emergency;
        this.hgivenby=hgivenby;
        this.medication=medication;
    }

    public HealthTreatment(LocalDate dateOfTreatment){
        super(dateOfTreatment);
    }

    public HealthTreatment(LocalDate date_of_treatment, boolean emergency) {
        this.setDateOfTreatment(date_of_treatment);
        this.emergency=emergency;
    }

    public Medication getHasMedication(){return medication;}
    public Veterinary getHgivenby(){return this.hgivenby;}
    public boolean isEmergency() {
        return this.emergency;
    }

    public void setMedication(Medication medication1){this.medication=medication1;}
    public void setEmergency(boolean emergency1) {
        this.emergency = emergency1;
    }
    public void setHgivenby(Veterinary hgivenby1){
        this.hgivenby=hgivenby1;
    }

    @Override
    public String toString() {
        return new StringBuffer ("Given by: ").append(this.getHgivenby())
                .append("\nEmergency: ").append(this.isEmergency())
                .append("Medication: ").append(this.getHasMedication())
                .append("Date Of Treatment: ").append(this.getDateOfTreatment()).toString();
    }

}
