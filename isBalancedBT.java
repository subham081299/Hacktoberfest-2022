package BinaryTree;
//Balanced binary Tree is the tree in which the differnece in number of nodes in left and right subtree is always 1
public class isBalancedBT {
    static boolean res =  true;
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);
        height(root1);
        if(res) System.out.println("Balanced");
        else System.out.println("Not Balanced");
    }

    public static int height(TreeNode root)
    {
        if(root == null)return 0;
        int lht = height(root.left);
        int  rht = height(root.right);
        if(lht == -1 || rht == -1){
            res = false;
            return -1;
        }
        if(Math.abs(lht-rht)>1){
            res = false;
            return -1;
        }
        return  1 + Math.max(lht,rht);
    }
}
