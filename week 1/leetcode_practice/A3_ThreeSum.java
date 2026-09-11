import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A3_ThreeSum {

    // Finds all unique triplets summing to 0 in O(n^2) time
    public static int[][] threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new int[0][0];
        }

        Arrays.sort(nums);
        List<int[]> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    resultList.add(new int[]{nums[i], nums[left], nums[right]});

                    // Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return resultList.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[][] res1 = threeSum(nums1);
        System.out.println(Arrays.deepToString(res1)); // [[-1, -1, 2], [-1, 0, 1]]

        int[] nums2 = {0, 0, 0};
        int[][] res2 = threeSum(nums2);
        System.out.println(Arrays.deepToString(res2)); // [[0, 0, 0]]
    }
}
