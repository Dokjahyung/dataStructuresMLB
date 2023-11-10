package com.mycompany.csse240prj1;
import java.lang.*;

import java.util.Scanner;

class Player{
    // name of player
    private String name;
	   // team name for respective player
		private String team;
	  // season player won MVP
	    private String season;
	  // numeric value 1-9 for position that player plays
	    private int position;
	    
        private LinkedList stats = new LinkedList();

        public Player(String name, String team, String season, int position){
          setName(name);
          setTeam(team);
          setSeason(season);
          setPosition(position);
        }
        public void setName(String name){
            if (validateTeam(name) == true){
                this.name = name;
            }
        }
        /*setTeam does not need an advanced validate class since it will ultimately be a string.
        You never know if a player's name is really that long
        */
        public boolean validateName(String name){
            Scanner scan = new Scanner(System.in);
            //fancy way of testing if team is a String 
            if (name instanceof String) {
                return true;
            }
            else{
                System.out.println("Unfortunately that is not a String. Please type in the player's name.");
                String finalName = scan.nextLine();
                validateTeam(finalName);
                return false;
            }
        }
        public String getName(){
            return this.name;
        }
        public void setTeam(String team){
            if (validateTeam(team) == true){
                this.team = team;
            }
        }
        /*setTeam does not need an advanced validate class since it will ultimately be a string.
        You never know if a player's name is really that long
        */
        public boolean validateTeam(String team){
            Scanner scan = new Scanner(System.in);
            //fancy way of testing if team is a String 
            if (team instanceof String) {
                return true;
            }
            else{
                System.out.println("Unfortunately that is not a String. Please type in the player's name.");
                String finalTeam = scan.nextLine();
                validateTeam(finalTeam);
                return false;
            }
        }
        public String getTeam(){
            return this.team;
        }

        public void setSeason(String season){
            if (validateSeason(season) == true){
                this.season = season;
            }
            else{
                System.out.println("this is not a ");
            }
        }
        public boolean validateSeason(String season){
          //call error method to make regex and conditional tests for acceptable inputs for season
            return true;
        }
        public String getSeason(){
          return this.season;
        }

        public void setPosition(int position){
            if (validatePosition(position) == true){
                this.position = position;
            }
        }
        /*setTeam does not need an advanced validate class since it will ultimately be a string.
        You never know if a player's name is really that long
        */
        public boolean validatePosition(int position){
            Scanner scan = new Scanner(System.in);
            //fancy way of testing if team is a String 
            if(position > 0 && position < 10){
              return true;
            }
            else{
              System.out.println("Unfortunately this is NaN please retype and eligible integer for player position");
              int finalPosition = scan.nextInt();
              setPosition(finalPosition);
              return false;
            }
        }
        public int getPosition(){
            return this.position;
        }
        /*WAR, batting average, On Base Percentage, Slugging Percentage, HR, RBI, Stolen Bases */
        public void setStats(String WAR, String battAve, String base, String slug, String HR, String RBI, String steal){
            LinkedList.insertStat(this.stats, WAR);
            LinkedList.insertStat(this.stats, battAve);
            LinkedList.insertStat(this.stats, base);
            LinkedList.insertStat(this.stats, slug);
            LinkedList.insertStat(this.stats, HR);
            LinkedList.insertStat(this.stats, RBI);
            LinkedList.insertStat(this.stats, steal);
        }
        public LinkedList getStats(){
            return this.stats;
        }
        public void printPlayer(){
          System.out.print("Player Name: " + this.getName() + " Team Name: " + this.getTeam() + " Season: " + this.getSeason() + " Position: " + this.getPosition() + " Statistics: ");
          printPlayerStat();
          System.out.println();
        }
        public void printPlayerStat(){
            LinkedList.printStats(stats);
        }
}
