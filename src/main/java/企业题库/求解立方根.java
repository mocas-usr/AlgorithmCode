package 企业题库;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/14 下午3:32
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Scanner;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-14 15:32
 */
public class 求解立方根 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext())
        {
            double num=sc.nextDouble();
            double res=getResult(num);
            System.out.printf("%1.f\n",res);
        }



    }

    // 使用二分查找算法
    public static double getResult(double input)
    {
        double min = 0;
        double max = input;
        double mid = 0;

        // 注意，这里的精度要提高一点，否则某些测试用例无法通过
        while ((max - min) > 0.001)
        {
            mid = (max + min) / 2;
            if (mid * mid * mid > input)
                max = mid;
            else if (mid * mid * mid < input)
                min = mid;
            else
                return mid;
        }
        return max;
    }
}
