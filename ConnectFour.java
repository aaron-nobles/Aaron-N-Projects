////////////////////////////////////////////////////////////////
//
// Name: Aaron Nobles
//
// Date: 2/23/22
//
// Program's Purpose: Inistialize all the methods to run the game of Connect four
//
// Inputs: None
//
// Outputs: None
//
////////////////////////////////////////////////////////////////

import javax.swing.JOptionPane;

public class ConnectFour {
   final int MAX_ROWS = 6,    //Max number of rows in game
             MAX_COLUMNS = 7; //Max number of columns in game
   
   final char  EMPTY = ' ',
               YOU = 'Y',
               OPPONENT = 'O';
             
   private char slots[][]; ///Holds characters for each slot in game
   
   private boolean youWin,       //Boolean checking if you win the game
                   opponentWins; //Boolean checking if you lost the game
                   
   public ConnectFour() {
      int index,     //Counts for first loop with each row
          index2;    //Counts for second loop with each column
          
      slots = new char [MAX_ROWS][MAX_COLUMNS];
      
      for (index = 0; index < MAX_ROWS; index++) {
         for (index2 = 0; index2 < MAX_COLUMNS; index2++)
            slots[index][index2] = EMPTY;
      }
   }
   
   public void displayBoard() {
      int index,  //Counts for loop forming each row
          index2, //Counts for loop forming lines seperating rows
          index3, //Counts for loop forming lines seperating columns
          index4; //Counts for loop forming column numbers
          
      for (index4 = 1; index4 <= MAX_COLUMNS; index4++) {
            System.out.print("  " + index4 + " ");
            if (index4 == MAX_COLUMNS)
               System.out.print("\n");
      }
      for (index = 0; index < MAX_ROWS; index++) {
         for (index2 = 0; index2 < MAX_COLUMNS; index2++) {
            System.out.print("+---");
            if (index2 == MAX_COLUMNS - 1)
               System.out.print("+\n");
         }
         for (index3 = 0; index3 < MAX_COLUMNS; index3++) {
            System.out.print("| " + slots[index][index3] + " ");
            if (index3 == MAX_COLUMNS - 1)
               System.out.print("|\n");
         }
         if (index == MAX_ROWS - 1) {
            for (index2 = 0; index2 < MAX_COLUMNS; index2++) {
               System.out.print("+---");
            if (index2 == MAX_COLUMNS - 1)
               System.out.print("+\n");
            }
         }
      }
   }
   
   public boolean gameDone() {
      boolean finish;   //Checks if game is finished
      
      int index,           //Counts for first loop going through rows
          index2,          //Counts for second loop going through columns
          index3,          //Counts for third loop checking for a math of ConnectFour
          full,            //Checks if board is full to determine if there's a tie
          countRight,      //Counts pieces right of found piece to search for mathches
          countDown,       //Counts pieces down of found piece to search for mathches
          countDiagUp,     //Counts pieces up diagonally of found piece to search for mathches
          countDiagDown;   //Counts pieces down diagonally of found piece to search for mathches
      
      finish = false;
      full = 0;
      
      for (index = 0; index < MAX_ROWS; index++) {
         for (index2 = 0; index2 < MAX_COLUMNS; index2++) {
            if (slots[index][index2] == YOU) {
               countRight = 1;
               countDown = 1;
               countDiagUp = 1;
               countDiagDown = 1;
               for (index3 = 1; index3 <= 4; index3++) {
                  if (index2 + index3 < MAX_COLUMNS) {
                     if (slots[index][index2 + index3] == YOU)
                        countRight++;
                     if (index + index3 < MAX_ROWS) {
                        if (slots[index + index3][index2] == YOU)
                           countDown++;
                        if (slots[index + index3][index2 + index3] == YOU)
                           countDiagDown++;
                     }
                     if (index - index3 >= 0) {
                        if (slots[index - index3][index2 + index3] == YOU)
                           countDiagUp++;
                     }
                  }
               }
               if (countRight == 4 || countDown == 4 || countDiagUp == 4 || countDiagDown == 4) {
                  finish = true;
                  youWin = true;
               }   
            }
            if (slots[index][index2] == OPPONENT) {
               countRight = 1;
               countDown = 1;
               countDiagUp = 1;
               countDiagDown = 1;
               for (index3 = 1; index3 <= 4; index3++) {
                  if (index2 + index3 < MAX_COLUMNS) {
                     if (slots[index][index2 +index3] == OPPONENT)
                        countRight++;
                     if (index + index3 < MAX_ROWS) {
                        if (slots[index + index3][index2] == OPPONENT)
                           countDown++;
                        if (slots[index + index3][index2 + index3] == OPPONENT)
                           countDiagDown++;
                     }
                     if (index - index3 >= 0) {
                        if (slots[index - index3][index2 + index3] == YOU)
                           countDiagUp++;  
                     }                
                  }
               }
               if (countRight == 4 || countDown == 4 || countDiagUp == 4 || countDiagDown == 4) {
                  finish = true;
                  opponentWins = true;
               }   
            }
         }
      }
      for (index = 0; index < MAX_ROWS; index++) {
         for (index2 = 0; index2 < MAX_COLUMNS; index2++) {
            if (slots[index][index2] != EMPTY)
               full++;
         }
      }
      if (full == MAX_ROWS * MAX_COLUMNS && finish != true)
         finish = true;
      return finish;
   }
   
   public boolean addToColumn(int column, boolean turn) {
      int index;  //Counts variable for loop
      
      boolean valid; //Determines if move is valid
      
      valid = false;
      
      if (column >= 0 && column <= MAX_COLUMNS - 1) {
         for (index = MAX_ROWS - 1; index >= 0; index--) {
            if (slots[index][column] == EMPTY && valid == false) {
               if (turn == true) {
                  slots[index][column] = YOU;
                  valid = true;
               }
               else {
                  slots[index][column] = OPPONENT;
                  valid = true;
               }
            }
         }
      } 
      
      return valid; 
   }
   
   public boolean getYouWin() {
      return youWin;
   }
   
   public boolean getOpponentWins() {
      return opponentWins;
   }
} // end the class