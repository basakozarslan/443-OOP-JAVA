package MyPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * Populate Data class that extends FarmApp.
 */
public class PopulateData extends FarmApp{
    PopulateData(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
/**
 * cow obj1
 */
        try {
            Cow cow1 = new Cow();
            cow1.setTagNo(1);
            cow1.setGender("Female");
            LocalDate dateOfBirth1 = LocalDate.of(2020, 1, 10);
            cow1.setDateOfBirth(dateOfBirth1);
            cow1.setPurchased(false);
            LocalDate dateOfMilk = LocalDate.of(2022, 5, 25);
            cow1.milking.put(dateOfMilk , 30.0);
            cow1.setWeight(520.0);
            HealthTreatment healthTreatment1 = new HealthTreatment();
            CleaningTreatment cleaningTreatment1 = new CleaningTreatment();
            String DOB2 = "10/01/2020";
            Date dateOfTreat = format.parse(DOB2);
            healthTreatment1.setDateOfTreatment(dateOfTreat);
            healthTreatment1.setEmergency(true);
            String DOB1 = "19/05/2020";
            Date date = format.parse(DOB1);
            Medication medication = new Medication("vaccination", 30, date, 2.0, "Get well");
            String DOB3 = "17/05/2021";
            Date dateOfTreat2 = format.parse(DOB3);
            cleaningTreatment1.setDateOfTreatment(dateOfTreat2);
            cleaningTreatment1.setMaterialsused("Pill");
        } catch (ParseException e) {
            e.printStackTrace();
        }
/**
 * cow obj2
 */
        try {
            Cow cow1 = new Cow();
            cow1.setTagNo(2);
            cow1.setGender("Male");
            LocalDate dateOfBirth1 = LocalDate.of(2019, 1, 15);
            cow1.setDateOfBirth(dateOfBirth1);
            cow1.setPurchased(false);
            LocalDate dateOfMilk = LocalDate.of(2012, 8, 25);
            cow1.milking.put(dateOfMilk , 35.0);
            cow1.setWeight(585.0);
            HealthTreatment healthTreatment1 = new HealthTreatment();
            CleaningTreatment cleaningTreatment1 = new CleaningTreatment();
            String DOB2 = "12/01/2021";
            Date dateOfTreat = format.parse(DOB2);
            healthTreatment1.setDateOfTreatment(dateOfTreat);
            healthTreatment1.setEmergency(true);
            String DOB1 = "19/10/2020";
            Date date = format.parse(DOB1);
            Medication medication = new Medication("vaccination", 20, date, 1.0, "Get well");
            String DOB3 = "17/11/2020";
            Date dateOfTreat2 = format.parse(DOB3);
            cleaningTreatment1.setDateOfTreatment(dateOfTreat2);
            cleaningTreatment1.setMaterialsused("Pill");
        } catch (ParseException e) {
            e.printStackTrace();
        }
/**
 * sheep obj1
 */
        try {
            Sheep sheep1 = new Sheep();
            sheep1.setTagNo(1);
            sheep1.setGender("Female");
            LocalDate dateOfBirth1 = LocalDate.of(2020, 1, 10);
            sheep1.setDateOfBirth(dateOfBirth1);
            sheep1.setPurchased(false);
            LocalDate dateOfMilk = LocalDate.of(2022, 5, 25);
            sheep1.milking.put(dateOfMilk , 30.0);
            HealthTreatment healthTreatment1 = new HealthTreatment();
            CleaningTreatment cleaningTreatment1 = new CleaningTreatment();
            String DOB2 = "6/6/2018";
            Date dateOfTreat = format.parse(DOB2);
            healthTreatment1.setDateOfTreatment(dateOfTreat);
            healthTreatment1.setEmergency(true);
            String DOB1 = "18/02/2014";
            Date date = format.parse(DOB1);
            Medication medication = new Medication("vaccination", 30, date, 2.0, "Get well");
            String DOB3 = "11/07/2019";
            Date dateOfTreat2 = format.parse(DOB3);
            cleaningTreatment1.setDateOfTreatment(dateOfTreat2);
            cleaningTreatment1.setMaterialsused("Pill");
        } catch (ParseException e) {
            e.printStackTrace();
        }
/**
 * sheep obj2
 */
        try {
            Sheep sheep1 = new Sheep();
            sheep1.setTagNo(1);
            sheep1.setGender("Male");
            LocalDate dateOfBirth1 = LocalDate.of(2020, 5, 13);
            sheep1.setDateOfBirth(dateOfBirth1);
            sheep1.setPurchased(false);
            LocalDate dateOfMilk = LocalDate.of(2016, 8, 15);
            sheep1.milking.put(dateOfMilk , 47.0);
            HealthTreatment healthTreatment1 = new HealthTreatment();
            CleaningTreatment cleaningTreatment1 = new CleaningTreatment();
            String DOB2 = "5/5/2019";
            Date dateOfTreat = format.parse(DOB2);
            healthTreatment1.setDateOfTreatment(dateOfTreat);
            healthTreatment1.setEmergency(true);
            String DOB1 = "13/04/2019";
            Date date = format.parse(DOB1);
            Medication medication = new Medication("vaccination", 10, date, 5.0, "Get well");
            String DOB3 = "11/07/2019";
            Date dateOfTreat2 = format.parse(DOB3);
            cleaningTreatment1.setDateOfTreatment(dateOfTreat2);
            cleaningTreatment1.setMaterialsused("Pill");
        } catch (ParseException e) {
            e.printStackTrace();
        }
/**
 * vet obj1
 */
        try {
            Veterinary vet1 = new Veterinary();
            vet1.setEmpID(1);
            vet1.setGender("Male");
            LocalDate dateOfBirth1 = LocalDate.of(2010, 7, 13);
            vet1.setDateOfBirth(dateOfBirth1);
            vet1.setBScDegree(true);
            LocalDate dateOfGrad = LocalDate.of(2010, 7, 13);
            vet1.setDateOfGraduation(dateOfGrad);
            vet1.setExpertiseLevel(2);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
/**
 * vet obj2
 */
        try {
            Veterinary vet1 = new Veterinary();
            vet1.setEmpID(5);
            vet1.setGender("Female");
            LocalDate dateOfBirth1 = LocalDate.of(2017, 2, 14);
            vet1.setDateOfBirth(dateOfBirth1);
            vet1.setBScDegree(true);
            LocalDate dateOfGrad = LocalDate.of(2018, 4, 10);
            vet1.setDateOfGraduation(dateOfGrad);
            vet1.setExpertiseLevel(8);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
/**
 * farmworker obj1
 */
        try {
            FarmWorker farmWorker1 = new FarmWorker();
            farmWorker1.setEmpID(5);
            farmWorker1.setGender("Female");
            LocalDate dateOfBirth1 = LocalDate.of(1999, 3, 17);
            farmWorker1.setDateOfBirth(dateOfBirth1);
            farmWorker1.setPreviousFarmName("Aysu");
            farmWorker1.setWorkexperience(10);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
/**
 * farmworker obj2
 */
        try {
            FarmWorker farmWorker1 = new FarmWorker();
            farmWorker1.setEmpID(3);
            farmWorker1.setGender("Male");
            LocalDate dateOfBirth1 = LocalDate.of(2000, 2, 14);
            farmWorker1.setDateOfBirth(dateOfBirth1);
            farmWorker1.setPreviousFarmName("Ali");
            farmWorker1.setWorkexperience(12);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }

    }

}
