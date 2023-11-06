package mainPackage;


import animalsPackage.Cow;
import animalsPackage.Sheep;
import peoplePackage.FarmWorker;
import peoplePackage.Veterinary;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fileOperations {
    public class FileOperations implements Serializable {
        private static final long serialVersionUID = 1L;

        public static ArrayList<Cow> ReadCowFile(){
            ArrayList<Cow> cows = new ArrayList<Cow>();

            try{
                File file = new File("cow.txt");    //creates a new file instance
                FileReader fr = new FileReader(file);   //reads the file
                BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
                StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
                String line;

                while((line = br.readLine()) != null) {
                    sb.append(line);      //appends line to string buffer
                    sb.append("\n");     //line feed
                }
                fr.close();    //closes the stream and release the resources

                //First split lines
                String str[] = line.split("\n");
                List newList = Arrays.asList(str);

                for (int i=0; i<newList.size(); i++){
                    String cowLine = newList.get(i).toString();

                    //Then split variables
                    String str2[] = cowLine.split("\t");
                    List newList2 = Arrays.asList(str);
                    String tagNo = newList2.get(0).toString();
                    String dob = newList2.get(3).toString();
                    String weight = newList2.get(4).toString();

                    //Set the taken values to cow object, then add it to arraylist
                    Cow cow = new Cow();
                    cow.setTagNo(Integer.parseInt(tagNo));
                    cow.setGender(newList2.get(1).toString());
                    cow.setPurchased((Boolean) newList2.get(2));
                    cow.setDateOfBirth(Date.valueOf(dob).toLocalDate());
                    cow.setWeight(Integer.parseInt(weight));
                    cows.add(cow);
                }

            } catch (IOException e) {
                System.out.println("IO Exception: "+e.getMessage());
            }
            return cows;
        }
        public static ArrayList<Sheep> ReadSheepFile(){
            ArrayList<Sheep> sheeps = new ArrayList<Sheep>();

            try{
                File file = new File("sheep.txt");    //creates a new file instance
                FileReader fr = new FileReader(file);   //reads the file
                BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
                StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
                String line;

                while((line = br.readLine()) != null) {
                    sb.append(line);      //appends line to string buffer
                    sb.append("\n");     //line feed
                }
                fr.close();    //closes the stream and release the resources

                //First split lines
                String str[] = line.split("\n");
                List newList = Arrays.asList(str);

                for (int i=0; i<newList.size(); i++){
                    String sheepLine = newList.get(i).toString();

                    //Then split variables
                    String str2[] = sheepLine.split("\t");
                    List newList2 = Arrays.asList(str);
                    String tagNo = newList2.get(0).toString();
                    String dob = newList2.get(3).toString();

                    //Set the taken values to sheep object, then add it to arraylist
                    Sheep sheep = new Sheep();
                    sheep.setTagNo(Integer.parseInt(tagNo));
                    sheep.setGender(newList2.get(1).toString());
                    sheep.setPurchased((Boolean) newList2.get(2));
                    sheep.setDateOfBirth(Date.valueOf(dob).toLocalDate());
                    sheeps.add(sheep);
                }

            } catch (IOException e) {
                System.out.println("IO Exception: "+e.getMessage());
            }
            return sheeps;
        }

        public static ArrayList<Veterinary> ReadVeterinaryFile(){
            ArrayList<Veterinary> vets = new ArrayList<Veterinary>();

            try{
                File file = new File("veterinary.txt");    //creates a new file instance
                FileReader fr = new FileReader(file);   //reads the file
                BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
                StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
                String line;

                while((line = br.readLine()) != null) {
                    sb.append(line);      //appends line to string buffer
                    sb.append("\n");     //line feed
                }
                fr.close();    //closes the stream and release the resources

                //First split lines
                String str[] = line.split("\n");
                List newList = Arrays.asList(str);

                for (int i=0; i<newList.size(); i++){
                    String vetLine = newList.get(i).toString();

                    //Then split variables
                    String str2[] = vetLine.split("\t");
                    List newList2 = Arrays.asList(str);
                    String empID = newList2.get(0).toString();
                    String dob = newList2.get(3).toString();
                    String dog = newList2.get(4).toString();
                    String expLevel = newList2.get(5).toString();

                    //Set the taken values to veterinary object, then add it to arraylist
                    Veterinary vet = new Veterinary();
                    vet.setEmpID(Integer.parseInt(empID));
                    vet.setGender(newList2.get(1).toString());
                    vet.setBScDegree((Boolean) newList2.get(2));
                    vet.setDateOfBirth(Date.valueOf(dob).toLocalDate());
                    vet.setDateOfGraduation(Date.valueOf(dog).toLocalDate());
                    vet.setExpertiseLevel(Integer.parseInt(expLevel));
                    vets.add(vet);
                }

            } catch (IOException e) {
                System.out.println("IO Exception: "+e.getMessage());
            }
            return vets;
        }
        public static ArrayList<FarmWorker> ReadFarmWorkerFile(){
            ArrayList<FarmWorker> farmWorkers = new ArrayList<FarmWorker>();

            try{
                File file = new File("farmworker.txt");    //creates a new file instance
                FileReader fr = new FileReader(file);   //reads the file
                BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
                StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
                String line;

                while((line = br.readLine()) != null) {
                    sb.append(line);      //appends line to string buffer
                    sb.append("\n");     //line feed
                }
                fr.close();    //closes the stream and release the resources

                //First split lines
                String str[] = line.split("\n");
                List newList = Arrays.asList(str);

                for (int i=0; i<newList.size(); i++){
                    String farmworkerLine = newList.get(i).toString();

                    //Then split variables
                    String str2[] = farmworkerLine.split("\t");
                    List newList2 = Arrays.asList(str);
                    String empID = newList2.get(0).toString();
                    String dob = newList2.get(3).toString();
                    String workExp = newList2.get(5).toString();

                    //Set the taken values to veterinary object, then add it to arraylist
                    FarmWorker farmWorker = new FarmWorker();
                    farmWorker.setEmpID(Integer.parseInt(empID));
                    farmWorker.setGender(newList2.get(1).toString());
                    farmWorker.setDateOfBirth(Date.valueOf(dob).toLocalDate());
                    farmWorker.setWorkexperience(Integer.parseInt(workExp));
                    farmWorker.setPreviousFarmName(newList2.get(2).toString());
                    farmWorkers.add(farmWorker);
                }

            } catch (IOException e) {
                System.out.println("IO Exception: "+e.getMessage());
            }
            return farmWorkers;
        }

        public static void WriteFarmWorkerFile(){
            ArrayList<FarmWorker> farmWorkers = new ArrayList<FarmWorker>();
            try{
                File fout = new File("farmworker.txt");
                FileOutputStream fos = new FileOutputStream(fout);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

                for (FarmWorker farmWorker : farmWorkers) {
                    String empID = String.valueOf(farmWorker.getEmpID());
                    String dateOfBirth = farmWorker.getDateOfBirth().toString();
                    String WorkExp = String.valueOf(farmWorker.getWorkexperience());

                    bw.write(empID+"\t"+farmWorker.getGender()+"\t"+dateOfBirth+"\t"+WorkExp+"\t"+ farmWorker.getPreviousFarmName());
                    bw.newLine();
                }
                bw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void WriteVetFile(){
            ArrayList<Veterinary> vets = FarmApp.VetArrayList();
            try{
                File fout = new File("veterinary.txt");
                FileOutputStream fos = new FileOutputStream(fout);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

                for (Veterinary vet: vets) {
                    String empID = String.valueOf(vet.getEmpID());
                    String dateOfBirth = vet.getDateOfBirth().toString();
                    String dateOfGrad = vet.getDateOfGraduation().toString();
                    String expLevel = String.valueOf(vet.getExpertiseLevel());

                    bw.write(empID+"\t"+vet.getGender()+"\t"+dateOfGrad+"\t"+dateOfBirth+"\t"+expLevel+"\t"+vet.isBScDegree());
                    bw.newLine();
                }
                bw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void WriteCowFile(){
            ArrayList<Cow> cows = FarmApp.CowArrayList();
            try{
                File fout = new File("cow.txt");
                FileOutputStream fos = new FileOutputStream(fout);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

                for (Cow cow: cows) {
                    String tagNo = String.valueOf(cow.getTagNo());
                    String dateOfBirth = cow.getDateOfBirth().toString();
                    String weight = String.valueOf(cow.getWeight());
                    bw.write(tagNo+"\t"+cow.getGender()+"\t"+weight+"\t"+dateOfBirth+"\t"+cow.isPurchased());
                    bw.newLine();
                }
                bw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void WriteSheepFile(){
            ArrayList<Sheep> sheeps = FarmApp.SheepArrayList();
            try{
                File fout = new File("sheep.txt");
                FileOutputStream fos = new FileOutputStream(fout);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

                for (Sheep sheep: sheeps) {
                    String tagNo = String.valueOf(sheep.getTagNo());
                    String dateOfBirth = sheep.getDateOfBirth().toString();
                    bw.write(tagNo+"\t"+sheep.getGender()+"\t"+dateOfBirth+"\t"+sheep.isPurchased());
                    bw.newLine();
                }
                bw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static void WriteVetFile(String pathName){
            ArrayList<Veterinary> vets = FarmApp.VetArrayList();
            try{
                File fout = new File(pathName);
                FileOutputStream fos = new FileOutputStream(fout);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

                for (Veterinary vet: vets) {
                    String empID = String.valueOf(vet.getEmpID());
                    String dateOfBirth = vet.getDateOfBirth().toString();
                    String dateOfGrad = vet.getDateOfGraduation().toString();
                    String expLevel = String.valueOf(vet.getExpertiseLevel());

                    bw.write(empID+"\t"+vet.getGender()+"\t"+dateOfGrad+"\t"+dateOfBirth+"\t"+expLevel+"\t"+vet.isBScDegree());
                    bw.newLine();
                }
                bw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static void WriteFarmWorkerFile(String pathName){
            ArrayList<FarmWorker> farmWorkers = new ArrayList<FarmWorker>();
            try{
                File fout = new File(pathName);
                FileOutputStream fos = new FileOutputStream(fout);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

                for (FarmWorker farmWorker : farmWorkers) {
                    String empID = String.valueOf(farmWorker.getEmpID());
                    String dateOfBirth = farmWorker.getDateOfBirth().toString();
                    String WorkExp = String.valueOf(farmWorker.getWorkexperience());

                    bw.write(empID+"\t"+farmWorker.getGender()+"\t"+dateOfBirth+"\t"+WorkExp+"\t"+ farmWorker.getPreviousFarmName());
                    bw.newLine();
                }
                bw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void WriteSheepFile(String pathName){
            ArrayList<Sheep> sheeps = FarmApp.SheepArrayList();
            try{
                File fout = new File(pathName);
                FileOutputStream fos = new FileOutputStream(fout);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

                for (Sheep sheep: sheeps) {
                    String tagNo = String.valueOf(sheep.getTagNo());
                    String dateOfBirth = sheep.getDateOfBirth().toString();
                    bw.write(tagNo+"\t"+sheep.getGender()+"\t"+dateOfBirth+"\t"+sheep.isPurchased());
                    bw.newLine();
                }
                bw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void WriteCowFile(String pathName){
            ArrayList<Cow> cows = FarmApp.CowArrayList();
            try{
                File fout = new File(pathName);
                FileOutputStream fos = new FileOutputStream(fout);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

                for (Cow cow: cows) {
                    String tagNo = String.valueOf(cow.getTagNo());
                    String dateOfBirth = cow.getDateOfBirth().toString();
                    String weight = String.valueOf(cow.getWeight());
                    bw.write(tagNo+"\t"+cow.getGender()+"\t"+weight+"\t"+dateOfBirth+"\t"+cow.isPurchased());
                    bw.newLine();
                }
                bw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
