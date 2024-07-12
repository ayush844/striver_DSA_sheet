import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Binary Search is an efficient algorithm for finding an item from a sorted list of items. It works by repeatedly dividing in half the portion of the list that could contain the item until you've narrowed down the possible locations to just one.

        //How it works:
        //Start with the middle element of the sorted array.
        //If the target value is equal to the middle element, the search is complete.
        //If the target value is less than the middle element, narrow the search to the left half.
        //If the target value is greater than the middle element, narrow the search to the right half.
        //Repeat the process until the target value is found or the remaining portion of the array is empty.

        //Real-life Example
        //Imagine looking for a word in a dictionary:
        //You open the dictionary to the middle page.
        //If the word you're looking for comes before this page, you discard the second half.
        //If it comes after, you discard the first half.
        //You then open the middle of the remaining section and repeat the process until you find the word.

    }

    // ITERATIVE APPROACH:
    public int BinarySearchIter(int[] nums, int target){
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while (low<=high){
            int mid = (low+high)/2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] > target) {
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return -1;

    }


// In the algorithm, in every step, we are basically dividing the search space into 2 equal halves. This is actually equivalent to dividing the size of the array by 2, every time. After a certain number of divisions, the size will reduce to such an extent that we will not be able to divide that anymore and the process will stop. The number of total divisions will be equal to the time complexity.

//Let’s derive the number of divisions mathematically,
//If a number n can be divided by 2 for x times:
//	2^x = n
//Therefore, x = logn (base is 2)
//So the overall time complexity is O(logN), where N = size of the given array.


//---------------------------------------------------------------------------------------------------------------

    // BINARY SEARCH APPROACH:

    public int BinarySearchRecur(int[] nums, int low, int high, int target){
        if (low > high){
            return -1;
        }

        int mid = (low+high)/2;

        if (nums[mid] == target){
            return mid;
        }else if (nums[mid] > target){
            return BinarySearchRecur(nums, low, mid-1, target);
        }else{
            return BinarySearchRecur(nums, mid + 1, high, target);
        }
    }

    //The return statements ensure that the final result of the binary search is correctly returned to the original caller. Without return, the function would not work correctly because it would not pass the results of the recursive calls back up the call stack.


//In the algorithm, in every step, we are basically dividing the search space into 2 equal halves. This is actually equivalent to dividing the size of the array by 2, every time. After a certain number of divisions, the size will reduce to such an extent that we will not be able to divide that anymore and the process will stop. The number of total divisions will be equal to the time complexity.

//Let’s derive the number of divisions mathematically,
//If a number n can be divided by 2 for x times:
//	2^x = n
//Therefore, x = logn (base is 2)
//So the overall time complexity is O(logN), where N = size of the given array.





//Overflow Case
//In binary search, an overflow can occur if you compute the mid-point using (left + right) / 2 directly when left and right are very large integers[suppose both are INT_MAX then low + high will be an overflow case]. This could result in an integer overflow. To avoid this, use the formula:

//int mid = left + (right - left) / 2;

//This prevents overflow by ensuring that the values being added do not exceed the maximum value that an integer can hold.



//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------

// LOWER BOUND:
// The lower bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than or equal to a given key i.e. x.
//The lower bound is the smallest index, ind, where arr[ind] >= x. But if any such index is not found, the lower bound algorithm returns n i.e. size of the given array.

    public int lowerBound(long arr[], int n, long x) {
        int low = 0;
        int high = n - 1;
        int ans = n;  // Initialize to n (out of bounds) to indicate no valid position found initially

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                ans = mid;  // Possible lower bound
                high = mid - 1;  // Search in the left half
            } else {
                low = mid + 1;  // Search in the right half
            }
        }

        return ans;
    }

//Time Complexity: O(logN), where N = size of the given array.
//Reason: We are basically using the Binary Search algorithm.
//
//Space Complexity: O(1) as we are using no extra space.


///////////////////////////////////////////////////////////////////////////////////////////////////////////

