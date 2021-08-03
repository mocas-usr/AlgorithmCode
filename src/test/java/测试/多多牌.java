package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/25 下午8:35
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Scanner;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-25 20:35
 */
public class 多多牌 {
    public static void Main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int q = sc.nextInt();

            if(a == q)
                System.out.println(1);
            else if((q - a) / b * b == (q - a))
                System.out.println(1);
            else if((q - a) / c * c == (q - a))
                System.out.println(1);
            else if((q - a) / (c + b) * (b + c) == (q - a))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

}
