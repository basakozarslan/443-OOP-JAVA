package MyPackage;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Animal class that is abstract
 */
public abstract class Animal {
    int tagNo;
    String gender;
    LocalDate dateOfBirth;
    boolean purchased;
    Map<LocalDate,Double> milking = new HashMap<LocalDate, Double>();
    private ArrayList<Treatment> treatments = new ArrayList();


    /**
     * Constructors of Animal
     */
    public Animal(){}

    public Animal(int tagNo, String gender, LocalDate dateOfBirth, boolean purchased, HashMap milking){
        this.tagNo=tagNo;
        this.gender=gender;
        this.dateOfBirth=dateOfBirth;
        this.purchased=purchased;
        this.milking=milking;
    }

    /**
     * getters of Animal
     */
    public int getTagNo(){
        return this.tagNo;
    }
    public String getGender(){
        return this.gender;
    }
    public boolean isPurchased(){
        return this.purchased;
    }
    public HashMap getMilking(){
        return (HashMap) this.milking;
    }
    public LocalDate getDateOfBirth(){return this.dateOfBirth;}

    /**
     * getAge class that calculates the age of animals according to their birthdate
     */
    public int getAge(LocalDate dateOfBirth){
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }

    /**
     * setters of Animal
     */
    public void setTagNo(int tagNo1){
        this.tagNo = tagNo1;
    }

    public void setGender(String gender1){
        this.gender = gender1;
    }

    public void setDateOfBirth(LocalDate dateOfBirth1){
        this.dateOfBirth=dateOfBirth1;
    }


    public void setPurchased(boolean purchased1){
        this.purchased = purchased1;
    }

    /**
     *feeding method it implemented in sheep and cow
     */
    public abstract void feeding();

}




