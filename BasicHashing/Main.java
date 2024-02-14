import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Given an array of integers: [1, 2, 1, 3, 2] and we are given some queries: [1, 3, 4, 2, 10]. For each query, we need to find out how many times the number appears in the array. For example, if the query is 1 our answer would be 2, and if the query is 4 the answer will be 0.

//        Scanner sc = new Scanner(System.in);
//

        //one array will keep the array(containing elements between 0 to 12) where we want to search an element

//        // making the array in which we want to search
//        int n;
//        n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
        //we'll ask usr to add number b/w 0 to 12
//            arr[i] = sc.nextInt();
//        }
//
//        //precompute:
//        int[] hash = new int[13];//array of 13(with all element 0) if we can ask for number b/w 0 to 12
//        for (int i = 0; i < n; i++) {
//            hash[arr[i]] += 1;  //adding 1 to the number if we find it
//        }
//
//        // to get the number whose total appearance we want to search:
//        int q;  //total no of numbers we want to know
//        q = sc.nextInt();
//        while (q-- != 0) {
//            int number; // number which we want to search for
//            number = sc.nextInt();
//            // fetching:
//            System.out.println(hash[number]); // get the total number of appearence
//        }

        // TIME COMPLEXITY:
        //We have learned how to compute the time complexity of any code. The above function contains a for loop that runs for N times. So, the time complexity of the function will be O(N) ignoring the other constant operations.
        //Now, for each query, we are calling this function. So, if the query contains 5 numbers and we call the function 5 times, the total time complexity will be O(5*N). If the number of queries is Q, the time complexity will be O(Q*N).

        //*************************************************************************************************
        //We may encounter a problem where the maximum array element may be very large like 109. In that case, theoretically, we should declare an array of size 109+1. But we cannot do so. The maximum size of an array of type int can be 10^6(inside main function) & 10^7(global)
        //*************************************************************************************************

//  HASHING FOR CHARACTERS:

//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//
//        int[] hash = new int[26];
//        for (int i = 0; i < s.length(); i++){
//            hash[s.charAt(i) - 'a']++;
//        }
//
//        int q;
//        q = sc.nextInt();
//        while (q-- > 0){
//            char c;
//            c = sc.next().charAt(0);
//
//            System.out.println(hash[c-'a']);
//        }


        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


        // if we want to include both uppercase and lowercase
//
//        Scanner sc = new Scanner(System.in);
//
//        String s;
//        s = sc.next();
//
//        //precompute:
//        int[] hash = new int[256];    // there are 256 ASCII characters
//        for (int i = 0; i < s.length(); i++) {
//            hash[s.charAt(i)]++;
//        }
//
//        int q;
//        q = sc.nextInt();
//        while (q-- > 0) {
//            char c;
//            c = sc.next().charAt(0);
//            // fetch:
//            System.out.println(hash[c]);
//        }

        //********************************************************************************//
        // for character hashing we should always go with the above array method
        //********************************************************************************//


        // for number, we'll use hashmaps, to store data as keys and their frequency as its value

        Scanner sc = new Scanner(System.in);

        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //precompute:
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            int freq = 0;
            if (mp.containsKey(key)) freq = mp.get(key); // fetching freq of the key from the map
            freq++;
            mp.put(key, freq); // inserting into the map
        }

        // Iterate over the map:
        /*
        for (Map.Entry<Integer, Integer> it : mp.entrySet()) {
            System.out.println(it.getKey() + "->" + it.getValue());
        }
        */

        int q;
        q = sc.nextInt();
        while (q-- > 0) {
            int number;
            number = sc.nextInt();
            // fetch:
            if (mp.containsKey(number)) System.out.println(mp.get(number));
            else System.out.println(0);
        }

        //*****map stores all value in sorted order*****

        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        //we can also store characters using map where characters will be key and value will be their frequency.

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


        //TIME COMPLEXITY

//        For HashMap in Java:
//        Average-case time complexity: O(1) for both insertion and retrieval.
//        Worst-case time complexity: O(n) for both insertion and retrieval (due to collisions).

//        But in the worst case, this time complexity will be O(N) for unordered_map. Now, the worst case occurs          very very rarely. It almost never happens and most of the time, we will be using unordered_map.

//        Note: Our first priority will be always to use unordered_map and then map. If unordered_map gives a             time limit exceeded error(TLE), we will then use the map.
//        The time complexity in the worst case is O(N) because of the internal collision.


// Division Method: study it from striver notes

    // collision:
        //Now, if we are applying linear chaining and division rule and we find that all elements of an array get stored in a single index, then we will call it a case of collision.
        //Now, while fetching we have to traverse N times(N = size of the given array) to find the frequency of an element. This is when the worst case happens and the time complexity becomes O(N). But this happens very rarely.
        //Whatever method the map is using, if all the elements go to the same hash index, we will call it a case of collision.


        //Note: In the map data structure, the data type of key can be anything like int, double, pair<int, int>, etc. But for unordered_map the data type is limited to integer, double, string, etc. We cannot have an unordered_map whose key is pair<int, int>.


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------






    }
}