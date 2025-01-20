import java.util.Stack;

public class PredfixInfixPostfixConversion {

    //Operator and Operand

    //Operator: An operator is a symbol that represents an operation or function to be performed on operands. Examples include +, -, *, /, etc.
    //Example: In 3 + 5, the + is the operator.

    //Operand: An operand is a value or variable on which the operator performs the operation.
    //Example: In 3 + 5, both 3 and 5 are operands.

    //Expressions: Prefix, Postfix, and Infix

    //1. Infix Expression
    //Definition: The operator is written between the operands.
    //Example: (A + B) * C
    //Explanation:
    //Operators appear between the operands they operate on.
    //Requires parentheses for clarity and operator precedence rules to resolve ambiguities.
    //Example Evaluation:
    //First (A + B) is evaluated, then the result is multiplied by C.


    //2. Prefix Expression (Polish Notation)
    //Definition: The operator is written before the operands.
    //Example: * + A B C
    //Explanation:
    //No need for parentheses because the order of operations is unambiguous.
    //Read the operator first, then process the operands.
    //Example Conversion (from infix): (A + B) * C → * + A B C


    //3. Postfix Expression (Reverse Polish Notation)
    //Definition: The operator is written after the operands.
    //Example: A B + C *
    //Explanation:
    //No need for parentheses; order of operations is inherently defined.
    //Evaluate from left to right, applying the operator to the two preceding operands.
    //Example Conversion (from infix): (A + B) * C → A B + C *

    public static void main(String[] args) {

    }

//--------------------------------------------------------------------------------------------------------------------


    // Infix to Postfix

// 1) Scan the infix expression from left to right.
// 2) If the scanned character is an operand, put it in the postfix expression.
// 3) Otherwise, do the following
//   > If the precedence of the current scanned operator is higher than the precedence of the operator on top of the stack, or if the stack is empty, or if the stack contains a ‘(‘, then push the current operator onto the stack.
//   > Else, pop all operators from the stack that have precedence higher than or equal to that of the current operator. After that push the current operator onto the stack.
// 4) If the scanned character is a ‘(‘, push it to the stack.
// 5) If the scanned character is a ‘)’, pop the stack and output it until a ‘(‘ is encountered, and discard both the parenthesis.
// 6) Repeat steps 2-5 until the infix expression is scanned.
// 7) Once the scanning is over, Pop the stack and add the operators in the postfix expression until it is not empty.
// 8) Finally, print the postfix expression.



    // A utility function to return
    // precedence of a given operator
    // Higher returned value means
    // higher precedence
    public static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }


    public static String infixToPostfix(String s) {
        if (s == null || s.isEmpty()) {
            return "Invalid Expression";
        }

        StringBuilder result = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                result.append(ch); // Add operands to the result
            } else if (ch == '(') {
                st.push(ch); // Push '(' to the stack
            } else if (ch == ')') {
                // Pop from stack until '(' is found
                while (!st.isEmpty() && st.peek() != '(') {
                    result.append(st.pop());
                }
                if (st.isEmpty()) {
                    return "Invalid Expression"; // Unmatched ')'
                }
                st.pop(); // Pop '(' from the stack
            } else { // Operator encountered
                while (!st.isEmpty() && Prec(ch) <= Prec(st.peek())) {
                    result.append(st.pop());
                }
                st.push(ch);
            }
        }

        // Pop all remaining operators from the stack
        while (!st.isEmpty()) {
            if (st.peek() == '(') {
                return "Invalid Expression"; // Unmatched '('
            }
            result.append(st.pop());
        }

        return result.toString();
    }


    // time complexity: O(n)


    // The time complexity of the `infixToPostfix` function can be determined by analyzing its operations step by step:
    //
    //### Key Points:
    //1. **Input Traversal**:
    //   - The function iterates over each character of the input string `s` exactly once.
    //   - This takes **O(n)** time, where `n` is the length of the string.
    //
    //2. **Stack Operations**:
    //   - Push and pop operations on the stack are performed in constant time, **O(1)**, per operation.
    //   - At most, each operator or parenthesis is pushed to or popped from the stack once, contributing at most **O(n)** in total across all stack operations.
    //
    //3. **Precedence Checking**:
    //   - The precedence function `Prec(ch)` is called during comparisons. This function runs in constant time, **O(1)**, because it uses a `switch` statement with a finite number of cases.
    //
    //4. **Output Construction**:
    //   - Each operand and operator is appended to the `result` string exactly once.
    //   - StringBuilder's `append` operation runs in amortized constant time, **O(1)**.
    //   - Therefore, the output construction also contributes **O(n)**.
    //
    //### Overall Time Complexity:
    //The function processes the input string once and performs constant-time operations for each character (stack operations, precedence checks, and string building). Thus, the total time complexity is:
    //
    //**O(n)**, where `n` is the length of the input string.
    //
    //### Edge Cases:
    //- Mismatched parentheses cause the function to return early, which does not increase the overall complexity.
    //- Empty or null strings are handled in constant time, **O(1)**.
    //
    //### Conclusion:
    //The time complexity of the `infixToPostfix` function is **O(n)**, making it efficient for converting infix expressions to postfix form.




    // space complexity: O(n)




