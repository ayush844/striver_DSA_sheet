import java.util.*;
//import java;

public class Medium {

     class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
     }

    class Pair<T, U> {
        public T first;
        public U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getKey(){
            return first;
        }

        public U getValue(){
            return second;
        }
    }

     /// ////////////////////////////////////////////////////////////////////////////////////////////////////

     // Given the root of a binary tree, return its maximum depth.
     //A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     //


    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1 + Math.max(lh, rh);
    }

    //Time Complexity: O(N) where N is the number of nodes in the Binary Tree. This complexity arises from visiting each node exactly once during the traversal to determine the maximum depth.
    //
    //Space Complexity: O(N) where N is the number of nodes in the Binary Tree because in the worst case scenario the tree is balanced and has N/2 nodes in its last level which will have to be stored in the queue.

    /// ////////////////////////////////////////////////////////////////////////////////////////////////////


    // Problem Statement: Given a Binary Tree, return true if it is a Balanced Binary Tree else return false. A Binary Tree is balanced if, for all nodes in the tree, the difference between left and right subtree height is not more than 1.

    // Function to calculate the maximum depth of the tree while checking if it is balanced
    public int maxDepth2(TreeNode root) {
        // Base case: If the node is null, return 0 (height of an empty tree is 0)
        if (root == null){
            return 0;
        }

        // Recursively calculate the depth of the left and right subtrees
        int lh = maxDepth2(root.left);
        int rh = maxDepth2(root.right);

        // If any subtree is already unbalanced (-1 is returned), propagate the -1 upwards
        if (lh == -1 || rh == -1){
            return -1;
        }

        // If the height difference between left and right subtrees is more than 1, return -1 (unbalanced)
        if (Math.abs(lh - rh) > 1){
            return -1;
        }

        // Return the height of the current node, which is 1 + max(left subtree height, right subtree height)
        return 1 + Math.max(lh, rh);
    }

    // Function to check if a tree is balanced
    public boolean isBalanced(TreeNode root) {
        // Call maxDepth2 to check balance condition
        int ans = maxDepth2(root);

        // If maxDepth2 returns -1, the tree is unbalanced; otherwise, it is balanced
        return ans != -1;
    }

    //Time Complexity: O(N) where N is the number of nodes in the Binary Tree. This complexity arises from visiting each node exactly once during the postorder traversal.
    //
    //Space Complexity : O(1) as no additional space or data structures is created that is proportional to the input size of the tree. O(H) Recursive Stack Auxiliary Space : The recursion stack space is determined by the maximum depth of the recursion, which is the height of the binary tree denoted as H. In the balanced case it is log2N and in the worst case its N.


    /// ////////////////////////////////////////////////////////////////////////////////////////////////////

    // Given the root of a binary tree, return the length of the diameter of the tree.
    //The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
    //The length of a path between two nodes is represented by the number of edges between them.



    // Helper function to compute the height of the tree while updating the diameter
    public int findMax(TreeNode root, int[] diameter) {
        // Base case: if the node is null, return height as 0
        if (root == null) {
            return 0;
        }

        // Recursively find the height of the left subtree
        int lh = findMax(root.left, diameter);
        // Recursively find the height of the right subtree
        int rh = findMax(root.right, diameter);

        // Update the maximum diameter found so far
        // Diameter at this node = left subtree height + right subtree height
        diameter[0] = Math.max(diameter[0], lh + rh);

        // Return the height of the subtree rooted at the current node
        // Height of a node = 1 (itself) + max height of left or right subtree
        return 1 + Math.max(lh, rh);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        // Array to store the maximum diameter (since Java does not allow pass-by-reference for primitives)
        int[] diameter = new int[1];
        diameter[0] = 0;

        // Call the recursive function to compute height and update diameter
        int height = findMax(root, diameter);

        // Return the maximum diameter found
        return diameter[0];
    }


