import java.util.Stack;

public class Concept {

    class TreeNode {
        int val;
        Concept.TreeNode left;
        Concept.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, Concept.TreeNode left, Concept.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //A Binary Search Tree (BST) in Java is a data structure where:
    //Each node has at most two children (left and right).

    //For any given node:
    //Values in the left subtree are less than the node’s value.
    //Values in the right subtree are greater than the node’s value.

    //This structure enables efficient searching, insertion, and deletion, typically in O(log n) time for balanced trees.


    //After understanding how a Binary Search Tree is represented, let us now understand why is there a need to use a Binary Search Tree instead of a simple Binary Tree.
    //So, generally in a BST, the maximum height in almost all cases is kept in order of log(N)2 where N = No. of nodes which is in contrast to the plain Binary Tree whose maximum height can reach the order of N when the tree is skewed.
    //This particularly makes the time of searching for a given node in a Binary Search Tree a lot less than searching in a simple Binary Tree.
    //
    //For example, if we have to search for an element, we can directly compare it to the root node value of the BST, if the value matches then we have found the element, if say the value is greater than the root node, we say that we now move on to searching that element in the right subtree because the right subtree has all the node values greater than the root value. The search process is terminated for the left subtree as it would only search for those nodes which have values lesser than the root.


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // You are given the root of a binary search tree (BST) and an integer val.
    //Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val){
            root = val > root.val ? root.right : root.left;
        }

