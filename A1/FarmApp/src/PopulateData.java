import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * PopulateData Class
 */
public class PopulateData {
    PopulateData() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        /**
         * cow obj1
         */
        try {
            String DOB = "10/01/2020";
            Date date1 = format.parse(DOB);
            Cow cows1 = new Cow(1, "Female", date1, true);
            FarmApp.cows.add(cows1);
            String DOB2 = "15/05/2020";
            String DOB3 = "19/05/2020";
            Date date2 = format.parse(DOB2);
            Date date3 = format.parse(DOB3);
            Treatment treatment = new Treatment(date2, "Plague Vaccine");
            Medication medication = new Medication("vaccination", 30, date3, 2.0, "Get well");
            cows1.newTreatments(treatment);
            cows1.newMedications(medication);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        /**
         * cow obj2
         */
        try {
            String DOB1 = "28/11/2021";
            Date date1 = format.parse(DOB1);
            Cow cows1 = new Cow(2, "Male", date1, true);
            FarmApp.cows.add(cows1);
            String DOB2 = "22/06/2022";
            String DOB3 = "25/06/2022";
            Date date2 = format.parse(DOB2);
            Date date3 = format.parse(DOB3);
            Treatment treatment1 = new Treatment(date2, "Pen-strep");
            Medication medication1 = new Medication("penicillin-streptomycin combination", 20, date3, 3.0, "Get well");
            cows1.newTreatments(treatment1);
            cows1.newMedications(medication1);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        /**
         * cow obj3
         */
        try {
            String DOB1 = "28/11/2020";
            Date date1 = format.parse(DOB1);
            Cow cows1 = new Cow(3, "Male", date1, false);
            FarmApp.cows.add(cows1);
            String DOB2 = "21/12/2021";
            String DOB3 = "26/12/2021";
            Date date2 = format.parse(DOB2);
            Date date3 = format.parse(DOB3);
            Treatment treatment2 = new Treatment(date2, "Milk Fever Case");
            Medication medication2 = new Medication("calcium IV", 3, date3, 25.0, "Get well");
            cows1.newTreatments(treatment2);
            cows1.newMedications(medication2);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        /**
         * vet obj1
         */
        try {
            String dob = "26/05/2000";
            Date d = format.parse(dob);
            Veterinary vet = new Veterinary(1, "Female", d, 25.000);
            FarmApp.vets.add(vet);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        /**
         * vet obj2
         */
        try {
            String dob = "12/07/2000";
            Date d = format.parse(dob);
            Veterinary vet = new Veterinary(2, "Male", d, 30.000);
            FarmApp.vets.add(vet);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        /**
         * vet obj3
         */
        try {
            String dob = "28/07/2000";
            Date d = format.parse(dob);
            Veterinary vet = new Veterinary(3, "Female", d, 20.000);
            FarmApp.vets.add(vet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}