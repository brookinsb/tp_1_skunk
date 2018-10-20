
public class Roll {

	private Die die1;
	private Die die2;
	private int lastDie1Value;
	private int lastDie2Value;

	public enum Skunk_Roll {
		NO_SKUNK,
		SKUNK,
		DOUBLE_SKUNK,
		SKUNK_DEUCE;
	}
	
	
	public Roll() {
		die1 = new Die();
		die2 = new Die();
	}

	public void shakeDie() {

		die1.roll();
		die2.roll();
		
		lastDie1Value = die1.getLastRoll();
		lastDie2Value = die2.getLastRoll();
	}

	public int getLastDie1Value() {
		return lastDie1Value;
	}

	public int getLastDie2Value() {
		return lastDie2Value;
	}
	
	public Skunk_Roll isRollASkunkRoll() {
		Skunk_Roll roll = Skunk_Roll.NO_SKUNK;
		
		if(lastDie1Value == 1 && lastDie2Value == 1) {
			roll = Skunk_Roll.DOUBLE_SKUNK;
		} 
		else if((lastDie1Value == 1 && lastDie2Value == 2) ||
				(lastDie1Value == 2 && lastDie2Value == 1)) {
			roll = Skunk_Roll.SKUNK_DEUCE;
		}
		else if(lastDie1Value == 1 || lastDie2Value == 1 ) {
				roll = Skunk_Roll.SKUNK;
		}
						
		return roll;
	}


	public int getRollValue() {
		return lastDie1Value + lastDie2Value;
	}
}