//--------------------------------------------------------------------------------------------------------------------


    // Infix to Prefix


    //Step 1: Reverse the infix expression. Note while reversing each ‘(‘ will become ‘)’ and each ‘)’ becomes ‘(‘.

    //Step 2: Convert the reversed infix expression to “nearly” postfix expression.
    //
    //While converting to postfix expression, instead of using pop operation to pop operators with greater than or equal precedence, here we will only pop the operators from stack that have greater precedence. also special condition for ^
    //

    //Step 3: Reverse the postfix expression.




    // striver steps:
    //First, reverse the infix expression given in the problem.
    //Scan the expression from left to right.
    //Whenever the operands arrive, print them.
    //If the operator arrives and the stack is found to be empty, then simply push the operator into the stack.
    //If the incoming operator has higher precedence than the TOP of the stack, push the incoming operator into the stack.
    //If the incoming operator has the same precedence with a TOP of the stack, push the incoming operator into the stack.
    //If the incoming operator has lower precedence than the TOP of the stack, pop, and print the top of the stack. Test the incoming operator against the top of the stack again and pop the operator from the stack till it finds the operator of lower precedence or same precedence.
    //If the incoming operator has the same precedence with the top of the stack and the incoming operator is ^, then pop the top of the stack till the condition is true. If the condition is not true, push the ^ operator.
    //When we reach the end of the expression, pop, and print all the operators from the top of the stack.
    //If the operator is ')', then push it into the stack.
    //If the operator is '(', then pop all the operators from the stack till it finds the ‘)’ bracket in the stack.
    //If the top of the stack is ')', push the operator on the stack.
    //In the end, reverse the output. And print it.




    public static int Prec2(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;

            default:
                return -1; // Return -1 for non-operator characters
        }
    }

    // Function to convert an infix expression to a postfix expression.(
    //      here we just changed while (!st.isEmpty() && Prec2(ch) <= Prec2(st.peek())) to
    //      while (!st.isEmpty() && Prec2(ch) < Prec2(st.peek()))
    //      special condition =>
    //      For right-associative operators like ^, ensure that operators with the same precedence are not popped.
    // )

    public static String infixToPostfix2(String s) {
        if (s == null || s.isEmpty()) {
            return "Invalid Expression";
        }

        StringBuilder result = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                result.append(ch); // Add operands to the result
            } else if (ch == '(') {
                st.push(ch); // Push '(' to the stack
            } else if (ch == ')') {
                // Pop from stack until '(' is found
                while (!st.isEmpty() && st.peek() != '(') {
                    result.append(st.pop());
                }
                if (st.isEmpty()) {
                    return "Invalid Expression"; // Unmatched ')'
                }
                st.pop(); // Pop '(' from the stack
            } else { // Operator encountered

                if(ch == '^'){
                    while (!st.isEmpty() && Prec2(ch) <= Prec2(st.peek())) {
                        result.append(st.pop());
                    }
                }else{
                    while (!st.isEmpty() && Prec2(ch) < Prec2(st.peek())) {
                        result.append(st.pop());
                    }
                }

                st.push(ch);
            }
        }

        // Pop all remaining operators from the stack
        while (!st.isEmpty()) {
            if (st.peek() == '(') {
                return "Invalid Expression"; // Unmatched '('
            }
            result.append(st.pop());
        }

        return result.toString();
    }


    public static String reverse(String S){
        char[] char_arr = S.toCharArray();
        int start = 0;
        int end = char_arr.length - 1;
        char temp;
        while ( start < end){
            temp = char_arr[start];
            char_arr[start] = char_arr[end];
            char_arr[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(char_arr);
    }


    public static String infixToPrefix(String s) {
        String infix = reverse(s);
        char[] infixToArr = infix.toCharArray();
        int l = infixToArr.length;

        // Replace ( with ) and vice versa
        for (int i = 0; i < l; i++) {

            if (infixToArr[i] == '(') {
                infixToArr[i] = ')';
                i++;
            }
            else if (infixToArr[i] == ')') {
                infixToArr[i] = '(';
                i++;
            }

        }

        String newInfix = String.valueOf(infixToArr);

        String prefix = infixToPostfix2(newInfix);

        prefix = reverse(prefix);

        return prefix;
    }


    //// Total Time Complexity:
    //// Adding up all these steps:

    //// Reverse the string: O(n)
    //// Swap parentheses: O(n)
    //// Convert infix to postfix: O(n)
    //// Reverse the postfix string: O(n)

    //// The total time complexity is: O(n) + O(n) + O(n) + O(n) = O(n)



    //// Space Complexity
    //// Your function uses extra space for:
    //
    //// 1. Stack (st):
    ////    In the worst case, all characters could be operators and pushed onto the stack
    ////    (e.g., a + b - c * d / e).
    ////    The stack requires O(n) space in the worst case.
    //
    //// 2. String Builders (result and prefix):
    ////    These accumulate the postfix and prefix strings, requiring O(n) space.
    //
    //// 3. Reversed String:
    ////    The reversed string also takes O(n) space.
    //
    //// Thus, the total auxiliary space is:
    //// O(n) + O(n) + O(n) = O(n)



//--------------------------------------------------------------------------------------------------------------------


    // Postfix to Infix conversion

//1.While there are input symbol left
//…1.1 Read the next symbol from the input.
//2.If the symbol is an operand
//…2.1 Push it onto the stack.
//3.Otherwise,
//…3.1 the symbol is an operator.
//…3.2 Pop the top 2 values from the stack.
//…3.3 Put the operator, with the values as arguments and form a string.
//…3.4 Push the resulted string back to stack.
//4.If there is only one value in the stack
//…4.1 That value in the stack is the desired infix string.



    static String postToInfix(String exp) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < exp.length(); i++){
            if(Character.isLetterOrDigit(exp.charAt(i))){
                st.push(exp.charAt(i) + "");
            }else{
                String op1 = st.peek();
                st.pop();
                String op2 = st.peek();
                st.pop();
                st.push("(" + op2 + exp.charAt(i) + op1 + ")");
            }
        }

        return st.peek();
    }


    //Time Complexity: O(N) where N is the length of the string
    //
    //Auxiliary Space: O(N) where N is the stack size.




