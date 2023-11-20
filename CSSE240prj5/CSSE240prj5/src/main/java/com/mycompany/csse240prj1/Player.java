package com.mycompany.csse240prj1;
import java.lang.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Player{
    // name of player
    private String name;
	   // team name for respective player
		private String team;
	  // season player won MVP
	    private String season;
	  // numeric value 1-9 for position that player plays
	    private int position;
        //	stats linked list to store  
        /*WAR, batting average, On Base Percentage, Slugging Percentage, HR, RBI, Stolen Bases */  
        private stack stats = new stack();

        //constructor of player that takes all the way to position argument
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
        //Used chatGPT to force checks on input with regex expressions
        // must match format (SSS: 123)
        public void setStats(String[] array){
            for (String stat : array){
                //push Node if matches regex
                if (validateStat(stat)){
                    this.stats.push(new Node(stat));
                }
            }
        }
        public LinkedList getStats(){
            return this.stats.stack;
        }
        //checks on regex used to fit the 3 char: and then whatever stat after
        public Boolean validateStat(String stat){
            Scanner scan = new Scanner(System.in);
            Pattern regex = Pattern.compile("\\w{1,3}:.+");
            Matcher matcher = regex.matcher(stat);
            if (matcher.matches()){
                return true;
            }
            else{
                //if it doesn't match go recursive and let user re input. this goes for saved data too obviously
                System.out.println(stat + " is not a valid stat entry make sure to follow format");
                System.out.println("Format: SSS: 123");
                String input = scan.nextLine();
                validateStat(input);
            }
            return false;
        }
        public void printPlayer(){
            System.out.println("Player Name: " + this.getName() + " Team Name: " + this.getTeam() + " Season: " + this.getSeason() + " Position: " + this.getPosition());
            System.out.print("              Statistics: ");
            printPlayerStat();
            System.out.println();
            System.out.println();
        }
        public void printPlayerStat(){
            LinkedList.printStats(stats.stack);
        }
}
