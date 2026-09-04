public class Solution {

    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        // Helper method to perform in-order traversal and collect node values
        inOrder(root, inOrderList);

        // Check if the collected values are in strictly ascending order
        boolean isBST = true;
        int prev = inOrderList.get(0);

        for (int i = 1; i < inOrderList.size(); i++) {
            // If current element is less than or equal to previous, it's not a valid BST
            if (inOrderList.get(i) <= prev) {
                isBST = false;
                break;
            }
            prev = inOrderList.get(i);
        }

        return isBST;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val); // Add root value
        inOrder(root.right, list);
    }
}