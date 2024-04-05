import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class ArrayBasics {

    //Java array is an object which contains elements of a similar data type. Additionally, The elements of an array are stored in a contiguous memory location. It is a data structure where we store similar elements. We can store only a fixed set of elements in a Java array.
    // by default value of each element in array is 0 when the array is initialised

    // max length of array that we can declare is 10^6(inside int main()) and 10^7(in global)

    public static void main(String[] args) {
        System.out.println("hello");

        int arr[] = {1, 1, 2, 2, 2, 3, 4, 5, 6};
        System.out.println(largestElement(arr, 7));

        System.out.println(removeDuplicates(arr, 9));

        int myArr[] = {1, 2, 3, 4, 5, 6};

        rotateArrayByK(myArr, 8);

        for (int i = 0; i < 6; i++){
            System.out.print(myArr[i] + " ");
        }

        System.out.println();


    }

    //**********************************************************************************************************

    // Given an array ‘arr’ of size ‘n’ find the largest element in the array.

    public static int largestElement(int[] arr, int n) {
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > largest){
                largest = arr[i];
            }
        }
        return largest;
    }

    //Time Complexity: O(N)
    //Space Complexity: O(1)

    //**********************************************************************************************************

    //You have been given an array ‘a’ of ‘n’ unique non-negative integers.
    //Find the second largest and second smallest element from the array.


    public static int[] getSecondOrderElements(int n, int []a) {
        int largest = a[0];
        int slargest = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++){
            if (a[i] > largest){
                slargest = largest;
                largest = a[i];
            } else if (a[i] > slargest) {
                slargest = a[i];
            }
        }

        int smallest = a[0];
        int ssmallest = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++){
            if (a[i] < smallest){
                ssmallest = smallest;
                smallest = a[i];
            } else if (a[i] < ssmallest) {
                ssmallest = a[i];
            }
        }

        int[] arr = {slargest, ssmallest};

        return arr;

    }

    //Time Complexity: O(N), Single-pass solution
    //Space Complexity: O(1)

    //**********************************************************************************************************

    //You have been given an array ‘a’ of ‘n’ non-negative integers.You have to check whether the given array is sorted in the non-decreasing order or not.
    //Your task is to return 1 if the given array is sorted. Else, return 0.

    public static int isSorted(int n, int []a) {
        for (int i = 1; i < n; i++){
            if (a[i] < a[i-1]){
                return 0;
            }
        }
        return 1;
    }

    //Space Complexity: O(1)

    //Time Complexity: O(N)

//----------------------------------------------------------------------------------------------------------

    //Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.
    //
    //There may be duplicates in the original array.
    //
    //Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

    //class Solution {
    //    public boolean check(int[] nums) {
    //        int k = 0;
    //        int n = nums.length;
    //        for (int i = 0; i < n; i++){
    //            if (nums[i] > nums[(i+1)%n]){
    //                k++;
    //            }
    //            if(k>1){
    //                return false;
    //            }
    //        }
    //        return true;
    //    }
    //}

    //**********************************************************************************************************


    //You are given a sorted integer array 'arr' of size 'n'.
    //You need to remove the duplicates from the array such that each element appears only once.
    //Return the length of this new array.

    public static int removeDuplicates(int[] arr,int n) {
        int count = 0;
        for (int i = 0; i < n-1; i++){
            if (arr[i] != arr[i+1]){
                count++;
            }
        }
        count++;

        return count;
    }


    //another better approach:

    //    static int removeDuplicates(int[] arr) {
    //        int i = 0;
    //        for (int j = 1; j < arr.length; j++) {
    //            if (arr[i] != arr[j]) {
    //                i++;
    //                arr[i] = arr[j];
    //            }
    //        }
    //        return i + 1;
    //    }

    //Time Complexity: O(N)
    //Space Complexity: O(1)

    //**********************************************************************************************************

    //Given an array 'arr' containing 'n' elements, rotate this array left once and return it.
    //Rotating the array left by one means shifting all elements by one place to the left and moving the first element to the last position in the array.

    public static int[] rotateArray(int[] arr, int n) {
        int temp = arr[0]; // storing the first element of array in a variable
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = temp; // assigned the value of variable at the last index
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        return arr;
    }

    //Time Complexity: O(n), as we iterate through the array only once.
    //Space Complexity: O(1) as no extra space is used

    //**********************************************************************************************************

    //Given an array 'arr' with 'n' elements, the task is to rotate the array to the left by 'k' steps, where 'k' is non-negative.

    public static void rotateArrayByK(int[] arr, int k) {

        int n = arr.length;

        if (n==0){
            return;
        }

        k = k % n;

        int[] temp = new int[k];

        for (int i = 0; i < k; i++){
            temp[i] = arr[i];
        }

        for (int i = 0; i < n-k; i++){
            arr[i] = arr[i+k];
        }

        for (int i = n-k; i < n; i++) {
            arr[i] = temp[i - n + k];
        }

    }

    // time complexity = O(k) + O(n-k) + O(k) = O(n+k)
    // space complexity = O(k) [extra space]


    //rotate by right
