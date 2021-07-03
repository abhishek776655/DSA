package DynamicProgramming;

import java.util.Scanner;

public class DPTabulation {

    public static void targetSumSubset() {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);

        System.out.println("Enter target");
        int target = s.nextInt();
        System.out.println("Enter size of array");
        int n = s.nextInt();
        boolean[][] dp = new boolean[n + 1][target + 1];
        int[] arr = new int[n];
        System.out.println("Enter array");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    if (dp[i - 1][j] == true) {
                        dp[i][j] = true;
                    } else {
                        int val = arr[i - 1];
                        if (j >= val) {
                            if (dp[i - 1][j - val] == true) {
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.print("Does subset exist? ");
        System.out.println(dp[n][target]);
    }

    public static void coinChangeCombination() {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);

        System.out.println("Enter amount to pay");
        int target = s.nextInt();
        System.out.println("Enter size of array");
        int n = s.nextInt();
        int[] dp = new int[target + 1];
        int[] arr = new int[n];
        System.out.println("Enter coin array");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= target; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }
        System.out.print("Number of ways amount can be paid -> ");
        System.out.println(dp[target]);

    }

    public static void coinChangePermutation() {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);

        System.out.println("Enter amount to pay");
        int target = s.nextInt();
        System.out.println("Enter size of array");
        int n = s.nextInt();
        int[] dp = new int[target + 1];
        int[] arr = new int[n];
        System.out.println("Enter coin array");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        dp[0] = 1;

        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j] <= i) {
                    dp[i] += dp[i - arr[j]];
                }
            }
        }
        System.out.print("Number of ways amount can be paid -> ");
        System.out.println(dp[target]);

    }

    public static void zeroOneKnapsack() {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Total Weight");
        int totalWeight = s.nextInt();

        System.out.println("Enter number of items");
        int n = s.nextInt();
        int weights[] = new int[n];
        int values[] = new int[n];

        System.out.println("Enter Weights");
        for (int i = 0; i < n; i++) {
            weights[i] = s.nextInt();
        }

        System.out.println("Enter Values");
        for (int i = 0; i < n; i++) {
            values[i] = s.nextInt();
        }
        int dp[][] = new int[n + 1][totalWeight + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= totalWeight; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (weights[i - 1] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        if (dp[i - 1][j] > dp[i - 1][j - weights[i - 1]] + values[i - 1]) {
                            dp[i][j] = dp[i - 1][j];
                        } else {
                            dp[i][j] = dp[i - 1][j - weights[i - 1]] + values[i - 1];
                        }
                    }
                }
            }
        }
        System.out.print("Maximum Value -> ");
        System.out.println(dp[n][totalWeight]);

    }

    public static void unboundedKnapSack() {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Total Weight");
        int totalWeight = s.nextInt();

        System.out.println("Enter number of items");
        int n = s.nextInt();
        int weights[] = new int[n];
        int values[] = new int[n];

        System.out.println("Enter Weights");
        for (int i = 0; i < n; i++) {
            weights[i] = s.nextInt();
        }

        System.out.println("Enter Values");
        for (int i = 0; i < n; i++) {
            values[i] = s.nextInt();
        }
        int dp[] = new int[totalWeight + 1];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= totalWeight; j++) {
                if (weights[i] > j) {
                    dp[j] = dp[j];
                } else {
                    if (dp[j] < dp[j - weights[i]] + values[i]) {
                        dp[j] = dp[j - weights[i]] + values[i];
                    }
                }
            }
        }
        System.out.print("Maximum Value -> ");
        System.out.println(dp[totalWeight]);

    }
}
