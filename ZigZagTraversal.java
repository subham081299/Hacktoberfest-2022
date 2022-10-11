package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal {
    /*
       So in Zig Zag Traversal move from left to right then right to left alternatively
     */
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);

        zigzag(root1);
        System.out.println(ans);
    }

    public static void zigzag(TreeNode root)
    {
        if(root == null)return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean f = true;
        while(!q.isEmpty())
        {
            ArrayList<Integer> lst = new ArrayList<>();
            int size = q.size();
            while (size-->0)
            {
                if(q.peek().left != null)q.add(q.peek().left);
                if(q.peek().right != null)q.add(q.peek().right);
                if(f){
                    lst.add(q.poll().data);
                }
                else {
                    lst.add(0 , q.poll().data);
                }
            }
            f = !f;
            ans.add(lst);
        }
    }
}
