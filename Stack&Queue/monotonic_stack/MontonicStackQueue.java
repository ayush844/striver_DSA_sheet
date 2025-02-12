import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class MontonicStackQueue {

    public static void main(String[] args) {

    }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Given a integer array A, return the next greater element for every element in A. The next greater element for an element x is the first element greater than x that we come across while traversing the array from left to right. If it doesn't exist, return -1 for this element.


    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n-1; i >= 0; i--){
            while (!st.isEmpty() && st.peek() <= nums[i]){
                st.pop();
            }
            if (st.isEmpty()){
                nge[i] = -1;
            }else {
                nge[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return nge;
    }

    // time complexity => O(2n) because inside at  while loop we in worst case will remove all elements after adding it

    // space complexity => O(n)+O(n) => O(2n) : for storing the stack and for the ans

//-------------------------------------------------------------------------------------------------------------------

    // leetcode question:

// The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
//You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
//For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
//Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
//
//Example 1:
//Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
//Output: [-1,3,-1]
//Explanation: The next greater element for each value of nums1 is as follows:
//- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
//- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
//- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
//Example 2:


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int nTotal = nums2.length;
        int totalNGE[] = new int[nTotal];
        int finalNGE[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = nTotal - 1; i >= 0; i--){
            while (!st.isEmpty() && st.peek() <= nums2[i]){
                st.pop();
            }
            if (st.isEmpty()){
                totalNGE[i] = -1;
            }else {
                totalNGE[i] = st.peek();
            }
            st.push(nums2[i]);
        }

        for (int i = 0; i < n; i++){
            int element = nums1[i];
            for (int j = 0; j < nTotal; j++){
                if (element==nums2[j]){
                    finalNGE[i] = totalNGE[j];
                    break;
                }
            }
        }

        return finalNGE;

    }

// optimal approach:
    public int[] nextGreaterElementOptimal(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // find out all the next greater elements in nums2 array
        for(int num: nums2) {
            // if num is greater than top elements in stack then it is the next greater element in nums2
            while(!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            // then add num to stack
            stack.add(num);
        }

        int i = 0;
        for(int num : nums1) {
            ans[i++] = map.getOrDefault(num, -1);
        }

        return ans;

    }
    // Time - O(n) where n is length of nums2 as it is equal to or greater than nums1,



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
//The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
//
//Example 1:
//Input: nums = [1,2,1]
//Output: [2,-1,2]
//Explanation: The first 1's next greater number is 2;
//The number 2 can't find next greater number.
//The second 1's next greater number needs to search circularly, which is also 2.




    public int[] nextGreaterElements3(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 2*n-1; i>=0; i--){
            while (!st.isEmpty() && st.peek() < nums[i%n]){
                st.pop();
            }

            if(st.isEmpty()){
                if(i >= 0 && i < n){
                    res[i] = -1;
                }
            }

            if(i >= 0 && i < n){
                res[i] = st.peek();
            }

            st.push(nums[i%n]);
        }

        return res;
    }

// time complexity => O(4N)
// space complexity => O(2N) + O(N)


/// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //Trapping Rainwater

    //Problem Statement: Given an array of non-negative integers representation elevation of ground. Your task is to find the water that can be trapped after rain.


    // first approach:

    //  For each index, we have to find the amount of water that can be stored and we have to sum it up.If we observe carefully the amount the water stored at a particular index is the minimum of maximum elevation to the left and right of the index minus the elevation at that index. we need to have taller building in left and right to store the water

    // Approach: Take 2 array prefix and suffix array and precompute the leftMax and rightMax for each index beforehand. Then use the formula min(prefix[I], suffix[i])-arr[i] to compute water trapped at each index.

    public int trap(int[] height) {
        int n = height.length;
        int prefixMax[] = new int[n];
        int suffixMax[] = new int[n];

        prefixMax[0] = height[0];
        for (int i = 1; i < n; i++){
            prefixMax[i] = Math.max(prefixMax[i-1], height[i]);
        }

        suffixMax[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--){
            suffixMax[i] = Math.max(suffixMax[i+1], height[i]);
        }

        int waterTrapped = 0;

        for (int i = 0; i < n; i++){
            waterTrapped += Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }

        return waterTrapped;
    }

    //Time Complexity: O(3*N) as we are traversing through the array only once. And O(2*N) for computing prefix and suffix array.
    //
    //Space Complexity: O(N)+O(N) for prefix and suffix arrays.

//------------------------------------------------------------------------------------------------------------------------


    // optimal approach

    // using 2 pointer approach

    //Approach: Take 2 pointers l(left pointer) and r(right pointer) pointing to 0th and (n-1)th index respectively. Take two variables leftMax and rightMax and initialize them to 0. If height[l] is less than or equal to height[r] then if leftMax is less than height[l] update leftMax to height[l] else add leftMax-height[l] to your final answer and move the l pointer to the right i.e l++. If height[r] is less than height[l], then now we are dealing with the right block. If height[r] is greater than rightMax, then update rightMax to height[r] else add rightMax-height[r] to the final answer. Now move r to the left. Repeat these steps till l and r crosses each other.

    // Intuition: We need a minimum of leftMax and rightMax.So if we take the case when height[l]<=height[r] we increase l++, so we can surely say that there is a block with a height more than height[l] to the right of l. And for the same reason when height[r]<=height[l] we can surely say that there is a block to the left of r which is at least of height[r]. So by traversing these cases and using two pointers approach the time complexity can be decreased without using extra space.


    public int trap2(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int res = 0;
        int maxLeft = 0;
        int maxRight = 0;

        while (left <= right){
            if(height[left] <= height[right]){
                if(height[left] >= maxLeft){
                    maxLeft = height[left];
                }else{
                    res += maxLeft-height[left];
                }
                left++;
            }else{
                if (height[right] >= maxRight){
                    maxRight = height[right];
                }else{
                    res += maxRight-height[right];
                }
                right--;
            }
        }

        return res;
    }

    // Time Complexity: O(N) because we are using 2 pointer approach.
    //Space Complexity: O(1) because we are not using anything extra.


/// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.
//For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
//Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.


    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for (int i: asteroids){
            if(i > 0){
                s.push(i);
            }else{
                while (!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(i)){
                    s.pop();
                }
                if (s.empty() || s.peek() < 0){
                    s.push(i);
                }else if (i + s.peek() == 0){
                    s.pop();
                }
            }
        }

        int[] res = new int[s.size()];

        for (int i = res.length-1; i >= 0; i--){
            res[i] = s.pop();
        }

        return res;
    }

    //### Time Complexity:
    //The time complexity of the `asteroidCollision` function is **O(N)**, where **N** is the number of elements in the `asteroids` array.
    //
    //#### Explanation:
    //1. **Loop through the `asteroids` array**: The outer `for` loop iterates through each element in the `asteroids` array once, which takes **O(N)** time.
    //2. **Stack operations**:
    //   - The `while` loop inside the `else` block processes collisions. In the worst case, each asteroid could be pushed and popped from the stack at most once. This means the total number of stack operations (push and pop) is proportional to the number of asteroids, **O(N)**.
    //   - The `if` and `else if` conditions are constant-time operations, **O(1)**.
    //3. **Building the result array**: The second loop iterates over the stack to populate the result array, which takes **O(N)** time.
    //
    //Since all these operations are linear and depend on the size of the input array, the overall time complexity is **O(N)**.
    //
    //---
    //
    //### Space Complexity:
    //The space complexity of the function is **O(N)** in the worst case.
    //
    //#### Explanation:
    //1. **Stack usage**: The stack can hold up to **N** elements in the worst case (e.g., when all asteroids are moving in the same direction or no collisions occur).
    //2. **Result array**: The `res` array stores the final result, which also takes **O(N)** space.
    //
    //Thus, the total space complexity is **O(N)**.
    //
    //---
    //
    //### Summary:
    //- **Time Complexity**: **O(N)**
    //- **Space Complexity**: **O(N)**
    //
    //This analysis assumes that stack operations (`push`, `pop`, `peek`, `isEmpty`) are **O(1)**.

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.


