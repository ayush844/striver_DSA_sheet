import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
// ### Stack and Queue in Java
//
//#### 1. **Stack**
//        - **Definition:** A stack is a linear data structure that follows the **Last In, First Out (LIFO)** principle. This means that the last element added to the stack is the first one to be removed.

//        - **Implementation in Java:** The `Stack` class in Java is part of the `java.util` package. It extends the `Vector` class and implements the stack functionalities.
//


//#### Important Stack Methods:
//        1. **`push(E item)`**
//        - Adds an item to the top of the stack.
//        - Example: `stack.push(10);`
//
//        2. **`pop()`**
//        - Removes and returns the top item from the stack.
//        - Throws an `EmptyStackException` if the stack is empty.
//        - Example: `int topElement = stack.pop();`
//
//        3. **`peek()`**
//        - Returns the top item of the stack without removing it.
//                - Throws an `EmptyStackException` if the stack is empty.
//        - Example: `int topElement = stack.peek();`
//
//        4. **`isEmpty()`**
//        - Checks if the stack is empty.
//        - Example: `boolean isEmpty = stack.isEmpty();`
//
//        5. **`search(Object o)`**
//        - Searches for an item in the stack.
//                - Returns the 1-based position from the top of the stack.
//                - Returns `-1` if the element is not found.
//                - Example: `int position = stack.search(10);`
//
//        ---
//
//#### 2. **Queue**
//                - **Definition:** A queue is a linear data structure that follows the **First In, First Out (FIFO)** principle. This means the first element added to the queue is the first one to be removed.
//                - **Implementation in Java:** The `Queue` interface in Java is part of the `java.util` package. It is implemented by classes like `LinkedList`, `PriorityQueue`, and `ArrayDeque`.
//
//#### Important Queue Methods:
//        1. **`add(E e)`**
//        - Adds an element to the tail of the queue.
//        - Throws an `IllegalStateException` if the queue is full (in bounded implementations).
//        - Example: `queue.add(10);`
//
//        2. **`offer(E e)`**
//        - Similar to `add()`, but returns `false` if the queue is full instead of throwing an exception.
//        - Example: `boolean isAdded = queue.offer(10);`
//
//        3. **`remove()`**
//        - Removes and returns the head of the queue.
//        - Throws a `NoSuchElementException` if the queue is empty.
//        - Example: `int head = queue.remove();`
//
//        4. **`poll()`**
//        - Similar to `remove()`, but returns `null` if the queue is empty.
//        - Example: `Integer head = queue.poll();`
//
//        5. **`element()`**
//        - Retrieves, but does not remove, the head of the queue.
//        - Throws a `NoSuchElementException` if the queue is empty.
//        - Example: `int head = queue.element();`
//
//        6. **`peek()`**
//        - Similar to `element()`, but returns `null` if the queue is empty.
//        - Example: `Integer head = queue.peek();`
//
//        ---
//
//        Both structures are widely used in algorithms like Depth-First Search (DFS) for stacks and Breadth-First Search (BFS) for queues.


////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // implement stack using array

//        class Stack {
//            private int[] stackArray; // Array to hold stack elements
//            private int top;          // Index of the top element
//            private int capacity;     // Maximum capacity of the stack
//
//            // Constructor to initialize the stack
//            public Stack(int size) {
//                stackArray = new int[size];
//                capacity = size;
//                top = -1; // Stack is initially empty
//            }
//
//            // Function to push an element onto the stack
//            public void push(int value) {
//                if (isFull()) {
//                    System.out.println("Stack Overflow! Cannot push " + value);
//                    return;
//                }
//                stackArray[++top] = value;
//                System.out.println("Pushed: " + value);
//            }
//
//            // Function to pop the top element from the stack
//            public int pop() {
//                if (isEmpty()) {
//                    System.out.println("Stack Underflow! Cannot pop element.");
//                    return -1; // Indicating an empty stack
//                }
//                return stackArray[top--];
//            }
//
//            // Function to view the top element of the stack
//            public int peek() {
//                if (isEmpty()) {
//                    System.out.println("Stack is empty! Cannot peek.");
//                    return -1; // Indicating an empty stack
//                }
//                return stackArray[top];
//            }
//
//            // Function to get the size of the stack
//            public int size() {
//                return top + 1;
//            }
//
//            // Function to check if the stack is empty
//            public boolean isEmpty() {
//                return top == -1;
//            }
//
//            // Function to check if the stack is full
//            public boolean isFull() {
//                return top == capacity - 1;
//            }
//        }
//
//        // all operation are done in O(1) time complexity
//        // space complexity: O(n)


