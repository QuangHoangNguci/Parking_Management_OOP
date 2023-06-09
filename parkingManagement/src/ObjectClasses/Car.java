/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjectClasses;

/**
 *
 * @author Hoang Ha My
 */
public class Car extends Vehicle{
    private int numberOfSeat;

    public Car(String ownerName, String numberPlate, String brand, int numberOfSeat) {
        super(ownerName, numberPlate, brand);
        this.numberOfSeat = numberOfSeat;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    @Override
    public String getBrand() {
        return super.getBrand(); 
    }
}
