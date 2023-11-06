package animalsPackage;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

public class Sheep extends Animal implements Serializable {

    private static final long serialVersionUID = 1L;
    public Sheep(){
        super();
    }

    public Sheep(int tagNo, char gender, LocalDate dateOfBirth, boolean purchased, HashMap milking){
        super(tagNo,gender,dateOfBirth,purchased, milking);
    }


    @Override
    public void feeding() {
        if(getAge(getDateOfBirth())<5 && getGender()=='m'){
            System.out.println("Fed with grass (sheep)");
        }
        else if(getAge(getDateOfBirth())<8 && getGender()=='f'){
            System.out.println("Fed with grass (sheep)");
        }
        else if(getAge(getDateOfBirth())>5 && getGender()=='m'){
            System.out.println("TMR diets (sheep)");
        }
        else if(getAge(getDateOfBirth())>8 && getGender()=='f'){
            System.out.println("TMR diets (sheep)");
        }
        else{
            System.out.println("Fed with grass and grains (sheep)");
        }
    }

    @Override
    public String toString() {
        return new StringBuffer ("TagNo: ").append(this.getTagNo())
                .append("Gender: ").append(this.getGender())
                .append("Purchased:").append(this.isPurchased())
                .append("Milking:").append(this.getMilking())
                .append("Date Of Birth ").append(this.getDateOfBirth()).toString();
    }

}