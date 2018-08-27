package bao.doan;

import java.util.Scanner;

public class Main {

  public static void printDescription() {
    System.out.println("Please input the commands: ");
    System.out.println("C w h Should create a new canvas of width w and height h.");
    System.out.println("L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only\n"
                       + "                horizontal or vertical lines are supported. Horizontal and vertical lines\n"
                       + "                will be drawn using the 'x' character.");

    System.out.println("R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and\n"
                       + "                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn\n"
                       + "                using the 'x' character.");
    System.out.println("B x y c         Should fill the entire area connected to (x,y) with \"colour\" c. The\n"
                       + "                behaviour of this is the same as that of the \"bucket fill\" tool in paint\n"
                       + "                programs.");
    System.out.println("Q               Should quit the program.\n" + "");
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    Canvas canvas = null;
    String[] arr;
    char firstChar;
    printDescription();
    boolean exit = false;
    while (!exit) {
      System.out.print("enter command: ");
      String str = new Scanner(System.in).nextLine();
      firstChar = str.toCharArray()[0];
      if (firstChar == 'Q') {
        System.out.println("Good bye!");
        exit = true;
      } else if (firstChar == 'C') {
        arr = str.split(" ");
        int width = Integer.parseInt(arr[1]);
        int height = Integer.parseInt(arr[2]);
        canvas = new Canvas(width, height);
        System.out.println(canvas.toString());
      } else if (canvas == null) {
        throw new IllegalArgumentException("Have to initize canvas first.");
      } else if (firstChar == 'R' || firstChar == 'L') {
        arr = str.split(" ");
        int x1 = Integer.parseInt(arr[1]);
        int y1 = Integer.parseInt(arr[2]);
        int x2 = Integer.parseInt(arr[3]);
        int y2 = Integer.parseInt(arr[4]);
        if (firstChar == 'L') {
          canvas.drawLine(x1, y1, x2, y2);
        } else {
          canvas.drawRect(x1, y1, x2, y2);
        }
        System.out.println(canvas.toString());
      } else if (firstChar == 'B') {
        arr = str.split(" ");
        int x = Integer.parseInt(arr[1]);
        int y = Integer.parseInt(arr[2]);
        char color = arr[3].toCharArray()[0];
        canvas.fillArea(x, y, color);
        System.out.println(canvas.toString());
      }
    }
    System.exit(0);
  }

}
