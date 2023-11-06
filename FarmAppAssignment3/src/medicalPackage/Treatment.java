package medicalPackage;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Treatment implements Serializable {
    private static final long serialVersionUID = 1L;
    private LocalDate dateOfTreatment ;

    public Treatment(){
        this.dateOfTreatment=null;
    }

    public Treatment(LocalDate dateOfTreatment){
        this.dateOfTreatment=dateOfTreatment;
    }

    public LocalDate getDateOfTreatment() {
        return dateOfTreatment;
    }
    public void setDateOfTreatment(LocalDate dateOfTreatment) {
        this.dateOfTreatment = dateOfTreatment;
    }

    @Override
    public String toString() {
        return new StringBuffer ("Date Of Treatment: ").append(this.dateOfTreatment).toString();
    }
}