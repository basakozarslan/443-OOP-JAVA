package MyPackage;

/**
 * CleaningTreatment class which extends Treatment
 */
public class CleaningTreatment extends Treatment {
    private String materialsused;

    /**
     * constructor of  CleaningTreatment
     */
    public CleaningTreatment(){
        this.materialsused=null;
    }


    public CleaningTreatment(String materialsused){
        this.materialsused=materialsused;
    }
    /**
     * getters and setters CleaningTreatment
     */
    public String getMaterialsused() {
        return materialsused;
    }

    public void setMaterialsused(String materialsused) {
        this.materialsused = materialsused;
    }
}
