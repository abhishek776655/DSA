package BinaryTree;

public class BinaryTreeLevelTwo {
    public static class DiaPair {
        int dia;
        int h;
    }

    public static DiaPair diameter(node root) {
        if (root == null) {
            DiaPair d = new DiaPair();
            d.dia = 0;
            d.h = -1;
            return d;
        }
        DiaPair ldia = diameter(root.left);
        DiaPair rdia = diameter(root.right);

        int maxHeight = Math.max(ldia.h, ldia.h) + 1;
        int f = ldia.h + rdia.h + 2;
        int dia = Math.max(Math.max(ldia.dia, rdia.dia), f);
        DiaPair r = new DiaPair();
        r.dia = dia;
        r.h = maxHeight;
        return r;
    }

    public static int tilt = 0;

    public static int tilt(node root) {
        if (root == null) {
            return 0;
        }
        int lt = tilt(root.left);
        int rt = tilt(root.right);

        tilt += Math.abs(lt - rt);
        return lt + rt;
    }
}