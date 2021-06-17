package 企业题库;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/14 下午3:08
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Scanner;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-14 15:08
 */
public class 求最小公倍数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a % b == 0 || b % a == 0) {
            System.out.println(Math.max(a, b));
        } else {
            int max = Math.max(a, b);
            int min = Math.min(a, b);
            int i=2;
            while (true) {
                int temp=min*i;
                if (temp%max==0)
                {
                    System.out.println(temp);
                    break;
                }
                i++;
            }
        }



    }
}
