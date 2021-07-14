package Oj练习;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/2 下午8:01
 * @email: wangyuhang_mocas@163.com
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-02 20:01
 */
public class 输入数据有多组每行表示一组输入数据 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input;
        while ((input=sc.nextLine()) != null) {
            String[] str = input.trim().split(" ");

            int[] nums = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                nums[i] = Integer.valueOf(str[i]);
            }
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            System.out.println(sum);
        }
    }
}
