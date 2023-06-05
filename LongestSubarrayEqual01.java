import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class LongestSubarrayEqual01 {
    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        int count = 0;
        
        // Create a map to store the count and its corresponding index
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, -1); // Initialize the map with count 0 at index -1
        
        for (int i = 0; i < nums.length; i++) {
            // Increment the count if the current number is 1
            // Decrement the count if the current number is 0
            count += nums[i] == 1 ? 1 : -1;
            
            // If the count is already present in the map, calculate the length
            // of the subarray by subtracting the current index with the stored index
            if (countMap.containsKey(count)) {
                int subarrayLength = i - countMap.get(count);
                maxLength = Math.max(maxLength, subarrayLength);
            } else {
                // If the count is not present in the map, store the count and its index
                countMap.put(count, i);
            }
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input numbers:");
        int[] nums = new int[2];
        for(int i=0;i<2;i++){
            nums[i] = sc.nextInt();
        }
        int maxLength = findMaxLength(nums);
        System.out.println("Length of the longest contiguous subarray with an equal number of 0s and 1s: " + maxLength);
    }
}
