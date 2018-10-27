
public class Player {

	private ISkunkUi ui;
	private String name;
	private int chips = 50;
	private int score = 0;
	private int chipsToKitty = 0;
	
	public Player(ISkunkUi ui, String name) {
		this.ui = ui;
		this.name = name;
	}

	public void takeTurn() {
		Turn turn = new Turn(ui, score);
		
		turn.go();

		handleTurnScore(turn);
		
	}

	private void handleTurnScore(Turn turn) {
		chipsToKitty = turn.getTotalChips();
		chips =- chipsToKitty;
		if(chips < 0) {
			chips = 0;
		}
		
		int turnScore = turn.getScore();
		if(turnScore >= 0) {
			this.score += turnScore;
		} else {
			this.score = 0;
		}
		
	}
}
