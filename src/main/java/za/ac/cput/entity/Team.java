/**
 * Team.java
 * This is the Team entity
 * @author Mike Somelezo Tyolani (220187568)
 * 04 April 2022
 */

package za.ac.cput.entity;

public class Team {
    //team attributes
    private String teamId;
    private String teamName;
    private String numberOfPlayers;
    private String maxNumberOfPlayers;


    //private constructor
    private Team (Builder builder){
        this.teamId = builder.teamId;
        this.teamName = builder.teamName;
        this.numberOfPlayers = builder.numberOfPlayers;
        this.maxNumberOfPlayers = builder.maxNumberOfPlayers;
    }

    //Getters
    public String getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public String getMaxNumberOfPlayers() {return maxNumberOfPlayers;}


    @Override
    public String toString() {
        return "Team{" +
                "teamId='" + teamId + '\'' +
                ", teamName='" + teamName + '\'' +
                ", numberOfPlayers='" + numberOfPlayers + '\'' +
                ", maxNumberOfPlayers='" + maxNumberOfPlayers + '\'' +
                '}';
    }

    //Builder
    public static class Builder {
        private String teamId;
        private String teamName;
        private String numberOfPlayers;
        private String maxNumberOfPlayers;

        public Builder setTeamId(String teamId) {
            this.teamId = teamId;
            return this;
        }

        public Builder setTeamName(String teamName) {
            this.teamName = teamName;
            return this;
        }

        public Builder setNumberOfPlayers(String numberOfPlayers) {
            this.numberOfPlayers = numberOfPlayers;
            return this;
        }

        public Builder setMaxNumberOfPlayers(String maxNumberOfPlayers) {
            this.maxNumberOfPlayers = maxNumberOfPlayers;
            return this;
        }

        public Builder copy(Team team) {
            this.teamId = team.teamId;
            this.teamName = team.teamName;
            this.numberOfPlayers = team.numberOfPlayers;
            this.maxNumberOfPlayers = team.maxNumberOfPlayers;
            return this;
        }

        public Team build() {
            return new Team(this); // anonymous object
        }

    }



}
