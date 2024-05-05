import java.util.*;

public class ArrayHard {

    public static void main(String[] args) {
        int n = 5;
        pascalTriangleRow(n);
    }
//*************************************************************************************************************
//*************************************************************************************************************
//***************************************************************************************************************

//You are given an integer ‘N’. You need to return the first ‘N’ rows of Pascal’s triangle.
//Example:
//Input:
//N = 4
//Output:
//1
//1 1
//1 2 1
//1 3 3 1
//Explanation: The output matrix has the first four rows of Pascal’s Triangle.

// Variation 1
// In this case, we are given the row number r and the column number c, and we need to find out the element at position (r,c).

    //formulae:
    // Element at (r, c) place => (r-1)C(c-1) [indexing is from 1 to n]

    // nCr = n!/r!*(n-r)!
    //OR
    // 10C3 = 10*9*8/3*2*1

    public static long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++){
            res = res * (n-i);
            res = res / (i+1);
        }

        return res;
    }

    public static int pascalTriangle(int r, int c) {
        // 1 to n indexing
        int element = (int) nCr(r - 1, c - 1);
        return element;

    }

    // time complexity: O(r)
    // space complexity: O(1)

//-------------------------------------------------------------------------------------------------------------

    //Variation 2
    //Given the row number n. Print the n-th row of Pascal’s triangle.


    // brute force solution
    // since we can get each element at a given position by using the above trick(nCr), we can find all elements in a particular row

    // OPTIMAL SOLUTION:

    static void pascalTriangleRow(int n) {

        long ans = 1;
        System.out.print(ans + " ");

        // 0 to n-1 indexing is followed here
        for (int i = 1; i < n; i++){
            ans = ans*(n-i);
            ans = ans/i;
            System.out.print(ans + " ");
        }

        System.out.println();

    }

    //Time Complexity: O(N) where N = given row number. Here we are using only a single loop.
    //
    //Space Complexity: O(1) as we not using any extra space.

//-------------------------------------------------------------------------------------------------------------

    //Variation 3
    //draw the whole pascal triangle for given number of rows



    public static List<Integer> getRow(int n) {

        List<Integer> arr = new ArrayList<>();

        long ans = 1;

        arr.add(1);

        // 0 to n-1 indexing is followed here
        for (int i = 1; i < n; i++){
            ans = ans*(n-i);
            ans = ans/i;
            arr.add((int) ans);
        }

        return arr;

    }

    public static List<List<Integer>> pascalTriangle2(int n){
        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 1; i <= n; i++){
            arr.add(getRow(i));
        }

        return arr;
    }

    //Time Complexity: O(n2), where n = number of rows(given).
    //Reason: We are generating a row for each single row. The number of rows is n. And generating an entire row takes O(n) time complexity.
    //
    //Space Complexity: In this case, we are only using space to store the answer. That is why space complexity can still be considered as O(1).

//*************************************************************************************************************
//*************************************************************************************************************
//***************************************************************************************************************

// Majority Elements(&gt;N/3 times) | Find the elements that appears more than N/3 times in the array

    //BETTER APPROACH:

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> hm = new HashMap<>();

        int minFreq = (int)Math.ceil(n/3);


        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++){
            if (hm.containsKey(nums[i])){
                hm.put(nums[i], hm.get(nums[i]) + 1);
            }else{
                hm.put(nums[i], 1);
            }

            if (hm.get(nums[i]) == minFreq){
                list.add(nums[i]);
            }

            if (list.size() == 2){
                break;
            }

        }

        return list;

    }

    //Time Complexity: O(N*logN), where N = size of the given array.
    //Reason: We are using a map data structure. Insertion in the map takes logN time. And we are doing it for N elements. So, it results in the first term O(N*logN).
    //If we use unordered_map instead, the first term will be O(N) for the best and average case and for the worst case, it will be O(N2).
    //
    //Space Complexity: O(N) as we are using a map data structure. We are also using a list that stores a maximum of 2 elements. That space used is so small that it can be considered constant.

//----------------------------------------------------------------------------------------------------------------


    // OPTIMAL SOLUTION

    public List<Integer> majorityElement2(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

        int n = nums.length;

        for (int i = 0; i < n; i++){
            if (count1 == 0 && nums[i] != element2){
                count1++;
                element1 = nums[i];
            } else if (count2 == 0 && nums[i] != element1) {
                count2++;
                element2 = nums[i];
            } else if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        List<Integer> ls = new ArrayList<>();

        count1 = 0; count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == element1) count1++;
            if (nums[i] == element2) count2++;
        }

        int mini = (int)(n / 3) + 1;
        if (count1 >= mini) ls.add(element1);
        if (count2 >= mini) ls.add(element2);

        return ls;

    }

