package BinaryTree;

import java.util.ArrayList;

//Boundary Traversal is done in 3 steps:
/*

   1. Add left nodes
   2. Add leaf nodes
   3. Add Right nodes

 */
public class BoundaryTraversal {
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);

        if(!isLeaf(root1))ans.add(root1.data);

        addLeftBoundary(root1);
        addLeaves(root1);
        addRightBoundary(root1);
        System.out.println(ans);
    }
    public static boolean isLeaf(TreeNode root)
    {
        return (root.left == null && root.right == null);
    }
    public static void addLeftBoundary(TreeNode root) // Step 1
    {
        TreeNode curr = root.left;
        while (curr != null)
        {
            if(!isLeaf(curr))ans.add(curr.data);
            if(curr.left != null){
                curr = curr.left;
            }else {
                curr = curr.right;
            }
        }
    }

    public  static  void addLeaves(TreeNode root) // Step 2
    {
        if(isLeaf(root))
        {
            ans.add(root.data);
            return;
        }
        if(root.left != null)addLeaves(root.left);
        if (root.right != null) addLeaves(root.right);
    }

    public  static  void addRightBoundary(TreeNode root)//Step 3
    {
        /*
          Now here it is  frome bottom to upward direction therfore we will add the data in the list in reverse order
         */
        TreeNode cur = root.right;
        ArrayList < Integer > tmp = new ArrayList < Integer > ();
        while (cur != null) {
            if (isLeaf(cur) == false) tmp.add(cur.data);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        int i;
        for (i = tmp.size() - 1; i >= 0; --i) {
            ans.add(tmp.get(i));
        }
    }
}
