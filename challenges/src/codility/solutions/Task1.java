package codility.solutions;

public class Task1 {
    public static int solution(int N) {
        int maxGap = 0;
        int currentGap = 0;
        boolean counting = false;

        while (N > 0) {
            if ((N & 1) == 1) {
                // Found a 1
                if (counting) {
                    // End of a gap
                    maxGap = Math.max(maxGap, currentGap);
                }
                // Start counting from next zero
                counting = true;
                currentGap = 0;
            } else {
                // Found a 0
                if (counting) {
                    currentGap++;
                }
            }
            N >>= 1; // Shift bits to the right
        }

        return maxGap;
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(solution(1041)); // Output: 5
        System.out.println(solution(32));   // Output: 0
        System.out.println(solution(529));  // Output: 4
    }
}
