import java.util.*;

public class largestValueInBinaryTreeLevel {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> findLevelAverages(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int max = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                // add the node's value to the running sum
                max = Math.max(max, currentNode.val);
                // insert the children of current node to the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            // append the current level's average to the result array
            result.add(max);
        }

        return result;
    }

    public static void main(String[] args) {
        largestValueInBinaryTreeLevel sol = new largestValueInBinaryTreeLevel();
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Integer> result = sol.findLevelAverages(root);
        System.out.print("Level averages are: " + result);
    }
}
