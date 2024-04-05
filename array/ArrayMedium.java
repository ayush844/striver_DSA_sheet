import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class ArrayMedium {

    public static void main(String[] args) {

    }


    //Problem Statement: Given an array of integers arr[] and an integer target.
    //1st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.
    //2nd variant: Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.


    //brute force approach:

    // variant 1:
    public static String read(int n, int []book, int target){
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (book[i] + book[j] == target) return "YES";
            }
        }
        return "NO";
    }


    // variant 2:
    public static int[] read2(int n, int []book, int target){
        int[] arr = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (book[i] + book[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                };
            }
        }

        arr[0] = -1;
        arr[1] = -1;

        return arr;
    }


    //Time Complexity: O(N2), where N = size of the array.
    //Reason: There are two loops(i.e. nested) each running for approximately N times.
    //Space Complexity: O(1) as we are not using any extra space.


    //-------------------------------------------------------------------------------------------------------------

    // better approach:


// variant 1:
    public static String read3(int n, int []book, int target){
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++){
            int num = book[i];
            int remaining = target - num;

            if (hm.containsKey(remaining)){
                return "YES";
            }

            hm.put(num, i);
        }

        return "NO";
    }


// variant 2
    public static int[] read4(int n, int []book, int target){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] arr = new int[2];
        arr[0] = arr[1] = -1;
        for (int i = 0; i < n; i++){
            int num = book[i];
            int remaining = target - num;

            if (hm.containsKey(remaining)){
                arr[0] = i;
                arr[1] = hm.get(remaining);
                return arr;
            }

            hm.put(num, i);
        }

        return arr;
    }


    //Time Complexity: O(N), where N = size of the array.
    //Reason: The loop runs N times in the worst case and searching in a hashmap takes O(1) generally. So the time complexity is O(N).
    //
    //Note: In the worst case(which rarely happens), the unordered_map takes O(N) to find an element. In that case, the time complexity will be O(N2). If we use map instead of unordered_map, the time complexity will be O(N* logN) as the map data structure takes logN time to find an element.
    //
    //Space Complexity: O(N) as we use the map data structure.
    //
    //Note: We have optimized this problem enough. But if in the interview, we are not allowed to use the map data structure, then we should move on to the following approach i.e. two pointer approach. This approach will have the same time complexity as the better approach.

    //-------------------------------------------------------------------------------------------------------------

    // optimal approach:

    public static String read5(int n, int []book, int target){
        int start = 0;
        int last = n-1;

        Arrays.sort(book);

        while (start < last){
            int sum = book[start] + book[last];
            if (sum == target){
                return "YES";
            } else if (sum < target) {
                start++;
            }else {
                last--;
            }
        }

        return "NO";
    }


    //Time Complexity: O(N) + O(N*logN), where N = size of the array.
    //Reason: The loop will run at most N times. And sorting the array will take N*logN time complexity.
    
    //Space Complexity: O(1) as we are not using any extra space.

    //Note: Here we are distorting the given array. So, if we need to consider this change, the space complexity will be O(N).


//**************************************************************************************************************
//**************************************************************************************************************
//**************************************************************************************************************

    //You have been given an array/list 'arr' consisting of 'n' elements.
    //Each element in the array is either 0, 1 or 2.
    //Sort this array/list in increasing order.
    //Do not make a new array/list. Make changes in the given array/list.

    public static void sortArray(ArrayList<Integer> arr, int n) {
        int i = 0;
        int j = 0;
        int k = 0;

        for (Integer num : arr){
            if (num == 0){
                i++;
            } else if(num == 1){
                j++;
            }else{
                k++;
            }
        }

        arr.clear();

        for (int m = 0; m < i; m++){
            arr.add(0);
        }

        for (int m = 0; m < j; m++){
            arr.add(1);
        }

        for (int m = 0; m < k; m++){
            arr.add(2);
        }

    }


    //time complexity: O(2n)
    //space complexity: O(1)

    //---------------------------------------------------------------------------------------------------------

    //optimal solution

    //we'll use DNF(dutch national flag algo)

    public static void sortArray2(ArrayList<Integer> arr, int n) {
        int low = 0;
        int mid = 0;
        int high = n-1;

        while (mid <= high){
            if (arr.get(mid) == 0){

                int temp = arr.get(low);
                arr.set(low, arr.get(mid));
                arr.set(mid, temp);

                mid++;
                low++;

            } else if (arr.get(mid) == 1) {
                mid++;
            }else{

                int temp = arr.get(high);
                arr.set(high, arr.get(mid));
                arr.set(mid, temp);

                high--;

            }
        }

    }

    //Time Complexity: O(N), where N = size of the given array.
    //Reason: We are using a single loop that can run at most N times.
    //Space Complexity: O(1) as we are not using any extra space.

