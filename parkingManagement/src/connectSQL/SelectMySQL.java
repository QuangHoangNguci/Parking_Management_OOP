package connectSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hoang Ha My & Nguyen Quang Huy Hoang
 */
public class SelectMySQL {
    public static void searchByNumberPlateCar(javax.swing.JTable table, String numberPlate){
        String sql = "SELECT * " + "FROM car natural join carticket"
                + " WHERE NumberPlate = '" + numberPlate + "' ORDER BY DayIn ASC";
        int stt = 0;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try(Connection conn = MySQLJDBCUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                stt++;
                String ownerName = rs.getString("OwnerName");
                String brand = rs.getString("Brand");
                String numberOfSeat = rs.getString("NumberOfSeat");
                String dayIn = rs.getString("DayIn");
                String dayOut = rs.getString("DayOut");
                String feeMonth = rs.getString("FeePerMonth");
                String feeAll = rs.getString("FeeAllTime");
                model.addRow(new Object[]{String.valueOf(stt), ownerName, numberPlate, brand, numberOfSeat, dayIn, dayOut, feeMonth, feeAll});
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }  
    }
    
    public static void searchByOwnerNameCar(javax.swing.JTable table, String ownerName){
        String sql = "SELECT * " + "FROM car natural join carticket"
                + " WHERE OwnerName = '" + ownerName + "' ORDER BY DayIn ASC";
        int stt = 0;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try(Connection conn = MySQLJDBCUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                stt++;
                String numberPlate = rs.getString("NumberPlate");
                String brand = rs.getString("Brand");
                String numberOfSeat = rs.getString("NumberOfSeat");
                String dayIn = rs.getString("DayIn");
                String dayOut = rs.getString("DayOut");
                String feeMonth = rs.getString("FeePerMonth");
                String feeAll = rs.getString("FeeAllTime");
                model.addRow(new Object[]{String.valueOf(stt), ownerName, numberPlate, brand, numberOfSeat, dayIn, dayOut, feeMonth, feeAll});
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }  
    }
    
    public static void searchByNumberPlateVan(javax.swing.JTable table, String numberPlate){
        String sql = "SELECT * " + "FROM van natural join vanticket"
                + " WHERE NumberPlate = '" + numberPlate + "' ORDER BY DayIn ASC";
        int stt = 0;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try(Connection conn = MySQLJDBCUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                stt++;
                String ownerName = rs.getString("OwnerName");
                String brand = rs.getString("Brand");
                String load = rs.getString("LoadVan");
                String dayIn = rs.getString("DayIn");
                String dayOut = rs.getString("DayOut");
                String feeMonth = rs.getString("FeePerMonth");
                String feeAll = rs.getString("FeeAllTime");
                model.addRow(new Object[]{String.valueOf(stt), ownerName, numberPlate, brand, load, dayIn, dayOut, feeMonth, feeAll});
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }  
    }
    
    public static void searchByOwnerNameVan(javax.swing.JTable table, String ownerName){
        String sql = "SELECT * " + "FROM van natural join vanticket"
                + " WHERE OwnerName = '" + ownerName + "' ORDER BY DayIn ASC";
        int stt = 0;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try(Connection conn = MySQLJDBCUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                stt++;
                String numberPlate = rs.getString("NumberPlate");
                String brand = rs.getString("Brand");
                String load = rs.getString("LoadVan");
                String dayIn = rs.getString("DayIn");
                String dayOut = rs.getString("DayOut");
                String feeMonth = rs.getString("FeePerMonth");
                String feeAll = rs.getString("FeeAllTime");
                model.addRow(new Object[]{String.valueOf(stt), ownerName, numberPlate, brand, load, dayIn, dayOut, feeMonth, feeAll});
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }  
    }
    
