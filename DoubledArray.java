import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class DoubledArray {
    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            // If the length of the changed array is odd, it can't be a doubled array
            return new int[0]; // Return an empty array
        }
        
        Arrays.sort(changed); // Sort the changed array in ascending order
        
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : changed) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1); // Count the occurrences of each number
        }
        
        List<Integer> originalList = new ArrayList<>();
        for (int num : changed) {
            if (countMap.getOrDefault(num, 0) == 0) {
                // If the current number has already been used, skip it
                continue;
            }
            
            int doubleValue = num * 2;
            if (countMap.getOrDefault(doubleValue, 0) == 0) {
                // If the double value of the current number is not found, the changed array is not a doubled array
                return new int[0]; // Return an empty array
            }
            
            // Add the original number to the list
            originalList.add(num);
            
            // Decrement the counts of the current number and its double value
            countMap.put(num, countMap.get(num) - 1);
            countMap.put(doubleValue, countMap.get(doubleValue) - 1);
        }
        
        int[] original = new int[originalList.size()];
        for (int i = 0; i < originalList.size(); i++) {
            original[i] = originalList.get(i);
        }
        
        return original;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array:");
        int size = sc.nextInt();
        System.out.println("Enter the array elements:");
        int[] changed = new int[size];
        for(int i=0;i<size;i++){
            changed[i] = sc.nextInt();
        }
        int[] original = findOriginalArray(changed);
        
        System.out.println("Original array:");
        if (original.length == 0) {
            System.out.println("Empty array");
        } else {
            System.out.println(Arrays.toString(original));
        }
    }
}
