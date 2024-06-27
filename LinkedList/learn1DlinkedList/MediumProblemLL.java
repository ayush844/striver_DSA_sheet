import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class ListNode{
    int val;
    ListNode next;

    ListNode(){

    }

    ListNode(int val){
        this.val = val;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

public class MediumProblemLL {

    public static void main(String[] args) {

    }


    //Given the head of a linked list of integers, determine the middle node of the linked list. However, if the linked list has an even number of nodes, return the second middle node.


    // BRUTE FORCE APPROACH:

    public ListNode middleNode(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        int cnt = 0;

        while (temp!=null){
            cnt++;

            temp = temp.next;
        }

        int midNode = (cnt/2)+1;

        temp = head;

        for (int i = 0; i < midNode-1; i++){
            temp = temp.next;
        }

        return temp;

    }

    //Time Complexity: O(N+N/2) The code traverses the entire linked list once and half times and then only half in the second iteration, first to count the number of nodes then then again to get to the middle node. Therefore, the time complexity is linear, O(N + N/2) ~ O(N).
    //
    //Space Complexity : O(1) There is constant space complexity because it uses a constant amount of extra space regardless of the size of the linked list. We only use a few variables to keep track of the middle position and traverse the list, and the memory required for these variables does not depend on the size of the list.


//-----------------------------------------------------------------------------------------------------------------


    // OPTIMAL APPROACH:

    public ListNode middleNode2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

    }


    //Time Complexity: O(N/2) The algorithm requires the 'fast' pointer to reach the end of the list which it does after approximately N/2 iterations (where N is the total number of nodes). Therefore, the maximum number of iterations needed to find the middle node is proportional to the number of nodes in the list, making the time complexity linear, or O(N/2) ~ O(N).
    //
    //Space Complexity : O(1) There is constant space complexity because it uses a constant amount of extra space regardless of the size of the linked list. We only use a few variables to keep track of the middle position and traverse the list, and the memory required for these variables does not depend on the size of the list.

//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------

// Given the head of a singly linked list, write a program to reverse the linked list, and return the head pointer to the reversed list.

    // MY APPROACH:

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode back = null;
        ListNode curr = head;
        ListNode front = head.next;

        while (curr != null){
            curr.next = back;

            back = curr;
            curr = front;
            if (front != null){
                front = front.next;
            }
        }

        return back;
    }

    // time complexity: O(n)
    // space complexity: O(1)

//---------------------------------------------------------------------------------------------------------------

    // BRUTE FORCE APPROACH:

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;

        while (temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;

        while (temp != null){
            temp.val = stack.pop();
            temp = temp.next;
        }

        return head;

    }

//Time Complexity: O(2N) This is because we traverse the linked list twice: once to push the values onto the stack, and once to pop the values and update the linked list. Both traversals take O(N) time, hence time complexity  O(2N) ~ O(N).
//
//Space Complexity: O(N) We use a stack to store the values of the linked list, and in the worst case, the stack will have all N values,  ie. storing the complete linked list.


//---------------------------------------------------------------------------------------------------------------

// OPTIMAL APPROACH:

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList3(head.next);

        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;

    }


    //Time Complexity: O(N) This is because we traverse the linked list twice: once to push the values onto the stack, and once to pop the values and update the linked list. Both traversals take O(N) time.
    //
    //Space Complexity : O(1) No additional space is used explicitly for data structures or allocations during the linked list reversal process. However, it's important to note that there is an implicit use of stack space due to recursion. This recursive stack space stores function calls and associated variables during the recursive traversal and reversal of the linked list. Despite this, no extra memory beyond the program's existing execution space is allocated, hence maintaining a space complexity of O(1).



//--------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------


// Detect a Cycle in a Linked List

    // BRUTE FORCE APPROACH:

    public boolean hasCycle(ListNode head) {

        ListNode temp = head;

        HashMap<ListNode, Integer> hashNodes = new HashMap<>();

        while (temp != null){

            if (hashNodes.containsKey(temp)){
                return true;
            }

            hashNodes.put(temp, 1);

            temp = temp.next;
        }

        return false;

    }

