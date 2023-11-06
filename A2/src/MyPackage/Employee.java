package MyPackage;

import java.time.LocalDate;
/**
 * Employee is an abstract class which implements Payment and Comparable
 */
public abstract class Employee implements Payment, Comparable {
    private int empID;
    private String gender;
    private LocalDate dateOfBirth;

    /**
     * Constructor of Employee
     */
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

    /**
     * getters of Employee
     */
    public int getEmpID(){
        return this.empID;
    }
    public String getGender(){
        return this.gender;
    }
    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }

    /**
     * setters of Employee
     */
    public void setEmpID(int empID1){
        this.empID=empID1;
    }
    public void setGender(String gender1){
        this.gender=gender1;
    }
    public void setDateOfBirth(LocalDate dateOfBirth1){
        this.dateOfBirth=dateOfBirth1;
    }


    /**
     * getSalary and compareTo methods that belongs to Payment and comparable interface
     */
    public abstract double getSalary(Employee employee);

    public  abstract int compareTo(Employee obj);
}