// Why does using an int variable not work, but using an int[] array does?
//In Java, primitive types (int, double, etc.) are passed by value, meaning changes inside a function do not affect the original variable.
//When you use int diameter instead of int[] diameter, any updates inside findMax to diameter will not be reflected in the calling function (diameterOfBinaryTree).
//However, an array (int[] diameter) is an object and is passed by reference, so modifications to diameter[0] inside findMax persist across function calls.


    // Time Complexity: O(N) where N is the number of nodes in the Binary Tree. This complexity arises from visiting each node exactly once during the postorder traversal.
    //
    //Space Complexity : O(1) as no additional space or data structures is created that is proportional to the input size of the tree. O(H) Recursive Stack Auxiliary Space : The recursion stack space is determined by the maximum depth of the recursion, which is the height of the binary tree denoted as H. In the balanced case it is log2N and in the worst case its N.


    /// ////////////////////////////////////////////////////////////////////////////////////////////////////

//Given the roots of two binary trees p and q, write a function to check if they are the same or not.
//
//Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.


    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If either of the nodes is null, check if both are null
        // If both are null, they are the same; otherwise, they are different
        if (p == null || q == null) {
            return p == q; // Returns true if both are null, false otherwise
        }

        // Check if the current nodes have the same value
        // Recursively check if the left subtrees are the same
        // Recursively check if the right subtrees are the same
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

//Time Complexity: O(N+M) where N is the number of nodes in the first Binary Tree and M is the number of nodes in the second Binary Tree. This complexity arises from visiting each node of the two binary nodes during their comparison.
//
//Space Complexity: O(1) as no additional space or data structures is created that is proportional to the input size of the tree. O(H) Recursive Stack Auxiliary Space : The recursion stack space is determined by the maximum depth of the recursion, which is the height of the binary tree denoted as H. In the balanced case it is log2N and in the worst case (its N).

    /// ////////////////////////////////////////////////////////////////////////////////////////////////////


// Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;  // Return an empty list if the tree is empty
        }

        Queue<TreeNode> nodesQueue = new LinkedList<>(); // Queue for BFS traversal
        nodesQueue.add(root); // Start with the root node

        boolean leftToRight = true; // Toggle direction for zigzag traversal

        while (!nodesQueue.isEmpty()) {
            int size = nodesQueue.size(); // Number of nodes at current level
            List<Integer> row = new ArrayList<>(); // List to store current level nodes

            for (int i = 0; i < size; i++) {
                TreeNode node = nodesQueue.poll(); // Remove node from queue
                row.add(node.val);  // Add node value to the row list

                // Add left and right children to the queue if they exist
                if (node.left != null) {
                    nodesQueue.add(node.left);
                }
                if (node.right != null) {
                    nodesQueue.add(node.right);
                }
            }

            if (!leftToRight) {
                Collections.reverse(row); // Reverse order for right-to-left levels
            }

            result.add(row); // Add current level's row to the final result
            leftToRight = !leftToRight; // Toggle direction for the next level
        }

        return result;
    }


    //Time Complexity Analysis:
    //Each node is processed once, so the time complexity is O(N), where N is the number of nodes in the tree.
    //Reversing a list takes O(K), where K is the number of elements in that level.
    //In the worst case, this could be O(N), but since the sum of all levels is N, the overall complexity remains O(N).
    //Space Complexity Analysis:
    //The queue stores nodes level-wise, at most O(N/2) = O(N) in the worst case (last level of a full binary tree).
    //The result list stores all node values, so it takes O(N) space.
    //Reversing a list requires O(K) extra space, but it doesn’t change the overall complexity.
    //Thus, the overall space complexity is O(N).
    //
    // Final Complexity:
    //Time Complexity: O(N)
    //Space Complexity: O(N)



    /// ////////////////////////////////////////////////////////////////////////////////////////////////////

    // A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
    //The path sum of a path is the sum of the node's values in the path.
    //Given the root of a binary tree, return the maximum path sum of any non-empty path.

    public int findMaxPathSum(TreeNode root, int[] maxi){

        if (root == null){
            return 0;
        }

        // Calculate the maximum path sum
        // for the left and right subtrees
        int leftMaxPath = Math.max(0, findMaxPathSum(root.left, maxi));
        int rightMaxPath = Math.max(0, findMaxPathSum(root.right, maxi));

        // Update the overall maximum
        // path sum including the current node
        maxi[0] = Math.max(maxi[0], leftMaxPath + rightMaxPath + root.val);

        // Return the maximum sum considering
        // only one branch (either left or right)
        // along with the current node
        return Math.max(leftMaxPath, rightMaxPath) + root.val;

    }


    public int maxPathSum(TreeNode root) {
        int[] maxi = {Integer.MIN_VALUE};

        findMaxPathSum(root, maxi);

        return maxi[0];
    }

