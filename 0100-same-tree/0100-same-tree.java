class Solution {
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        // Queue to hold pairs of nodes to compare
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);

        // Loop till the queue is not empty
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();

            // Check for equality
            if (first == null && second == null) {
                continue;
            } else if (first == null || second == null || first.val != second.val) {
                return false;
            }

            // Add child nodes in matching order
            queue.add(first.left);
            queue.add(second.left);
            queue.add(first.right);
            queue.add(second.right);
        }

        return true;
    }
}