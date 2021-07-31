package Heap;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPriorityQueue {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianPriorityQueue() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void add(int val) {
        if (right.size() > 0 && right.peek() < val) {
            right.add(val);
        } else {
            left.add(val);
        }
        if (left.size() - right.size() >= 2) {
            int k = left.remove();
            right.add(k);
        } else if (right.size() - left.size() >= 2) {
            int k = right.remove();
            left.add(k);
        }

    }

    public int peek() {
        if (this.size() == 0) {
            System.out.println("underflow");
            return -1;
        }
        if (left.size() >= right.size()) {
            return left.peek();
        }
        return right.peek();
    }

    public int remove() {
        if (this.size() == 0) {
            System.out.println("underflow");
            return -1;
        }
        if (left.size() >= right.size()) {
            return left.remove();
        }
        return right.remove();
    }

    public int size() {
        return left.size() + right.size();
    }
}
