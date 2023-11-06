package peoplePackage;
import medicalPackage.Treatment;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Employee implements Payment, Comparable, Serializable {
    //default serialVersion id
    private static final long serialVersionUID = 1L;
    private int empID;
    private String gender;
    private LocalDate dateOfBirth;

    private ArrayList<Treatment> treatments = new ArrayList();

    public Employee(){
        this.empID=0;
        this.gender="Not Defined";
        this.dateOfBirth=null;
    }

    public Employee(int empID, String gender, LocalDate dateOfBirth){
        this.empID=empID;
        this.gender=gender;
        this.dateOfBirth=dateOfBirth;
    }


    public int getEmpID(){
        return this.empID;
    }
    public String getGender(){
        return this.gender;
    }
    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }

    public void setEmpID(int empID1){
        this.empID=empID1;
    }
    public void setGender(String gender1){
        this.gender=gender1;
    }
    public void setDateOfBirth(LocalDate dateOfBirth1){
        this.dateOfBirth=dateOfBirth1;
    }

    public ArrayList<Treatment> getTreatments(){
        return treatments;
    }
    public void newTreatments (Treatment treatment) { treatments.add(treatment); }

    @Override
    public String toString() {
        return new StringBuffer ("empID: ").append(this.getEmpID())
                .append("Gender: ").append(this.getGender())
                .append("Date Of Birth ").append(this.getDateOfBirth()).toString();
    }

}