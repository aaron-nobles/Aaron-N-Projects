////////////////////////////////////////////////////////////////
//
// Name: Aaron Nobles
//
// Date: 3/8/22
//
// Program's Purpose: Use various search methods to search through a two dimensional array and count how many comparisons are made along the way
//
// Inputs: Number user wants to search for
//
// Outputs: If the number was found or not and how many comparisons it took,
//          Row and column number search number was found on if found
//
////////////////////////////////////////////////////////////////

import javax.swing.JOptionPane;

public class UseTwoDimSearch {

   public static void main(String args[]) throws Exception{
      //decleration statements
      TwoDimSearch data;
      
      int search, //Number being searched for in array
          count,  //Number of successful searches
          count2, //Number of unsuccessful searches
          num;    //Goes through numbers 1 - 300 in last search loop
      
      double avg,    //Average for successful comparisons
             avg2;   //Average for unsuccessful comparisons
      
      boolean end,   //Checks for end of user input loops
              found; //Checks if number has been found
      
      String input;    
      //executable statements
      data = new TwoDimSearch();
      end = false;
      avg = 0;
      avg2 = 0;
      count = 0;
      count2 = 0;
      
      System.out.println("Row search \n");
      while (end == false) {
         input = JOptionPane.showInputDialog(null,
                 "What number would you like to search for? Enter a negative number to end.",
                 "Two Dimensional Search (By Rows)",
                 JOptionPane.QUESTION_MESSAGE);
         
         search = Integer.parseInt(input);
         found = false;
         if (search > 0) {
            data.basicSearch1(search);
            if (data.basicSearch1(search) == true) {
               System.out.println("The number " + search + " was found in row " + data.getRow() + ", column " + data.getColumn());
               System.out.println("It took " + data.getComparisons() + " comparisons before the number was found");
               count++;
               found = true;
            }
            else {
               System.out.println("The number " + search + " was not found");
               avg2 += data.getComparisons();
               count2++;
            }
         }
         else
            end = true;
         if (found == true)
            avg += data.getComparisons();
         if (end == true) {
            avg = avg / count;
            avg2 = avg2 / count2;
            System.out.println("The average number of comparisons for successful searches was " + avg);
            System.out.println("The average number of comparisons for unsuccessful searches was " + avg2 + "\n");
         
         }
      }
      
      end = false;
      avg = 0;
      avg2 = 0;
      count = 0;
      count2 = 0;
      
      System.out.println("Column search \n");
      while (end == false) {
         input = JOptionPane.showInputDialog(null,
                 "What number would you like to search for? Enter a negative number to end.",
                 "Two Dimensional Search (By Column)",
                 JOptionPane.QUESTION_MESSAGE);
         
         search = Integer.parseInt(input);
         found = false;
         if (search > 0) {
            data.basicSearch2(search);
            if (data.basicSearch2(search) == true) {
               System.out.println("The number " + search + " was found in row " + data.getRow() + ", column " + data.getColumn());
               System.out.println("It took " + data.getComparisons() + " comparisons before the number was found");
               count++;
               found = true;
            }
            else {
               System.out.println("The number " + search + " was not found");
               avg2 += data.getComparisons();
               count2++;
            }
         }
         else
            end = true;
         if (found == true)
            avg += data.getComparisons();
         if (end == true) {
            avg = avg / count;
            avg2 = avg2 / count2;
            System.out.println("The average number of comparisons for successful searches was " + avg);
            System.out.println("The average number of comparisons for unsuccessful searches was " + avg2 + "\n");
         }      
      }
      
      end = false;
      avg = 0;
      avg2 = 0;
      count = 0;
      count2 = 0;
      
      System.out.println("Improved search \n");
      while (end == false) {
         input = JOptionPane.showInputDialog(null,
                 "What number would you like to search for? Enter a negative number to end.",
                 "Two Dimensional Search (Improved)",
                 JOptionPane.QUESTION_MESSAGE);
         
         search = Integer.parseInt(input);
         found = false;
         if (search > 0) {
            data.improvedSearch(search);
            if (data.improvedSearch(search) == true) {
               System.out.println("The number " + search + " was found in row " + data.getRow() + ", column " + data.getColumn());
               System.out.println("It took " + data.getComparisons() + " comparisons before the number was found");
               count++;
               found = true;
            }
            else {
               System.out.println("The number " + search + " was not found");
               System.out.println("It took " + data.getComparisons() + " comparisons");
               avg2 += data.getComparisons();
               count2++;
            }         
         }
         else
            end = true;
         if (found == true)
            avg += data.getComparisons();
         if (end == true) {
            avg = avg / count;
            avg2 = avg2 / count2;
            System.out.println("The average number of comparisons for successful searches was " + avg);
            System.out.println("The average number of comparisons for unsuccessful searches was " + avg2 + "\n");
         }      
      }
      
      avg = 0;
      avg2 = 0;
      count = 0;
      count2 = 0;
      
      System.out.println("Numbers 1 - 300 search");
      for (num = 1; num <= 300; num++) {
         data.improvedSearch(num);
         if (data.improvedSearch(num) == true) {
            avg += data.getComparisons();
            count++;
         }
         else {
            avg2 += data.getComparisons();
            count2++;
         }     
      }
      avg = avg / count;
      avg2 = avg2 / count;
      System.out.println("The average number of comparisons for successful searches was " + avg);
      System.out.println("The average number of comparisons for unsuccessful searches was " + avg2);
      
      System.out.println("All done for now");
      System.exit(0);
   } // end main method
   
} // end the class