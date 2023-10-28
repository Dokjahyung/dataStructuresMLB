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
        
        //declare instance of mlbArray to call needed methods from this class
        mlbConstruct mlbListConstruct = new mlbConstruct();
        LinkedList mlbList= mlbListConstruct.mlbCreateList();
        
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
                //calls addition method from mlbArray with following info
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
                    LinkedList.insert(mlbList, mlbPlayer);
                    LinkedList.printList(mlbList);
                    break;
                    //calls delete method from mlbArray class w/ following info
                case 'd':
                    // prompt user to input specific line they want to delete and then call delete method for made array
                    System.out.println("Which line would you like to delete?");
                    int del = scan.nextInt();
                    mlbList = LinkedList.delete(mlbList, del);
                    break;
                case 'p':
                    //allow an option for created array to be shown multiple times for user as needed
                     LinkedList.printList(mlbList);
                     break;
                case 's':
                    //call the array sort method in mlbArray class
                    //mlbA.arraySort();
                    break;
                case 'q':
                    //call the array search method in mlbArray
                    //mlbArrays.arraySearch();
                    break;
                case 'f':
                    //finish program and call method for saving array back to file
                    
                    //mlbArrays.mlbFinish();
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
