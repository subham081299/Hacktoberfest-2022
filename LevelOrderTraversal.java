package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String args[]) {

        TreeNode  root = new TreeNode(1);
        root . left = new TreeNode(3);
        root . left . left = new TreeNode(5);
        root . left . left . left = new TreeNode(7);
        root . right = new TreeNode(2);
        root . right . right = new TreeNode(4);
        root . right . right . right = new TreeNode(6);

        levelOrder(root);
        System.out.println(ans);

    }
    public static  void levelOrder(TreeNode root)
    {
        if(root == null)return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty())
        {
            TreeNode node = q.poll();
            ans.add(node.data);
            if(node.left != null)q.add(node.left);
            if(node.right != null)q.add(node.right);
        }
    }
}
