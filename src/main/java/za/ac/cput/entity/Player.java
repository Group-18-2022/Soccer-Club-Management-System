/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18

Component:
This is the Player class. It is composed of the PersonalDetails class
and other soccer player-specific attributes.
 */

package za.ac.cput.entity;

public class Player
{
    private int fieldPosition;
    private int jerseyNumber;
    private String teamId;
    PersonalDetails personalDetails;

    private Player(Builder builder)
    {
        this.fieldPosition = builder.fieldPosition;
        this.jerseyNumber = builder.jerseyNumber;
        this.teamId = builder.teamId;
    }

    @Override
    public String toString() {
        return "Player{" +
                "fieldPosition=" + fieldPosition +
                ", jerseyNumber=" + jerseyNumber +
                ", teamId='" + teamId + '\'' +
                '}';
    }


    public static class Builder
    {
        private int fieldPosition;
        private int jerseyNumber;
        private String teamId;
        PersonalDetails personalDetails;

        public Builder setFieldPosition(int fieldPosition) {
            this.fieldPosition = fieldPosition;
            return this;
        }

        public Builder setJerseyNumber(int jerseyNumber) {
            this.jerseyNumber = jerseyNumber;
            return this;
        }

        public Builder setTeamId(String teamId) {
            this.teamId = teamId;
            return this;
        }

        public Builder setPersonalDetails(PersonalDetails personalDetails) {
            this.personalDetails = personalDetails;
            return this;
        }

        public Player build()
        {
            return new Player(this);
        }
    }
}
