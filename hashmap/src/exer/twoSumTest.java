package exer;

import java.util.HashMap;

/**
 * 类 描 述：给定一个整数数组 nums 和一个目标值 target，
 *          请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *          你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 创建时间：2020-03-31 21:43
 * 创 建 人：t4ki
 */
public class twoSumTest {
    public static void main(String[] args) {
        int target = 9;
        int[] nums = {2, 15, 11, 7};
        twoSumTest t = new twoSumTest();
        int[] a = t.twoSum(nums, target);
        for(int x : a){
            System.out.print(x);
        }


    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(map.containsKey(temp) && map.get(temp) != i){
                return new int[]{i, map.get(temp)};

            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
