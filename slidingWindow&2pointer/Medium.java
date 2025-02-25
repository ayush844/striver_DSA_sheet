import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Medium {

    public static void main(String[] args) {

    }


////////////////////////////////////////////////////////////////////////////////////////////

    // 2 pointer & sliding window in case of subarrays

////////////////////////////////////////////////////////////////////////////////////////////

// Given a String, find the length of longest substring without any repeating character.

    // Brute force approach:

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int maxans = 0;  // Start from 0 instead of Integer.MIN_VALUE

        for (int i = 0; i < s.length(); i++) {
            Set<Character> se = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (se.contains(s.charAt(j))) {
                    break;  // Break if a duplicate is found
                }
                se.add(s.charAt(j));
                maxans = Math.max(maxans, j - i + 1); // Update maxans for every valid substring
            }
        }

        return maxans;
    }

    // Time Complexity: O( N2 )
    //Space Complexity: O(N) where N is the size of HashSet taken for storing the elements

//-------------------------------------------------------------------------------------------

    // optimal approach


    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = s.length();
        int len = 0;

        while (right < n){
            if (map.containsKey(s.charAt(right))){
                left = Math.max(left, map.get(s.charAt(right)) + 1); //** explanation below
            }
            map.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }

        return len;
    }

    // Time Complexity: O( N )
    //
    //Space Complexity: O(N) where N represents the size of HashSet where we are storing our elements


// Summary

//Why do we use Math.max(left, map.get(s[right]) + 1)?
//To ensure left does not move backward when updating the window.
//If the previous occurrence of a character is already out of the window, left remains unchanged.

//How does it handle cases where a character exists in map but is not in the current window?
//It checks the last seen index and only moves left forward when needed.
//If the character’s last occurrence is outside the current window, left stays the same.

//Final Complexity:
//O(N) time (each character is processed at most twice).
//O(min(N, 26)) space (storing 26 lowercase letters).

//This is why the sliding window + HashMap approach works efficiently! 🚀

/// //////////////////////////////////////////////////////////////////////////////////////////

// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

// Brute Force approach

    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++){
            int zeroes = 0;
            for (int j = i; j < n; j++){
                if (nums[j] == 0){
                    zeroes++;
                }
                if (zeroes <= k){
                    int len = j - i + 1;
                    maxLen = Math.max(len, maxLen);
                }else{
                    break;
                }
            }
        }

        return maxLen;
    }

    // time complexity: O(n ^ 2)
    // space complexity: O(1)


//--------------------------------------------------------------------------------------------


    // Optimal Approach


    public int longestOnes2(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int maxLen = 0;
        int zeroes = 0;
        while (right < n){
            if(nums[right] == 0){
                zeroes ++;
            }

            while (zeroes > k){
                if(nums[left] == 0){
                        zeroes--;
                }
                left++;
            }

            maxLen = Math.max(right-left+1, maxLen);
            right++;
        }

        return maxLen;
    }

    //     // time complexity: O(2n)
    //    // space complexity: O(1)

/////////////////////////////////////////////////////////////////////////////////////////////

// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
//Return the length of the longest substring containing the same letter you can get after performing the above operations.


    public int characterReplacement(String s, int k) {
        int start = 0;
        int maxCount = 0;
        int maxLen = 0;
        int[] count = new int[26];

        for (int end = 0; end < s.length(); end++){
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']); // maxCount is updated to track the most frequently occurring character in the window.

            while (end - start + 1 - maxCount > k){ // if more than k replacements
                count[s.charAt(start) - 'A']--;
                start++;    //  we shrink the window from the left (start++).
            }

            maxLen = Math.max(maxLen, end - start + 1); // After ensuring that the window is valid, we update maxLength with the current window size.
        }

        return maxLen;
    }


    //Time Complexity
    //O(N): Each character is processed once when expanding (end++) and at most once when shrinking (start++).
    //Space Complexity
    //O(1): Uses only a fixed-size count array (26 elements for uppercase English letters).

