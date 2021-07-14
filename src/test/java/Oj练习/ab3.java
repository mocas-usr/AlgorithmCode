package Oj练习;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/2 下午9:11
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Scanner;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-02 21:11
 */
public class ab3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while (sc.hasNext())
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            if (a==0 && b==0)
            {
                break;
            }
            System.out.println(a+b);
        }
    }
}
