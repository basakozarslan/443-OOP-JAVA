package MyPackage;

/**
 * HealthTreatment class which extends Treatment
 */
public class HealthTreatment extends Treatment{
    private boolean emergency;
    /**
     * constructors of HealthTreatments
     */
    public HealthTreatment(){
        this.emergency=false;
    }

    public HealthTreatment(boolean emergency){
        this.emergency=emergency;
    }
    /**
     * getters of HealthTreatments
     */
    public boolean isEmergency() {
        return emergency;
    }
    /**
     * setters of HealthTreatments
     */
    public void setEmergency(boolean emergency1) {
        this.emergency = emergency1;
    }
}
