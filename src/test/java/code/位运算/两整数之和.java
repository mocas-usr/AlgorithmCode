package code.位运算;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/15 下午7:15
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-15 19:15
 */
public class 两整数之和 {
      public int getSum(int a, int b) {

          int temp=0;
          while (b!=0)
          {
              //先求不进位数值
              int bujin=a^b;
              int jin=(a&b);
              b=jin<<1;//进位移动
              a=bujin;

          }
          return a;

    }
}
