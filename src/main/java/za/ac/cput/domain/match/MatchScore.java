package za.ac.cput.domain.match;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/*
 * @author Karl Haupt (220236585)
 * MatchScore.java -> is an entity in the problem domain to store the various match results that the team(s) has played.
 */

@Entity
public class MatchScore {
    @NotNull
    @Id
    private String matchId;
    @NotNull
    private byte opponentScore, teamScore;

    protected MatchScore() {}

    private MatchScore(Builder builder) {
        this.matchId = builder.matchId;
        this.opponentScore = builder.opponentScore;
        this.teamScore = builder.teamScore;
    }

    public String getMatchId() {
        return matchId;
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
                "matchID=" + matchId +
                ", opponentScore=" + opponentScore +
                ", teamScore=" + teamScore +
                '}';
    }

    public static class Builder {
        private String matchId;
        private byte opponentScore;
        private byte teamScore;

        public Builder setMatchId(String matchId) {
            this.matchId = matchId;
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
            this.matchId = matchId;
            this.opponentScore = matchScore.opponentScore;
            this.teamScore = matchScore.teamScore;
            return this;
        }

        public MatchScore build() {
            return new MatchScore(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchScore that = (MatchScore) o;
        return opponentScore == that.opponentScore && teamScore == that.teamScore && matchId.equals(that.matchId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchId, opponentScore, teamScore);
    }
}
