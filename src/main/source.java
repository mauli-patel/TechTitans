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

        System.out.print("Enter your command: ");
        while (!(command = scanner.nextLine()).equalsIgnoreCase("Q")) {
            executeCommand(command);
            System.out.print("Enter your command: ");

	}

}
	private static void initializeSystem(int n) {
        size = n;
        board = new int[size][size];
        posX = 0;
        posY = 0;
        isPenDown = false;
        Direction = "north";
    }
  private static void printCurrentPosition() {
        System.out.printf("Position: %d, %d - Pen: %s - Facing: %s%n",
                posX, posY, (isPenDown ? "down" : "up"), Direction);
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
                  posY = Math.min(posY + 1, size - 1);
                  if (isPenDown) {
                      board[posY][posX] = 1;
                  }
              }
              break;
          case "east":
              for (int i = 0; i < steps; i++) {
                  posX = Math.min(posX + 1, size - 1);
                  if (isPenDown) {
                      board[posY][posX] = 1;
                  }
              }
              break;
          case "south":
              for (int i = 0; i < steps; i++) {
                  posY = Math.max(posY - 1, 0);
                  if (isPenDown) {
                      board[posY][posX] = 1;
                  }
              }
              break;
          case "west":
              for (int i = 0; i < steps; i++) {
                  posX = Math.max(posX - 1, 0);
                  if (isPenDown) {
                      board[posY][posX] = 1;
                  }
              }
              break;
      }
  }
}
