package BinaryTree;

import java.util.ArrayList;

public class RightView {
    static ArrayList<TreeNode> ans = new ArrayList<>();
    public static void main(String args[]) {

        TreeNode  root = new TreeNode(1);
        root . left = new TreeNode(3);
        root . left . left = new TreeNode(5);
        root . left . left . left = new TreeNode(7);
        root . right = new TreeNode(2);
        root . right . right = new TreeNode(4);
        root . right . right . right = new TreeNode(6);

        rightView(root,0);
        for(TreeNode node:ans)
        {
            System.out.print(node.data + " ");
        }
    }
    public static void rightView(TreeNode root,int level)
    {
        if(root == null)return;
        if(ans.size() == level)
        {
            ans.add(root);
        }
        rightView(root.right , level +1);
        rightView(root.left , level + 1);

    }
}