//------------------------------------------------------------------------------------------------------------

        // implement queue using array

//        class Queue {
//
//            private int arr[];
//            private int start, end, currSize, maxSize;
//            public Queue() {
//                arr = new int[16];
//                start = -1;
//                end = -1;
//                currSize = 0;
//            }
//
//            public Queue(int maxSize) {
//                this.maxSize = maxSize;
//                arr = new int[maxSize];
//                start = -1;
//                end = -1;
//                currSize = 0;
//            }
//            public void push(int newElement) {
//                if (currSize == maxSize) {
//                    System.out.println("Queue is full\nExiting...");
//                    System.exit(1);
//                }
//                if (end == -1) {
//                    start = 0;
//                    end = 0;
//                } else {
//                    end = (end + 1) % maxSize;
//                }
//                arr[end] = newElement;
//                System.out.println("The element pushed is " + newElement);
//                currSize++;
//            }
//            public int pop() {
//                if (start == -1) {
//                    System.out.println("Queue Empty\nExiting...");
//                    System.exit(1);
//                }
//                int popped = arr[start];
//                if (currSize == 1) {
//                    start = -1;
//                    end = -1;
//                } else {
//                    start = (start + 1) % maxSize;
//                }
//                currSize--;
//                return popped;
//            }
//            public int top() {
//                if (start == -1) {
//                    System.out.println("Queue is Empty");
//                    System.exit(1);
//                }
//                return arr[start];
//            }
//            public int size() {
//                return currSize;
//            }
//
//        }

//
//        Time Complexity:
//
//        pop function: O(1)
//
//        push function: O(1)
//
//        top function: O(1)
//
//        size function: O(1)
//
//        Space Complexity:
//
//        Whole Queue: O(n)

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//
//        // implement stack using linked list:
//
//
//        class Stack {
//            private class StackNode {
//                int data;
//                StackNode next;
//
//                StackNode(int d) {
//                    data = d;
//                    next = null;
//                }
//            }
//
//            private StackNode top;
//            private int size;
//
//            // Constructor
//            Stack() {
//                this.top = null;
//                this.size = 0;
//            }
//
//            // Method to push an element onto the stack
//            public void push(int x) {
//                StackNode element = new StackNode(x);
//                element.next = top;
//                top = element;
//                System.out.println("Element pushed: " + x);
//                size++;
//            }
//
//            // Method to pop an element from the stack
//            public int pop() {
//                if (top == null) {
//                    System.out.println("Stack is empty, cannot pop.");
//                    return -1; // Return -1 if the stack is empty
//                }
//                int topData = top.data;
//                StackNode temp = top;
//                top = top.next;
//                size--;
//                System.out.println("Element popped: " + topData);
//                return topData;
//            }
//
//            // Method to get the size of the stack
//            public int size() {
//                return size;
//            }
//
//            // Method to check if the stack is empty
//            public boolean isEmpty() {
//                return top == null;
//            }
//
//            // Method to print the stack elements
//            public void printStack() {
//                StackNode current = top;
//                if (current == null) {
//                    System.out.println("Stack is empty.");
//                } else {
//                    while (current != null) {
//                        System.out.print(current.data + " ");
//                        current = current.next;
//                    }
//                    System.out.println();
//                }
//            }
//        }
//
////        class Main {
////            public static void main(String args[]) {
////                Stack s = new Stack();
////                s.push(10);
////                s.push(20);
////                s.push(30);
////                s.printStack();
////                System.out.println("Element popped: " + s.pop());
////                s.printStack();
////                System.out.println("Stack size: " + s.size());
////                System.out.println("Stack is empty: " + s.isEmpty());
////            }
////        }








