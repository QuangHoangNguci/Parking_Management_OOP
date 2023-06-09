package parkingManagement;

import ObjectClasses.VanContract;
import connectSQL.InsertMySQL;
import connectSQL.UpdateMySQL;
import java.text.ParseException;

public class test {
    public static void main(String[] args) throws ParseException {
        
       /*CarContract carContract = new CarContract("30K41975", "18/02/2023", "20/10/2023");
        System.out.println(carContract.getTimeParking());
//        double a= carContract.calculateFee();
        //System.out.println(Date.valueOf(carContract.getDayIn()));
        System.out.println(carContract.calculateFee());
        InsertMySQL.insertCar("Nguyen Van A", "30K41975", "Toyota", 4);
        InsertMySQL.insertCarContract(carContract);
        */
        InsertMySQL.insertVan("Le Van Tuy", "89C89212", "Suzuki");
        VanContract vanContract = new VanContract("89C89212", 2.5, "30/09/2022", "31/02/2023");
        System.out.println(vanContract.getTimeParking());
        InsertMySQL.insertVanContract(vanContract);
        //UpdateMySQL.deleteCarContract("19A48455");*/
        
    }
}
