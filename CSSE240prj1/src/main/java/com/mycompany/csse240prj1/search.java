/**
 * The "search" class allows the user to search for players based on different criteria such as name,
 * team, season, or position.
 */
package com.mycompany.csse240prj1;

import java.util.Scanner;
import java.util.Comparator;

public class search {
    // Array to store filtered players
    public LinkedList filter = new LinkedList();
    
    // Constructor
    public search(LinkedList list){
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
                searchName(list);
                break;
            //case for filter by Team
            case 't':
                searchTeam(list);
                break;
            //case for filter by Season
            case 's':
                searchSeason(list);
                break;
            //case for filter by Position
            case 'p':
                searchPosition(list);
                break;
            //if they gave a bad input then default will prompt them to try again from beginning in main
            default:
                System.out.println("Try Again");
                break;
        }
        System.out.println("RESULTS:");
        //if filter array has no items cut program and print no results
        if (this.filter.getLength() > 0){
            //print each player that matches searched criteria
            for (int i = 0; i < this.filter.getLength(); i++){
                System.out.println(this.filter.getNode(i).data.printPlayer());
            }
            System.out.println(this.filter.getLength() + " results");
        }
        else {
            System.out.println("no results...");
        }

    }

    // Search by Name
    private void searchName(LinkedList list){
        //declare and initialize pointer for new filter array
        int j = 0;
        //prompt user for name input
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the name you are searching for?");
        String input = scan.nextLine();
        //search given list for matching with input
        for (int i = 0; i < list.getLength(); i++){
            if (list.getNode(i).data.getName().equals(input)){
                //insert player into modified list of filtered results
                this.filter = LinkedList.insertPlayer(this.filter, list.getNode(i).data);
            }
        }
    } 
    
    // Search by Team
    private void searchTeam(LinkedList list){
        //declare and initialize pointer for new filter list
        int j = 0;
        //prompt user for Team input
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the Team you are searching for?");
        String input = scan.nextLine();
        //search given list for matching with input
        for (int i = 0; i < list.getLength(); i++){
            if (list.getNode(i).data.getTeam().equals(input)){
                this.filter = LinkedList.insertPlayer(this.filter, list.getNode(i).data);
            }
        }
    } 

    // Search by Season
    private void searchSeason(LinkedList list){
        int j = 0;
        //prompt user for Season input
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the Season you are searching for?");
        String input = scan.nextLine();
        for (int i = 0; i < list.getLength(); i++){
            if (list.getNode(i).data.getSeason().equals(input)){
                this.filter = LinkedList.insertPlayer(this.filter, list.getNode(i).data);
            }
        }
    } 

    // Search by Position
    private void searchPosition(LinkedList list){
        int j = 0;
        //prompt user for Position input
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the Position you are searching for?");
        int input = scan.nextInt();
        for (int i = 0; i < list.getLength(); i++){
            if (list.getNode(i).data.getPosition() == input){
                this.filter = LinkedList.insertPlayer(this.filter, list.getNode(i).data);
            }
        }
    } 
}
