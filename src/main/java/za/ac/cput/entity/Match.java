package za.ac.cput.entity;

/*
 * Karl Haupt (220236585)
 * Match.java -> is an entity in the problem domain to store the various match(s) that team(s) would or have played.
 */

public class Match {
    private int matchId;
    private String kitType;
    private String opponent;
    private String date;
    private String time;

    private Match(Builder builder) {
        this.kitType = builder.kitType;
        this.opponent = builder.opponent;
        this.date = builder.date;
        this.time = builder.time;
    }

    public int getMatchId() {
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
        return "Match{" +
                "matchId=" + matchId +
                ", kitType='" + kitType + '\'' +
                ", opponent='" + opponent + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public static class Builder {
        private int matchId;
        private String kitType;
        private String opponent;
        private String date;
        private String time;

        public Builder setMatchId(int matchId) {
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

        public Builder copy(Match match) {
            this.matchId = match.matchId;
            this.kitType = match.kitType;
            this.opponent = match.opponent;
            this.date = match.date;
            this.time = match.time;
            return this;
        }

        public Match build() {
            return new Match(this);
        }
    }
}
