package com.gameGuesser;
import java.util.Random;
import java.util.Scanner;

public class GameGuesser {
	
	public static void main(String[] args) {
		
		//-----Initialize necessary variables-------//
		int min = 1; // Min & Max variables to initialize
		int max = 100;
		int maxAttempts = 5; // Represents maximum attempts for the UserInput before false.
		boolean playerWin = false;
		
		//------------Setting Up Inputs----------------//
		Scanner s = new Scanner(System.in);
		Random rand = new Random();
		int numberToGuess = rand.nextInt(100) + 1; 
		int numberOfTries = 0;
		
		//--------------Game Loop------------------//
	
		System.out.println("Welcome to Game Guesser!");
		
		/* The game will loop until either the player wins or uses all guess attempts */
		int guess = 0; 
		while (numberOfTries < maxAttempts) {
			System.out.print("Choose a number between " + min + " and " + max + ": ");
			guess = s.nextInt();
			
			if (guess < numberToGuess) { //Compare the UserGuess with the number of correct attempts.
				System.out.println("Too Low. Please guess again.");
				numberOfTries++;
			} else if (guess > numberToGuess) {
				System.out.println("Too High. Please guess again.");
				numberOfTries++;
			} else if (guess <= min || guess >= max) { //If UserGuesss is outside of the available int or is a string, return this message.
					System.out.println("Your guess is not between" + min + " and " + max + "Please try again.");
			// If the number is invalid, numberOfTries can't increment.
			} else {
				playerWin = true;
				break;
			}
		}	
		
		//--------------Display Game Results--------------//
		if (playerWin) {
			System.out.println("You Win! The number to guess was: " + numberToGuess);
			System.out.println("The number of tries it took you was: " + numberOfTries);
		} else {
			System.out.println("You've lost. Too many guesses.");
			System.out.println("The correct number was: " + numberToGuess);
		}
	}
}