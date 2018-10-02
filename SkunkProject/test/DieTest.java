import junit.framework.TestCase;

public class DieTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testDie() {
		int dieArray[] = new int[] {1, 2, 3, 4, 5, 6}; 
		Die die = new Die(dieArray);
		
		for(int dieIndex = 0; dieIndex < dieArray.length - 1; dieIndex++ ){
			assertEquals("Incorrect value returned", die.getLastRoll(), dieArray[dieIndex]);
			die.roll();
		}
	}

//	public void testGetLastRoll() {
//		fail("Not yet implemented");
//	}
//
//	public void testRoll() {
//		fail("Not yet implemented");
//	}
//
//	public void testToString() {
//		fail("Not yet implemented");
//	}

}
