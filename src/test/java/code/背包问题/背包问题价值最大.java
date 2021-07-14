package code.背包问题;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 下午8:59
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Scanner;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-17 20:59
 */
public class 背包问题价值最大 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        while (sc.hasNext())
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[] w=new int[n];
            int[] v=new int[n];
            //输入
            for (int i=0;i<n;i++)
            {
                w[i]=sc.nextInt();
            }
            for (int j=0;j<n;j++)
            {
                v[j]=sc.nextInt();
            }

            int[] dp=new int[m+1];
            //物品
            for (int i=0;i<n;i++) {
                int weight=w[i];
                int value=v[i];
                //容量
                for (int j=m;j>=weight;j--)
                {
                    dp[j]=Math.max(dp[j],dp[j-weight]+v[i]);
                }
            }
            System.out.println(dp[m]);

        }
    }
}