//Time Complexity: O(N * 2 * log(N) )The algorithm traverses the linked list once, performing hashmap insertions and searches in the while loop for each node. The insertion and search operations in the unordered_map have a worst-case time complexity of O(log(N)). As the loop iterates through N nodes, the total time complexity is determined by the product of the traversal (O(N)) and the average-case complexity of the hashmap operations (insert and search), resulting in O(N * 2 * log(N)).
//Hashmaps and their time complexities are discussed in more detail here.
//
//Space Complexity: O(N) The code uses a hashmap/dictionary to store encountered nodes, which can take up to O(N) additional space, where 'n' is the number of nodes in the list. Hence, the spacecomplexity is O(N) due to the use of the map to track nodes.

//---------------------------------------------------------------------------------------------------------------

// OPTIMAL APPROACH:

    public boolean hasCycle2(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                return true;
            }
        }

        return false;

    }


//Time Complexity: O(N), where N is the number of nodes in the linked list. This is because in the worst-case scenario, the fast pointer, which moves quicker, will either reach the end of the list (in case of no loop) or meet the slow pointer (in case of a loop) in a linear time relative to the length of the list.
//
//The key insight into why this is O(N) and not something slower is that each step of the algorithm reduces the distance between the fast and slow pointers (when they are in the loop) by one. Therefore, the maximum number of steps needed for them to meet is proportional to the number of nodes in the list.
//
//
//Space Complexity : O(1) The code uses only a constantamount of additionalspace, regardless of the linked list's length. This is achieved by using two pointers (slow and fast) to detect the loop without any significant extra memory usage, resulting in constantspace complexity, O(1).



//--------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------

// Given the head of a linked list that may contain a cycle, return the starting point of that cycle. If there is no cycle in the linked list return null.

    // BRUTE FORCE APPROACH:

    public ListNode detectCycle(ListNode head) {
        ListNode temp = head;

        HashMap<ListNode, Integer> hashNodes = new HashMap<>();

        while (temp != null){

            if (hashNodes.containsKey(temp)){
                return temp;
            }

            hashNodes.put(temp, 1);

            temp = temp.next;
        }

        return null;
    }

//Time Complexity: O(N) The code traverses the entire linked list once, where 'N' is the number of nodes in the list. Therefore, the time complexity is linear, O(N).
//
//Space Complexity : O(N) The code uses a hash map/dictionary to store encountered nodes, which can take up to O(N) additional space, where 'n' is the number of nodes in the list. Hence, the space complexity is O(N) due to the use of the map to track nodes.


//---------------------------------------------------------------------------------------------------------------

// OPTIMAL APPROACH:

    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;


        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                    slow = head;

                    while (slow != fast){
                        slow = slow.next;
                        fast = fast.next;
                    }

                    return slow;
            }

        }

        return null;


    }

//Time Complexity: O(N) The code traverses the entire linked list once, where 'n' is the number of nodes in the list. This traversal has a linear time complexity, O(n).
//
//Space Complexity : O(1) The code uses only a constant amount of additional space, regardless of the linked list's length. This is achieved by using two pointers (slow and fast) to detect the loop without any significant extra memory usage, resulting in constant space complexity, O(1).


//--------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------

//Given a linked list of size N. The task is to complete the function countNodesinLoop() that checks whether a given Linked List contains a loop or not and if the loop is present then return the count of nodes in a loop or else return 0. C is the position of the node to which the last node is connected. If it is 0 then no loop.

    // BRUTE FORCE APPROACH:

    public static int countNodesinLoop(ListNode head)
    {
        ListNode temp = head;
        HashMap<ListNode, Integer> hmap = new HashMap<>();

        int count = 1;

        while (temp.next != null){

            if (hmap.containsKey(temp)){
                int old = hmap.get(temp);
                int ans = count - old;
                return ans;
            }

            hmap.put(temp, count);

            temp = temp.next;

            count++;

        }

        return 0;

    }
