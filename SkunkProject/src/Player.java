
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

	public void takeTurn(Round round, boolean someoneDeclared) {
		mDeclared = false;
		
		Turn turn = new Turn(ui, score);
		
		ui.displayStartTurnInfo(name, chips, score);
		
		turn.go();

		handleTurnScore(round, turn);
		
		checkDeclaration(round, someoneDeclared);
		
		ui.displayEndTurnInfo(name, chips, score);
		
	}

	private void handleTurnScore(Round round, Turn turn) {
		chipsToKitty = turn.getTotalChips();
		chips -= chipsToKitty;
		round.addToKitty(chipsToKitty);
		
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

	private void checkDeclaration(Round round, boolean someoneElseDeclared) {
		if(!someoneElseDeclared) {
			if(this.score >= MIN_DECLARE_SCORE) {
				boolean declared = ui.displayDeclarePrompt(name, score);
				if(declared) {
					mDeclared = true;
				}
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
	
	public void addKitty(int kittyChips) {
		this.chips += kittyChips;
	}
	
	public int getChips() {
		return this.chips;
	}

}
