
public interface ISkunkUi
{

	void displayRollInfo(SkunkRoll roll, int playerScore);
	
	void displayMessage(String prompt);

	String getPlayerName();

	boolean rollPrompt();
	
}
