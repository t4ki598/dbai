package dfs;

import java.util.Scanner;

/**
 * 类 描 述：求n个数的排列
 * 创建时间：2020-04-29 11:14
 * 创 建 人：t4ki
 */
public class sortNum {
    static int N = 10;
    static int n;
    static boolean status[] = new boolean[N];
    static int path[] = new int[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入数字：");
        n = in.nextInt();
        dfs(0);
    }

    public static void dfs(int level){
        if(level == n){
            for (int i = 0; i < n; i++) {
                System.out.print(path[i]);
            }
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            if(!status[i]){
                path[level] = i;
                status[i] = true;
                dfs(level + 1);
                status[i] = false;
            }
        }
    }
}
