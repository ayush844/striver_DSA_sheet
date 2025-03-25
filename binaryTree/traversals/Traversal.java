import java.util.*;

public class Traversal {

    /*
     * Introduction to Trees
     *
     * In the world of data structures and algorithms, understanding binary trees lays the groundwork for hierarchical organisation and efficient data manipulation.
     *
     * Up until now, we have studied array, linked list, stack and queues which are the fundamental linear data structures. Binary Trees are a different data structure and allow hierarchical organisation and structure of multi-level sequences. This resembles a tree with branching at each node expanding the tree in a non-linear fashion.
     *
     * Just as the folders, subfolders and files are hierarchically arranged in your computer's file system, the binary tree has a similar structure with nodes representing folders and their children nodes representing the sub directory or files inside it.
     *
     * Binary Tree: Binary tree is a fundamental hierarchical data structure in computer science that comprises nodes arranged in a tree-like structure. It consists of nodes, where each node can have at most two children nodes, known as the left child and the right child.
     *
     * Nodes: Each node in a binary tree contains a piece of data, often referred to as the node’s value or key. This node also contains references and pointers to its left and right children so that we can traverse from one node to another in a hierarchical order.
     *
     * Root Node: is the topmost node of a binary tree from which all other nodes stem out. This serves as the entry point for traversing the tree structure.
     *
     * Children Nodes are the nodes directly connected to a parent node. In a binary tree, a parent node can have zero, one or two children nodes, each situated to the left or right of the parent node.
     *
     * Leaf Nodes are the nodes that do not have any children. These nodes lie on the outermost ends of the tree branches and are the terminal points of the traversal.
     *
     * Ancestors in a Binary Tree are those nodes that lie on the path from a particular node to the root node. They are the nodes encountered while moving upwards from a specific node through its parent nodes until reaching the root of the tree.
     *
     * Full Binary Tree:
     * A Full Binary Tree, also known as a Strict Binary Tree, adheres to the structural property where every node has either zero or two children.
     *
     * No node of this tree has just a single child, all internal nodes have exactly two children or in the case of leaf nodes, no children.
     *
     * The property that each node has either 2 or 0 children contributes significantly to the tree’s balance, making traversal, searching and insertion options more predictable and efficient.
     *
     * The emphasis that the internal nodes must have exactly two children optimises the tree’s space utilisation and makes it more balanced.
     *
     * Complete Binary Tree:
     * A Complete Binary Tree is a specialised form of Binary Tree where all levels are filled completely except possibly the last level, which is filled from left to right.
     *
     * All levels of the tree, except possibly the last one, are fully filled. If the last level is not completely filled, it is filled from left to right, ensuring that nodes are positioned as far left as possible.
     *
     * In a complete binary tree, all leaf nodes are in the last level or the second-to-last level, and they are positioned towards the leftmost side.
     *
     * This structure is particularly useful for storing data in structures like heaps, where efficient access to the top element (root) or certain properties (e.g., maximum or minimum values in a heap) is crucial. The completeness property of a complete binary tree aids in achieving balanced structures, making it easier to implement algorithms and ensuring reasonably consistent performance.
     *
     * One important aspect to note is that although it might seem similar to a full binary tree, a complete binary tree doesn't require all nodes to have two children; it's about the positioning and arrangement of nodes.
     *
     * Perfect Binary Tree:
     * A Perfect Binary tree is a type of Binary Tree where all leaf nodes are at the same level and the number of leaf nodes is maximised for that level.
     *
     * Every node in a perfect binary tree has either zero or two children. This means that every internal node (non-leaf node) has exactly two children and all leaf nodes are at the same level.
     *
     * All levels of this tree are fully filled with nodes including the last level. Perfect Binary Trees have a balanced structure that maximises the number of nodes for a given height, creating a dense structure where the number of nodes doubles as we move down each level of the tree.
     *
     * Properties of perfect binary trees make them efficient for certain operations like searching and sorting due to their balanced nature. However, achieving and maintaining perfect balance, especially when the number of nodes is not a power of two, might not be feasible in many practical applications.
     *
     * All levels of this tree are fully filled with nodes including the last level. Perfect Binary Trees have a balanced structure that maximises the number of nodes for a given height, creating a dense structure where the number of nodes doubles as we move down each level of the tree.
     *
     * Properties of perfect binary trees make them efficient for certain operations like searching and sorting due to their balanced nature. However, achieving and maintaining perfect balance, especially when the number of nodes is not a power of two, might not be feasible in many practical applications.
     *
     * Balanced Binary Tree:
     * A Balanced Binary tree is a type of Binary Tree where the heights of the two subtrees of any node differ by at most one. This property ensures that the tree remains relatively well-balanced, preventing the tree from becoming highly skewed or degenerate.
     *
     * In a balanced binary tree, the height of the tree should be log2N at maximum, where N is the number of nodes. This ensures that the tree does not become heavily skewed or imbalanced. The distribution of nodes of both the left and right subtrees remains relatively even throughout the tree.
     *
     * Degenerate Tree:
     * A Degenerate Tree is a Binary Tree where the nodes are arranged in a single path leaning to the right or left. The tree resembles a linked list in its structure where each node points to the next node in a linear fashion.
     *
     * There’s a lot of imbalance in the tree structure due to the sequential arrangement of nodes. This lack of balance results in a tree that resembles a singly linked list rather than a branching structure.
     *
     * Each level of this tree only has one node. The height of tree reaches ‘n’ ie. the number of nodes in the tree, resulting in inefficient search operations. Though degenerate trees are not commonly used intentionally due to their inefficient nature for most operations, they may occur inadvertently in scenarios where nodes are inserted in a specific order (e.g., always to the right or left), causing the tree to lose its balanced properties.
     *
     * Understanding degenerate trees is essential in analysing the worst-case time complexity of algorithms in scenarios where the tree structure degrades to this linear form, as it can help in optimising algorithms for these situations.
     *
     * In Summary:
     *
     * In summary, Binary Trees introduce a hierarchical arrangement taking a step ahead of the linear structure we have studied so far.
     *
     * Binary Trees comprise of nodes, each capable of hosting at most two children hence the predecessor ‘Binary”. These structures mirror the hierarchical oraganisation seen in file systems.
     *
     * Full Binary Trees impose the constraint that each node possesses either zero or two children, promoting a well-balanced structure and enhancing predictability in operations like traversal and insertion.
     *
     * Complete Binary Trees, on the other hand, embrace a specialized form where all levels, save possibly the last, are completely filled. Their design, ensuring nodes are positioned leftmost on the last level, proves valuable for efficient data storage and access, resembling the organized arrangement of folders and files in a computer system.
     *
     * Perfect Binary Trees take this hierarchical order a step further, showcasing a balanced structure where all leaf nodes align at the same level. Such trees optimize space by filling all levels with nodes, creating a dense structure.
     *
     * Balanced Binary Trees ensure the difference in heights between subtrees of any node remains minimal, preventing significant skewing or imbalance.
     *
     * Degenerate Trees represent a case where nodes arrange linearly, akin to a linked list, posing inefficiencies in search operations due to the lack of balance.
     */


