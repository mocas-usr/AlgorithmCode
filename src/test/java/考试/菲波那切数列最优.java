package 考试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/8/6 16:15
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Scanner;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-08-06 16:15
 */
public class 菲波那切数列最优 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

    }
    public int fib(int n,int pre,int cur)
    {
        if (n==0)
        {
            return 1;
        }
        if (n==1)
        {
            return 1;
        }

        return fib(n,cur,cur+pre);

    }
}
