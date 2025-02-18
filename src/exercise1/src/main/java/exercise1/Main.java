package exercise1;

import java.util.Scanner;

public class Main {

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

    private static int[] convertSeconds(int sec) {
        int h = 0, m = 0, s = 0;
        h = sec / 3600;
        m = (sec % 3600) / 60;
        s = sec % 60;
        int[] arr = {h, m, s};
        return arr;
    }

    private static void output(int[] time) {
        int h = 0, m = 0, s = 0;
        h = time[0];
        m = time[1];
        s = time[2];
        System.out.printf("%02d:%02d:%02d\n", h, m, s);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int seconds = 0;
        System.out.println("Enter seconds:");
        seconds = input(in);
        if(seconds<0){
            System.out.println("Incorrect time");
        }
        else{
            int[] time = convertSeconds(seconds);
            output(time);
        }

        in.close();
    }
}
