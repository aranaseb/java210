package view_controller;

// A Game of 20 questions game played at the console with standard IO
//
// @author Rick Mercer and Nathon Smith and Sebastian Arana
//
import java.util.Scanner;

import model.Choice;
import model.GameTree;

public class GameOf20Console {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		GameTree game = new GameTree("animals.txt");
		boolean playAnother = true;
		while (playAnother) {
			game.reStart();
			playAnother = playOneGame(game, keyboard);
		}
		keyboard.close();
	}

	private static boolean playOneGame(GameTree game, Scanner keyboard) {
		while (!game.foundAnswer()) {
			System.out.print(game.getCurrent() + " ");
			String answer = keyboard.next();
			if (answer.equals("y")) {
				game.playerSelected(Choice.YES);
			} else {
				game.playerSelected(Choice.NO);
			}
		}
		System.out.print("Were you thinking of a " + game.getCurrent() + "? ");
		String answer = keyboard.next();
		if (answer.equals("y")) {
			System.out.println("\nI win\n");
		} else {
			System.out.print("What were you thinking of? ");
			keyboard.nextLine();
			String newAnswer = keyboard.nextLine();
			System.out.print(
					"Give me a yes answer for '" + newAnswer + "' and a no answer for '" + game.getCurrent() + "': ");
			String newQuestion = keyboard.nextLine();
			game.add(newQuestion, newAnswer);
		}
		System.out.println("\n" + game);
		return playAgain(keyboard);
	}

	private static boolean playAgain(Scanner keyboard) {
		System.out.print("Play another game? <y or n>: ");
		String answer = keyboard.nextLine();
		if (answer.equals("y")) {
			return true;
		}
		return false;
	}
}
