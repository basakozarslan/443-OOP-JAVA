package medicalPackage;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Medication implements Serializable {

    private static final long serialVersionUID = 1L;
    private String details;
    private int duration;
    private LocalDate startDate;
    private double Dosage;
    private String notes;
    private ArrayList<Treatment> treatment = new ArrayList<Treatment>();

    public Medication(){
        this.details="Not Defined";
        this.duration=0;
        this.startDate=null;
        this.Dosage=0.0;
        this.notes="Not Defined";
    }

    public Medication(String details, int duration, LocalDate startDate, double Dosage, String notes){
        this.details=details;
        this.duration=duration;
        this.startDate=startDate;
        this.Dosage=Dosage;
        this.notes=notes;
    }



    public ArrayList<Treatment> getTreatments(){return treatment;}
    public String getDetails() {
        return this.details;
    }
    public int getDuration() {
        return this.duration;
    }
    public LocalDate getStartDate() {
        return this.startDate;
    }
    public double getDosage() {
        return this.Dosage;
    }
    public String getNotes() {
        return this.notes;
    }


    public void setTreatments(Treatment treatments){treatment.add(treatments);}
    public void setDetails(String details1) {
        this.details = details1;
    }
    public void setDuration(int duration1) {
        this.duration = duration1;
    }
    public void setStartDate(LocalDate startDate1) {
        this.startDate = startDate1;
    }
    public void setDosage(double dosage1) {
        Dosage = dosage1;
    }
    public void setNotes(String notes1) {
        this.notes = notes1;
    }

    @Override
    public String toString() {
        return new StringBuffer ("Details: ").append(this.details)
                .append("\nDuration: ").append(this.duration)
                .append("\nDosage: ").append(this.Dosage)
                .append("\nNotes: ").append(this.notes)
                .append("\nStart Date: ").append(this.startDate).toString();
    }
}