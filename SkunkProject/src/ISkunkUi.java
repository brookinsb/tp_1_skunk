
public interface ISkunkUi
{

	void displayRollInfo(SkunkRoll roll, int playerScore);
	
	void displayEndTurnInfo(String name, int chips, int score);
	
	void displayMessage(String prompt);

	String getPlayerName();

	boolean rollPrompt();

	int numberOfPlayersPrompt();

	void displayStartTurnInfo(String name, int chips, int score);

	boolean displayDeclarePrompt(String name, int score);

	void displayPlayerDeclared(String name, int score);
	
}
