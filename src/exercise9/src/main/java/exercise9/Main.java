package exercise9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<User> users = new ArrayList<>();
        int count = inputCount(in);
        inputUser(in, count, users);
        List<String> res = filterList(users);
        if (!res.isEmpty()) {
            System.out.println(res);
        }

        in.close();
    }

    private static int inputCount(Scanner in) {
        int count = 0;
        boolean valid = false;
        while (!valid) {
            System.out.println("Enter the count of users:");
            String input = in.nextLine();
            count = Integer.parseInt(input);
            valid = count > 0;
            if (!valid) {
                System.out.println("Couldn't parse a number. Please, try again");
            }
        }
        return count;
    }

    private static void inputUser(Scanner in, int count, List<User> users) {
        for (int i = 0; i < count; i++) {
            String name = "";
            int age = 0;
            boolean validAge = false;
            System.out.println("Enter the name:");
            name = in.nextLine();
            while (!validAge) {
                System.out.println("Enter the age:");
                String ageInput = in.nextLine();
                try {
                    age = Integer.parseInt(ageInput);
                    if (age > 0) {
                        validAge = true; 
                    } else {
                        System.out.println("Incorrect input. Age must be greater than 0. Please try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Couldn't parse a number. Please, try again.");
                }
            }
    
            users.add(new User(name, age));
        }
    }

    private static List<String> filterList(List<User> users) {
        List<String> result = users.stream()
                .filter(user -> user.getAge() >= 18)
                .map(User::getName) // получение имен
                .collect(Collectors.toList()); // собираем в список
        return result;
    }

}

