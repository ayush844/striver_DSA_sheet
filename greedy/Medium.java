import java.util.*;


public class Medium {

//You are given timings of n meetings in the form of (start[i], end[i]) where start[i] is the start time of meeting i and end[i] is the finish time of meeting i. Return the maximum number of meetings that can be accommodated in a single meeting room, when only one meeting can be held in the meeting room at a particular time.
//
//Note: The start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

    static class Meeting{
        int start;
        int end;
        int pos;

        Meeting(int start, int end, int pos){
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    static class MeetingComparator implements Comparator<Meeting>{
        @Override
        public int compare(Meeting o1, Meeting o2)
        {
            if (o1.end < o2.end)
                return -1;
            else if (o1.end > o2.end)
                return 1;
            else if(o1.pos < o2.pos)
                return -1;
            return 1;
        }
    }

    static void maxMeetings(int start[], int end[], int n) {
        ArrayList<Meeting> meet = new ArrayList<>();

        for (int i = 0; i < start.length; i++){
            meet.add(new Meeting(start[i], end[i], i+1 ));
        }

        MeetingComparator mc = new MeetingComparator();

        Collections.sort(meet, mc);

        ArrayList<Integer> order = new ArrayList<>();

        order.add(meet.get(0).pos);
        int limit = meet.get(0).end;

        for (int i = 1; i < start.length; i++){
            if (meet.get(i).start > limit){
                limit = meet.get(i).end;
                order.add(meet.get(i).pos);
            }
        }

        System.out.println("The order in which meeting will be performed is ");

        for (int i = 0; i < order.size(); i++){
            System.out.print(order.get(i) + " ");
        }


    }


    /// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

// You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
//
//Return true if you can reach the last index, or false otherwise.

    public boolean canJump(int[] nums) {
        int maxTotal = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++){
            if (i > maxTotal){
                return false;
            }

            maxTotal = Math.max(maxTotal, i + nums[i]);

        }

        return true;
    }

    //Time Complexity: O(N) where N is the length of the input array. We iterate through the input array exactly once and at each element perform constant time operations.
    //Space Complexity: O(1) as the algorithm uses only a constant amount of extra space regardless of the size of the input array. It does not require any additional data structures that scale with the input size.


    /// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

//You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
//Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
//0 <= j <= nums[i] and
//i + j < n
//Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].


    public int jump(int[] nums) {
        int jumps = 0;
        int l = 0;
        int r = 0;
        int n = nums.length;
        while (r < n-1){
            int farthest = 0;
            for(int index = l; index <= r; index++){
                farthest = Math.max(farthest, index + nums[index]);
            }
            l = r + 1;
            r = farthest;
            jumps++;
        }

        return jumps;
    }

    //Time Complexity: 𝑂(𝑛)
    //O(n) – We iterate through the array once.

    //Space Complexity: 𝑂(1)
    //O(1) – We use only a few integer variables.


    /// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //You are given the arrival times arr[] and departure times dep[] of all trains that arrive at a railway station on the same day. Your task is to determine the minimum number of platforms required at the station to ensure that no train is kept waiting.
    //
    //At any given time, the same platform cannot be used for both the arrival of one train and the departure of another. Therefore, when two trains arrive at the same time, or when one arrives before another departs, additional platforms are required to accommodate both trains.



// Brute Force approach
    public int findPlatform(int arr[], int dep[]) {
        int ans = 1;
        int n = arr.length;

        for (int i = 0; i < n; i++){
            int count = 1;

            for (int j = i +1; j < n; j++){
                if ((arr[i] >= arr[j] && arr[i] <= dep[j]) || (arr[j] >= arr[i] && arr[j] <= dep[i])){  // Train i arrives while Train j is still at the station. or Train j arrives while Train i is still at the station.
                    count++;    //If any of these conditions hold, count (number of required platforms) is increased.
                }
            }

            ans = Math.max(count, ans); //Stores the maximum value of count encountered in all iterations.
        }

        return ans;
}

//Time Complexity: O(n^2)  (due to two nested loops).
//Space Complexity: O(1)  (no extra space used).

//-------------------------------------------------------------------------------------------------------------------