    public static void searchType(javax.swing.JTable table, String type){
        type = type.toUpperCase();
        String sql;
        if(type.equals("VAN")){
           sql = "SELECT * " + "FROM van natural join vanticket"
                + " ORDER BY DayIn ASC";
        }else{
            sql = "SELECT * " + "FROM car natural join carticket"
                + " ORDER BY DayIn ASC";
        }
        int stt = 0;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try(Connection conn = MySQLJDBCUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                stt++;
                String ownerName = rs.getString("OwnerName");
                String numberPlate = rs.getString("NumberPlate");
                String brand = rs.getString("Brand");
                String tmp;
                if (type.equals("VAN")){
                    tmp = rs.getString("LoadVan");
                }else{
                    tmp = rs.getString("NumberOfSeat");
                }
                String dayIn = rs.getString("DayIn");
                String dayOut = rs.getString("DayOut");
                String feeMonth = rs.getString("FeePerMonth");
                String feeAll = rs.getString("FeeAllTime");
                model.addRow(new Object[]{String.valueOf(stt), ownerName, numberPlate, brand, tmp, dayIn, dayOut, feeMonth, feeAll});
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }  
    }
    
    public static void searchByFee(javax.swing.JTable table, double amount){
        String sql = "SELECT * " + "FROM car natural join carticket"
                + " WHERE FeePerMonth > " + amount;
        String sql1 = "SELECT * " + "FROM van natural join vanticket"
                + " WHERE FeePerMonth > " + amount;
        int stt = 0;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try(Connection conn = MySQLJDBCUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                stt++;
                String ownerName = rs.getString("OwnerName");
                String numberPlate = rs.getString("NumberPlate");
                String brand = rs.getString("Brand");
                String numberOfSeat = rs.getString("NumberOfSeat");
                String dayIn = rs.getString("DayIn");
                String dayOut = rs.getString("DayOut");
                String feeMonth = rs.getString("FeePerMonth");
                String feeAll = rs.getString("FeeAllTime");
                model.addRow(new Object[]{String.valueOf(stt), ownerName, numberPlate, brand, numberOfSeat, dayIn, dayOut, feeMonth, feeAll});
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }  
        try(Connection conn = MySQLJDBCUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql1)){
            while (rs.next()){
                stt++;
                String ownerName = rs.getString("OwnerName");
                String numberPlate = rs.getString("NumberPlate");
                String brand = rs.getString("Brand");
                String load = rs.getString("LoadVan");
                String dayIn = rs.getString("DayIn");
                String dayOut = rs.getString("DayOut");
                String feeMonth = rs.getString("FeePerMonth");
                String feeAll = rs.getString("FeeAllTime");
                model.addRow(new Object[]{String.valueOf(stt), ownerName, numberPlate, brand, load, dayIn, dayOut, feeMonth, feeAll});
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static int checkCar(String numberPlate){
        int ans = 0;
        String sql = "SELECT numberPlate " +"FROM car "
                + "WHERE NumberPlate = '" + numberPlate + "'";
        //System.out.println(sql);
        try(Connection conn = MySQLJDBCUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            if (rs.next()){
                ans = 1;
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }  
        return ans;
    }
    
    public static int checkVan(String numberPlate){
        int ans = 0;
        String sql = "SELECT numberPlate " +"FROM van "
                + "WHERE NumberPlate = '" + numberPlate + "'";
        try(Connection conn = MySQLJDBCUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            if (rs.next()){
                ans = 1;
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }  
        return ans;
    }
    
    //calculate Proceed from beginDate to endDate
    public static double calculateProceed(Date beginDate, Date endDate){
        double sumProceed = 0;
        String sql = "SELECT * " + "FROM carticket";
        String sql1 = "SELECT * " + "FROM vanticket";
        
        //calculate all car contracts
        try(Connection conn = MySQLJDBCUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                
                //get dayin, dayout, fee per month of car contract
                Date dayIn = rs.getDate("DayIn");
                Date dayOut = rs.getDate("DayOut");
                Double feeMonth = rs.getDouble("FeePerMonth");
                long tmp = 0, d = 0;
                
                //case 1: dayin BEFORE or IS beginDate, dayout AFTER or IS endDate
                if(dayIn.compareTo(beginDate) <= 0 && dayOut.compareTo(endDate) >= 0){
                    tmp = Math.abs(endDate.getTime() - beginDate.getTime());
                    d = tmp/(24*60*60*1000);
                }
                //case 2: dayin BEFORE or IS beginDate, dayout BEFORE or IS endDate
                else if(dayIn.compareTo(beginDate) <= 0 && dayOut.compareTo(endDate) <= 0 && dayOut.compareTo(beginDate) >=0 ){
                   tmp = Math.abs(dayOut.getTime() - beginDate.getTime());
                    d = tmp/(24*60*60*1000);
                }
                //case 3: dayin AFTER or IS beginDate, dayout BEFORE or IS endDate
                else if(dayIn.compareTo(beginDate) >= 0 && dayIn.compareTo(endDate) <= 0 && dayOut.compareTo(endDate) <= 0){
                    tmp = Math.abs(dayOut.getTime() - dayIn.getTime());
                    d = tmp/(24*60*60*1000);  
                }
                //case 4: dayin AFTER or IS beginDate, dayout AFTER or IS endDate
                else if(dayIn.compareTo(beginDate) >= 0 && dayIn.compareTo(endDate) <= 0 && dayOut.compareTo(endDate) >= 0){
                    tmp = Math.abs(endDate.getTime() - dayIn.getTime());
                    d = tmp/(24*60*60*1000);         
                }
                System.out.println(dayIn);
                System.out.println(Math.round((double) d/30) * feeMonth);
                sumProceed += Math.round((double) d/30) * feeMonth;
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }  
        
        //calculate all van contracts 
        try(Connection conn = MySQLJDBCUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql1)){
            while (rs.next()){
                //get dayin, dayout, fee per month of car contract
                Date dayIn = rs.getDate("DayIn");
                Date dayOut = rs.getDate("DayOut");
                
                Double feeMonth = rs.getDouble("FeePerMonth");
                //System.out.println(feeMonth);
                long tmp = 0, d = 0;
                //case 1: dayin BEFORE or IS beginDate, dayout AFTER or IS endDate
                if(dayIn.compareTo(beginDate) <= 0 && dayOut.compareTo(endDate) >= 0){
                    tmp = Math.abs(endDate.getTime() - beginDate.getTime());
                    d = tmp/(24*60*60*1000);
                }
                //case 2: dayin BEFORE or IS beginDate, dayout BEFORE or IS endDate
                else if(dayIn.compareTo(beginDate) <= 0 && dayOut.compareTo(endDate) <= 0 && dayOut.compareTo(beginDate) >=0 ){
                    tmp = Math.abs(dayOut.getTime() - beginDate.getTime());
                    d = tmp/(24*60*60*1000);
                }
                //case 3: dayin AFTER or IS beginDate, dayout BEFORE or IS endDate
                else if(dayIn.compareTo(beginDate) >= 0 && dayIn.compareTo(endDate) <= 0 && dayOut.compareTo(endDate) <= 0){
                    tmp = Math.abs(dayOut.getTime() - dayIn.getTime());
                    d = tmp/(24*60*60*1000);  
                }
                //case 4: dayin AFTER or IS beginDate, dayout AFTER or IS endDate
                else if(dayIn.compareTo(beginDate) >= 0 && dayIn.compareTo(endDate) <= 0 && dayOut.compareTo(endDate) >= 0){
                    tmp = Math.abs(endDate.getTime() - dayIn.getTime());
                    d = tmp/(24*60*60*1000);         
                }
                System.out.println(dayIn);
                System.out.println(Math.round((double) d/30) * feeMonth);
                sumProceed += Math.round((double) d/30) * feeMonth;
                //System.out.println(sumProceed);
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return sumProceed;
    }
    public static void main(String[] args) {
        System.out.println(calculateProceed(Date.valueOf("2017-03-18"), Date.valueOf("2023-10-31")));
    }
}
