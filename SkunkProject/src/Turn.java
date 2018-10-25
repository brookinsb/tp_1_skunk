

public class Turn {
	
	private ISkunkUi Ui;
	private int startingScore;
	private int turnScore = 0;
	
	
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
			
			handleShake(roll);
		}
	}

	private boolean handleShake(Roll roll) {
		boolean turnDone = false;
		SkunkRoll rollResult = roll.getRoll();
		
		switch(rollResult) {
			case SKUNK:
				
				turnDone = true;
				break;
			case DOUBLE_SKUNK:
				
				turnDone = true;
				break;
			case SKUNK_DEUCE:
				
				turnDone = true;
				break;
			default:
				
				int rollValue = roll.getRollValue();
		}
		
		return turnDone;
		
	}
}
