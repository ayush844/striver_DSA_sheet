import java.util.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Easy {



    public static void main(String[] args) {
        int ans = minCoinsRecur(49);
    }

    // Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
    //
    //Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

    public int findContentChildren(int[] g, int[] s) {
        int left = 0;
        int right = 0;
        int n = g.length;
        int m = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        while (left < n && right < m){
            if (g[left] <= s[right]){
                left++;
            }
            right++;
        }

        return left;
    }

    // Time Complexity: O(N logN + M logM + M) where N is the length of the greedy array, M is the length of the cookies array. To sort the greedy and cookies array, the complexity is O(N logN) and O(M logM).
    //
    //After sorting, we iterate over the arrays at most M times as M is the total number of cookies.
    //Since each child and each cookie is considered at most once, the time complexity of this part is linear in terms of the size of the cookie array, which is O(M).
    //Space Complexity: O(1) as the algorithm uses only a constant amount of extra space regardless of the size of the input array. It does not require any additional data structures that scale with the input size.

////////////////////////////////////////////////////////////////////////////////////////////////////////


    // Problem Statement: Given a value V, if we want to make a change for V Rs, and we have an infinite supply of each of the denominations in Indian currency, i.e., we have an infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes, what is the minimum number of coins and/or notes needed to make the change.

    public static int minCoinsRecur(int sum) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int n = coins.length;
        int total = sum;

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--){
            while (total >= coins[i]){
                total  -= coins[i];
                ans.add(coins[i]);
            }
        }

        for (int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }

        return ans.size();

    }

    //Time Complexity:O(sum)
    //
    //Space Complexity:O(1)


////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. You must provide the correct change to each customer so that the net transaction is that the customer pays $5.
//
//    Note that you do not have any change in hand at first.
//
//    Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every customer with the correct change, or false otherwise.


    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++){
            if (bills[i] == 5){
                five++;
            } else if (bills[i] == 10) {
                if(five > 0){
                    five--;
                    ten++;
                }else{
                    return false;
                }
            }else{
                if(five > 0 && ten > 0){
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                }else {
                    return false;
                }
            }
        }

        return true;
    }

    //Time Complexity: O(N) where N is the number of people in queue/ bills we will deal with. We iterate through each customer’s bills exactly once. The loop runs for N iterations and at each iteration the operations performed are constant time.
    //
    //Space Complexity: O(1) as the algorithm uses only a constant amount of extra space regardless of the size of the input array. It does not require any additional data structures that scale with the input size.

////////////////////////////////////////////////////////////////////////////////////////////////////////
//
     // Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
    //The following rules define a valid string:
    //Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    //Any right parenthesis ')' must have a corresponding left parenthesis '('.
    //Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    //'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
    //

public boolean checkValidString(String s) {

    // for '(' add 1, for ')' add -1 and for empty add 0

    int cmin = 0, cmax = 0; // open parentheses count in range [cmin, cmax]
    for (char c : s.toCharArray()) {
        if (c == '(') {
            cmax++;
            cmin++;
        } else if (c == ')') {
            cmax--;
            cmin--;
        } else if (c == '*') {
            cmax++; // if `*` become `(` then openCount++
            cmin--; // if `*` become `)` then openCount--
            // if `*` become `` then nothing happens
            // So openCount will be in new range [cmin-1, cmax+1]
        }
        if (cmax < 0) return false; // Currently, don't have enough open parentheses to match close parentheses-> Invalid
        // For example: ())(
        cmin = Math.max(cmin, 0);   // It's invalid if open parentheses count < 0 that's why cmin can't be negative
    }
    return cmin == 0; // Return true if can found `openCount == 0` in range [cmin, cmax]
}

////////////////////////////////////////////////////////////////////////////////////////////////////////
//

    

    
}