//time complexity: O(2*N*log(N))
//space complexity: O(N)

//----------------------------------------------------------------------------------------------------------------

    //OPTIMAL APPROACH:

    public static int countNodesinLoop2(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                int count = 1;
                fast = fast.next;
                while (slow != fast){
                    fast = fast.next;
                    count++;
                }
                return count+1;
            }
        }

        return 0;
    }

    ////Time Complexity: O(2N) The code traverses the entire linked list almost twice, where 'n' is the number of nodes in the list. This traversal has a linear time complexity, O(n).
    ////
    ////Space Complexity : O(1) The code uses only a constant amount of additional space, regardless of the linked list's length. This is achieved by using two pointers (slow and fast) to detect the loop without any significant extra memory usage, resulting in constant space complexity, O(1).


//--------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------


// Check if the given Linked List is Palindrome

    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;

        Stack<Integer> container = new Stack<>();

        while (temp != null){
            container.push(temp.val);
            temp = temp.next;
        }

        temp = head;

        while (temp != null){
            if (temp.val == container.pop()){
                temp = temp.next;
            }else{
                return false;
            }
        }

        return true;
    }

    //Time Complexity: O(2 * N) This is because we traverse the linked list twice: once to push the values onto the stack, and once to pop the values and compare with the linked list. Both traversals take O(2*N) ~ O(N) time.
    //
    //Space Complexity: O(N) We use a stack to store the values of the linked list, and in the worst case, the stack will have all N values,  ie. storing the complete linked list.

//---------------------------------------------------------------------------------------------------------------

    // OPTIMAL APPROACH:

    // function to reverse a linkedList

    public ListNode reverseLL(ListNode head){
        if (head==null || head.next == null){
            return head;
        }

        ListNode newHead = reverseLL(head.next);

        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;

    }

    public boolean isPalindrome2(ListNode head) {

        if (head == null || head.next == null){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        //****************************************************//
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverseLL(slow.next);

        ListNode first = head;
        ListNode second = newHead;

        while (second != null){
            if (first.val != second.val){
                reverseLL(newHead);
                return false;
            }

            first = first.next;
            second = second.next;
        }

        reverseLL(newHead);

        return true;
    }

    // Time Complexity: O (2* N) The algorithm traverses the linked list twice, dividing it into halves. During the first traversal, it reverses one-half of the list, and during the second traversal, it compares the elements of both halves. As each traversal covers N/2 elements, the time complexity is calculated as O(N/2 + N/2 + N/2 + N/2), which simplifies to O(2N), ultimately representing O(N).
    //
    //Space Complexity: O(1) The approach uses a constant amount of additional space regardless of the size of the input linked list. It doesn't allocate any new data structures that depend on the input size, resulting in a space complexity of O(1).


//--------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------

// You are given the 'head' of a singly linked list. Your task is to group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list’s head.
//The first node is considered odd, and the second node is even, and so on.

    // BRUTE FORCE APPROACH

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode temp = head;

        ArrayList<Integer> alist = new ArrayList<>();

        while (temp!=null && temp.next != null){
            alist.add(temp.val);
            temp = temp.next.next;
        }

        if (temp != null){
            alist.add(temp.val);
        }

        temp = head.next;

        while (temp!=null && temp.next != null){
            alist.add(temp.val);
            temp = temp.next.next;
        }

        if (temp != null){
            alist.add(temp.val);
        }

        int i = 0;
        temp = head;

        while (temp != null){
            temp.val = alist.get(i);
            i++;
            temp = temp.next;
        }

        return head;

    }

    // time complexity: O(2N)
    // space complexity: O(N)

