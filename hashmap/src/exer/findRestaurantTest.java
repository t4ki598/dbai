package exer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类 描 述：假设Andy和Doris想在晚餐时选择一家餐厅，
 *          并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 *          你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。
 *          如果答案不止一个，则输出所有答案并且不考虑顺序。
 *          你可以假设总是存在一个答案。
 * 创建时间：2020-04-02 10:32
 * 创 建 人：t4ki
 */
public class findRestaurantTest {
    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

        findRestaurantTest t = new findRestaurantTest();
        String[] res = t.findRestaurantTest(list1, list2);
        for (String s : res) {
            System.out.println(s);
        }


    }

    public String[] findRestaurantTest(String[] list1, String[] list2) {
        Map<String, Integer> hashMap = new HashMap<>();
        int min_idx_sum = 2000;    //1000 + 1000
        List<String> list = new ArrayList<>();

        //1.先把list1中的元素存入到map集合中，key为元素值，value为元素下标
        for (int i = 0; i < list1.length; i++) {
            hashMap.put(list1[i], i);
        }

        //2.遍历list2，看hashMap中是否有对应的元素
        for (int j = 0; j < list2.length; j++) {
            if (hashMap.containsKey(list2[j])) {
                //判断元素下标之和是否小于等于当前的最小值
                if ((hashMap.get(list2[j]) + j) < min_idx_sum) {  //如果小于
                    list.clear();       //清除之前保存的值
                    list.add(list2[j]);         //添加新的值
                    min_idx_sum = hashMap.get(list2[j]) + j;    //更新min_idx_sum的值
                } else if ((hashMap.get(list2[j]) + j) == min_idx_sum) {   //如果等于
                    list.add(list2[j]);         //直接添加新的值
                }
            }
        }

        //3.将list集合转换为String数组
        String[] res = new String[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }

        return res;
    }
}