        return root;
    }

    //Time Complexity: O(log2N) where N is the number of nodes in the Binary Search Tree. In the best case scenario, where the tree is balanced, the time complexity is the height of the tree ie. log2N. In the worst-case scenario, where the tree is degenerate (linear), the time complexity becomes O(n), as it would require traversing all nodes along the path from the root to the leaf.

    //Space Complexity: O(1) since the algorithm does not use any additional space or data structures. The algorithm does use auxiliary stack space from recursion. In the average and worst-case scenarios, the space complexity for recursive stack space is O(h), where 'h' represents the height of the tree.


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Given a Binary Search Tree and a key, return the ceiling of the given key in the Binary Search Tree.
//Ceiling of a value refers to the value of the smallest node in the Binary Search Tree that is greater than or equal to the given key.
//If the ceiling node does not exist, return nullptr.


    public int findCeil(TreeNode root, int key) {

        int ceil = -1;

        while (root != null){
            if (root.val == key){
                ceil = root.val;
                return ceil;
            }

            if (key > root.val){
                root = root.right;
            }else{
                ceil = root.val;
                root = root.left;
            }
        }

        return ceil;

    }

    //Time Complexity: O(log2N) where N is the number of nodes in the Binary Search Tree. In the best case scenario, where the tree is balanced, the time complexity is the height of the tree ie. log2N. In the worst-case scenario, where the tree is degenerate (linear), the time complexity becomes O(n), as it would require traversing all nodes along the path from the root to the leaf.

    //Space Complexity: O(1) since the algorithm does not use any additional space or data structures.


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Given a Binary Search Tree and a key, return the floor of the given key in the Binary Search Tree.
    //Floor of a value refers to the value of the largest node in the Binary Search Tree that is smaller than or equal to the given key.
    //If the floor node does not exist, return nullptr.


    public int findFloor(TreeNode root, int key) {

        int floor = -1;

        while (root != null){
            if(root.val == key){
                floor = root.val;
                return floor;
            }

            if (key > root.val){
                floor = root.val;
                root = root.right;
            }else{
                root = root.left;
            }
        }

        return floor;

    }

    //Time Complexity: O(log2N) where N is the number of nodes in the Binary Search Tree. In the best case scenario, where the tree is balanced, the time complexity is the height of the tree ie. log2N. In the worst-case scenario, where the tree is degenerate (linear), the time complexity becomes O(N), as it would require traversing all nodes along the path from the root to the leaf.

    //Space Complexity: O(1) since the algorithm does not use any additional space or data structures.


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
//Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.


    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }

        TreeNode curr = root;

        while (true){
            if(curr.val <= val){
                if (curr.right != null){
                    curr = curr.right;
                }else{
                    curr.right = new TreeNode(val);
                    break;
                }
            }else{
                if (curr.left != null){
                    curr = curr.left;
                }else{
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }


    //    //Time Complexity: O(log2N)
    //    //Space Complexity: O(1) since the algorithm does not use any additional space or data structures.


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
//
//Basically, the deletion can be divided into two stages:
//
//Search for a node to remove.
//If the node is found, delete the node.




// Main method to delete a node from the BST
    public TreeNode deleteNode(TreeNode root, int key) {
        // Base case: If the tree is empty, return null
        if (root == null){
            return null;
        }

        // If the root node itself is the one to be deleted
        if (root.val == key){
            // Use helper function to delete the node and return the new root
            return helper(root);
        }

        // Keep a reference to the original root to return it at the end
        TreeNode dummy = root;

        // Traverse the tree to find the node with the key
        while (root != null){
            if (root.val > key){
                // Go left if the key is smaller
                if (root.left != null && root.left.val == key){
                    // If the left child is the node to be deleted
                    root.left = helper(root.left);  // Replace it using helper
                    break;
                } else {
                    root = root.left;  // Keep going left
                }
            } else {
                // Go right if the key is larger
                if (root.right != null && root.right.val == key){
                    // If the right child is the node to be deleted
                    root.right = helper(root.right);  // Replace it using helper
                    break;
                } else {
                    root = root.right;  // Keep going right
                }
            }
        }

        // Return the unchanged root (unless it was the root that was deleted)
        return dummy;
    }

    // Helper function to delete the node and restructure the tree
    public TreeNode helper(TreeNode root){
        // If the node has no left child, return its right child (could be null or a subtree)
        if (root.left == null){
            return root.right;
        }

        // If the node has no right child, return its left child
        if (root.right == null){
            return root.left;
        }

        // If the node has two children:
        TreeNode rightChild = root.right; // Store reference to the right subtree

        // Find the rightmost node in the left subtree (inorder predecessor)
        TreeNode lastRight = findLastRide(root.left);

        // Connect the right subtree to the rightmost node of the left subtree
        lastRight.right = rightChild;

        // Return the left subtree as the new root for this subtree
        return root.left;
    }

    // Function to find the rightmost node in a given subtree
    public TreeNode findLastRide(TreeNode root){
        // Keep going right until no more right child
        if (root.right == null){
            return root;
        }

        // Recursive call to go deeper into the right subtree
        return findLastRide(root.right);
    }



    //    //Time Complexity: O(log2N)
    //    //Space Complexity: O(1) since the algorithm does not use any additional space or data structures.


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// IMPORTANT :

    // If you perform an inorder traversal on a binary search tree (BST), it will visit the nodes in ascending sorted order.

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.



    // Main function to find the k-th smallest element in a BST
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        // Step 1: Push all left nodes of the tree starting from root
        // This simulates the beginning of an inorder traversal (Left -> Node -> Right)
        pushLeft(stack, root);

        // Step 2: Pop k-1 nodes from the stack, each time moving to the right subtree
        // Every pop gives us the next smallest node in the BST
        for(int i = 0; i < k - 1; ++i){
            TreeNode node = stack.pop(); // This is the i-th smallest node
            // After visiting this node, we need to explore its right subtree
            // Because in inorder traversal, we go to the right subtree after the node
            pushLeft(stack, node.right);
        }

        // Step 3: The next node on the stack is the k-th smallest node
        return stack.pop().val;
    }

    // Helper method: Pushes a node and all its left descendants to the stack
    // This sets us up to visit the smallest node first (in BST, leftmost is smallest)
    void pushLeft(Stack<TreeNode> stack, TreeNode root){
        while(root != null){
            stack.push(root);   // Keep pushing current node
            root = root.left;   // Move to its left child
        }
        // When root becomes null, we've reached the leftmost node
    }



    //🔍 How the Logic Works (High-Level Overview):
    //In a BST, an inorder traversal visits all nodes in ascending order.
    //You simulate this traversal using a stack (instead of recursion).
    //You push all left children first — starting at the smallest value.
    //Every time you pop, you’re getting the next smallest node.
    //After k-1 pops, the next node you pop is the k-th smallest element.


//  Time Complexity	O(H + k)
//  Space Complexity	O(H)
    //  H = height of the BST
    //  k = number of nodes visited until the k-th smallest




    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Given the root of a binary tree, determine if it is a valid binary search tree (BST).

    //A valid BST is defined as follows:
    //The left subtree of a node contains only nodes with keys less than the node's key.
    //The right subtree of a node contains only nodes with keys greater than the node's key.
    //Both the left and right subtrees must also be binary search trees.



    // Entry point: starts recursion with the widest possible range of valid values
    public boolean isValidBST(TreeNode root) {
        // We use Long.MIN_VALUE and Long.MAX_VALUE to avoid integer overflow
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Helper method that checks whether the subtree rooted at 'root'
    // is a valid BST within the range (minVal, maxVal)
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        // Base case: empty tree is a valid BST
        if (root == null) return true;

        // The current node must be strictly within the (minVal, maxVal) range
        // If not, it's invalid
        if (root.val >= maxVal || root.val <= minVal) {
            return false;
        }

        // Recursively validate the left subtree
        // All values in the left subtree must be < root.val
        boolean leftIsValid = isValidBST(root.left, minVal, root.val);

        // Recursively validate the right subtree
        // All values in the right subtree must be > root.val
        boolean rightIsValid = isValidBST(root.right, root.val, maxVal);

        // The current tree is valid only if both subtrees are valid
        return leftIsValid && rightIsValid;
    }



    //🧠 Time and Space Complexity
    //⏱️ Time Complexity: O(N)
    //Each node is visited exactly once.
    //At each node, you perform a constant-time comparison and two recursive calls.

    //🧠 Space Complexity: O(H)
    //Where H is the height of the tree.
    //This is due to recursive call stack.
    //For a balanced BST: H = log N
    //For a skewed tree: H = N
    //No additional space (like arrays or hash sets) is used.




    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


// Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
//
//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the current node is null, there's nothing to search
        if (root == null){
            return null;
        }

        // Store the value of the current root node
        int curr = root.val;

        // If both p and q are greater than the current node,
        // then the LCA must be in the right subtree
        if (curr < p.val && curr < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        // If both p and q are smaller than the current node,
        // then the LCA must be in the left subtree
        if (curr > p.val && curr > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }

        // If one of p or q is smaller and the other is greater than the current node,
        // or the current node is equal to p or q,
        // then this node is the Lowest Common Ancestor
        return root;
    }



    // time complexity: O(h)    h -> height of tree
    // space complexity: O(1)



    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.
//It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.
//A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.
//A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.



    // Main entry point: starts the recursion with full range and index 0
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    // Recursive function to build BST
    public TreeNode bstFromPreorder(int[] preorder, int upper_bound, int[] i) {

        // preorder: Same array as above.
        //upper_bound: The maximum allowed value for a node in the current subtree (helps ensure BST property).
        //i: A single-element array used to simulate a mutable integer (to keep track of the current index in preorder across recursive calls).


        // Base case 1: if we've processed all elements in preorder
        // Base case 2: if the current value exceeds allowed upper_bound (violates BST property)
        if (i[0] == preorder.length || preorder[i[0]] > upper_bound) {
            return null;
        }

        // Construct the current node with the current value in preorder and move index forward
        TreeNode root = new TreeNode(preorder[i[0]++]);

        // Recursively build the left subtree
        // All values in left subtree must be < current node's value (root.val)
        root.left = bstFromPreorder(preorder, root.val, i);

        // Recursively build the right subtree
        // All values must be < upper_bound (inherited from parent), but ≥ root.val
        root.right = bstFromPreorder(preorder, upper_bound, i);

        // Return the constructed subtree rooted at `root`
        return root;
    }


//Time Complexity:
//O(n) where n is the number of nodes in the BST.
//Each node is visited once, and i[0] is incremented exactly n times — no backtracking or reprocessing.

//Space Complexity:
//O(h) where h is the height of the BST (due to recursion stack).
//In worst case (skewed tree), h = n → O(n)
//In best/average case (balanced tree), h = log n → O(log n)
//No extra space is used beyond the recursion and the output tree.


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //You are given root node of the BST and an integer key. You need to find the in-order successor and predecessor of the given key. If either predecessor or successor is not found, then set it to NULL.

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;

        while (root != null){
            if (p.val >= root.val){
                root = root.right;
            }else{
                successor = p;
                root = root.left;
            }
        }

        return successor;

    }

    // time complexity: O(h)    h -> height of tree
    // space complexity: O(1)

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
    //
    //BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
    //boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
    //int next() Moves the pointer to the right, then returns the number at the pointer.
    //Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
    //
    //You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.




