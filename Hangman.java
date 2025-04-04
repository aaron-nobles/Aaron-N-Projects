////////////////////////////////////////////////////////////////
//
// Name: Aaron Nobles
//
// Date: 1/2/23
//
// Program's Purpose: Play a game of hangman and where the user tries to guess the word
//                    by each letter before they run out of their 7 guesses
//
// Inputs: Letter guess
//
// Outputs: Guesses made, 
//          Secret word as it's filled in with  correct guesses,
//          If user wins or loses
//
////////////////////////////////////////////////////////////////

import javax.swing.JOptionPane;

public class Hangman {

   public static void main(String args[]) {
      //decleration statements
      final String SECRET_WORD = "reference";   //Word the user has to guess
      
      final int TOTAL_GUESSES = 7;  //Total # of guesses player has
      
      String allGuesses,   //Collection of the guesses made by player so far
             input;        //Temporary placeholder
      
      StringBuffer displayWord;  //Word progress displayed to user
      
      char letterGuess;    //Individual guess by user
      
      int incorrectGuesses,    //Number of incorrect guesses used
          totalGuesses,        //Number of total guesses
          index;               //Index variable for loops
          
      boolean endGame,     //Checks if game is finished
              validGuess,  //Checks if guess is valid
              validCheck2,
              correct;     //Checks if player was correct with guess
      //executable statements
      endGame = false;
      incorrectGuesses = 0;
      displayWord = new StringBuffer ("");
      allGuesses = " ";
      letterGuess = ' ';
      totalGuesses = 0;
      for (index = 0; index < SECRET_WORD.length(); index++)
         displayWord.append("-");
      System.out.println("Lets play Hangman! Try to guess the word before using up all " + TOTAL_GUESSES + " guesses.");
      while (endGame == false) {
         validGuess = false;
         correct = false;
         System.out.println("The word is: " + displayWord);
         System.out.println("You have guessed letters" + allGuesses);
         System.out.println("You have used up " + incorrectGuesses + " incorrect guesses so far");
         while (validGuess == false) {
            input = JOptionPane.showInputDialog(null,
                    "Please guess a letter",
                    "Hangman Game",
                    JOptionPane.QUESTION_MESSAGE);
            letterGuess = input.charAt(0);
            validCheck2 = true;
            for (index = 0; index < allGuesses.length(); index++) {
               if (letterGuess == allGuesses.charAt(index)) {
                  validCheck2 = false;
               }
            }
            if (validCheck2 == true) {
               allGuesses += letterGuess;
               validGuess = true;
            }
            else
               System.out.println("You already guessed the letter " + letterGuess + "!");
         }
         for (index = 0; index < SECRET_WORD.length(); index++) {
            if (letterGuess == SECRET_WORD.charAt(index)) {
               displayWord.setCharAt(index,letterGuess);
               correct = true;
            }
         }
         if (letterGuess == '$') {
            System.out.println("Quitting already? The secret word was: " + SECRET_WORD);
            System.out.println("Letters used: " + allGuesses);
            endGame = true;
         }   
         else if (correct == false)
            incorrectGuesses++;
         if (SECRET_WORD.equals(new String(displayWord)) == true) {
            endGame = true;
            System.out.println("You won! You correctly guessed the word: " + SECRET_WORD);
            System.out.println("Letters used: " + allGuesses);
         }
         else if (displayWord.equals(SECRET_WORD) == false && incorrectGuesses == 7) {
            endGame = true;
            System.out.println("You lost! The word was: " + SECRET_WORD);
            System.out.println("Letters used: " + allGuesses);
         }
      }
      System.out.println("All done for now");
      System.exit(0);
   } // end main method
   
} // end the class