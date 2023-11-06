package MyPackage;

import java.time.LocalDate;
/**
 * Sheep Class that extends Animal
 */
public class Sheep extends Animal {
    /**
     * constructors of Animal
     */
    public Sheep(){}

    public Sheep(int tagNo, String gender, LocalDate dateOfBirth, boolean purchased){
        this.setTagNo(tagNo);
        this.setGender(gender);
        this.setDateOfBirth(dateOfBirth);
        this.setPurchased(purchased);
    }
    /**
     * feeding method for sheep
     */
    @Override
    public void feeding() {
        if(getAge(getDateOfBirth())<5 && getGender()=="male"){
            System.out.println("Fed with grass");
        }
        else if(getAge(getDateOfBirth())<8 && getGender()=="female"){
            System.out.println("Fed with grass");
        }
        else if(getAge(getDateOfBirth())>5 && getGender()=="male"){
            System.out.println("TMR diets");
        }
        else if(getAge(getDateOfBirth())>8 && getGender()=="female"){
            System.out.println("TMR diets");
        }
        else{
            System.out.println("Fed with grass and grains");
        }
    }
}
