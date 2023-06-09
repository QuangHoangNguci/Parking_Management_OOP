package ObjectClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Nguyen Quang Huy Hoang
 */
public class CarContract extends ParkingContract{
    private double feePerMonthCar;
    private double offerCar;

    public CarContract(String numberPlate, String dayIn, String dayOut) {
        super(numberPlate, dayIn, dayOut);
    }

    @Override
    public double calculateFee() {
        return calculateFeePerMonth() * this.getTimeParking();
    }
    
    @Override
    public double calculateFeePerMonth() {
        getFeeAndOffer();
        if(this.getTimeParking() >= 5)
           return feePerMonthCar * (1 - offerCar);
        return feePerMonthCar;
    }
    
    //get fee and offer for car from properties file
    @Override
    public void getFeeAndOffer(){
        try (FileInputStream f = new FileInputStream("feeandoffer.properties")) {
            // load the properties file
            Properties pros = new Properties();
            pros.load(f);
            feePerMonthCar = Double.parseDouble(pros.getProperty("feePerMonthCar"));
            offerCar = Double.parseDouble(pros.getProperty("offerCar"));      
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //get fee per month
    public static void main(String[] args) {
       // System.out.println(getFee());
    }
}
