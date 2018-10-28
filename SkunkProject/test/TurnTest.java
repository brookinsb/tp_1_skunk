import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.princeton.cs.introcs.StdOut;

public class TurnTest {

	TestUi testUi;
	private int testNumber = 0;
	
	class TestUi implements ISkunkUi {


		@Override
		public void displayRollInfo(SkunkRoll roll, int playerScore) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void displayTurnInfo(String name, int chips, int score) {
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
			boolean response;
			if (testNumber == 0) {
				response = false;
				
			} else {
				response = true;
			}
			
			testNumber++;
			
			return response;
		}
		
	}
	
	@Before
	public void setUp() throws Exception {
		testUi = new TestUi();
	}

	@Test
	public void testGo() {
		Turn turn = new Turn(testUi, 50);
		Roll roll = turn.getRoll();
		
		for(int i = 0; i < 20; i++) {
			turn.go();
			if(testNumber > 1) {
				SkunkRoll currentRoll = roll.getRoll();
				StdOut.println(currentRoll);
				switch (currentRoll) {
				case SKUNK:
					assertEquals("Chip value incorrect", turn.getScore(), 0);
					break;
				case DOUBLE_SKUNK:
					assertEquals("Chip value incorrect", turn.getScore(), 0);
					break;
				case SKUNK_DEUCE:
					assertEquals("Chip value incorrect", turn.getScore(), 0);
					break;
		
				default:
					assertEquals("Chip value incorrect", turn.getScore(), currentRoll.getValue());
					break;
				}
			}
		}

	}

	@Test
	public void testHandleShakeChips() {
		Turn turn = new Turn(testUi, 50);
		Roll roll = new Roll();
		
		for(int i=0; i < 100; i++) {
			roll.shakeDie();
			
			turn.handleShake(roll);
			
			SkunkRoll currentRoll = roll.getRoll();
			StdOut.println(currentRoll);
			switch (currentRoll) {
			case SKUNK:
				assertEquals("Chip value incorrect", turn.getTotalChips(), 1);
				break;
			case DOUBLE_SKUNK:
				assertEquals("Chip value incorrect", turn.getTotalChips(), 4);
				break;
			case SKUNK_DEUCE:
				assertEquals("Chip value incorrect", turn.getTotalChips(), 2);
				break;

			default:
				assertEquals("Chip value incorrect", turn.getTotalChips(), 0);
				break;
			}
			
		}
	}

	@Test
	public void testGetTotalScore() {
		Turn turn = new Turn(testUi, 50);
		Roll roll = new Roll();
		
			roll.shakeDie();
			
			turn.handleShake(roll);
			
			SkunkRoll currentRoll = roll.getRoll();
			StdOut.println(currentRoll);
			switch (currentRoll) {
			case SKUNK:
				assertEquals("Chip value incorrect", turn.getScore(), 0);
				break;
			case DOUBLE_SKUNK:
				assertEquals("Chip value incorrect", turn.getScore(), 0);
				break;
			case SKUNK_DEUCE:
				assertEquals("Chip value incorrect", turn.getScore(), 0);
				break;

			default:
				assertEquals("Chip value incorrect", turn.getScore(), currentRoll.getValue());
				break;
			}
	}


}
