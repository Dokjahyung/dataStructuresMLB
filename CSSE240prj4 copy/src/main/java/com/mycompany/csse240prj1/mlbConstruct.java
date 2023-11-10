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
    public LinkedList lines = new LinkedList();

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
                String[] tempArray = new String[11];
                tempArray = line.split(",");
                Player player = new Player(tempArray[0], tempArray[1], tempArray[2], Integer.parseInt(tempArray[3]));
                player.setStats(tempArray[4], tempArray[5], tempArray[6], tempArray[7], tempArray[8], tempArray[9], tempArray[10]);
                LinkedList.insertPlayer(lines, player);
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
    //create method to save array to text file via filewriter
    public void mlbFinish() {
        try {
            //bufffered filewriter
            FileWriter fw = new FileWriter("mlbNames.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            //each element gets it's own line when being re written
            for (int i = 0; i < this.lines.getLength(); i++) {
                bw.write(this.lines.getNode(i).data.getName() + "," + this.lines.getNode(i).data.getTeam() + "," + this.lines.getNode(i).data.getSeason() + "," + this.lines.getNode(i).data.getPosition() + this.lines.getNode(i).data.getStats().getStat());
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
}
