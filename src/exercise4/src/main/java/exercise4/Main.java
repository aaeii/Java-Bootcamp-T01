package exercise4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n:");
        int size = input(in);
        if (size <= 0) {
            System.out.println("Input error. Size <= 0");
        } else {
            int[] arr = inputArray(in, size);
            if (!firstLastElem(size, arr)) {
                System.out.println("There are no such elements");
            }
        }
        in.close();
    }

    private static boolean firstLastElem(int size, int[] arr) {
        int first = 0, last = 0;
        boolean find = false;
        for (int i = 0; i < size; i++) {
            if (arr[i] < 0) {
                arr[i] *= -1;
            }
            first = arr[i];
            while (first >= 10) {
                first = first / 10;
            }
            last = arr[i] % 10;
            if (first == last) {
                find = true;
                System.out.printf("%d ", arr[i]);
            }
        }
        return find;
    }

    private static int input(Scanner in) {
        boolean valid = false;
        int n = 0;
        while (!valid) {
            String input = in.nextLine();
            try {
                n = Integer.parseInt(input);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Couldn't parse a number. Please, try again");
            }
        }
        return n;
    }

    private static int[] inputArray(Scanner in, int size) {
        int[] arr = new int[size];
        boolean valid = false;
        while (!valid) {
            String input1 = in.nextLine();
            String[] input = input1.split(" ");
            if (input.length != size) {
                System.out.println("Couldn't parse a number. Please, try again");
            } else {
                try {
                    for (int i = 0; i < size; i++) {
                        arr[i] = Integer.parseInt(input[i]);
                    }
                    valid = true;
                } catch (NumberFormatException e) {
                    System.out.println("Couldn't parse a number. Please, try again");
                }
            }
        }
        return arr;
    }
}
