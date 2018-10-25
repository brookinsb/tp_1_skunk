import edu.princeton.cs.introcs.*;

public class SkunkUi implements ISkunkUi {
	
	public SkunkUi() {
		StdOut.print("SkunkUi init");
	}

	@Override
	public void displayRoll() {
		StdOut.print("displayRoll");
		// TODO Auto-generated method stub
		
	}

	@Override
	public String displayPrompt(String prompt) {
		StdOut.print("Do you wnat to roll? (n or y)");
		
		String response = StdIn.readLine();
		
		return response;
		
	}

	@Override
	public String getPlayerName() {
		StdOut.print("Enter player name:");
		String name = StdIn.readLine();
		return name;
	}

	@Override
	public boolean rollPrompt() {
		StdOut.print("Do you wnat to roll? (n or y)");
		
		String response = StdIn.readLine();
		
		return response.toLowerCase().equals("y");
	}

}