    // Print the maximum number of nodes on level i of a binary tree.
    static int countNodes(int i) {
        double ans = Math.pow(2,i-1);
        return (int)ans;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////


    class Node{
        int data;
        Node left;
        Node right;

        Node(int key){
            data = key;
            left = null;
            right = null;
        }
    }

    public  void Representation() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(5);
    }
//
//     1
//    / \
//   2   3
//      / 
//     5

/////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Traversals in hierarchical data structures like Binary Trees can be broadly classified into two categories: Depth-First Search (DFS) and Breadth-First Search (BFS). Each of them utilises a different strategy to visit the nodes within the tree.


    // * Binary Tree Traversal(DFS): Inorder, Preorder, Postorder, and Level Order.
    // *
    // * Traversals in hierarchical data structures like Binary Trees are classified into:
    // * 1. Depth-First Search (DFS): Explores as deeply as possible along each branch before backtracking.
    // *    - Uses recursion or a stack.
    // *    - Types:
    // *      - Inorder: Left, Root, Right (visits nodes in ascending order in BST).
    // *      - Preorder: Root, Left, Right (visits root before children).
    // *      - Postorder: Left, Right, Root (visits children before root).
    // *
    // * 2. Breadth-First Search (BFS): Explores level by level, visiting all nodes at a level before moving to the next.
    // *    - Uses a queue.
    // *    - Level Order Traversal: Visits nodes level-wise from left to right.
    // *
    // * Summary:
    // * - Inorder: Left -> Root -> Right
    // * - Preorder: Root -> Left -> Right
    // * - Postorder: Left -> Right -> Root
    // * - Level Order: Level by level, left to right.
    // */



    /**
     * Binary Tree Traversal: Inorder, Preorder, Postorder.
     * Example Tree:
     *     1
     *    / \
     *   2   3
     *  / \   \
     * 4   5   6
     *
     * Preorder: 1 -> 2 -> 4 -> 5 -> 3 -> 6
     * Inorder: 4 -> 2 -> 5 -> 1 -> 3 -> 6
     * Postorder: 4 -> 5 -> 2 -> 6 -> 3 -> 1
     */

//////////////////////////////////////////////////////////////////////////////////////////////////////////////