//--------------------------------------------------------------------------------------------------------------------

    // Prefix to infix conversion

//    Read the Prefix expression in reverse order (from right to left)
//    If the symbol is an operand, then push it onto the Stack
//    If the symbol is an operator, then pop two operands from the Stack
//    Create a string by concatenating the two operands and the operator between them.
//            string = (operand1 + operator + operand2)
//    And push the resultant string back to Stack
//    Repeat the above steps until the end of Prefix expression.
//    At the end stack will have only 1 string i.e resultant string


    static String preToInfix(String pre_exp) {
        Stack<String> st = new Stack<>();

        for (int i = pre_exp.length() - 1; i >= 0; i--){
            if(Character.isLetterOrDigit(pre_exp.charAt(i))){
                st.push(pre_exp.charAt(i) + "");
            }else{
                String op1 = st.peek();
                st.pop();
                String op2 = st.peek();
                st.pop();
                st.push("(" + op1 + pre_exp.charAt(i) + op2 + ")");
            }
        }

        return st.peek();
    }


//
    //Time Complexity: O(N) where N is the length of the string
    //
    //Auxiliary Space: O(N) where N is the stack size.




//--------------------------------------------------------------------------------------------------------------------

    // Postfix to Prefix

//Read the Postfix expression from left to right
//If the symbol is an operand, then push it onto the Stack
//If the symbol is an operator, then pop two operands from the Stack
//Create a string by concatenating the two operands and the operator before them.
//string = operator + operand2 + operand1
//And push the resultant string back to Stack
//Repeat the above steps until end of Postfix expression.

    static String postToPre(String post_exp) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < post_exp.length(); i++){
            if(Character.isLetterOrDigit(post_exp.charAt(i))){
                st.push(post_exp.charAt(i) + "");
            }else{
                String op1 = st.peek();
                st.pop();
                String op2 = st.peek();
                st.pop();
                st.push( post_exp.charAt(i) + op2 + op1 );
            }
        }

        return st.peek();
    }

    //Time Complexity: O(N) where N is the length of the string
    //
    //Auxiliary Space: O(N) where N is the stack size.

//--------------------------------------------------------------------------------------------------------------------


    // Prefix to Postfix

    //Read the Prefix expression in reverse order (from right to left)
    //If the symbol is an operand, then push it onto the Stack
    //If the symbol is an operator, then pop two operands from the Stack
    //Create a string by concatenating the two operands and the operator after them.
    //string = operand1 + operand2 + operator
    //And push the resultant string back to Stack
    //Repeat the above steps until end of Prefix expression.


    static String preToPost(String pre_exp) {
        Stack<String> st = new Stack<>();

        for (int i = pre_exp.length() - 1; i >= 0; i--){
            if(Character.isLetterOrDigit(pre_exp.charAt(i))){
                st.push(pre_exp.charAt(i) + "");
            }else{
                String op1 = st.peek();
                st.pop();
                String op2 = st.peek();
                st.pop();
                st.push(  op1 + op2 + pre_exp.charAt(i));
            }
        }

        return st.peek();
    }

    //Time Complexity: O(N) where N is the length of the string
    //
    //Auxiliary Space: O(N) where N is the stack size.



}
