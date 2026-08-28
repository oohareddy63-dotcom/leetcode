import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        findSubsets(nums, 0, new ArrayList<>(), result);

        return result;
    }

    void findSubsets(int[] nums, int i,
                     List<Integer> current,
                     List<List<Integer>> result) {

        if (i == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // YES choice
        current.add(nums[i]);
        findSubsets(nums, i + 1, current, result);

        // Backtrack
        current.remove(current.size() - 1);

        // Skip duplicates
        while (i + 1 < nums.length &&
               nums[i] == nums[i + 1]) {
            i++;
        }

        // NO choice
        findSubsets(nums, i + 1, current, result);
    }
}