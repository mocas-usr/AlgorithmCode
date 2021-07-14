package Oj练习;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/2 下午9:14
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Scanner;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-02 21:14
 */
public class ab4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n=sc.nextInt();
            int sum=0;

            for (int i=0;i<n;i++)
            {
                sum+=sc.nextInt();
            }
            System.out.println(sum);
        }
    }
}