//*************************************************************************************************************
//*************************************************************************************************************
//***************************************************************************************************************

    //3 SUM PROBLEM:
//Problem Statement: Given an array of N integers, your task is to find unique triplets that add up to give a sum of zero. In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]] such that i!=j, j!=k, k!=i, and their sum is equal to zero.

    // BRUTE FORCE APPROACH:

    public static List< List < Integer > > triplet(int n, int []arr) {
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }

    //Time Complexity: O(N3 * log(no. of unique triplets)), where N = size of the array.
    //Reason: Here, we are mainly using 3 nested loops. And inserting triplets into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.
    //
    //Space Complexity: O(2 * no. of the unique triplets) as we are using a set data structure and a list to store the triplets.

//--------------------------------------------------------------------------------------------------------------

    // BETTER APPROACH:
    public static List<List<Integer>> triplet2(int n, int []arr) {
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++){
            //this hashset stores the different element in array
            Set<Integer> hashSet = new HashSet<>();
            for (int j = i+1; j < n; j++){
                int third = -(arr[i] + arr[j]);
                if (hashSet.contains(third)){
                    List<Integer> al = Arrays.asList(arr[i], arr[j], third);
                    al.sort(null);
                    set.add(al);
                }
                hashSet.add(arr[j]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);

        return ans;


    }

    //Time Complexity: O(N2 * log(no. of unique triplets)), where N = size of the array.
    //Reason: Here, we are mainly using 3 nested loops. And inserting triplets into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.
    //
    //Space Complexity: O(2 * no. of the unique triplets) + O(N) as we are using a set data structure and a list to store the triplets and extra O(N) for storing the array elements in another set.

//--------------------------------------------------------------------------------------------------------------


    //OPTIMAL APPROACH:

    public static List< List<Integer>> triplet3(int n, int []arr) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n; i++){

            if (i != 0 && arr[i] == arr[i-1]){
                continue;
            }

            int j = i+1;
            int k = n-1;
            while (j < k){
                int sum = arr[i];
                sum += arr[j];
                sum += arr[k];
                if (sum < 0){
                    j++;
                } else if (sum > 0) {
                    k--;
                }else{
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    list.add(temp);
                    j++;
                    k--;

                    while (j<k && arr[j] == arr[j-1]){
                        j++;
                    }
                    while (j<k && arr[k] == arr[k+1]){
                        k--;
                    }
                }
            }
        }

        return list;

    }

//Time Complexity: O(NlogN)+O(N^2), where N = size of the array.
//Reason: NlogN to sort the array. The pointer i, is running for approximately N times. And both the pointers j and k combined can run for approximately N times including the operation of skipping duplicates. So the total time complexity will be O(N2).
//
//Space Complexity: O(no. of triplets), This space is only used to store the answer. We are not using any extra space to solve this problem. So, from that perspective, space complexity can be written as O(1).

//*************************************************************************************************************
//*************************************************************************************************************
//***************************************************************************************************************

    // 4 SUM:
//Given an array of N integers, your task is to find unique quads that add up to give a target value. In short, you need to return an array of all the unique quadruplets [arr[a], arr[b], arr[c], arr[d]] such that their sum is equal to a given target.

    public static List<List<Integer>> fourSum(int []nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                for (int k = j+1; k < n; k++){
                    for (int l = k+1; l < n; l++){
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target){
                            List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(list);
                            set.add(list);
                        }
                    }
                }
            }
        }
        List<List<Integer>> ls = new ArrayList<>(set);
        return ls;
    }

    // Time Complexity: O(N^4), where N = size of the array.
    //Reason: Here, we are mainly using 4 nested loops. But we not considering the time complexity of sorting as we are just sorting 4 elements every time.
    //
    //Space Complexity: O(2 * no. of the quadruplets) as we are using a set data structure and a list to store the quads.

