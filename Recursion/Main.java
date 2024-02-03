import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<String> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello world!");
//        Scanner scanner = new Scanner(System.in);
//        int input = scanner.nextInt();
//        scanner.nextLine();
//        scanner.close();

        List<String> stringList = new ArrayList<>();

        stringList = printNtimes(3);

        System.out.println(stringList);


//        System.out.println(printReverseNos(5));


        System.out.println(sumFirstN(5));

        int[] arr = {10, 20, 30};

        int[] revArr = reverseArray(3, arr);

        for (int i = 0; i < revArr.length; i++){
            System.out.println(revArr[i]);
        }

        String str = "abccba";

        System.out.println(isPalindrome(str));

        int[] arrNew = generateFibonacciNumbers(5);

        for (int i = 0; i < arrNew.length; i++){
            System.out.println(arrNew[i]);
        }


    }


    //RECURSION:
    //when a function calls itself untill a specific condition is met

    //if we don't give it a stopping condition it will cause stack overflow in memory





    //--------------------------------------------------------------------------------------------------------------

    //You are given an integer ‘n’.
    //Your task is to return an array containing integers from 1 to ‘n’ (in increasing order) without using loops.
    public static int[] printNos(int x) {
        int arr[] = new int[x];
        return print(arr, 0);
    }

    public static int[] print(int[] arr, int n){
        if(n == arr.length ){
            return arr;
        }
        arr[n] = ++n;
        return print(arr, n);
    }

    //time complexity => O(n)
    //space complexity => O(n)
    //--------------------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------------------
    //You are given an integer ‘n’.
    //Print “Coding Ninjas ” ‘n’ times, without using a loop.
    public static List<String> printNtimes(int n){
        if (n==0){
            return arrayList;
        }
        arrayList.add("Coding Ninjas");
        printNtimes(n-1);
        return arrayList;
    }

    //time complexity => O(n)
    //space complexity => O(n)

    //-------------------------------------------------------------------------------------------------------------

    //-------------------------------------------------------------------------------------------------------------
//You are given an integer ‘n’.
//Your task is to return an array containing integers from ‘n’ to ‘1’ (in decreasing order) without using loops.

    public static int[] printReverseNos(int x) {
        int arr[] = new int[x];
        int index = 0;
        return printReverse(arr, x, index);
    }

    public static int[] printReverse(int[] arr, int n, int i){
        if(n == 0){
            return arr;
        }
        arr[i] = n;
        return printReverse(arr, n-1, i+1);
    }


    //-------------------------------------------------------------------------------------------------------------

    // PRINT 1 TO N WITH BACKTRACKING
    //void func( i, n)
    //{
    //   if(i<1) return;
    //   f( i-1,N );
    //   print(i);
    //}
    //
    //main()
    //{
    //  int n;
    //  input(n);
    //  f(n,n);
    //}

    // PRINT N TO 1 WITH BACKTRACKING

    //void func( i, n)
    //{
    //   if(i>n) return;
    //
    //   f( i+1,n );
    //   print(i);
    //}
    //
    //main()
    //{
    //  int n;
    //  input(n);
    //  f(1,n);
    //}
    //-------------------------------------------------------------------------------------------------------------

//You are given an integer ‘n’.
//Your task is determining the sum of the first ‘n’ natural numbers and returning it.
    public static long sumFirstN(long n) {
        long sum = 0;
        return doSum(sum, n);
    }

    public static long doSum(long sum, long n) {
        if (n==0){
            return sum;
        }
        sum+=n;
        return doSum(sum, n-1);
    }

//----------------------------------------------------------------------------------------------------------------

    // parameterized way

    //void func(i,sum)
    //{
    //   if(i<1)
    //   {
    //     print(sum);
    //     return;
    //   }
    //    func(i-1,sum+i);
    //}
    //
    //main()
    //{
    //   input(n);
    //   func(n,0);
    //}
//----------------------------------------------------------------------------------------------------------------

    // functional way

    //int func(n)
    //{
    //   if(n == 0)
    //   {
    //     return 0;
    //   }
    //   return n + func(n-1);
    //}
    //
    //main()
    //{
    //   input(n);
    //   func(n);
    //}

    //time complexity => O(n)
    //space complexity => O(n)

//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------//-------------------------------------------------------------------------------------------------------------

    //Given an array 'arr' of size 'n'.
    //Return an array with all the elements placed in reverse order.
    public static int[] reverseArray(int n, int []nums) {
        int[] arr = nums;
        return reverseNewArray(arr, 0, n-1);
    }

    public static int[] reverseNewArray(int []arr, int i, int j){

        if (i >= j){
            return arr;
        }

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return reverseNewArray(arr, i+1, j-1);
    }


    //-------------------------------------------------------------------------------------------------------------

    //-------------------------------------------------------------------------------------------------------------


    //Determine if a given string ‘S’ is a palindrome using recursion. Return a Boolean value of true if it is a palindrome and false if it is not.
    //Note: You are not required to print anything, just implement the function.

    public static boolean isPalindrome(String str) {
        String value = str;
        return checkPalindrome(str, 0, str.length()-1);
    }

    public static boolean checkPalindrome(String str, int i, int j) {
        if (i >= j){
            return true;
        }

        if (str.charAt(i) != str.charAt(j)){
            return false;
        }else{
            return checkPalindrome(str, i+1, j-1);
        }
    }

    //time complexity => O(n)
    //space complexity => O(n)

    //****************************************** LEETCODE ******************************************************

    //class Solution {
    //    public boolean isPalindrome(String str) {
    //        String value = str.replaceAll("\\s", "");
    //        value = value.toLowerCase();
    //        value = value.replaceAll("[^a-zA-Z0-9]", "");
    //        return checkPalindrome(value, 0, value.length()-1);
    //    }
    //
    //    public static boolean checkPalindrome(String str, int i, int j) {
    //        if (i >= j){
    //            return true;
    //        }
    //
    //        if (str.charAt(i) != str.charAt(j)){
    //            return false;
    //        }else{
    //            return checkPalindrome(str, i+1, j-1);
    //        }
    //    }
    //}

    //-------------------------------------------------------------------------------------------------------------//-------------------------------------------------------------------------------------------------------------

    public static int[] generateFibonacciNumbers(int n) {
        
        if (n == 0){
            int[] arr = {};
            return arr;
        } else if (n==1) {
            int[] arr = {0};
            return arr;
        } else if (n == 2) {
            int[] arr = {0, 1};
            return arr;
        }else{
            int[] arr = new int[n];
            arr[0] = 0;
            arr[1] = 1;
            return createFibonacci(arr, 2, n);
        }
    }

    public static int[] createFibonacci(int[] arr, int i, int n) {

        if (i == n){
            return arr;
        }

        arr[i] = arr[i-1] + arr[i-2];

        return createFibonacci(arr, i+1, n);
    }

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    //class Recursion {
    //
    //    static int fibonacci(int N){
    //
    //            // Base Condition.
    //            if(N <= 1){
    //
    //                return N;
    //            }
    //
    //            // Problem broken down into 2 functional calls
    //            // and their results combined and returned.
    //            int last = fibonacci(N-1);
    //            int slast = fibonacci(N-2);
    //
    //            return last + slast;
    //    }
    //
    //
    //    public static void main(String[] args) {
    //
    //       // Here, let’s take the value of N to be 4.
    //       int N = 4;
    //       System.out.println(fibonacci(N));
    //    }
    //}


    //time complexity => O(2^n)

}