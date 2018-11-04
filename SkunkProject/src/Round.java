import java.util.ArrayList;

public class Round {

	private ISkunkUi skunkUi;
	private ArrayList<Player> players;
	private int mNumberOfPlayers = 0;
	private int activePlayerIndex;
	
	public Round(ISkunkUi Ui) {
		this.skunkUi = Ui;

		players = new ArrayList<>();
		
		addPlayers();
		
	}
	
	private void addPlayers() {
		mNumberOfPlayers = skunkUi.numberOfPlayersPrompt();
		
		while(mNumberOfPlayers < 2 || mNumberOfPlayers > 8) {
			mNumberOfPlayers = skunkUi.numberOfPlayersPrompt();
		}
		
		for(int i = 0; i < mNumberOfPlayers; i++) {
			String name = skunkUi.getPlayerName();
			players.add(new Player(skunkUi, name));

		}
		
	}
	
	private Player nextPlayer() {
		int maxPlayerIndex = mNumberOfPlayers - 1;
		if(activePlayerIndex < maxPlayerIndex) {
			activePlayerIndex++;
		}
		else {
			 activePlayerIndex = 0;
		}
		return players.get(activePlayerIndex);
	}

	public void start() {
		int lastRoundPlayer;
		activePlayerIndex = 0;
		Player activePlayer = players.get(activePlayerIndex);
		
		while(true) {
			activePlayer.takeTurn();
			
			if(activePlayer.isDeclared()) {
				skunkUi.displayPlayerDeclared(activePlayer.getName(), 
											activePlayer.getScore());
				lastRoundPlayer = getLastPlayer();
				break;
			}
			
			activePlayer = nextPlayer();
		}
		
		finishFinalRound();
		
		skunkUi.displayMessage("End of round");
	}

	private void finishFinalRound() {
		boolean roundDone = false;
		Player activePlayer = nextPlayer();
		
		while(!roundDone) {
			activePlayer.takeTurn();
						
			activePlayer = nextPlayer();
			
			roundDone = activePlayer.isDeclared();
		}
		
		
	}

	private int getLastPlayer() {
		int previousPlayerIndex;
		
		previousPlayerIndex = activePlayerIndex - 1;
		if(previousPlayerIndex < 0) {
			previousPlayerIndex = mNumberOfPlayers - 1;
		}
		
		return previousPlayerIndex;
	}

	
}
