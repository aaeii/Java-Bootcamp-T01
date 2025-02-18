package exercise6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        double[] arr = null;
        System.out.println("Enter filename:");
        String filename = in.nextLine();
        Scanner fileIn = null;
        try {
            fileIn = new Scanner(new File(filename));
            arr = readFile(fileIn);
        } catch (FileNotFoundException e) {
            System.out.println("Input error. File isn't exist");
        }
        if (fileIn != null) {
            fileIn.close();
        }
        if (arr != null) {
            printArray(arr);
            double max = findMax(arr), min = findMin(arr);
            try (FileWriter res = new FileWriter("result.txt", false)) {// append:false для перезаписи
                res.write(min + " " + max);
            }
        }
        in.close();
    }

    private static double[] readFile(Scanner fileIn) {
        double[] arr = null;
        if (fileIn.hasNextLine()) {
            int size = Integer.parseInt(fileIn.nextLine());
            if (size <= 0) {
                System.out.println("Input error. Size <= 0");
            } else {
                arr = new double[size];
                if (fileIn.hasNextLine()) {
                    String[] values = fileIn.nextLine().split(" "); // разбиваем по пробелам
                    int count = 0;
                    for (String value : values) {
                        try {
                            arr[count] = Double.parseDouble(value);
                            count++;
                        } catch (NumberFormatException ignored) {
                        }
                    }
                    if (count < size) {
                        System.out.println("Input error. Insufficient number of elements");
                        arr = null;
                    }
                }
            }
        }
        return arr;
    }

    private static void printArray(double[] arr) {
        if (arr != null) {
            System.out.println(arr.length);
            for (double value : arr) {
                System.out.print(value + " ");
            }
            System.out.println("\nSaving min and max values in file");
        }
    }

    private static double findMax(double[] arr) {
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static double findMin(double[] arr) {
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