//------------------------------------------------------------------------------------------------------------

    // BETTER APPROACH:

    public static List<List<Integer>> fourSum2(int []nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                Set<Long> hashSet = new HashSet<>();
                for (int k = j+1; k < n; k++){

                    long sum = nums[i] + nums[j] + nums[k];
                    long fourth = target - sum;

                    if (hashSet.contains(fourth)){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int)fourth);
                        Collections.sort(temp);
                        set.add(temp);
                    }

                    hashSet.add((long)nums[k]);

                }
            }
        }
        List<List<Integer>> ls = new ArrayList<>(set);
        return ls;
    }

//Time Complexity: O(N3*log(M)), where N = size of the array, M = no. of elements in the set.
//Reason: Here, we are mainly using 3 nested loops, and inside the loops there are some operations on the set data structure which take log(M) time complexity.
//
//Space Complexity: O(2 * no. of the quadruplets)+O(N)
//Reason: we are using a set data structure and a list to store the quads. This results in the first term. And the second space is taken by the set data structure we are using to store the array elements. At most, the set can contain approximately all the array elements and so the space complexity is O(N).


//----------------------------------------------------------------------------------------------------------

    // OPTIMAL APPROACH:

    public static List<List<Integer>> fourSum3(int []nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++){

            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            for (int j = i+1; j < n; j++){
                if (j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                int k = j+1;
                int l = n-1;

                while (k < l){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        while (k<l && nums[k] == nums[k-1]){
                            k++;
                        }
                        while (k<l && nums[l] == nums[l+1]){
                            l--;
                        }
                    } else if (sum < target) {
                        k++;
                    }else{
                        l--;
                    }
                }

            }
        }
        return ans;
    }

//Time Complexity: O(N3), where N = size of the array.
//Reason: Each of the pointers i and j, is running for approximately N times. And both the pointers k and l combined can run for approximately N times including the operation of skipping duplicates. So the total time complexity will be O(N3).
//
//Space Complexity: O(no. of quadruplets), This space is only used to store the answer. We are not using any extra space to solve this problem. So, from that perspective, space complexity can be written as O(1).

//*************************************************************************************************************
//*************************************************************************************************************
//***************************************************************************************************************


    //Given an array containing both positive and negative integers, we have to find the length of the longest subarray with the sum of all elements equal to zero.


    // BRUTE FORCE APPROACH:

    public static int getLongestZeroSumSubarrayLength(int []arr){
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++){
            int sum = 0;
            for (int j = i; j < n; j++){
                sum += arr[j];
                if (sum == 0){
                    int length = j-i+1;
                    max = Math.max(max, length);
                }
            }
        }

        return max;
    }

    //Time Complexity: O(N^2) as we have two loops for traversal
    //
    //Space Complexity: O(1) as we aren’t using any extra space.

//------------------------------------------------------------------------------------------------------------

    // OPTIMAL APPROACH:

    public static int getLongestZeroSumSubarrayLength2(int []arr){
        int n = arr.length;
        int max = 0;
        int sum = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < n; i++){
            sum += arr[i];

            if (sum == 0){
                max = i+1;
            }

            if (hmap.get(sum) != null){
                max = Math.max(max, i - hmap.get(sum));
            }else{
                hmap.put(sum, i);
            }
        }


        return max;
    }

    //Time Complexity: O(N), as we are traversing the array only once
    //
    //Space Complexity: O(N), in the worst case we would insert all array elements prefix sum into our hashmap


//*************************************************************************************************************
//*************************************************************************************************************
//***************************************************************************************************************

    //Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all elements equal to k.

    //[XORR cancels the elements when they both have same value]

// BRUTE FORCE APPROACH:
    public static int subarraysWithSumK(int []a, int b) {
        int n = a.length;
        int cnt = 0;

        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                int xorr = 0;
                for (int k = i; k <= j; k++){
                    xorr = xorr ^ a[k];
                }
                if (xorr == b) cnt++;
            }
        }
        return cnt;

    }

    //Time Complexity: O(N3) approx., where N = size of the array.
    //Reason: We are using three nested loops, each running approximately N times.
    //
    //Space Complexity: O(1) as we are not using any extra space.

//-------------------------------------------------------------------------------------------------------------

// BETTER APPROACH:


    public static int subarraysWithSumK2(int []a, int b) {
        int n = a.length;
        int cnt = 0;

        for (int i = 0; i < n; i++){
            int xorr = 0;
            for (int j = i; j < n; j++){
                xorr = xorr ^ a[j];
                if (xorr == b) cnt++;
            }
        }
        return cnt;
    }
    //Time Complexity: O(N2), where N = size of the array.
    //Reason: We are using two nested loops here. As each of them is running for N times, the time complexity will be approximately O(N2).
    //
    //Space Complexity: O(1) as we are not using any extra space

