package Hangman;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangmanCompute {

	Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    
    String guesses[] = {"monkey", "hippopocampus", "rhinoceros", "elephant",
                        "tiger", "wallaby", "panther", "lion", "zebra","hyena", "gorilla", "monkey", "moose"};
    int randomNumber; 
    char randomWordToGuess[];
    int ammountOfGuesses;
    char playerGuess;
    char secret;
    
    //method for playing the game
    public void newGame() {
    boolean weArePlaying = true;
    
    while(weArePlaying){
       randomNumber = random.nextInt(guesses.length); 
       randomWordToGuess = guesses[randomNumber].toCharArray(); // String to char array
       ammountOfGuesses = randomWordToGuess.length; //total tries to guess a word=word length.
        char playerGuess[] = new char[ammountOfGuesses]; // "_ _ _ _ _ _ _ _" depending on length of word
        char[] secret = randomWordToGuess;//word to guess
     
        for(int i=0; i<playerGuess.length; i++){ // Assign empty dashes at start "_ _ _ _ _ _ _ _"
            playerGuess[i] =  '_';
        } 
        
        boolean wordIsGuessed = false;
        int tries = 0;
        
        while(!wordIsGuessed && tries != ammountOfGuesses){
            System.out.println("Word to guess: ");
            print(playerGuess);//prints secret word to guess
            System.out.printf("You have %d ammount of tries left.\n", ammountOfGuesses-tries);
            System.out.println("Enter a single character: ");
            char input = scanner.nextLine().charAt(0);
            tries++;
            System.out.println("**************************");
            System.out.println();
            
            if(input == '-'){
                wordIsGuessed = true;
                weArePlaying = false;
            } else{
                for(int i=0; i<randomWordToGuess.length; i++){
                    if(randomWordToGuess[i] == input){
                        playerGuess[i] = input;
                    } 
                } 
                
                if(isTheWordGuessed(playerGuess)){
                    wordIsGuessed = true;
                    System.out.println("Congratulations! You guessed the word ====> ");
                    System.out.println(secret);
                    int won = 0;
					won++;
                }
            }
        } // End of wordIsGuessed 
        if(!wordIsGuessed){
            System.out.println("You ran out of guesses. Word to guess was ====>");
            System.out.print(secret);
            System.out.println();
            int lost = 0;
            lost++;
          
        }
        
        System.out.println("Would you like to play again? (yes/no)\n ");
        String choice = scanner.nextLine();
        if(choice.equals("no")){
            weArePlaying = false;
        }
        
    }/*End of We Are Playing*/
    
    System.out.println("Game Over!");
    
    }


public static void print(char array[]){//prints word to guess
    for(int i=0; i<array.length; i++){ // Assign empty dashes at start "_ _ _ _ _ _ _ _"
        System.out.print(array[i] + " ");
    } 
    System.out.println();
}

public static boolean isTheWordGuessed(char[] array){//to check if word is guessed
    boolean condition = true;
    for(int i=0; i<array.length; i++){
        if(array[i] == '_'){
            condition = false;
        }
    }
    return condition;
    
    }

}
