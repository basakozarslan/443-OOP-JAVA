package animalsPackage;
import java.io.Serializable;
import java.sql.Date;
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

    public Sheep(int tagNo, String gender, Date dateOfBirth, boolean purchased){
        super(tagNo);
    }

    public Sheep(int tagNo, char gender, LocalDate dateOfBirth, boolean purchased) {
    }

    public Sheep(int tagNo){
        super(tagNo);
    }

    @Override
    public void feeding() {
        if(getAge(getDateOfBirth())<5 && getGender().equals('m')){
            System.out.println("Fed with grass (sheep)");
        }
        else if(getAge(getDateOfBirth())<8 && getGender().equals('f')){
            System.out.println("Fed with grass (sheep)");
        }
        else if(getAge(getDateOfBirth())>5 && getGender().equals('m')){
            System.out.println("TMR diets (sheep)");
        }
        else if(getAge(getDateOfBirth())>8 && getGender().equals('f')){
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