//-------------------------------------------------------------------------------------------------------------

    // OPTIMAL APPROACH:*****

    public static int subarraysWithSumK3(int []a, int b) {
        int n = a.length;
        int cnt = 0;

        int xr = 0;

        //if total xor of subarray is xr and front part is x and rest is b
        // so x ^ b = xr
        // doing ^ b both side
        // x = xr ^ b

        // map to store the prefix XORs and their counts.
        Map<Integer, Integer> hmap = new HashMap<>();

        hmap.put(xr, 0);

        for (int i = 0; i < n; i++){
            xr = xr ^ a[i];
            int x = xr ^ b;

            if (hmap.containsKey(x)){
                cnt += hmap.get(x);
            }

            if (hmap.containsKey(xr)){
                hmap.put(xr, hmap.get(xr) + 1);
            }else{
                hmap.put(xr, 1);
            }

        }

        return cnt;

    }


    //Time Complexity: O(N) or O(N*logN) depending on which map data structure we are using, where N = size of the array.
    //[In java we use unordered map so the time complexity here will be O(n)]
    //Reason: For example, if we are using an unordered_map data structure in C++ the time complexity will be O(N) but if we are using a map data structure, the time complexity will be O(N*logN). The least complexity will be O(N) as we are using a loop to traverse the array. Point to remember for unordered_map in the worst case, the searching time increases to O(N), and hence the overall time complexity increases to O(N2).

    //Space Complexity: O(N) as we are using a map data structure.

//*************************************************************************************************************
//*************************************************************************************************************
//***************************************************************************************************************

//Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.

    // Brute Force Approach
    public static List< List< Integer > > mergeOverlappingIntervals(int [][]arr){
        int n = arr.length;

        // sorting the array:
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < n; i++){
            int start = arr[i][0];
            int end = arr[i][1];

            // skipping all the elements that are merged

            if (!ls.isEmpty() && end <= ls.get(ls.size()-1).get(1)){
                continue;
            }

            //check the rest of the intervals

            for (int j = i+1; j < n; j++){
                if (arr[j][0] <= end){
                    end = Math.max(end, arr[j][1]);
                }else{
                    break;
                }
            }

            ls.add(Arrays.asList(start, end));
        }

        return ls;
    }

//Time Complexity: O(N*logN) + O(2*N), where N = the size of the given array.
//Reason: Sorting the given array takes  O(N*logN) time complexity. Now, after that, we are using 2 loops i and j. But while using loop i, we skip all the intervals that are merged with loop j. So, we can conclude that every interval is roughly visited twice(roughly, once for checking or skipping and once for merging). So, the time complexity will be 2*N instead of N2.
//
//Space Complexity: O(N), as we are using an answer list to store the merged intervals. Except for the answer array, we are not using any extra space.

//----------------------------------------------------------------------------------------------------------



    // Optimal Approach
    public static List< List< Integer > > mergeOverlappingIntervals2(int [][]arr){
        int n = arr.length;

        // sorting the array:
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < n; i++){

            if (ls.isEmpty() || arr[i][0] > ls.get(ls.size()-1).get(1)){
                ls.add(Arrays.asList(arr[i][0], arr[i][1]));
            }else{
                ls.get(ls.size()-1).set(1, Math.max(ls.get(ls.size() - 1).get(1), arr[i][1]));
            }

        }

        return ls;
    }

    //Time Complexity: O(N*logN) + O(N), where N = the size of the given array.
    //Reason: Sorting the given array takes  O(N*logN) time complexity. Now, after that, we are just using a single loop that runs for N times. So, the time complexity will be O(N).
    //
    //Space Complexity: O(N), as we are using an answer list to store the merged intervals. Except for the answer array, we are not using any extra space.


//*************************************************************************************************************
//*************************************************************************************************************
//***************************************************************************************************************

    //Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.

    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        int left = 0;
        int right = 0;
        int k = 0;
        long[] arr = new long[a.length+b.length];

        while (left < a.length && right < b.length){
            if (a[left] <= b[right]){
                arr[k] = a[left];
                left++;
                k++;
            }else{
                arr[k] = b[right];
                right++;
                k++;
            }
        }

        while (left < a.length){
            arr[k++] = a[left++];
        }

        while (right < b.length){
            arr[k++] = b[right++];
        }

        for (int m = 0; m < a.length; m++){
            a[m] = arr[m];
        }

        for (int n = 0; n < b.length; n++){
            b[n] = arr[a.length + n];
        }

    }

    //Time Complexity: O(n+m) + O(n+m), where n and m are the sizes of the given arrays.
    //Reason: O(n+m) is for copying the elements from arr1[] and arr2[] to arr3[]. And another O(n+m) is for filling back the two given arrays from arr3[].
    //
    //Space Complexity: O(n+m) as we use an extra array of size n+m.


