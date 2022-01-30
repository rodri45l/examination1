package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@FunctionalInterface
interface CalculateInterface {
    void Calculate();
}

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the calculator!");
        Main main = new Main();
        String numbers = main.EnterArguments();
        List<Integer> intList = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        main.runCalculator(intList);

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
            i = main.ShowMenu();
        }
        return i;

    }

    public String EnterArguments() {
        System.out.println("Please enter the numbers you need for the operation separated by a comma");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

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
            String numbers = main.EnterArguments();
            List<Integer> intList2 = Arrays.stream(numbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            main.runCalculator(intList2);

    }else if (option == 5) {
            System.exit(0);
        }

    }
}

