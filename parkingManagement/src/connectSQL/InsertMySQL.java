package connectSQL;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nguyen Quang Huy Hoang
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import ObjectClasses.CarContract;
import ObjectClasses.VanContract;

public class InsertMySQL {
    // for insert new car
    public static void insertCar(String ownerName, String numberPlate, String brand, int numberOfSeat) {
        String sql = "INSERT into car(OwnerName, NumberPlate, Brand, NumberOfSeat) "
                   + "VALUES(?,?,?,?)";
         
        try (Connection conn = MySQLJDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
             
            // set parameters for statement
            pstmt.setString(1, ownerName);
            pstmt.setString(2, numberPlate);
            pstmt.setString(3, brand);
            pstmt.setInt(4, numberOfSeat);

            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1) System.out.printf("OK");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    //for insert new car contract
    public static void insertCarContract(CarContract carContract) throws ParseException{
        String sql = "INSERT into carticket(NumberPlate, DayIn, DayOut, FeePerMonth, FeeAllTime) "
                   + "VALUES(?,?,?,?,?)";
        try (Connection conn = MySQLJDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
            
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date dayIn = simpleDateFormat.parse(carContract.getDayIn());
            java.util.Date dayOut = simpleDateFormat.parse(carContract.getDayOut());
            
            pstmt.setString(1, carContract.getNumberPlate());
            pstmt.setDate(2, new java.sql.Date(dayIn.getTime()));
            pstmt.setDate(3, new java.sql.Date(dayOut.getTime()));
            pstmt.setDouble(4, carContract.calculateFeePerMonth());
            pstmt.setDouble(5, carContract.calculateFee());
            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1) System.out.printf("OK");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
    //for insert new van
    public static void insertVan(String ownerName, String numberPlate, String brand) {
        String sql = "INSERT into van(OwnerName, NumberPlate, Brand) "
                   + "VALUES(?,?,?)";
         
        try (Connection conn = MySQLJDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
             
            // set parameters for statement
            pstmt.setString(1, ownerName);
            pstmt.setString(2, numberPlate);
            pstmt.setString(3, brand);

            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1) System.out.printf("OK");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
    //insert new van contract
    public static void insertVanContract(VanContract vanContract) throws ParseException{
        String sql = "INSERT into vanticket(NumberPlate, LoadVan, DayIn, DayOut, FeePerMonth, FeeAllTime) "
                   + "VALUES(?,?,?,?,?,?)";
        try (Connection conn = MySQLJDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
            
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date dayIn = simpleDateFormat.parse(vanContract.getDayIn());
            java.util.Date dayOut = simpleDateFormat.parse(vanContract.getDayOut());
            
            pstmt.setString(1, vanContract.getNumberPlate());
            pstmt.setDouble(2, vanContract.getLoad());
            pstmt.setDate(3, new java.sql.Date(dayIn.getTime()));
            pstmt.setDate(4, new java.sql.Date(dayOut.getTime()));
            pstmt.setDouble(5, vanContract.calculateFeePerMonth());
            pstmt.setDouble(6, vanContract.calculateFee());
            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1) System.out.printf("OK");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    /**
     * @param args the command line arguments
     */
}