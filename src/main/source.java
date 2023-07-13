import java.util.Scanner;

public class Robot {
    private static int[][] board;
    private static int size;
    private static int posX;
    private static int posY;
    private static boolean isPenDown;
    private static String Direction;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.print("Enter the command: ");
        while (!(command = scanner.nextLine()).equalsIgnoreCase("Q")) {
            executeCommand(command);
            System.out.print("Enter the command: ");
        }
    }

    private static void executeCommand(String command) {
        char commandType = command.charAt(0);
        String arguments = command.substring(1).trim();

        if (commandType == 'I'){initialize_System(Integer.parseInt(arguments));}
        else if(commandType == 'C'){print_CurrentPosition();}
        else if(commandType == 'D'){setPenDown(true);}
        else if(commandType == 'U'){setPenDown(false);}
        else if(commandType == 'R'){turn_Right();}
        else if(commandType == 'L'){turn_Left();}
        else if(commandType == 'M'){move(Integer.parseInt(arguments));}
        else if(commandType == 'P'){print_board();}
        else {System.out.println("Invalid command.");}
 
    }

    private static void initialize_System(int n) {
        size = n;
        board = new int[size][size];
        posX = 0;
        posY = 0;
        isPenDown = false;
        Direction = "north";
    }

    private static void print_CurrentPosition() {
        System.out.printf("Position: %d, %d - Pen: %s - Facing: %s%n",
                posX, posY, (isPenDown ? "down" : "up"), Direction);
    }

    private static void setPenDown(boolean down) {
        isPenDown = down;
    }

    private static void turn_Right() {
       if (Direction == "north"){ Direction = "east"; }
       else if (Direction == "east") { Direction = "south"; }
       else if (Direction == "south") { Direction = "west"; }
       else  { Direction = "north"; }
    }
    
    private static void turn_Left() {
    	 if (Direction == "north"){ Direction = "west"; }
         else if (Direction == "east") { Direction = "north"; }
         else if (Direction == "south") { Direction = "east"; }
         else  { Direction = "south"; }
    }

    private static void move(int steps) {
    	 if (Direction == "north"){
                for (int i = 0; i < steps; i++) {
                    posY = Math.min(posY + 1, size - 1);
                    if (isPenDown) {
                        board[posY][posX] = 1;
                    }
                }
    	 }
    	 else if (Direction == "east"){
                for (int i = 0; i < steps; i++) {
                    posX = Math.min(posX + 1, size - 1);
                    if (isPenDown) {
                        board[posY][posX] = 1;
                    }
                }
    	 }
    	 else if (Direction == "south") {
                for (int i = 0; i < steps; i++) {
                    posY = Math.max(posY - 1, 0);
                    if (isPenDown) {
                        board[posY][posX] = 1;
                    }
                }
    	 }
    	 else {
                for (int i = 0; i < steps; i++) {
                    posX = Math.max(posX - 1, 0);
                    if (isPenDown) {
                        board[posY][posX] = 1;
                    }
                }
    	 }
     }
    

    private static void print_board() {
        for (int i = size - 1; i >= 0; i--) {
            System.out.printf("%2d ", i);
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.print("   ");
        for (int i = 0; i < size; i++) {
            System.out.printf("%2d", i);
        }
        System.out.println();
    }
}
