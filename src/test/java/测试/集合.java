package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/30 下午7:33
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Scanner;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-30 19:33
 */
public class 集合 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] save = new int[30000];
        save[7] = 1;
        for (int i = 8; i < save.length; i++) {
            if (String.valueOf(i).contains("7") && i % 7 == 0) {
                save[i] = save[i - 1] + 1;
            } else if (i % 7 == 0) {
                save[i] = save[i - 1] + 1;
            } else if (String.valueOf(i).contains("7")) {
                save[i] = save[i - 1] + 1;
            }else {
                save[i] = save[i - 1];
            }
        }

        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(save[n]);

        }
    }

}
