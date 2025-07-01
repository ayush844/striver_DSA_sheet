import java.util.*;

class Pair {
    int node, weight;
    Pair(int n, int w) {
        node = n;
        weight = w;
    }

    @Override
    public String toString() {
        return "(" + node + ", " + weight + ")";
    }
}


public class Learning {

    /*
     * =======================
     * Introduction to Graphs
     * =======================
     *
     * A Graph is a non-linear data structure consisting of nodes (also called vertices),
     * which are connected by edges. Graphs are used to model pairwise relationships
     * between objects, and have real-life applications like:
     * - Google Maps (shortest route)
     * - Social networks (friend connections)
     * - Circuit analysis
     * - Network routing algorithms, etc.
     *
     * ---------------------
     * Linear vs Non-linear:
     * ---------------------
     * Linear Data Structures:
     *   - Arrays, Stacks, Queues, Linked Lists
     *   - Elements arranged in sequence.
     *
     * Non-linear Data Structures:
     *   - Trees (special type of Graph)
     *   - Graphs (general non-linear structure)
     */


    /*
     * =======================
     * Basic Terminologies
     * =======================
     *
     * Vertex (or Node):
     *   - Represented using circles, labeled with numbers or names.
     *   - No specific order required.
     *
     * Edge:
     *   - A connection between two vertices.
     *   - Can be:
     *      - Undirected: No direction (A <-> B)
     *      - Directed: One-way (A -> B)
     */


    /*
     * =======================
     * Types of Graphs
     * =======================
     *
     * 1. Undirected Graph:
     *    - Edges are bidirectional: (u, v) == (v, u)
     *
     * 2. Directed Graph (DiGraph):
     *    - Edges have direction: <u, v> ≠ <v, u>
     *
     * 3. Weighted Graph:
     *    - Each edge has an associated weight or cost.
     *
     * 4. Unweighted Graph:
     *    - All edges assumed to have equal weight (usually 1).
     *
     * 5. Cyclic and Acyclic Graphs:
     *    - Cyclic: At least one cycle exists (path starting and ending at same vertex).
     *    - Acyclic: No cycles present.
     *
     * 6. DAG (Directed Acyclic Graph):
     *    - A directed graph with no cycles.
     */


    /*
     * =======================
     * Graph Structure Example
     * =======================
     *
     * Graphs can be:
     *   - Open (not forming a cycle)
     *   - Closed (containing cycles)
     *
     * Example:
     *   A Tree is a graph with no cycles.
     */


    /*
     * =======================
     * Paths in Graph
     * =======================
     *
     * A path is a sequence of vertices where each adjacent pair is connected by an edge.
     *
     * Valid path example: 1 -> 2 -> 3 -> 5
     * Invalid path:
     *   - 1 -> 2 -> 3 -> 2 -> 1 (Node repeated)
     *   - 1 -> 3 -> 5 (No direct edge between 1 and 3)
     */


    /*
     * =======================
     * Degree of a Node
     * =======================
     *
     * Undirected Graph:
     *   - Degree = Number of edges connected to a node.
     *   - Property: Total Degree of Graph = 2 * (Number of Edges)
     *     Example: D(1) + D(2) + ... + D(n) = 2 * E
     *
     * Directed Graph:
     *   - In-degree: Number of incoming edges.
     *   - Out-degree: Number of outgoing edges.
     */


    /*
     * =======================
     * Edge Weights
     * =======================
     *
     * - Graphs can have weighted edges.
     * - Weight often represents:
     *    - Cost, time, distance, etc.
     * - If not specified, assume weight = 1
     *
     * Example:
     *   - In a road network: weight can be distance between towns.
     */


    /*
     * =======================
     * Summary
     * =======================
     * - Graphs are versatile, non-linear structures.
     * - Used in many algorithmic problems: DFS, BFS, Dijkstra, Kruskal, etc.
     * - Key types: Directed, Undirected, Weighted, Unweighted, Cyclic, Acyclic, DAG.
     */

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /*
     * ====================================
     * Graph Representation in Java
     * ====================================
     *
     * Input Format for Graph:
     * -----------------------
     * - First line: two integers `n` and `m` (nodes and edges)
     * - Next m lines: two integers u and v (edge between u and v)
     *
     * For undirected graphs: if u is connected to v, then v is connected to u.
     * For directed graphs: u -> v (only one-way connection).
     *
     * No restrictions on the number of edges (m can be any value).
     */

    /*
     * ====================================
     * 1. Adjacency Matrix Representation
     * ====================================
     *
     * An adjacency matrix is a 2D array of size (n+1) x (n+1) for 1-based indexing.
     * If there is an edge between i and j, then matrix[i][j] = 1.
     *
     * For undirected graphs, both matrix[i][j] and matrix[j][i] are set to 1.
     * Space Complexity: O(n^2)
     */


    public class AdjacencyMatrixGraph {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Read number of nodes and edges
            int n = sc.nextInt();
            int m = sc.nextInt();

            // Adjacency matrix for undirected graph
            int[][] adj = new int[n + 1][n + 1]; // 1-based indexing

