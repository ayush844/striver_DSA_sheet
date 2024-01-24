import java.util.Stack;

public class learningStack {

    public static void main(String[] args) {
        Stack<String> animals = new Stack<>();

        animals.push("Lion");
        animals.push("Dog");
        animals.push("Horse");
        animals.push("cat");

        System.out.println("Stack: " + animals); // Stack: [Lion, Dog, Horse, cat]

        System.out.println(animals.peek()); // cat

        animals.pop();
        System.out.println("Stack: " + animals); // Stack: [Lion, Dog, Horse]


        

    }

}
