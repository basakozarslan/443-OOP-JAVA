import java.util.Date;

/**
 * Treatment Class
 */
public class Treatment  {
    private Date dateOfTreatment;
    private String details;


    /**
     * default constructor of Treatment
     */
    public Treatment(){}

    /**
     * constructor of Treatment
     * @param dateOfTreatment as a date
     * @param details as a str
     */
    public Treatment(Date dateOfTreatment, String details){
        this.dateOfTreatment=dateOfTreatment;
        this.details=details;
    }

    /**
     * getter date of treatment
     * @return date of treatment as a date class
     */
    public Date getDateOfTreatment(){
        return this.dateOfTreatment;
    }

    /**
     * getter details of treatment
     * @return details as a string
     */
    public String getDetails(){
        return this.details;
    }

    /**
     * setter date of treatment
     * @param dateOfTreatment1 as a date
     */
    public void setDateOfTreatment(Date dateOfTreatment1) {
        this.dateOfTreatment = dateOfTreatment1;
    }

    /**
     * setter details of treatment
     * @param details1 as a str
     */
    public void setDetails(String details1) {
        this.details = details1;
    }


}