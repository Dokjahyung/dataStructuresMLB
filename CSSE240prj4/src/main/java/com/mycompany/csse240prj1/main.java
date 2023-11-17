/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csse240prj1;

import java.util.Scanner;

/**
 *
 * @author gsirv
 */
public class main {
        public static void main(String[] args) {
        //declare scanner instance variable
        Scanner scan = new Scanner(System.in);
        //declare condition for while loop on interface
        int stop = 0;
        
        //declare instance of mlbConstruct to call needed methods from this class as well as LinkedList
        mlbConstruct mlbListConstruct = new mlbConstruct();
        LinkedList mlbList= mlbListConstruct.mlbCreateList();
        System.out.println("explanation of statistics format below");
        new information();
        
        //create interface that infinitely loops as long as user wants
        while (stop == 0) {
            /*specified options w/ user input needed
            UI should include options for add, delete, show, sort, search, and finish.*/
            System.out.println();
            System.out.println("Welcome to the MLB STAT reader, please choose an operation");
            System.out.println("a = add | d = delete | p = print | s = sort | q = query/search | f = finish");
            char stage = scan.next().charAt(0);
            //switch case for each option
            switch (stage) {
                //calls addition method from LinkedList with following info
                case 'a':
                scan.nextLine();
                    //prompt user to input desired info to be added
                    System.out.println("What is the name of the player?");
                    //need to use nextLine to allow whole name to be included in input
                    String mlbName = scan.nextLine();

                    System.out.println("What is the player's team?");
                    String mlbTeam = scan.nextLine();

                    System.out.println("What season did this player play?");
                    String mlbSeason = scan.next();

                    System.out.println("What is the player's position?");
                    int mlbPosition = scan.nextInt();

                    //call add method
                    Player mlbPlayer = new Player(mlbName, mlbTeam, mlbSeason, mlbPosition);
                    //mlbPlayer.setStats(null, null, null, null, null, null, null);
                    mlbList = LinkedList.insertPlayer(mlbList, mlbPlayer);


                    System.out.println("Will you be adding any stats to the player?");
                    System.out.println("y = yes | n = no");
                    String[] tempArray = new String[7];
                    if (scan.next().charAt(0) == 'y'){
                        scan.nextLine();
                        System.out.println("Please type in the your player statistics with the following format.");
                        information.inputInformationFormat();
                        String line = scan.nextLine();
                        tempArray = line.split(",");
                        mlbPlayer.setStats(tempArray[0], tempArray[1], tempArray[2], tempArray[3], tempArray[4], tempArray[5], tempArray[6]);
                    }
                    else {
                        mlbPlayer.setStats("-1","-1","-1","-1","a-1","-1","-1");
                    }
                    LinkedList.printList(mlbList);
                    break;
                    //calls delete method from LinkedList class w/ following info
                case 'd':
                    // prompt user to input specific line they want to delete and then call delete method for made array
                    System.out.println("Which line would you like to delete?");
                    int del = scan.nextInt();
                    mlbList = LinkedList.deletePlayer(mlbList, del);
                    break;
                case 'p':
                    //allow an option for created list to be shown multiple times for user as needed
                     LinkedList.printList(mlbList);
                     break;
                case 's':
                    //call the list sort method in mlbArray class
                    sort sort = new sort();
                    LinkedList.printList(sort.listSort(mlbList));
                    break;
                case 'q':
                    //call the list search method in mlbArray
                    search search = new search(mlbList);
                    break;
                case 'f':
                    //finish program and call method for saving array back to file
                    
                    mlbListConstruct.lines = mlbList;
                    mlbListConstruct.mlbFinish();
                    //change loop condition to end program
                    stop = 1;
                    break;
                default:
                    
                    System.out.println("Try Again");
                    
                    break;
            }
        }
        scan.close();

    }
}
