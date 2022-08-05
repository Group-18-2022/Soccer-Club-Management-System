package za.ac.cput.domain.match;

/*
* @author Karl Haupt (220236585)
* Location.java -> is an entity in the problem domain to store the various location that soccer clubs can play at.
* */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Location {
    @NotNull
    @Id
    private String locationId;
    @NotNull
    private String stadiumName;

    protected Location() {}

    private Location(Builder builder) {
        this.locationId = builder.locationId;
        this.stadiumName = builder.stadiumName;
    }

    public String getLocationId() {
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
        private String locationId;
        private String stadiumName;

        public Builder setLocationId(String locationId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return locationId.equals(location.locationId) && stadiumName.equals(location.stadiumName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, stadiumName);
    }
}
