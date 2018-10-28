import edu.princeton.cs.introcs.*;

public class SkunkUi implements ISkunkUi {
	
	public SkunkUi() {
		StdOut.print("SkunkUi init");
	}

	@Override
	public void displayRollInfo(SkunkRoll roll, int playerScore) {
		StdOut.println("Roll result: " + roll.toString());
		StdOut.println("Cummulative turn score: " + playerScore);
		
	}

	@Override
	public void displayTurnInfo(String name, int chips, int score) {
		StdOut.println(name + "\'s turn ended");
		StdOut.println("Score: " + score + ".  Chips: " + chips);
		
	}

	@Override
	public void displayMessage(String prompt) {
		StdOut.println(prompt);
				
	}

	@Override
	public String getPlayerName() {
		StdOut.print("Enter player name: ");
		String name = StdIn.readLine();
		return name;
	}

	@Override
	public boolean rollPrompt() {
		StdOut.print("Do you wnat to roll? (n or y): ");
		
		String response = StdIn.readLine();
		
		return response.toLowerCase().equals("y");
	}

}
