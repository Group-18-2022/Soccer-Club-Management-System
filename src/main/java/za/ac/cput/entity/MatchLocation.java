package za.ac.cput.entity;

public class MatchLocation {
    private String matchId;
    private String locationId;

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
}
