package MyPackage;

/**
 * FarmWorker Class that extends Employee
 */
public class FarmWorker extends Employee {
    private String previousFarmName;
    private int workexperience;

    /**
     * FarmWorker Constructor
     */
    public FarmWorker(){
        this.previousFarmName=null;
        this.workexperience=0;
    }
    public FarmWorker(String previousFarmName, int workexperience){
        this.previousFarmName=previousFarmName;
        this.workexperience=workexperience;
    }

    /**
     * getSalary is a method which belongs to Payment interface
     * employee is abstract class because of that I implemented it in subclass
     */
    @Override
    public double getSalary(Employee employee) {
        double gSalary = (Payment.grossSalary)+((this.workexperience*2)/100);
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

    /**
     * getters of FarmWorker
     */
    public String getPreviousFarmName(){
        return this.previousFarmName;
    }
    public int getWorkexperience(){
        return this.workexperience;
    }
    /**
     * setters of FarmWorker
     */
    public void setPreviousFarmName(String previousFarmName1){
        this.previousFarmName=previousFarmName1;
    }
    public void setWorkexperience(int workexperience1){
        this.workexperience=workexperience1;
    }

}
