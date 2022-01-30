package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@FunctionalInterface
interface CalculateInterface {
    void Calculate();
}

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        String numbers = main.EnterArguments();
        ArrayList<String> numberList = new ArrayList<>(Arrays.asList(numbers.split(",")));
        ArrayList<Integer> intList = main.arrayListToInt(numberList);
        int option = main.ShowMenu();

        if (option == 1) {
            CalculateInterface sum = () -> {
                Integer result = intList.stream()
                        .mapToInt(Integer::intValue)
                        .sum();
                System.out.println(result);
            };
            sum.Calculate();
        } else if (option == 2) {
            CalculateInterface multiplication = () -> {
                int x;
                x = intList.stream().reduce(0, (a, b) -> a * b);
                System.out.println(x);
            };
            multiplication.Calculate();


        } else if (option == 3) {
            CalculateInterface substraction = () -> {
                int x;
                x = intList.stream().reduce(0, (a, b) -> a - b);
                System.out.println(x);
            };
            substraction.Calculate();

        }
        System.out.println("Done!");
    }

    public int ShowMenu() {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose one of the options showed below:");
        System.out.println("1. Add");
        System.out.println("2. Multiply");
        System.out.println("3. Substract");
        int i;
        i = scanner.nextInt();
        if (i < 1 | i > 3) {
            i = main.ShowMenu();
        }
        return i;

    }

    public String EnterArguments() {
        System.out.println("Welcome to the calculator!");
        System.out.println("Please enter the numbers you need for the operation separated by a comma");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    public ArrayList<Integer> arrayListToInt(ArrayList<String> rawNumbers) {
        ArrayList<Integer> ints = new ArrayList<>();
        rawNumbers.forEach(strNumb -> ints.add(Integer.parseInt(strNumb)));
        return ints;


    }


}
