package Oj练习;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/2 下午7:51
 * @email: wangyuhang_mocas@163.com
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-02 19:51
 */
public class 计算一系列数的和 {
    public static void main(String[] args) throws IOException {
        //br读取
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr;

        while ((inputStr = br.readLine()) != null) {
            //分割
            String[] str = inputStr.trim().split(" ");
            int n = Integer.valueOf(str[0]);
            if (n==0)
            {
                break;
            }
            int sum = 0;
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.valueOf(str[i + 1]);
            }
            for (int num:nums)
            {
                sum+=num;
            }
            System.out.println(sum);
        }
    }
}
