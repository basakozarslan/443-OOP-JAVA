package mainPackage;

import animalsPackage.Animal;
import animalsPackage.Cow;
import animalsPackage.Sheep;
import medicalPackage.CleaningTreatment;
import medicalPackage.HealthTreatment;
import medicalPackage.Medication;
import medicalPackage.Treatment;
import peoplePackage.Employee;
import peoplePackage.FarmWorker;
import peoplePackage.Veterinary;


import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class FarmApp {

    //File medicationFile = new File("Medication.ser");
    //File treatmentFile = new File("Treatment.ser");

    public static void main(String[] args) {}


    public static void addCow (String tagNo, char gender, String dateOfBirth, String purchased, String milking,double weight) {
        Scanner input = new Scanner(System.in);
        Cow cow= new Cow();
        //THIS TRY-CATCH BLOCK IS ADDED TO AVOID WRONG-TYPE-INPUTS' CONSEQUENCES
        try {

            dateOfBirth = String.valueOf(LocalDate.parse(input.next()));

            cow.setTagNo(Integer.parseInt(tagNo));
            cow.setGender(gender);
            cow.setPurchased(Boolean.parseBoolean(purchased));
            //cow.setMilking(milking);
            cow.setWeight(weight);
            cow.setDateOfBirth(LocalDate.parse(dateOfBirth));

            CowWriteObjectToFile("Cow.txt", cow);
        } //TRY-CATCH BLOCK IS HANDLING THE EXCEPTION THAT IS THROWN BECAUSE OF DIFFERENT-TYPE-DATA ENTRY
        //LIKE STRING TYPE FOR ID ENTRY
        catch (InputMismatchException e){
            System.out.println("PLEASE ENTER VALID INPUTS!");
        }

    }

    public static void addSheep (String tagNo, char gender, String dateOfBirth, String purchased, String milking) {
        Scanner input = new Scanner(System.in);
        Sheep sheep = new Sheep();
        //THIS TRY-CATCH BLOCK IS ADDED TO AVOID WRONG-TYPE-INPUTS' CONSEQUENCES
        try {
            dateOfBirth = String.valueOf(LocalDate.parse(input.next()));

            sheep.setTagNo(Integer.parseInt(tagNo));
            sheep.setGender(gender);
            sheep.setPurchased(Boolean.parseBoolean(purchased));
            //sheep.setMilking(String.valueOf(milking));
            sheep.setDateOfBirth(LocalDate.parse(dateOfBirth));

            SheepWriteObjectToFile("Sheep.txt", sheep);
        } //TRY-CATCH BLOCK IS HANDLING THE EXCEPTION THAT IS THROWN BECAUSE OF DIFFERENT-TYPE-DATA ENTRY
        //LIKE STRING TYPE FOR ID ENTRY
        catch (InputMismatchException e){
            System.out.println("PLEASE ENTER VALID INPUTS!");
        }

    }

    public static void deleteCow ( int tagNo){
        ArrayList<Cow> cows = CowArrayList();

        for(Cow cow: cows){
            if(cow.getTagNo()==tagNo){
                cows.remove(cow);
                UpdateCowFile(cows);
                break;
            }
        }
    }
    public static ArrayList<Cow> getCowDetails ( int tagNo) {
        ArrayList<Cow> cows = CowArrayList();
        ArrayList<Cow> returnCows = null;

        for (Cow cow: cows) {
            if(cow.getTagNo()==tagNo){
                System.out.println(cow.toString());
                returnCows.add(cow);
                break;
            }
        }
        return cows;
    }


    public static void addVet (String empID, char gender, String BScDegree, String expertiseLevel, String dateOfGrad,String dateOfBirth){
        Scanner input = new Scanner(System.in);
        Veterinary vet = new Veterinary();

        try{
            dateOfBirth = String.valueOf(LocalDate.parse(input.next()));
            dateOfGrad = String.valueOf(LocalDate.parse(input.next()));

            vet.setEmpID(Integer.parseInt(empID));
            vet.setGender(String.valueOf(gender));
            vet.setDateOfBirth(LocalDate.parse(dateOfBirth));
            vet.setBScDegree(Boolean.parseBoolean(BScDegree));
            vet.setDateOfGraduation(LocalDate.parse(dateOfGrad));
            vet.setExpertiseLevel(Integer.parseInt(expertiseLevel));

            VeterinaryWriteObjectToFile("Veterinary.txt", vet);
        } //TRY-CATCH BLOCK IS HANDLING THE EXCEPTION THAT IS THROWN BECAUSE OF DIFFERENT-TYPE-DATA ENTRY
        //LIKE STRING TYPE FOR ID ENTRY
        catch (InputMismatchException e){
            System.out.println("PLEASE ENTER VALID INPUTS!");
        }
    }

    public static void deleteVet ( int empID){
        ArrayList<Veterinary> vets = VetArrayList();

        for(Veterinary vet: vets){
            if(vet.getEmpID()==empID){
                vets.remove(vet);
                UpdateVetFile(vets);
                break;
            }
        }
    }

        public static ArrayList<Veterinary> getVetDetails ( int empID) {
            ArrayList<Veterinary> vets = VetArrayList();
            ArrayList<Veterinary> returnVets = null;

            for (Veterinary vet : vets) {
                if(vet.getEmpID()==empID){
                    System.out.println(vet.toString());
                    returnVets.add(vet);
                    break;
                }
            }
            return vets;
        }

        public static void addHealthTreatment(LocalDate dateOfTreatment, boolean emergency)
        {   Scanner input = new Scanner(System.in);
            HealthTreatment healthTreatment = new HealthTreatment();
            ArrayList<Veterinary> vets = VetArrayList();

            for(Veterinary vet : vets){

                //SETTING THE INSTANCE IS COMPLETED AFTER BEING SURE THAT THERE IS NO EXCEPTION
                try{
                    dateOfTreatment =  LocalDate.parse(input.next());

                    ArrayList<Medication> vetMedications = vet.getMedications();
                    for(Medication medication : vetMedications){
                        if(medication.getStartDate()== dateOfTreatment){
                            healthTreatment.setMedication(medication);
                            break;
                        }
                    }

                    healthTreatment.setDateOfTreatment(dateOfTreatment);
                    healthTreatment.setEmergency(emergency);

                    vet.setTreatments(healthTreatment);
                    UpdateVetFile(vets);
                }//SYSTEM MAKES SURE THAT DATE IS IN THE RIGHT FORMAT.
                catch (InputMismatchException e) {
                    System.out.println("PLEASE ENTER THE DATE INTO DD/MM/YYYY FORMAT!");
                }
            }
        }
    public static void addCleaningTreatment(LocalDate dateOfTreatment, String materialsUsed) {
        Scanner input = new Scanner(System.in);
        ArrayList<FarmWorker> farmWorkers = FarmWorkerArraylist();

        for(FarmWorker farmWorker : farmWorkers){
            CleaningTreatment cleaningTreatment = new CleaningTreatment();

            //SETTING THE INSTANCE IS COMPLETED AFTER BEING SURE THAT THERE IS NO EXCEPTION
            try{
                dateOfTreatment =  LocalDate.parse(input.next());



                cleaningTreatment.setDateOfTreatment(dateOfTreatment);
                cleaningTreatment.setMaterialsused(materialsUsed);

                farmWorker.setTreatments(cleaningTreatment);
                UpdateFarmWorkerFile(farmWorkers);
            }//SYSTEM MAKES SURE THAT DATE IS IN THE RIGHT FORMAT.
            catch (InputMismatchException e) {
                System.out.println("PLEASE ENTER THE DATE INTO DD/MM/YYYY FORMAT!");
            }
        }
    }

    public static void getCowTreatment ( int tagNo) {
        ArrayList<Cow> cows = CowArrayList();

        for (Cow cow : cows) {
            if (cow.getTagNo() == tagNo) {
                ArrayList<Treatment> cowTreatment = cow.getTreatments();
                for (Treatment treatment : cowTreatment) {
                    String treatType = String.valueOf(treatment.getClass());

                    if (treatType.equals("class medicalPackage.HealthTreatment")) {
                        HealthTreatment healthTreatment = (HealthTreatment) treatment;
                        System.out.println(healthTreatment.toString());
                       /* System.out.println("Date of Treatment:" + treatment.getDateOfTreatment());
                        System.out.println("Emergency:" + ((HealthTreatment) treatment).isEmergency());
                        ArrayList<Medication> cowMedication = cow.getMedications();
                        for (Medication medication : cowMedication) {
                            System.out.println("Details: " + medication.getDetails());
                            System.out.println("Duration: " + medication.getDuration());
                            System.out.println("Start Date: " + medication.getStartDate());
                            System.out.println("Dosage: " + medication.getDosage());
                            System.out.println("Notes: " + medication.getNotes());*/
                    }
                     else {
                        CleaningTreatment cleaningTreatment = (CleaningTreatment) treatment;
                        System.out.println(cleaningTreatment.toString());
                        /*System.out.println("Date of Treatment:" + treatment.getDateOfTreatment());
                        System.out.println("Materials used:" + ((CleaningTreatment) treatment).getMaterialsused());
                        FarmWorker farmWorker = cleaningTreatment.getCgivenby();
                        System.out.println("Given by:" + farmWorker.getEmpID());*/
                    }
                    System.out.println("\n");
                }
            }
        }
    }
    public static void getCowTreatment ( int tagNo, Date dateOfTreatment) {
        ArrayList<Cow> cows = CowArrayList();

        for (Cow cow : cows) {
            if (cow.getTagNo() == tagNo) {
                ArrayList<Treatment> cowTreatment = cow.getTreatments();
                for (Treatment treatment : cowTreatment) {
                    String treatType = String.valueOf(treatment.getClass());
                    HealthTreatment healthTreatment = (HealthTreatment) treatment;
                    if (healthTreatment.getDateOfTreatment().equals((dateOfTreatment))) {
                        if (treatType.equals("class medicalPackage.HealthTreatment")) {
                            System.out.println(healthTreatment.toString());
                            /*System.out.println("Date of Treatment:" + treatment.getDateOfTreatment());
                            System.out.println("Emergency:" + ((HealthTreatment) treatment).isEmergency());
                            ArrayList<Medication> cowMedication = cow.getMedications();
                            for (Medication medication : cowMedication) {
                                System.out.println("Details: " + medication.getDetails());
                                System.out.println("Duration: " + medication.getDuration());
                                System.out.println("Start Date: " + medication.getStartDate());
                                System.out.println("Dosage: " + medication.getDosage());
                                System.out.println("Notes: " + medication.getNotes());*/
                            }
                        }
                    else {
                        CleaningTreatment cleaningTreatment = (CleaningTreatment) treatment;
                        System.out.println(cleaningTreatment.toString());
                        /*System.out.println("Date of Treatment:" + treatment.getDateOfTreatment());
                        System.out.println("Materials used:" + ((CleaningTreatment) treatment).getMaterialsused());
                        FarmWorker farmWorker = cleaningTreatment.getCgivenby();
                        System.out.println("Given by:" + farmWorker.getEmpID());*/
                    }
                    System.out.println("\n");
                }
            }
        }
    }


    public static ArrayList<Cow> listCow () {
        ArrayList<Cow> cows = CowArrayList();

        for(Cow cow: cows){
            System.out.println(cow.toString());
        }
        return cows;
    }

    public static ArrayList<Veterinary> listVet () {
        ArrayList<Veterinary> vets = VetArrayList();

        for(Veterinary vet: vets){
            System.out.println(vet.toString());
        }
        return vets;
    }


    static void feedingAnimal (int tagNo){
        ArrayList<Animal> animals = AnimalArrayList();
            for (Animal animal1 : animals) {
            String animalType = String.valueOf(animal1.getClass());
            if (animalType.equals("class animalsPackage.Cow")) {
                Cow cow = (Cow) animal1;
                if (cow.getTagNo() == tagNo) {
                    cow.feeding();
                }
            }
            else if (animalType.equals("class animalsPackage.Sheep")) {
                Sheep sheep = (Sheep) animal1;
                if (sheep.getTagNo() == tagNo) {
                    sheep.feeding();
                }
              }
            }
    }

    static double getEmpSalary(int empId) {
        ArrayList<Employee> employees= EmployeeArrayList();
        for(Employee employee1: employees){
            System.out.println("Salary:" + employee1.getSalary());
        }
        /* if (!isUniqueEmployee(empId)) {
            for (Employee employee1 : employees) {
                String empType = String.valueOf(employee1.getClass());
                if(empType.equals("class peoplePackage.Veterinary")) {
                    Veterinary vet1 = (Veterinary) employee1;
                    if (vet1.getEmpID() == empId) {
                        System.out.println("Vet salary is:" + vet1.getSalary());
                    }
                }
                else if(empType.equals("class peoplePackage.FarmWorker")) {
                    FarmWorker farmWorker1 = (FarmWorker) employee1;
                    if (farmWorker1.getEmpID() == empId) {
                        System.out.println("Farmworker salary is:" + farmWorker1.getSalary());
                    }
                }
            }
        }
        else {
            System.out.println("Employee with empId is not found!");
        }*/
        return 0;
    }
    static void addMilkingMeasurement(int tagNo, double amount){
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Cow> cows = new ArrayList<>();
        ArrayList<Sheep> sheeps = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        Map<LocalDate,Double> milking =new HashMap<LocalDate,Double>();
        LocalDate currentDate = LocalDate.now();
        milking.put(currentDate, amount);

        for(Cow cow : cows) {
            for (Sheep sheep : sheeps) {
                if (cow.getTagNo()== tagNo){
                    cow.setTagNo(tagNo);
                    cow.getMilking().put(currentDate, amount);
                    animals.add(cow);
                }
                else if(sheep.getTagNo()== tagNo){
                    sheep.setTagNo(tagNo);
                    sheep.getMilking().put(currentDate, amount);
                    animals.add(sheep);
                }
                else{
                    System.out.print("Animal does not exist with this tagNo!");
                }
            }
        }
    }

    static void exit () {
        System.out.println("GoodBye!!");
    }

    public static ArrayList<Sheep>  SheepArrayList(){
        ArrayList<Sheep> sheeps = new ArrayList<>();
        try {
            File sheepFile = new File("Sheep.txt");
            FileInputStream fileIn = new FileInputStream(sheepFile);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            int fileIsEmpty = fileIn.read();

            if (fileIsEmpty != -1) {
                sheeps = (ArrayList<Sheep>) objectIn.readObject();
                objectIn.close();
                fileIn.close();
            }

        /*//THIS WHILE BLOCK CREATES AN ARRAYLIST AND FILLS IT BY READING "SHEEP.SER" FILE
        while (true){
            if(cowFile.length()==0) break;
            Sheep sheep = SheepReadObjectFromFile("Sheep.txt");
            if (sheep != null) sheeps.add(sheep);
        }

        while (checker) {
            try (ObjectInputStream input = new ObjectInputStream(objectIn)) {
                 Sheep sheep = (Sheep) input.readObject();
                if (sheep != null) {
                    sheeps.add(sheep);
                } else {
                    checker = false;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            }*/
            return sheeps;
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            return sheeps;
        }
    }
    public static ArrayList<Cow> CowArrayList(){
        ArrayList<Cow> cows = new ArrayList<>();
        try {
            File cowFile = new File("Cow.txt");
            FileInputStream fileIn = new FileInputStream(cowFile);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            int fileIsEmpty = fileIn.read();

            if (fileIsEmpty != -1) {
                cows = (ArrayList<Cow>) objectIn.readObject();
                objectIn.close();
                fileIn.close();
            }

        /*//THIS WHILE BLOCK CREATES AN ARRAYLIST AND FILLS IT BY READING "COW.SER" FILE
        while (true){
            if(cowFile.length()==0) break;
            Cow cow = CowReadObjectFromFile("Cow.txt");
            if (cow != null) cows.add(cow);
        }

        while (checker) {
            try (ObjectInputStream input = new ObjectInputStream(objectIn)) {
                 Cow cow = (Cow) input.readObject();
                if (cow != null) {
                    cows.add(cow);
                } else {
                    checker = false;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            }*/
            return cows;
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            return cows;
        }
    }

    public static  ArrayList<FarmWorker>  FarmWorkerArraylist(){
        ArrayList<FarmWorker> farmWorkers = new ArrayList<>();
        try {
            File farmWorkerFile = new File("FarmWorker.txt");
            FileInputStream fileIn = new FileInputStream(farmWorkerFile);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            int fileIsEmpty = fileIn.read();

            if (fileIsEmpty != -1) {
                farmWorkers = (ArrayList<FarmWorker>) objectIn.readObject();
                objectIn.close();
                fileIn.close();
            }

        /*//THIS WHILE BLOCK CREATES AN ARRAYLIST AND FILLS IT BY READING "COW.SER" FILE
        while (true){
            if(farmWorkerFile.length()==0) break;
            FarmWorker farmWorker = CowReadObjectFromFile("FarmWorker.txt");
            if (farmWorker != null) farmWorkers.add(farmWorker);
        }

        while (checker) {
            try (ObjectInputStream input = new ObjectInputStream(objectIn)) {
                 FarmWorker farmWorker = (FarmWorker) input.readObject();
                if (farmWorker != null) {
                    farmWorkers.add(farmWorker);
                } else {
                    checker = false;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            }*/
            return farmWorkers;
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            return farmWorkers;
        }
    }

    public static  ArrayList<Veterinary> VetArrayList(){
        ArrayList<Veterinary> vets = new ArrayList<>();
        try {
            File vetFile = new File("Veterinary.txt");
            FileInputStream fileIn = new FileInputStream(vetFile);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            int fileIsEmpty = fileIn.read();

            if (fileIsEmpty != -1) {
                vets = (ArrayList<Veterinary>) objectIn.readObject();
                objectIn.close();
                fileIn.close();
            }

        /*//THIS WHILE BLOCK CREATES AN ARRAYLIST AND FILLS IT BY READING "COW.SER" FILE
        while (true){
            if(vetFile.length()==0) break;
            Veterinary vet = CowReadObjectFromFile("Veterinary.txt");
            if (vet != null) vets.add(vet);
        }

        while (checker) {
            try (ObjectInputStream input = new ObjectInputStream(objectIn)) {
                 Veterinary vet = (Veterinary) input.readObject();
                if (vet != null) {
                    vets.add(vet);
                } else {
                    checker = false;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            }*/
            return vets;
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            return vets;
        }
    }

    //THIS METHOD FIRST DELETES EVERYTHING IN THE VETERINARY FILE, THEN UPLOAD THE NEW VERSION
    public static void  UpdateVetFile(ArrayList<Veterinary> vets){
        try {
            new FileWriter("Veterinary.txt", false).close();
            for(Veterinary veterinary: vets){
                VeterinaryWriteObjectToFile("Veterinary.txt", veterinary);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //THIS METHOD FIRST DELETES EVERYTHING IN THE FARMWORKER FILE, THEN UPLOAD THE NEW VERSION
    public static void  UpdateFarmWorkerFile(ArrayList<FarmWorker> farmWorkers){
        try {
            new FileWriter("FarmWorker.txt", false).close();
            for(FarmWorker farmWorker: farmWorkers){
                FarmWorkerWriteObjectToFile("FarmWorker.txt", farmWorker);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //THIS METHOD FIRST DELETES EVERYTHING IN THE COW FILE, THEN UPLOAD THE NEW VERSION
    public static void UpdateCowFile(ArrayList<Cow> cows){
        try {
            new FileWriter("Cow.txt", false).close();
            for(Cow cow: cows){
                CowWriteObjectToFile("Cow.txt", cow);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void VeterinaryWriteObjectToFile(String fileName,Veterinary veterinary) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            ArrayList<Veterinary> vets = VetArrayList();
            vets.add(veterinary);
            objectOut.writeObject(vets);
            objectOut.flush();
            objectOut.close();
            fileOut.close();
            //System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void  FarmWorkerWriteObjectToFile(String fileName,FarmWorker farmWorker) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            ArrayList<FarmWorker> farmWorkers =FarmWorkerArraylist();
            farmWorkers.add(farmWorker);
            objectOut.writeObject(farmWorkers);
            objectOut.flush();
            objectOut.close();
            fileOut.close();
            //System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void  SheepWriteObjectToFile(String fileName,Sheep sheep) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            ArrayList<Sheep> sheeps = SheepArrayList();
            sheeps.add(sheep);
            objectOut.writeObject(sheeps);
            objectOut.flush();
            objectOut.close();
            fileOut.close();
            //System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void  CowWriteObjectToFile(String fileName,Cow cow) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            ArrayList<Cow> cows = CowArrayList();
            cows.add(cow);
            objectOut.writeObject(cows);
            objectOut.flush();
            objectOut.close();
            fileOut.close();
            //System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //THIS METHOD READS THE ANIMAL FILE AND RETURN IT AS AN ARRAYLIST
    public static ArrayList<Animal> AnimalArrayList(){
        ArrayList<Animal> animals = new ArrayList<>();
        try {
            File staffFile = new File("Animal.txt");
            FileInputStream fileIn = new FileInputStream(staffFile);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            int fileIsEmpty = fileIn.read();
            if (fileIsEmpty != -1) {
               animals = (ArrayList<Animal>) objectIn.readObject();
                //if(animal != null) animals.add(animal);animals.add(animal);
                objectIn.close();
                fileIn.close();
            }

            /*
             * @param checker IS CHECKING WHETHER ALL OBJECTS ARE COPIED IN THE ARRAYLIST OR NOT

            boolean checker = true;

            while (checker){
                if(animalFile.length() == 0) checker = false;
                Animal animal = (Animal) objectIn.readObject();
                if(animal != null) animals.add(animal);animals.add(animal);
                if(animal == null) break;
            }

            while (checker) {
                try (ObjectInputStream input = new ObjectInputStream(objectIn)) {
                    Animal animal = (Animal) input.readObject();
                    if (animal != null) {
                        animals.add(animal);
                    } else {
                        checker = false;
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }*/
            return animals;
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            return animals;
        }
    }

    //THIS METHOD READS THE EMPLOYEE FILE AND RETURN IT AS AN ARRAYLIST
    public static ArrayList<Employee> EmployeeArrayList(){
        ArrayList<Employee>employees = new ArrayList<>();
        try {
            File employeeFile = new File("Employee.txt");
            FileInputStream fileIn = new FileInputStream(employeeFile);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            int fileIsEmpty = fileIn.read();
            if (fileIsEmpty != -1) {
                employees = (ArrayList<Employee>) objectIn.readObject();
                //if(employee != null) employees.add(employee);employees.add(employee);
                objectIn.close();
                fileIn.close();
            }

            /*
             * @param checker IS CHECKING WHETHER ALL OBJECTS ARE COPIED IN THE ARRAYLIST OR NOT

            boolean checker = true;

            while (checker){
                if(employeeFile.length() == 0) checker = false;
                Employee employee = (Employee) objectIn.readObject();
                if(employee != null) employees.add(employee);employees.add(employee);
                if(employee == null) break;
            }

            while (checker) {
                try (ObjectInputStream input = new ObjectInputStream(objectIn)) {
                    Employee employee = (Employee) input.readObject();
                    if (employee != null) {
                        employees.add(employee);
                    } else {
                        checker = false;
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }*/
            return employees;
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            return employees;
        }
    }
}
