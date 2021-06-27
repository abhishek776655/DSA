package Recursion;

import java.util.Scanner;

public class RecursionLevelFour {

	public static void floodFill() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[][] maze = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				maze[i][j] = s.nextInt();
			}
		}
		boolean[][] visited = new boolean[n][m];
		floodFillHelper(maze, 0, 0, "", visited);
	}

	private static void floodFillHelper(int[][] maze, int row, int col, String psf, boolean[][] visited) {
		if (row < 0 || col < 0 || row == maze.length || col == maze[0].length || maze[row][col] == 1
				|| visited[row][col] == true) {
			return;
		}
		if (row == maze.length - 1 && col == maze[0].length - 1) {
			System.out.println(psf);
			return;
		}
		visited[row][col] = true;

		floodFillHelper(maze, row - 1, col, psf + "t", visited);

		floodFillHelper(maze, row, col - 1, psf + "l", visited);

		floodFillHelper(maze, row + 1, col, psf + "d", visited);

		floodFillHelper(maze, row, col + 1, psf + "r", visited);

		visited[row][col] = false;

	}

	public static void targetSumSubset() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int target = s.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {

			arr[i] = s.nextInt();

		}
		targetSubsetHelper(arr, 0, "", 0, target);

	}

	private static void targetSubsetHelper(int[] arr, int index, String ans, int val, int target) {

		if (arr.length == index) {
			if (val == target) {
				System.out.println(ans);
				return;

			}
			return;

		}
		targetSubsetHelper(arr, index + 1, ans + arr[index] + ",", val + arr[index], target);
		targetSubsetHelper(arr, index + 1, ans, val, target);
	}

	public static void NQueens() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		boolean chess[][] = new boolean[N][N];
		NQueensHelper(chess, 0, "");

	}

	private static boolean isQueenSafe(boolean[][] chess, int row, int col) {
		for (int i = row; i >= 0; i--) {
			if (chess[i][col] == true) {
				return false;
			}
		}
		for (int i = row, j = col; i >= 0 && j < chess.length; i--, j++) {
			if (chess[i][j] == true) {
				return false;
			}
		}
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (chess[i][j] == true) {
				return false;
			}
		}
		return true;

	}

	private static void NQueensHelper(boolean[][] chess, int row, String psf) {
		if (row >= chess.length) {
			System.out.println(psf + ".");
			return;

		}

		for (int i = 0; i < chess.length; i++) {
			if (isQueenSafe(chess, row, i) == true) {
				chess[row][i] = true;
				NQueensHelper(chess, row + 1, psf + row + "-" + i + ", ");
				chess[row][i] = false;
			}
		}
	}

	public static void KnightsTour() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int r = s.nextInt();
		int c = s.nextInt();
		int chess[][] = new int[N][N];
		KnightsTourHelper(chess, r, c, 1);

	}

	private static void KnightsTourHelper(int[][] chess, int r, int c, int move) {

		if (r < 0 || r >= chess.length || c < 0 || c >= chess.length || chess[r][c] > 0) {
			return;
		} else if (move == chess.length * chess.length) {
			chess[r][c] = move;
			displayBoard(chess);
			chess[r][c] = 0;
			return;
		}

		chess[r][c] = move;
		KnightsTourHelper(chess, r - 2, c + 1, move + 1);
		KnightsTourHelper(chess, r - 1, c + 2, move + 1);
		KnightsTourHelper(chess, r + 1, c + 2, move + 1);
		KnightsTourHelper(chess, r + 2, c + 1, move + 1);
		KnightsTourHelper(chess, r - 2, c - 1, move + 1);
		KnightsTourHelper(chess, r - 1, c - 2, move + 1);
		KnightsTourHelper(chess, r + 1, c - 2, move + 1);
		KnightsTourHelper(chess, r + 2, c - 1, move + 1);
		chess[r][c] = 0;

	}

	private static void displayBoard(int[][] chess) {
		int n = chess.length;
		System.out.println("Knights Tour");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(chess[i][j] + " , ");
			}
			System.out.println();
		}
	}

}
