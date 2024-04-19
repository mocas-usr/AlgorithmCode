package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/25 19:04
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-25 19:04
 */
public class 线段 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            //线段数量
            int n = sc.nextInt();
            //线段
            int[][] nums = new int[n][2];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < 2; j++) {
                    nums[i][j] = sc.nextInt();
                }
            //排列线段
            Arrays.sort(nums, (x1, x2) -> x1[0] - x2[0]);
            //头部已经实现顺序
            boolean res=false;
            for (int i=0;i<nums.length;i++)
            {
                int left=nums[i][0];
                int right=nums[i][1];
                for (int j=i+1;j<nums.length;j++)
                {
                    if (nums[j][1]<=right)
                    {
                        res=true;
                        break;
                    }
                }
            }
            System.out.println(res);

        }
    }
}