///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    // implement queue using linked list:


//
//        class QueueNode {
//            int val;
//            QueueNode next;
//
//            // Constructor to initialize the node with data
//            QueueNode(int data) {
//                val = data;
//                next = null;
//            }
//        }
//
//        class Queue {
//            QueueNode Front = null, Rear = null;
//            int size = 0;
//
//            // Method to check if the queue is empty
//            boolean Empty() {
//                return Front == null;
//            }
//
//            // Method to peek the front element of the queue
//            int Peek() {
//                if (Empty()) {
//                    System.out.println("Queue is Empty");
//                    return -1;
//                }
//                return Front.val;
//            }
//
//            // Method to enqueue a new element in the queue
//            void Enqueue(int value) {
//                // Create a new node with the given value
//                QueueNode Temp = new QueueNode(value);
//
//                // Insert the node into the queue
//                if (Front == null) {  // If the queue is empty
//                    Front = Temp;
//                    Rear = Temp;
//                } else {
//                    Rear.next = Temp; // Link the current last node to the new node
//                    Rear = Temp;      // Update the rear to the new node
//                }
//
//                System.out.println(value + " Inserted into Queue ");
//                size++;
//            }
//
//            // Method to dequeue an element from the queue
//            void Dequeue() {
//                if (Front == null) { // If the queue is empty
//                    System.out.println("Queue is Empty");
//                } else {
//                    System.out.println(Front.val + " Removed From Queue");
//                    Front = Front.next; // Move the front pointer to the next node
//                    size--;
//                }
//            }
//
//            // Main method to test the Queue
//            public static void main(String args[]) {
//                Queue Q = new Queue();
//
//                // Enqueue elements
//                Q.Enqueue(10);
//                Q.Enqueue(20);
//                Q.Enqueue(30);
//                Q.Enqueue(40);
//                Q.Enqueue(50);
//
//                // Dequeue an element
//                Q.Dequeue();
//
//                // Print the size of the queue
//                System.out.println("The size of the Queue is " + Q.size);
//
//                // Peek the front element of the queue
//                System.out.println("The Peek element of the Queue is " + Q.Peek());
//            }
//        }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Implement stack using queue


//
//        class Stack {
//            // Queue to implement stack
//            Queue<Integer> q = new LinkedList<>();
//
//            // Method to push an element into the stack
//            void push(int x) {
//                // Step 1: Add the new element to the queue
//                q.add(x);
//
//                // Step 2: Rotate the elements to maintain stack order (LIFO)
//                int size = q.size();
//                for (int i = 0; i < size - 1; i++) {
//                    // Remove front element and add it to the back
//                    q.add(q.remove());
//                }
//
//                System.out.println(x + " pushed into the stack.");
//            }
//
//            // Method to pop the top element from the stack
//            int pop() {
//                if (q.isEmpty()) {
//                    System.out.println("Stack is empty, cannot pop.");
//                    return -1;
//                }
//                // Remove the front element (which is the stack's top)
//                int removed = q.remove();
//                System.out.println(removed + " popped from the stack.");
//                return removed;
//            }
//
//            // Method to get the top element of the stack
//            int top() {
//                if (q.isEmpty()) {
//                    System.out.println("Stack is empty, no top element.");
//                    return -1;
//                }
//                // Return the front element without removing it
//                return q.peek();
//            }
//
//            // Method to check the size of the stack
//            int size() {
//                return q.size();
//            }
//
//            // Method to check if the stack is empty
//            boolean isEmpty() {
//                return q.isEmpty();
//            }
//        }



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // implement queue using stack

