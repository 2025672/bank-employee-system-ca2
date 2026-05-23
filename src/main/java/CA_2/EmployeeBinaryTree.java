package CA_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary tree for bank employee hierarchy.
 * Inserts nodes using level-order (breadth-first): left child first, then right.
 */
public class EmployeeBinaryTree {

    public static final int MINIMUM_RECORDS = 20;

    private TreeNode root;

    public EmployeeBinaryTree() {
        this.root = null;
    }

    /**
     * Builds the tree from all records using level-order insertion.
     */
    public void buildFromRecords(ArrayList<ApplicantRecord> records) {
        root = null;
        for (ApplicantRecord record : records) {
            insertLevelOrder(record);
        }
    }

    /**
     * Level-order insertion: fill left child, then right, then move to next node in the queue.
     */
    public void insertLevelOrder(ApplicantRecord record) {
        TreeNode newNode = new TreeNode(record);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.getLeft() == null) {
                current.setLeft(newNode);
                return;
            }
            if (current.getRight() == null) {
                current.setRight(newNode);
                return;
            }

            queue.add(current.getLeft());
            queue.add(current.getRight());
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    /** Total number of nodes in the tree. */
    public int getNodeCount() {
        return countNodes(root);
    }

    private int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
    }

    /** Height of the tree (empty tree = 0). */
    public int getHeight() {
        return calculateHeight(root);
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = calculateHeight(node.getLeft());
        int rightHeight = calculateHeight(node.getRight());
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
