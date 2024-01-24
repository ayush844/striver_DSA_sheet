import java.util.ArrayDeque;

public class learningArrayDeque {

    public static void main(String[] args) {
        ArrayDeque<Integer> adq = new ArrayDeque<>();
        adq.offer(23);
        adq.offerFirst(45);
        adq.offerLast(89);

        // offer and offer last are doing the same thing i.e. adding the element in the last but the offerFirst is adding the element in startr of queue

        System.out.println(adq);
        // [45, 23, 89]


        System.out.println(adq.peek()); // 45
        System.out.println(adq.peekFirst());  // 45
        System.out.println(adq.peekLast()); // 89

        System.out.println(adq.poll()); // 45
        System.out.println("poll() " +adq);  // poll() [23, 89]

        System.out.println(adq.pollFirst());  // 23
        System.out.println("pollFirst() " +adq);  //  pollFirst() [89]

        System.out.println(adq.pollLast());  // 89
        System.out.println("pollLast() " +adq);  //  pollLast() []
    }

}