//    import java.util.Stack;
//
//// Class implementing Queue using two stacks
//        class MyQueue {
//            // Two stacks for implementing queue
//            Stack<Integer> input = new Stack<>();  // Stack to hold elements
//            Stack<Integer> output = new Stack<>(); // Temporary stack for rearrangement
//
//            /** Initialize the queue */
//            public MyQueue() {
//                System.out.println("Queue Initialized");
//            }
//
//            /** Push element to the back of the queue */
//            public void push(int x) {
//                // Step 1: Move all elements from input stack to output stack
//                while (!input.empty()) {
//                    output.push(input.pop());
//                }
//
//                // Step 2: Add the new element to the empty input stack
//                input.push(x);
//                System.out.println("The element pushed is " + x);
//
//                // Step 3: Move all elements back from output stack to input stack
//                while (!output.empty()) {
//                    input.push(output.pop());
//                }
//            }
//
//            /** Removes the element from the front of the queue and returns it */
//            public int pop() {
//                if (input.empty()) {
//                    System.out.println("Queue is empty. Cannot pop.");
//                    return -1;  // Return an invalid value when queue is empty
//                }
//                int val = input.pop();  // Remove and return the front element
//                System.out.println("The element popped is " + val);
//                return val;
//            }
//
//            /** Get the front element of the queue */
//            public int peek() {
//                if (input.empty()) {
//                    System.out.println("Queue is empty. No front element.");
//                    return -1;  // Return an invalid value when queue is empty
//                }
//                return input.peek();  // Return front element without removing it
//            }
//
//            /** Get the current size of the queue */
//            int size() {
//                return input.size();  // Return the number of elements in the queue
//            }
//        }


        //Time Complexity: O(N )
        //
        //Space Complexity: O(2N)

/// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
        //
        //An input string is valid if:
        //Open brackets must be closed by the same type of brackets.
        //Open brackets must be closed in the correct order.
        //Every close bracket has a corresponding open bracket of the same type.
        //


        class Solution {

            // a closing bracket should be closing the last opening encountered
            public boolean isValid(String s) {
                // since we have to know the last opening, we need to store all the openings, and since we are getting the last entered opening we will use stack

                Stack<Character> charStack = new Stack<Character>();

                for(char i : s.toCharArray()){
                    if(i == '(' || i == '{' || i == '['){
                        charStack.push(i);
                    }else{
                        if(charStack.isEmpty()) return false;   // it doesn't have closing bracket
                        char ch = charStack.pop();
                        if((ch == '(' && i == ')') || (ch == '{' && i == '}') || (ch == '[' && i == ']')){
                            continue;
                        }else{
                            return false;
                        }
                    }
                }

                if(charStack.isEmpty()){
                    return true;
                }else{
                    return false;
                }

            }
        }


        //Time Complexity: O(N)
        //
        //Space Complexity: O(N)

/// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//Implement the MinStack class:
//MinStack() initializes the stack object.
//void push(int val) pushes the element val onto the stack.
//void pop() removes the element on the top of the stack.
//int top() gets the top element of the stack.
//int getMin() retrieves the minimum element in the stack.
//You must implement a solution with O(1) time complexity for each function.


        // Solution 1: Using pairs to store the value and minimum element till now.
        //
        //Approach: The first element in the pair will store the value and the second element will store the minimum element till now.
        //When the first push operation comes in we will push the value and store it as minimum itself in the pair.
        //In the second push operation, we will check if the top element’s minimum is less than the new value. If it is then we will push the value with minimum as the previous top’s minimum. To get the getMin element to take the top’s second element.


        class Pair{
            int x, y;
            public Pair(int x, int y){
                this.x = x;
                this.y = y;
            }
        }


        class MinStack {

            Stack<Pair> st;

            public MinStack() {
                st = new Stack<>();
            }

            public void push(int val) {
                int min;
                if(st.isEmpty()){
                    min = val;
                }else{
                    min = Math.min(st.peek().y, val);
                }
                st.push(new Pair(val, min));
            }

            public void pop() {
                st.pop();
            }

            public int top() {
                return st.peek().x;
            }

            public int getMin() {
                return st.peek().y;
            }
        }

        //Time Complexity: O(1)
        //
        //Space Complexity: O(2N)


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

/// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        

    }
}