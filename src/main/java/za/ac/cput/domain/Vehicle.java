package za.ac.cput.domain;

/* Vehicle.java
   Entity for the Vehicle
   Author: Joshua Daniel Jonkers(215162668)
   Date: 08/04/2022
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Vehicle {
    @NotNull
    @Id
    private String vinNumber;
    @NotNull
    private String modelType;
    @NotNull
    private String modelName;
    @NotNull
    private String capacity;

    private Vehicle(Builder builder) {
        this.vinNumber = builder.vinNumber;
        this.modelType = builder.modelType;
        this.modelName = builder.modelName;
        this.capacity = builder.capacity;
    }

    protected Vehicle() {}

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Builder)) return false;
            Builder builder = (Builder) o;
            return vinNumber.equals(builder.vinNumber) && modelType.equals(builder.modelType) && modelName.equals(builder.modelName) && capacity.equals(builder.capacity);
        }

        @Override
        public int hashCode() {
            return Objects.hash(vinNumber, modelType, modelName, capacity);
        }
    }
}
