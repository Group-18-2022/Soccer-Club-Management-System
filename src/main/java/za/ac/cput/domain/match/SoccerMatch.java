package za.ac.cput.domain.match;

/*
 * @author Karl Haupt (220236585)
 * SoccerMatch.java -> is an entity in the problem domain to store the various match(s) that team(s) would or have played.
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class SoccerMatch {
    @NotNull @Id
    private String matchId;
    @NotNull
    private String kitType, opponent, date, time;

    protected SoccerMatch() {}

    private SoccerMatch(Builder builder) {
        this.matchId = builder.matchId;
        this.kitType = builder.kitType;
        this.opponent = builder.opponent;
        this.date = builder.date;
        this.time = builder.time;
    }

    public String getMatchId() {
        return matchId;
    }

    public String getKitType() {
        return kitType;
    }

    public String getOpponent() {
        return opponent;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "SoccerMatch{" +
                "matchId=" + matchId +
                ", kitType='" + kitType + '\'' +
                ", opponent='" + opponent + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public static class Builder {
        private String matchId;
        private String kitType;
        private String opponent;
        private String date;
        private String time;

        public Builder setMatchId(String matchId) {
            this.matchId = matchId;
            return this;
        }

        public Builder setKitType(String kitType) {
            this.kitType = kitType;
            return this;
        }

        public Builder setOpponent(String opponent) {
            this.opponent = opponent;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder setTime(String time) {
            this.time = time;
            return this;
        }

        public Builder copy(SoccerMatch soccerMatch) {
            this.matchId = soccerMatch.matchId;
            this.kitType = soccerMatch.kitType;
            this.opponent = soccerMatch.opponent;
            this.date = soccerMatch.date;
            this.time = soccerMatch.time;
            return this;
        }

        public SoccerMatch build() {
            return new SoccerMatch(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoccerMatch that = (SoccerMatch) o;
        return matchId.equals(that.matchId) && kitType.equals(that.kitType) && opponent.equals(that.opponent) && date.equals(that.date) && time.equals(that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchId, kitType, opponent, date, time);
    }
}
