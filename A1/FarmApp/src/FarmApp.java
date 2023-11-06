import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.lang.String;


/**
 * FarmMe Class
 */

public class FarmApp {

    static ArrayList<Cow> cows = new ArrayList<>();
    static ArrayList<Veterinary> vets = new ArrayList<>();


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
                System.out.print("Please enter vetId: ");
                int vetID = input.nextInt();

                while (isUniqueVet(vetID)) {
                    System.out.print("The vet does not exist in the system. Please enter new vetID: ");
                    vetID = input.nextInt();
                }
                addTreatment(tagNo,vetID);
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
            else {
                for (Cow cow : cows) {
                    System.out.println(cow.getTagNo() + "" + cow.getAge() + "" + cow.getGender() + "" + cow.isPurchased());
                }
            }
            System.out.print("Choice: ");
            choice = input.nextInt();
            while (choice < 1 || choice > 12) {
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
        System.out.println("12. Exit");
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
            String DOB = input.next();
            System.out.print("Enter purchased or not: ");
            boolean purchase = input.hasNextInt();

            try {
                Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(DOB);
                cow.setDateOfBirth(dateOfBirth);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            cow.setTagNo(tagNo);
            cow.setGender(gender);
            cow.setPurchased(purchase);

        }
        cows.add(cow);
    }

    /**
     * method that deletes the cow according to its tagNo
     * @param tagNo
     */
    static void deleteCow ( int tagNo){
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
        if (!isUniqueCow(tagNo)) {
            for (Cow cow1 : cows) {
                if (cow1.getTagNo() == tagNo) {
                    System.out.println(cow1.getTagNo());
                    System.out.println(cow1.getGender());
                    System.out.println(cow1.getAge());
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
        System.out.print("Enter vetID:");
        int vetID = input.nextInt();


        while (!isUniqueVet(vetID)) {
            System.out.print("The vet is exist in the system. Please enter new vetID: ");
            vetID = input.nextInt();
        }
        if(isUniqueVet(vetID)) {
            input.nextLine();
            System.out.print("Enter gender: ");
            String gender = input.next();
            System.out.print("Enter date of birth: ");
            String DOB = input.next();
            System.out.print("Enter salary: ");
            double salary = input.nextDouble();

            try {
                Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(DOB);
                vet.setDateOfBirth(dateOfBirth);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            vet.setVetID(vetID);
            vet.setGender(gender);
            vet.setSalary(salary);
        }
        vets.add(vet);
    }

    /**
     * method that deletes the vet according to its vetID
     * @param vetID
     */
    static void deleteVet ( int vetID){
        try {
            int check = 0;
            for (Veterinary vet1 : vets) {
                if (vet1.getVetID() == vetID){
                    check++;
                    vets.remove(vet1);
                    System.out.println("Vet with vetID: " + vetID + " is deleted.");
                    break;
                }
            }
            if (check == 0) {
                System.out.println("Vet with that vetID is not found!");
            }
        } catch (Exception e){
            System.out.println("Vet with that vetID is not found!");
        }
    }

    /**
     * method that gets the details of vet & prints them to screen
     * @param vetID
     */
    static void getVetDetails ( int vetID){
        if (!isUniqueVet(vetID)) {
            for (Veterinary vet1 : vets) {
                if (vet1.getVetID() == vetID) {
                    System.out.println(vet1.getVetID());
                    System.out.println(vet1.getGender());
                    System.out.println(vet1.getDateOfBirth());
                    System.out.println(vet1.getSalary());
                }
            }
        } else {
            System.out.println("Vet with that vetID is not found!");
        }
    }

    /**
     * method that add new treatment and medications based on added treatment
     * it checks the vetId & tagNo existence
     * @param vetId
     * @param tagNo
     */
    static void addTreatment(int vetId, int tagNo) {
        Scanner input = new Scanner(System.in);
        Treatment treatment = new Treatment();
        Medication medication = new Medication();

        if((!isUniqueCow(tagNo) && !isUniqueVet(vetId))) {
            for (Cow cow1 : cows) {
                if (cow1.getTagNo() == tagNo) {
                    System.out.print("Enter date of treatment:");
                    String dateOfTreatment = input.next();
                    System.out.print("Enter treatment details:");
                    String details = input.next();
                    treatment.setDetails(details);

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
                        treatment.setDateOfTreatment(DOT);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    try {
                        Date DOT2 = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
                        medication.setStartDate(DOT2);
                    } catch (ParseException e) {
                        e.printStackTrace();
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

        if (!isUniqueCow(tagNo)) {
            for (Cow cow1 : cows) {
                if (cow1.getTagNo() == tagNo) {
                    ArrayList<Treatment> cowTreatment;
                    ArrayList<Medication> cowMedication;
                    cowTreatment = cow1.getTreatments();
                    cowMedication = cow1.getMedications();
                    int i;
                    for (i = 0; i < cowMedication.size(); i++){
                        Treatment treatment = cowTreatment.get(i);
                        Medication medication = cowMedication.get(i);
                        System.out.println("TagNo: " + cow1.getTagNo());
                        System.out.println("Date Of Treatments: " + treatment.getDateOfTreatment());
                        System.out.println("Details of Treatment: " + treatment.getDetails());
                        System.out.println("Details of Medication: " + medication.getDetails());
                        System.out.println("Duration: " + medication.getDuration());
                        System.out.println("Start Date: " + medication.getStartDate());
                        System.out.println("Dosage: " + medication.getDosage());
                        System.out.println("Notes: " + medication.getNotes());
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
        try{
            int check1=0, check2=0;
            for (Cow cow1 : cows) {
                if (cow1.getTagNo() == tagNo) {
                    check1++;
                    ArrayList<Medication> cowMedication;
                    ArrayList<Treatment> cowTreatment;
                    cowMedication = cow1.getMedications();
                    cowTreatment = cow1.getTreatments();
                    int i;
                    for (i = 0; i < cowMedication.size(); i++) {
                        Medication medication = cowMedication.get(i);
                        Treatment treatment = cowTreatment.get(i);
                        if (treatment.getDateOfTreatment().equals((dateOfTreatment))) {
                            System.out.println("TagNo: " + cow1.getTagNo());
                            System.out.println("Details of Treatment: " + treatment.getDetails());
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
     * method that prints all the cows as a list
     */
    static void listCow () {
        for (Cow cow : cows) {
            if(!(cow.isPurchased())){
                String cowPurchased = "purchased";
                System.out.println(cow.getTagNo() +"\t"+ cow.getGender() +"\t"+ cow.getAge() +"\t"+ cowPurchased);
            }
            else{
                String cowFarm = "Farm-raising";
                System.out.println(cow.getTagNo() +"\t"+ cow.getGender() +"\t"+ cow.getAge() +"\t"+ cowFarm);
            }
        }
    }

    /**
     * method that prints all the vets as a list
     */
    static void listVet () {
        for (Veterinary vet : vets) {
            System.out.println(vet.getVetID() +"\t"+ vet.getGender() +"\t"+ vet.getDateOfBirth() +"\t"+ vet.getSalary());
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
        for (Cow cow1 : cows) {
            if (cow1.getTagNo() == tagNo)
                return false;
        }
        return true;
    }

    /**
     * method that determines the existence of vet based on its vetID
     * @param vetID
     * @return true or false as a boolean
     */
    static boolean isUniqueVet ( int vetID){
        for (Veterinary vet1 : vets) {
            if (vet1.getVetID() == vetID)
                return false;
        }
        return true;

    }

}