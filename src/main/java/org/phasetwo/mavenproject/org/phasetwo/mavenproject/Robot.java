package org.phasetwo.mavenproject.org.phasetwo.mavenproject;

import java.util.Scanner;

public class Robot {
	
	    static int[][] board;
	    static int dimension;
	    static int Xaxis;
	    static int Yaxis;
	    static boolean PenDown;
	    static String Direction;

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String command;

	        System.out.print("Enter the command: ");
	        while (!(command = scanner.nextLine()).equalsIgnoreCase("Q")) {
	            executeCommand(command);
	            System.out.print("Enter the command: ");
	        }
	    }

	    public static void executeCommand(String command) {
	        char commandType = command.charAt(0);
	        String arguments = command.substring(1).trim();
	        if (commandType == 'I'|| commandType =='i'){initialize_System(Integer.parseInt(arguments));}
	        else if(commandType == 'C' || commandType =='c'){print_CurrentPosition();}
	        else if(commandType == 'D' || commandType =='d'){setPenDown(true);}
	        else if(commandType == 'U' || commandType =='u'){setPenDown(false);}
	        else if(commandType == 'R' || commandType =='r'){turn_Right();}
	        else if(commandType == 'L' || commandType =='l'){turn_Left();}
	        else if(commandType == 'M' || commandType =='m'){move(Integer.parseInt(arguments));}
	        else if(commandType == 'P' || commandType =='p'){print_board();}
	      else {System.out.println("Invalid command.");}
	 
	    }

	    public static void initialize_System(int n) {
	        dimension = n;
	        board = new int[dimension][dimension];
	        Xaxis = 0;
	        Yaxis = 0;
	        PenDown = false;
	        Direction = "north";
	    }

	    public static String print_CurrentPosition() {
	    	String output = String.format("Position: %d, %d - Pen: %s - Facing: %s%n",
	                Xaxis, Yaxis, (PenDown ? "down" : "up"), Direction);
	    	System.out.println(output);
	        return output;
	    }

	    public static void setPenDown(boolean down) {
	        PenDown = down;
	    }

	    public static void turn_Right() {
	       if (Direction == "north"){ Direction = "east"; }
	       else if (Direction == "east") { Direction = "south"; }
	       else if (Direction == "south") { Direction = "west"; }
	       else  { Direction = "north"; }
	    }
	    
	    public static void turn_Left() {
	    	 if (Direction == "north"){ Direction = "west"; }
	         else if (Direction == "east") { Direction = "north"; }
	         else if (Direction == "south") { Direction = "east"; }
	         else  { Direction = "south"; }
	    }

	    public static void move(int steps) {
	    	 if (Direction == "north"){
	                for (int i = 0; i < steps; i++) {
	                    Yaxis = Math.min(Yaxis + 1, dimension - 1);
	                    if (PenDown) {
	                        board[Yaxis][Xaxis] = 1;
	                    }
	                }
	    	 }
	    	 else if (Direction == "east"){
	                for (int i = 0; i < steps; i++) {
	                    Xaxis = Math.min(Xaxis + 1, dimension - 1);
	                    if (PenDown) {
	                        board[Yaxis][Xaxis] = 1;
	                    }
	                }
	    	 }
	    	 else if (Direction == "south") {
	                for (int i = 0; i < steps; i++) {
	                    Yaxis = Math.max(Yaxis - 1, 0);
	                    if (PenDown) {
	                        board[Yaxis][Xaxis] = 1;
	                    }
	                }
	    	 }
	    	 else {
	                for (int i = 0; i < steps; i++) {
	                    Xaxis = Math.max(Xaxis - 1, 0);
	                    if (PenDown) {
	                        board[Yaxis][Xaxis] = 1;
	                    }
	                }
	    	 }
	     }
	    

	    public static String print_board() {
	        StringBuilder output = new StringBuilder();
	        for (int i = dimension - 1; i >= 0; i--) {
	            output.append(String.format("%2d ", i));
	            for (int j = 0; j < dimension; j++) {
	                if (board[i][j] == 1) {
	                    output.append("* ");
	                } else {
	                    output.append("  ");
	                }
	            }
	            output.append("\n");
	        }
	        output.append("   ");
	        for (int i = 0; i < dimension; i++) {
	            output.append(String.format("%2d", i));
	        }
	        output.append("\n");
	        System.out.print(output);
	        
	        return output.toString();
	    }


		
}
