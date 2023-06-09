package ObjectClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Nguyen Quang Huy Hoang
 */

public class ParkingContract {
    private String numberPlate;
    private String dayIn;
    private String dayOut;

    public ParkingContract(String numberPlate, String dayIn, String dayOut) {
        this.numberPlate = numberPlate;
        this.dayIn = dayIn;
        this.dayOut = dayOut;
    }

    public String getDayIn() {
        return dayIn;
    }

    public String getDayOut() {
        return dayOut;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    //get time parking in month 
    public long getTimeParking() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        long timeParking = 0;
        try {
            Date startDate = simpleDateFormat.parse(this.dayIn);
            Date endDate = simpleDateFormat.parse(this.dayOut);

            long startValue = startDate.getTime();
            long endValue = endDate.getTime();

            //calculate period time in milisecond
            long tmp = Math.abs(startValue - endValue);
            //get time in day
            long result = tmp/(24*60*60*1000);
            //get time in month
            timeParking = Math.round((double)result/30); 
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return timeParking;
    }

    //calculate fee all time
    public double calculateFee(){return 0;}
    
    //get fee and offer for from properties file
    public void getFeeAndOffer(){}
    
    //calculate fee per month
    public double calculateFeePerMonth(){return 0;}
}
