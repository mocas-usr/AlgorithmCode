package Oj练习;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/2 下午9:27
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-02 21:27
 */
public class 字符串排序3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine())
        {
            String[] str=sc.nextLine().trim().split(",");
            Arrays.sort(str);
            for (int i=0;i<str.length;i++)
            {
                if (i==str.length-1)
                {
                    System.out.println(str[i]);

                }else
                {
                    System.out.print(str[i]+",");

                }
            }

        }
    }
}
