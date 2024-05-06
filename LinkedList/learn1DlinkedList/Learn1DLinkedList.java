class Node{
    int data;
    Node next;

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class Learn1DLinkedList {


    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 9};

        Node y = new Node(arr[0]);

        System.out.println(y.data); //2
        System.out.println(y.next); //null


        // convert an array to a linked list
        int[] newArr = {2, 4, 6, 7, 9, 11, 13, 15, 17, 19};
        Node head = constructLL(newArr);

        // traversal in a linked list
        traverseLL(head);   //2 -> 4 -> 6 -> 7 -> 9 -> 11 -> 13 -> 15 -> 17 -> 19

        // length of linked list
        System.out.println(lengthOfLL(head));   // 10

        //searching in linked list
        System.out.println(searchLL(head, 4));  // 1

        // DELETION:

        // Delete first element
        head = constructLL(newArr);
        traverseLL(DeleteFirst(head));  // 4 -> 6 -> 7 -> 9 -> 11 -> 13 -> 15 -> 17 -> 19

        // Delete the last element
        head = constructLL(newArr);
        traverseLL(DeleteLast(head));   // 2 -> 4 -> 6 -> 7 -> 9 -> 11 -> 13 -> 15 -> 17

        // Delete a particular position in linked list
        head = constructLL(newArr);
        traverseLL(DeletePosition(head, 9));    // 2 -> 4 -> 6 -> 7 -> 9 -> 11 -> 13 -> 15 -> 19

        // Delete a particular value in linked list
        head = constructLL(newArr);
        traverseLL(DeleteValue(head, 11));  // 2 -> 4 -> 6 -> 7 -> 9 -> 13 -> 15 -> 17 -> 19


        // INSERTION:

        //2 -> 4 -> 6 -> 7 -> 9 -> 11 -> 13 -> 15 -> 17 -> 19

        // Insert the first element:
        head = constructLL(newArr);
        traverseLL(InsertFirst(head, 1));   // 1 -> 2 -> 4 -> 6 -> 7 -> 9 -> 11 -> 13 -> 15 -> 17 -> 19

        // Insert the last element:
        head = constructLL(newArr);
        traverseLL(InsertLast(head, 21));   // 2 -> 4 -> 6 -> 7 -> 9 -> 11 -> 13 -> 15 -> 17 -> 19 -> 21

        // Insert element at given position in linked list :
        head = constructLL(newArr);
        traverseLL(InsertPosition(head, 101, 6));  // 2 -> 4 -> 6 -> 7 -> 9 -> 101 -> 11 -> 13 -> 15 -> 17 -> 19





    }


    // convert an array to a linked list
    private static Node constructLL(int []arr) {
        Node head = new Node(arr[0]);

        Node mover = head;

        for(int i = 1; i < arr.length; i++){
            Node newNode = new Node(arr[i]);

            mover.next = newNode;
            mover = newNode;

        }

        return head;

    }


    // traversal in linked list
    private static void traverseLL(Node head) {
        Node temp = head;
        for (; temp != null; temp = temp.next){
            System.out.print(temp.data);

            if (temp.next != null){
                System.out.print(" -> ");
            }

        }
        System.out.println();
    }


    // length of linked list
    private static int lengthOfLL(Node head) {
        Node temp = head;
        int count = 0;
        for (; temp != null; temp = temp.next){
            count++;
        }

        return count;
    }



    // search in linked list
    private static int searchLL(Node head, int k) {
        Node temp = head;
        for (; temp != null; temp = temp.next){

            if (temp.data == k){
                return 1;
            }

        }

        return 0;
    }



    //DELETION IN LINKED LIST

    // deleting from starting of the linked list
    private static Node DeleteFirst(Node head) {
        if (head == null){
            return head;
        }

        head = head.next;

        return head;
    }

    // deleting from last of the linked list
    private static Node DeleteLast(Node head) {
        if (head == null || head.next == null){
            return null;
        }

        Node temp = head;

        while (temp.next.next != null){
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }


    // deleting a particular position in the linked list
    private static Node DeletePosition(Node head, int k) {

        if (k > lengthOfLL(head) || k < 1 || head == null){
            System.out.println("INVALID POSITION or INVALID LINKED LIST");
            return head;
        }



        if (k == 1){
            head = head.next;
            return head;
        } else {
            Node temp = head;
            for (int i = 1; i < k-1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }


        return head;
    }

    // deleting a particular position in the linked list
    private static Node DeleteValue(Node head, int value) {

        if (head == null){
            System.out.println("INVALID LINKED LIST");
            return head;
        }

        if (head.data == value){
            head = head.next;
            return head;
        }

        Node temp = head;
        Node prev = null;

        while (temp != null){
            if (temp.data == value){
                prev.next = temp.next;
                return head;
            }
            prev = temp;
            temp = temp.next;
        }

        System.out.println("value not found");
        return head;

    }




    //INSERTION IN LINKED LIST

    // insertion from starting of the linked list
    private static Node InsertFirst(Node head, int value) {
        if (head == null){
            return new Node(value);
        }
        Node temp = new Node(value, head);
        head = temp;
        return head;
    }

    // insertion from last of the linked list
    private static Node InsertLast(Node head, int value) {

        if (head == null){
            return new Node(value);
        }

        Node newNode = new Node(value);

       Node temp = head;

       while (temp.next != null){
           temp = temp.next;
       }

       temp.next = newNode;

        return head;
    }


    // insertion at a given position in the linked list
    private static Node InsertPosition(Node head, int value, int k) {

        if (head == null){
            return new Node(value);
        }

        if (k < 1 || k > lengthOfLL(head)+1){
            System.out.println("Invalid position");
            return head;
        }

        if (k == 1){
            return new Node(value, head);
        }

        Node newNode = new Node(value);

        Node temp = head;

        for (int i = 1; i < k-1; i++){
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }



}
