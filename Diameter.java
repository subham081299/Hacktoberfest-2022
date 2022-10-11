package BinaryTree;
import java.util.*;
public class Diameter {
    static int diameter = 0;
    public static void main(String args[]) {

        TreeNode  root = new TreeNode(1);
        root . left = new TreeNode(3);
        root . left . left = new TreeNode(5);
        root . left . left . left = new TreeNode(7);
        root . right = new TreeNode(2);
        root . right . right = new TreeNode(4);
        root . right . right . right = new TreeNode(6);

        height(root);
        System.out.println(diameter);
    }
    public static int height(TreeNode root)
    {
        if(root == null)return 0;
        int leftsideHeight = height(root.left);
        int rightsideHeight = height(root.right);

        diameter = Math.max(diameter , leftsideHeight + rightsideHeight + 1);

        return Math.max(leftsideHeight,rightsideHeight)+1;
    }
}
