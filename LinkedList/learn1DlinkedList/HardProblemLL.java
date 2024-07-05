import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class DifferentNode
{
    int data;
    DifferentNode next;
    DifferentNode bottom;

    DifferentNode(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}

class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


public class HardProblemLL {


//    Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
//    k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
//    You may not alter the values in the list's nodes, only nodes themselves may be changed.


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

    public ListNode findKthNode(ListNode temp, int k){
        k-=1;
        while (temp != null && k > 0){
            k--;
            temp = temp.next;
        }
        return temp;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;

        while (temp != null){
            ListNode KthNode = findKthNode(temp, k);
            if (KthNode == null){
                if (prevNode != null){
                    prevNode.next = temp;
                }
                break;
            }
            ListNode nextNode = KthNode.next;
            KthNode.next = null;

            reverseLinkedList(temp);

            if (temp == head){
                head = KthNode;
            }else{
                prevNode.next = KthNode;
            }

            prevNode = temp;
            temp = nextNode;


        }

        return head;

    }

    //Time Complexity: O(2N) The time complexity consists of actions of reversing segments of K and finding the Kth node which operates in linear time. Thus, O(N) + O(N) = O(2N), which simplifies to O(N).

    //Space Complexity: O(1) The space complexity is O(1) as the algorithm operates in place without any additional space requirements.

//--------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------

    // Given the head of a linked list, rotate the list to the right by k places.

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode tail = head;

        int len = 1;

        while (tail.next != null){
            len++;
            tail = tail.next;
        }

        k = k%len;

        if (k == 0){
            return head;
        }

        tail.next = head;

        int newTailLen = len - k;

        ListNode temp = head;

        for (int i = 0; i < newTailLen-1; i++){
            temp = temp.next;
        }

        ListNode newHead = temp.next;

        temp.next = null;

        return newHead;

    }

    // time complexity: O(2N)
    // space complexity: O(1)

//--------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------

    //Given a Linked List of size n, where every node represents a sub-linked-list and contains two pointers:
    //(i) a next pointer to the next node,
    //(ii) a bottom pointer to a linked list where this node is head.
    //Each of the sub-linked-list is in sorted order.
    //Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order.
    //
    //Note: The flattened list will be printed using the bottom pointer instead of the next pointer.
    //For more clarity have a look at the printList() function in the driver code.


    // brute force approach:

    public DifferentNode convertToLL(ArrayList<Integer> arr){
        DifferentNode dummy = new DifferentNode(-1);
        int len = arr.size();

        if (len == 0){
            return null;
        }

        DifferentNode temp = dummy;

        for (int i = 0; i < len; i++){
            temp.bottom = new DifferentNode(arr.get(i));
            temp = temp.bottom;
        }

        return dummy.bottom;
    }


// n is the size of horizontal list
// m is the size of vertical list

    public DifferentNode flatten(DifferentNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        DifferentNode temp = root;

        while (temp != null){           // TC: O(n*m)
            DifferentNode t2 = temp;
            while (t2 != null){
                arr.add(t2.data);
                t2 = t2.bottom;
            }
            temp = temp.next;
        }

        Collections.sort(arr);  // TC: x * log(x) [where x = n*m]

        return convertToLL(arr);    // TC: O(n*m)

    }

    // time complexity: O((n*m)*2 + x*log(x)) [where x = n*m]
    // space complexity: O(n*m*2)


//---------------------------------------------------------------------------------------------------------------



    public DifferentNode merge2List(DifferentNode list1, DifferentNode list2){
        DifferentNode dummy = new DifferentNode(-1);
        DifferentNode res = dummy;

        while (list1 != null && list2 != null){
            if (list1.data < list2.data){
                res.bottom = list1;
                res = list1;
                list1 = list1.bottom;
            }else{
                res.bottom = list2;
                res = list2;
                list2 = list2.bottom;
            }
            res.next = null;
        }

        if (list1 != null){
            res.bottom = list1;
        }else{
            res.bottom = list2;
        }

        return dummy.bottom;
    }


    public DifferentNode flatten2(DifferentNode root) {
        if (root == null || root.next == null){
            return root;
        }

        DifferentNode merged = flatten(root.next);

        DifferentNode result = merge2List(merged, root);

        return result;
    }


    //Time Complexity: O( N*(2M) ) ~ O(2 N*M)where N is the length of the linked list along the next pointer and M is the length of the linked list along the child pointers.
    //
    //The merge operation in each recursive call takes time complexity proportional to the length of the linked lists being merged as they have to iterate over the entire lists. Since the vertical depth of the linked lists is assume to be M, the time complexity for a single merge operation is proportional to O(2*M).
    //This operation operation is performed N number of times (to each and every node along the next pointer list) hence the resultant time complexity becomes: O(N* 2M).


    //Space Complexity : O(1) as this algorithm uses no external space or additional data structures to store values. But a recursive stack uses O(N) space to build the recursive calls for each node along the next pointer list.

//--------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------

//A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
//
//Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
//For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
//
//Return the head of the copied linked list.
//The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
//val: an integer representing Node.val
//random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
//Your code will only be given the head of the original linked list.



    // BRUTE FORCE APPROACH

    public RandomNode copyRandomList(RandomNode head) {
        RandomNode temp = head;

        HashMap<RandomNode, RandomNode> map = new HashMap<>();

        while (temp != null){
            RandomNode cloneNode = new RandomNode(temp.val);

            map.put(temp, cloneNode);

            temp = temp.next;
        }

        temp = head;

        while (temp != null){
            RandomNode cloneNode = map.get(temp);
            cloneNode.next = map.get(temp.next);
            cloneNode.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);


    }

    //Time Complexity: O(2N) where N is the number of nodes in the linked list. The linked list is traversed twice, once for creating copies of each node and for the second time to set the next and random pointers for each copied node. The time to access the nodes in the map is O(1) due to hashing.
    //
    //Space Complexity : O(N)+O(N)where N is the number of nodes in the linked list as all nodes are stored in the map to maintain mappings and the copied linked lists takes O(N) space as well.

//------------------------------------------------------------------------------------------------------------


    //  OPTIMAL APPROACH

    public RandomNode insertCopyNodeInBetween(RandomNode head){
        RandomNode temp = head;
        while (temp != null){
            RandomNode nextNode = temp.next;
            RandomNode cloneNode = new RandomNode(temp.val);
            temp.next = cloneNode;
            cloneNode.next = nextNode;
            temp = nextNode;
        }
        return head;
    }

    public void connectRandomPointers(RandomNode head){
        RandomNode temp = head;

        while (temp!=null){
            RandomNode cloneNode = temp.next;

            if (temp.random != null){
                cloneNode.random = temp.random.next;
            }else{
                cloneNode.random = null;
            }

            temp = temp.next.next;
        }

    }

    public RandomNode getDeepCopy(RandomNode head){
        RandomNode temp = head;
        RandomNode dummy = new RandomNode(-1);
        RandomNode result = dummy;

        while (temp != null){
            result.next = temp.next;
            result = result.next;

            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummy.next;
    }

    public RandomNode copyRandomList2(RandomNode head) {
        if (head == null){
            return null;
        }

        head = insertCopyNodeInBetween(head);

        connectRandomPointers(head);

        return getDeepCopy(head);


    }

//Time Complexity: O(3N)where N is the number of nodes in the linked list. The algorithm makes three traversals of the linked list, once to create copies and insert them between original nodes, then to set the random pointers of the copied nodes to their appropriate copied nodes and then to separate the copied and original nodes.
//
//Space Complexity : O(N) where N is the number of nodes in the linked list as the only extra additional space allocated it to create the copied list without creating any other additional data structures.



//--------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------


    







}
