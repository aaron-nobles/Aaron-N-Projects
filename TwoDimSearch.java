////////////////////////////////////////////////////////////////
//
// Name: Aaron Nobles
//
// Date: 2/8/22
//
// Program's Purpose: 
//
//    TwoDimSearch: Intialize two dimensional array that holds numbers within data set
//
//    basicSearch1: Returns a boolean for if the number was found,
//                  Searches for number by going left to right through each row
//
//    basicSearch2: Returns a boolean for if the number was found,
//                  Searches for number by going from top to bottom through each column
//
//    improvedSearch: Returns a boolean for if the number was found,
//                    Custom means of improving search method
//
////////////////////////////////////////////////////////////////

import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.StringTokenizer;

public class TwoDimSearch {
      
   int numbers[][],  //Array that holds all numbers in the data set
       howMany,      //Size of the data set array
       lines,        //Number of lines in dat set
       intPerLine;   //Number of numbers in each line
       
   private int comparisons,   //Number of numbers checked
               rowFound,      //Row the number was found in
               columnFound;   //Column number was found in
       
   
   public TwoDimSearch () throws Exception {
   
      int index,  //Loop count variable 
          index2, //Loop count variable
          index3, //Loop count variable
          thisOne,// Holds the value to be searched for in numbers[]
          tokenCt;//Holds # of 'strings'/tokens on the 1st input line
                
      Scanner input; //object that holds selected file
      
      StringTokenizer tokens; //Object used to separate the Strings on the 1st line
      
      String   inputString,  //Text of selected file converted into a String
               temp;         //Next string extracted from the 1st input line.
                              
        JFileChooser fileChooser = new JFileChooser();

        if (fileChooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION){
            System.out.println("Could not find the file!");
            System.exit(-1);
        }

        java.io.File file = fileChooser.getSelectedFile();
        input = new Scanner(file);

        howMany = 0;
        inputString = input.nextLine();
        tokens = new StringTokenizer(inputString);
        tokenCt = tokens.countTokens();
        temp = tokens.nextToken();
        thisOne = Integer.parseInt(temp);
        lines = thisOne;
        temp = tokens.nextToken();
        thisOne = Integer.parseInt(temp);
        intPerLine = thisOne;

        numbers = new int [lines][intPerLine];
        index2 = 0;
        index3 = 0;
        
        while (input.hasNext()){
            inputString = input.nextLine();
            // process what is in the inputString!
            tokens = new StringTokenizer(inputString);
            tokenCt = tokens.countTokens();
            for (index = 0; index < tokenCt; index++) {
               temp = tokens.nextToken();
               thisOne = Integer.parseInt(temp);
               numbers[index2][index3] = thisOne;
               howMany++;
               if (index3 < intPerLine - 1)
                  index3++;
               else {
                  index3 = 0;
                  if (index2 < lines)
                     index2++;
               }
            }
        }
   }
   
   public boolean basicSearch1(int num) {
      //Search array row by row
      boolean found; //checks if number was found
      
      int index,  //Loop count variable
          index2; //Loop count variable
      
      found = false;
      index = 0;
      index2 = 0;
      comparisons = 0;
      
      while (index < lines && found == false) {
         while (index2 < intPerLine && found == false) {
            if (numbers[index][index2] == num)
               found = true;
            comparisons++;
            index2++;
         }
         index++;
         if (found == false)
            index2 = 0;
      }
      if (found == true) {
         rowFound = index;
         columnFound = index2;
      }
      return found;
   }
   
   public boolean basicSearch2(int num) {
      //Search array column by column
      boolean found; //checks if number was found
      
      int index,  //loop count variable
          index2; //loop count variable
          
      found = false;
      index = 0;
      index2 = 0;
      comparisons = 0;
      
      while (index < intPerLine && found == false) {
         while (index2 < lines && found == false) {
            if (numbers[index2][index] == num)
               found = true;
            comparisons++;
            index2++;
         }
         index++;
         if (found == false)
            index2 = 0;
      }
      if (found == true) {
         rowFound = index2;
         columnFound = index;
      }
      return found;
   }
   
   public boolean improvedSearch(int num) {
      boolean found,       //checks if number was found
              stopPoint;   //checks if there will be a new stop point for index2
      
      int index,     //loop count variable
          index2,    //loop count variable
          stop;      //new stop point if needed
          
      found = false;
      index = 0;
      index2 = 0;
      comparisons = 0;
      stop = 0;
      
      if (numbers[index][index2] > num) {
         comparisons = 1;
         return false;
      }
      while (index < lines && found == false) {
         stopPoint = false;
         comparisons++;
         if (numbers[index][intPerLine / 2] <= num)
            index2 = intPerLine / 2;
         else {
            stopPoint = true;
            stop = intPerLine / 2;
         }
         if (stopPoint == false) {
            while (index2 < intPerLine && found == false) {
               if (numbers[index][index2] == num)
                  found = true;
               comparisons++;
               index2++;
            }
         }
         else {
           while (index2 < stop && found == false) {
              if (numbers[index][index2] == num)
                 found = true;
              comparisons++;
              index2++;
            }
         }
         index++;
         if (found == false)
            index2 = 0;
      }
      if (found == true) {
         rowFound = index;
         columnFound = index2;
      }
      return found; 
   }
   
   public int getComparisons() {
      return comparisons;
   }
   
   public int getRow(){
      return rowFound;
   }
   
   public int getColumn(){
      return columnFound;
   }
} // end the class