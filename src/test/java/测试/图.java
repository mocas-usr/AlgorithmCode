package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/17 15:36
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-17 15:36
 */
public class 图 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        int n = Integer.parseInt(s);
        //dp[i]代表i的节点
        int[] dp=new int[n+1];
        dp[1]=0;
        for(int i=2;i<n;i++){
            for(int j=i-1;j>=1;j--){
                if (i%j==0)
                {
                    dp[i]+=dp[j]+1;
                }
            }
        }
        int sum=0;
        for (int num:dp)
        {
            sum+=num;
        }
        System.out.println(sum);
    }

    @Test
    public void test()
    {
        Integer i1=200;
        int i2=200;
        System.out.println(i2==i1);
    }


}
