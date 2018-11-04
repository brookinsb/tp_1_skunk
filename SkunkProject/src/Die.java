
public class Die
{
	private int lastRoll;
	private int[] dieValues;
	private int testDieIndex;
	private boolean testDie = false;

	public Die()
	{
		testDie = false;
		this.roll();
	}

	public Die(int[] initValues) {
		if (initValues == null)
		{
			throw new RuntimeException("null initializing int[] array");
		}

		testDie = true;
		testDieIndex = 0;
		dieValues = initValues;
		this.roll();
		
	}
	
	public int getLastRoll() // getter or accessor method
	{

		return this.lastRoll;
	}

	public void roll() // note how this changes Die's state, but doesn't return anything
	{
		if(!testDie) {
			this.lastRoll = (int) (Math.random() * 6 + 1);
		} else {
			this.lastRoll = dieValues[testDieIndex++];
			if (testDieIndex >= dieValues.length){
				testDieIndex = 0;
			}
		}
	}

}
