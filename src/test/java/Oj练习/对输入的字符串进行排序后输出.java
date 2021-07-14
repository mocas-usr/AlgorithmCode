package Oj练习;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/2 下午8:26
 * @email: wangyuhang_mocas@163.com
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-02 20:26
 */
public class 对输入的字符串进行排序后输出 {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input=br.readLine())!=null)
        {
            String[] str=input.trim().split(" ");
            Arrays.sort(str);

            for (String s:str)
            {
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }
}