      public class TreeNode {
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


    public void preorder(TreeNode root, List<Integer> arr) {
        if (root == null){
            return;
        }

        arr.add(root.val);
        preorder(root.left, arr);
        preorder(root.right, arr);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();

        preorder(root, arr);

        return arr;
    }

    //Time Complexity: O(N) where N is the number of nodes in the binary tree as each node of the binary tree is visited exactly once.
    //
    //Space Complexity: O(N) where N is the number of nodes in the binary tree as an additional space for array is allocated to store the values of all ‘N’ nodes of the binary tree.


//---------------------------------------------------------------------------------------------------------


    public void inorder(TreeNode root, List<Integer> arr) {
        if (root == null){
            return;
        }


        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();

        inorder(root, arr);

        return arr;
    }


    //Time Complexity: O(N) where N is the number of nodes in the binary tree as each node of the binary tree is visited exactly once.
    //
    //Space Complexity: O(N) where N is the number of nodes in the binary tree. This is because the recursive stack uses an auxiliary space which can potentially hold all nodes in the tree when dealing with a skewed tree (all nodes have only one child), consuming space proportional to the number of nodes.In the average case or for a balanced tree, the maximum number of nodes that could be in the stack at any given time would be roughly the height of the tree hence O(log2N).


//---------------------------------------------------------------------------------------------------------


    public void postorder(TreeNode root, List<Integer> arr) {
        if (root == null){
            return;
        }

        postorder(root.left, arr);
        postorder(root.right, arr);
        arr.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        postorder(root, arr);
        return arr;
    }


    // Time Complexity: O(N) where N is the number of nodes in the binary tree as each node of the binary tree is visited exactly once.
    //
    //Space Complexity: O(N) where N is the number of nodes in the binary tree as an additional space for array is allocated to store the values of all ‘N’ nodes of the binary tree.



//////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

    public List<List<Integer>> levelOrder(TreeNode root) {
        // Result list to store each level's values
        List<List<Integer>> ans = new ArrayList<>();

        // If the root is null, return an empty list
        if (root == null) {
            return ans;
        }

        // Queue to facilitate level-order traversal (BFS approach)
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root); // Start by adding the root node to the queue

        // Loop until all levels are processed
        while (!q.isEmpty()) {
            int size = q.size(); // Get the number of nodes at the current level
            List<Integer> level = new ArrayList<>(); // List to store node values for this level

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll(); // Remove the front node from the queue
                level.add(node.val); // Add the node's value to the current level list

                // Add the left child to the queue if it exists
                if (node.left != null) {
                    q.add(node.left);
                }

                // Add the right child to the queue if it exists
                if (node.right != null) {
                    q.add(node.right);
                }
            }

            // Add the current level list to the final result
            ans.add(level);
        }

        return ans; // Return the list of levels
    }

//
//    Time Complexity: O(N) where N is the number of nodes in the binary tree. Each node of the binary tree is enqueued and dequeued exactly once, hence all nodes need to be processed and visited. Processing each node takes constant time operations which contributes to the overall linear time complexity.
//
//    Space Complexity: O(N) where N is the number of nodes in the binary tree. In the worst case, the queue has to hold all the nodes of the last level of the binary tree, the last level could at most hold N/2 nodes hence the space complexity of the queue is proportional to O(N).The resultant vector answer also stores the values of the nodes level by level and hence contains all the nodes of the tree contributing to O(N) space as well.


//////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // Given the root of a Binary Tree, write a function that returns an array containing the preorder traversal of the tree using an iterative approach with a stack.


    public List<Integer> preorder(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();

        if (root == null){
            return preorder;
        }

        Stack<TreeNode> st = new Stack<>();

        st.push(root);

        while (!st.isEmpty()){
            root = st.pop();
            preorder.add(root.val);
            if (root.right != null){
                st.push(root.right);
            }
            if (root.left != null){
                st.push(root.left);
            }
        }

        return preorder;
    }

    //Time Complexity: O(N) where N is the number of nodes in the binary tree. Every node of the binary tree is visited exactly once, and for each node, , the operations performed (pushing and popping from the stack, accessing node values, etc.) are constant time operations.
    //
    //Space Complexity: O(N) where N is the number of nodes in the binary tree. This is because the stack can potentially hold all nodes in the tree when dealing with a skewed tree (all nodes have only one child), consuming space proportional to the number of nodes.


