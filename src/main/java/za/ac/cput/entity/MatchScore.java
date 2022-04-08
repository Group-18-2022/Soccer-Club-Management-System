package za.ac.cput.entity;

/*
 * @author Karl Haupt (220236585)
 * MatchScore.java -> is an entity in the problem domain to store the various match results that the team(s) has played.
 */

public class MatchScore {
    private String matchID;
    private byte opponentScore;
    private byte teamScore;

    private MatchScore(Builder builder) {
        this.matchID = builder.matchID;
        this.opponentScore = builder.opponentScore;
        this.teamScore = builder.teamScore;
    }

    public String getMatchID() {
        return matchID;
    }

    public byte getOpponentScore() {
        return opponentScore;
    }

    public byte getTeamScore() {
        return teamScore;
    }

    @Override
    public String toString() {
        return "MatchScore{" +
                "matchID=" + matchID +
                ", opponentScore=" + opponentScore +
                ", teamScore=" + teamScore +
                '}';
    }

    public static class Builder {
        private String matchID;
        private byte opponentScore;
        private byte teamScore;

        public Builder setMatchID(String matchID) {
            this.matchID = matchID;
            return this;
        }

        public Builder setOpponentScore(byte opponentScore) {
            this.opponentScore = opponentScore;
            return this;
        }

        public Builder setTeamScore(byte teamScore) {
            this.teamScore = teamScore;
            return this;
        }

        public Builder copy(MatchScore matchScore) {
            this.matchID = matchID;
            this.opponentScore = matchScore.opponentScore;
            this.teamScore = matchScore.teamScore;
            return this;
        }

        public MatchScore build() {
            return new MatchScore(this);
        }
    }
}
