package exercise2;

import java.util.Scanner;

public class Main {
    private static boolean isValid(String input) {
        try {
            int n = Integer.parseInt(input);
            return n >= 1;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    private static int input(Scanner in) {
        boolean valid = false;
        int n = 0;
        while (!valid) {
            String input = in.nextLine();
            valid = isValid(input);
            if (valid) {
                n = Integer.parseInt(input);
            } else {
                System.out.println("Couldn't parse a number. Please, try again");
            }
        }
        return n;
    }

    private static int fib(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = input(in);
        if (n >= 47) {
            System.out.println("Too large n");
        } else {
            int res = fib(n);
            System.out.println(res);
        }
        in.close();
    }
}
