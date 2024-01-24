import java.util.LinkedList;
import java.util.Queue;

public class learningQueueAndLinkedList {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        // to add elements in queue
        queue.offer(12);
        queue.offer(24);
        queue.offer(36);
        queue.offer(48);
        queue.offer(60);

        System.out.println("our queue is " + queue); // our queue is [12, 24, 36, 48, 60]


        //to remove lements in queue

        System.out.println(queue.poll()); // 12

        System.out.println(queue); // [24, 36, 48, 60]


        //peek tells the next element that will be popped out
        System.out.println(queue.peek()); // 24






    }

}
