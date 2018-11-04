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
		
		if(mNumberOfPlayers >=2 && mNumberOfPlayers <= 8 ) {

			for(int i = 0; i < mNumberOfPlayers; i++) {
				String name = skunkUi.getPlayerName();
				players.add(new Player(skunkUi, name));

			}
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
		boolean roundDone = false;
		
		activePlayerIndex = 0;
		Player activePlayer = players.get(activePlayerIndex);
		
		while(!roundDone) {
			activePlayer.takeTurn();
			
			activePlayer = nextPlayer();
		}
		skunkUi.displayMessage("End of round");
	}

	
}
