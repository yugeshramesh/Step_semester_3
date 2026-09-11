import java.util.HashMap;
import java.util.Map;

public class A4_SubarraySumEqualsK {

    // Computes total number of contiguous subarrays summing to k using prefix sums & HashMap
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        // Base case: prefix sum of 0 has occurred once (empty prefix)
        prefixSumCounts.put(0, 1);

        int runningSum = 0;
        int count = 0;

        for (int num : nums) {
            runningSum += num;

            // If (runningSum - k) exists in map, add its frequency
            if (prefixSumCounts.containsKey(runningSum - k)) {
                count += prefixSumCounts.get(runningSum - k);
            }

            // Record current runningSum in map
            prefixSumCounts.put(runningSum, prefixSumCounts.getOrDefault(runningSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println(subarraySum(nums1, k1)); // Output: 2

        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        System.out.println(subarraySum(nums2, k2)); // Output: 3
    }
}
