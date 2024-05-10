import java.util.Stack;

class DoublyNode{
    int data;
    DoublyNode next;
    DoublyNode back;

    DoublyNode(int data, DoublyNode next, DoublyNode back){
        this.data = data;
        this.next = next;
        this.back = back;
    }

    DoublyNode(int data){
        this.data = data;
        this.next = null;
        this.back = null;
    }
}



public class LearnDoublyLinkedList {



    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        DoublyNode head = convert2Dll(arr);
        System.out.println(head.next.data);

        // deleting head
        head = deleteHeadIn2DLL(head);
        traverseLL(head); //2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 11 -> 12

        // deleting tail
        head = deleteTailIn2DLL(head);
        traverseLL(head); //2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 11

        // deleting at kth position in 2d-LL
        head = deleteAtKthPositionIn2DLL(head, 7);
        traverseLL(head); //2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 9 -> 10 -> 11

        // delete the given node from the linked list
        deleteGivenNodeIn2DLL(head.next);
        traverseLL(head);   // 2 -> 4 -> 5 -> 6 -> 7 -> 9 -> 10 -> 11

        // inserting a node before head
        head = insertingAtHeadIn2DLL(head, 101);
        traverseLL(head); //101 -> 2 -> 4 -> 5 -> 6 -> 7 -> 9 -> 10 -> 11

        // inserting a node before tail
        head = insertingBeforTailIn2DLL(head, 102);
        traverseLL(head);
        // 101 -> 2 -> 4 -> 5 -> 6 -> 7 -> 9 -> 10 -> 102 -> 11

        // inserting a node before kth position
        head = insertingBeforeKPositionIn2DLL(head, 103, 4);
        traverseLL(head);
        // 101 -> 2 -> 4 -> 103 -> 5 -> 6 -> 7 -> 9 -> 10 -> 102 -> 11


        // inserting a node before the given node
        head = insertingBeforeGivenNodeIn2DLL(head, 104, 11);
        traverseLL(head);
        // 101 -> 2 -> 4 -> 103 -> 5 -> 6 -> 7 -> 9 -> 10 -> 102 -> 104 -> 11


        // reversing a doubly linked list
        head = reverseDLL(head);
        traverseLL(head);
        // 11 -> 104 -> 102 -> 10 -> 9 -> 7 -> 6 -> 5 -> 103 -> 4 -> 2 -> 101


    }

    public static DoublyNode convert2Dll(int[] arr){

        if(arr.length == 0){
            return null;
        }

        DoublyNode head = new DoublyNode(arr[0]);
        DoublyNode prev = head;

        for (int i  = 1; i < arr.length; i++){
            DoublyNode newNode = new DoublyNode(arr[i], null, prev);
            prev.next = newNode;
            prev = newNode;
        }

        return head;
    }

    // traversal in linked list
    private static void traverseLL(DoublyNode head) {
        DoublyNode temp = head;
        for (; temp != null; temp = temp.next){
            System.out.print(temp.data);

            if (temp.next != null){
                System.out.print(" -> ");
            }

        }
        System.out.println();
    }

//    length of linked list
    private static int lengthOfLL(DoublyNode head) {
        DoublyNode temp = head;
        int count = 0;
        for (; temp != null; temp = temp.next){
            count++;
        }

        return count;
    }


// deleting head
    public static DoublyNode deleteHeadIn2DLL(DoublyNode head){
        if (head == null || head.next == null){
            return null;
        }

        DoublyNode prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;

        return head;
    }

// deleting tail
    public static DoublyNode deleteTailIn2DLL(DoublyNode head){
        if (head == null || head.next == null){
            return null;
        }

        DoublyNode temp = head.next;

        while (temp.next != null){
            temp = temp.next;
        }

        DoublyNode prev = temp.back;

        temp.back = null;
        prev.next = null;

        return head;
    }


// deleting at Kth position
    public static DoublyNode deleteAtKthPositionIn2DLL(DoublyNode head, int k){
        if (head == null){

            return null;
        }

        if (k < 1 || k > lengthOfLL(head)){
            System.out.println("invalid position");
            return null;
        }

        DoublyNode temp = head;
        int count = 0;
        while (temp != null){

            count++;

            if (count == k){
                break;
            }

            temp = temp.next;
        }

        DoublyNode prevNode = temp.back;
        DoublyNode nextNode = temp.next;


        if (prevNode == null && nextNode == null){
            return null;
        } else if (prevNode == null) {
            return deleteHeadIn2DLL(head);
        }else if (nextNode == null){
            return deleteTailIn2DLL(head);
        }else{
            temp.back = null;
            temp.next = null;
            prevNode.next = nextNode;
            nextNode.back = prevNode;


            return head;
        }


    }


