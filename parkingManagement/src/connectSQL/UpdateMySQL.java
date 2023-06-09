package connectSQL;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hoang Ha My & Nguyen QUang Huy Hoang
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import ObjectClasses.Car;
import ObjectClasses.CarContract;
import ObjectClasses.Van;
import ObjectClasses.VanContract;

public class UpdateMySQL {
    public static void deleteCarContract(String numberPlate) {
        String sqlUpdate = "DELETE FROM car " + "WHERE NumberPlate = ?";
        try(Connection conn = MySQLJDBCUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlUpdate,Statement.RETURN_GENERATED_KEYS)){
                    pstmt.setString(1, numberPlate);
                    int rowAffected = pstmt.executeUpdate();
                    if(rowAffected == 1) System.out.print("OK");
    }catch (SQLException ex){
        System.out.println(ex.getMessage());  
        }  
    }
    
    public static void deleteVanContract(String numberPlate) {
        String sqlUpdate = "DELETE FROM van " + "WHERE NumberPlate = ?";
        try(Connection conn = MySQLJDBCUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlUpdate,Statement.RETURN_GENERATED_KEYS)){
                    pstmt.setString(1, numberPlate);
                    int rowAffected = pstmt.executeUpdate();
                    if(rowAffected == 1) System.out.print("OK");
    }catch (SQLException ex){
        System.out.println(ex.getMessage());  
        }  
    }
    
    public static void updateCarContract(Car car, CarContract carContract) throws ParseException{
        String sqlUpdate = "UPDATE car natural join carticket " + "SET OwnerName = ?, Brand = ?, NumberOfSeat = ?, "
                + " DayIn = ?, DayOut = ?, FeePerMonth = ?, FeeAllTime = ? " + "WHERE NumberPlate = ?";
        try(Connection conn = MySQLJDBCUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)){
                    pstmt.setString(1, car.getOwnerName());
                    pstmt.setString(2, car.getBrand());
                    pstmt.setInt(3, car.getNumberOfSeat());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date dayIn = simpleDateFormat.parse(carContract.getDayIn());
                    java.util.Date dayOut = simpleDateFormat.parse(carContract.getDayOut());
                    pstmt.setDate(4, new java.sql.Date(dayIn.getTime()));
                    pstmt.setDate(5, new java.sql.Date(dayOut.getTime()));
                    pstmt.setDouble(6, carContract.calculateFeePerMonth());
                    pstmt.setDouble(7, carContract.calculateFee());
                    pstmt.setString(8, car.getNumberPlate());
                    int rowAffected = pstmt.executeUpdate();  
                    System.out.println(rowAffected);
                 
    }catch (SQLException ex){
        System.out.println(ex.getMessage());  
        }  
    }
    
    public static void updateVanContract(Van van, VanContract vanContract) throws ParseException{
            String sqlUpdate = "UPDATE van natural join vanticket " + "SET OwnerName = ?, Brand = ?, LoadVan = ?, "
                + " DayIn = ?, DayOut = ?, FeePerMonth = ?, FeeAllTime = ? " + "WHERE NumberPlate = ?";
        try(Connection conn = MySQLJDBCUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)){
                    pstmt.setString(1, van.getOwnerName());
                    pstmt.setString(2, van.getBrand());
                    pstmt.setDouble(3, vanContract.getLoad());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date dayIn = simpleDateFormat.parse(vanContract.getDayIn());
                    java.util.Date dayOut = simpleDateFormat.parse(vanContract.getDayOut());
                    pstmt.setDate(4, new java.sql.Date(dayIn.getTime()));
                    pstmt.setDate(5, new java.sql.Date(dayOut.getTime()));
                    pstmt.setDouble(6, vanContract.calculateFeePerMonth());
                    pstmt.setDouble(7, vanContract.calculateFee());
                    pstmt.setString(8, van.getNumberPlate());
                    int rowAffected = pstmt.executeUpdate();  
                    System.out.println(rowAffected);
                 
    }catch (SQLException ex){
        System.out.println(ex.getMessage());  
        }  
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        deleteVanContract("19C43941");
}
}
