/**
 * 项目名称：DBAl
 * 类 名 称：hannuota
 * 类 描 述：
 *  汉诺塔问题：
 *      abc三个桌子，a有64个盘子，盘子大小不等，大的在下小的在上，
 *      每次只能移动一个盘子
 *      移动过程保持大的在下小的在上，一次只能移动一个盘子
 *      输出移动的步骤
 * 创建时间：2020-03-21 17:06
 * 创 建 人：t4ki
 */
public class hannuota {
    void hanoi(int n, char src, char mid, char desk){
        if(n == 1){
            System.out.println(src + "->" + desk);
            return;
        }
        hanoi(n - 1, src, desk, mid);
        System.out.println(src + "->" + desk);
        hanoi(n -1, mid, src, desk);
        return;
    }

    public static void main(String[] args) {
        hannuota h = new hannuota();
        h.hanoi(4, 'a', 'b', 'c');
    }
}