// deleting the given node
    public static void deleteGivenNodeIn2DLL(DoublyNode node){

        DoublyNode prevNode = node.back;
        DoublyNode nextNode = node.next;

        if (nextNode == null){
            prevNode.next = null;
            node.back = null;
            return;
        }

        prevNode.next = nextNode;
        nextNode.back = prevNode;

        node.next = null;
        node.back = null;


    }



    // inserting a node before the head
    public static DoublyNode insertingAtHeadIn2DLL(DoublyNode head, int value){
        if (head == null){
            return null;
        }

        DoublyNode temp = new DoublyNode(value, head, null);

        head.back = temp;

        head = temp;

        return head;
    }


    // inserting a node before the tail
    public static DoublyNode insertingBeforTailIn2DLL(DoublyNode head, int value){
        if (head == null){
            return null;
        }

        DoublyNode temp = head;

        while (temp.next != null){
            temp = temp.next;
        }

        DoublyNode newNode = new DoublyNode(value, temp, temp.back);

        newNode.back.next = newNode;
        newNode.next.back = newNode;



        return head;
    }



    // inserting a node before the kth position
    public static DoublyNode insertingBeforeKPositionIn2DLL(DoublyNode head, int value, int k){
        if (head == null){
            return null;
        }

        if (k < 1 || k > lengthOfLL(head)){
            System.out.println("invalid position");
            return null;
        }

        if (k == 1){
            return insertingAtHeadIn2DLL(head, value);
        }

        if (k == lengthOfLL(head)){
            return insertingBeforTailIn2DLL(head, value);
        }


        DoublyNode temp = head;

        int count = 0;

        while (temp.next != null){
            count++;

            if (count == k){
                break;
            }

            temp = temp.next;
        }

        DoublyNode newNode = new DoublyNode(value, temp, temp.back);

        newNode.back.next = newNode;
        newNode.next.back = newNode;

        return head;
    }



    // inserting a node before the given node
    public static DoublyNode insertingBeforeGivenNodeIn2DLL(DoublyNode head, int value, int data){
        if (head == null){
            return null;
        }


        DoublyNode temp = head;

        Boolean found = false;

        while (temp.next != null){

            if (temp.data == data){
                found = true;
                break;
            }

            temp = temp.next;
        }

        DoublyNode newNode = new DoublyNode(value, temp, temp.back);

        if(temp == head){
            return newNode;
        }


        newNode.back.next = newNode;
        newNode.next.back = newNode;

        return head;
    }

//----------------------------------------------------------------------------------------------------------------

//  Reverse a Doubly Linked List:

    public static DoublyNode reverseDLL(DoublyNode head){

        DoublyNode temp = head;

        Stack<Integer> stack = new Stack<>();

        while (temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;

        while (temp != null){
            temp.data = stack.pop();
            temp = temp.next;
        }

        return head;

    }
//Time Complexity : O(2N) During the first traversal, each node's value is pushed into the stack once, which requires O(N) time. Then, during the second iteration, the values are popped from the stack and used to update the nodes. Space Complexity : O(N) This is because we are using an external stack data structure. At the end of the first iteration, the stack will hold all N values of the doubly linked list therefore the space required for stack is directly proportional to the size of the input doubly linked list.
//    SPACE COMPLEXITY: O(n);

//****************************************************************************************************
// BETTER SOLUTION:

    public static DoublyNode reverseDLL2(DoublyNode head){

        if(head==null || head.next == null){
            return head;
        }

        DoublyNode prev = null;
        DoublyNode current = head;

        while (current != null){

            prev = current.back;
            current.back = current.next;
            current.next = prev;

            current = current.back;

        }

        return prev.back;

    }

    //Time Complexity : O(N) We only have to traverse the doubly linked list once, hence our time complexity is O(N).
    //
    //Space Complexity : O(1), as the reversal is done in place.

//****************************************************************************************************


        

}
