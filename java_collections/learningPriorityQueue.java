import java.util.Comparator;
import java.util.PriorityQueue;

public class learningPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // we can use all the functions here that we learned in queue

        pq.offer(90);
        pq.offer(12);
        pq.offer(24);
        pq.offer(36);
        pq.offer(19);

        System.out.println(pq); // [12, 19, 24, 90, 36] -> we get the answer in increasing order (min heap)


        System.out.println(pq.poll()); // 12
        System.out.println(pq); // [19, 36, 24, 90]


        System.out.println(pq.peek()); // 19


        PriorityQueue<Integer> newPQ = new PriorityQueue<>(Comparator.reverseOrder());

        newPQ.offer(90);
        newPQ.offer(12);
        newPQ.offer(24);
        newPQ.offer(36);
        newPQ.offer(19);

        System.out.println(newPQ); // [90, 36, 24, 12, 19]


    }

}
