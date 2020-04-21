package Hangman;

public class HangmanApp {

	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Hangman Game!\n"+
				 "You have to guess an animal. You`re amount of guesses depends on the length of the word, good luck!");
		  
		HangmanCompute hangmanGame = new HangmanCompute();
		hangmanGame.newGame();

	  
	}//main

}

	


