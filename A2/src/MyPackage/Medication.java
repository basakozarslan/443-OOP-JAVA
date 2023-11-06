package MyPackage;

import java.util.Date;
/**
 * medication class
 */
public class Medication {
    private String details;
    private int duration;
    private Date startDate;
    private double Dosage;
    private String notes;
    /**
     * constructor of medication
     */
    public Medication(){
        this.details=null;
        this.duration=0;
        this.startDate=null;
        this.Dosage=0.0;
        this.notes=null;
    }

    public Medication(String details, int duration, Date startDate, double Dosage, String notes){
        this.details=details;
        this.duration=duration;
        this.startDate=startDate;
        this.Dosage=Dosage;
        this.notes=notes;
    }
    /**
     * getters of medication
     */

    public String getDetails() {
        return this.details;
    }
    public int getDuration() {
        return this.duration;
    }
    public Date getStartDate() {
        return this.startDate;
    }
    public double getDosage() {
        return this.Dosage;
    }
    public String getNotes() {
        return this.notes;
    }

    /**
     * setters of medication
     */
    public void setDetails(String details1) {
        this.details = details1;
    }
    public void setDuration(int duration1) {
        this.duration = duration1;
    }
    public void setStartDate(Date startDate1) {
        this.startDate = startDate1;
    }
    public void setDosage(double dosage1) {
        Dosage = dosage1;
    }
    public void setNotes(String notes1) {
        this.notes = notes1;
    }

}