//***************************************************************************************************************

    // >>> https://leetcode.com/problems/rotate-array/solutions/1730142/java-c-python-a-very-very-well-detailed-explanation/
    public static void reverse(int nums[], int i, int j){
        int li = i;
        int ri = j;

        while(li < ri){
            int temp = nums[li];
            nums[li] = nums[ri];
            nums[ri] = temp;

            li++;
            ri--;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k < 0){
            k += nums.length;
        }
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

//****************************************************************************************************************
    public static void rotateArrayByK2(ArrayList<Integer> arr, int k) {

        int n = arr.size();

        if (n==0){
            return;
        }

        k = k % n;

        int[] temp = new int[k];

        for (int i = 0; i < k; i++){
            temp[i] = arr.get(i);
        }

        for (int i = 0; i < n-k; i++){
            arr.set(i, arr.get(i+k));
        }

        for (int i = n-k; i < n; i++) {
            arr.set(i, temp[i - n + k]);
        }

    }


    //*******************************************************************************************************

    // Given an array 'arr' of 'n' non-negative integers, your task is to move all the zeros to the end of the array while keeping the non-zero elements at the start of the array in their original order. Return the modified array.

    // brute force approach:

    //public static int[] moveZeros(int n, int []a) {
    //        //temporary array:

    //        ArrayList<Integer> temp = new ArrayList<>();

    //        //copy non-zero elements
    //        //from original -> temp array:

    //        for (int i = 0; i < n; i++) {
    //            if (a[i] != 0)
    //                temp.add(a[i]);
    //        }
    //
    //        // number of non-zero elements.

    //        int nz = temp.size();
    //
    //        //copy elements from temp
    //        //fill first nz fields of
    //        //original array:

    //        for (int i = 0; i < nz; i++) {
    //            a[i] = temp.get(i);
    //        }
    //
    //        //fill rest of the cells with 0:

    //        for (int i = nz; i < n; i++) {
    //            a[i] = 0;
    //        }
    //        return a;
    //  }

    //Time Complexity: O(N) + O(X) + O(N-X) ~ O(2*N), where N = total no. of elements,
    //X = no. of non-zero elements, and N-X = total no. of zeros.
    //Reason: O(N) for copying non-zero elements from the original to the temporary array. O(X) for again copying it back from the temporary to the original array. O(N-X) for filling zeros in the original array. So, the total time complexity will be O(2*N).
    //
    //Space Complexity: O(N), as we are using a temporary array to solve this problem and the maximum size of the array can be N in the worst case.
    //Reason: The temporary array stores the non-zero elements. In the worst case, all the given array elements will be non-zero.


    //-----------------------------------------------------------------------------------------------------

    // optimal approach
//2 pointer approach
    public static int[] moveZeros(int n, int []a) {

        int j = -1;

        for (int i = 0; i < n; i++){
            if (a[i] == 0){
                j = i;
                break;
            }
        }

        if (j==-1) return a;

        for (int i = j+1; i < n; i++){
            if (a[i] != 0){
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                j++;
            }
        }

        return a;
    }

    //Time Complexity: O(N), N = size of the array.
    //    Reason: We have used 2 loops and using those loops, we are basically traversing the array once.
    // Space Complexity: O(1) as we are not using any extra space to solve this problem.


    //************************************************************************************************************


    //Given two sorted arrays, ‘a’ and ‘b’, of size ‘n’ and ‘m’, respectively, return the union of the arrays.
    //The union of two sorted arrays can be defined as an array consisting of the common and the distinct elements of the two arrays. The final array should be sorted in ascending order.
    //Note: 'a' and 'b' may contain duplicate elements, but the union array must contain unique elements.


    // brute force approach:

    // here we are using TreeSet becoz we want to keep the elements in order and also sorted
    public static List< Integer > sortedArray(int []a, int []b) {
        TreeSet<Integer> ts = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i : a){
            ts.add(i);
        }

        for (int i : b){
            ts.add(i);
        }

        for (int i : ts){
            list.add(i);
        }

        return list;

    }


    // insertion in set takes O(log(n)),

    // n1 => size of array a
    // n2 => size of array b
    // 'n' typically refers to the number of elements in the TreeSet after insertion.
    // time complexity: O(n1*Log(n) + n2*Log(n)) + O(n1+n2)
    // space complexity:
    // O(n1+n2){for set, if all elements are unique} + O(n1+n2){for list, it is only used to return the answer}


    // *** OPTIMAL APPROACH ***

    public static List< Integer > sortedArray2(int []a, int []b) {
        List<Integer> Union = new ArrayList<>();

        int i = 0;
        int j = 0;
        int m = a.length;
        int n = b.length;

        while (i < m && j < n){
            if (a[i] <= b[j]){
                if (Union.size() == 0 || Union.get(Union.size()-1) != a[i]) {
                    Union.add(a[i]);
                    i++;
                }
            }else{
                if (Union.size() == 0 || Union.get(Union.size()-1) != b[j]) {
                    Union.add(b[j]);
                    j++;
                }
            }
        }

        while (i < m){
            if (Union.get(Union.size()-1) != a[i]) {
                Union.add(a[i]);
                i++;
            }
        }

        while (j < n){
            if (Union.get(Union.size()-1) != b[j]) {
                Union.add(b[j]);
                j++;
            }
        }

        return Union;

    }


    //Time Complexity: O(m+n), Because at max i runs for n times and j runs for m times. When there are no common elements in arr1 and arr2 and all elements in arr1, arr2 are distinct.

    //Space Complexity : O(m+n) {If Space of Union ArrayList is considered}
    //O(1) {If Space of union ArrayList is not considered}


