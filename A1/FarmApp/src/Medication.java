import java.util.Date;

/**
 * Medication class
 */
public class Medication {
    private String details;
    private int duration;
    private Date startDate;
    private double Dosage;
    private String notes;

    /**
     * default constructor of Medication
     */
    public Medication(){}

    /**
     * constructor of Medication
     * @param details as a str
     * @param duration as an int
     * @param startDate as a date
     * @param Dosage as a double
     * @param notes as a str
     */
    public Medication(String details, int duration, Date startDate, double Dosage, String notes){
        this.details=details;
        this.duration=duration;
        this.startDate=startDate;
        this.Dosage=Dosage;
        this.notes=notes;
    }

    /**
     * getter details of medication
     * @return details as a string
     */
    public String getDetails() {
        return this.details;
    }

    /**
     * getter duration of medication
     * @return duration as an int
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * getter start date of medication
     * @return start date as a date class
     */
    public Date getStartDate() {
        return this.startDate;
    }

    /**
     * getter dosage of medication
     * @return dosage as a double
     */
    public double getDosage() {
        return this.Dosage;
    }

    /**
     * getter notes of medication
     * @return notes as a string
     */
    public String getNotes() {
        return this.notes;
    }


    /**
     * setter details of medication
     * @param details1 as a str
     */
    public void setDetails(String details1) {
        this.details = details1;
    }

    /**
     * setter duration of medication
     * @param duration1 as an int
     */
    public void setDuration(int duration1) {
        this.duration = duration1;
    }

    /**
     * setter start date of medication
     * @param startDate1 as a date
     */
    public void setStartDate(Date startDate1) {
        this.startDate = startDate1;
    }

    /**
     * setter dosage of medication
     * @param dosage1 as a double
     */
    public void setDosage(double dosage1) {
        Dosage = dosage1;
    }

    /**
     * setter notes of medication
     * @param notes1 as a str
     */
    public void setNotes(String notes1) {
        this.notes = notes1;
    }


}