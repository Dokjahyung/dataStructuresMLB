/**
 * The "search" class allows the user to search for players based on different criteria such as name,
 * team, season, or position.
 */
package com.mycompany.csse240prj1;

import java.util.Scanner;
import java.util.Comparator;

public class search {
    // Array to store filtered players
    private Player[] filter = new Player[0];
    
    // Constructor
    public search(Player[] array){
        //Establish scanner and prompt user through UI for input on search criteria
        Scanner scan = new Scanner(System.in);
        System.out.println("How would you like to search for your player by?");
        System.out.println("n = name | t = team | s = season | p = position");
        char type = scan.next().charAt(0);
        //use different methods for each type of search input: name, team, season, position
        //will work on making this more abstract

        switch (type){
            //case for filter by Name
            case 'n':
                searchName(array);
                break;
            //case for filter by Team
            case 't':
                searchTeam(array);
                break;
            //case for filter by Season
            case 's':
                searchSeason(array);
                break;
            //case for filter by Position
            case 'p':
                searchPosition(array);
                break;
            //if they gave a bad input then default will prompt them to try again from beginning in main
            default:
                System.out.println("Try Again");
                break;
        }
        System.out.println("RESULTS:");
        //if filter array has no items cut program and print no results
        if (this.filter.length > 0){
            //print each player that matches searched criteria
            for (int i = 0; i < this.filter.length; i++){
                System.out.println(this.filter[i].printPlayer());
            }
            System.out.println(this.filter.length + " results");
        }
        else {
            System.out.println("no results...");
        }

    }

    // Search by Name
    private void searchName(Player[] array){
        //declare and initialize pointer for new filter array
        int j = 0;
        //prompt user for name input
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the name you are searching for?");
        String input = scan.nextLine();
        //search given array for matching with input
        for (int i = 0; i < array.length; i++){
            if (array[i].getName().equals(input)){
                //call resize array and add element if matches searched name equals stored name
                this.filter = resize.add(this.filter, array[i]);
            }
        }
    } 
    
    // Search by Team
    private Player[] searchTeam(Player[] array){
        int j = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the team you are searching for?");
        String input = scan.nextLine();
        for (int i = 0; i < array.length; i++){
            if (array[i].getTeam().equals(input)){
                this.filter = resize.add(this.filter, array[i]);
            }
        }
        return filter;
    }

    // Search by Season
    private Player[] searchSeason(Player[] array){
        int j = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the value you are searching with?");
        String input = scan.nextLine();
            for (int i = 0; i < array.length; i++){
                if (array[i].getSeason().equals(input)){
                    this.filter = resize.add(this.filter, array[i]);
                }
            }
            return filter;
    }

    // Search by Position
    private Player[] searchPosition(Player[] array){
        int j = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the value you are searching with?");
        int input = scan.nextInt();
        for (int i = 0; i < array.length; i++){
            if (array[i].getPosition() ==  input){
                this.filter = resize.add(this.filter, array[i]);
            }
        }
        return filter;
    }
}
