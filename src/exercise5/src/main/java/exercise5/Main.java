package exercise5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n:");
        int size = input(in);
        if (size <= 0) {
            System.out.println("Input error. Size <= 0");
        } else {
            double[] arr = inputArray(in, size);
            double[] sort = selectionSort(arr, size);
            for (int i = 0; i < size; i++) {
                System.out.printf("%.1f ", sort[i]);
            }
        }
    }

    private static double[] selectionSort(double[] arr, int size) {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                double tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
        }
        return arr;
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

    private static double[] inputArray(Scanner in, int size) {
        double[] arr = new double[size];
        boolean valid = false;
        while (!valid) {
            String input1 = in.nextLine();
            String[] input = input1.split(" ");
            if (input.length != size) {
                System.out.println("Couldn't parse a number. Please, try again");
            } else {
                try {
                    for (int i = 0; i < size; i++) {
                        arr[i] = Double.parseDouble(input[i]);
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
