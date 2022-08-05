package za.ac.cput.domain.lookup;

/*
 * @author Karl Haupt (220236585)
 * MatchLocation.java -> is an entity in the problem domain to associate SoccerMatch with Location.
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(MatchLocation.MatchLocationID.class)
public class MatchLocation {
    @NotNull @Id
    private String matchId, locationId;

    protected MatchLocation() {}

    public MatchLocation(Builder builder) {
        this.matchId = builder.matchId;
        this.locationId = builder.locationId;
    }

    public String getMatchId() {
        return matchId;
    }

    public String getLocationId() {
        return locationId;
    }

    @Override
    public String toString() {
        return "MatchLocation{" +
                "matchId='" + matchId + '\'' +
                ", locationId='" + locationId + '\'' +
                '}';
    }

    public static class Builder {
        private String matchId;
        private String locationId;

        public Builder setMatchId(String matchId) {
            this.matchId = matchId;
            return this;
        }

        public Builder setLocationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        public Builder copy(MatchLocation matchLocation) {
            this.matchId = matchLocation.matchId;
            this.locationId = matchLocation.locationId;
            return this;
        }

        public MatchLocation build() {
            return new MatchLocation(this);
        }
    }

    public static class MatchLocationID implements Serializable {
        private String matchId, locationId;

        protected MatchLocationID() {}

        public MatchLocationID(String matchId, String locationId) {
            this.matchId = matchId;
            this.locationId = locationId;
        }

        public String getMatchId() {
            return matchId;
        }

        public String getLocationId() {
            return locationId;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchLocation that = (MatchLocation) o;
        return matchId.equals(that.matchId) && locationId.equals(that.locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchId, locationId);
    }
}