//---------------------------------------------------------------------------------------------------------------


    // OPTIMAL APPROACH:

    public ListNode oddEvenList2(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode odd = head;

        ListNode evenStart = head.next;
        ListNode even = head.next;

        while (even!=null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenStart;

        return head;

    }

    //    // time complexity: O(N)
    //    // space complexity: O(1)

//--------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------

    // Given the head of a linked list, remove the nth node from the end of the list and return its head.



    // BRUTE FORCE APPROACH:


    // delete from starting

    public int lengthOfLL(ListNode head) {
        ListNode temp = head;
        int count = 0;
        for (; temp != null; temp = temp.next){
            count++;
        }

        return count;
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null){
            return null;
        }

        int length = lengthOfLL(head);

        if (n>length || n < 1){
            System.out.println("invalid value of n");
            return null;
        }

    // there is only one element in the list
        if(length == 1){
            return null;
        }

    // we have to delete the first node
        if(length == n){
            ListNode newHead = head.next;
            return newHead;
        }


        ListNode prev = head;
        ListNode temp = head;


        for (int counter = 1; counter < length - n + 1; counter++){
            prev = temp;
            temp = temp.next;
        }

        prev.next = temp.next;


        return head;
    }


    //Time Complexity: O(L)+O(L-N), We are calculating the length of the linked list and then iterating up to the (L-N)th node of the linked list, where L is the total length of the list.
    //
    //Space Complexity:  O(1), as we have not used any extra space.

//--------------------------------------------------------------------------------------------------------------


    // OPTIMAL APPROACH:

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // move the fast pointer n node ahead of the slow pointer
        for (int i = 0; i < n; i++){
            fast = fast.next;
        }

        // if fast becomes null it means we are asked to delete the first node
        if (fast == null){
            return head.next;
        }

        // now move both fast and slow by one step until fast pointer gets to the last node
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;

    }

    //Time Complexity: O(N) since the fast pointer will traverse the entire linked list, where N is the length of the linked list.
    //
    //Space Complexity: O(1), as we have not used any extra space.

//--------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------
// --------------------------------------------------------------------------------------------------------------

    //You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
    //
    //The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
    //
    //For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.


    // optimal approach:

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode prevSlow = slow;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prevSlow.next = prevSlow.next.next;

        return head;

    }


    // time complexity = O(n/2)
    // space complexity = O(1)


//--------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------
// --------------------------------------------------------------------------------------------------------------


    // Given the head of a linked list, return the list after sorting it in ascending order.

    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (list1!=null && list2!=null){
            if (list1.val < list2.val){
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            }else{
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }
        if (list1 != null){
            temp.next = list1;
        }else{
            temp.next = list2;
        }

        return dummy.next;
    }


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode middle = findMiddle(head);
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);


    }


    // time complexity: O((N + N/2)log(N))
    // space complexity: O(1)


//--------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------
// --------------------------------------------------------------------------------------------------------------


    //Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.

    public ListNode segregate(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }


        ListNode dummy0Head = new ListNode(-1);
        ListNode dummy0 = dummy0Head;

        ListNode dummy1Head = new ListNode(-1);
        ListNode dummy1 = dummy1Head;

        ListNode dummy2Head = new ListNode(-1);
        ListNode dummy2 = dummy2Head;


        ListNode temp = head;

        while (temp!=null){
            if (temp.val == 0){
                dummy0.next = temp;
                dummy0 = dummy0.next;
                temp = temp.next;
            } else if (temp.val == 1) {
                dummy1.next = temp;
                dummy1 = dummy1.next;
                temp = temp.next;
            }else{
                dummy2.next = temp;
                dummy2 = dummy2.next;
                temp = temp.next;
            }
        }

        dummy0.next = (dummy1Head.next != null)? dummy1Head.next : dummy2Head.next;
        dummy1.next = dummy2Head.next;
        dummy2.next = null;

        return dummy0Head.next;

    }

    // time complexity: O(N)
    // space complexity: O(1)

//--------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------
// --------------------------------------------------------------------------------------------------------------

    // Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.


    // brurte force approach

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headB != null){
            ListNode temp = headA;
            while (temp != null){
                if (temp == headB){
                    return temp;
                }
                temp = temp.next;
            }
            headB = headB.next;
        }

        return null;
    }

    //Time Complexity: O(m*n)
    //Reason: For each node in list 2 entire lists 1 are iterated.

    //Space Complexity: O(1)
    //Reason: No extra space is used.

