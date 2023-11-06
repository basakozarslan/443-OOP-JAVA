package MyPackage;

import java.util.Date;
/**
 * Treatment class
 */
public class Treatment {
    private Date dateOfTreatment ;

    /**
     * Constructors of Treatment
     */
    public Treatment(){
        this.dateOfTreatment=null;
    }

    public Treatment(Date dateOfTreatment){
        this.dateOfTreatment=dateOfTreatment;
    }
    /**
     * getters of Treatment
     */
    public Date getDateOfTreatment() {
        return dateOfTreatment;
    }
    /**
     * setters of Treatment
     */
    public void setDateOfTreatment(Date dateOfTreatment) {
        this.dateOfTreatment = dateOfTreatment;
    }
}
