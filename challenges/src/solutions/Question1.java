package solutions;

import java.util.Scanner;
import java.util.Stack;

public class Question1 {
    public static void main(String[] args) {
        System.out.println("Enter Input String");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String result = decompress(input);
        System.out.println("Decompressed string: " + result);
    }

    public static String decompress(String s) {
        // Stack to keep track of numbers and partial strings
        Stack<String> stack = new Stack<>();
        // This will store the current string being formed
        StringBuilder currentString = new StringBuilder();
        // This will store the current multiplier (number of repetitions)
        int currentNum = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // If the character is a digit, update the current number
                currentNum = currentNum * 10 + (ch - '0');
            }else if (ch == '[') {
                // When we encounter '[', push current string and current number to stack
                stack.push(currentString.toString());
                stack.push(Integer.toString(currentNum));
                // Reset the current string and current number
                currentString.setLength(0);
                currentNum = 0;
            } else if (ch == ']') {
                // When we encounter ']', pop the number and string from the stack
                int repeatTimes = Integer.parseInt(stack.pop());
                String prevString = stack.pop();
                // Repeat the current string and append it to the previous string
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currentString);
                }
                currentString = new StringBuilder(prevString).append(temp);
            } else {
                // If it's a letter, just add it to the current string
                currentString.append(ch);
            }
        }
        // The final result is in currentString
        return currentString.toString();
    }
}
