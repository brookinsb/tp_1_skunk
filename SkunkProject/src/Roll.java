
public class Roll {

	private Die die1;
	private Die die2;
	private int lastDie1Value;
	private int lastDie2Value;

	
	
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

	public boolean isRollASkunkRoll(int die1, int die2) {
		SkunkRoll roll = SkunkRoll.NO_SKUNK;
		
		if(die1 == 1 && die2 == 1) {
			roll = SkunkRoll.DOUBLE_SKUNK;
		} 
		else if(die1 + die2 == 3) {
			roll = SkunkRoll.SKUNK_DEUCE;
		}
		else if(die1 == 1 || die2 == 1 ) {
				roll = SkunkRoll.SKUNK;
		}
						
		return roll == SkunkRoll.SKUNK;
	}
	
	
	public SkunkRoll getRoll() {
		SkunkRoll roll = SkunkRoll.NO_SKUNK;
		
		if(isRollASkunkRoll(lastDie1Value, lastDie2Value) ) {
			roll = SkunkRoll.SKUNK;
		} else {
			
			int rollValue = lastDie1Value + lastDie2Value;
			switch(rollValue) {
			case 2:
				roll = SkunkRoll.DOUBLE_SKUNK;
				break;
			case 3:
				roll = SkunkRoll.SKUNK_DEUCE;
				break;
			case 4:
				roll = SkunkRoll.FOUR;
				break;
			case 5:
				roll = SkunkRoll.FIVE;
				break;
			case 6:
				roll = SkunkRoll.SIX;
				break;
			case 7:
				roll = SkunkRoll.SEVEN;
				break;
			case 8:
				roll = SkunkRoll.EIGHT;
				break;
			case 9:
				roll = SkunkRoll.NINE;
				break;
			case 10:
				roll = SkunkRoll.TEN;
				break;
			case 11:
				roll = SkunkRoll.ELEVEN;
				break;
			case 12:
				roll = SkunkRoll.TWELVE;
				break;
			default:
				roll = SkunkRoll.NO_SKUNK;
				throw new IllegalArgumentException("Illegal roll value");
			}
			
		}
		
		return roll;
	}


	public int getRollValue() {
		return lastDie1Value + lastDie2Value;
	}
}