//----------------------------------------------------------------------------------------------------------

    // OPTIMAL APPROACH:

    public static void mergeTwoSortedArraysWithoutExtraSpace2(long []a, long []b){
        int left = a.length-1;
        int right = 0;

        while (left >= 0 && right < b.length){
            if (a[left] > b[right]){
                long temp = a[left];
                a[left] = b[right];
                b[right] = temp;
                left--;
                right++;
            }else{
                break;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }

    //Time Complexity: O(min(n, m)) + O(n*logn) + O(m*logm), where n and m are the sizes of the given arrays.
    //Reason: O(min(n, m)) is for swapping the array elements. And O(n*logn) and O(m*logm) are for sorting the two arrays.
    //
    //Space Complexity: O(1) as we are not using any extra space.


//----------------------------------------------------------------------------------------------------------

    // study the second optimal approach from the videos



//*************************************************************************************************************
//*************************************************************************************************************
//***************************************************************************************************************

//You are given a read-only array of N integers with values also in the range [1, N] both inclusive. Each integer appears exactly once except A which appears twice and B which is missing. The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

    // BRUTE FORCE APPROACH:
    public static int[] findMissingRepeatingNumbers(int []a) {
        int n = a.length;
        int missing = -1;
        int repeating = -1;

        // loop for each possible element in an array
        for (int i = 1; i <= n; i++){
            int count = 0;

            //for each array loop in array to find its occurrence
            for (int j = 0; j < n; j++){
                if (a[j] == i){
                    count++;
                }
            }

            if (count==2){
                repeating = i;
            } else if (count==0) {
                missing = i;
            }

            if (repeating != -1 && missing != -1){
                break;
            }
        }

        int[] ans = {repeating, missing};
        return ans;
    }

    //Time Complexity: O(N2), where N = size of the given array.
    //Reason: Here, we are using nested loops to count occurrences of every element between 1 to N.
    //
    //Space Complexity: O(1) as we are not using any extra space.

//--------------------------------------------------------------------------------------------------------------

    // BETTER APPROACH:

    public static int[] findMissingRepeatingNumbers2(int []a) {
        int n = a.length;

        int[] arr = new int[n+1];

        for (int i = 0; i < a.length; i++){
            arr[a[i]]++;
        }

        int missing = -1;
        int repeating = -1;

        for (int i = 1; i <= n; i++){
            if (arr[i] == 2){
                repeating = i;
            } else if (arr[i] == 0) {
                missing = i;
            }

            if (repeating != -1 && missing != -1){
                break;
            }
        }

        int[] ans = {repeating, missing};
        return ans;

    }

    //Time Complexity: O(2N), where N = the size of the given array.
    //Reason: We are using two loops each running for N times. So, the time complexity will be O(2N).
    //
    //Space Complexity: O(N) as we are using a hash array to solve this problem.


//--------------------------------------------------------------------------------------------------------------

    // OPTIMAL APPROACH:

    public static int[] findMissingRepeatingNumbers3(int []a) {
        long n = a.length; // size of the array

        // Find Sn and S2n:
        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        // Calculate S and S2:
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += a[i];
            S2 += (long)a[i] * (long)a[i];
        }

        //S-Sn = X-Y:
        long val1 = S - SN;

        // S2-S2n = X^2-Y^2:
        long val2 = S2 - S2N;

        //Find X+Y = (X^2-Y^2)/(X-Y):
        val2 = val2 / val1;

        //Find X and Y: X = ((X+Y)+(X-Y))/2 and Y = X-(X-Y),
        // Here, X-Y = val1 and X+Y = val2:
        long x = (val1 + val2) / 2;
        long y = x - val1;

        int[] ans = {(int)x, (int)y};
        return ans;
    }

    //Time Complexity: O(N), where N = the size of the given array.
    //Reason: We are using only one loop running for N times. So, the time complexity will be O(N).
    //
    //Space Complexity: O(1) as we are not using any extra space to solve this problem.



//*************************************************************************************************************
//*************************************************************************************************************
//***************************************************************************************************************


// Problem Statement: Given an array of N integers, count the inversion of the array (using merge-sort).
//
//What is an inversion of an array? Definition: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].
// [left element in the array should be greater than right element in the array]

    // BRUTE FORCE APPROACH
    public static int numberOfInversions(int []a, int n) {
        int cnt = 0;

        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                if (a[j] < a[i]){
                    cnt++;
                }
            }
        }

        return cnt;
    }

    //Time Complexity: O(N2), where N = size of the given array.
    //Reason: We are using nested loops here and those two loops roughly run for N times.
    //
    //Space Complexity: O(1) as we are not using any extra space to solve this problem.

