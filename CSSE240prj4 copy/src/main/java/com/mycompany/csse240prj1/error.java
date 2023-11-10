package com.mycompany.csse240prj1;

import java.util.Scanner;
// use regex to determine if input is valid season
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class error{
  // error checking given my stackoverflow: https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
  //want to make my own static classes that will check for errors in code
    public static boolean isDouble(String str) { 
        try {  
          Double.parseDouble(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
      }
    public static boolean isInteger(String str) { 
        try {  
          Integer.parseInt(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
      }
      
      /*public static boolean isDate(String date){
        if (date.matches("\\d+")){
          return true;
        }
        System.out.println("This is not a valid year for season. Please try again.");
        return false;
      }
      */
}