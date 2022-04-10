package za.ac.cput.entity;

/* Vehicle.java
   Entity for the Vehicle
   Author: Joshua Daniel Jonkers(215162668)
   Date: 08/04/2022
 */

public class Vehicle {
    private String vinNumber;
    private String modelType;
    private String modelName;
    private String capacity;

    private Vehicle(Builder builder) {
        this.vinNumber = builder.vinNumber;
        this.modelType = builder.modelType;
        this.modelName = builder.modelName;
        this.capacity = builder.capacity;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public String getModelType() {
        return modelType;
    }

    public String getModelName() {
        return modelName;
    }

    public String getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vinNumber='" + vinNumber + '\'' +
                ", modelType='" + modelType + '\'' +
                ", modelName='" + modelName + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }

    public static class Builder {
        private String vinNumber;
        private String modelType;
        private String modelName;
        private String capacity;

        public Builder setVinNumber(String vinNumber) {
            this.vinNumber = vinNumber;
            return this;
        }

        public Builder setModelType(String modelType) {
            this.modelType = modelType;
            return this;
        }

        public Builder setModelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public Builder setCapacity(String capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder copy(Vehicle vehicle) {
            this.vinNumber = vehicle.vinNumber;
            this.modelType = vehicle.modelType;
            this.modelName = vehicle.modelName;
            this.capacity = vehicle.capacity;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}
