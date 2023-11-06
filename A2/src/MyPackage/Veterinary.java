package MyPackage;

import java.time.LocalDate;
import java.time.Period;


/**
 * Veterinary Class that extends Employee
 */
public class Veterinary extends Employee {

    private boolean BScDegree;
    private LocalDate dateOfGraduation ;
    private int expertiseLevel;

    /**
     * Constructor of Veterinary
     */
    public Veterinary(){
        this.BScDegree=false;
        this.dateOfGraduation=null;
        this.expertiseLevel=0;
    }
    /**
     * Constructor of Veterinary
     */
    public Veterinary(boolean BScDegree, LocalDate dateOfGraduation, int expertiseLevel){
        this.BScDegree=BScDegree;
        this.dateOfGraduation=dateOfGraduation;
        this.expertiseLevel=expertiseLevel;
    }
    /**
     * getters of Veterinary
     */
    public boolean isBScDegree(){
        return this.BScDegree;
    }
    public LocalDate getDateOfGraduation(){
        return this.dateOfGraduation;
    }
    public int getExpertiseLevel(){
        return this.expertiseLevel;
    }
    /**
     * setters of Veterinary
     */
    public void setBScDegree(boolean BScDegree1){
        this.BScDegree=BScDegree1;
    }
    public void setDateOfGraduation(LocalDate dateOfGraduation1){
        this.dateOfGraduation=dateOfGraduation1;
    }
    public void setExpertiseLevel(int expertiseLevel1){
        this.expertiseLevel=expertiseLevel1;
    }


    /**
     * getSalary is a method which belongs to Payment interface
     * employee is abstract class because of that I implemented it in subclass
     */

    @Override
    public double getSalary(Employee employee) {
       LocalDate dateOfGrad = this.dateOfGraduation ;
       LocalDate currentDate = LocalDate.now();
       double gradYear= Period.between(dateOfGrad, currentDate).getYears();
       double gSalary = (Payment.grossSalary)+((Payment.grossSalary*10)/100)*gradYear;
       return gSalary;
    }
    /**
     * compareTo is a method which belongs to employee
     *  employee is abstract class because of that I implemented it in subclass
     */
    @Override
    public int compareTo(Employee obj) {
        return 0;
    }
}
