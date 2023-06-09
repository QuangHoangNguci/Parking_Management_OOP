/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjectClasses;

import java.io.Serializable;

/**
 *
 * @author Hoang Ha My
 */
public abstract class Vehicle implements Serializable{
    private String ownerName;
    private String numberPlate;
    private String brand;

    public Vehicle(String ownerName, String numberPlate, String brand) {
        this.ownerName = ownerName;
        this.numberPlate = numberPlate;
        this.brand = brand;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getBrand() {
        return brand;
    }
    
}
