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
        Helper.checkStringParam("vinNumber", vinNumber);
        Helper.checkStringParam("modelType", modelType);
        Helper.checkStringParam("modelName", modelName);
        Helper.checkStringParam("capacity", capacity);

        return new Vehicle.Builder()
                .setVinNumber(vinNumber)
                .setModelType(modelType)
                .setModelName(modelName)
                .setCapacity(capacity)
                .build();
    }
}
