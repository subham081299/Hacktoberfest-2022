package BinaryTree;

import java.util.*;

public class ConstructTreeFromPost_InOrder {
    static ArrayList<Integer> ans = new ArrayList<>();
    static  int j = 0;
    public static void main(String[] args) {
        int postorder[] = {9,15,7,20,3};
        int inorder[] = {9,3,15,20,7};
        TreeNode root = buildTree(postorder, inorder);
        Display_levelOrder(root);
        System.out.println(ans);
    }
    public static  TreeNode buildTree(int[] post , int[] in)
    {
        if(in.length != post.length)return null;
        j = post.length-1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i<in.length ; i++)
        {
            map.put(in[i],i);
        }
        return createTree(post , map , 0 , in.length-1);
    }

    public static TreeNode createTree(int[] post , Map<Integer,Integer> map , int start , int end)
    {
        if(start>end)return null;
        TreeNode root = new TreeNode(post[j]);
        int pos = map.get(post[j--]);
        root.right = createTree(post ,map ,pos+1 , end);
        root.left = createTree(post , map , start , pos - 1);

        return root;
    }


    public static  void Display_levelOrder(TreeNode root)
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
