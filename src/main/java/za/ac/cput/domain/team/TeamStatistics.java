/**
 * TeamStatistics.java
 * This is the TeamStatistics entity
 * @author Mike Somelezo Tyolani (220187568)
 * 04 April 2022
 */
package za.ac.cput.domain.team;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TeamStatistics {
    //Team statistics attributes
    @Id @NotNull
    private String teamId;
    @NotNull
    private String  trophiesWon;
    @NotNull
    private String matchesPlayed;

    //private constructor
    private TeamStatistics (Builder builder){
        this.teamId = builder.teamId;
        this.trophiesWon = builder.trophiesWon;
        this.matchesPlayed = builder.matchesPlayed;
    }

    protected TeamStatistics () {}

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

        public Builder setTeamId(String teamId) {
            this.teamId = teamId;
            return this;
        }

        public Builder setTrophiesWon(String trophiesWon) {
            this.trophiesWon = trophiesWon;
            return this;
        }

        public Builder setMatchesPlayed(String matchesPlayed) {
            this.matchesPlayed = matchesPlayed;
            return this;
        }

        public Builder copy(TeamStatistics teamStatistics) {
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
