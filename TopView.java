package BinaryTree;
import  java.util.*;

public class TopView {
    static  ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String args[]) {

        TreeNode  root = new TreeNode(1);
        root . left = new TreeNode(3);
        root . left . left = new TreeNode(5);
        root . left . left . left = new TreeNode(7);
        root . right = new TreeNode(2);
        root . right . right = new TreeNode(4);
        root . right . right . right = new TreeNode(6);

        topView(root,0);
        System.out.println(ans);

    }

    public static  void topView(TreeNode root , int level)
    {
        TreeMap<Integer,TreeNode> map = new TreeMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root , 0));

        while (!q.isEmpty())
        {
            int horizontalDistance = q.peek().num;
            TreeNode curr = q.poll().node;

            map.putIfAbsent(horizontalDistance,curr);
            if(curr.left != null)q.add(new Pair(curr.left , horizontalDistance - 1));
            if(curr.right != null)q.add(new Pair(curr.right , horizontalDistance + 1));
        }
        for(Integer key:map.keySet())
        {
            ans.add(map.get(key).data);
        }
    }
}