//**************************************************************************************************************
//**************************************************************************************************************
//**************************************************************************************************************

//You are given an array 'a' of 'n' integers.
//A majority element in the array ‘a’ is an element that appears more than 'n' / 2 times.
//Find the majority element of the array.
//It is guaranteed that the array 'a' always has a majority element.


    public static int majorityElement(int []v) {
        int half = v.length / 2;
        for (Integer x : v){
            int freq = 0;
            for (int i = 0; i < v.length; i++){
                if (v[i] == x){
                    freq++;
                }
            }
            if (freq > half){
                return x;
            }
        }
        return -1;
    }

    // time complexity: O(n^2)

//------------------------------------------------------------------------------------------------------------

    public static int majorityElement2(int []v) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (Integer num : v){
            if (hm.containsKey(num)){
                hm.put(num, hm.get(num)+1);
            }else{
                hm.put(num, 1);
            }
        }
        int half = v.length/2;
        for (Map.Entry<Integer, Integer> mp : hm.entrySet()){
            if (mp.getValue() > half){
                return mp.getKey();
            }
        }
        return -1;
    }

//Time Complexity: O(N*logN) + O(N), where N = size of the given array.
//Reason: We are using a map data structure. Insertion in the map takes logN time. And we are doing it for N elements. So, it results in the first term O(N*logN). The second O(N) is for checking which element occurs more than floor(N/2) times. If we use unordered_map instead, the first term will be O(N) for the best and average case and for the worst case, it will be O(N2).
//
//Space Complexity: O(N) as we are using a map data structure.

