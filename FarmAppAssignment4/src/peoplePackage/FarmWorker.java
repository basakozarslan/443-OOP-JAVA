package peoplePackage;
import medicalPackage.Treatment;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class FarmWorker extends Employee implements Serializable {
    //default serialVersion id
    private static final long serialVersionUID = 1L;
    private String previousFarmName;
    private int workexperience;
    private ArrayList<Treatment> treatments = new ArrayList<>();


    public FarmWorker(){
        super();
        this.previousFarmName="Not Defined";
        this.workexperience=0;
    }
    public FarmWorker(int empID, String gender, LocalDate dateOfBirth,String previousFarmName, int workexperience){
        super(empID,gender,dateOfBirth);
        this.previousFarmName=previousFarmName;
        this.workexperience=workexperience;
    }

    public FarmWorker(int empID){super(empID);}

    public String getPreviousFarmName(){
        return this.previousFarmName;
    }
    public int getWorkexperience(){
        return this.workexperience;
    }

    public ArrayList<Treatment> getTreatments(){return treatments;}
    public void setPreviousFarmName(String previousFarmName1){
        this.previousFarmName=previousFarmName1;
    }
    public void setWorkexperience(int workexperience1){
        this.workexperience=workexperience1;
    }

    public void setTreatments(Treatment treatment){treatments.add(treatment);}

    @Override
    public double getSalary() {
        return ((Payment.grossSalary)+((getWorkexperience()*2)/100.0));
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return new StringBuffer ("empID: ").append(this.getEmpID())
                .append("Gender: ").append(this.getGender())
                .append("PreviousFarmName: ").append(this.getPreviousFarmName())
                .append("Workexperience: ").append(this.getWorkexperience())
                .append("Date Of Birth ").append(this.getDateOfBirth()).toString();
    }


}