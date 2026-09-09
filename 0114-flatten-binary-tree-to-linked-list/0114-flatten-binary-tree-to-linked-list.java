class Solution {
    public void flatten(TreeNode root) {
        // Base case: If the root is null, there's nothing to flatten
        if (root == null) return;
        
        // Iterate through each node starting from root
        while (root != null) {
            
            // If the current node has a left child, process it
            if (root.left != null) {
                TreeNode left = root.left;
                TreeNode current = left;
                
                // Find the rightmost node in the left subtree
                while (current.right != null) {
                    current = current.right;
                }
                
                // Connect the original right subtree to the rightmost node of the left subtree
                current.right = root.right;
                
                // Move the left subtree to the right side and set left pointer to null
                root.left = null;
                root.right = left;
            }
            
            // Move to the next right node
            root = root.right;
        }
    }
}