    // optimal approach
    public int findPlatform2(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0;
        int j = 0;
        int count = 0;
        int maxCount = 0;

        int n = arr.length;

        while (i < n){
            if (arr[i] <= dep[j]){
                count++;
                i++;
            }
            else {
                count--;
                j++;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;

    }

//Time Complexity: O(2(nlogn + n))
//Space Complexity: O(1)  (no extra space used).

    /// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

// There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
//
//You are giving candies to these children subjected to the following requirements:
// > Each child must have at least one candy.
// > Children with a higher rating get more candies than their neighbors.

//Return the minimum number of candies you need to have to distribute the candies to the children.



    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        right[n-1] = 1;

        for (int i = 1; i < n; i++){
            if (ratings[i] > ratings[i-1]){
                left[i] = left[i-1] + 1;
            }else{
                left[i] = 1;
            }
        }

        for (int j = n - 2; j >= 0; j--){
            if (ratings[j] > ratings[j + 1]){
                right[j] = right[j + 1] + 1;
            }else {
                right[j] = 1;
            }
        }

        int sum = 0;

        for (int m = 0; m < n; m++){
            sum = sum + Math.max(left[m], right[m]);
        }

        return sum;
    }

    // time complexity: O(3n)
    // space complexity: O(2n)

//-------------------------------------------------------------------------------------------------------------

    // optimal approach: approach with slope (need to watch video to understand)

    public int candy2(int[] ratings) {
        int sum = 1;
        int i = 1;
        int n = ratings.length;
        while (i < n){
            if (ratings[i] == ratings[i-1]){
                sum = sum + 1;
                i++;
                continue;
            }
            int peak = 1;
            while (i < n && ratings[i] > ratings[i-1]){
                peak++;
                sum += peak;
                i++;
            }
            int down = 1;
            while (i < n && ratings[i] < ratings[i-1]){
                sum += down;
                down++;
                i++;
            }

            if (down > peak){
                sum += down - peak;
            }


        }

        return sum;
    }


//Time Complexity: O(n)
//Space Complexity: O(1)


    /// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Geek is a software engineer. He is assigned with the task of calculating average waiting time of all the processes by following shortest job first policy.
//The shortest job first (SJF) or shortest job next, is a scheduling policy that selects the waiting process with the smallest execution time to execute next.
//Given an array of integers bt of size n. Array bt denotes the burst time of each process. Calculate the average waiting time of all the processes and return the nearest integer which is smaller or equal to the output.
//Note: Consider all process are available at time 0.


    public int sjf(int bt[] ) {
        // code here
        Arrays.sort(bt);

        int t = 0;
        int wtTime = 0;
        int n = bt.length;

        for (int i = 0; i < n; i++){
            wtTime += t;
            t += bt[i];
        }

        return (wtTime / n);

    }

//Time Complexity: O(n) + O(nlogn)
//Space Complexity: O(1)

    /// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
    //Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
    //Return intervals after the insertion.
    //Note that you don't need to modify intervals in-place. You can make a new array and return it.


    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add all intervals before newInterval (no overlap)
        while(i < n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Add remaining intervals
        while (i < n){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

//Time Complexity: O(n)
//Space Complexity: O(n)

    /// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

    public int[][] merge(int[][] intervals) {

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] <= current[1]){
                // Merge intervals
                current[1] = Math.max(intervals[i][1], current[1]);
            }else{
                // Add the previous interval and move to the next
                merged.add(current);
                current = intervals[i];
            }
        }
        merged.add(current);

        return merged.toArray(new int[merged.size()][]);
    }

    // time complexity: O(n log n) + O(n) ≈ O(n log n).
    // space complexity: O(n)

    /// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
//
//Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int n = intervals.length;
        int cnt = 1;    // we'll take the first meeting
        int lastEndingTime = intervals[0][1];   // ending time of first meeting

        for (int i = 0; i < n; i++){
            if(intervals[i][0] >= lastEndingTime){
                lastEndingTime = intervals[i][1];
                cnt++;
            }
        }

        return n - cnt;

    }

    // time complexity: O(n log n) + O(n) ≈ O(n log n).
    // space complexity: O(1)





}
