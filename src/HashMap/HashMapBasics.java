package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapBasics {
    public static void highestFrequencyCharacter() {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) + 1);
            } else {
                hm.put(ch, 1);
            }
        }

        int maxFreq = 0;
        char maxChar = str.charAt(0);
        for (Character ch : hm.keySet()) {

            if (hm.get(ch) > maxFreq) {
                maxFreq = hm.get(ch);
                maxChar = ch;
            }
        }
        System.out.println(maxChar);

    }

    public static void getCommonElements() {
        Scanner scn = new Scanner(System.in);
        int n1, n2;
        n1 = scn.nextInt();
        n2 = scn.nextInt();
        ArrayList<Integer> arr1 = new ArrayList<Integer>(n1);
        ArrayList<Integer> arr2 = new ArrayList<Integer>(n1);

        for (int i = 0; i < n1; i++) {
            arr1.add(scn.nextInt());
        }
        for (int i = 0; i < n2; i++) {
            arr2.add(scn.nextInt());
        }

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n1; i++) {

            if (hm.containsKey(arr1.get(i))) {
                hm.put(arr1.get(i), hm.get(arr1.get(i)) + 1);
            } else {
                hm.put(arr1.get(i), 1);
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>(n1);

        for (int i = 0; i < n2; i++) {
            if (hm.containsKey(arr2.get(i))) {
                res.add(arr2.get(i));
                hm.remove(arr2.get(i));
            }
        }
        System.out.print(res);

    }

    public static void getCommonElementsTwo() {
        Scanner scn = new Scanner(System.in);
        int n1, n2;
        n1 = scn.nextInt();
        n2 = scn.nextInt();
        ArrayList<Integer> arr1 = new ArrayList<Integer>(n1);
        ArrayList<Integer> arr2 = new ArrayList<Integer>(n1);

        for (int i = 0; i < n1; i++) {
            arr1.add(scn.nextInt());
        }
        for (int i = 0; i < n2; i++) {
            arr2.add(scn.nextInt());
        }

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n1; i++) {

            if (hm.containsKey(arr1.get(i))) {
                hm.put(arr1.get(i), hm.get(arr1.get(i)) + 1);
            } else {
                hm.put(arr1.get(i), 1);
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>(n1);

        for (int i = 0; i < n2; i++) {
            if (hm.containsKey(arr2.get(i)) && hm.get(arr2.get(i)) > 0) {
                res.add(arr2.get(i));
                int g = hm.get(arr2.get(i));
                hm.put(arr2.get(i), g - 1);
            }
        }
        System.out.print(res);

    }

    public static void LongestConsecutiveSubSequence() {
        Scanner scn = new Scanner(System.in);

        int n1 = scn.nextInt();

        int[] arr = new int[n1];

        for (int i = 0; i < n1; i++) {
            arr[i] = scn.nextInt();
        }
        HashMap<Integer, Boolean> hm = new HashMap<>();

        for (int val : arr) {
            hm.put(val, true);
        }
        for (int val : arr) {
            if (hm.containsKey(val - 1)) {
                hm.put(val, false);
            }
        }
        int maxL = 0;
        int msp = 0;

        for (int val : arr) {
            if (hm.get(val) == true) {
                int lsp = val;
                int l = 1;
                while (hm.containsKey(val + l)) {
                    l++;
                }
                if (l > maxL) {
                    maxL = l;
                    msp = lsp;
                }
            }
        }
        System.out.println(msp);
    }
}
