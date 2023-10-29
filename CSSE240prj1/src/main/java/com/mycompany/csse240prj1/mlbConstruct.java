/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csse240prj1;

//Test
//Import all needed libraries for scanning, read/write files, and throwing exceptions
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author gsirv
 */
//creat project
public class mlbConstruct {
    //need to declare private field for our names array
    private LinkedList lines = new LinkedList();

    // make a basic constructor class for main method to call different methods of class and read original txt file
    public LinkedList mlbCreateList() {
        
        String filePath = "mlbNames.txt"; // Replace with the actual file path

        try {
            // Open the file for reading
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            // Read each line from the file and add it to the ArrayList
            // Initialize the lines array dynamically based on the number of lines in the file
            int lineCount = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
            }

            // Reset the reader to the beginning of the file
            reader.close();
            reader = new BufferedReader(new FileReader(filePath));

            // Read each line from the file and add it to the array
            for (int i = 0; i < lineCount; i++) {
                line = reader.readLine();
                String[] tempArray = new String[4];
                tempArray = line.split(", ");
                Player player = new Player(tempArray[0], tempArray[1], tempArray[2], Integer.parseInt(tempArray[3]));
                LinkedList.insert(lines, player);
            }
            // Close the file
            reader.close();
            //catch errors
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
        }

        LinkedList.printList(lines);
        return lines;
        
    }
    /*
    NB NEW DELETE METHOD

        public void deletePlayer(int index) {
        if (index < 0 || index >= LinkedList.getLength(lines)) {
            System.out.println("Invalid index. Player not found in the list.");
            return;
        }

        if (index == 0) {
            // If the player to delete is the head of the list
            lines.head = lines.head.next;
        } else {
            Node current = lines.head;
            int currentIndex = 0;
            while (currentIndex < index - 1) {
                current = current.next;
                currentIndex++;
            }

            if (current.next != null) {
                current.next = current.next.next;
            }
        }
        System.out.println("Player at index " + index + " has been deleted.");
    }


    */

    /* 
    //create delete method that will also resize aray for optimal storage overtime
    public void delete(int delete) {
        //declare copy array
        Player arrCopy[];

        for (int i = 0; i < lines.length; i++) {
            //if line wanted deleted found, copy elements from original array to new array up to said element
            if (i == delete - 1) {
                arrCopy = new Player[lines.length - 1];
                //system.arraycopy takes 4 arguments (former array, starting position to copy, new array, new start of copy, length of elements)
                //this copies all elements up to line before deletion line
                System.arraycopy(this.lines, 0, arrCopy, 0, i);
                //if arrcopy length - index (i) is = or greater than 0. copy this.array at position over deletion line  shifted back one to new array
                if (arrCopy.length - i >= 0) {
                    System.arraycopy(this.lines, i + 1, arrCopy, i, arrCopy.length - i);
                    //store this new array beck into this.array
                    this.lines = arrCopy;
                }
            }
        }
            //show user modified data *had issue with including in for loop*
            printArray();
    }

    //this is the method that will both istantiate an instance from sort class and start the sort script for dataset
    public void arraySort(){
        //the arguments here will be passed to sort class and will assume 0 is the lowest index of the list for this case
        //sort arraySort = new sort(lines, 0, this.lines.length-1);
    }
    //method will instantiate array search and pass lines array for later use
    public void arraySearch(){
        search arraySearch = new search(lines);
    }
    //create method to save array to text file via filewriter
    public void mlbFinish() {
        try {
            //bufffered filewriter
            FileWriter fw = new FileWriter("mlbNames.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            //each element gets it's own line when being re written
            for (int i = 0; i < this.lines.length; i++) {
                bw.write(this.lines[i].getName() + ", " + this.lines[i].getTeam() + ", " + this.lines[i].getSeason() + ", " + this.lines[i].getPosition());
                bw.newLine();
            }
            //close buffered writer
            bw.close();
            //print for user that program is finished
            System.out.println("Collection successful...");
            System.out.println("rewriting text file");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    */
}