//------------------------------------------------------------------------------------------------------------

    // MOORE's VOTING ALGO

    public static int majorityElement3(int []v) {
        int n = v.length;

        int elem = 0;
        int count = 0;
        
        for (int i = 0; i < n; i++){
            if (count == 0){
                count = 1;
                elem = v[i];
            } else if (elem == v[i]) {
                count++;
            }else{
                count--;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++){
            if (v[i] == elem){
                cnt++;
            }
        }

        if (cnt > n/2){
            return elem;
        }else{
            return -1;
        }
    }

//Time Complexity: O(N) + O(N), where N = size of the given array.
//Reason: The first O(N) is to calculate the count and find the expected majority element. The second one is to check if the expected element is the majority one or not.

//**************************************************************************************************************
//**************************************************************************************************************
//**************************************************************************************************************

    //Given an integer array arr, find the contiguous subarray (containing at least one number) which
    //has the largest sum and returns its sum and prints the subarray.


    // brute force approach:

    public static long maxSubarraySum(int[] arr, int n) {
        long maxSum = Long.MIN_VALUE;


        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                int sum = 0;
                for (int k = i; k <= j; k++){
                    sum += arr[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;

    }

    //Time Complexity: O(N3), where N = size of the array.
    //Reason: We are using three nested loops, each running approximately N times.
    //Space Complexity: O(1) as we are not using any extra space.

//-------------------------------------------------------------------------------------------------------------

    // better approach:

    public static long maxSubarraySum2(int[] arr, int n) {
        long maxSum = Long.MIN_VALUE;

        for (int i = 0; i < n; i++){
            int sum = 0;
            for (int j = i; j < n; j++){
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;

    }

    //Time Complexity: O(N2), where N = size of the array.
    //Reason: We are using two nested loops, each running approximately N times.
    //Space Complexity: O(1) as we are not using any extra space.

//-------------------------------------------------------------------------------------------------------------

    // Kadane's Algorithm(optimal approach)

    public static long maxSubarraySum3(int[] arr, int n) {

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            sum += arr[i];
            maxSum = Math.max(sum, maxSum);
            if (sum < 0){
                sum = 0;
            }
        }

        return maxSum;

    }

    //Time Complexity: O(N), where N = size of the array.
    //Reason: We are using a single loop running N times.
    //Space Complexity: O(1) as we are not using any extra space.

//-------------------------------------------------------------------------------------------------------------

    // follow up question:

    //You are given an array 'a' of size 'n' and an integer 'k'.
    //Find the length of the longest subarray of 'a' whose sum is equal to 'k'.
    //[each element of array is >= 0]

    public static int longestSubarrayWithSumK(int []a, long k) {

        int left = 0;
        int right = 0;
        int maxlen = 0;
        long sum = a[0];
        int n = a.length;

        while (right < n) {
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            if (sum == k) {
                maxlen = Math.max(maxlen, right - left + 1);
            }

            right++;

            if (right < n) {
                sum += a[right];
            }
        }

        return maxlen;

    }

//**************************************************************************************************************
//**************************************************************************************************************
//**************************************************************************************************************


    // You are given an array of prices where prices[i] is the price of a given stock on an ith day.
    //You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

    //BRUTE FORCE APPROACH:
    public static int bestTimeToBuyAndSellStock(int []prices) {

        int n = prices.length;

        int maxProfit = 0;

        for (int buy = 0; buy < n-1; buy++){
            for (int sell = buy+1; sell<n; sell++){
                int profit = prices[sell] - prices[buy];
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;

    }

    //Time complexity: O(n^2)
    //Space Complexity: O(1)

//-----------------------------------------------------------------------------------------------------------

    // OPTIMAL APPROACH

    //We will linearly travel the array. We can maintain a minimum from the start of the array and compare it with every element of the array, if it is greater than the minimum then take the difference and maintain it in max, otherwise update the minimum.

    public static int bestTimeToBuyAndSellStock2(int []prices) {

        int n = prices.length;

        int minElement = prices[0];

        int max = 0;

        for (int i = 0; i < n; i++){
            if (prices[i] <= minElement){
                minElement = prices[i];
            }else {
                int profit = prices[i] - minElement;
                max = Math.max(max, profit);
            }
        }

        return max;

    }

//**************************************************************************************************************
//**************************************************************************************************************
//**************************************************************************************************************

//    Variety-1

//    Problem Statement:
// There’s an array ‘A’ of size ‘N’ with an equal number of positive and negative elements. Without altering the relative order of positive and negative elements, you must return an array of alternately positive and negative values.

//    Note: Start the array with positive elements.

    public static int[] alternateNumbers(int []a) {

        int pos_index = 0, neg_index = 1;
        int[] ans = new int[a.length];

        for (int i = 0; i < a.length; i++){
            if (a[i] >= 0){
                ans[pos_index] = a[i];
                pos_index+=2;
            }else{
                ans[neg_index] = a[i];
                neg_index += 2;
            }
        }

        return ans;

    }

//--------------------------------------------------------------------------------------------------------------

//Variety-2
//Problem Statement:
//There’s an array ‘A’ of size ‘N’ with positive and negative elements (not necessarily equal). Without altering the relative order of positive and negative elements, you must return an array of alternately positive and negative values. The leftover elements should be placed at the very end in the same order as in array A.
//Note: Start the array with positive elements.

    public static ArrayList<Integer> RearrangebySign(ArrayList<Integer> A) {
        int n = A.size();

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i = 0; i < n; i++){
            if (A.get(i) >= 0){
                pos.add(A.get(i));
            }else{
                neg.add(A.get(i));
            }
        }

        // if possitives are less than negatives
        if (pos.size() < neg.size()){
            for (int i = 0; i < pos.size(); i++){
                A.set(2*i, pos.get(i));
                A.set(2*i + 1, neg.get(i));
            }
            int index = pos.size()*2;
            for (int i = pos.size(); i < neg.size(); i++){
                A.set(index, neg.get(i));
                index++;
            }
        }

        // if negatives are less than possitives
        else {
            for (int i = 0; i < neg.size(); i++){
                A.set(2*i, pos.get(i));
                A.set(2*i+1, neg.get(i));
            }
            int index = neg.size()*2;
            for (int i = neg.size()*2; i < pos.size(); i++){
                A.set(index, pos.get(i));
                index++;
            }
        }
        return A;
    }


//**************************************************************************************************************
//**************************************************************************************************************
//**************************************************************************************************************

    //A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
    //
    //For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
    //The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
    //
    //For example, the next permutation of arr = [1,2,3] is [1,3,2].
    //Similarly, the next permutation of arr = [2,3,1] is [3,1,2].




//***** BRUTE FORCE APPROACH *****//
    //Step 1: Find all possible permutations of elements present and store them.
    //Step 2: Search input from all possible permutations.
    //Step 3: Print the next permutation present right after it.

//Complexity Analysis
//For finding, all possible permutations, it is taking N!xN. N represents the number of elements present in the input array. Also for searching input arrays from all possible permutations will take N!. Therefore, it has a Time complexity of O(N!xN).
//
//Space Complexity :
//Since we are not using any extra spaces except stack spaces for recursion calls. So, it has a space complexity of O(1).


//---------------------------------------------------------------------------------------------------------

//***** BEST APPROACH *****//


    //> Find the break-point, i: Break-point means the first index i from the back of the given array where arr[i] becomes smaller than arr[i+1].
    //For example, if the given array is {2,1,5,4,3,0,0}, the break-point will be index 1(0-based indexing). Here from the back of the array, index 1 is the first index where arr[1] i.e. 1 is smaller than arr[i+1] i.e. 5.
    //To find the break-point, using a loop we will traverse the array backward and store the index i where arr[i] is less than the value at index (i+1) i.e. arr[i+1].

    //> If such a break-point does not exist i.e. if the array is sorted in decreasing order, the given permutation is the last one in the sorted order of all possible permutations. So, the next permutation must be the first i.e. the permutation in increasing order.
    //So, in this case, we will reverse the whole array and will return it as our answer.

    //> If a break-point exists:
    //Find the smallest number i.e. > arr[i] and in the right half of index i(i.e. from index i+1 to n-1) and swap it with arr[i].
    //Reverse the entire right half(i.e. from index i+1 to n-1) of index i. And finally, return the array.


    public static List< Integer > nextGreaterPermutation(List< Integer > A) {
        // finding the break point
        int n = A.size();
        int index = -1;
        for (int i = n-2; i >= 0 ; i--){
            if (A.get(i) < A.get(i+1)){
                index = i;
                break;
            }
        }

        if (index == -1){
            Collections.reverse(A);
            return A;
        }

        //find the next biggest element after the A[index]

        for (int i = n-1; i > index; i--){
            if (A.get(i) > A.get(index)){
                // swap these 2 elements
                int temp = A.get(i);
                A.set(i, A.get(index));
                A.set(index, temp);

                break;
            }
        }


        //reverse the right half

        List<Integer> subList = A.subList(index+1, n);
        Collections.reverse(subList);

        return A;

    }

    //    //Time Complexity: O(3N), where N = size of the given array
    //    //Finding the break-point, finding the next greater element, and reversal at the end takes O(N) for each, where N is the number of elements in the input array. This sums up to 3*O(N) which is approximately O(3N).
    //    //
    //    //Space Complexity: Since no extra storage is required. Thus, its space complexity is O(1).

//-----------------------------------------------------------------------------------------------------
    // if we have to do it for array not arrayList
    public void nextPermutation(int[] A) {
        if(A == null || A.length <= 1) return;
        int i = A.length - 2;
        while(i >= 0 && A[i] >= A[i + 1]) i--; // Find 1st id i that breaks descending order
        if(i >= 0) {                           // If not entirely descending
            int j = A.length - 1;              // Start from the end
            while(A[j] <= A[i]) j--;           // Find rightmost first larger id j
            swap(A, i, j);                     // Switch i and j
        }
        reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }


//**************************************************************************************************************
//**************************************************************************************************************
//**************************************************************************************************************

//There is an integer array ‘a’ of size ‘n’.
//An element is called a Superior Element if it is greater than all the elements present to its right.
//You must return an array all Superior Elements in the array ‘a’.

    // brute force approach

    public static List< Integer > superiorElements(int []a) {
        int n = a.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++){
            Boolean leader = true;

            for (int j = i+1; j < n; j++){
                leader = false;
                break;
            }
            if (leader){
                ans.add(a[i]);
            }
        }

        return ans;
    }

    //Time Complexity: O(N^2) { Since there are nested loops being used, at the worst case n^2 time would be consumed }.
    //Space Complexity: O(N) { There is no extra space being used in this approach. But, a O(N) of space for ans array will be used in the worst case }.

//------------------------------------------------------------------------------------------------------------

    // optimal approach

    public static List< Integer > superiorElements2(int []a) {
        int n = a.length;
        List<Integer> ans = new ArrayList<>();

        int max = a[n-1];
        ans.add(a[n-1]);

        for (int i = n-2; i >= 0; i--){
            if (a[i] > max){
                ans.add(a[i]);
                max = a[i];
            }
        }

        return ans;
    }

//Time Complexity: O(N) { Since the array is traversed single time back to front, it will consume O(N) of time where N = size of the array }.
//
//Space Complexity: O(N) { There is no extra space being used in this approach. But, a O(N) of space for ans array will be used in the worst case }.


//**************************************************************************************************************
//**************************************************************************************************************
//**************************************************************************************************************

    //There is an integer array ‘A’ of size ‘N’.
    //A sequence is successive when the adjacent elements of the sequence have a difference of 1.
    //You must return the length of the longest successive sequence.
    //Note:
    //You can reorder the array to form a sequence.

    //For example,
    //Input:
    //A = [5, 8, 3, 2, 1, 4], N = 6
    //Output:
    //5


// BRUTE FORCE SOLUTION


    public static int longestSuccessiveElements(int []a) {
        int n = a.length;
        int longestCount = 1;

        for (int i = 0; i < n ;i++){
            int element = a[i];
            int count = 1;

            while (isPresent(a, element+1)){
                count++;
                element++;
            }

            longestCount = Math.max(longestCount, count);
        }

        return longestCount;
    }

    public static boolean isPresent(int[] arr, int x){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            if (arr[i] == x){
                return true;
            }
        }
        return false;
    }

    //Time Complexity: O(N2), N = size of the given array.
    //Reason: We are using nested loops each running for approximately N times.
    //
    //Space Complexity: O(1), as we are not using any extra space to solve this problem.


//----------------------------------------------------------------------------------------------------------------

    // BETTER SOLUTION

    public static int longestSuccessiveElements2(int []a) {
        int longest = 1;
        int count = 0;

        int lastLowest = Integer.MIN_VALUE;

        int n = a.length;

        Arrays.sort(a);

        for (int i = 0; i < n; i++){
            if (a[i] - 1 == lastLowest){
                count+=1;
                lastLowest = a[i];
            } else if (a[i] != lastLowest) {
                count = 1;
                lastLowest = a[i];
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    //Time Complexity: O(NlogN) + O(N), N = size of the given array.
    //Reason: O(NlogN) for sorting the array. To find the longest sequence, we are using a loop that results in O(N).
    //
    //Space Complexity: O(1), as we are not using any extra space to solve this problem.

//--------------------------------------------------------------------------------------------------------------


    public static int longestSuccessiveElements3(int []a) {
        int n = a.length;

        if (n == 0){
            return 0;
        }

        int longest = 1;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++){
            set.add(a[i]);
        }

        for (int it: set){
            if (!set.contains(it - 1)){
                int cnt = 1;
                int x = it;

                while (set.contains(x+1)){
                    x = x+1;
                    cnt = cnt+1;
                }

                longest = Math.max(longest, cnt);
            }
        }

        return longest;

    }


    //Time Complexity: O(N) + O(2*N) ~ O(3*N), where N = size of the array.
    //Reason: O(N) for putting all the elements into the set data structure. After that for every starting element, we are finding the consecutive elements. Though we are using nested loops, the set will be traversed at most twice in the worst case. So, the time complexity is O(2*N) instead of O(N2).
    //
    //Space Complexity: O(N), as we are using the set data structure to solve this problem.
    //
    //Note: The time complexity is computed under the assumption that we are using unordered_set and it is taking O(1) for the set operations.
    //
    //If we consider the worst case the set operations will take O(N) in that case and the total time complexity will be approximately O(N2).
    //And if we use the set instead of unordered_set, the time complexity for the set operations will be O(logN) and the total time complexity will be O(NlogN).


//**************************************************************************************************************
//**************************************************************************************************************
//**************************************************************************************************************

// Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.

    //BRUTE FORCE APPROACH:

    public static void markRow(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m, Integer i){
        for (int j = 0; j < m; j++){
            if (matrix.get(i).get(j) != 0){
                matrix.get(i).set(j, -1);
            }
        }
    }

    public static void markCol(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m, Integer j){
        for (int i = 0; i < n; i++){
            if (matrix.get(i).get(j) != 0){
                matrix.get(i).set(j, -1);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (matrix.get(i).get(j) == 0){
                    markRow(matrix, n, m, i);
                    markCol(matrix, n, m, j);
                }
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (matrix.get(i).get(j) == -1){
                    matrix.get(i).set(j, 0);
                }
            }
        }


        return matrix;


    }

    //Time Complexity: O((N*M)*(N + M)) + O(N*M), where N = no. of rows in the matrix and M = no. of columns in the matrix.
    //Reason: Firstly, we are traversing the matrix to find the cells with the value 0. It takes O(N*M). Now, whenever we find any such cell we mark that row and column with -1. This process takes O(N+M). So, combining this the whole process, finding and marking, takes O((N*M)*(N + M)).
    //Another O(N*M) is taken to mark all the cells with -1 as 0 finally.
    //
    //Space Complexity: O(1) as we are not using any extra space.

//--------------------------------------------------------------------------------------------------------------

    // BETTER APPROACH:

    public static ArrayList<ArrayList<Integer>> zeroMatrix2(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {

        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (matrix.get(i).get(j) == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j< m; j++){
                if (row[i] == 1 || col[j] == 1){
                    matrix.get(i).set(j, 0);
                }
            }
        }

        return matrix;

    }

//Time Complexity: O(2*(N*M)), where N = no. of rows in the matrix and M = no. of columns in the matrix.
//Reason: We are traversing the entire matrix 2 times and each traversal is taking O(N*M) time complexity.
//
//Space Complexity: O(N) + O(M), where N = no. of rows in the matrix and M = no. of columns in the matrix.
//Reason: O(N) is for using the row array and O(M) is for using the col array.

//-------------------------------------------------------------------------------------------------------------

    // OPTIMAL SOLUTION

    public static ArrayList<ArrayList<Integer>> zeroMatrix3(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {

        int col0 = 1;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (matrix.get(i).get(j) == 0){
                    matrix.get(i).set(0, 0);

                    if (j != 0){
                        matrix.get(0).set(j, 0);
                    }else{
                        col0 = 0;
                    }

                }
            }
        }

        for (int i = 1; i < n; i++){
            for (int j = 1; j< m; j++){
                if (matrix.get(0).get(j) == 0 || matrix.get(i).get(0) == 0){
                    matrix.get(i).set(j, 0);
                }
            }
        }

        if (matrix.get(0).get(0) == 0){
            for (int j = 0 ; j < m; j++){
                matrix.get(0).set(j, 0);
            }
        }

        if (col0 == 0){
            for (int i = 0 ; i < n; i++){
                matrix.get(i).set(0, 0);
            }
        }

        return matrix;

    }


    //Time Complexity: O(2*(N*M)), where N = no. of rows in the matrix and M = no. of columns in the matrix.
    //Reason: In this approach, we are also traversing the entire matrix 2 times and each traversal is taking O(N*M) time complexity.
    //
    //Space Complexity: O(1) as we are not using any extra space.



//**************************************************************************************************************
//**************************************************************************************************************
//**************************************************************************************************************


    //You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
    //You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.



    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // for transposing the matrix
        for (int i = 0; i < n; i++){
            for (int j = i; j < m; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m-j-1];
                matrix[i][m-j-1] = temp;
            }
        }
    }

    //Time Complexity: O(N*N) + O(N*N).One O(N*N) is for transposing the matrix and the other is for reversing the matrix.
    //
    //Space Complexity: O(1).



//**************************************************************************************************************
//**************************************************************************************************************
//**************************************************************************************************************


    //You are given a 2D matrix ‘MATRIX’ of ‘N’*’M’ dimension. You have to return the spiral traversal of the matrix.

    //Example:
    //Input:
    //MATRIX = [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60] ]
    //Output:
    //1 3 5 7 20 60 34 30 23 10 11 16


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = m-1;

        while (top<=bottom && left<=right){

            for (int i = left; i <= right; i++){
                ans.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom){
                for (int i = right; i >= left; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right){
                for (int i = bottom; i >= top; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }


    //Time Complexity: O(m x n) { Since all the elements are being traversed once and there are total n x m elements ( m elements in each row and total n rows) so the time complexity will be O(n x m)}.

    //Space Complexity: O(n) { Extra Space used for storing traversal in the ans array }.


//**************************************************************************************************************
//**************************************************************************************************************
//**************************************************************************************************************

    //You are given an integer array 'arr' of size 'N' and an integer 'K'.
    //Your task is to find the total number of subarrays of the given array whose sum of elements is equal to k.
    //A subarray is defined as a contiguous block of elements in the array.

    //Example:
    //Input: ‘N’ = 4, ‘arr’ = [3, 1, 2, 4], 'K' = 6
    //Output: 2


    //BRUTE FORCE APPROACH

    public static int findAllSubarraysWithGivenSum(int arr[], int s) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                int sum = 0;
                for (int k = i; k <=j; k++){
                    sum += arr[k];
                }
                if (sum == s){
                    count++;
                }
            }
        }
        return count;
    }

    //Time Complexity: O(N3), where N = size of the array.
    //Reason: We are using three nested loops here. Though all are not running for exactly N times, the time complexity will be approximately O(N3).
    //
    //Space Complexity: O(1) as we are not using any extra space.

//-------------------------------------------------------------------------------------------------------------

    // BETTER APPROACH

    public static int findAllSubarraysWithGivenSum2(int arr[], int s) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++){
            int sum = 0;
            for (int j = i; j < n; j++){
                sum += arr[j];
                if (sum == s){
                    count++;
                }
            }
        }
        return count;
    }

    //Time Complexity: O(N2), where N = size of the array.
    //Reason: We are using two nested loops here. As each of them is running for exactly N times, the time complexity will be approximately O(N2).
    //
    //Space Complexity: O(1) as we are not using any extra space.

//----------------------------------------------------------------------------------------------------------

    // BEST APPROACH:

    public static int findAllSubarraysWithGivenSum3(int arr[], int k) {
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int cnt = 0;
        int presum = 0;

        mp.put(0, 1);
        for (int i = 0; i < n; i++){
            presum += arr[i];

            int remove = presum - k;

            cnt += mp.getOrDefault(remove, 0);

            mp.put(presum, mp.getOrDefault(presum, 0) + 1);
        }

        return cnt;
    }

    //Time Complexity: O(N) or O(N*logN) depending on which map data structure we are using, where N = size of the array.
            //Reason: For example, if we are using an unordered_map data structure in C++ the time complexity will be O(N) but if we are using a map data structure, the time complexity will be O(N*logN). The least complexity will be O(N) as we are using a loop to traverse the array.

    //Note: To know more about maps, please refer to this: Hashing | Maps | Time Complexity | Collisions | Division Rule of Hashing | Strivers A2Z DSA Course.

    //Space Complexity: O(N) as we are using a map data structure.

//**************************************************************************************************************
//**************************************************************************************************************
//**************************************************************************************************************

}
