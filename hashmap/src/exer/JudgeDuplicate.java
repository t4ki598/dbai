package exer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 类 描 述：给定一个整数数组，判断是否存在重复元素。
 *          如果任何值在数组中出现至少两次，函数返回 true。
 *          如果数组中每个元素都不相同，则返回 false。
 * 创建时间：2020-03-31 20:21
 * 创 建 人：t4ki
 */
public class JudgeDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        JudgeDuplicate test = new JudgeDuplicate();
        System.out.println(test.containsDuplicate(nums));
        System.out.println(test.containsDuplicate2(nums));
    }

    //哈希表
    public boolean containsDuplicate(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0 ; i < nums.length; i++){
            if(map.containsValue(nums[i])){
                return true;
            }
            map.put(i, nums[i]);
        }
        return false;
    }

    //哈希集合
    public boolean containsDuplicate2(int[] nums){
        HashSet<Integer> set = new HashSet<>(nums.length);
        for(int x : nums){
            if (set.contains(x)){
                return true;
            }
            set.add(x);
        }
        return false;
    }
}