// UPPER BOUND:
// The upper bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than the given key i.e. x.
//The upper bound is the smallest index, ind, where arr[ind] > x.
//But if any such index is not found, the upper bound algorithm returns n i.e. size of the given array. The main difference between the lower and upper bound is in the condition. For the lower bound the condition was arr[ind] >= x and here, in the case of the upper bound, it is arr[ind] > x.

    public static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > x) {
                ans = mid;
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

//Time Complexity: O(logN), where N = size of the given array.
//Reason: We are basically using the Binary Search algorithm.
//
//Space Complexity: O(1) as we are using no extra space.


///////////////////////////////////////////////////////////////////////////////////////////////////////////

//Given a sorted array arr[] of size n without duplicates, and given a value x. Floor of x is defined as the largest element k in arr[] such that k is smaller than or equal to x. Find the index of k(0-based indexing).

    public int findFloor(long arr[], int n, long x) {

        int low = 0;
        int high = n-1;
        int ans = -1;

        while (low <= high){
            int mid = (low+high)/2;
            if (arr[mid] <= x){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return ans;

    }

    ////Time Complexity: O(logN), where N = size of the given array.
    ////Reason: We are basically using the Binary Search algorithm.
    ////
    ////Space Complexity: O(1) as we are using no extra space.

///////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.


    // it is similar to finding the lower bound

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int n = nums.length;
        int high = n-1;
        int ans = n;
        while (low <= high){
            int mid = (low + high)/2;
            if (nums[mid] >= target){
                ans = mid;
                high = mid-1;
            }else{
                low = low+1;
            }
        }

        return ans;
    }

    ////Time Complexity: O(logN), where N = size of the given array.
    ////Reason: We are basically using the Binary Search algorithm.
    ////
    ////Space Complexity: O(1) as we are using no extra space.


///////////////////////////////////////////////////////////////////////////////////////////////////////////

    //You're given an sorted array arr of n integers and an integer x. Find the floor and ceiling of x in arr[0..n-1].
    //The floor of x is the largest element in the array which is smaller than or equal to x.
    //The ceiling of x is the smallest element in the array greater than or equal to x.

    public int floor(int[] arr, int n, int x){
        int low = 0;
        int high = n-1;
        int ans = -1;

        while (low <= high){
            int mid = (low + high)/2;
            if (arr[mid] <= x){
                ans = arr[mid];
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return ans;
    }

    public int ceil(int[] arr, int n, int x){
        int low = 0;
        int high = n-1;
        int ans = n;

        while (low <= high){
            int mid = (low + high)/2;
            if (arr[mid] >= x){
                ans = arr[mid];
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }

    public int[] getFloorAndCeil(int[] a, int n, int x) {
        int floor = floor(a, n, x);
        int ceil = ceil(a, n, x);
        int[] arr = {floor, ceil};
        return arr;
    }
    
//Time Complexity: O(logN), where N = size of the given array.
//Reason: We are basically using the Binary Search algorithm.
//
//Space Complexity: O(1) as we are using no extra space.


///////////////////////////////////////////////////////////////////////////////////////////////////////////


    // Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
    //
    //If target is not found in the array, return [-1, -1].

    // lower bound
    public int lowerBound2(int[] arr, int n, int x){
        int low = 0;
        int high = n-1;

        int ans = n;

        while (low <= high){
            int mid = (low + high)/2;
            if (arr[mid] >= x){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }

    // upper bound
    public int upperBound2(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                ans = mid;
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }


    public int[] searchRange(int[] nums, int target) {
        int lb = lowerBound2(nums, nums.length, target);
        int ub = upperBound2(nums, nums.length, target);

        if (lb == nums.length || nums[lb] != target){
            return new int[]{-1, -1};
        }

        return new int[]{lb, ub-1};

    }

    // time complexity: 2*O(log(n))
    // space complexity: O(1)

//--------------------------------------------------------------------------------------------------------------

    // using plane binary Search:

    public int firstOccurence(int[] arr, int n, int x){
        int low = 0;
        int high = n-1;
        int first = -1;

        while (low <= high){
            int mid = (low + high)/2;

            if (arr[mid] == x){
                first = mid;
                high = mid-1;
            } else if (arr[mid] < x) {
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return first;
    }

    public int lastOccurence(int[] arr, int n, int x){
        int low = 0;
        int high = n-1;
        int last = -1;

        while (low <= high){
            int mid = (low + high)/2;

            if (arr[mid] == x){
                last = mid;
                low = mid+1;
            } else if (arr[mid] < x) {
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return last;
    }


    public int[] searchRange2(int[] nums, int target) {
        int firstOccurence = firstOccurence(nums, nums.length, target);
        int lastOccurence = lastOccurence(nums, nums.length, target);

        return new int[]{firstOccurence, lastOccurence};

    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

    public int countOccurence(int[] arr, int n, int x) {
        int firstOccurence = firstOccurence(arr, arr.length, x);

        if(firstOccurence == -1){
            return 0;
        }

        int lastOccurence = lastOccurence(arr, arr.length, x);


        return lastOccurence-firstOccurence+1;
    }

    //Time Complexity: O(2*logN), where N = size of the given array.
    //Reason: We are basically using the binary search algorithm twice.
    //
    //Space Complexity: O(1) as we are using no extra space.


///////////////////////////////////////////////////////////////////////////////////////////////////////////


// Given an integer array arr of size N, sorted in ascending order (with distinct values) and a target value k. Now the array is rotated at some pivot point unknown to you. Find the index at which k is present and if k is not present return -1.

    public int search(int[] nums, int target) {

        int n= nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // if mid points to the target
            if (nums[mid] == target) {
                return mid;
            }

            // if left part is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    // element exists
                    high = mid - 1;
                } else {
                    // element does not exist
                    low = mid + 1;
                }
            } else { // if right part is sorted
                if (nums[mid] <= target && target <= nums[high]) {
                    // element exists
                    low = mid + 1;
                } else {
                    // element does not exist
                    high = mid - 1;
                }
            }
        }
        return -1;
    }


    //Time Complexity: O(logN), N = size of the given array.
    //Reason: We are using binary search to search the target.
    //
    //Space Complexity: O(1)
    //Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).


///////////////////////////////////////////////////////////////////////////////////////////////////////////


    //There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
    //Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
    //Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

    public boolean search2(int[] nums, int target) {
        int n= nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            // if mid points to the target
            if (nums[mid] == target) {
                return true;
            }

            // edge case:
            if (nums[mid] == nums[low] && nums[mid] == nums[high]){
                low = low+1;
                high = high-1;
                continue;
            }

            // if left part is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    // element exists
                    high = mid - 1;
                } else {
                    // element does not exist
                    low = mid + 1;
                }
            } else { // if right part is sorted
                if (nums[mid] <= target && target <= nums[high]) {
                    // element exists
                    low = mid + 1;
                } else {
                    // element does not exist
                    high = mid - 1;
                }
            }
        }
        return false;
    }


    //Time Complexity: O(logN) for the best and average case. O(N/2) for the worst case. Here, N = size of the given array.
    //Reason: In the best and average scenarios, the binary search algorithm is primarily utilized and hence the time complexity is O(logN). However, in the worst-case scenario, where all array elements are the same but not the target (e.g., given array = {3, 3, 3, 3, 3, 3, 3}), we continue to reduce the search space by adjusting the low and high pointers until they intersect. This worst-case situation incurs a time complexity of O(N/2).
    //
    //Space Complexity: O(1)
    //Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).


///////////////////////////////////////////////////////////////////////////////////////////////////////////


    // Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
    //[4,5,6,7,0,1,2] if it was rotated 4 times.
    //[0,1,2,4,5,6,7] if it was rotated 7 times.
    //Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
    //Given the sorted rotated array nums of unique elements, return the minimum element of this array.


    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        int ans = Integer.MAX_VALUE;

        while (low <= high){
            int mid = (low+high)/2;

            // check if left half is sorted
            if (nums[mid] >= nums[low]){
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            }else{
                //right half is sorted

                ans = Math.min(ans,nums[mid]);
                high = mid-1;
            }
        }

        return ans;
    }

    //Time Complexity: O(logN), N = size of the given array.
    //Reason: We are basically using binary search to find the minimum.
    //
    //Space Complexity: O(1)
    //Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).

///////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Given an ascending sorted rotated array arr. The array is right-rotated k times. Find the value of k.

    public int findKRotation(List<Integer> arr) {
        int low = 0;
        int high = arr.size()-1;

        int ans = Integer.MAX_VALUE;
        int index = 0;

        while (low <= high){
            int mid = (low+high)/2;

            // check if left half is sorted
            if (arr.get(mid) >= arr.get(low)){

                if (arr.get(low) < ans){
                    index = low;
                }

                ans = Math.min(ans, arr.get(low));

                low = mid + 1;
            }else{
                //right half is sorted

                if (arr.get(mid) < ans){
                    index = mid;
                }

                ans = Math.min(ans,arr.get(mid));
                high = mid-1;
            }
        }

        return index;
    }

//Time Complexity: O(logN), N = size of the given array.
//Reason: We are basically using binary search to find the minimum.
//
//Space Complexity: O(1)
//Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).

///////////////////////////////////////////////////////////////////////////////////////////////////////////

    //  You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
    //Return the single element that appears only once.

    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;

        // if array have only one element return that element
        if (n == 1){
            return nums[0];
        }

        // if first element is the single element
        if (nums[0] != nums[1]){
            return nums[0];
        }

        // if last element is the single element
        if (nums[n-1] != nums[n-2]){
            return nums[n-1];
        }

        int low = 1;
        int high = n-2;


        while (low <= high){
            int mid = (low+high) / 2;

            // if nums[mid] is our single element
            if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }


            if ((mid % 2 == 0 && nums[mid] == nums[mid+1]) || (mid % 2 == 1 && nums[mid] == nums[mid-1])){
                // if our mid is at left of the single element
                low = mid+1;
            }else{
                // if our mid is at the right of our single element
                high = mid-1;
            }

        }

        return -1;



    }

    //Time Complexity: O(logN), N = size of the given array.
    //Reason: We are basically using the Binary Search algorithm.

    //Space Complexity: O(1) as we are not using any extra space.


///////////////////////////////////////////////////////////////////////////////////////////////////////////


    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if (n == 1){
            return nums[0];
        }

        if (nums[0] > nums[1]){
            return 0;
        }

        if (nums[n-1] > nums[n-2]){
            return n-1;
        }

        int low = 1;
        int high = n-2;

        while (low <= high){
            int mid = (low + high)/2;

            if (nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]){
                return mid;
            }

            if (nums[mid] > nums[mid-1]){
                // we are in the left half
                low = mid+1;
            }else{
                // we are in the right half
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


    


}