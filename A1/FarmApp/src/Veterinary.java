import java.util.Date;

/**
 * Veterinary Class
 */
public class Veterinary {
    private int vetID;
    private String gender;
    private Date dateOfBirth;
    private double salary;

    /**
     * default constructor of Veterinary
     */
    public Veterinary(){}

    /**
     * constructor of Veterinary
     * @param vetID as an int
     * @param gender as a str
     * @param dateOfBirth as a date
     * @param salary as a double
     */
    public Veterinary(int vetID, String gender, Date dateOfBirth, double salary){
        this.vetID=vetID;
        this.gender=gender;
        this.dateOfBirth=dateOfBirth;
        this.salary=salary;
    }


    /**
     * getter VetId of vet
     * @return vetId as an int
     */
    public int getVetID(){
        return this.vetID;
    }

    /**
     * getter gender of vet
     * @return gender as a string
     */
    public String getGender(){
        return this.gender;
    }

    /**
     * getter date of birth of vet
     * @return date of birth as a date class
     */
    public Date getDateOfBirth(){
        return this.dateOfBirth;
    }

    /**
     * getter salary of vet
     * @return salary as a double
     */
    public double getSalary(){
        return this.salary;
    }


    /**
     * setter vetId of vet
     * @param vetID1 as an int
     */
    public void setVetID(int vetID1){
        this.vetID = vetID1;
    }

    /**
     * setter gender of vet
     * @param gender1 as a str
     */
    public void setGender(String gender1) {
        this.gender = gender1;
    }

    /**
     * setter date of birth of vet
     * @param dateOfBirth1 as a date
     */
    public void setDateOfBirth(Date dateOfBirth1) {
        this.dateOfBirth = dateOfBirth1;
    }

    /**
     * setter salary of vet
     * @param salary1 as a double
     */
    public void setSalary(double salary1) {
        this.salary = salary1;
    }

}