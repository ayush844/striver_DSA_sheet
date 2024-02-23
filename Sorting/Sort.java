import java.util.ArrayList;

public class Sort {
    public static void main(String[] args) {
        System.out.println("hello world");

        int[] arr = {64, 25, 12, 22, 11};
        qs(arr, 0, 4);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    //Selection sort is a simple sorting algorithm that works by repeatedly finding the minimum element from the unsorted portion of the array and putting it at the beginning. It maintains two subarrays: the sorted subarray and the unsorted subarray. In each iteration, it finds the minimum element from the unsorted subarray and swaps it with the first element of the unsorted subarray, effectively expanding the sorted subarray.

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the index of the minimum element in the unsorted part of the array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // time complexity := O(n^2) [best, worst and avg case]


    //**************************************************************************************************************


    //Bubble sort is another simple sorting algorithm. It works by repeatedly stepping through the list of elements to be sorted, comparing each pair of adjacent items and swapping them if they are in the wrong order. This process is repeated until no swaps are needed, which means the list is sorted.

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Last i elements are already sorted, so we don't need to check them
            for (int j = 0; j < n - i - 1; j++) {
                // Swap adjacent elements if they are in the wrong order
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped in the inner loop, then the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    //if we try to access an element that don't exist then it throws runtime error


    // time complexity := O(n^2) [worst and avg case] & O(n) for best case [when array is sorted]


    //**************************************************************************************************************


    //Insertion sort is another simple sorting algorithm. It builds the final sorted array (or list) one item at a time. It iterates through the input list, removing one element from the input data, and then finding its correct position in the already-sorted part of the array. It repeatedly does this until no more unsorted elements remain.


    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    // time complexity := O(n^2) [worst and avg case] & O(n) for best case [when array is sorted where while loop will never run]

    //**************************************************************************************************************

    // MERGE SORT

    public static void merge(int[]arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid+1;

        while (low <= mid && right <= high){
            if (arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid){
            temp.add(arr[left]);
            left++;
        }

        while (right <= high){
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++){
            arr[i] = temp.get(i-low);
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high){
            return;
        }
        int mid = (low + high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    // time complexity: ***
    //Time complexity: O(nlogn)
    //Reason: At each step, we divide the whole array, for that logn and we assume n steps are taken to get sorted array, so overall time complexity will be nlogn

    //Space complexity: O(n)
    //Reason: We are using a temporary array(inside merger()) to store elements in sorted order.
    //Auxiliary Space Complexity: O(n)

    //**************************************************************************************************************

    // QUICK SORT

    public static int findPivotIndex(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j){
            while (arr[i] <= pivot && i <= high-1){
                i++;
            }
            while (arr[j] > pivot && j >= low+1){
                j--;
            }
            if (i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return  j;
    }

    public static void qs(int[] arr, int low, int high) {
        if (low < high){
            int pIndex = findPivotIndex(arr, low, high);
            qs(arr, low, pIndex-1);
            qs(arr, pIndex+1, high);
        }
    }

    //Time Complexity for the best and average case: O(N*logN)
    //Space Complexity: O(1)


}
