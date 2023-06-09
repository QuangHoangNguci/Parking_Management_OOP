/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjectClasses;

/**
 *
 * @author Hoang Ha My
 */
public class Van extends Vehicle{

    public Van(String ownerName, String numberPlate, String brand) {
        super(ownerName, numberPlate, brand);
    }
    @Override
    public String getBrand() {
        return super.getBrand();
    }

    @Override
    public String getNumberPlate() {
        return super.getNumberPlate();
    }


}