//////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Given the root of a Binary Tree, write a recursive function that returns an array containing the inorder traversal of the tree.


    public List<Integer> inorderTraversal2(TreeNode root) {
        // Create a list to store the inorder traversal result
        List<Integer> inorder = new ArrayList<>();

        // Stack is used to simulate the recursive function call stack
        Stack<TreeNode> st = new Stack<>();

        // Pointer to traverse the tree
        TreeNode node = root;

        // Loop until all nodes are processed
        while (true) {
            if (node != null) {
                // Push the current node onto the stack and move to the left subtree
                st.push(node);
                node = node.left;
            } else {
                // If stack is empty, all nodes have been processed, exit the loop
                if (st.isEmpty()) {
                    break;
                }

                // Pop the last node from the stack and process it
                node = st.pop();
                inorder.add(node.val); // Add the node value to the result list

                // Move to the right subtree to continue the inorder traversal
                node = node.right;
            }
        }

        // Return the final inorder traversal result
        return inorder;
    }


// Time Complexity: O(N) where N is the number of nodes in the binary tree as each node of the binary tree is visited exactly once.
//
//Space Complexity: O(N) where N is the number of nodes in the binary tree. This is because the recursive stack uses an auxiliary space which can potentially hold all nodes in the tree when dealing with a skewed tree (all nodes have only one child), consuming space proportional to the number of nodes.In the average case or for a balanced tree, the maximum number of nodes that could be in the stack at any given time would be roughly the height of the tree hence O(log2N).


//////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Given the root of a Binary Tree, create a function that performs a postorder traversal using two stacks and returns an array containing the traversal sequence.

    public List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        List<Integer> postOrder = new ArrayList<>();

        if (root == null){
            return postOrder;
        }

        st1.push(root);

        while (!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);
            if (root.left != null){
                st1.push(root.left);
            }
            if (root.right != null){
                st1.push(root.right);
            }
        }

        while (!st2.isEmpty()){
            postOrder.add(st2.pop().val);
        }

        return postOrder;
    }

    // Time Complexity: O(2N) where N is the number of nodes in the Binary Tree. The traversal process visits each node in the Binary Tree exactly once to push into stack1 and stack2. Then after the tree is traversed and the nodes are popped from stack2 to push into the postorder array.
    //
    //Space Complexity: O(2N) where N is the number of nodes in the Binary Tree. The space occupied by the two stacks depend on the height of the binary tree. In the worst-case scenario, if the tree is skewed, the space complexity would be O(N) as both stacks could potentially hold all nodes at different points during traversal.The postorder array also holds all nodes from the binary tree hence giving another O(N) + O(N) ~ O(2N).

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //  Given the root of a Binary Tree, return the preorder, inorder and postorder traversal sequence of the given tree by making just one traversal.

    class Pair<T, U> {
        public T first;
        public U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public U getValue(){
            return second;
        }
    }



    public List<List<Integer>> preInPostTraversal(Node root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if (root == null){
            return new ArrayList<>();
        }

        Stack<Pair<TreeNode, Integer>> st = new Stack<>();

        while (!st.isEmpty()){
            Pair<TreeNode, Integer> it = st.pop();

            if (it.second == 1){
                pre.add(it.first.val);
                it.second = 2;
                st.push(it);

                if (it.first.left != null){
                    st.push(new Pair<TreeNode, Integer>(it.first.left, 1));
                }
            } else if (it.second == 2) {
                in.add(it.first.val);
                it.second = 3;
                st.push(it);

                if (it.first.right != null){
                    st.push(new Pair<TreeNode, Integer>(it.first.right, 1));
                }
            }else {
                post.add(it.first.val);
            }

        }

        List<List<Integer>> result = new ArrayList<>();

        result.add(pre);
        result.add(in);
        result.add(post);

        return result;

    }


    //Time Complexity: O(3N) where N is the number of nodes in the Binary Tree. Each node is processed once for each traversal type (pre-order, in-order, and post-order). Hence, the algorithm effectively visits each node three times in total across the three traversal types.
    //
    //Space Complexity: O(4N) where N is the number of nodes in the Binary Tree. The following additional data structures are used:A stack to maintain traversal states, requiring additional space proportional to the maximum number of nodes in the stack at any point during traversal.Three vectors to store the preorder, inorder and postorder traversal. These arrays collectively occupy space proportional to the total number of nodes in the tree. Hence, 3N is added to the space complexity.



//////////////////////////////////////////////////////////////////////////////////////////////////////////////



    







}
