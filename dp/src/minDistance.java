import java.util.Scanner;

/**
 * 类 描 述：求一个方阵从左上到右下的最短路径。不超过2n-1。
 * 方阵为：
 * 1 4 6 8 10
 * 2 5 7 15 17
 * 6 8 9 18 20
 * 10 11 12 19 21
 * 20 23 25 29 33
 * 最短路径为： 109 = 1 + 2 + 5 + 7 + 9 + 12 + 19 + 21 + 33
 * 创建时间：2020-04-28 16:41
 * 创 建 人：t4ki
 */
public class minDistance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一个方阵大小n：");

        int n = scanner.nextInt();
        int[][] w = new int[n][n];

        System.out.println("请输入元素：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j] = scanner.nextInt();
            }
        }

        System.out.println("方阵为：");
        show(w);
        System.out.println("最短路径为：");
        System.out.println(queryMinDistance(w, n));

    }

    public static void show(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int queryMinDistance(int[][] w, int n){
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //特判左上角
                if(i == 0 && j == 0){
                    f[i][j] = w[i][j];
                } else {
                    f[i][j] = Integer.MAX_VALUE;
                    //只有不在第一行，才可以从上面下来
                    if(i > 0) f[i][j] = Math.min(f[i][j], f[i - 1][j] + w[i][j]);
                    //只有不在第一列，才可以从左边过来
                    if(j > 0) f[i][j] = Math.min(f[i][j], f[i][j - 1] + w[i][j]);
                    f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]);
                }
            }

        }
        return f[n - 1][n - 1];
    }
}
