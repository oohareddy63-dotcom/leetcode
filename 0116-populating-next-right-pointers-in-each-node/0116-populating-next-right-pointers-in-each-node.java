import java.util.LinkedList;
import java.util.Queue;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        // Base case: If tree is empty or contains only a single node
        if (root == null || root.left == null) {
            return root;
        }

        Queue<Node> q = new LinkedList<>();
        // Push root node and a null delimiter to mark the end of the first level
        q.add(root);
        q.add(null);

        Node prev = null; // Tracks the previous node in the current level

        while (!q.isEmpty()) {
            Node curr = q.poll(); // Pop front node

            if (curr == null) { // Reached end of current level
                if (q.isEmpty()) {
                    break; // All levels processed
                }
                q.add(null); // Mark end of the next level
            } else {
                // Push children to the queue
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }

                // If previous node exists in current level, set its next pointer
                if (prev != null) {
                    prev.next = curr;
                }
            }

            // Update previous pointer for the next iteration
            prev = curr;
        }

        return root;
    }
}