//Time Complexity: O(N) where N is the number of nodes in the Binary Tree. This complexity arises from visiting each node exactly once during the recursive traversal.
//
//Space Complexity: O(1) as no additional space or data structures is created that is proportional to the input size of the tree. O(H) Recursive Stack Auxiliary Space : The recursion stack space is determined by the maximum depth of the recursion, which is the height of the binary tree denoted as H. In the balanced case it is log2N and in the worst case its N.



    /// ////////////////////////////////////////////////////////////////////////////////////////////////////


    // Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

    private void recursionRight(TreeNode root, int level, List<Integer> res) {
        // Check if the current node is null
        if (root == null) {
            return;
        }

        // Check if the size of the result list
        // is equal to the current level
        if (res.size() == level) {
            // If equal, add the value of the
            // current node to the result list (since it is the first from the right in that level)
            res.add(root.val);
        }

        // Recursively call the function for the
        // right child with an increased level
        recursionRight(root.right, level + 1, res);

        // Recursively call the function for the
        // left child with an increased level
        recursionRight(root.left, level + 1, res);
    }



    public List<Integer> rightSideView(TreeNode root) {
        // List to store the result
        List<Integer> res = new ArrayList<>();

        // Call the recursive function
        // to populate the left-side view
        recursionRight(root, 0, res);

        return res;
    }


    // 🧠 Time Complexity: O(n)
    //Each node is visited once.
    //No repeated work — just a standard DFS traversal.
    //n is the total number of nodes in the tree.
    //✅ Time = O(n)
    //
    //🧠 Space Complexity:
    //Let’s consider two parts:
    //1. Recursive Call Stack:
    //In the worst case (skewed tree), the recursion depth could be O(n).
    //In a balanced tree, it would be O(log n).
    //So:
    //Worst-case stack space = O(n)
    //Average-case (balanced) = O(log n)
    //
    //2. Result List res:
    //You store one node per level (rightmost).
    //So for a tree of height h, res will have at most h entries.
    //So result storage = O(h) = O(n) in worst case (skewed tree).


    // Time: O(n)
    //Space: O(h) where h is the height of the tree (up to O(n) in worst-case)


    /// ////////////////////////////////////////////////////////////////////////////////////////////////////

    // Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

         public boolean isSymmetric(TreeNode root) {
             return root == null || isSymmetricHelp(root.left, root.right);
        }

        public boolean isSymmetricHelp(TreeNode left, TreeNode right){
            if(left == null || right == null){
                return left == right;
            }

            if(left.val != right.val){
                return false;
            }

            return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
        }


    // Time Complexity: O(N) where N is the number of nodes in the Binary Tree. This complexity arises from visiting each node exactly once during the traversal and the function compares the nodes in a symmetric manner.

    //Space Complexity: O(1) as no additional data structures or memory is allocated.
    //O(H): Recursive Stack Space is used to calculate the height of the tree at each node which is proportional to the height of the tree.
    //The recursive nature of the getHeight function, which incurs space on the call stack for each recursive call until it reaches the leaf nodes or the height of the tree.


/////////////////////////////////////////////////////////////////////////////////////////////////////

