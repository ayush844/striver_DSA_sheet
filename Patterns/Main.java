public class Main {
    public static void main(String[] args) {

        // how to solve pattern questions
        // > nested loops[outer loop for rows and inner loop for columns]
        // > connect the inner loops somehow to the outer loops
        // > print the element inside the inner loop
        // > observe the symmetry[optional]

        pattern1(3);
        System.out.println();
        pattern2(5);
        System.out.println();
        pattern3(5);
        System.out.println();
        pattern4(5);
        System.out.println();
        pattern5(5);
        System.out.println();
        pattern6(5);
        System.out.println();
        pattern7(5);
        System.out.println();
        pattern8(5);
        System.out.println();
        pattern9(5);
        System.out.println();
        pattern10(5);
        System.out.println();
        pattern11(5);
        System.out.println();
        pattern12(5);
        System.out.println();
        pattern13(5);
        System.out.println();
        pattern14(5);
        System.out.println();
        pattern15(5);
        System.out.println();
        pattern16(5);
        System.out.println();
        pattern17(5);
        System.out.println();
        pattern18(5);
        System.out.println();
        pattern19(5);
        System.out.println();
        pattern20(5);
        System.out.println();
        pattern21(5);
        System.out.println();
        pattern22(5);
    }

    public static void pattern1(int n) {
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern2(int n) {
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern3(int n) {
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++){
                System.out.print(j+1 + " ");
            }
            System.out.println();
        }
    }

    public static void pattern4(int n) {
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++){
                System.out.print(i+1 + " ");
            }
            System.out.println();
        }
    }

    public static void pattern5(int n) {
        for (int i = n; i > 0; i--){
            for (int j = 0; j < i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern6(int n) {
        for (int i = n; i > 0; i--){
            for (int j = 0; j < i; j++){
                System.out.print(j+1 + " ");
            }
            System.out.println();
        }
    }

    public static void pattern7(int n) {
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n-(i+1); j++){
                System.out.print(" ");
            }
            for (int j = 0; j < (2*i+1); j++){
                System.out.print("*");
            }
            for (int j = 0; j < n-(i+1); j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern8(int n) {
        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++){
                System.out.print(" ");
            }
            for (int j = 0; j < (2*(n-i-1) + 1); j++){
                System.out.print("*");
            }
            for (int j = 0; j < i; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern9(int n) {
        pattern7(n);
        pattern8(n);
    }

    public static void pattern10(int n) {
        for (int i = 0; i < 2*n; i++){
            if(i < n){
                for (int j = 0; j <= i; j++){
                    System.out.print("*");
                }
                for (int j = 0; j < n-i-1; j++){
                    System.out.print(" ");
                }
            }else{
                for (int j = 0; j < (2*n-(i+1)); j++){
                    System.out.print("*");
                }
                for (int j = 0; j < (i-n+1); j++){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void pattern11(int n) {
        int start;
        for (int i = 0; i < n; i++){

            if(i%2==0){
                start = 1;
            }else{
                start = 0;
            }

            for (int j = 0; j <= i; j++){
                System.out.print(start + " ");
                start = 1 - start;
            }

            System.out.println();
        }
    }

    public static void pattern12(int n) {
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++){
                System.out.print(j+1);
            }
            for(int j = 0; j < n-(i+1);j++){
                System.out.print("  ");
            }
            for (int j = i+1; j > 0; j--){
                System.out.print(j);
            }

            System.out.println();
        }
    }

    public static void pattern13(int n) {
        int k = 1;
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++){
                System.out.print(k + " ");
                k++;
            }
            System.out.println();
        }
    }

    public static void pattern14(int n) {
        for (int i = 0; i < n; i++){
            for (char j = 'A'; j <= 'A'+i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void pattern15(int n) {
        for (int i = 0; i < n; i++){
            for (char j = 'A'; j <= 'A'+(n-i-1); j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void pattern16(int n) {
        char k = 'A';
        for (int i = 0; i < n; i++){
            for (char j = 0; j <= i; j++){
                System.out.print(k + " ");
            }
            k++;
            System.out.println();
        }
    }

    public static void pattern17(int n) {
        for (int i = 0; i < n; i++){
            char k = 'A';
            for (int j = 0; j < n-(i+1); j++){
                System.out.print(" ");
            }
            for (int j = 0; j < (2*i+1); j++){
                System.out.print(k);
                if(j < i){
                    k++;
                }else {
                    k--;
                }
            }
            for (int j = 0; j < n-(i+1); j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern18(int n) {
        char k = 'A';
        k = (char) (k + (n - 1));
        for (int i = 0; i < n; i++){
            char l = k;
            for (char j = 0; j <= i; j++){
                System.out.print(l + " ");
                l--;
            }
            System.out.println();
        }
    }

    public static void pattern19(int n) {
        int initialSpace = 0;

        for (int i = 0; i < n; i++){
            for (int j = 1; j <= n-i; j++){
                System.out.print("*");
            }

            for (int j = 0; j < initialSpace; j++){
                System.out.print(" ");
            }

            for (int j = 1; j <= n-i; j++){
                System.out.print("*");
            }

            initialSpace+=2;
            System.out.println();
        }

        int newInitialSpace = 2*n-2;

        for (int i = 0; i < n; i++){
            for (int j = 0; j <=i; j++){
                System.out.print("*");
            }
            for (int j = 0; j < newInitialSpace; j++){
                System.out.print(" ");
            }
            for (int j = 0; j <=i; j++){
                System.out.print("*");
            }

            newInitialSpace-=2;
            System.out.println();
        }

    }

    public static void pattern20(int n) {

        int spaces = 2*n-2;

        for(int i = 1;i<=2*n-1;i++){

            int stars = i;

            if(i>n) stars = 2*n - i;

            for(int j=1;j<=stars;j++){
                System.out.print("*");
            }

            for(int j = 1;j<=spaces;j++){
                System.out.print(" ");
            }

            for(int j = 1;j<=stars;j++){
                System.out.print("*");
            }

            System.out.println();
            if(i<n) spaces -=2;
            else spaces +=2;
        }

    }

    public static void pattern21(int n){

        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){

                if(i==0 || j==0 || i==n-1 || j==n-1)
                    System.out.print("*");
                else System.out.print(" ");
            }

            System.out.println();
        }
    }

    public static void pattern22(int n){

        for(int i=0;i<2*n-1;i++){

            for(int j=0;j<2*n-1;j++){

                int top = i;
                int left = j;
                int bottom = (2*n-1)-1-i;
                int right = (2*n-1)-1-j;

                System.out.print(n-Math.min(Math.min(top, bottom), Math.min(left, right)) + " ");

            }

            System.out.println();
        }
    }

}