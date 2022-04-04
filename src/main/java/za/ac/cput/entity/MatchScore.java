package za.ac.cput.entity;

/*
 * Karl Haupt (220236585)
 * MatchScore.java -> is an entity in the problem domain to store the various match results that the team(s) has played.
 */

public class MatchScore {
    private int matchID;
    private int opponentScore;
    private int teamScore;

    private MatchScore(Builder builder) {
        this.matchID = builder.matchID;
        this.opponentScore = builder.opponentScore;
        this.teamScore = builder.teamScore;
    }

    public int getMatchID() {
        return matchID;
    }

    public int getOpponentScore() {
        return opponentScore;
    }

    public int getTeamScore() {
        return teamScore;
    }

    public static class Builder {
        private int matchID;
        private int opponentScore;
        private int teamScore;

        public Builder setMatchID(int matchID) {
            this.matchID = matchID;
            return this;
        }

        public Builder setOpponentScore(int opponentScore) {
            this.opponentScore = opponentScore;
            return this;
        }

        public Builder setTeamScore(int teamScore) {
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
