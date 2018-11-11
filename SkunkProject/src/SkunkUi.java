import java.util.ArrayList;

import edu.princeton.cs.introcs.*;

public class SkunkUi implements ISkunkUi {
	
	public SkunkUi() {
		StdOut.print("SkunkUi init");
		StdOut.println();
	}

	@Override
	public void displayRollInfo(SkunkRoll roll, int playerScore) {
		StdOut.println("Roll result: " + roll.toString());
		StdOut.println("Cummulative turn score: " + playerScore);
		StdOut.println();
		
	}

	@Override
	public void displayEndTurnInfo(String name, int chips, int score) {
		StdOut.println(name + "\'s turn ended");
		StdOut.println("Score: " + score + ".  Chips: " + chips);
		StdOut.println("****************************************\r\n");
		
	}

	@Override
	public void displayMessage(String prompt) {
		StdOut.println(prompt);
				
	}

	@Override
	public String getPlayerName() {
		StdOut.print("Enter player name: ");
		StdOut.println();
		String name = StdIn.readLine();
		return name;
	}

	@Override
	public boolean rollPrompt() {
		StdOut.print("Do you wnat to roll? (n or y): ");
		
		String response = StdIn.readLine();
		
		return response.toLowerCase().equals("y");
	}

	@Override
	public int numberOfPlayersPrompt() {
		StdOut.print("Enter the number of players (2 to 8): ");
		
		int response = Integer.parseInt(StdIn.readLine());
		
		return response;
	}

	@Override
	public void displayStartTurnInfo(String name, int chips, int score) {
		StdOut.println("Starting " + name + "\'s turn");
		StdOut.println("Score: " + score + ".  Chips: " + chips);
		StdOut.println();
		
	}

	@Override
	public boolean displayDeclarePrompt(String name, int score) {
		StdOut.println("You have more than 100.");
		StdOut.print("Do you wnat to declare? (n or y): ");
		
		String response = StdIn.readLine();
		
		return response.toLowerCase().equals("y");
	}

	@Override
	public void displayPlayerDeclared(String name, int score) {
		StdOut.println(name + " declared with " + score + " points");
		StdOut.println();
	}

	@Override
	public void displayEndOfRoundMessage() {
		StdOut.println();
		StdOut.println("** End of Round **");
		StdOut.println();
		
	}

	@Override
	public void displayRoundWinner(String name, int score, int chips, int kitty, 
									ArrayList<Player> players) {
		StdOut.println("Round winner: " + name + " with " + score + " points");
		StdOut.println(name + "collected the kitty of " + kitty + " chips.\r\n");
		StdOut.println();
	
		StdOut.println("****** Round Results ******");
		for(Player player : players) {
			String pName = player.getName();
			int pScore = player.getScore();
			int pChips = player.getChips();
			StdOut.println(pName + ": Score: " + pScore + ", Chips: " + pChips);
		}
		
		StdOut.println();
	}

}
