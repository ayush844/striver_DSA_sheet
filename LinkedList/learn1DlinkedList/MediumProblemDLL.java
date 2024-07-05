import java.util.ArrayList;

class DoubleNode{
    int data;
    DoubleNode next;
    DoubleNode back;

    DoubleNode(int data, DoubleNode next, DoubleNode back){
        this.data = data;
        this.next = next;
        this.back = back;
    }

    DoubleNode(int data){
        this.data = data;
        this.next = null;
        this.back = null;
    }
}

public class MediumProblemDLL {

    //You are given the head_ref of a doubly Linked List and a Key. Your task is to delete all occurrences of the given key if it is present and return the new DLL.

    public  DoubleNode deleteAllOccurOfX(DoubleNode head, int x) {
        DoubleNode temp = head;

        while (temp != null){
            if (temp.data == x){
                if (temp == head){
                    head = head.next;
                }
                DoubleNode nextNode = temp.next;
                DoubleNode prevNode = temp.back;

                if (nextNode != null){
                    nextNode.back = prevNode;
                }
                if (prevNode != null){
                    prevNode.next = nextNode;
                }

                temp = nextNode;
            }else{
                temp = temp.next;
            }
        }

        return head;
    }

    // time complexity: O(N)
    // space complexity: O(1)


//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------


    //Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.


    // brute force approach:

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, ListNode head) {
        ListNode temp1 = head;

        ListNode temp2 = head;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        while (temp1 != null){

            temp2 = temp1.next;

            while (temp2 != null){
                int sum = temp1.val + temp2.val;
                if (sum == target){
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(temp1.val);
                    arr.add(temp2.val);
                    ans.add(arr);
                }

                if (sum > target){
                    break;
                }

                temp2 = temp2.next;

            }

            temp1 = temp1.next;
        }

        return ans;

    }


    // time complexity: O(N^2)
    // space complexity: O(1)


//------------------------------------------------------------------------------------------------------------

    // optimal approach:

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum2(int target, DoubleNode head) {
        DoubleNode left = head;
        DoubleNode right = head;

        while (right.next != null){
            right = right.next;
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        while (left.data < right.data){
            int sum = left.data + right.data;

            if (sum == target){
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(left.data);
                arr.add(right.data);

                ans.add(arr);

                left = left.next;
                right = right.back;
            } else if (sum < target) {
                left = left.next;
            }else{
                right = right.back;
            }
        }
        return ans;


    }


    // time complexity: O(2N)
    // space complexity: O(1)


//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

    // Given a doubly linked list of n nodes sorted by values, the task is to remove duplicate nodes present in the linked list.

    // my approach:
    public static DoubleNode removeDuplicates(DoubleNode head){
        DoubleNode temp = head;
        int curr = temp.data;

        temp = temp.next;

        while (temp != null){
            if (temp.data == curr){
                DoubleNode previ = temp.back;
                previ.next = temp.next;
                if(temp.next != null){
                    temp.next.back = previ;
                }
                temp = temp.next;
            }else{
                curr = temp.data;
                temp = temp.next;
            }
        }

        return head;

    }

    // time complexity: O(n)
    // space complexity: O(1)

//---------------------------------------------------------------------------------------------------------

    // striver approach:

    public static DoubleNode removeDuplicates2(DoubleNode head){
        DoubleNode temp = head;
        while (temp != null && temp.next != null){
            DoubleNode nextNode = temp.next;

            while (nextNode != null && temp.data == nextNode.data){
                nextNode = nextNode.next;
            }

            temp.next = nextNode;
            if (nextNode != null){
                nextNode.back = temp;
            }
            temp = temp.next;
        }
        return head;
    }

    // time complexity: O(n)
    // space complexity: O(1)






}
