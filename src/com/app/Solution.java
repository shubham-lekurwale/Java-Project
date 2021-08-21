package com.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static final int MAX_PAIR_EXIT_LIMIT = 1000000000;

    public static void main(String[] args) {
        System.out.println("\nCrossing peoples count: " + solution(readInputs()));
    }

    private static int[] readInputs() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> elements = new ArrayList<>();
        in:
        while (true) {
            try {
                System.out.println("Choose Option");
                System.out.println("1. Add element (1 For West And 0 For East)");
                System.out.println("2. Exit");
                String in = br.readLine();
                switch (in) {
                    case "1":
                        System.out.println("Enter value: ");
                        String val = br.readLine();
                        if (val.equalsIgnoreCase("1") || val.equalsIgnoreCase("0"))
                            elements.add(Integer.parseInt(val));
                        break;
                    case "2":
                        break in;
                    default:
                        System.out.println("Please enter valid option");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return elements.stream().mapToInt(e -> e).toArray();
    }

    public static int solution(int[] A) {
        int pairCount = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++)
                pairCount = checkIsPersonCrossing(A[j], A[i]) ? pairCount + 1 : pairCount;
        }
        return pairCount > MAX_PAIR_EXIT_LIMIT ? -1 : pairCount;
    }

    private static boolean checkIsPersonCrossing(int first, int next) {
        return first < next && first != next;
    }
}