            // Input edges
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj[u][v] = 1;
                adj[v][u] = 1; // Remove this line for directed graph
            }

            // Example usage: Print the matrix
            System.out.println("Adjacency Matrix:");
            for (int i = 1; i <= n; i++) {
                System.out.println(Arrays.toString(adj[i]));
            }

            sc.close();
        }
    }


    /*
     * ====================================
     * 2. Adjacency List Representation
     * ====================================
     *
     * An adjacency list uses an array (or list) of lists.
     * For each node, we store its adjacent neighbors.
     *
     * For undirected graphs: if there is an edge u-v, store:
     *   - v in u's list
     *   - u in v's list
     *
     * Space Complexity:
     *   - Undirected: O(2E)
     *   - Directed:   O(E)
     */

    class AdjacencyListGraph {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Read number of nodes and edges
            int n = sc.nextInt();
            int m = sc.nextInt();

            // Adjacency list for undirected graph
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>()); // index 0 unused for 1-based indexing
            }

            // Input edges
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
                adj.get(v).add(u); // Remove this line for directed graph
            }

            // Example usage: Print adjacency list
            System.out.println("Adjacency List:");
            for (int i = 1; i <= n; i++) {
                System.out.println(i + " -> " + adj.get(i));
            }

            sc.close();
        }
    }


    /*
     * ====================================
     * 3. Weighted Graph Representation
     * ====================================
     *
     * For adjacency list with weights, store (neighbor, weight) pairs.
     * In Java, we can use:
     *   - List of List of Pairs
     *
     * Example: Edge from u to v with weight w:
     *   adj.get(u).add(new Pair(v, w));
     */

    class WeightedGraph {


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Read number of nodes and edges
            int n = sc.nextInt();
            int m = sc.nextInt();

            // Weighted adjacency list
            List<List<Pair>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            // Input weighted edges
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int wt = sc.nextInt();

                adj.get(u).add(new Pair(v, wt));
                adj.get(v).add(new Pair(u, wt)); // Remove for directed graph
            }

            // Example usage: Print weighted adjacency list
            System.out.println("Weighted Adjacency List:");
            for (int i = 1; i <= n; i++) {
                System.out.println(i + " -> " + adj.get(i));
            }

            sc.close();
        }
    }


    /*
     * ====================================
     * Summary
     * ====================================
     * Adjacency Matrix:
     *   - Uses O(n^2) space
     *   - Simple, but memory inefficient for sparse graphs
     *
     * Adjacency List:
     *   - Uses O(2E) space (undirected) or O(E) (directed)
     *   - Efficient for sparse graphs
     *
     * Weighted Graph:
     *   - Use List of Pair<Node, Weight>
     */




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /*
     * =============================================
     * Connected Components in Graphs (Undirected)
     * =============================================
     *
     * So far, we’ve seen various kinds of graphs — some connected like trees, and
     * others that consist of multiple disconnected parts.
     *
     * A connected component in an undirected graph is a **set of nodes** such that:
     * - Any node in the set can be reached from any other node in the same set.
     * - No edge connects this set to any node outside it.
     *
     * Example:
     * Given a graph with:
     *   Nodes = 10
     *   Edges = 8
     *   Edge list: (1,2), (1,3), (2,4), (4,3), (5,6), (5,7), (6,7), (8,9)
     *
     * Observation:
     * - This graph forms 4 **connected components**:
     *   1. {1, 2, 3, 4}
     *   2. {5, 6, 7}
     *   3. {8, 9}
     *   4. {10} (single isolated node)
     *
     * Note:
     * - Although visually they may look like different graphs, they are still part
     *   of a single graph data structure, as per the input.
     */


    /*
     * =============================================
     * Graph Traversal & Visited Array
     * =============================================
     *
     * To find all connected components:
     * - Use a visited[] array of size (n+1) to track whether a node has been visited.
     * - Traverse the graph using DFS/BFS.
     * - For every unvisited node, start a traversal — this gives one connected component.
     *
     * Why can't we just call traversal(1)?
     * - Because it only explores the component where node 1 is present.
     * - Other disconnected components will be missed.
     *
     * So we loop through all nodes:
     *   for (int i = 1; i <= n; i++) {
     *       if (!visited[i]) {
     *           run traversal(i);
     *       }
     *   }
     */


    /*
     * =============================================
     * Summary:
     * =============================================
     * - A graph can have one or more connected components.
     * - Use DFS or BFS to identify and count each component.
     * - Maintain a visited[] array to avoid revisiting nodes.
     * - This approach ensures that all parts of the graph are explored.
     *
     * Time Complexity:
     *   - O(N + E), where N is number of nodes, E is number of edges.
     * Space Complexity:
     *   - O(N) for visited[] and adjacency list.
     */



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
 * ===============================================
 * Breadth First Search (BFS): Level Order Traversal
 * ===============================================
 *
 * Problem Statement:
 * Given an undirected graph, return a list of all nodes traversed
 * using Breadth First Search (BFS) starting from node 0.
 *
 * -----------------------------------------------
 * Pre-requisites:
 * - Graph representation (using Adjacency List)
 * - Queue data structure (FIFO)
 *
 * -----------------------------------------------
 * BFS Approach:
 * 1. Use a `Queue` to process nodes in a FIFO manner.
 * 2. Use a `visited[]` array to keep track of visited nodes.
 * 3. Start with a source node (e.g., 0), mark it visited, and enqueue it.
 * 4. While the queue is not empty:
 *    - Dequeue a node `v`, add it to the BFS result list.
 *    - For each unvisited neighbor of `v`, mark it visited and enqueue it.
 *
 * This ensures that all nodes are explored in a breadth-wise manner.
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();

        boolean visited[] = new boolean[V];

        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()){
            Integer node = q.poll();

            bfs.add(node);

            for (Integer it: adj.get(node)){
                if(visited[it] == false){
                    visited[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }


    //Let's analyze the **time and space complexity** of your `bfsOfGraph()` function.
    //
    //### ✅ **Time Complexity: `O(V + E)`**
    //Where:
    //* `V` = number of vertices (nodes)
    //* `E` = number of edges
    //
    //#### Breakdown:
    //1. **Initialization:**
    //
    //   * Creating the `visited[]` array → `O(V)`
    //   * Queue and result list instantiation → `O(1)`
    //2. **Main BFS loop:**
    //
    //   * Each node is **enqueued and dequeued exactly once** → `O(V)`
    //   * For each node, we iterate through its adjacency list (i.e., its neighbors).
    //
    //     * Across the whole graph, the total number of neighbors we’ll iterate through is **E** (since in an undirected graph, each edge shows up in two lists).
    //     * So this inner loop over neighbors (adjacent nodes) takes total `O(E)` time.
    //
    //**Total time complexity = O(V + E)**

    //---

    //### ✅ **Space Complexity: `O(V)`**
    //
    //#### Breakdown:
    //
    //1. **`visited[]` array** → size `V` → `O(V)`
    //2. **`Queue`** → at most `V` elements can be present in the queue → `O(V)`
    //3. **`bfs` result list** → stores all `V` nodes → `O(V)`
    //
    //**Total space complexity = O(V)**
    //
    //> Note: The adjacency list `adj` is passed as a parameter and not counted in this function's space complexity (it’s pre-constructed externally).

    //---

    //### 📌 Summary
    //
    //| Metric           | Complexity |
    //| ---------------- | ---------- |
    //| Time Complexity  | O(V + E)   |
    //| Space Complexity | O(V)       |
    //
    //Let me know if you want the same analysis for DFS or connected components code too!


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
 * ===============================================
 * Depth First Search (DFS) - Graph Traversal
 * ===============================================
 *
 * Problem Statement:
 * Given an undirected graph, return a list of all nodes
 * traversed using Depth-First Search (DFS) starting from node 0.
 *
 * -----------------------------------------------
 * Pre-requisites:
 * - Graph representation using adjacency list
 * - Recursion & backtracking concepts
 *
 * -----------------------------------------------
 * DFS Approach:
 * 1. Start from a source node (e.g., node 0)
 * 2. Mark it as visited, and store in result list.
 * 3. For each unvisited neighbor of the node, recursively call DFS.
 * 4. This continues until the node's entire reachable path is explored.
 * 5. Once all reachable nodes are explored, backtrack and explore other paths.
 *
 * This ensures all nodes are explored in **depth-wise** fashion.
 *
 * DFS is a recursive algorithm and uses the function call stack implicitly.
 */



    // DFS traversal using recursion
    public void dfs(int node, boolean visited[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {
        // Mark the current node as visited
        visited[node] = true;

        // Add the node to the DFS result list
        ls.add(node);

        // Loop through all the neighbors of the current node
        for (Integer it : adj.get(node)) {
            // If the neighbor hasn't been visited, recursively call DFS on it
            if (!visited[it]) {
                dfs(it, visited, adj, ls); // Recursive call for DFS
            }
        }
    }

    // Function to return the DFS traversal of the graph
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Initialize visited array of size V+1 (assuming 0-based indexing)
        boolean visited[] = new boolean[V + 1];

        // Mark node 0 as visited initially
        visited[0] = true;

        // Create a list to store DFS traversal order
        ArrayList<Integer> ls = new ArrayList<>();

        // Start DFS from node 0
        dfs(0, visited, adj, ls);

        // Return the final DFS traversal list
        return ls;
    }



    /*
     * -----------------------------------------------
     * Time Complexity:
     * For undirected graph: O(N) + O(2E)
     * For directed graph:   O(N) + O(E)
     * Where:
     *   - N = number of nodes
     *   - E = number of edges
     *
     * Why?
     * - Each node is visited once → O(N)
     * - Each adjacency list is traversed (total edges in undirected = 2E) → O(2E)
     * - So total = O(N + 2E) = O(N + E)
     *
     * -----------------------------------------------
     * Space Complexity: O(3N) → Simplified to O(N)
     * - O(N) for visited[] array
     * - O(N) for recursion call stack in worst case (if graph is linear)
     * - O(N) for result list storing DFS order
     */

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    



}
