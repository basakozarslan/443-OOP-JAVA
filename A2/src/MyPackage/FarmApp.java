package MyPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * FarmApp Class
 */

public class FarmApp {
    static ArrayList<Animal> animals = new ArrayList<>();
    static ArrayList<Employee> employees = new ArrayList<>();

    /**
     * main method
     * @param args
     */

    public static void main(String[] args) {
        new PopulateData();
        menu();
        Scanner input = new Scanner(System.in);
        System.out.print("Choice: ");
        int choice = input.nextInt();

        while (choice < 1 || choice > 12) {
            System.out.print("Please enter a valid choice!");
            choice = input.nextInt();
        }

        while (choice != 12) {
            if (choice == 1) {
                addCow();
            }
            else if (choice == 2)
            {
                System.out.print("Please enter tagNo you want to delete:");
                int deletedTagNo = input.nextInt();
                deleteCow(deletedTagNo);
            } else if (choice == 3)
            {
                System.out.print("Please enter tagNo you want to learn details about cow:");
                int tagNo = input.nextInt();
                getCowDetails(tagNo);
            }
            else if (choice == 4)
            {
                addVet();
            }
            else if (choice == 5)
            {
                System.out.print("Please enter vetID you want to delete:");
                int deletedVetID = input.nextInt();
                deleteVet(deletedVetID);
            }
            else if (choice == 6)
            {
                System.out.print("Please enter vetID you want to learn details about veterinary:");
                int vetID = input.nextInt();
                getVetDetails(vetID);
            }
            else if(choice==7){
                System.out.print("Please enter tagNo: ");
                int tagNo= input.nextInt();

                while (isUniqueCow(tagNo)) {
                    System.out.print("The cow does not exist in the system. Please enter new tagNo: ");
                    tagNo = input.nextInt();
                }
                System.out.print("Please enter EmpId: ");
                int empID = input.nextInt();

                while (isUniqueVet(empID)) {
                    System.out.print("The employee does not exist in the system. Please enter new empID: ");
                    empID = input.nextInt();
                }
                addTreatment(tagNo,empID);
            }
            else if (choice == 8) {
                System.out.print("Please enter tagNo you want to learn treatment of cow:");
                int tagNo = input.nextInt();
                getCowTreatment(tagNo);
            }
            else if (choice == 9) {
                System.out.print("Please enter tagNo:");
                int tagNo = input.nextInt();
                if (!isUniqueCow(tagNo)) {
                    input.nextLine();
                    System.out.print("Please enter the date:");
                    String date = input.next();

                    try {
                        Date dateOfTreatment = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                        getCowTreatment(tagNo, dateOfTreatment);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    System.out.println("Cow with that tagNo is not found!");
                }
            }
            else if (choice == 10) {
                listCow();
            }
            else if (choice == 11) {
                listVet();
            }
            else if (choice == 12) {
                System.out.print("Please enter tagNo:");
                int tagNo = input.nextInt();
                feeding(tagNo);
            }
            else if (choice == 13) {
                System.out.print("Please enter empId: ");
                int empID = input.nextInt();
                getEmpSalary(empID);
            }
            else if (choice == 14) {
                System.out.print("Please enter tagNo: ");
                int tagNo = input.nextInt();
                System.out.print("Please enter amount: ");
                double amount = input.nextDouble();
                addMilkingMeasurement(tagNo, amount);
            }
            System.out.print("Choice: ");
            choice = input.nextInt();
            while (choice < 1 || choice > 15) {
                System.out.print("Please enter a valid choice!:");
                choice = input.nextInt();

            }
        }
        exit();

    }

    /**
     * menu of the program
     */
    static void menu () {
        System.out.println("Welcome to FarmMe App!");
        System.out.println("Please enter your choice:");
        System.out.println("1. Add Cow");
        System.out.println("2. Delete Cow");
        System.out.println("3. Get Cow Details");
        System.out.println("4. Add Vet");
        System.out.println("5. Delete Vet");
        System.out.println("6. Get Vet Details");
        System.out.println("7. Add Treatment");
        System.out.println("8. Get Cow Treatment");
        System.out.println("9. Get Cow Treatment with date");
        System.out.println("10. List Cow");
        System.out.println("11. List Vet");
        System.out.println("12. Feed Animal");
        System.out.println("13. Get Employee Salary");
        System.out.println("14. Add Milking Measurement");
        System.out.println("15. Exit");
    }
    /**
     * method that adds new cow
     */
    static void addCow () {
        Scanner input = new Scanner(System.in);
        Cow cow = new Cow();

        System.out.print("Enter tagNo:");
        int tagNo = input.nextInt();

        while (!isUniqueCow(tagNo)) {
            System.out.print("The cow is exist in the system. Please enter new tagNo: ");
            tagNo = input.nextInt();
        }
        if (isUniqueCow(tagNo)) {
            input.nextLine();
            System.out.print("Enter gender: ");
            String gender = input.next();
            System.out.print("Enter date of birth: ");
            LocalDate DOB = LocalDate.parse(input.next());
            System.out.print("Enter purchased or not: ");
            boolean purchase = input.hasNextInt();
            System.out.print("Enter weight: ");
            double weight = input.nextDouble();
            HashMap MyMap = new HashMap();
            MyMap.put(null,0);

            try {
                cow.setDateOfBirth(DOB);
            } catch (DateTimeParseException e) {
                e.printStackTrace();
            }

            cow.setTagNo(tagNo);
            cow.setGender(gender);
            cow.setPurchased(purchase);
            cow.setWeight(weight);

        }
        animals.add(cow);
    }
    /**
     * method that deletes the cow according to its tagNo
     * @param tagNo
     */
    static void deleteCow ( int tagNo){
        ArrayList<Cow> cows = new ArrayList<>();
        try {
            int check = 0;
            for (Cow cow1 : cows) {
                if (cow1.getTagNo() == tagNo){
                    check++;
                    cows.remove(cow1);
                    System.out.println("Cow with tagNo: " + tagNo + " is deleted.");
                    break;
                }
            }
            if (check == 0) {
                System.out.println("Cow with that tagNo is not found!");
            }
        } catch (Exception e){
            System.out.println("Cow with that tagNo is not found!");
        }
    }
    /**
     * method that get cow details & prints them to the screen
     * @param tagNo
     */
    static void getCowDetails ( int tagNo){
        ArrayList<Cow> cows = new ArrayList<>();
        if (!isUniqueCow(tagNo)) {
            for (Cow cow1 : cows) {
                if (cow1.getTagNo() == tagNo) {
                    System.out.println(cow1.getTagNo());
                    System.out.println(cow1.getGender());
                    System.out.println(cow1.getAge(cow1.getDateOfBirth()));
                    System.out.println(cow1.getWeight());
                    System.out.println(cow1.getMilking());
                    if(cow1.isPurchased()){
                        String cowPurchased = "purchased";
                        System.out.println(cowPurchased);
                    }
                    else{
                        String cowFarm = "Farm-raising";
                        System.out.println(cowFarm);
                    }
                }
            }
        } else {
            System.out.println("Cow with that tagNo is not found!");
        }
    }
    /**
     * method that adds new vet
     */
    static void addVet ()  {
        Scanner input = new Scanner(System.in);
        Veterinary vet = new Veterinary();

        System.out.print("Enter empID:");
        int empID = input.nextInt();

        while (!isUniqueVet(empID)) {
            System.out.print("The employee is exist in the system. Please enter new empID: ");
            empID = input.nextInt();
        }
        if(isUniqueVet(empID)) {
            input.nextLine();
            System.out.print("Enter gender: ");
            String gender = input.next();
            System.out.print("Enter date of birth: ");
            LocalDate DOB = LocalDate.parse(input.next());

            try{
                System.out.print("Enter BScDegree: ");
                boolean BScDegree = input.hasNextInt();
                vet.setBScDegree(BScDegree);
            }
            catch (RuntimeException e){
                e.printStackTrace();
            }

            System.out.print("Enter dateOfGraduation: ");
            LocalDate dateOfGraduation = LocalDate.parse(input.next());
            System.out.print("Enter expertise level: ");
            int expertiseLevel = input.nextInt();

            try {
                vet.setDateOfBirth(DOB);
                vet.setDateOfGraduation(dateOfGraduation);
            } catch (DateTimeParseException e) {
                e.printStackTrace();
            }

            vet.setEmpID(empID);
            vet.setGender(gender);

            vet.setExpertiseLevel(expertiseLevel);
        }
        employees.add(vet);
    }
    /**
     * method that deletes the vet according to its vetID
     * @param empID
     */
    static void deleteVet ( int empID){
        ArrayList<Veterinary> vets = new ArrayList<>();
        try {
            int check = 0;
            for (Veterinary vet1 : vets) {
                if (vet1.getEmpID() == empID){
                    check++;
                    vets.remove(vet1);
                    System.out.println("Employee with empID: " + empID + " is deleted.");
                    break;
                }
            }
            if (check == 0) {
                System.out.println("Employee with empID is not found!");
            }
        } catch (Exception e){
            System.out.println("Employee with empID is not found!");
        }
    }
    /**
     * method that gets the details of vet & prints them to screen
     * @param empID
     */
    static void getVetDetails ( int empID){
        ArrayList<Veterinary> vets = new ArrayList<>();
        if (!isUniqueVet(empID)) {
            for (Veterinary vet1 : vets) {
                if (vet1.getEmpID() == empID) {
                    System.out.println(vet1.getEmpID());
                    System.out.println(vet1.getGender());
                    System.out.println(vet1.getDateOfBirth());
                    System.out.println(vet1.isBScDegree());
                    System.out.println(vet1.getDateOfGraduation());
                    System.out.println(vet1.getExpertiseLevel());
                }
            }
        } else {
            System.out.println("Employee with empID is not found!");
        }
    }
    /**
     * method that add new treatment and medications based on added treatment
     * it checks the vetId & tagNo existence
     * @param empId
     * @param tagNo
     */
    static void addTreatment(int empId, int tagNo){
        Scanner input = new Scanner(System.in);
        Treatment treatment = new Treatment();
        Medication medication = new Medication();
        HealthTreatment healthTreatment = new HealthTreatment();
        CleaningTreatment cleaningTreatment = new CleaningTreatment();

        if((!isUniqueCow(tagNo) && !isUniqueVet(empId))) {
            ArrayList<Cow> cows = new ArrayList<>();
            for (Cow cow1 : cows) {
                if (cow1.getTagNo() == tagNo) {
                    System.out.print("Enter type of treatment:");
                    String typeOfTreatment = input.next();
                    if(typeOfTreatment=="Cleaning") {
                        System.out.print("Enter date of treatment:");
                        String dateOfTreatment = input.next();
                        System.out.print("Enter materials used:");
                        String materialsUsed = input.next();
                        cleaningTreatment.setMaterialsused(materialsUsed);
                        try {
                            Date DOT = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfTreatment);
                            healthTreatment.setDateOfTreatment(DOT);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        System.out.print("Enter date of treatment:");
                        String dateOfTreatment = input.next();
                        System.out.print("Enter it is emergency or not:");
                        String emergency = input.next();
                        if (emergency == "emergency") {
                            healthTreatment.setEmergency(true);
                        }
                        else{
                            healthTreatment.setEmergency(false);
                        }
                        System.out.print("Enter medication details:");
                        String detailsOfMed = input.next();
                        medication.setDetails(detailsOfMed);
                        System.out.print("Enter duration:");
                        int duration = input.nextInt();
                        medication.setDuration(duration);
                        System.out.print("Enter start date of medication:");
                        String startDate = input.next();
                        System.out.print("Enter dosage of medication:");
                        double dosage = input.nextDouble();
                        medication.setDosage(dosage);
                        System.out.print("Enter notes of medication:");
                        String notes = input.next();
                        medication.setNotes(notes);

                        try {
                            Date DOT = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfTreatment);
                            healthTreatment.setDateOfTreatment(DOT);

                            Date DOT2 = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
                            medication.setStartDate(DOT2);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
                cow1.newTreatments(treatment);
                cow1.newMedications(medication);
            }

        }

    }
    /**
     * method that gets cow treatment just checking tagNo
     * @param tagNo
     */

    static void getCowTreatment ( int tagNo){
        ArrayList<Cow> cows = new ArrayList<>();
        HealthTreatment healthTreatment = new HealthTreatment();
        CleaningTreatment cleaningTreatment = new CleaningTreatment();
        if (!isUniqueCow(tagNo)) {
            for (Cow cow1 : cows) {
                if (cow1.getTagNo() == tagNo) {
                    ArrayList<HealthTreatment> cowTreatment;
                    ArrayList<CleaningTreatment>cowTreatment2;
                    ArrayList<Medication> cowMedication;
                    cowTreatment = cow1.getHTreatments();
                    cowTreatment2= cow1.getCTreatments();
                    cowMedication = cow1.getMedications();

                    Scanner input = new Scanner(System.in);
                    System.out.print("Enter type of treatment:");
                    String typeOfTreatment = input.next();
                    if(typeOfTreatment=="Cleaning"){
                        int i;
                        for (i = 0; i < cowTreatment2.size(); i++){
                            Treatment treatment = cowTreatment2.get(i);
                            System.out.println("TagNo: " + cow1.getTagNo());
                            System.out.println("Date Of Treatments: " + treatment.getDateOfTreatment());
                            System.out.println("Materials used for Cleaning: " + cleaningTreatment.getMaterialsused());
                        }
                    }
                    else {
                        int i;
                        for (i = 0; i < cowMedication.size(); i++){
                            Treatment treatment = cowTreatment.get(i);
                            Medication medication = cowMedication.get(i);
                            System.out.println("TagNo: " + cow1.getTagNo());
                            System.out.println("Date Of Treatments: " + treatment.getDateOfTreatment());
                            System.out.println("Treatment situation: " + healthTreatment.isEmergency());
                            System.out.println("Details of Medication: " + medication.getDetails());
                            System.out.println("Duration: " + medication.getDuration());
                            System.out.println("Start Date: " + medication.getStartDate());
                            System.out.println("Dosage: " + medication.getDosage());
                            System.out.println("Notes: " + medication.getNotes());
                        }

                    }
                }
            }
        } else {
            System.out.println("Cow with that tagNo is not found!");
        }

    }

    /**
     * method that gets the cow treatment by checking
     * existence of cow & date of this treatment
     * @param tagNo
     * @param dateOfTreatment
     */
    static void getCowTreatment ( int tagNo, Date dateOfTreatment){
        ArrayList<Cow> cows = new ArrayList<>();
        HealthTreatment healthTreatment = new HealthTreatment();
        CleaningTreatment cleaningTreatment = new CleaningTreatment();
        try{
            int check1=0, check2=0;
            for (Cow cow1 : cows) {
                if (cow1.getTagNo() == tagNo) {
                    check1++;
                    ArrayList<Medication> cowMedication;
                    ArrayList<HealthTreatment> cowTreatment;
                    ArrayList<CleaningTreatment>cowTreatment2;
                    cowMedication = cow1.getMedications();
                    cowTreatment = cow1.getHTreatments();
                    cowTreatment2 = cow1.getCTreatments();

                    Scanner input = new Scanner(System.in);
                    System.out.print("Enter type of treatment:");
                    String typeOfTreatment = input.next();

                    if(typeOfTreatment=="Cleaning") {
                        int i;
                        for (i = 0; i < cowTreatment2.size(); i++) {
                            Treatment treatment = cowTreatment2.get(i);
                            if (treatment.getDateOfTreatment().equals((dateOfTreatment))) {
                                System.out.println("TagNo: " + cow1.getTagNo());
                                System.out.println("Materials used: " + cleaningTreatment.getMaterialsused());
                                check2++;
                            }
                        }
                        break;
                    }
                    else{
                        int i;
                        for (i = 0; i < cowMedication.size(); i++) {
                            Medication medication = cowMedication.get(i);
                            Treatment treatment = cowTreatment.get(i);
                            if (treatment.getDateOfTreatment().equals((dateOfTreatment))) {
                                System.out.println("TagNo: " + cow1.getTagNo());
                                System.out.println("Emergency: " + healthTreatment.isEmergency());
                                System.out.println("Details of Medication: " + medication.getDetails());
                                System.out.println("Duration: " + medication.getDuration());
                                System.out.println("Start Date: " + medication.getStartDate());
                                System.out.println("Dosage: " + medication.getDosage());
                                System.out.println("Notes: " + medication.getNotes());
                                check2++;
                            }
                        }
                        break;
                    }
                }
            }
            if(check1==0){
                System.out.println("Cow with that tagNo is not found!");
            }
            if(check2==0){
                System.out.println("Medication & Treatment with that date is not found!");
            }
        } catch (Exception e){
            System.out.println("Cow Treatment is not found!");
        }
    }

    /**
     * feeding method for animals
     */
    static void feeding (int tagNo){
        ArrayList<Cow> cows = new ArrayList<>();
        ArrayList<Sheep> sheeps = new ArrayList<>();
        for (Cow cow : cows) {
            for(Sheep sheep : sheeps){
            if (tagNo == cow.tagNo){
                cow.feeding();
            }
            else{
                sheep.feeding();
            }
            }
        }
    }

    /**
     * method that gets the salary of employees
     */
    static double getEmpSalary(int empId) {
        ArrayList<Veterinary> vets = new ArrayList<>();
        ArrayList<FarmWorker> farmWorkers = new ArrayList<>();
        if (!isUniqueVet(empId)) {
            for (Veterinary vet1 : vets) {
                if (vet1.getEmpID() == empId) {
                    return vet1.getSalary(vet1);
                }
            }
        }
        else if (!isUniqueFarmWorker(empId)) {
            for(FarmWorker farmWorker1 : farmWorkers){
                if (farmWorker1.getEmpID() == empId) {
                    return farmWorker1.getSalary(farmWorker1);
                }
            }
        }
        else {
            System.out.println("Employee with empId is not found!");
        }
        return 0;
    }

    /**
     * method that adds milking measurements
     */
    static void addMilkingMeasurement(int tagNo, double amount){
        ArrayList<Cow> cows = new ArrayList<>();
        ArrayList<Sheep> sheeps = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        //Map<LocalDate,Double> milking =new HashMap<LocalDate,Double>();
        Map milking = new HashMap();
        LocalDate currentDate = LocalDate.now();
        milking.put(currentDate, amount);

        for(Cow cow : cows) {
            for (Sheep sheep : sheeps) {
                if (cow.getTagNo()== tagNo){
                    cow.setTagNo(tagNo);
                    cow.milking.put(currentDate, amount);
                    animals.add(cow);
                }
                else if(sheep.getTagNo()== tagNo){
                    sheep.setTagNo(tagNo);
                    sheep.milking.put(currentDate, amount);
                    animals.add(sheep);
                }
                else{
                    System.out.print("Animal does not exist with this tagNo!");
                }
            }
        }
    }
    /**
     * method that prints all the cows as a list
     */
    static void listCow () {
        ArrayList<Cow> cows = new ArrayList<>();
        for (Cow cow : cows) {
            if(!(cow.isPurchased())){
                String cowPurchased = "purchased";
                System.out.println(cow.getTagNo() +"\t"+ cow.getGender() +"\t"+ cow.getAge(cow.getDateOfBirth()) +"\t"+ cowPurchased);
            }
            else{
                String cowFarm = "Farm-raising";
                System.out.println(cow.getTagNo() +"\t"+ cow.getGender() +"\t"+ cow.getAge(cow.getDateOfBirth()) +"\t"+ cowFarm);
            }
        }
    }
    /**
     * method that prints all the vets as a list
     */
    static void listVet () {
        ArrayList<Veterinary> vets = new ArrayList<>();
        for (Veterinary vet : vets) {
            System.out.println(vet.getEmpID() +"\t"+ vet.getGender() +"\t"+ vet.getDateOfBirth() +"\t"+ vet.getSalary(vet));
        }
    }
    /**
     * method that terminates the program
     */
    static void exit () {
        System.out.println("GoodBye!!");
    }
    /**
     * method that determines the existence of cow based on its tagNo
     * @param tagNo
     * @return true or false as a boolean
     */
    static boolean isUniqueCow ( int tagNo){
        ArrayList<Cow> cows = new ArrayList<>();
        for (Cow cow1 : cows) {
            if (cow1.getTagNo() == tagNo)
                return false;
        }
        return true;
    }
    /**
     * method that determines the existence of emp based on its empID
     * @param empID
     * @return true or false as a boolean
     */
    static boolean isUniqueVet ( int empID){
        ArrayList<Veterinary> vets = new ArrayList<>();
        for (Veterinary vet1 : vets) {
            if (vet1.getEmpID() == empID)
                return false;
        }
        return true;

    }
    /**
     * method that determines the existence of emp based on its empID
     * @param empID
     * @return true or false as a boolean
     */
    static boolean isUniqueFarmWorker ( int empID){
         ArrayList<FarmWorker> farmWorkers = new ArrayList<>();
         for (FarmWorker farmWorker1 : farmWorkers) {
             if (farmWorker1.getEmpID() == empID)
                return false;
         }
         return true;
    }
}
