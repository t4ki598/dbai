package exer;

import java.util.HashSet;

/**
 * 类 描 述：给定一个非空整数数组，除了某个元素只出现一次以外，
 *          其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 创建时间：2020-03-31 20:44
 * 创 建 人：t4ki
 */
public class QuerySingle {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        QuerySingle t = new QuerySingle();
        System.out.println(t.singleNumber(nums));
        System.out.println(t.singleNumber2(nums));
    }


    //方法一：使用hashset
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        //这样最后的set就只包含这个不重复的元素了
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }

        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                res = nums[i];
                break;
            }
        }
        return res;
    }

    //方法二：异或
    public int singleNumber2(int[] nums) {
        int ans = 0;
        for (int x : nums){
            ans ^= x;
        }
        return ans;
    }
}
