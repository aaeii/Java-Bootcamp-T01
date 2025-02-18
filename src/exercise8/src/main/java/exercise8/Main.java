package exercise8;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] argc) {
        Scanner in = new Scanner(System.in);
        int n = input(in);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextLine());
        }
        String substring = in.nextLine();
        List<String> res = findingSubstring(substring, list);
        if (!res.isEmpty()) {
            System.out.println(res);
        }
    }

    private static List<String> findingSubstring(String substring, List<String> list) {
        List<String> res = new ArrayList<>();
        int index = -1;
        for (String str : list) {
            index = str.indexOf(substring);
            if (index != -1) {
                res.add(str);
            }
        }
        return res;
    }

    private static int input(Scanner in) {
        int n = 0;
        boolean valid = false;
        while (!valid) {
            String nStr = in.nextLine();
            try {
                n = Integer.parseInt(nStr);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Couldn't parse a number. Please, try again");
            }
        }
        return n;
    }
}
