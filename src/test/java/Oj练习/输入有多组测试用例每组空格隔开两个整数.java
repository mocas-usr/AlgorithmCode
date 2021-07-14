package Oj练习;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/2 下午8:37
 * @email: wangyuhang_mocas@163.com
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-02 20:37
 */
public class 输入有多组测试用例每组空格隔开两个整数 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            String[] str=input.trim().split(" ");
            int a=Integer.valueOf(str[0]);
            int b=Integer.valueOf(str[1]);
            System.out.println(a+b);
        }
    }
}
