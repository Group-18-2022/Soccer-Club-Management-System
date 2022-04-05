package za.ac.cput.entity;

public class TeamStatistics {
    //Team statistics attributes
    private String teamId;
    private String  trophiesWon;
    private String matchesPlayed;

    //private constructor
    private TeamStatistics (TeamStatistics.Builder builder){
        this.teamId = builder.teamId;
        this.trophiesWon = builder.trophiesWon;
        this.matchesPlayed = builder.matchesPlayed;
    }

    //Getters

    public String getTeamId() {
        return teamId;
    }


    public String getTrophiesWon() {
        return trophiesWon;
    }

    public String getMatchesPlayed() {
        return matchesPlayed;
    }

    @Override
    public String toString() {
        return "TeamStatistics{" +
                "teamId='" + teamId + '\'' +
                ", trophiesWon='" + trophiesWon + '\'' +
                ", matchesPlayed='" + matchesPlayed + '\'' +
                '}';
    }
    //Builder

    public static class Builder {
        private String teamId;
        private String trophiesWon;
        private String matchesPlayed;

        public TeamStatistics.Builder setTeamId(String teamId) {
            this.teamId = teamId;
            return this;
        }

        public TeamStatistics.Builder setTrophiesWon(String trophiesWon) {
            this.trophiesWon = trophiesWon;
            return this;
        }

        public TeamStatistics.Builder setMatchesPlayed(String matchesPlayed) {
            this.matchesPlayed = matchesPlayed;
            return this;
        }

        public TeamStatistics.Builder copy(TeamStatistics teamStatistics) {
            this.teamId = teamStatistics.teamId;
            this.trophiesWon = teamStatistics.trophiesWon;
            this.matchesPlayed = teamStatistics.matchesPlayed;
            return this;
        }

        public TeamStatistics build() {
            return new TeamStatistics(this); // anonymous object
        }

    }
}
