package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/8 上午11:43
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-08 11:43
 */
public class 整数中1出现的次数 {

    public int countDigitOne(int n) {
        int digit = 1;

        int cur = n % 10;
        int low = 0;
        int high= n / 10;
        int res=0;
        int count=0;
        while (high != 0 || cur != 0) {

            if (cur==0)
            {
                res+=high*digit;
            }
            else if (cur==1)
            {
               res+=(high*digit)+low+1;
            }else if (cur>1)
            {
                res+=(high+1)*digit;
            }
            low+=cur*digit;
            cur=high%10;
            high=high/10;
            digit=digit*10;


        }
        return res;

    }
}