// Class to implement an iterator over a Binary Search Tree (BST)
// It provides in-order traversal (left -> root -> right)
    class BSTIterator {

        // Stack is used to simulate the in-order traversal without recursion
        private Stack<TreeNode> stack = new Stack<>();

        // Constructor initializes the iterator with the root node
        public BSTIterator(TreeNode root) {
            // Push all the leftmost nodes from the root into the stack
            // This ensures that the smallest node is at the top of the stack
            pushAll(root);
        }

        // Returns the next smallest number in the BST
        public int next() {
            // Pop the top node from the stack (smallest unvisited node)
            TreeNode temp = stack.pop();

            // If the popped node has a right child, push all its left descendants
            // into the stack to maintain in-order traversal
            pushAll(temp.right);

            // Return the value of the node
            return temp.val;
        }

        // Returns true if there are more nodes to visit
        public boolean hasNext() {
            // If the stack is not empty, there are still nodes to return
            return !stack.isEmpty();
        }

        // Helper method to push all left children of a node into the stack
        private void pushAll(TreeNode node){
            // Keep going left and push each node onto the stack
            // This prepares the stack for the next smallest element
            for (; node != null; stack.push(node), node = node.left);

            // Equivalent to:
            // while (node != null) {
            //     stack.push(node);
            //     node = node.left;
            // }
        }
    }




    // time complexity: O(1)
    // space complexity: O(h)   h -> height of tree


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


// Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.



// Iterator class to traverse a Binary Search Tree (BST)
// It can do normal in-order (left to right) or reverse in-order (right to left) traversal
    class BSTIterator2 {

        // Stack to simulate the recursive in-order traversal
        private Stack<TreeNode> stack = new Stack<>();

        // Boolean flag to decide the direction of traversal
        // reverse = false → normal in-order (ascending)
        // reverse = true  → reverse in-order (descending)
        boolean reverse = true;

        // Constructor
        public BSTIterator2(TreeNode root, boolean isReverse) {
            reverse = isReverse;  // Set the traversal direction
            pushAll(root);        // Push the initial path from root based on direction
        }

        // Returns true if there are more elements in the traversal
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        // Returns the next smallest/largest element based on traversal direction
        public int next() {
            // Pop the top node from the stack (current element)
            TreeNode temp = stack.pop();

            // If doing normal in-order (left to right), go to right subtree next
            // If doing reverse in-order (right to left), go to left subtree next
            if (!reverse) {
                pushAll(temp.right);  // For ascending order
            } else {
                pushAll(temp.left);   // For descending order
            }

            // Return the value of the current node
            return temp.val;
        }

        // Helper method to push all nodes along the path (left or right depending on direction)
        private void pushAll(TreeNode node) {
            // Keep going in the required direction and push all visited nodes to the stack
            while (node != null) {
                stack.push(node);
                // If reverse → go right first (for largest values first)
                // Else → go left first (for smallest values first)
                node = reverse ? node.right : node.left;
            }
        }
    }


    // Main solution class to solve Two Sum in a BST
    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            if (root == null) {
                return false; // Empty tree has no pair
            }

            // Create two iterators:
            // l → normal in-order (smallest value first)
            // r → reverse in-order (largest value first)
            BSTIterator2 l = new BSTIterator2(root, false);
            BSTIterator2 r = new BSTIterator2(root, true);

            // Initialize two pointers with first values from both ends
            int i = l.next(); // smallest
            int j = r.next(); // largest

            // Two-pointer approach: keep moving i or j until they meet
            while (i < j) {
                int sum = i + j;

                if (sum == k) {
                    // Found the target sum
                    return true;
                } else if (sum < k) {
                    // Move left pointer forward to increase sum
                    i = l.next();
                } else {
                    // Move right pointer backward to decrease sum
                    j = r.next();
                }
            }

            // No pair found that sums to k
            return false;
        }
    }


    // 🧠 Time & Space Complexity:
    //Time complexity: O(n) in worst-case when all nodes are visited, but usually better.
    //Space complexity: O(h) where h is the height of the tree (stack space).


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

    class Solution2 {

        // These will be used to track the nodes that are out of order
        private TreeNode first;   // The first node where the BST property is violated
        private TreeNode middle;  // The middle node, used when the swapped nodes are adjacent
        private TreeNode last;    // The second node where the BST property is violated (when not adjacent)
        private TreeNode prev;    // Keeps track of the previous node during in-order traversal

        // In-order traversal to detect the misplaced nodes
        private void inorder(TreeNode root){
            if (root == null){
                return;
            }

            // Recursively visit left subtree
            inorder(root.left);

            // Check if the previous node's value is greater than the current node's value
            // This indicates a violation of BST properties
            if (prev != null && (root.val < prev.val)) {

                // If this is the first violation, mark 'first' and 'middle'
                if (first == null){
                    first = prev;
                    middle = root;
                } else {
                    // If this is the second violation, mark 'last'
                    last = root;
                }
            }

            // Update 'prev' to current node before moving to right subtree
            prev = root;

            // Recursively visit right subtree
            inorder(root.right);
        }

        // Main function to recover the BST
        public void recoverTree(TreeNode root) {
            // Initialize pointers
            first = middle = last = null;

            // Set 'prev' to a dummy node with minimum value so first comparison is safe
            prev = new TreeNode(Integer.MIN_VALUE);

            // Perform in-order traversal to find the two swapped nodes
            inorder(root);

            // If the swapped nodes are not adjacent, swap 'first' and 'last'
            if (first != null && last != null){
                int t = first.val;
                first.val = last.val;
                last.val = t;
            }
            // If the swapped nodes are adjacent, swap 'first' and 'middle'
            else if (first != null && middle != null){
                int t = first.val;
                first.val = middle.val;
                middle.val = t;
            }
        }
    }


    // ✅ Time Complexity:
    //O(n) – You traverse all n nodes of the BST once using in-order traversal.

    //✅ Space Complexity:
    //O(h) – where h is the height of the tree (due to recursive call stack during in-order traversal).
    //For a balanced BST: O(log n)
    //For a skewed tree: O(n)


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




}
