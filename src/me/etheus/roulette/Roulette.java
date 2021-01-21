package me.etheus.roulette;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Made by Ethan Richards
 * November 06, 2020
 */
public class Roulette {

    private static final int[] greenTiles = { 0, 37 }; // 37 represents '00'
    private static final int[] redTiles = { 1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36 };
    private static final int[] blackTiles = { 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35 };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter how many trials you would like to run: ");
        int trials = input.nextInt();

        Random random = ThreadLocalRandom.current();
        List<Integer> greens = new ArrayList<>();
        List<Integer> reds = new ArrayList<>();
        List<Integer> blacks = new ArrayList<>();

        for(int i = 0; i < trials; i++) {
            System.out.print("TRIAL " + (i + 1) + ": ");

            int number = random.nextInt(38);

            for(int green : greenTiles) {
                if(number == green) {
                    System.out.println("Green with " + number);
                    greens.add(number);
                }
            }

            for(int black : blackTiles) {
                if(number == black) {
                    System.out.println("Black with " + number);
                    blacks.add(number);
                }
            }

            for(int red : redTiles) {
                if(number == red) {
                    System.out.println("Red with " + number);
                    reds.add(number);
                }
            }
        }

        Collections.sort(greens);
        Collections.sort(blacks);
        Collections.sort(reds);

        System.out.println("-----------------");
        System.out.println("Results after " + trials + " trials:");
        System.out.println("Green total: " + greens.size());
        System.out.println("Red total: " + reds.size());
        System.out.println("Black total: " + blacks.size());
        System.out.println("-----------------");
        System.out.println("ALL GREENS");
        greens.forEach(System.out::println);
        System.out.println("-----------------");
        System.out.println("ALL BLACKS");
        blacks.forEach(System.out::println);
        System.out.println("-----------------");
        System.out.println("ALL REDS");
        reds.forEach(System.out::println);
        System.out.println("-----------------");
    }
}
