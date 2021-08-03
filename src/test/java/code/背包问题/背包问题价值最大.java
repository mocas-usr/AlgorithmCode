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

/*

1、0/1背包问题：每个元素最多选取一次
2、完全背包问题：每个元素可以重复选择
3、组合背包问题：背包中的物品要考虑顺序
4、分组背包问题：不止一个背包，需要遍历每个背包

1、0/1背包：外循环nums,内循环target,target倒序且target>=nums[i];
2、完全背包：外循环nums,内循环target,target正序且target>=nums[i];
3、组合背包(考虑顺序)：外循环target,内循环nums,target正序且target>=nums[i];
4、分组背包：这个比较特殊，需要三重循环：外循环背包bags,内部两层循环根据题目的要求转化为1,2,3三种背包类型的模板


https://leetcode-cn.com/problems/coin-change/solution/yi-pian-wen-zhang-chi-tou-bei-bao-wen-ti-sq9n/
*/

public class 背包问题价值最大 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        while (sc.hasNext())
        {
            //背包个数
            int n=sc.nextInt();
            //容量
            int m=sc.nextInt();
            int[] w=new int[n];
            int[] v=new int[n];
            //输入
            for (int i=0;i<n;i++)
            {
                //重量
                w[i]=sc.nextInt();
            }
            for (int j=0;j<n;j++)
            {
                //价值
                v[j]=sc.nextInt();
            }
            //dp[i]代表i容量的最大数值
            int[] dp=new int[m];
            dp[0]=0;
            for (int i=0;i<n;i++)
            {
                int weight=w[i];
                int val=v[i];

                for (int j=m;j>=weight;j--)
                {
                    //分为两种情况，
                    //一是当前物品加入dp[j-w]+v，二是当前物品不加入dp[j]
                    dp[j]=Math.max(dp[j],dp[j-weight]+val);
                }
            }
            System.out.println(dp[m]);

        }
    }
}