//--------------------------------------------------------------------------------------------------------------


    //OPTIMAL APPROACH

    //***** WATCH THE OPTIMAL APPROACH



    public static int merge(int [] arr,int l , int mid, int r)
    {
        int temp [] = new int[arr.length];
        int i =l;
        int left =l;
        int right=mid+1;

        int count = 0;
        while(left<=mid && right<=r)
        {
            if(arr[left]<=arr[right])
            {
                temp[i]=arr[left];
                left++;
            }
            else{
                temp[i]=arr[right];
                count += mid-left+1;
                right++;

            }
            i++;
        }

        while(left<=mid)
        {
            temp[i]=arr[left];
            left++;
            i++;
        }

        while(right<=r)
        {
            temp[i]=arr[right];
            right++;
            i++;
        }

        for(int j=l;j<=r;j++)
        {
            arr[j]=temp[j];
        }

        return count;
    }
    public static int mergeSort(int[] arr, int l, int r){
        int cnt = 0;
        if (l >= r){
            return cnt;
        }
        int mid = (l + r)/2;
        cnt += mergeSort(arr, l, mid);
        cnt += mergeSort(arr, mid+1, r);
        cnt += merge(arr, l, mid, r);

        return cnt;
    }


    public static int numberOfInversions2(int []a, int n) {
        return mergeSort(a, 0, n-1);
    }

    //Time Complexity: O(N*logN), where N = size of the given array.
    //Reason: We are not changing the merge sort algorithm except by adding a variable to it. So, the time complexity is as same as the merge sort.
    //
    //Space Complexity: O(N), as in the merge sort We use a temporary array to store elements in sorted order.

//--------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------

//Given an integer array nums, return the number of reverse pairs in the array.
//A reverse pair is a pair (i, j) where:
//0 <= i < j < nums.length and
//nums[i] > 2 * nums[j].


    // BRUTE FORCE APPROACH
    public static int reversePairs(int[] nums) {
        int cnt = 0;

        int n = nums.length;

        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                if (2*nums[j] < nums[i]){
                    cnt++;
                }
            }
        }

        return cnt;
    }

//    Time Complexity: O(N2), where N = size of the given array.
//            Reason: We are using nested loops here and those two loops roughly run for N times.
//
//    Space Complexity: O(1) as we are not using any extra space to solve this problem.


        








//--------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------


//Given an array ‘Arr’ that has ‘N’ elements. You have to find the subarray of ‘Arr’ that has the largest product. You must return the product of the subarray with the maximum product.

    // BRUTE FORCE APPROACH:
    public static int subarrayWithMaxProduct(int []arr){
        int n = arr.length;

        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            int product = 1;
            for (int j = i; j < n; j++){
                product = product*arr[j];

                maxProduct = Math.max(product, maxProduct);
            }
        }

        return maxProduct;
    }

    //Time Complexity: O(N2)
    //
    //Reason: We are using two nested loops
    //
    //Space Complexity: O(1)
    //
    //Reason: No extra data structures are used for computation

//--------------------------------------------------------------------------------------------------------------

    // OPTIMAL APPROACH:

    public static int subarrayWithMaxProduct2(int []arr){
        int n = arr.length;
        int pref = 1;
        int suff = 1;

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            if (pref == 0) pref = 1;
            if (suff == 0) suff = 1;
            pref = pref*arr[i];
            suff = suff*arr[n-i-1];

            ans = Math.max(ans, Math.max(pref, suff));
        }

        return ans;
    }

    //Time Complexity: O(N), N = size of the given array.
    //Reason: We are using a single loop that runs for N times.
    //
    //Space Complexity: O(1) as No extra data structures are used for computation.

//

    
}
