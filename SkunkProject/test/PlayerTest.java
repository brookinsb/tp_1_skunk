import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	private int testNumber = 0;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPlayer() {
		TestUi testUi = new TestUi();
		String playerName = "Bob";
		
		Player player = new Player(testUi, playerName);

		assertEquals(playerName, player.getName());
		assertEquals(50, player.getChips());
		assertEquals(0, player.getScore());
	}

	@Test
	public void testIsDeclared() {
		TestUi testUi = new TestUi();
		String playerName = "Bob";
		
		Player player = new Player(testUi, playerName);

		assertFalse(player.isDeclared());
	}

	@Test
	public void testAddKitty() {
		TestUi testUi = new TestUi();
		String playerName = "Bob";
		
		Player player = new Player(testUi, playerName);
		player.addKitty(4);
		
		assertEquals(54, player.getChips());
	}

	class TestUi implements ISkunkUi {


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
			boolean response;
			if (testNumber == 0) {
				response = false;
				
			} else {
				response = true;
			}
			
			testNumber++;
			
			return response;
		}

		@Override
		public int numberOfPlayersPrompt() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void displayStartTurnInfo(String name, int chips, int score) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean displayDeclarePrompt(String name, int score) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void displayPlayerDeclared(String name, int score) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void displayEndOfRoundMessage() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void displayRoundWinner(String name, int score, int chips, int kitty, ArrayList<Player> players) {
			// TODO Auto-generated method stub
			
		}
		
	}


}
