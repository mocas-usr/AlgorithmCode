package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/21 下午7:18
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Map;
import java.util.Scanner;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-21 19:18
 */
public class 出租车 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String[] str1 = sc.nextLine().trim().split(" ");
            int n = Integer.parseInt(str1[0]);
            int k = Integer.parseInt(str1[1]);
            int[][] arr = new int[k][3];
            for (int i = 0; i < k; i++) {
                String[] str = sc.nextLine().trim().split(" ");
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            }

            int res = 0;

            //所有时间
            int[] times = new int[n * 5];
            int[][] nums = new int[k][2];
            //先计算上车的
            for (int i = 0; i < k; i++) {
                int start = arr[i][1];
                int end = arr[i][2];
                if (end - start > n/2) {
                    //逆时针
                    nums[0]=arr[0];
//                    nums[1]=arr
                }else
                {

                }
            }


        }
    }
}
