package knowledge;

import java.util.HashMap;

/**
 * 类 描 述：测试哈希map接口常用的方法
 * 创建时间：2020-03-31 17:15
 * 创 建 人：t4ki
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        HashMap<Integer, String> map2 = new HashMap<Integer, String>();

        //添加
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        //获取
        System.out.println(map.get(2));

        //是否包含键为1对应的键值对
        System.out.println(map.containsKey(1));

        //是否包含值为"three"对应的键值对
        System.out.println(map.containsValue("three"));

        //map的大小
        System.out.println(map.size());

        //map是否为空
        System.out.println(map.isEmpty());

        map2.put(4, "四");
        map2.put(5, "五");

        //将另外一张map添加进来
        map.putAll(map2);


        System.out.println(map);


    }
}