// Given a Binary Tree, return its Top View. The Top View of a Binary Tree is the set of nodes visible when we see the tree from the top.

    public List<Integer> topView(TreeNode root) {

        // This list will store the final result (top view of the binary tree)
        List<Integer> ans = new ArrayList<>();

        // Base case: if the tree is empty, return an empty list
        if (root == null) {
            return ans;
        }

        // TreeMap is used to keep the horizontal distance in sorted order
        // Key: horizontal distance (line), Value: node value at that line seen from the top
        Map<Integer, Integer> mpp = new TreeMap<>();

        // Queue to perform level-order traversal (BFS)
        // Each element in the queue is a Pair of (node, horizontal distance from root)
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();

        // Start with the root at horizontal distance 0
        q.add(new Pair<>(root, 0));

        // Standard BFS traversal
        while (!q.isEmpty()) {

            // Get the front node and its horizontal distance
            Pair<TreeNode, Integer> pair = q.poll();
            TreeNode node = pair.getKey();
            int line = pair.getValue();

            // If this horizontal distance is not already present in the map,
            // it means this is the topmost node at this horizontal distance
            if (!mpp.containsKey(line)) {
                mpp.put(line, node.val);
            }

            // If left child exists, add it to the queue with horizontal distance - 1
            if (node.left != null) {
                q.add(new Pair<>(node.left, line - 1));
            }

            // If right child exists, add it to the queue with horizontal distance + 1
            if (node.right != null) {
                q.add(new Pair<>(node.right, line + 1));
            }
        }

        // Traverse the TreeMap to get the values in sorted order of horizontal distance
        for (int value : mpp.values()) {
            ans.add(value);
        }

        // Return the list containing the top view
        return ans;
    }

//Time Complexity: O(N) where N is the number of nodes in the Binary Tree. This complexity arises from visiting each node exactly once during the BFS traversal.
//
//Space Complexity: O(N/2 + N/2) where N represents the number of nodes in the Binary Tree.
//
//The main space consuming data structure is the queue used for BFS traversal. It acquires space proportional to the number of nodes in the level it is exploring hence in the worst case of a balanced binary tree, the queue will have at most N/2 nodes which is the maximum width.
//Additionally, the map is used to store the top view nodes based on their vertical positions hence its complexity will also be proportional to the greatest width level. In the worst case, it may have N/2 entries as well.



/////////////////////////////////////////////////////////////////////////////////////////////////////

// Given a Binary Tree, return its Bottom View. The Bottom View of a Binary Tree is the set of nodes visible when we see the tree from the bottom.

    public List<Integer> bottomView(TreeNode root) {
        // List to store the result
        List<Integer> ans = new ArrayList<>();

        // Check if the tree is empty
            if(root == null) {
            return ans;
        }

        // Map to store the bottom view nodes
        // based on their vertical positions
        Map<Integer, Integer> mpp = new TreeMap<>();

        // Queue for BFS traversal, each
        // element is a pair containing node
        // and its vertical position
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();

        // Push the root node with its vertical
        // position (0) into the queue
            q.add(new Pair<>(root, 0));

        // BFS traversal
            while(!q.isEmpty()) {
            // Retrieve the node and its vertical
            // position from the front of the queue
            Pair<TreeNode, Integer> pair = q.poll();
            TreeNode node = pair.getKey();
            int line = pair.getValue();

            // Update the map with the node's data
            // for the current vertical position
            mpp.put(line, node.val);

            // Process left child
            if(node.left != null) {
                // Push the left child with a decreased
                // vertical position into the queue
                q.add(new Pair<>(node.left, line - 1));
            }

            // Process right child
            if(node.right != null) {
                // Push the right child with an increased
                // vertical position into the queue
                q.add(new Pair<>(node.right, line + 1));
            }
        }

        // Transfer values from the
        // map to the result list
            for(Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            ans.add(entry.getValue());
        }

            return ans;
    }

// Time Complexity: O(N) where N is the number of nodes in the Binary Tree. This complexity arises from visiting each node exactly once during the BFS traversal.
//
//Space Complexity: O(N/2 + N/2) where N represents the number of nodes in the Binary Tree.
//
//The main space consuming data structure is the queue used for BFS traversal. It acquires space proportional to the number of nodes in the level it is exploring hence in the worst case of a balanced binary tree, the queue will have at most N/2 nodes which is the maximum width.
//Additionally, the map is used to store the top view nodes based on their vertical positions hence its complexity will also be proportional to the greatest width level. In the worst case, it may have N/2 entries as well.


/////////////////////////////////////////////////////////////////////////////////////////////////////

    

}
