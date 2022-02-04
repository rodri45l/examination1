package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@FunctionalInterface
interface CalculateInterface {
    void Calculate();
}

public class Main {

    public static void main(String[] args) {
        System.out.println("           _            _       _             \n" +
                "          | |          | |     | |            \n" +
                "  ___ __ _| | ___ _   _| | __ _| |_ ___  _ __ \n" +
                " / __/ _` | |/ __| | | | |/ _` | __/ _ \\| '__|\n" +
                "| (_| (_| | | (__| |_| | | (_| | || (_) | |   \n" +
                " \\___\\__,_|_|\\___|\\__,_|_|\\__,_|\\__\\___/|_|   ");

        System.out.println("\n\nWelcome to our calculator!");
        Main main = new Main();
        main.EnterArguments();
    }

    public int ShowMenu() {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose one of the options showed below:");
        System.out.println("1. Add");
        System.out.println("2. Multiply");
        System.out.println("3. Subtract");
        System.out.println("4. Average");
        System.out.println("5. Change numbers");
        System.out.println("6. Exit");
        int i;
        i = scanner.nextInt();
        if (i < 1 | i > 6) {
            System.out.println("Option Out of bounds!!");
            System.out.println("Try Again!");
            i = main.ShowMenu(); // We use recursion to show again the menu if an invalid option is chosen.
        }
        return i;
    }

    public void PrintResult(Object result){
        System.out.println("Operation result: " + result + "\nDone!");
    }

    public void EnterArguments() {
        try {
            Main main = new Main();
            System.out.print("Please enter the numbers you need for the operation separated by a comma: ");
            Scanner scanner = new Scanner(System.in);
            String numbers = scanner.nextLine();
            List<Integer> intList = Arrays.stream(numbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            main.runCalculator(intList);
        } catch (NumberFormatException e) {
            System.out.println("Only numbers and commas allowed");
            EnterArguments();
        }
    }

    public void runCalculator(List<Integer> intList) {
        Main main = new Main();
        int option = main.ShowMenu();

        if (option == 1) {
            CalculateInterface sum = () -> {
                Integer result = intList.stream()
                        .mapToInt(Integer::intValue)
                        .sum();
                main.PrintResult(result);
            };
            sum.Calculate();
            main.runCalculator(intList);
        } else if (option == 2) {
            CalculateInterface multiplication = () -> {
                int result = intList.stream().reduce(1, (a, b) -> a * b);
                main.PrintResult(result);
            };
            multiplication.Calculate();
            main.runCalculator(intList);

        } else if (option == 3) {
            CalculateInterface subtraction = () -> {
                int result = intList.stream().reduce(0, (a, b) -> a - b);
                main.PrintResult(result);
            };

            subtraction.Calculate();
            main.runCalculator(intList);
        } else if (option == 4) {
            CalculateInterface averageInt = () -> {
                OptionalDouble result = intList
                        .stream()
                        .mapToInt(number -> number.intValue())
                        .average();

                main.PrintResult(result.getAsDouble());
            };

            averageInt.Calculate();
            main.runCalculator(intList);

        } else if (option == 5) {
            main.EnterArguments();
        } else if (option == 6) {
            System.out.println(" _   _                 _                      \n" +
                    "| | | |               | |                     \n" +
                    "| |_| |__   __ _ _ __ | | ___   _  ___  _   _ \n" +
                    "| __| '_ \\ / _` | '_ \\| |/ / | | |/ _ \\| | | |\n" +
                    "| |_| | | | (_| | | | |   <| |_| | (_) | |_| |\n" +
                    " \\__|_| |_|\\__,_|_| |_|_|\\_\\\\__, |\\___/ \\__,_|\n" +
                    "                             __/ |            \n" +
                    "                            |___/");
            System.exit(0); // Stops the execution of the code with no error messages
        }

    }
}

