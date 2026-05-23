package CA_2;

/**
 * Holds the active employee hierarchy binary tree in memory.
 */
public class TreeDataStore {

    private static EmployeeBinaryTree tree;

    private TreeDataStore() {
    }

    public static void setTree(EmployeeBinaryTree newTree) {
        tree = newTree;
    }

    public static EmployeeBinaryTree getTree() {
        return tree;
    }

    public static boolean hasTree() {
        return tree != null && !tree.isEmpty();
    }

    public static void clear() {
        tree = null;
    }
}
