

public class Turn {
	
	private ISkunkUi Ui;
	private int startingScore;
	private int turnScore = 0;
	private int chipNumber;
	
	
	public Turn(ISkunkUi Ui, int startingTurnScore) {
		this.Ui = Ui;
		this.startingScore = startingTurnScore;
	}
	
	public void go() {
		Roll roll = new Roll();
		boolean rollAgain;
		
		rollAgain = Ui.rollPrompt();
		
		while (rollAgain) {
			roll.shakeDie();
			
			boolean skunkRolled = handleShake(roll);
			
			if(skunkRolled) {
				rollAgain = false;
			} else {
				rollAgain = Ui.rollPrompt();
			}
		}
	}

	public boolean handleShake(Roll roll) {
		boolean turnDone = false;
		SkunkRoll rollResult = roll.getRoll();
		
		switch(rollResult) {
			case SKUNK:
				chipNumber = 1;
				turnScore = 0;
				turnDone = true;
				break;
			case DOUBLE_SKUNK:
				chipNumber = 4;
				turnScore = -1;
				turnDone = true;
				break;
			case SKUNK_DEUCE:
				chipNumber = 2;
				turnScore = 0;
				turnDone = true;
				break;
			default:
				
				int rollValue = roll.getRollValue();
				turnScore += rollValue;
		}
		
		int playerTurnScore = startingScore + turnScore;
		Ui.displayRollInfo(rollResult, playerTurnScore);
		
		return turnDone;
		
	}

	public int getTotalChips() {
		
		return chipNumber;
	}

	public int getScore() {

		return turnScore;
	}
}
