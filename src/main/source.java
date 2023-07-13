import java.util.Scanner;

public class Robot {
	private static int[][] board;
    private static int dimension;
    private static int Xaxis;
    private static int Yaxis;
    private static boolean isPenDown;
    private static String Direction;
    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        String command;

        System.out.print("Enter your command: ");
        while (!(command = scanner.nextLine()).equalsIgnoreCase("Q")) {
            executeCommand(command);
            System.out.print("Enter your command: ");

	}

}
	private static void executeCommand(String command) {
        char commandType = command.charAt(0);
        String arguments = command.substring(1).trim();

        switch (commandType) {
            case 'I':
                initializeSystem(Integer.parseInt(arguments));
                break;
            case 'C':
                printCurrentPosition();
                break;
            case 'D':
                setPenDown(true);
                break;
            case 'U':
                setPenDown(false);
                break;
            case 'R':
                turnRight();
                break;
            case 'L':
                turnLeft();
                break;
            case 'M':
                move(Integer.parseInt(arguments));
                break;
            case 'P':
                printFloor();
                break;
            default:
                System.out.println("Invalid command.");
        }
    }
	private static void initializeSystem(int n) {
        dimension = n;
        board = new int[dimension][dimension];
        Xaxis = 0;
        Yaxis = 0;
        isPenDown = false;
        Direction = "north";
    }
  private static void printCurrentPosition() {
        System.out.printf("Position: %d, %d - Pen: %s - Facing: %s%n",
                Xaxis, Yaxis, (isPenDown ? "down" : "up"), Direction);
    }
  
  private static void setPenDown(boolean down) {
      isPenDown = down;
  }
  
  private static void turnRight() {
      switch (Direction) {
          case "north":
              Direction = "east";
              break;
          case "east":
              Direction = "south";
              break;
          case "south":
              Direction = "west";
              break;
          case "west":
              Direction = "north";
              break;
      }
  }

  private static void turnLeft() {
      switch (Direction) {
          case "north":
              Direction = "west";
              break;
          case "east":
              Direction = "north";
              break;
          case "south":
              Direction = "east";
              break;
          case "west":
              Direction = "south";
              break;
      }
  }

  private static void move(int steps) {
      switch (Direction) {
          case "north":
              for (int i = 0; i < steps; i++) {
                  Yaxis = Math.min(Yaxis + 1, dimension - 1);
                  if (isPenDown) {
                      board[Yaxis][Xaxis] = 1;
                  }
              }
              break;
          case "east":
              for (int i = 0; i < steps; i++) {
                  Xaxis = Math.min(Xaxis + 1, dimension - 1);
                  if (isPenDown) {
                      board[Yaxis][Xaxis] = 1;
                  }
              }
              break;
          case "south":
              for (int i = 0; i < steps; i++) {
                  Yaxis = Math.max(Yaxis - 1, 0);
                  if (isPenDown) {
                      board[Yaxis][Xaxis] = 1;
                  }
              }
              break;
          case "west":
              for (int i = 0; i < steps; i++) {
                  Xaxis = Math.max(Xaxis - 1, 0);
                  if (isPenDown) {
                      board[Yaxis][Xaxis] = 1;
                  }
              }
              break;
      }
  }
 private static void printFloor() {
        for (int i = dimension - 1; i >= 0; i--) {
            System.out.printf("%2d ", i);
            for (int j = 0; j < dimension; j++) {
                if (board[i][j] == 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.print("   ");
        for (int i = 0; i < dimension; i++) {
            System.out.printf("%2d", i);
        }
        System.out.println();
    }
}
