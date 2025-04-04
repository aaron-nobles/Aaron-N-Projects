////////////////////////////////////////////////////////////////
//
// Name: Aaron Nobles
//
// Date: 2/25/22
//
// Program's Purpose: Run the methods to play a game of ConnectFour
//
// Inputs:  Choice of column
//
// Outputs: Board displayed after each move and end result of if you win or lose
//
////////////////////////////////////////////////////////////////

import javax.swing.JOptionPane;

public class UseConnectFour {

   public static void main(String args[]) {
      //decleration statements
      ConnectFour slots;   //Holds all slots for ConnectFour board
      
      int columnChoice;    //User choice for column to place piece in
      
      String input;        //Temporary placeholder
      
      boolean yourTurn,    //Is true if it's your turn, false if opponents
              valid;       //True for valid columnChoice input
              
      //executable statements
      slots = new ConnectFour();
      yourTurn = true;
      valid = false;
      columnChoice = 0;
      
      while (slots.gameDone() == false) {
         slots.displayBoard();
         valid = false;
         if (yourTurn == true) {
            while (valid == false) {
               input = JOptionPane.showInputDialog(null,
                        "Pick which column you'd like to insert a piece.",
                        "Connect Four",
                        JOptionPane.QUESTION_MESSAGE);
               
               columnChoice = Integer.parseInt(input);
               
               if (columnChoice >= 1 && columnChoice <= 7)
                  valid = true;
               else
                  JOptionPane.showMessageDialog(null,
                     "Please enter a valid input.",
                     "Connect Four",
                     JOptionPane.PLAIN_MESSAGE);
            }
            slots.addToColumn(columnChoice - 1,yourTurn);
            yourTurn = false;
         }
         else {
            while (valid == false) {
               input = JOptionPane.showInputDialog(null,
                        "Which column will your opponent insert a piece.",
                        "Connect Four",
                        JOptionPane.QUESTION_MESSAGE);
               
               columnChoice = Integer.parseInt(input);
               
               if (columnChoice >= 1 && columnChoice <= 7)
                  valid = true;
               else
                  JOptionPane.showMessageDialog(null,
                     "Please enter a valid input.",
                     "Connect Four",
                     JOptionPane.PLAIN_MESSAGE);
            }
            slots.addToColumn(columnChoice - 1,yourTurn);
            yourTurn = true;
         }
         
         slots.gameDone();
         if (slots.getYouWin() == true) {
            slots.displayBoard();
            System.out.println("You've connected four pieces and won the game!");
         }
         else if (slots.getOpponentWins() == true) {
            slots.displayBoard();
            System.out.println("Your opponent connected four pieces and won the game!");
         }
         else if (slots.gameDone() == true && slots.getOpponentWins() != true && slots.getOpponentWins() != true) {
            slots.displayBoard();
            System.out.println("You tied, there was no winner.");
         }
      }
      
      System.out.println("All done for now");
      System.exit(0);
   } // end main method
   
} // end the class