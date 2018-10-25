import java.util.ArrayList;

public class Round {

	private ISkunkUi skunkUi;
	private ArrayList<Player> players;
	
	public Round(ISkunkUi Ui) {
		this.skunkUi = Ui;

		players = new ArrayList<>();
		
		addPlayers();
		
	}
	
	private void addPlayers() {
		String name = skunkUi.getPlayerName();
		players.add(new Player(skunkUi, name));
		
	}
	
	public void start() {
		Player activePlayer = players.get(0);
		activePlayer.takeTurn();
	}
	
	
}
