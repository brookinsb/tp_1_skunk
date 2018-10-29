import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RollTest {

	private Roll nRoll;
	
	@Before
	public void setUp() throws Exception 
	{
	}

	@Test
	public void test_Init_Roll() 
	{
		Roll roll = new Roll();

		assertNotEquals("", roll, null);
	}

	@Test
	public void test_roll_dice() 
	{
		Roll roll = new Roll();
		
		roll.shakeDie();
//		assertEquals("")
		
	}
	
	@Test
	public void test_isRollASkunkRoll()
	{
		
	}
	
	
}
