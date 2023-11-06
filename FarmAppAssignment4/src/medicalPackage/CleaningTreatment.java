package medicalPackage;
import peoplePackage.FarmWorker;
import peoplePackage.Veterinary;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class CleaningTreatment extends Treatment implements Serializable {
    private static final long serialVersionUID = 1L;
    private String materialsused;
    private FarmWorker cgivenby;

    public CleaningTreatment(){
        super();
        this.materialsused="Not Defined";
        this.cgivenby=null;
    }

    public CleaningTreatment(LocalDate dateOfTreatment ,String materialsused, FarmWorker cgivenby){
        super(dateOfTreatment);
        this.materialsused=materialsused;
        this.cgivenby=cgivenby;
    }

    public CleaningTreatment(LocalDate dateOfTreatment){
        super(dateOfTreatment);
    }

    public CleaningTreatment(LocalDate date_of_treatment, String material_used) {
        this.setDateOfTreatment(date_of_treatment);
        this.materialsused=material_used;
    }


    public FarmWorker getCgivenby(){return this.cgivenby;}
    public String getMaterialsused() {
        return this.materialsused;
    }
    public void setMaterialsused(String materialsused) {
        this.materialsused = materialsused;
    }
    public void setCgivenby(FarmWorker cgivenby1){
        this.cgivenby=cgivenby1;
    }

    @Override
    public String toString() {
        return new StringBuffer ("Given by: ").append(this.getCgivenby())
                .append("\nEmergency: ").append(this.getMaterialsused())
                .append("Date Of Treatment: ").append(this.getDateOfTreatment()).toString();
    }



}
