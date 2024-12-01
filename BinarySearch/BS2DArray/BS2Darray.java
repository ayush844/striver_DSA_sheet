import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BS2Darray {

    public static void main(String[] args) {

    }


    // Problem Statement: You have been given a non-empty grid ‘mat’ with 'n' rows and 'm' columns consisting of only 0s and 1s. All the rows are sorted in ascending order.
    //Your task is to find the index of the row with the maximum number of ones.
    //Note: If two rows have the same number of ones, consider the one with a smaller index. If there's no row with at least 1 zero, return -1.


    // brute force approach

    public int rowWithMax1s(int arr[][]) {
        int maxCnt = 0;
        int index = -1;
        int n = arr.length;
        int m = arr[0].length;

        for (int i = 0; i < n; i++){
            int cnt1 = 0;
            for (int j = 0; j < m; j++){
                if(arr[i][j] == 1){
                    cnt1++;
                }
            }
            if(cnt1 > maxCnt){
                maxCnt = cnt1;
                index = i;
            }
        }

        return index;
    }

    //Time Complexity: O(n X m), where n = given row number, m = given column number.
    //Reason: We are using nested loops running for n and m times respectively.
    //
    //Space Complexity: O(1) as we are not using any extra space.

//---------------------------------------------------------------------------------------------------------------

    // optimal approach

    // using lower bound to get first occurence of 1:
    public int lowerBound(int[] arr){
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high){
            int mid = (low + high) / 2;

            if(arr[mid] >= 1){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }


    public int rowWithMax1s2(int arr[][]){
        int maxCnt = 0;
        int index = -1;
        int n = arr.length;
        int m = arr[0].length;

        for (int i = 0; i < n; i++) {
            int cnt1 = m - lowerBound(arr[i]);
            if(cnt1 > maxCnt){
                maxCnt = cnt1;
                index = i;
            }
        }

        return index;
    }


    //Time Complexity: O(n X logm), where n = given row number, m = given column number.
    //Reason: We are using a loop running for n times to traverse the rows. Then we are applying binary search on each row with m columns.
    //
    //Space Complexity: O(1) as we are not using any extra space.


///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Problem Statement: You have been given a 2-D array 'mat' of size 'N x M' where 'N' and 'M' denote the number of rows and columns, respectively. The elements of each row are sorted in non-decreasing order. Moreover, the first element of a row is greater than the last element of the previous row (if it exists). You are given an integer ‘target’, and your task is to find if it exists in the given 'mat' or not.

    // brute force approach

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;

        // traverse the matrix:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target)
                    return true;
            }
        }

        return false;
    }

    // Time Complexity: O(N X M), where N = given row number, M = given column number.
    //Reason: In order to traverse the matrix, we are using nested loops running for n and m times respectively.
    //
    //Space Complexity: O(1) as we are not using any extra space.

//---------------------------------------------------------------------------------------------------------------


    // better approach

// check if target lies between fierst and last element of the row if yes then do binary sesarch on the array to find the target

    public boolean binarySearch(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == target){
                return true;
            } else if (arr[mid] > target) {
                high = mid -1;
            }else {
                low = mid + 1;
            }
        }

        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;

        // traverse the matrix:
        for (int i = 0; i < n; i++) {
            if(matrix[i][0] <= target && target <= matrix[i][m-1]){
                return binarySearch(matrix[i], target);
            }
        }

        return false;
    }

    //Time Complexity: O(N + logM), where N = given row number, M = given column number.
    //Reason: We are traversing all rows and it takes O(N) time complexity. But for all rows, we are not applying binary search rather we are only applying it once for a particular row. That is why the time complexity is O(N + logM) instead of O(N*logM).
    //
    //Space Complexity: O(1) as we are not using any extra space.

