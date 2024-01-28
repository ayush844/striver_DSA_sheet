import java.util.*;

public class Main {


    public static void main(String[] args) {
        System.out.println(countDigitsDividingEvenly(123));
        System.out.println(reverse(123));

//        Scanner scan = new Scanner(System.in);
//        int num = scan.nextInt();

        System.out.println(isPalindrome(121));

        System.out.println(sumOfAllDivisors(3));



        System.out.println(countDigits(32456123));


        System.out.println(isArmstrong(1634));



        printAllDivisors(36);
        printAllDivisorsBetter(36);

        gcd(12, 36);

    }

    //------------------------------------------------------------------------------------------------------
    //------------------------------- countDigitsDividingEvenly---------------------------------------------

    // You are given a number ’n’.
    //Find the number of digits of ‘n’ that evenly divide ‘n’.
    public static int countDigitsDividingEvenly(int n){
        int value = n;
        int count = 0;
        while(value != 0){
            int term = value % 10;
            if(term != 0 && n%term == 0){
                count++;
            }
            value = value/10;
        }
        return count;
    }
    //time complexity => O(log10(n))  [10 as base]
    //whenever there is a division that decides the number of iterations that will be run we'll use log, if it is happening with 2 then log base2
    //space complexity => O(1)

    //------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------


    //------------------------------------------------------------------------------------------------------
    //------------------------------- REVERSING A NUMBER-------------------------------------------------
    //reversing a number (leetcode)
    public static int reverse(int x) {
        int given = Math.abs(x);
        int rev = 0;
        while (given!=0){
            int ld = given % 10;
            if(rev > (Integer.MAX_VALUE - ld) / 10){
                return 0;
            }
            rev = rev*10 + ld;
            given = given / 10;
        }

        return (x < 0)? -rev : rev ;
    }

    //time complexity => O(log10(n))  [10 as base]
    //whenever there is a division that decides the number of iterations that will be run we'll use log, if it is happening with 2 then log base2
    //space complexity => O(1)



    //------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------
    //------------------------------- RPALINDROME NUMBER-------------------------------------------------

    // palindrome (leetcode)
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x==0){
            return true;
        }
        int value = x;
        int reverseValue = reverse(x);
        if (reverseValue == 0){
            return false;
        }
        if (reverseValue == value){
            return true;
        }else{
            return false;
        }
    }

    //time complexity => O(log10(n))  [10 as base]
    //whenever there is a division that decides the number of iterations that will be run we'll use log, if it is happening with 2 then log base2
    //space complexity => O(1)



    //------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------


    //-----------------------------------------------------------------------------------------------------
    //-------------------------------SUM OF DIVISOR-----------------------------------------------
    // sum of divisors

    public static int sumOfAllDivisors(int n){
        int sum = 0;
        for (int i = 1; i <= n; i++){
            if (n % i == 0){
                sum+=i;
            }
        }
        return sum;
    }

    //time complexity => O(n)
    //space complexity => O(1)

    //------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------


    //-----------------------------------------------------------------------------------------------------
    //-------------------------------PRINT ALL DIVISOR-----------------------------------------------

    public static void printAllDivisors(int n){
        for (int i = 1; i <= n; i++){
            if (n % i == 0){
                System.out.println(i);
            }
        }
    }

    //time complexity => O(n)
    //space complexity => O(1)

    //************************************* BETTER WAY ************************************************

    public static void printAllDivisorsBetter(int n){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                numbers.add(i);
                if (n/i != i){
                    numbers.add(n/i);
                }
            }
        }
        Collections.sort(numbers);

        System.out.println("sorted list: " + numbers);
    }

    //time complexity => O(sqrt(n))
    //space complexity => O(1)



    //------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------


    //-----------------------------------------------------------------------------------------------------
    //------------------------------- ARMSTRONG NUMBER-------------------------------------------------
    public static int countDigits(int n){
        int value = n;
        int count = 0;
        while(value != 0){
            int term = value % 10;
            count++;
            value = value/10;
        }
        return count;
    }


    public static boolean isArmstrong(int num){
        int value = num;
        int power = countDigits(value);
        int sum = 0;
        while(value != 0){
            int term = value % 10;
            sum += (int) Math.pow(term, power);
            value /= 10;
        }
        return ( sum==num )? true : false;
    }

    //time complexity => O(log10(n))  [10 as base]
    //whenever there is a division that decides the number of iterations that will be run we'll use log, if it is happening with 2 then log base2
    //space complexity => O(1)

    //-----------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------

    //-----------------------------------------------------------------------------------------------------
    //-------------------------------GCD OR HCR-----------------------------------------------

    public static int gcd(int n1, int n2){
        int gcd = 1;
        for (int i = Math.min(n1, n2); i >= 1; i++){
            if (n1%i == 0 && n2%i == 0){
                gcd = i;
                break;
            }
        }

        System.out.println("GCD is " + gcd);

        return gcd;

    }


    //time complexity => O(min(n1, n2))
    //space complexity => O(1)


//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------






}