import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BSAnswers {

    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int ans = aggressiveCows2(stalls, k);
        System.out.println("The maximum possible minimum distance is: " + ans);
    }

    // Given an integer x, find the square root of x. If x is not a perfect square, then return floor(√x).

    public int floorSqrt(int x)
    {
        int low = 1;
        int high = x;

        int ans = 1;

        while (low <= high){
            int mid = (low + high)/2;

            if (mid*mid == x){
                return mid;
            } else if (mid*mid < x) {
                low = mid+1;
                ans = mid;
            }else{
                high = mid-1;
            }
        }

        return ans;
    }

    //Time Complexity: O(logN), N = size of the given array.
    //Reason: We are basically using the Binary Search algorithm.
    //
    //Space Complexity: O(1) as we are not using any extra space.


///////////////////////////////////////////////////////////////////////////////////////////////////////////


    // You are given 2 numbers (n , m); the task is to find n√m (nth root of m).

    public int func(int n, int m, int mid){
        long ans = 1;
        for (int i = 1; i <= n; i++){
            ans = ans*mid;
            if(ans > m){
                return 2;
            }
        }

        if (ans == m){
            return 1;
        }
        return 0;

    }


    public int NthRoot(int n, int m)
    {
        int low = 1;
        int high = m;

        int ans = 1;

        while (low <= high){
            int mid = (low+high)/2;
            int comparision = func(n, m, mid);


            if (comparision == 1){
                return mid;
            } else if (comparision == 0) {
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return -1;

    }

    //Time Complexity: O(logN), N = size of the given array.
    //Reason: We are basically using binary search to find the minimum.
    //
    //Space Complexity: O(1)
    //Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).


///////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
    //Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
    //Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
    //Return the minimum integer k such that she can eat all the bananas within h hours.


    public int findMaxElement(int[] arr){
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++){
            max = Integer.max(max, arr[i]);
        }

        return max;
    }

    public int findTimeTaken(int[] arr, int bananaPerHour){
        int timeTaken = 0;

        for (int i = 0; i < arr.length; i++){
            timeTaken += Math.ceil((double)arr[i]/(double)bananaPerHour);
        }

        return timeTaken;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = findMaxElement(piles);

        while (low <= high){
            int mid = (low + high)/2;

            int timeTaken = findTimeTaken(piles, mid);

            if (timeTaken <= h){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return low;
    }


    // Time Complexity: O(N * log(max(a[]))), where max(a[]) is the maximum element in the array and N = size of the array.
    //Reason: We are applying Binary search for the range [1, max(a[])], and for every value of ‘mid’, we are traversing the entire array inside the function named calculateTotalHours().
    //
    //Space Complexity: O(1) as we are not using any extra space to solve this problem.


///////////////////////////////////////////////////////////////////////////////////////////////////////////

    //You are given an integer array bloomDay, an integer m and an integer k.
    //
    //You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
    //
    //The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
    //
    //Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.



    // BRUTE FORCE APPROACH:


    public Boolean possible(int[] bloomDay, int days , int m, int k){
        int n = bloomDay.length;
        int cnt = 0; // count of adjacent flower for a bouquet
        int noOfB = 0;

        for (int i = 0; i < n; i++){
            if (bloomDay[i] <= days){
                cnt++;
            }else{
                noOfB += (cnt/k);
                cnt = 0;
            }
        }

        noOfB += (cnt/k);

        return noOfB >= m;
    }



    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < m*k){
            return -1;
        }

        // finding min and max from the array
        int minDays = Integer.MAX_VALUE;
        int maxDays = Integer.MIN_VALUE;

        for (int i = 0; i < bloomDay.length; i++){
            if (minDays > bloomDay[i]){
                minDays = bloomDay[i];
            }
            if (maxDays < bloomDay[i]){
                maxDays = bloomDay[i];
            }
        }



        for (int i = minDays; i <= maxDays; i++){
            if (possible(bloomDay, i, m, k)){
                return i;
            }
        }

        return -1;


    }

    // Time Complexity: O((max(arr[])-min(arr[])+1) * N), where {max(arr[]) -> maximum element of the array, min(arr[]) -> minimum element of the array, N = size of the array}.
    //Reason: We are running a loop to check our answers that are in the range of [min(arr[]), max(arr[])]. For every possible answer, we will call the possible() function. Inside the possible() function, we are traversing the entire array, which results in O(N).
    //
    //Space Complexity: O(1) as we are not using any extra space to solve this problem.

//-----------------------------------------------------------------------------------------------------------



    public Boolean possible2(int[] bloomDay, int days , int m, int k){
        int n = bloomDay.length;
        int cnt = 0;
        int noOfB = 0;

        for (int i = 0; i < n; i++){
            if (bloomDay[i] <= days){
                cnt++;
            }else{
                noOfB += (cnt/k);
                cnt = 0;
            }
        }

        noOfB += (cnt/k);

        return noOfB >= m;
    }



    public int minDays2(int[] bloomDay, int m, int k) {
        if(bloomDay.length < (long)m*k){
            return -1;
        }

        // finding min and max from the array
        int minDays = Integer.MAX_VALUE;
        int maxDays = Integer.MIN_VALUE;

        for (int i = 0; i < bloomDay.length; i++){
            if (minDays > bloomDay[i]){
                minDays = bloomDay[i];
            }
            if (maxDays < bloomDay[i]){
                maxDays = bloomDay[i];
            }
        }


        int low = minDays;
        int high = maxDays;

        while (low <= high){
            int mid = (low + high)/2;
            if (possible(bloomDay, mid, m, k)){
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }

        return low;


    }

//Time Complexity: O(log(max(arr[])-min(arr[])+1) * N), where {max(arr[]) -> maximum element of the array, min(arr[]) -> minimum element of the array, N = size of the array}.
//Reason: We are applying binary search on our answers that are in the range of [min(arr[]), max(arr[])]. For every possible answer ‘mid’, we will call the possible() function. Inside the possible() function, we are traversing the entire array, which results in O(N).
//
//Space Complexity: O(1) as we are not using any extra space to solve this problem.


///////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
    //Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).


    public int sumByD(int[] nums, int d){
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += Math.ceil((double) (nums[i])/(double) (d));
        }
        return sum;
    }


    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        if (n > threshold){
            return -1;
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
        }

        int low = 1;
        int high = max;

        while (low <= high){
            int mid = (low + high)/2;

            int sum = sumByD(nums, mid);

            if (sum <= threshold){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }


    // Time Complexity: O(log(max(arr[]))*N), where max(arr[]) = maximum element in the array, N = size of the array.
    //Reason: We are applying binary search on our answers that are in the range of [1, max(arr[])]. For every possible divisor ‘mid’, we call the sumByD() function. Inside that function, we are traversing the entire array, which results in O(N).
    //
    //Space Complexity: O(1) as we are not using any extra space to solve this problem.


///////////////////////////////////////////////////////////////////////////////////////////////////////////

    //A conveyor belt has packages that must be shipped from one port to another within days days.
    //The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
    //Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

    public int findMaxElementInArr(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public int findSumInArr(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    public int findDays(int[] weights, int capacity){
        int day = 1;
        int load = 0;
        for (int i = 0; i < weights.length; i++){
            if (load + weights[i] > capacity){
                day += 1;
                load = weights[i];
            }else{
                load += weights[i];
            }
        }

        return day;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = findMaxElementInArr(weights);
        int high = findSumInArr(weights);

        while (low <= high){
            int mid = (low + high)/2;
            int dayTaken = findDays(weights, mid);

            if (dayTaken <= days){
                high = mid - 1;
            }else{
                low = mid+1;
            }
        }

        return low;
    }

//Time Complexity: O(N * log(sum(weights[]) - max(weights[]) + 1)), where sum(weights[]) = summation of all the weights, max(weights[]) = maximum of all the weights, N = size of the weights array.
//Reason: We are applying binary search on the range [max(weights[]), sum(weights[])]. For every possible answer ‘mid’, we are calling findDays() function. Now, inside the findDays() function, we are using a loop that runs for N times.
//
//Space Complexity: O(1) as we are not using any extra space to solve this problem.


///////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
    //Return the kth positive integer that is missing from this array.

    // brute force approach

    public int findKthPositive(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++){
            if (arr[i] <= k){
                k++;
            }else{
                break;
            }
        }
        return k;
    }

    //Time Complexity: O(N), N = size of the given array.
    //Reason: We are using a loop that traverses the entire given array in the worst case.
    //
    //Space Complexity: O(1) as we are not using any extra space to solve this problem.

//---------------------------------------------------------------------------------------------------------

    // optimal approach

    public int findKthPositive2(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++){
            if (arr[i] <= k){
                k++;
            }else{
                break;
            }
        }
        return k;
    }



///////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Problem Statement: You are given an array 'arr' of size 'n' which denotes the position of stalls.
    //You are also given an integer 'k' which denotes the number of aggressive cows.
    //You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.
    //Find the maximum possible minimum distance.


// brute force approach:

    public static boolean canWePlace(int[] stalls, int minDist, int noOfCows){
        int n = stalls.length;
        int last = stalls[0];
        int cntCows = 1;
        for (int i = 1; i < n; i++){
            if((stalls[i] - last) >= minDist){
                last = stalls[i];
                cntCows++;
            }
            if(cntCows >= noOfCows){
                return true;
            }
        }
        return false;
    }


    public static int aggressiveCows(int[] stalls, int k){
        int n = stalls.length;

        Arrays.sort(stalls);

        int limit = stalls[n-1] - stalls[0];

        for (int i = 1; i <= limit; i++){
            if(canWePlace(stalls, i, k)){
                continue;
            }else{
                return i-1;
            }
        }

        return limit;
    }

//Time Complexity: O(NlogN) + O(N *(max(stalls[])-min(stalls[]))), where N = size of the array, max(stalls[]) = maximum element in stalls[] array, min(stalls[]) = minimum element in stalls[] array.
//Reason: O(NlogN) for sorting the array. We are using a loop from 1 to max(stalls[])-min(stalls[]) to check all possible distances. Inside the loop, we are calling canWePlace() function for each distance. Now, inside the canWePlace() function, we are using a loop that runs for N times.
//
//Space Complexity: O(1) as we are not using any extra space to solve this problem.



//-----------------------------------------------------------------------------------------------------------



    //OPTIMAL APPROACH

    public static int aggressiveCows2(int[] stalls, int k){
        int n = stalls.length;
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[n-1] - stalls[0];

        while (low <= high){
            int mid = (low + high) / 2;
            if(canWePlace(stalls, mid,k)){
                low = mid + 1;
            }else{
                high = mid-1;
            }
        }

        return high;

    }

//Time Complexity: O(NlogN) + O(N * log(max(stalls[])-min(stalls[]))), where N = size of the array, max(stalls[]) = maximum element in stalls[] array, min(stalls[]) = minimum element in stalls[] array.
//Reason: O(NlogN) for sorting the array. We are applying binary search on [1, max(stalls[])-min(stalls[])]. Inside the loop, we are calling canWePlace() function for each distance, ‘mid’. Now, inside the canWePlace() function, we are using a loop that runs for N times.
//
//Space Complexity: O(1) as we are not using any extra space to solve this problem.


///////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Problem Statement: Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book. There are a ‘m’ number of students, and the task is to allocate all the books to the students.
    //Allocate books in such a way that:
    //
    //Each student gets at least one book.
    //Each book should be allocated to only one student.
    //Book allocation should be in a contiguous manner.
    //You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum. If the allocation of books is not possible. return -1


    // brute force approach:

    public static int countStudents(ArrayList<Integer> arr, int pages){
        int n = arr.size();
        int students = 1;
        long pagesStudent = 0;

        for(int i = 0; i < n; i++){
            if (pagesStudent + arr.get(i) <= pages){
                // add pages to current student
                pagesStudent += arr.get(i);
            }else{
                //add pages to next student
                students++;
                pagesStudent = arr.get(i);
            }
        }

        return students;
    }


    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // book allocation impossible
        if (m > n)
            return -1;

        int low = Collections.max(arr); // max number of pages in a single book
        int high = arr.stream().mapToInt(Integer::intValue).sum(); // sum of pages in each book in array

        for (int pages = low; pages <= high; pages++) {
            // pages = max number of pages 1 student can have
            if (countStudents(arr, pages) == m) {
                return pages;
            }
        }
        return low;
    }

    //Time Complexity: O(N * (sum(arr[])-max(arr[])+1)), where N = size of the array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements.
    //Reason: We are using a loop from max(arr[]) to sum(arr[]) to check all possible numbers of pages. Inside the loop, we are calling the countStudents() function for each number. Now, inside the countStudents() function, we are using a loop that runs for N times.
    //
    //Space Complexity:  O(1) as we are not using any extra space to solve this problem.

//-----------------------------------------------------------------------------------------------------------

    // optimal approach

    public static int findPages2(ArrayList<Integer> arr, int n, int m) {
        // book allocation impossible
        if (m > n) {
            return -1;
        }

        int low = Collections.max(arr); // max number of pages in a single book
        int high = arr.stream().mapToInt(Integer::intValue).sum(); // sum of pages in each book in array

        while (low <= high){
            int mid = (low + high) / 2; // max number of pages 1 student can have
            int students = countStudents(arr, mid);

            if(students > m){
                low = mid + 1;  // we need to increase max number of page 1 student can have to decrease number                    of student
            }else{
                high = mid - 1; // we need to decrease max number of page 1 student can have to increase number                    of student
            }
        }

        return low;
    }

    // Time Complexity: O(N * log(sum(arr[])-max(arr[])+1)), where N = size of the array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements.
    //Reason: We are applying binary search on [max(arr[]), sum(arr[])]. Inside the loop, we are calling the countStudents() function for the value of ‘mid’. Now, inside the countStudents() function, we are using a loop that runs for N times.
    //
    //Space Complexity:  O(1) as we are not using any extra space to solve this problem.


///////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Problem Statement: Given an integer array ‘A’ of size ‘N’ and an integer ‘K'. Split the array ‘A’ into ‘K’ non-empty subarrays such that the largest sum of any subarray is minimized. Your task is to return the minimized largest sum of the split.
    //A subarray is a contiguous part of the array.

    // *** this question is similar to the above question ***


    public int countPartitions(int[] nums, int maxSum){
        int n = nums.length;
        int partition = 1;
        int subarraySum = 0;
        for(int i =  0; i < n; i++){
            if(subarraySum + nums[i] <= maxSum){
                subarraySum += nums[i];
            }else{
                partition++;
                subarraySum = nums[i];
            }
        }
        return partition;
    }


    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low = nums[n-1];
        int high = 0;
        for(int i = 0; i < n; i++){
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        while (low <= high){
            int mid = (low + high) / 2;
            int partitions = countPartitions(nums, mid);
            if(partitions > k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return low;

    }

    // Time Complexity: O(N * log(sum(arr[])-max(arr[])+1)), where N = size of the array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements.
    //Reason: We are applying binary search on [max(arr[]), sum(arr[])]. Inside the loop, we are calling the countPartitions() function for the value of ‘mid’. Now, inside the countPartitions() function, we are using a loop that runs for N times.
    //
    //Space Complexity:  O(1) as we are not using any extra space to solve this problem.


///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Given an array/list of length ‘N’, where the array/list represents the boards and each element of the given array/list represents the length of each board. Some ‘K’ numbers of painters are available to paint these boards. Consider that each unit of a board takes 1 unit of time to paint. You are supposed to return the area of the minimum time to get this job done of painting all the ‘N’ boards under the constraint that any painter will only paint the continuous sections of boards.


    public static int countPainters(ArrayList<Integer> boards, int time){
        int painter = 1;
        int areaUnit = 0;
        int n = boards.size();

        for (int i = 0; i < n; i++){
            if(areaUnit + boards.get(i) <= time){
                areaUnit += boards.get(i);
            }else{
                painter++;
                areaUnit = boards.get(i);
            }
        }

        return painter;
    }



    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int low = Collections.max(boards); // max number of pages in a single book
        int high = boards.stream().mapToInt(Integer::intValue).sum(); // sum of pages in each book in array

        while (low <= high){
            int mid = (low + high)/2;
            int painters = countPainters(boards, mid);
            if(painters > k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return low;

    }


    // Time Complexity: O(N * log(sum(arr[])-max(arr[])+1)), where N = size of the array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements.
    //Reason: We are applying binary search on [max(arr[]), sum(arr[])]. Inside the loop, we are calling the countPainters() function for the value of ‘mid’. Now, inside the countPainters() function, we are using a loop that runs for N times.
    //
    //Space Complexity:  O(1) as we are not using any extra space to solve this problem.


///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Problem Statement: Given two sorted arrays arr1 and arr2 of size m and n respectively, return the median of the two sorted arrays. The median is defined as the middle value of a sorted list of numbers. In case the length of the list is even, the median is the average of the two middle elements.


// brute force approach:
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Size of two given arrays
        int n1 = nums1.length;
        int n2 = nums2.length;

        List<Integer> arr3 = new ArrayList<>();
        // Apply the merge step
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                arr3.add(nums1[i++]);
            } else {
                arr3.add(nums2[j++]);
            }
        }

        // Copy the left-out elements
        while (i < n1) {
            arr3.add(nums1[i++]);
        }
        while (j < n2) {
                arr3.add(nums2[j++]);
        }

        // Find the median
        int n = n1 + n2;
        if (n % 2 == 1) {
            return (double) arr3.get(n / 2);
        }

        double median = ((double) arr3.get(n / 2) + (double) arr3.get((n / 2) - 1)) / 2.0;
        return median;
    }

    //Time Complexity: O(n1+n2), where  n1 and n2 are the sizes of the given arrays.
    //Reason: We traverse through both arrays linearly.
    //
    //Space Complexity: O(n1+n2), where  n1 and n2 are the sizes of the given arrays.
    //Reason: We are using an extra array of size (n1+n2) to solve this problem.

//-----------------------------------------------------------------------------------------------------------

    // optimal approach

    // was not able to understand


///////////////////////////////////////////////////////////////////////////////////////////////////////////////




}
