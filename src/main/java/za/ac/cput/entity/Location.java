package za.ac.cput.entity;

/*
* Karl Haupt (220236585)
* Location.java -> is an entity in the problem domain to store the various location that soccer clubs can play at.
* */

public class Location {
    private int locationId;
    private String stadiumName;

    private Location(Builder builder) {
        this.stadiumName = builder.stadiumName;
    }

    public int getLocationId() {
        return locationId;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", stadiumName='" + stadiumName + '\'' +
                '}';
    }

    public static class Builder {
        private int locationId;
        private String stadiumName;

        public Builder setLocationId(int locationId) {
            this.locationId = locationId;
            return this;
        }

        public Builder setStadiumName(String stadiumName) {
            this.stadiumName = stadiumName;
            return this;
        }

        public Builder copy(Location location) {
            this.locationId = location.locationId;
            this.stadiumName = location.stadiumName;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }
}
