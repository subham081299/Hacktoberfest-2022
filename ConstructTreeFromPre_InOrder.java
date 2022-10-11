package BinaryTree;

import java.util.*;


public class ConstructTreeFromPre_InOrder {
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {
        int preorder[] = {10,20,40,50,30,60};
        int inorder[] = {40,20,50,10,60,30};
        TreeNode root = buildTree(preorder, inorder);
        Display_levelOrder(root);
        System.out.println(ans);
    }
    public static  TreeNode buildTree(int[] pre , int[] in)
    {
        if(in.length != pre.length)return null;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i<in.length ; i++)
        {
            map.put(in[i],i);
        }
        return createTree(pre , map , 0 , in.length-1);
    }
    static  int j = 0;
    public static TreeNode createTree(int[] pre , Map<Integer,Integer> map , int start , int end)
    {
        if(start>end)return null;
        TreeNode root = new TreeNode(pre[j]);
        int pos = map.get(pre[j++]);
        root.left = createTree(pre , map , start , pos - 1);
        root.right = createTree(pre ,map ,pos+1 , end);
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