/////////////////////////////////////////////////////////////////////////////////////////////

    // Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
    //
    //A subarray is a contiguous part of the array.

    public int atMostGoal(int[] nums, int goal) {

        if(goal < 0){
            return 0;
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;

        while (right < nums.length){
            //we're iterating over the nums array and
            //then adding the current element into the sum
            sum += nums[right];

            //if our current sum is greater than our goal
            //that means we don't need the extra element
            //so we will shrink our window by subtracting
            //the left elements from sum till sum > goal
            while (sum > goal){
                sum = sum - nums[left];
                left++;
            }

            //We're adding the length of each subarray
            //to our result
            count = count + (right - left + 1);

            right++;
        }

        return count;

    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMostGoal(nums, goal) - atMostGoal(nums, goal-1);
    }

    // time complexity of atMostGoal: O(2n)
    // space complexity of atMostGoal: O(1)

    // time complexity of numSubarraysWithSum: O(2 * 2n) = O(4n)
    // space complexity of numSubarraysWithSum: O(1)


/////////////////////////////////////////////////////////////////////////////////////////////

    // Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
    //Return the number of nice sub-arrays.

public int atMostGoal2(int[] nums, int goal) {
    if(goal < 0){
        return 0;
    }
    int left = 0;
    int right = 0;
    int sum = 0;
    int count = 0;

    while (right < nums.length){
        sum += nums[right] % 2;
        while (sum > goal){
            sum = sum - nums[left] % 2;
            left++;
        }
        count = count + (right - left + 1);
        right++;
    }

    return count;
}


// very much similar to previous question, consider odd as 1 and even as 0
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostGoal2(nums, k) - atMostGoal2(nums, k);
    }


    // time complexity of numberOfSubarrays: O(2 * 2n) = O(4n)
    // space complexity of numberOfSubarrays: O(1)


/////////////////////////////////////////////////////////////////////////////////////////////

// Given a string s consisting only of characters a, b and c.
//
//Return the number of substrings containing at least one occurrence of all these characters a, b and c.

// brute force approach
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int cnt = 0;

        for(int i = 0; i < n; i++){
            int[] hash = new int[3];
            for (int j = i; j < n; j++){
                hash[s.charAt(j) - 'a'] = 1;
                if (hash[0] + hash[1] + hash[2] == 3){
//                    cnt += 1;
                    cnt = cnt + (n - j);    // once we get att 3 elements we can include all the character to the substring after that
                    break;
                }
            }
        }
        return cnt;
    }

    // time complexity: O(n^2)
    //space complexity: O(1)


//-------------------------------------------------------------------------------------------

// optimal solution

    // with every element there is a substring that ends

    public int numberOfSubstrings2(String s) {
        int[] lastSeen = {-1, -1, -1};
        int cnt = 0;
        int n = s.length();

        for (int i = 0; i < n; i++){
            lastSeen[s.charAt(i) - 'a'] = i;
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                int minLastSeen = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));// minimum among the index of the last seen
                cnt += (minLastSeen + 1);
            }
        }

        return cnt;
    }


    // time complexity: O(n)
    //space complexity: O(1)



/////////////////////////////////////////////////////////////////////////////////////////////

    //There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.
    //In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
    //Your score is the sum of the points of the cards you have taken.
    //Given the integer array cardPoints and the integer k, return the maximum score you can obtain.


    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0;
        int rsum = 0;
        int maxScore = 0;
        int n = cardPoints.length;
        for (int i = 0; i < k; i++){
            lsum += cardPoints[i];
        }

        maxScore = lsum;
        int rightIndex = n-1;

        for (int i = k - 1; i>= 0; i--){
            lsum = lsum - cardPoints[i];
            rsum = rsum + cardPoints[rightIndex];
            rightIndex--;
            maxScore = Math.max(maxScore, lsum + rsum);
        }

        return maxScore;

    }

    // time complexity: O(2k)
    // space complexity: O(1)

/// /////////////////////////////////////////////////////////////////////////////////////////

    // 3rd question in striver sheet
    // Given an array arr[] containing positive elements, the task is to find the length of the longest subarray of an input array containing at most two distinct integers.


    public static int totalElements(Integer[] arr) {
        int maxLen = 0;
        int left = 0;
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();    // Stores element frequency

        for (int right = 0; right < n; right++){
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            while (map.size() > 2){ // If more than 2 distinct elements, shrink window
                map.put(arr[left],map.get(arr[left]) - 1);
                if(map.get(arr[left]) == 0){
                    map.remove(arr[left]);  // Remove if count becomes zero
                }
                left++; // Move left pointer to reduce window size
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }


    // time complexity: O(2N)
    // space complexity: O(1)


/// /////////////////////////////////////////////////////////////////////////////////////////





}
