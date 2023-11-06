import java.util.ArrayList;
import java.util.Date;

/**
 * Cow Class
 */
public class Cow {
    private int tagNo;
    private String gender;
    private Date dateOfBirth;
    private boolean purchased;

    private ArrayList<Treatment> treatments = new ArrayList<>();

    private ArrayList<Medication> medications = new ArrayList<>();


    /**
     * default constructor of Cow
     */
    public Cow(){}

    /**
     * constructor of Cow
     * @param tagNo as an int
     * @param gender as a str
     * @param dateOfBirth as a date
     * @param purchased as a boolean
     */
    public Cow(int tagNo,String gender, Date dateOfBirth, boolean purchased){
        this.tagNo = tagNo;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.purchased = purchased;
    }

    /**
     * getter date of birth
     * @return date of birth as obj of date class
     */
    public Date getAge(){
        return this.dateOfBirth;
    }

    /**
     * getter tagNo of Cow
     * @return tagNo as a int
     */
    public int getTagNo(){
        return this.tagNo;
    }

    /**
     * getter gender of Cow
     * @return gender as a string
     */
    public String getGender(){
        return this.gender;
    }

    /**
     * getter cow is purchased or not
     * @return true or false as a boolean
     */
    public boolean isPurchased(){
        return this.purchased;
    }

    /**
     * getter for treatments
     * @return treatments
     */
    public ArrayList<Treatment> getTreatments(){
        return treatments;
    }

    /**
     * setter tagNo of Cow
     * @param tagNo1 as an int
     */
    public void setTagNo(int tagNo1){
        this.tagNo = tagNo1;
    }

    /**
     * setter gender of Cow
     * @param gender1 as a str
     */
    public void setGender(String gender1){
        this.gender = gender1;
    }

    /**
     * setter date of birth of Cow
     * @param dateOfBirth1 as a date
     */
    public void setDateOfBirth(Date dateOfBirth1){
        this.dateOfBirth = dateOfBirth1;
    }

    /**
     * setter purchased or not about the Cow
     * @param purchased1 as a boolean
     */
    public void setPurchased(boolean purchased1){
        this.purchased = purchased1;
    }


    /**
     * setter for added treatments
     * @param treatment as a obj
     */
    public void newTreatments (Treatment treatment) { treatments.add(treatment); }


    /**
     * getter for medications
     * @return medications
     */
    public ArrayList<Medication> getMedications() {
        return medications;
    }

    /**
     * setter for added medications
     * @param medication as a obj
     */
    public void newMedications(Medication medication) {
        medications.add(medication);
    }
}
