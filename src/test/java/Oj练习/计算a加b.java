package Oj练习;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/2 下午7:41
 * @email: wangyuhang_mocas@163.com
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-02 19:41
 */
public class 计算a加b {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String input;
        //按行读取
        while ((input=br.readLine())!=null)
        {
            String[] inputArr=input.trim().split(" ");
            int a=Integer.valueOf(inputArr[0]);
            int b=Integer.valueOf(inputArr[1]);
            System.out.println(a+b);
        }
    }
}
