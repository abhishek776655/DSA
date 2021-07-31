package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HeapBasics {
    public static void kthLargest() {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        int n1 = scn.nextInt();

        int[] arr = new int[n1];

        for (int i = 0; i < n1; i++) {
            arr[i] = scn.nextInt();
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < n1; i++) {
            if (pq.peek() < arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
        }
        for (int val : pq) {
            System.out.print(val);
        }
    }

    public static void kSortedArray() {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        int n1 = scn.nextInt();

        int[] arr = new int[n1];

        for (int i = 0; i < n1; i++) {
            arr[i] = scn.nextInt();
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k + 1; i < n1; i++) {
            System.out.println(pq.remove());
            pq.add(arr[i]);
        }
        while (pq.size() > 0) {
            System.out.println(pq.remove());
        }
    }

    public static class Pair implements Comparable<Pair> {
        int li;
        int di;
        int val;

        Pair(int li, int di, int val) {
            this.li = li;
            this.di = di;
            this.val = val;
        }

        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }

    public static void mergeKlist() {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        int n1 = scn.nextInt();

        int[][] arr = new int[k][n1];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n1; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            Pair np = new Pair(i, 0, arr[i][0]);
            pq.add(np);
        }
        while (pq.size() > 0) {
            Pair p = pq.remove();
            res.add(p.val);
            p.di++;
            if (p.di < arr[p.li].length) {
                int val = arr[p.li][p.di];
                p.val = val;
                pq.add(p);
            }
        }
        System.out.println(res);
    }
}
