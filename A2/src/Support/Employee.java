package Support;

import java.time.LocalDate;

public abstract class Employee implements Payment, Comparable {
    private int empID;
    private String gender;
    private LocalDate dateOfBirth;

    public Employee(){
        this.empID=0;
        this.gender=null;
        this.dateOfBirth=null;
    }

    public Employee(int empID, String gender, LocalDate dateOfBirth){
        this.empID=empID;
        this.gender=gender;
        this.dateOfBirth=dateOfBirth;
    }

    //getters
    public int getEmpID(){
        return this.empID;
    }
    public String getGender(){
        return this.gender;
    }
    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }

    //setters
    public void setEmpID(int empID1){
        this.empID=empID1;
    }
    public void setGender(String gender1){
        this.gender=gender1;
    }
    public void setDateOfBirth(LocalDate dateOfBirth1){
        this.dateOfBirth=dateOfBirth1;
    }


    public abstract double getSalary(Employee employee);

    public  abstract int compareTo(Employee obj);
}
