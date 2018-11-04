
public interface ISkunkUi
{

	void displayRollInfo(SkunkRoll roll, int playerScore);
	
	void displayTurnInfo(String name, int chips, int score);
	
	void displayMessage(String prompt);

	String getPlayerName();

	boolean rollPrompt();

	int numberOfPlayersPrompt();
	
}
