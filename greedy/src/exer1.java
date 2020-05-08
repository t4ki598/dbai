import java.util.Arrays;
import java.util.Scanner;

/**
 * 类 描 述：TODO
 * 创建时间：2020-04-15 16:01
 * 创 建 人：t4ki
 */
public class exer1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入果子的种类数:");
        int n = scanner.nextInt();
        int[] m = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("请输入第" + (i + 1) + "个果子的数目：");
            m[i] = scanner.nextInt();
        }

    }
    
    public void test(int[] arr, int n){
        int strength = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            arr[i + 1] += arr[i];
            strength += arr[i + 1];

        }
    }
}
