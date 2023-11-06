package animalsPackage;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;


public class Cow extends Animal implements Serializable {
    //default serialVersion id
    private static final long serialVersionUID = 1L;
    private double weight;

    public Cow() {
        super();
        this.weight=0.0;
    }

    public Cow(int tagNo, char gender, LocalDate dateOfBirth, boolean purchased, HashMap milking,double weight) {
        super(tagNo,gender,dateOfBirth,purchased, milking);
        this.weight=weight;
    }


    public double getWeight() {
        return this.weight;
    }
    public void setWeight(double weight1) {
        this.weight = weight1;
    }


    @Override
    public void feeding() {
        if(getAge(getDateOfBirth())<3){
            System.out.println("Fed with grass (cow)");
        }
        else if(getAge(getDateOfBirth())>5 && getWeight()<500){
            System.out.println("TMR diets (cow)");
        }
        else if(getAge(getDateOfBirth())>10){
            System.out.println("Fed with grains and oilseed (cow)");
        }
        else{
            System.out.println("Fed with grass and grains (cow)");
        }
    }

    @Override
    public String toString() {
        return new StringBuffer ("TagNo: ").append(this.getTagNo())
                .append("Gender: ").append(this.getGender())
                .append("Purchased:").append(this.isPurchased())
                .append("Milking:").append(this.getMilking())
                .append("Weight:").append(this.getWeight())
                .append("Date Of Birth ").append(this.getDateOfBirth()).toString();
    }
}