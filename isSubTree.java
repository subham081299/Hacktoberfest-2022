package BinaryTree;

public class isSubTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);

        TreeNode subroot = new TreeNode(2);
        subroot.left = new TreeNode(4);
        subroot.right = new TreeNode(5);


        System.out.println(CheckSub(root,subroot));
    }
    public  static boolean CheckSub(TreeNode root , TreeNode sub)
    {
        if(root == null)return false;
        if(root.data == sub.data)
        {
            if(isIdentical(root,sub))
            {
                return true;
            }
        }
        return CheckSub(root.left,sub) || CheckSub(root.right,sub);
    }

    public static boolean isIdentical(TreeNode root ,TreeNode sub)
    {
        if(root == null && sub == null)return true;
        if(root == null || sub == null || root.data != sub.data){
            return false;
        }
        if(!isIdentical(root.left ,sub.left))return false;
        if (!isIdentical(root.right , sub.right))return false;

        return true;

    }
}
