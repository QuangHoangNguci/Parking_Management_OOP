package ObjectClasses;

import ObjectClasses.ParkingContract;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Nguyen Quang Huy Hoang
 */
public class VanContract extends ParkingContract{
    private double feePerMonth1Ton;
    private double offerVan;
    private double load;
    
    public VanContract(String numberPlate, double load, String dayIn, String dayOut) {
        super(numberPlate, dayIn, dayOut);
        this.load = load;
    }
    
    public double getLoad() {
        return load;
    } 
    
    @Override
    public double calculateFeePerMonth() {
        getFeeAndOffer();
        if(this.getTimeParking() >= 5){
            return feePerMonth1Ton * (1 - offerVan) * load;
        }else{
            return feePerMonth1Ton;
        }
    }   

    @Override
    public double calculateFee() {
        return calculateFeePerMonth() * getTimeParking();
    }

    @Override
    public void getFeeAndOffer() {
       try (FileInputStream f = new FileInputStream("feeandoffer.properties")) {
            // load the properties file
            Properties pros = new Properties();
            pros.load(f);
            feePerMonth1Ton = Double.parseDouble(pros.getProperty("feePerMonth1Ton"));
            offerVan = Double.parseDouble(pros.getProperty("offerVan"));      
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
