package exercise3;

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
            countingAvg(size, arr);
        }
        in.close();
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

    private static void countingAvg(int size, int[] arr) {
        int sum = 0, count = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] < 0) {
                sum += arr[i];
                count++;
            }
        }
        if (sum == 0) {
            System.out.println("There are no negative elements");
        } else {
            System.out.println(sum / count);
        }

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
