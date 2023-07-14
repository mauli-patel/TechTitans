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

