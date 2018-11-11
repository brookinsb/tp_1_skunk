import java.util.ArrayList;

public class Round {

	private ISkunkUi skunkUi;
	private ArrayList<Player> players;
	private int mNumberOfPlayers = 0;
	private int activePlayerIndex;
	private int kitty = 0;
	
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
			activePlayer.takeTurn(this, false);
			
			if(activePlayer.isDeclared()) {
				skunkUi.displayPlayerDeclared(activePlayer.getName(), 
											activePlayer.getScore());
				lastRoundPlayer = getLastPlayer();
				break;
			}
			
			activePlayer = nextPlayer();
		}
		
		finishFinalRound();
	}

	private void finishFinalRound() {
		boolean roundDone = false;
		Player activePlayer = nextPlayer();
		
		while(!roundDone) {
			activePlayer.takeTurn(this, true);
						
			activePlayer = nextPlayer();
			
			roundDone = activePlayer.isDeclared();
		}
		
		// Determine winner
		Player winningPlayer = determineWinningPlayer();
		
		// Give kitty to winner
		winningPlayer.addKitty(kitty);
		
		skunkUi.displayRoundWinner(winningPlayer.getName(), 
										 winningPlayer.getScore(),
										 winningPlayer.getChips(),
										 kitty,
										 players);
		skunkUi.displayEndOfRoundMessage();
	}

	private Player determineWinningPlayer() {
		int highScore = 0;
		Player highScoringPlayer = players.get(0);
		
		for(Player player : players ) {
			if(player.getScore() > highScore) {
				highScore =  player.getScore();
				highScoringPlayer = player;
			}
		}
		return highScoringPlayer;
	}

	private int getLastPlayer() {
		int previousPlayerIndex;
		
		previousPlayerIndex = activePlayerIndex - 1;
		if(previousPlayerIndex < 0) {
			previousPlayerIndex = mNumberOfPlayers - 1;
		}
		
		return previousPlayerIndex;
	}

	public void addToKitty(int chips) {
		kitty = kitty + chips;
	}
	
	
}
