
package exercise0;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    private static double sideLength(double x1, double y1, double x2, double y2) {
        double length = 0;
        length = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return length;
    }

    private static double perimeter(double x1, double y1, double x2, double y2, double x3, double y3) {
        double p = 0, a = 0, b = 0, c = 0;
        a = sideLength(x1, y1, x2, y2);
        b = sideLength(x1, y1, x3, y3);
        c = sideLength(x3, y3, x2, y2);
        if (a != 0 && b != 0 && c != 0) {
            p = a + b + c;
        }
        return p;
    }

    private static double input(Scanner in, boolean valid) {
        double x = 0;
        while (!valid) {
            String input = in.nextLine();
            try {
                x = Double.parseDouble(input);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Couldn't parse a number. Please, try again");
            }
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0, y3 = 0;
        System.out.println("Enter the numbers:");
        boolean valid = false;

        x1 = input(in, valid);
        y1 = input(in, valid);
        x2 = input(in, valid);
        y2 = input(in, valid);
        x3 = input(in, valid);
        y3 = input(in, valid);
        DecimalFormat myFormat = new DecimalFormat("#.###");
        double p = perimeter(x1, y1, x2, y2, x3, y3);
        if (p != 0) {
            System.out.println("Perimeter: " + myFormat.format(perimeter(x1, y1, x2, y2, x3, y3)));
        } else {
            System.out.println("It isn't triangle");
        }
        in.close();
    }
}
