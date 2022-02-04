package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
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
        System.out.println("3. Substract");
        System.out.println("4. Change numbers");
        System.out.println("5. Exit");
        int i;
        i = scanner.nextInt();
        if (i < 1 | i > 5) {
            System.out.println("Option Out of bounds!!");
            System.out.println("Try Again!");
            i = main.ShowMenu(); // We use recursion to show again the menu if an invalid option is chosen.
        }
        return i;

    }

    public void EnterArguments() {
        try{
            Main main = new Main();
        System.out.print("Please enter the numbers you need for the operation separated by a comma: ");
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        List<Integer> intList = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        main.runCalculator(intList);}
        catch(NumberFormatException e){
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
                System.out.println(result);
                System.out.println("Done!");
            };
            sum.Calculate();
            main.runCalculator(intList);
        } else if (option == 2) {
            CalculateInterface multiplication = () -> {
                int x;
                x = intList.stream().reduce(1, (a, b) -> a * b);
                System.out.println(x);
                System.out.println("Done!");
            };
            multiplication.Calculate();
            main.runCalculator(intList);


        } else if (option == 3) {
            CalculateInterface subtraction = () -> {
                int x;
                x = intList.stream().reduce(0, (a, b) -> a - b);
                System.out.println(x);
                System.out.println("Done!");
            };
            subtraction.Calculate();
            main.runCalculator(intList);

        }
    else if (option == 4) {
            main.EnterArguments();

    }
    else if (option == 5) {
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

