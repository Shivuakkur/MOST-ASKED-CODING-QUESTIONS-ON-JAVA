package com.employe.getData;

import java.util.Scanner;

public class BestBubble {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(minSwaps(arr));
    }

    public static int minSwaps(int[] arr) {
        int n = arr.length;
        int ascSwaps = 0;
        int descSwaps = 0;

        // Count swaps for ascending order
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                ascSwaps++;
            }
        }

        // Count swaps for descending order
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                descSwaps++;
            }
        }

        // Return the minimum swaps
        return Math.min(ascSwaps, descSwaps);
    }
}



