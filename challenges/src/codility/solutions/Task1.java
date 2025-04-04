package codility.solutions;

import java.util.*;

public class Task1 {
    int solution(int n) {
        int count = 0;
        List<Integer> gapList = new ArrayList<>();
        int remainder;
      //  int binaryNumber = convertToBinary(n);


        Stack<Integer> stack = new Stack<>();
        while (n != 0){
            remainder = n % 2;
            stack.push(remainder);
            n /= 2;
        }
     //   System.out.println(stack);

        while (!stack.isEmpty()){
            int popped = stack.pop();
            if (popped == 1) {
                gapList.add(count);
                count = 0;
            }else {
                count = count + 1;
            }
        }
        return  Collections.max(gapList);
    }

/*    private int convertToBinary(int decimalNumber) {
        int remainder, i = 1, binaryNumber = 0;
        while (decimalNumber != 0) {
            remainder = decimalNumber % 2;
            decimalNumber = decimalNumber / 2;
            binaryNumber += remainder * i;
            i *= 10;
        }
        return binaryNumber;
    }*/

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int n = scanner.nextInt();
        System.out.println(task1.solution(n));
    }

}
