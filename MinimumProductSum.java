import java.util.Arrays;
import java.util.Scanner;

public class MinimumProductSum {
    public static int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); // Sort nums1 in ascending order
        Arrays.sort(nums2); // Sort nums2 in ascending order
        
        int n = nums1.length;
        int minSum = 0;
        
        for (int i = 0; i < n; i++) {
            minSum += nums1[i] * nums2[n - i - 1]; // Calculate the product sum
        }
        
        return minSum;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size:");
        int size = sc.nextInt();
        System.out.println("enter the array elements:");
        int[] nums1 = new int[size];
        for(int i=0;i<size;i++){
            nums1[i] = sc.nextInt();
        }
        System.out.println("enter the second array elements:");
        int[] nums2 = new int[size];
        for(int i=0;i<size;i++){
            nums2[i] = sc.nextInt();
        }
        
        int minProductSum = minProductSum(nums1, nums2);
        System.out.println("Minimum product sum: " + minProductSum);
    }
}
