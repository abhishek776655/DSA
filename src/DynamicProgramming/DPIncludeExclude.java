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

}