//***************************************************************************************************************

    //Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

    //BRUTE FORCE APPROACH:

    public int missingNumber(int[] nums) {
        int n = nums.length;

        // therefore, array contains number between 0 to n (with one number missing)

        //looping through 0 to n (all possible value of missing number)
        for(int i = 0; i <= n; i++){


            int flag = 0; //will tell if we found the number in array or not

            //looping through length of array
            for(int j = 0; j < n; j++){
                if(i == nums[j]){
                    flag = 1;
                    break;
                }
            }

            if(flag == 0){
                return i;
            }
        }

        return -1;
    }

    //Time Complexity: O(N2), where N = size of the array+1.
    //Reason: In the worst case i.e. if the missing number is N itself, the outer loop will run for N times, and for every single number the inner loop will also run for approximately N times. So, the total time complexity will be O(N2).
    //Space Complexity: O(1)  as we are not using any extra space.


    // BETTER APPROACH:

    public int missingNumber2(int[] nums) {
        int n = nums.length;

        //making our hash array:
        int[] hashArray = new int[n+1];// all elements in this will have initial value 0

        // increasing value from 0 to 1 in hash array, if the value is found in nums array
        for (int i = 0; i < nums.length; i++){
            hashArray[nums[i]]++;
        }

        // finding the element whose hash value is still 0
        for (int i = 0; i < hashArray.length; i++){
            if (hashArray[i] == 0){
                return i;
            }
        }
        return -1;
    }

    //Time Complexity: O(N) + O(N) ~ O(2*N),  where N = size of the array+1.
    //Reason: For storing the frequencies in the hash array, the program takes O(N) time complexity and for checking the frequencies in the second step again O(N) is required. So, the total time complexity is O(N) + O(N).
    //Space Complexity: O(N), where N = size of the array+1. Here we are using an extra hash array of size N+1.


    //OPTIMAL APPROACH:

    public int missingNumber3(int[] nums) {
        int n = nums.length;

        // array contains 0 to n

        // sum of first n numbers:
        int sum = n*(n+1)/2;

        int s = 0; // sum of elements in array
        for (int i = 0; i < n; i++){
            s += nums[i];
        }

        int missingNum = sum -= s;

        return missingNum;

    }

    //Time Complexity: O(N), where N = size of array+1.
    //Reason: Here, we need only 1 loop to get the sum of the array elements. The loop runs for approx. N times. So, the time complexity is O(N).
    //Space Complexity: O(1) as we are not using any extra space.

//****************************************************************************************************************

    // Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array.


    public int findMaxOnes(int[] arr){

        int count = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 1){
                count++;
            }else{
                count = 0;
            }

            max = Math.max(count, max);
        }

        return max;

    }


