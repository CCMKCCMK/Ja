//input an algorithm like 1+2+3 and output 12+3+, using stack
import java.util.Stack;
import java.util.*;
public class alg {
    static boolean isMultiBalanced(String input) {
        Stack<Character> s = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                s.push(c);
            }
            else if (c == ')') {
                if (s.isEmpty()) {
                    return false;
                }
                else {
                    s.pop();
                }
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        // input an algorithm like 1+2+3 and output 12+3+,input an algorithm like 1+(2+3) and output 123++, using stack
        // create a stack
        Stack<Character> sign = new Stack<Character>();
        Stack<Character> middle = new Stack<Character>();
        Stack<Integer> output = new Stack<Integer>();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        //System.out.println(input);

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' || c == ')') {
                c = sign.pop();
                middle.push(c);
                
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                sign.push(c);
            }
            else {
                middle.push(c);
            }
        }

        
    }
}
