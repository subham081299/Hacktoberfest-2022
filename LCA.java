package BinaryTree;

import java.security.PublicKey;

/*
LCA Lowest Common Ancestor:
Naive Approach -  List down  the nodes check from the back the common node
 */
public class LCA {
    public static void main(String args[]) {

        TreeNode  root = new TreeNode(1);
        root . left = new TreeNode(3);
        root . left . left = new TreeNode(5);
        root . left . left . left = new TreeNode(7);
        root . right = new TreeNode(2);
        root . right . right = new TreeNode(4);
        root . right . right . right = new TreeNode(6);

        System.out.println(LCA(root , 4,6).data);

    }
    public static  TreeNode LCA(TreeNode root , int v1 ,int v2)
    {
        if(root == null)return null;
        if(root.data == v1 || root.data == v2)return root;

        TreeNode left = LCA(root.left , v1,v2);
        TreeNode right = LCA(root.right , v1,v2);

        if(left == null)return right;
        if(right == null)return left;
        return root;

    }
}
