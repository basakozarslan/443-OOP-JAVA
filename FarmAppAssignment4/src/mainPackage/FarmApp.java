package mainPackage;

import animalsPackage.Animal;
import animalsPackage.Cow;
import animalsPackage.Sheep;
import medicalPackage.CleaningTreatment;
import medicalPackage.HealthTreatment;
import medicalPackage.Treatment;
import peoplePackage.Employee;
import peoplePackage.FarmWorker;
import peoplePackage.Veterinary;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.io.*;
import java.util.*;

public class FarmApp {

    public static void main(String[] args) {}


    public static void addCow (char gender, String dob, String purchased, String milking,double weight) {

        try {
            Date dateOfBirth = Date.valueOf(dob);
            Boolean bol = Boolean.valueOf(purchased);
            ArrayList<Animal> animal = AnimalArrayList();
            int tagNO = IDgenerator(animal);

            Connection connection = null;
            DBHelper dbHelper = new DBHelper();
            PreparedStatement preparedStatement1 = null;
            PreparedStatement preparedStatement2 = null;

            try {
                connection = dbHelper.getConnection();

                String sql1 = "insert into trial.animal (tagNO,gender,dateOfBirth,bol,milking) values (?,?,?,?,?)";
                preparedStatement1 = connection.prepareStatement(sql1);
                preparedStatement1.setInt(1, tagNO);
                preparedStatement1.setString(2, String.valueOf(gender));
                preparedStatement1.setDate(3,  dateOfBirth);
                preparedStatement1.setBoolean(4, bol);
                preparedStatement1.setString(5, milking);
                int result1 = preparedStatement1.executeUpdate();

                String sql2 = "insert into trial.cow () values (?,?)";
                preparedStatement2 = connection.prepareStatement(sql2);
                preparedStatement2.setInt(1, tagNO);
                preparedStatement2.setDouble(2, weight);
                int result2 = preparedStatement2.executeUpdate();

            } catch (InstantiationException e) {
                dbHelper.showErrorMessage(e);
            } catch (SQLException throwables) {
                dbHelper.showErrorMessage(throwables);
            } catch (IllegalAccessException e) {
                dbHelper.showErrorMessage(e);
            } catch (ClassNotFoundException e) {
                dbHelper.showErrorMessage(e);
            } finally {
                try {
                    preparedStatement1.close();
                    preparedStatement2.close();
                    connection.close();
                } catch (SQLException throwables) {
                    dbHelper.showErrorMessage(throwables);
                }
            }
        }catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }
    }

    public static void addSheep (char gender, String dob, String purchased, String milking) {
        try {
            Date dateOfBirth = Date.valueOf(dob);
            Boolean bol = Boolean.valueOf(purchased);
            ArrayList<Animal> animal = AnimalArrayList();
            int tagNO = IDgenerator(animal);

            Connection connection = null;
            DBHelper dbHelper = new DBHelper();
            PreparedStatement preparedStatement1 = null;
            PreparedStatement preparedStatement2 = null;

            try {
                connection = dbHelper.getConnection();

                String sql1 = "insert into trial.animal (tagNO,gender,dateOfBirth,bol,milking) values (?,?,?,?,?)";
                preparedStatement1 = connection.prepareStatement(sql1);
                preparedStatement1.setInt(1, tagNO);
                preparedStatement1.setString(2, String.valueOf(gender));
                preparedStatement1.setDate(3,  dateOfBirth);
                preparedStatement1.setBoolean(4, bol);
                preparedStatement1.setString(5, milking);
                int result1 = preparedStatement1.executeUpdate();

                String sql2 = "insert into trial.sheep () values (?)";
                preparedStatement2 = connection.prepareStatement(sql2);
                preparedStatement2.setInt(1, tagNO);
                int result2 = preparedStatement2.executeUpdate();

            } catch (InstantiationException e) {
                dbHelper.showErrorMessage(e);
            } catch (SQLException throwables) {
                dbHelper.showErrorMessage(throwables);
            } catch (IllegalAccessException e) {
                dbHelper.showErrorMessage(e);
            } catch (ClassNotFoundException e) {
                dbHelper.showErrorMessage(e);
            } finally {
                try {
                    preparedStatement1.close();
                    preparedStatement2.close();
                    connection.close();
                } catch (SQLException throwables) {
                    dbHelper.showErrorMessage(throwables);
                }
            }
        }catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }

    }

    public static void deleteCow ( int tagNo){
        String cowID = String.valueOf(tagNo);
        try {
            Connection connection = null;
            DBHelper dbHelper = new DBHelper();
            PreparedStatement statement2 = null;

            try{
                connection = dbHelper.getConnection();
                String sql2 = "delete from trial.animal where ID="+cowID+";";
                statement2 = connection.prepareStatement(sql2);
                statement2.execute();


            } catch (InstantiationException e) {
                dbHelper.showErrorMessage(e);
            } catch (SQLException throwables) {
                dbHelper.showErrorMessage(throwables);
            } catch (IllegalAccessException e) {
                dbHelper.showErrorMessage(e);
            } catch (ClassNotFoundException e) {
                dbHelper.showErrorMessage(e);
            }finally {
                try {
                    statement2.close();
                    connection.close();
                } catch (SQLException throwables) {
                    dbHelper.showErrorMessage(throwables);
                }
            }
        }catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }
    }
    public static void deleteSheep ( int tagNo){
        String sheepID = String.valueOf(tagNo);
        try {
            Connection connection = null;
            DBHelper dbHelper = new DBHelper();
            PreparedStatement statement2 = null;

            try{
                connection = dbHelper.getConnection();
                String sql2 = "delete from trial.animal where ID="+sheepID+";";
                statement2 = connection.prepareStatement(sql2);
                statement2.execute();


            } catch (InstantiationException e) {
                dbHelper.showErrorMessage(e);
            } catch (SQLException throwables) {
                dbHelper.showErrorMessage(throwables);
            } catch (IllegalAccessException e) {
                dbHelper.showErrorMessage(e);
            } catch (ClassNotFoundException e) {
                dbHelper.showErrorMessage(e);
            }finally {
                try {
                    statement2.close();
                    connection.close();
                } catch (SQLException throwables) {
                    dbHelper.showErrorMessage(throwables);
                }
            }
        }catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }
    }

    public static ArrayList<Cow> getCowDetails ( int tagNo) {
        ArrayList<Cow> returnCows = new ArrayList<Cow>();
        try {
            ArrayList<Cow> cows = CowArrayList();

            for (Cow cow: cows) {
                if (cow.getTagNo()==tagNo) {
                    returnCows.add(cow);
                    break;
                }
            }
        } catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }
        return returnCows;
    }

    public static ArrayList<Sheep> getSheepDetails ( int tagNo) {
        ArrayList<Sheep> returnSheeps = new ArrayList<Sheep>();
        try {
            ArrayList<Sheep> sheeps = SheepArrayList();

            for (Sheep sheep: sheeps) {
                if (sheep.getTagNo()==tagNo) {
                    returnSheeps .add(sheep);
                    break;
                }
            }
        } catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }
        return returnSheeps ;
    }


    public static void addVet (char gender, String BScDegree, String expertiseLevel, String dog,String dob){

        try{
            Date dateOfBirth = Date.valueOf(dob);
            Date dateOfGrad = Date.valueOf(dog);

            ArrayList<Employee> employee = EmployeeArrayList();
            int empID = IDgenerator(employee);

            Connection connection = null;
            DBHelper dbHelper = new DBHelper();
            PreparedStatement preparedStatement1 = null;
            PreparedStatement preparedStatement2 = null;

            try{
                connection = dbHelper.getConnection();

                String sql1 = "insert into trial.employee (empID,gender,dateOfBirth) values (?,?,?)";
                preparedStatement1 = connection.prepareStatement(sql1);
                preparedStatement1.setInt(1,empID);
                preparedStatement1.setString(2, String.valueOf(gender));
                preparedStatement1.setDate(3,dateOfBirth);
                int result1 = preparedStatement1.executeUpdate();

                String sql2 = "insert into trial.veterinary (customerID,registrationDate,creditCardNumber,lastUsageDate,securityCode) values (?,?,?,?,?)";
                preparedStatement2 = connection.prepareStatement(sql2);
                preparedStatement2.setInt(1,empID);
                preparedStatement2.setBoolean(2, Boolean.parseBoolean(BScDegree));
                preparedStatement2.setDate(3,dateOfGrad);
                preparedStatement2.setInt(4, Integer.parseInt(expertiseLevel));
                int result2 = preparedStatement2.executeUpdate();
            } catch (InstantiationException e) {
                dbHelper.showErrorMessage(e);
            } catch (SQLException throwables) {
                dbHelper.showErrorMessage(throwables);
            } catch (IllegalAccessException e) {
                dbHelper.showErrorMessage(e);
            } catch (ClassNotFoundException e) {
                dbHelper.showErrorMessage(e);
            }finally {
                try {
                    preparedStatement1.close();
                    preparedStatement2.close();
                    connection.close();
                } catch (SQLException throwables) {
                    dbHelper.showErrorMessage(throwables);
                }
            }
        }catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }
    }

    public static void deleteVet ( int empID){
        String vetID = String.valueOf(empID);
        try {
            Connection connection = null;
            DBHelper dbHelper = new DBHelper();
            PreparedStatement statement2 = null;

            try{
                connection = dbHelper.getConnection();
                String sql2 = "delete from trial.employee where ID="+vetID+";";
                statement2 = connection.prepareStatement(sql2);
                statement2.execute();


            } catch (InstantiationException e) {
                dbHelper.showErrorMessage(e);
            } catch (SQLException throwables) {
                dbHelper.showErrorMessage(throwables);
            } catch (IllegalAccessException e) {
                dbHelper.showErrorMessage(e);
            } catch (ClassNotFoundException e) {
                dbHelper.showErrorMessage(e);
            }finally {
                try {
                    statement2.close();
                    connection.close();
                } catch (SQLException throwables) {
                    dbHelper.showErrorMessage(throwables);
                }
            }
        }catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }
    }

        public static ArrayList<Veterinary> getVetDetails ( int empID) {
            ArrayList<Veterinary> returnVets = new ArrayList<Veterinary>();
            try {
                ArrayList<Veterinary> vets = VetArrayList();

                for (Veterinary vet : vets) {
                    if (vet.getEmpID()==empID) {
                        returnVets .add(vet);
                        break;
                    }
                }
            } catch (NullPointerException e){
                System.out.println("NULL POINTER EXCEPTION!");
            }
            return returnVets ;
        }

        public static void addHealthTreatment(LocalDate dateOfTreatment, boolean emergency)
        {

            try{
                ArrayList<Treatment> treatments = TreatmentArrayList();
                int treatmentID = IDgenerator(treatments);
                Date treatDate = Date.valueOf(dateOfTreatment);
                ArrayList<Veterinary> vets = VetArrayList();
                int hgivenbyID= 0;
                for (Veterinary veterinary: vets) {
                    if (veterinary.getEmpID()==(hgivenbyID)) {
                        hgivenbyID = veterinary.getEmpID();
                        break;
                    }
                }

                Connection connection = null;
                DBHelper dbHelper = new DBHelper();
                PreparedStatement preparedStatement1 = null;
                PreparedStatement preparedStatement2 = null;

                try{
                    connection = dbHelper.getConnection();

                    String sql1 = "insert into trial.treatment (treatDate,treatmentID) values (?,?)";
                    preparedStatement1 = connection.prepareStatement(sql1);
                    preparedStatement1.setInt(1,treatmentID);
                    preparedStatement1.setDate(2, treatDate);
                    int result3 = preparedStatement1.executeUpdate();

                    String sql2 = "insert into trial.healthtreatment (emergency,hgivenbyID) values (?,?)";
                    preparedStatement2 = connection.prepareStatement(sql2);
                    preparedStatement2.setString(1, String.valueOf(emergency));
                    preparedStatement2.setInt(2,hgivenbyID);
                    int result2 = preparedStatement2.executeUpdate();
                }catch (InstantiationException e) {
                    dbHelper.showErrorMessage(e);
                } catch (SQLException throwables) {
                    dbHelper.showErrorMessage(throwables);
                } catch (IllegalAccessException e) {
                    dbHelper.showErrorMessage(e);
                } catch (ClassNotFoundException e) {
                    dbHelper.showErrorMessage(e);
                }finally {
                    try {
                        preparedStatement1.close();
                        preparedStatement2.close();
                        connection.close();
                    } catch (SQLException throwables) {
                        dbHelper.showErrorMessage(throwables);
                    }
                }
            } catch (NullPointerException e){
                System.out.println("NULL POINTER EXCEPTION!");
            }
        }


    public static void addCleaningTreatment(LocalDate dateOfTreatment, String materialsUsed) {
        try{
            ArrayList<Treatment> treatments = TreatmentArrayList();
            int treatmentID = IDgenerator(treatments);
            Date treatDate = Date.valueOf(dateOfTreatment);
            ArrayList<FarmWorker>farmWorkers = FarmWorkerArraylist();
            int cgivenbyID= 0;
            for (FarmWorker farmWorker: farmWorkers) {
                if (farmWorker.getEmpID()==(cgivenbyID)) {
                    cgivenbyID = farmWorker.getEmpID();
                    break;
                }
            }

            Connection connection = null;
            DBHelper dbHelper = new DBHelper();
            PreparedStatement preparedStatement1 = null;
            PreparedStatement preparedStatement2 = null;

            try{
                connection = dbHelper.getConnection();

                String sql1 = "insert into trial.treatment (treatDate,treatmentID) values (?,?)";
                preparedStatement1 = connection.prepareStatement(sql1);
                preparedStatement1.setInt(1,treatmentID);
                preparedStatement1.setDate(2, treatDate);
                int result3 = preparedStatement1.executeUpdate();

                String sql2 = "insert into trial.cleaningtreatment (materialsUsed,hgivenbyID) values (?,?)";
                preparedStatement2 = connection.prepareStatement(sql2);
                preparedStatement2.setString(1, String.valueOf(materialsUsed));
                preparedStatement2.setInt(2,cgivenbyID);
                int result2 = preparedStatement2.executeUpdate();
            }catch (InstantiationException e) {
                dbHelper.showErrorMessage(e);
            } catch (SQLException throwables) {
                dbHelper.showErrorMessage(throwables);
            } catch (IllegalAccessException e) {
                dbHelper.showErrorMessage(e);
            } catch (ClassNotFoundException e) {
                dbHelper.showErrorMessage(e);
            }finally {
                try {
                    preparedStatement1.close();
                    preparedStatement2.close();
                    connection.close();
                } catch (SQLException throwables) {
                    dbHelper.showErrorMessage(throwables);
                }
            }
        } catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }
    }

    public static ArrayList<Treatment> getCowTreatment (int tagNo) {
        ArrayList<Treatment> cowTreatment = TreatmentArrayList();
        ArrayList<Treatment> returnTreatments = new ArrayList<Treatment>();

        try {
            if (!cowTreatment.isEmpty()) {
                for (Treatment treatment : cowTreatment) {
                    if(treatment.getAnimalID() == tagNo) returnTreatments.add(treatment );
                }
            }
        } catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }
        return returnTreatments;
    }

    public static ArrayList<Treatment> getCowTreatment (int tagNo, Date dateOfTreatment) {
        ArrayList<Treatment> cowTreatment = TreatmentArrayList();
        ArrayList<Treatment> returnTreatments = new ArrayList<Treatment>();

        try {
            if (!cowTreatment.isEmpty()) {
                for (Treatment treatment : cowTreatment) {
                    if(treatment.getAnimalID() == tagNo && treatment.getDateOfTreatment().equals(dateOfTreatment)) returnTreatments.add(treatment );
                }
            }
        } catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }
        return returnTreatments;
    }


    public static ArrayList<Cow> listCow (int tagNo) {
        ArrayList<Cow> returnCow = new ArrayList<Cow>();
        try {
            ArrayList<Cow> cows = CowArrayList();
            for(Cow cow: cows){
                if(cow.getTagNo() == tagNo){
                    returnCow.add(cow);
                    break;
                }
            }
        }
        catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }
        return returnCow;
    }

    public static ArrayList<Veterinary> listVet (int empID) {
        ArrayList<Veterinary> returnVeterinary = new ArrayList<Veterinary>();
        try {
            ArrayList<Veterinary> veterinarys = VetArrayList();
            for(Veterinary veterinary: veterinarys){
                if(veterinary.getEmpID() == empID){
                    returnVeterinary.add(veterinary);
                    break;
                }
            }
        }
        catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }
        return returnVeterinary;
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

    public static ArrayList<Sheep>  SheepArrayList(){
        ArrayList<Sheep> sheeps = new ArrayList<Sheep>();
        try {
            Connection connection = null;
            DBHelper dbHelper = new DBHelper();
            Statement statement = null;
            ResultSet resultSet;

            try{
                connection = dbHelper.getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT trial.sheep.tagNo,gender, dateOfBirth,purchased\n"
                        + "FROM trial.sheep\n"
                        + "INNER JOIN trial.animal \n"
                        + "    ON trial.animal.ID = trial.sheep.sheeptagNo");

                while(resultSet.next()){
                    sheeps.add(new Sheep(resultSet.getInt("sheep tag no"),
                            resultSet.getString("gender"),
                            resultSet.getDate("dateOfBirth"),
                            resultSet.getBoolean("purchased")));
                }
            }catch(SQLException e){
                dbHelper.showErrorMessage(e);
            } catch (ClassNotFoundException ex) {
                dbHelper.showErrorMessage(ex);
            } catch (InstantiationException ex) {
                dbHelper.showErrorMessage(ex);
            } catch (IllegalAccessException ex) {
                dbHelper.showErrorMessage(ex);
            }finally{
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    dbHelper.showErrorMessage(ex);
                }
            }
        } catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }
        return sheeps;
    }
    public static ArrayList<Cow> CowArrayList(){
        ArrayList<Cow> cows = new ArrayList<Cow>();
        try {
            Connection connection = null;
            DBHelper dbHelper = new DBHelper();
            Statement statement = null;
            ResultSet resultSet;

            try{
                connection = dbHelper.getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT trial.cow.tagNo,gender, dateOfBirth,purchased,weight\n"
                        + "FROM trial.cow\n"
                        + "INNER JOIN trial.animal \n"
                        + "    ON trial.animal.ID = trial.cow.cowtagNo");

                while(resultSet.next()){
                    cows.add(new Cow(resultSet.getInt("cow tag no"),
                            resultSet.getString("gender"),
                            resultSet.getDate("dateOfBirth"),
                            resultSet.getBoolean("purchased"),
                            resultSet.getDouble("Weight")));
                }
            }catch(SQLException e){
                dbHelper.showErrorMessage(e);
            } catch (ClassNotFoundException ex) {
                dbHelper.showErrorMessage(ex);
            } catch (InstantiationException ex) {
                dbHelper.showErrorMessage(ex);
            } catch (IllegalAccessException ex) {
                dbHelper.showErrorMessage(ex);
            }finally{
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    dbHelper.showErrorMessage(ex);
                }
            }
        } catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }
        return cows;
    }

    public static  ArrayList<FarmWorker>  FarmWorkerArraylist(){
        ArrayList<FarmWorker> farmWorkers = new ArrayList<FarmWorker>();
        try {
            Connection connection = null;
            DBHelper dbHelper = new DBHelper();
            Statement statement = null;
            ResultSet resultSet;

            try{
                connection = dbHelper.getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT trial.farmWorker.empID,gender, dateOfBirth,previousName,workExperience\n"
                        + "FROM trial.farmWorker\n"
                        + "INNER JOIN trial.employee \n"
                        + "    ON trial.employee.ID = trial.farmWorker.farmWorkerempID");

                while(resultSet.next()){
                    farmWorkers.add(new FarmWorker(resultSet.getInt("farmWorker emp ID"),
                            resultSet.getString("gender"),
                            resultSet.getDate("dateOfBirth").toLocalDate(),
                            resultSet.getString("previousName"),
                            resultSet.getInt("workExperience")));
                }
            }catch(SQLException e){
                dbHelper.showErrorMessage(e);
            } catch (ClassNotFoundException ex) {
                dbHelper.showErrorMessage(ex);
            } catch (InstantiationException ex) {
                dbHelper.showErrorMessage(ex);
            } catch (IllegalAccessException ex) {
                dbHelper.showErrorMessage(ex);
            }finally{
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    dbHelper.showErrorMessage(ex);
                }
            }
        } catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }
        return farmWorkers;
    }

    public static  ArrayList<Veterinary> VetArrayList(){
        ArrayList<Veterinary> vets = new ArrayList<Veterinary>();
        try {
            Connection connection = null;
            DBHelper dbHelper = new DBHelper();
            Statement statement = null;
            ResultSet resultSet;

            try{
                connection = dbHelper.getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT trial.veterinary.empID,gender, dateOfBirth,bscDegree,dateOfGrad, expertLevel\n"
                        + "FROM trial.veterinary\n"
                        + "INNER JOIN trial.employee \n"
                        + "    ON trial.employee.ID = trial.veterinary.veterinaryempID");

                while(resultSet.next()){
                    vets.add(new Veterinary(resultSet.getInt("veterinary emp ID"),
                            resultSet.getString("gender"),
                            resultSet.getDate("dateOfBirth").toLocalDate(),
                            resultSet.getBoolean("bsc degree"),
                            resultSet.getDate("dateOfGrad").toLocalDate(),
                            resultSet.getInt("expertiseLevel")));
                }
            }catch(SQLException e){
                dbHelper.showErrorMessage(e);
            } catch (ClassNotFoundException ex) {
                dbHelper.showErrorMessage(ex);
            } catch (InstantiationException ex) {
                dbHelper.showErrorMessage(ex);
            } catch (IllegalAccessException ex) {
                dbHelper.showErrorMessage(ex);
            }finally{
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    dbHelper.showErrorMessage(ex);
                }
            }
        } catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }
        return vets;
    }

    public static ArrayList<Animal> AnimalArrayList(){
        ArrayList<Animal> animal = new ArrayList<Animal>();
        try {
            Connection connection = null;
            DBHelper dbHelper = new DBHelper();
            Statement statement = null;
            ResultSet resultSet;

            try{
                connection = dbHelper.getConnection();
                statement = connection.createStatement();

                resultSet = statement.executeQuery("SELECT cowtagNo from trial.cow");
                while(resultSet.next()){
                    animal.add(new Cow(resultSet.getInt("cowtagNo")));
                }

                resultSet = statement.executeQuery("SELECT sheeptagNo from trial.sheep");
                while(resultSet.next()){
                    animal.add(new Sheep(resultSet.getInt("sheeptagNo")));
                }

            }catch(SQLException e){
                dbHelper.showErrorMessage(e);
            } catch (ClassNotFoundException ex) {
                dbHelper.showErrorMessage(ex);
            } catch (InstantiationException ex) {
                dbHelper.showErrorMessage(ex);
            } catch (IllegalAccessException ex) {
                dbHelper.showErrorMessage(ex);
            }finally{
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    dbHelper.showErrorMessage(ex);
                }
            }
        } catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }
        return animal;
    }

    //THIS METHOD READS THE EMPLOYEE FILE AND RETURN IT AS AN ARRAYLIST
    public static ArrayList<Employee> EmployeeArrayList(){
        ArrayList<Employee> employee = new ArrayList<Employee>();
        try {
            Connection connection = null;
            DBHelper dbHelper = new DBHelper();
            Statement statement = null;
            ResultSet resultSet;

            try{
                connection = dbHelper.getConnection();
                statement = connection.createStatement();

                resultSet = statement.executeQuery("SELECT vetEmpID from trial.veterinary");
                while(resultSet.next()){
                    employee.add(new Veterinary(resultSet.getInt("vetEmpID")));
                }

                resultSet = statement.executeQuery("SELECT farmworkerEmpID from trial.farmWorker");
                while(resultSet.next()){
                    employee.add(new FarmWorker(resultSet.getInt("farmWorkerEmpID")));
                }

            }catch(SQLException e){
                dbHelper.showErrorMessage(e);
            } catch (ClassNotFoundException ex) {
                dbHelper.showErrorMessage(ex);
            } catch (InstantiationException ex) {
                dbHelper.showErrorMessage(ex);
            } catch (IllegalAccessException ex) {
                dbHelper.showErrorMessage(ex);
            }finally{
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    dbHelper.showErrorMessage(ex);
                }
            }
        } catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }
        return employee;
    }


    public static ArrayList<Treatment> TreatmentArrayList(){
        ArrayList<Treatment> treatments = new ArrayList<Treatment>();
        try {
            Connection connection = null;
            DBHelper dbHelper = new DBHelper();
            Statement statement = null;
            ResultSet resultSet;

            try{
                connection = dbHelper.getConnection();
                statement = connection.createStatement();

                resultSet = statement.executeQuery("SELECT dateOfTreatment\n"
                        + "FROM trial.treatment\n"
                        + "INNER JOIN trial.healthtreatment \n"
                        + "    ON trial.healthtreatment.healthtreatmentID = trial.treatment.treatmentID");
                while(resultSet.next()){
                    treatments.add(new HealthTreatment(resultSet.getDate("date of treatment").toLocalDate(),
                            resultSet.getBoolean("emergency")));
                }

                resultSet = statement.executeQuery("SELECT dateOfTreatment\n"
                        + "FROM trial.treatment\n"
                        + "INNER JOIN trial.cleaningtreatment \n"
                        + "    ON trial.cleaningtreatment.cleaningtreatmentID = trial.treatment.treatmentID");
                while(resultSet.next()){
                    treatments.add(new CleaningTreatment(resultSet.getDate("date of treatment").toLocalDate(),
                            resultSet.getString("material used")));
                }

            }catch(SQLException e){
                dbHelper.showErrorMessage(e);
            } catch (ClassNotFoundException ex) {
                dbHelper.showErrorMessage(ex);
            } catch (InstantiationException ex) {
                dbHelper.showErrorMessage(ex);
            } catch (IllegalAccessException ex) {
                dbHelper.showErrorMessage(ex);
            }finally{
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    dbHelper.showErrorMessage(ex);
                }
            }
        } catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }
        return treatments;
    }

    public static int IDgenerator(ArrayList arrayList){
        int ID = 0;
        try {
            for(Object object: arrayList){
                ID++;
            }
            ID+=1001;

        } catch (NullPointerException e){
            System.out.println("NULL POINTER EXCEPTION!");
        }
        return ID;
    }
}
