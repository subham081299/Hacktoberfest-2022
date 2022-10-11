package BinaryTree;

public class MaximumPathSum {
    public static void main(String args[]) {

        TreeNode  root = new TreeNode(1);
        root . left = new TreeNode(3);
        root . left . left = new TreeNode(5);
        root . left . left . left = new TreeNode(7);
        root . right = new TreeNode(2);
        root . right . right = new TreeNode(4);
        root . right . right . right = new TreeNode(6);
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPath(max,root);
        System.out.println(max[0]);

    }
    public static int maxPath(int max[] , TreeNode root) // gives the path which will give the max value
    {
        if(root == null)return 0;

        int leftSum = Math.max(0 , maxPath(max,root.left)); // 0 because suppose the sum is comming nefgative then it will ignore it
        int rightSum = Math.max(0 , maxPath(max , root.right));
        max[0] = Math.max(max[0],leftSum + root.data + rightSum);
        return root.data + Math.max(leftSum , rightSum);
    }
}