//------------------------------------------------------------------------------------------------------------


    // using hashing

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        HashSet<ListNode> store = new HashSet<>();

        while (headA != null){
            store.add(headA);
            headA = headA.next;
        }

        while (headB != null){
            if (store.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

    //Time Complexity: O(n+m)
    //Reason: Iterating through list 1 first takes O(n), then iterating through list 2 takes O(m).
    //
    //Space Complexity: O(n)
    //Reason: Storing list 1 node address in HashSet.


//------------------------------------------------------------------------------------------------------------


    public ListNode collisionPoint(ListNode smallerList, ListNode biggerList, int diff){
        for (int i = 0; i < diff; i++){
            biggerList = biggerList.next;
        }

        while (smallerList != null && biggerList != null){
            if (smallerList == biggerList){
                return smallerList;
            }

            smallerList = smallerList.next;
            biggerList = biggerList.next;
        }

        return null;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        int nA = 0;
        int nB = 0;

        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != null || tempB != null){
            if (tempA != null){
                nA++;
                tempA = tempA.next;
            }
            if (tempB != null){
                nB++;
                tempB = tempB.next;
            }
        }


        if (nA > nB){
            return collisionPoint(headB, headA, nA-nB);
        }else{
            return collisionPoint(headA, headB, nB-nA);
        }
    }


    //Time Complexity: O(n+m)
    //Space Complexity: O(1)

//--------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------
// --------------------------------------------------------------------------------------------------------------


    //A number n is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it. Returns the head of the modified linked list. The driver code prints the number.


    public static ListNode reverseLinkedList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseLinkedList(head.next);

        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;

    }


    public ListNode addOne(ListNode head)
    {
        head = reverseLinkedList(head);

        ListNode temp = head;
        int carry = 1;

        while (temp != null){
            temp.val += 1;
            if (temp.val < 10){
                carry = 0;
                break;
            }else{
                temp.val = 0;
                carry = 1;
            }
            temp = temp.next;
        }

        if (carry == 1){
            ListNode newNode = new ListNode(1);
            head = reverseLinkedList(head);
            newNode.next = head;
            return newNode;
        }

        return reverseLinkedList(head);

    }

// time complexity: O(3N)
// space complexity: O(1)

//---------------------------------------------------------------------------------------------------------------


    // using recursion  [backtracking]

    public int helper(ListNode head){
        if (head == null){
            return 1;
        }

        int carry = helper(head.next);

        if (carry == 1){
            head.val = head.val+1;
            if (head.val == 10){
                head.val = 0;
                return 1;
            }else{
                return 0;
            }
        }

        return 0;

    }


    public ListNode addOne2(ListNode head)
    {

        int carry = helper(head);

        if (carry == 1){
            ListNode newNode = new ListNode(1);
            newNode.next = head;
            return newNode;
        }

        return head;

    }


// time complexity: O(N)
// space complexity: O(N)


//--------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------
// --------------------------------------------------------------------------------------------------------------

    //You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
    //You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        int carry = 0;

        while(t1 != null || t2 != null){
            int sum = carry;
            if (t1 != null){
                sum += t1.val;
            }
            if (t2 != null){
                sum += t2.val;
            }
            if (sum > 9){
                int value = sum % 10;
                carry = 1;
                ListNode newNode = new ListNode(value);
                curr.next = newNode;
                curr = curr.next;
            }else{
                carry = 0;
                ListNode newNode = new ListNode(sum);
                curr.next = newNode;
                curr = curr.next;
            }

            if(t1 != null){
                t1 = t1.next;
            }

            if(t2 != null){
                t2 = t2.next;
            }
        }

        if (carry != 0){
            ListNode temp = new ListNode(1);
            curr.next = temp;
        }

        return dummy.next;


    }


    // time complexity: O(max(n1, n2));
    // space complexity: O(max(n1, n2));



}
