package za.ac.cput.factory;

/* VehicleFactory.java
   Factory for the Vehicle
   Author: Joshua Daniel Jonkers(215162668)
   Date: 09/04/2022
 */

import za.ac.cput.domain.Vehicle;
import za.ac.cput.util.Helper;

public class VehicleFactory {

    public static Vehicle createVehicle(String vinNumber, String modelType, String modelName, String capacity) {
//        if(Helper.isNull(vinNumber) || Helper.isNull(modelType) || Helper.isNull(modelName) || Helper.isNull(capacity) ||
//            Helper.isEmpty(vinNumber) || Helper.isEmpty(modelType) || Helper.isEmpty(modelName) || Helper.isEmpty(capacity))
//            throw new IllegalStateException("Invalid values");

        var vehicle = new Vehicle.Builder()
                .setVinNumber(vinNumber)
                .setModelType(modelType)
                .setModelName(modelName)
                .setCapacity(capacity)
                .build();

        return vehicle;
    }
}
