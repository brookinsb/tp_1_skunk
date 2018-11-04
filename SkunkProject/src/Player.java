
public class Player {

	private ISkunkUi ui;
	private String name;
	private final int MIN_DECLARE_SCORE = 100;
	private int chips = 50;
	private int score = 0;
	private int chipsToKitty = 0;
	private boolean mDeclared = false;
	
	public Player(ISkunkUi ui, String name) {
		this.ui = ui;
		this.name = name;
	}

	public void takeTurn() {
		mDeclared = false;
		
		Turn turn = new Turn(ui, score);
		
		ui.displayStartTurnInfo(name, chips, score);
		
		turn.go();

		handleTurnScore(turn);
		
		checkDeclaration();
		
		ui.displayEndTurnInfo(name, chips, score);
		
	}

	private void handleTurnScore(Turn turn) {
		chipsToKitty = turn.getTotalChips();
		chips -= chipsToKitty;
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

	private void checkDeclaration() {
		if(this.score >= MIN_DECLARE_SCORE) {
			boolean declared = ui.displayDeclarePrompt(name, score);
			if(declared) {
				mDeclared = true;
			}
		}
	}

	public boolean isDeclared() {
		return mDeclared;
	}

	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}

}
