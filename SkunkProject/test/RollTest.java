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
	public void test_isRollASkunkRoll_DoubleSkunk()
	{
		Roll roll = new Roll();

		assertEquals(false, roll.isRollASkunkRoll(1, 1));
	}
	
	@Test
	public void test_isRollASkunkRoll_SkunkDuece()
	{
		Roll roll = new Roll();

		assertEquals(false, roll.isRollASkunkRoll(1, 2));
		assertEquals(false, roll.isRollASkunkRoll(2, 1));
	}
	
	@Test
	public void test_isRollASkunkRoll_Skunk()
	{
		Roll roll = new Roll();

		assertEquals(true, roll.isRollASkunkRoll(1, 3));
		assertEquals(true, roll.isRollASkunkRoll(1, 4));
		assertEquals(true, roll.isRollASkunkRoll(1, 5));
		assertEquals(true, roll.isRollASkunkRoll(1, 6));
		
		assertEquals(true, roll.isRollASkunkRoll(3, 1));
		assertEquals(true, roll.isRollASkunkRoll(4, 1));
		assertEquals(true, roll.isRollASkunkRoll(5, 1));
		assertEquals(true, roll.isRollASkunkRoll(6, 1));
	}
	
	@Test
	public void test_isRollASkunkRoll_NoSkunk()
	{
		Roll roll = new Roll();

		assertEquals(false, roll.isRollASkunkRoll(2, 2));
	}
	
	
}
