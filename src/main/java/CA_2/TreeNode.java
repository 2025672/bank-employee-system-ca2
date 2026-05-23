package CA_2;

/**
 * Node for the employee hierarchy binary tree.
 * Stores name, manager type, and department from ApplicantRecord.
 */
public class TreeNode {

    private final ApplicantRecord data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(ApplicantRecord data) {
        this.data = data;
    }

    public ApplicantRecord getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
