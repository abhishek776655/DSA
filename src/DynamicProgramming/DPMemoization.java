package DynamicProgramming;

import java.util.Scanner;

public class DPMemoization {

    public static void FibonaciMemoized() {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] qb = new int[n + 1];
        int fibn = FibonaciMemoizedHelper(n, qb);
        System.out.println(fibn);
    }

    private static int FibonaciMemoizedHelper(int n, int[] qb) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (qb[n] != 0) {
            return qb[n];
        }
        int fib1 = FibonaciMemoizedHelper(n - 1, qb);
        int fib2 = FibonaciMemoizedHelper(n - 2, qb);
        int fib = fib1 + fib2;
        qb[n] = fib;
        return fib;
    }

    public static void countStairPathsMemoization() {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] qb = new int[n + 1];
        int count = countStairPathsMemoizationHelper(n, qb);
        System.out.println(count);

    }

    private static int countStairPathsMemoizationHelper(int n, int[] qb) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        if (qb[n] > 0) {
            return qb[n];
        }
        int path1 = countStairPathsMemoizationHelper(n - 1, qb);
        int path2 = countStairPathsMemoizationHelper(n - 2, qb);
        int path3 = countStairPathsMemoizationHelper(n - 3, qb);

        int paths = path1 + path2 + path3;

        qb[n] = paths;
        return paths;
    }

    public static void countStairPathsTabular() {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] qb = new int[n + 1];
        qb[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                qb[i] = qb[i - 1];
            } else if (i == 2) {
                qb[i] = qb[i - 1] + qb[i - 2];
            } else {
                qb[i] = qb[i - 1] + qb[i - 2] + qb[i - 3];
            }
        }
        System.out.println(qb[n]);
    }

    public static void countStairPathsVarJumpsTabular() {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of stairs");
        int n = s.nextInt();
        int[] dp = new int[n + 1];
        int[] arr = new int[n];
        System.out.println("Enter Jump Array");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                dp[i] = dp[i] + dp[i + j];
            }
        }
        System.out.println("number of paths");
        System.out.println(dp[0]);

    }

    public static void minimumJumpsTabular() {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of stairs");
        int n = s.nextInt();
        Integer[] dp = new Integer[n + 1];
        int[] arr = new int[n];
        System.out.println("Enter Jump Array");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                    if (dp[i + j] != null) {
                        min = Math.min(min, dp[i + j]);
                    }
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                }
            }
        }
        System.out.println(dp[0]);
    }

    public static void minimumCostPath() {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();
        int[][] dp = new int[n][m];
        int[][] arr = new int[n][m];
        System.out.println("Enter cost matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.nextInt();
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == n - 1) {
                    dp[i][j] = dp[i][j + 1] + arr[i][j];
                } else if (j == m - 1) {
                    dp[i][j] = dp[i + 1][j] + arr[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + arr[i][j];
                }
            }
        }
        System.out.println("Minimum Cost");
        System.out.println(dp[0][0]);

    }

    public static void maxGoldMine() {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();
        int[][] dp = new int[n][m];
        int[][] arr = new int[n][m];
        System.out.println("Enter cost matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.nextInt();
            }
        }
        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                if (j == m - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == 0) {
                    dp[i][j] = Math.min(arr[i][j + 1], arr[i + 1][j + 1]) + arr[i][j];
                } else if (i == n - 1) {
                    dp[i][j] = Math.min(arr[i][j + 1], arr[i - 1][j + 1]) + arr[i][j];
                } else {
                    dp[i][j] = Math.min(Math.min(arr[i][j + 1], arr[i + 1][j + 1]), arr[i - 1][j + 1]) + arr[i][j];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i][0]);
        }
        System.out.print("Maximum gold that can be obtained is -> ");
        System.out.println(max);

    }
}
