package DynamicProgramming;

import java.util.Scanner;

public class DPIncludeExclude {

    public static void CountBinaryStrings() {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int oBuildingCount = 1;
        int oSpaceCount = 1;
        for (int i = 1; i < n; i++) {
            int newSpaceCount = oBuildingCount + oSpaceCount;
            int newBuildingCount = oSpaceCount;

            oSpaceCount = newSpaceCount;
            oBuildingCount = newBuildingCount;
        }
        System.out.print("Number of Strings are -> ");
        System.out.println(oSpaceCount + oBuildingCount);

    }

    public static void ArrangeBuilding() {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int oBuildingCount = 1;
        int oSpaceCount = 1;
        for (int i = 1; i < n; i++) {
            int newSpaceCount = oBuildingCount + oSpaceCount;
            int newBuildingCount = oSpaceCount;

            oSpaceCount = newSpaceCount;
            oBuildingCount = newBuildingCount;
        }
        System.out.print("Number of Ways are -> ");
        System.out.println((int) (Math.pow(oSpaceCount + oBuildingCount, 2)));

    }

    public static void DecodeWays() {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        System.out.println("Enter string");
        String str = s.next();
        int[] dp = new int[str.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (str.charAt(i) == '0' && str.charAt(i - 1) == '0') {
                dp[i] = 0;
            } else if (str.charAt(i) == '0' && str.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            } else if (str.charAt(i) != '0' && str.charAt(i - 1) == '0') {
                if (str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2') {
                    dp[i] = i >= 2 ? dp[i - 2] : 1;
                } else {
                    dp[i] = 0;
                }
            } else {
                int num = Integer.parseInt(str.substring(i - 1, i + 1));
                if (num <= 26) {
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                } else {
                    dp[i] = dp[i - 1];
                }

            }

        }
        System.out.print("Number of encodings possible -> ");
        System.out.println(dp[str.length() - 1]);

    }

    public static void subSequenceABC() {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        System.out.println("Enter string");
        String str = s.next();
        int a = 0;
        int ab = 0;
        int abc = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'a') {
                a = 2 * a + 1;
            } else if (c == 'b') {
                ab = 2 * ab + a;
            } else {
                abc = 2 * abc + ab;
            }
        }
        System.out.print("Number of subsequence possible ->");
        System.out.println(abc);
    }

    public static void MaximumNonConsecutiveSubset() {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n = s.nextInt();

        int[] arr = new int[n];
        int maxInclude = arr[0];
        int maxExclude = 0;
        System.out.println("Enter Array");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        for (int i = 1; i < n; i++) {
            int newMaxInclude = maxExclude + arr[i];
            int newMaxExclude = Math.max(maxExclude, maxInclude);

            maxExclude = newMaxExclude;
            maxInclude = newMaxInclude;
        }
        System.out.print("Maximum value-> ");
        System.out.println(Math.max(maxExclude, maxInclude));

    }

    public static void PaintHouseManyColors() {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of houses");
        int n = s.nextInt();
        System.out.println("Enter number of colors");
        int m = s.nextInt();
        System.out.println("Enter painting cost");
        int[][] colors = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                colors[i][j] = s.nextInt();
            }
        }
        int[][] dp = new int[n][m];
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            dp[0][j] = colors[0][j];
            if (dp[0][j] < least) {
                sleast = least;
                least = dp[0][j];
            } else if (dp[0][j] < sleast) {
                sleast = dp[0][j];
            }
        }

        for (int i = 1; i < n; i++) {
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if (dp[i - 1][j] == least) {
                    dp[i][j] = sleast + colors[i][j];
                } else {
                    dp[i][j] = least + colors[i][j];
                }
                if (dp[i][j] < nleast) {
                    nsleast = nleast;
                    nleast = dp[i][j];
                } else if (dp[i][j] < nsleast) {
                    nsleast = dp[i][j];
                }
            }
            least = nleast;
            sleast = nsleast;

        }
        System.out.print("Minimum cost to paint -> ");
        System.out.println(least);

    }

    public static void paintFence() {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of fence");
        int n = s.nextInt();
        System.out.println("Enter number of colors");
        int k = s.nextInt();
        int osame = k * 1;
        int odiff = k * (k - 1);
        int total = osame + odiff;
        for (int i = 2; i < n; i++) {
            osame = odiff;
            odiff = total * (k - 1);
            total = osame + odiff;
        }
        System.out.println("Possilbe number of ways to paint -> ");
        System.out.println(total);
    }
}
