private static void initializeSystem(int n) {
        size = n;
        floor = new int[size][size];
        posX = 0;
        posY = 0;
        isPenDown = false;
        facingDirection = "north";
    }
  private static void printCurrentPosition() {
        System.out.printf("Position: %d, %d - Pen: %s - Facing: %s%n",
                posX, posY, (isPenDown ? "down" : "up"), facingDirection);
    }
  