//**************************************************************************************************************

    //You are given a sorted array 'arr' of positive integers of size 'n'.
    //It contains each number exactly twice except for one number, which occurs exactly once.
    //Find the number that occurs exactly once.

    public static int getSingleElement(int []arr){
        int i = 0;
        while (i < arr.length-1){
            if (arr[i] == arr[i+1]){
                i+=2;
            }else{
                break;
            }
        }

        return arr[i];
    }


    //Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    //You must implement a solution with a linear runtime complexity and use only constant extra space.
    //Example 1:
    //Input: nums = [2,2,1]
    //Output: 1
    //Example 2:
    //Input: nums = [4,1,2,1,2]
    //Output: 4
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0; i<nums.length; i++) {
            result = result^nums[i];
        }
        return result;
    }

    //Time Complexity: O(N), where N = size of the array.
    //Reason: We are iterating the array only once.
    //
    //Space Complexity: O(1) as we are not using any extra space.

//**************************************************************************************************************

    //You are given an array 'a' of size 'n' and an integer 'k'.
    //Find the length of the longest subarray of 'a' whose sum is equal to 'k'.

    // brute force approach:
    public static int longestSubarrayWithSumK(int []a, int k) {
        int n = a.length;
        int length = 0;
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                long sum = 0;
                for (int m = i; m <= j; m++) {
                    sum += a[m];
                }

                if (sum == k){
                    length = Math.max(length, j-i+1);
                }

            }
        }

        return length;
    }

    //Time Complexity: O(N3) approx., where N = size of the array.
    //Reason: We are using three nested loops, each running approximately N times.
    //Space Complexity: O(1) as we are not using any extra space.

    //------------------------------------------------------------------------------------------------------

    // better approach:

    public static int longestSubarrayWithSumK2(int []a, int k) {
        int n = a.length;
        int length = 0;
        for (int i = 0; i < n; i++){
            long sum = 0;
            for (int j = i; j < n; j++){
                sum += a[j];
                if (sum == k){
                    length = Math.max(length, j-i+1);
                }

            }
        }

        return length;
    }

    //Time Complexity: O(N2) approx., where N = size of the array.
    //Reason: We are using three nested loops, each running approximately N times.
    //Space Complexity: O(1) as we are not using any extra space.

    //------------------------------------------------------------------------------------------------------

    // much better approach:

    public static int longestSubarrayWithSumK3(int []a, int k) {
        int n = a.length;

        HashMap<Long, Integer> hm = new HashMap<>();

        long sum = 0;

        int maxLen = 0;

        for (int i = 0; i < n; i++){
            sum += a[i];

            if (sum == k){
                maxLen = Math.max(maxLen, i+1);
            }

            long rem = sum-k;

            if (hm.containsKey(rem)){
                int len = i - hm.get(rem);
                maxLen = Math.max(maxLen, len);
            }else{
                hm.put(sum, i);
            }
        }

        return maxLen;
    }

    //Time Complexity: O(N) or O(N*logN) depending on which map data structure we are using, where N = size of the array.
    //Reason: For example, if we are using an unordered_map data structure in C++ the time complexity will be O(N)(though in the worst case, unordered_map takes O(N) to find an element and the time complexity becomes O(N2)) but if we are using a map data structure, the time complexity will be O(N*logN). The least complexity will be O(N) as we are using a loop to traverse the array.
    //Space Complexity: O(N) as we are using a map data structure.

    //------------------------------------------------------------------------------------------------------

    // OPTIMAL SOLUTION *******

    public static int longestSubarrayWithSumK4(int []a, int k) {
        int n = a.length;

        int left = 0, right = 0;

        long sum = a[0];

        int maxLen = 0;

        while (right < n){

            while (left <= right && sum > k){
                sum-=a[left];
                left++;
            }

            if (sum == k){
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;

            if (right < n){
                sum += a[right];
            }

        }
        return maxLen;
    }

    //Time Complexity: O(2*N), where N = size of the given array.
    //Reason: The outer while loop i.e. the right pointer can move up to index n-1(the last index). Now, the inner while loop i.e. the left pointer can move up to the right pointer at most. So, every time the inner loop does not run for n times rather it can run for n times in total. So, the time complexity will be O(2*N) instead of O(N2).

    //Space Complexity: O(1) as we are not using any extra space.


//**************************************************************************************************************

}
