package exercise7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter sequence:");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        boolean order = true, valid = true;
        checkOrder(input, order, valid);
        in.close();
    }

    private static boolean isValid(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void checkOrder(String input, boolean order, boolean valid) {
        int i1 = 0, i2 = 0, ordinalNumber = -1;
        if (input.isEmpty()) {
            valid = false;
        }
        while (!input.isEmpty() && order && valid) {
            int spaceIndex = input.indexOf(' '); // индекс 1 пробела
            if (spaceIndex != -1) {//пробел найден
                String part = input.substring(0, spaceIndex);
                input = input.substring(spaceIndex + 1);
                ordinalNumber++;
                valid = isValid(part);
                if (valid) {
                    i1 = Integer.parseInt(part);
                }
            } else {//пробела нет
                valid = isValid(input);
                if (valid) {
                    i1 = Integer.parseInt(input);
                    input = "";
                    ordinalNumber++;
                }
            }
            if (ordinalNumber >= 1 && i2 > i1) {
                order = false;
            }

            i2 = i1;
        }
        printResult(valid, order, ordinalNumber);
    }

    private static void printResult(boolean valid, boolean order, int ordinalNumber) {
        if (valid) {
            if (order) {
                System.out.println("The sequence is ordered");
            } else {
                System.out.println("The sequence is not ordered from the ordinal number of the number: " + ordinalNumber);
            }
        } else {
            if (ordinalNumber >= 0) {
                System.out.println("The sequence is ordered in ascending order");
            } else {
                System.out.println("Input error");
            }
        }
    }
}

