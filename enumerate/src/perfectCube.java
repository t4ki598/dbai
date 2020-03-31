/**
 * 项目名称：DBAl
 * 类 名 称：perfectCube
 * 类 描 述：完美立方
 * 创建时间：2020-03-19 21:26
 * 创 建 人：t4ki
 */
public class perfectCube {
    public static void main(String[] args) {
        int a, b, c, d;
        for (a = 2; a < 100; a++) {
            for (b = 2; b < a; b++) {
                for (c = b; c < a; c ++){
                    for (d = c; d < a; d++){
                        if (a * a * a == b * b * b + c * c * c + d * d * d){
                            System.out.println("Cube: " + a + " , Triple: (" + b
                                    + ", " + c + ", " + d + ")");
                        }
                    }
                }
            }
        }
    }
}
