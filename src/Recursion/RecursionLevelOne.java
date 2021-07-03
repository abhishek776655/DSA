package Recursion;

import java.util.Scanner;

public class RecursionLevelOne {

	public static void ZigZag() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ZigZagHelper(n);

	}

	private static void ZigZagHelper(int n) {
		if (n == 0) {
			return;
		}
		System.out.print(n + " ");
		ZigZagHelper(n - 1);
		System.out.print(n + " ");
		ZigZagHelper(n - 1);
		System.out.print(n + " ");
	}

	public static void TowerOfHonoi() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int td1 = s.nextInt();
		int td2 = s.nextInt();
		int td3 = s.nextInt();
		TOHHelper(n, td1, td2, td3);

	}

	private static void TOHHelper(int n, int td1, int td2, int td3) {
		if (n == 0) {
			return;
		}
		TOHHelper(n - 1, td1, td3, td2);
		System.out.println(n + "[" + td1 + " -> " + td2 + "]");
		TOHHelper(n - 1, td3, td2, td1);

	}
}
