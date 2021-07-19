package BinaryTree;

import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeBasics {

    public static node TreeConstructor(Integer[] arr) {
        node root = new node(arr[0], null, null);
        Pair rp = new Pair(root, 1);
        Stack<Pair> stk = new Stack<Pair>();
        stk.push(rp);
        int index = 0;
        while (stk.size() > 0) {
            Pair top = stk.peek();
            if (top.state == 1) {
                index++;
                if (arr[index] != null) {
                    top.node.left = new node(arr[index], null, null);

                    Pair p = new Pair(top.node.left, 1);
                    stk.push(p);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                index++;
                if (arr[index] != null) {
                    top.node.right = new node(arr[index], null, null);

                    Pair p = new Pair(top.node.right, 1);
                    stk.push(p);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                stk.pop();
            }
        }
        return root;
    }

    public static void display(node node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left == null ? "." : node.left.data + " ";
        str += "< - " + node.data + "- >";
        str += node.right == null ? "." : node.right.data + " ";
        System.out.println(str);
        display(node.left);
        display(node.right);

    }

    public static int size(node root) {
        if (root == null) {
            return 0;
        }
        int ts = size(root.left) + size(root.right) + 1;
        return ts;
    }

    public static int sum(node root) {
        if (root == null) {
            return 0;
        }
        int ts = sum(root.left) + sum(root.right) + root.data;
        return ts;
    }

    public static int max(node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int ts = Math.max(Math.max(max(root.left), max(root.right)), root.data);
        return ts;
    }

    public static int min(node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int ts = Math.min(Math.min(min(root.left), min(root.right)), root.data);
        return ts;
    }

    public static int height(node root) {
        if (root == null) {
            return -1; // -1 for edges , 0 for node
        }
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

    public static void traversal(node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + " in Preorder");
        traversal(root.left);
        System.out.println(root.data + " in Inorder");
        traversal(root.right);
        System.out.println(root.data + " in Postorder");

    }

    public static void levelOrderTraversal(node root) {
        Queue<node> q = new ArrayDeque<>();
        q.add(root);
        while (q.size() > 0) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                node temp = q.remove();
                System.out.print(temp.data);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }

            System.out.println();

        }
    }

    public static void iterativeTraversal(node root) {
        Stack<Pair> stk = new Stack<>();
        stk.push(new Pair(root, 1));
        while (stk.size() > 0) {
            Pair top = stk.peek();
            if (top.state == 1) {
                System.out.println(top.node.data + " Preorder");
                top.state++;
                if (top.node.left != null) {
                    stk.push(new Pair(top.node.left, 1));
                }
            } else if (top.state == 2) {
                System.out.println(top.node.data + " Inorder");
                top.state++;
                if (top.node.right != null) {
                    stk.push(new Pair(top.node.right, 2));
                }
            } else {
                System.out.println(top.node.data + " Postorder");
                stk.pop();
            }
        }
    }

    private static ArrayList<node> path = new ArrayList<>();

    public static Boolean findNode(node root, int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            path.add(root);
            return true;
        }
        if (findNode(root.left, data)) {
            path.add(root);
            return true;
        }
        if (findNode(root.right, data)) {
            path.add(root);
            return true;
        }
        return false;
    }

    public static void nodeToRoot(node root, int data) {
        if (findNode(root, data) == true) {
            System.out.print(path);
            return;
        }
        System.out.print("Not found");
    }

    public static void printKlevelsDown(node root, int k, node blocker) {
        if (k < 0 || root == null || root == blocker) {
            return;
        }
        if (k == 0) {
            System.out.print(root.data + " ");
            return;
        }

        printKlevelsDown(root.left, k - 1, null);
        printKlevelsDown(root.right, k - 1, null);
    }

    public static void printKFar(node root, int k, int data) {
        if (root == null) {
            return;
        }
        path = new ArrayList<>();
        findNode(root, data);
        for (int i = 0; i < path.size(); i++) {
            printKlevelsDown(path.get(i), k, path.get(i - 1));
        }
    }

    public static void nodeToLeaves(node root) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter lo and hi values");
        int lo = s.nextInt();
        int hi = s.nextInt();
        nodeToLeavesHelper(root, "", 0, lo, hi);
    }

    public static void nodeToLeavesHelper(node root, String path, int sum, int lo, int hi) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (lo <= root.data && root.data <= hi) {
                System.out.println(path + " ");
                return;
            }
            return;
        }
        nodeToLeavesHelper(root.left, sum + root.data + " ", sum + root.data, lo, hi);
        nodeToLeavesHelper(root.right, sum + root.data + " ", sum + root.data, lo, hi);
    }

    public static node leftCloneTree(node root) {
        if (root == null) {
            return root;
        }

        node lcr = leftCloneTree(root.left);
        node rcr = leftCloneTree(root.right);

        root.right = rcr;
        node nn = new node(root.data, lcr, null);
        root.left = nn;
        return root;
    }

    public static node transformBactFromLeftClone(node root) {

        if (root == null) {
            return root;
        }
        node l = transformBactFromLeftClone(root.left.left);
        node r = transformBactFromLeftClone(root.right);

        root.left = l;
        root.right = r;
        return root;
    }

    public static void printOnlyChild(node root, node parent) {
        if (root == null) {
            return;
        }
        if (parent.left == root && parent.right == null) {
            System.out.print(root.data + " ");
        } else if (parent.left == null && parent.right == root) {
            System.out.print(root.data + " ");

        }
        printOnlyChild(root.left, root);
        printOnlyChild(root.right, root);

    }

    public static node removeLeaves(node root) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);
        return root;
    }
}
