package org.phasetwo.mavenproject.org.phasetwo.mavenproject;
import org.phasetwo.mavenproject.org.phasetwo.mavenproject.Robot;

import org.junit.jupiter.api.BeforeAll;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;



public class UnitTest {
	
				static Robot robot;

			    @BeforeAll
			    public static void setup() {
			        robot = new Robot();
			    }

			    @Test
			    public void testInitializeSystem() {
			        
			        robot.initialize_System(5);

			        Assertions.assertEquals(5, robot.dimension);
			        Assertions.assertEquals(0, robot.Xaxis);
			        Assertions.assertEquals(0, robot.Yaxis);
			        Assertions.assertEquals(false, robot.PenDown);
			        Assertions.assertEquals("north", robot.Direction);
			        Assertions.assertEquals(5, robot.board.length);
			        for (int i = 0; i < 5; i++) {
			            for (int j = 0; j < 5; j++) {
			                Assertions.assertEquals(0, robot.board[i][j]);
			            }
			        }
			    }

			    @Test
			    public void testSetPenDown() {
			        robot.setPenDown(true);
			        Assertions.assertEquals(true, robot.PenDown);

			        robot.setPenDown(false);
			        Assertions.assertEquals(false, robot.PenDown);
			    }

			    @Test
			    public void testturn_Right() {
			        
			        robot.Direction = "north";
			        robot.turn_Right();
			        Assertions.assertEquals("east", robot.Direction);

			        robot.Direction = "east";
			        robot.turn_Right();
			        Assertions.assertEquals("south", robot.Direction);

			        robot.Direction = "south";
			        robot.turn_Right();
			        Assertions.assertEquals("west", robot.Direction);

			        robot.Direction = "west";
			        robot.turn_Right();
			        Assertions.assertEquals("north", robot.Direction);
			    }

			    @Test
			    public void testturn_Left() {
			        
			        robot.Direction = "north";
			        robot.turn_Left();
			        Assertions.assertEquals("west", robot.Direction);

			        robot.Direction = "west";
			        robot.turn_Left();
			        Assertions.assertEquals("south", robot.Direction);

			        robot.Direction = "south";
			        robot.turn_Left();
			        Assertions.assertEquals("east", robot.Direction);

			        robot.Direction = "east";
			        robot.turn_Left();
			        Assertions.assertEquals("north", robot.Direction);
			    }

			    @Test
			    public void testMove() {
			        robot.initialize_System(5);

			        robot.setPenDown(true);
			        robot.move(3);
			        Assertions.assertEquals(0, robot.Xaxis);
			        Assertions.assertEquals(3, robot.Yaxis);
			        Assertions.assertEquals(1, robot.board[1][0]);
			        Assertions.assertEquals(1, robot.board[2][0]);
			        Assertions.assertEquals(1, robot.board[3][0]);

			        robot.Direction = "east";
			        robot.move(2);
			        Assertions.assertEquals(2, robot.Xaxis);
			        Assertions.assertEquals(3, robot.Yaxis);
			        Assertions.assertEquals(1, robot.board[3][1]);
			        Assertions.assertEquals(1, robot.board[3][2]);

			        robot.Direction = "south";
			        robot.move(2);
			        Assertions.assertEquals(2, robot.Xaxis);
			        Assertions.assertEquals(1, robot.Yaxis);
			        Assertions.assertEquals(1, robot.board[2][2]);
			        Assertions.assertEquals(1, robot.board[1][2]);

			        robot.Direction = "west";
			        robot.move(1);
			        Assertions.assertEquals(1, robot.Xaxis);
			        Assertions.assertEquals(1, robot.Yaxis);
			        Assertions.assertEquals(1, robot.board[1][1]);
			    }
			    
			    @Test
			    public void testPrintCurrentPosition() {
			        robot.Xaxis = 0;
			        robot.Yaxis = 3;
			        robot.PenDown = true;
			        robot.Direction = "north";

			        String output = robot.print_CurrentPosition();
			        String expectedOutput = "Position: 0, 3 - Pen: down - Facing: north\r"
			        		+ "\n";
			        Assertions.assertEquals(expectedOutput, output);
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

			        Assertions.assertEquals(expectedOutput, robot.print_board());
			    }
}