//---------------------------------------------------------------------------------------------------------------

    // optimal approach

    public boolean searchMatrix3(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;

        int low = 0;
        int high = n*m - 1;

        while (low <= high){
            int mid = (low + high) / 2;
            int row = mid / m;
            int col = mid % m;
            
            if(matrix[row][col] == target){
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return false;
    }


    // Time Complexity: O(log(NxM)), where N = given row number, M = given column number.
    //Reason: We are applying binary search on the imaginary 1D array of size NxM.
    //
    //Space Complexity: O(1) as we are not using any extra space.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//Problem Statement: You have been given a 2-D array 'mat' of size 'N x M' where 'N' and 'M' denote the number of rows and columns, respectively. The elements of each row and each column are sorted in non-decreasing order.
//But, the first element of a row is not necessarily greater than the last element of the previous row (if it exists).
//You are given an integer ‘target’, and your task is to find if it exists in the given 'mat' or not.

    public boolean searchMatrixTwo(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = m - 1;

        while (row < n && col >= 0){
            if(matrix[row][col] == target){
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            }else{
                col--;
            }
        }

        return false;
    }


    //Time Complexity: O(N+M), where N = given row number, M = given column number.
    //Reason: We are starting traversal from (0, M-1), and at most, we can end up being in the cell (M-1, 0). So, the total distance can be at most (N+M). So, the time complexity is O(N+M).
    //
    //Space Complexity: O(1) as we are not using any extra space.


////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.
//
//Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].
//
//You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
//
//You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.


    public int maxElement(int[][] matrix, int rows, int cols, int mid){
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++){
            if(max < matrix[i][mid]){
                max = matrix[i][mid];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m - 1;

        while (low <= high){
            int mid = (low + high) / 2;
            int row = maxElement(mat, n, m, mid);

            int left = mid - 1 >= 0 ? mat[row][mid - 1] : Integer.MIN_VALUE;
            int right = mid + 1 < m ? mat[row][mid + 1] : Integer.MIN_VALUE;

            if(mat[row][mid] > left && mat[row][mid] > right){
                return new int[] {row, mid};
            } else if (mat[row][mid] < left) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return new int[] {-1, -1};
    }


    // time complexity: O(n * log(m))
    // space complexity: O(1)


////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //Problem Statement: Given a row-wise sorted matrix of size MXN, where M is no. of rows and N is no. of columns, find the median in the given matrix.
    //
    //    Note: M and N is odd.


// brute force approach
    public int median(int mat[][]) {
        List<Integer> lst = new ArrayList<>();

        int n = mat.length;
        int m = mat[0].length;

        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                lst.add(mat[i][j]);
            }
        }

        Collections.sort(lst);
        return lst.get((n*m)/2);
    }

    // Time Complexity: O(MXN) + O(MXN(log(MXN))), where M = number of row in the given matrix, N = number of columns in the given matrix
    //
    //Reason: At first, we are traversing the matrix to copy the elements. This takes O(MXN) time complexity. Then we are sorting the linear array of size (MXN), that takes O(MXN(log(MXN))) time complexity
    //
    //Space Complexity: O(MXN) as we are using a temporary list to store the elements of the matrix.


//---------------------------------------------------------------------------------------------------------------

    // optimal approach

    public int upperBound(int[] arr, int x, int n){
        int low = 0;
        int high = n-1;
        int ans = n;

        while (low <= high){
            int mid = (low + high) / 2;

            if(arr[mid] > x){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }


    public int countSmallEquals(int[][] matrix, int n, int m, int x){
        int cnt = 0;
        for (int i = 0; i < n; i++){
            cnt += upperBound(matrix[i], x, m);
        }
        return cnt;
    }

    int median2(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][m - 1]);
        }

        int req = (n*m)/2;

        while (low <= high){
            int mid = (low + high) / 2;
            int smallEquals = countSmallEquals(mat, n, m, mid);
            if(smallEquals <= req){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return low;
    }


//    Time Complexity: O(log(10^9)) X O(M(logN)), where M = number of rows in the given matrix, N = number of columns in the given matrix
//
//    Reason: Our search space lies between [0, 109] as the min(matrix) can be 0 and the max(matrix) can be 109. We are applying binary search in this search space and it takes O(log(109)) time complexity. Then we call countSmallEqual() function for every ‘mid’ and this function takes O(M(logN)) time complexity.
//
//    Space Complexity : O(1) as we are not using any extra space





}
