import java.util.*;

public class PermutationReconstruction {
    public static int[] reconstructPermutation(String s) {
        int n = s.length();
        int[] perm = new int[n + 1];
        
        // Initialize the permutation with the numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            perm[i] = i;
        }
        
        int start = 0;
        int end = 0;
        
        // Iterate through the string
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                // If the character is 'I', reverse the subarray from start to end
                reverse(perm, start, end);
                end++;
            } else if (s.charAt(i) == 'D') {
                // If the character is 'D', update the end index
                end++;
            }
        }
        
        // Reverse the last subarray if necessary
        reverse(perm, start, end);
        
        return perm;
    }
    
    // Helper method to reverse a subarray in-place
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string:");
        String s = sc.nextLine();
        int[] perm = reconstructPermutation(s);
        
        System.out.println(Arrays.toString(perm));
    }
}
