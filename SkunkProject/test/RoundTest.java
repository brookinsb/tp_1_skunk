import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class RoundTest {
	TestUi testUi;
	private int testNumber = 0;
	
	class TestUi implements ISkunkUi {
		public int times_numberOfPlayersPrompt_called = 0;
		boolean rollPromptRetValue = false;

		@Override
		public void displayRollInfo(SkunkRoll roll, int playerScore) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void displayEndTurnInfo(String name, int chips, int score) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void displayMessage(String prompt) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getPlayerName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean rollPrompt() {
			rollPromptRetValue = rollPromptRetValue == true ? false : true;
			return rollPromptRetValue;
		}

		@Override
		public int numberOfPlayersPrompt() {
			int retValue = 2;

			times_numberOfPlayersPrompt_called++;
			
			switch (testNumber) {
			case 1:
				retValue = 9;
				testNumber = 2;
				break;

			case 2:
				retValue = 1;
				testNumber = 3;
				break;

			default:
				retValue = 2;
				break;
			}
			
			return retValue;
		}

		@Override
		public void displayStartTurnInfo(String name, int chips, int score) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean displayDeclarePrompt(String name, int score) {
			return true;
		}

		@Override
		public void displayPlayerDeclared(String name, int score) {
			// TODO Auto-generated method stub
			
		}
		
		
		
	}
	
	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testRound() {
		testUi = new TestUi();
		testNumber = 1;
		Round round = new Round(testUi);
		
		assertEquals(3, testUi.times_numberOfPlayersPrompt_called);
	}

	@Test
	public void testRoundTooManyPlayers() {
		testUi = new TestUi();
		testNumber = 1;
		Round round = new Round(testUi);
	}

	@Test
	public void testStart() {
		testUi = new TestUi();
		testNumber = 3;
		Round round = new Round(testUi);
		round.start();
	}

}