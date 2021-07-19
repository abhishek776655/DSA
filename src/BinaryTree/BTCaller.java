package BinaryTree;

public class BTCaller {
    public static void main(String[] args) {
        Integer arr[] = { 2, 4, 5, null, null, 3, 52, null, null, null, 43, 32, null, 23, null, null, 32, null, null };
        node root = BinaryTreeBasics.TreeConstructor(arr);
        BinaryTreeBasics.display(root);

    }
}
