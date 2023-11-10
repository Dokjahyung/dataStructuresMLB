package com.mycompany.csse240prj1;

//User needs to understand data since it would be to unclean in my opinion to make a messy print stat value
//this is up to debate but this seems easier to just offer the user a legend
class information{
    public information(){
        System.out.println("Statistics: WAR (Wins Above Replacement) | Batting Average (BA) | On Base Percentage (OBP) | Slugging Percentage (SLG) | Home Runs (HR) | Runs Batted In (RBI) | Stolen Bases (SB) |");
    }
    public static void inputInformationFormat(){
        System.out.println("WAR (Wins Above Replacement),Batting Average (BA),On Base Percentage (OBP),Slugging Percentage (SLG),Home Runs (HR),Runs Batted In (RBI),Stolen Bases (SB)");
        System.out.println("If you do not have a stat for a field shown above type in -1");
    }
}