// brute force approach
    public int sumSubarrayMins(int[] arr) {
        int mod = (int)(1e9 + 7);
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            int min = arr[i];
            for (int j = i; j < arr.length; j++){
                min = Math.min(min, arr[j]);
                sum = (sum + min)%(mod);
            }
        }
        return sum;
    }

    // time complexity: O(n^2)
    // space complexity: O(1)

//---------------------------------------------------------------------------------------------------------------

// optimal solution


    // finding next smaller element
    public int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];

        // Stack to store indexes
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nse;
    }

    // Finding Previous Smaller Element Equal or Less Than
    public int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] psee = new int[n];

        // Stack to store indexes
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return psee;
    }

    public int sumSubarrayMins2(int[] arr) {
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);

        int total = 0;
        int mod = (int) (1e9 + 7);

        for (int i = 0; i < arr.length; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;

            total = (int) ((total + (arr[i]  * left * right) % mod) % mod);
        }

        return total;
    }






    // Complexity:

    //Time Complexity:
    //findNSE and findPSEE both run in O(n), as each element is pushed and popped from the stack at most once.
    //The final computation of the sum also runs in O(n).
    //Total: O(n).

    //Space Complexity:
    //Space for the stacks in findNSE and findPSEE: O(n).
    //Arrays nse and psee: O(n).
    //Total: O(n).





/// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.
//
//Return the sum of all subarray ranges of nums.
//
//A subarray is a contiguous non-empty sequence of elements within an array.


    // brute force approach:

    public long subArrayRanges(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length; i++){
            int max = nums[i];
            int min = nums[i];

            for (int j = i; j < nums.length; j++){
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                res += max - min;
            }

        }

        return res;
    }


    // time complexity: O(n^2)
    // space complexity: O(1)


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

    public String removeKdigits(String num, int k) {

        int len = num.length();

        if (len == k){
            return "0";
        }

        Stack<Character> st = new Stack<>();

        int i = 0;

        while (i < num.length()){
            while (k > 0 && !st.isEmpty() && st.peek() > num.charAt(i)){
                st.pop();
                k--;
            }

            st.push(num.charAt(i));
            i++;
        }

        // corner case like "1111" or "123456"
        while (k > 0){
            st.pop();
            k--;
        }

        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
            sb.append(st.pop());
        sb.reverse();

        //remove all the 0 at the head
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);

        
        return sb.toString();

    }


    //Here's the analysis of the function:
    //
    //### **Time Complexity**:
    //1. **Traversal of the input string `num`:**
    //   - The `while (i < num.length())` loop processes each character of the string once. This takes **O(n)** time, where `n` is the length of `num`.
    //   - Inside this loop, `st.pop()` may execute up to `k` times, but across the entire loop, the total number of `pop` operations is bounded by `k`. This is because `k` decrements with each `pop`. Thus, the combined cost of all `pop` operations is **O(k)**.
    //
    //2. **While loop to handle leftover `k`:**
    //   - If `k > 0` after the traversal, up to `k` `pop` operations are performed. This contributes an additional **O(k)**.
    //
    //3. **Constructing the result string:**
    //   - The `StringBuilder` operations involve reversing the string and removing leading zeros. These operations take linear time relative to the size of the stack, which is at most `n`. Thus, this step takes **O(n)**.
    //
    //**Overall Time Complexity**:
    //The total time complexity is **O(n)** because the dominant term is the traversal of the input string, and the other operations (like stack manipulation and string construction) are linear or bounded by `k` (which is ≤ `n`).
    //
    //---
    //
    //### **Space Complexity**:
    //1. **Stack Space:**
    //   - The stack `st` can store up to `n` characters in the worst case (e.g., when `k = 0` and all characters are added to the stack). This requires **O(n)** space.
    //
    //2. **StringBuilder:**
    //   - The `StringBuilder` can store up to `n` characters, requiring **O(n)** space.
    //
    //**Overall Space Complexity**:
    //The dominant space requirement is the stack, so the space complexity is **O(n)**.
    //
    //---
    //
    //### **Final Analysis**:
    //- **Time Complexity**: **O(n)**
    //- **Space Complexity**: **O(n)**

/// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

// brute force approach:
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];

        for (int i = 0; i < n; i++){
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }

            if (st.isEmpty()){
                leftSmall[i] = 0;
            }else{
                leftSmall[i] = st.peek() + 1;
                //When we pop elements from the stack, the remaining st.peek() represents the index of the nearest smaller bar to the left of the current bar (heights[i]).
                //However, this nearest smaller bar cannot be part of the rectangle for the current bar because it is smaller. The rectangle can only start right after this smaller bar.
            }

            st.push(i);
        }

        while (!st.isEmpty()){
            st.pop();
        }

        for (int i = n-1; i >=0; i--){
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }

            if (st.isEmpty()){
                rightSmall[i] = n-1;
            }else{
                rightSmall[i] = st.peek() - 1;
            }
            st.push(i);
        }

        int maxA = 0;

        for (int i = 0; i < n; i++){
            maxA = Math.max(maxA, heights[i] * (rightSmall[i]-leftSmall[i] + 1));
        }

        return maxA;

    }

    //Time Complexity: O( 5N )
    //
    //Space Complexity: O(3N) where 3 is for the stack, left small array and a right small array

//------------------------------------------------------------------------------------------------------------------

    // optimal solution

    public int largestRectangleArea2(int[] heights) {
        int len = heights.length; // Get the number of bars in the histogram
        Stack<Integer> st = new Stack<>(); // Stack to store indices of the histogram bars
        int maxArea = 0; // Variable to track the maximum area encountered

        // Iterate through the histogram, including a virtual bar of height 0 at the end
        for (int i = 0; i <= len; i++) {
            // For the virtual bar at the end, height is 0. Otherwise, take the current bar height.
            int h = (i == len) ? 0 : heights[i];

            // If the stack is empty or the current height is greater than or equal to the height at the top of the stack:
            if (st.isEmpty() || h >= heights[st.peek()]) {
                st.push(i); // Push the current index onto the stack
            } else {
                // When the current height is less than the height of the bar at the top of the stack:
                int tp = st.pop(); // Pop the top index from the stack
                // Calculate the width of the rectangle with the popped bar as the smallest (height-defining) bar:
                int width = st.isEmpty() ? i : i - 1 - st.peek(); // If the stack is empty, the rectangle extends from 0 to `i - 1`
                // Calculate the area of the rectangle using the popped bar as height and the computed width
                maxArea = Math.max(maxArea, heights[tp] * width);
                i--; // Decrement `i` to re-evaluate the current bar with the new stack top
            }
        }

        return maxArea; // Return the maximum area found
    }


    // Time Complexity: O( N ) + O (N)
    //
    //Space Complexity: O(N)

/// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
//
// 

    public int maximalRectangle(char[][] matrix) {
        // Edge case: If matrix is empty
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length; // Number of rows
        int m = matrix[0].length; // Number of columns

        int[] heights = new int[m]; // Histogram heights for each column
        int maxArea = 0; // Track the maximum rectangle area

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Update histogram heights: Increment for '1', reset to 0 for '0'
                if (matrix[i][j] == '1') {
                    heights[j]++; // Increment height for column `j`
                } else {
                    heights[j] = 0; // Reset height for column `j` if '0' is encountered
                }
            }

            // Calculate the largest rectangle area for the current histogram
            maxArea = Math.max(maxArea, largestRectangleArea2(heights));
        }

        return maxArea;
    }


    //Total Time Complexity:
    //Combining these:
    //
    //The outer loop runs O(n) times.
    //Inside the loop, we spend O(m) for updating heights and another O(m) for the largestRectangleArea2 function.
    //Total = O(n × m).


    //Space Complexity
    //The space complexity depends on the additional data structures used.
    //
    //Heights Array:
    //
    //The heights array is of size m, where m is the number of columns.
    //Space = O(m).
    //Stack in largestRectangleArea2:
    //
    //The stack used in largestRectangleArea2 can hold up to m elements in the worst case (if the histogram is strictly increasing or decreasing).
    //Space = O(m).
    //Total Space Complexity:
    //Adding these together, the total space complexity is O(m).


}
