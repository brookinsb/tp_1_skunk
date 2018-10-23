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
		// TODO Auto-generated method stub
		
	}

}
