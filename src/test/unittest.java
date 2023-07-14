package org.phase.mavenproject.org.phase.mavenproject;
import org.phase.mavenproject.org.phase.mavenproject.Robot;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;


public class UnitTest {
	
	static Robot robot;

    @BeforeClass
    public static void setup() {
        robot = new Robot();
    }

	@Test
    public void testInitializeSystem() {
        
        robot.initialize_System(5);

        assertEquals(5, robot.dimension);
        assertEquals(0, robot.Xaxis);
        assertEquals(0, robot.Yaxis);
        assertEquals(false, robot.PenDown);
        assertEquals("north", robot.Direction);
        assertEquals(5, robot.board.length);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                assertEquals(0, robot.board[i][j]);
            }
        }
    }

    @Test
    public void testSetPenDown() {
        robot.setPenDown(true);
        assertEquals(true, robot.PenDown);

        robot.setPenDown(false);
        assertEquals(false, robot.PenDown);
    }


	
    @Test
    public void testPrintBoard() {
        
        robot.initialize_System(3);

        robot.setPenDown(true);
        robot.move(2);
        robot.turn_Right();
        robot.move(1);
        robot.turn_Left();
        robot.move(1);

        String expectedOutput = " 2 * *   \n" +
                				" 1 *     \n" +
                				" 0       \n" +
                				"    0 1 2\n";

        assertEquals(expectedOutput, robot.print_board());
    }
}
