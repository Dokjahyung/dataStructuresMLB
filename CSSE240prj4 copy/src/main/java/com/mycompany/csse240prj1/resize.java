package com.mycompany.csse240prj1;

import java.util.Scanner;

class resize {
    //Have come to realize that code needs this resizing for multiple modules so would be better to decouple from mlbArray. However, have yet to remove mlbArray version of this
    public static Player[] add(Player[] array, Player player){
            
        Player[] arrCopy = new Player[array.length + 1];
        
        //assign values to copy
        for (int i = 0; i < array.length; i++) {
            
            arrCopy[i] = array[i];
            
        }
        //need to be sure to include last element with desired added info
        arrCopy[arrCopy.length - 1] = player;
        
        array = arrCopy;
        return array;
    }
    public static Player[] delete(Player[] array, int delete) {
        //declare copy array
        Player arrCopy[];

        for (int i = 0; i < array.length; i++) {
            //if line wanted deleted found, copy elements from original array to new array up to said element
            if (i == delete - 1) {
                arrCopy = new Player[array.length - 1];
                //system.arraycopy takes 4 arguments (former array, starting position to copy, new array, new start of copy, length of elements)
                //this copies all elements up to line before deletion line
                System.arraycopy(array, 0, arrCopy, 0, i);
                //if arrcopy length - index (i) is = or greater than 0. copy this.array at position over deletion line  shifted back one to new array
                if (arrCopy.length - i >= 0) {
                    System.arraycopy(array, i + 1, arrCopy, i, arrCopy.length - i);
                    //store this new array beck into this.array
                    array = arrCopy;
                }
            }
        }
        return array;
    }
}