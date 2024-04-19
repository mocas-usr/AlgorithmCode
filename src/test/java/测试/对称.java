package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/17 15:46
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-17 15:46
 */
public class 对称 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while (sc.hasNextLine())
        {
            String[] str1=sc.nextLine().trim().split(" ");
            int m=Integer.parseInt(str1[0]);
            int n=Integer.parseInt(str1[1]);

            int[][] nums=new int[m][n];
            for (int i=0;i<m;i++)
            {
                String str=sc.nextLine().trim();
                for (int j=0;j<n;j++)
                {
                    nums[i][j]=str.charAt(j)-'0';
                }
            }
//            ConcurrentHashMap


        }
    }
}
