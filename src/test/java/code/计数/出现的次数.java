package code.计数;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/15 上午10:59
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-15 10:59
 */
public class 出现的次数 {

    public int numberOf2sInRange(int n) {

        //初始化
        int low = 0;
        int cur = n % 10;
        int high = n / 10;
        int digit=1;
        int res = 0;

        while (high != 0 || cur != 0) {
            if (cur<2)
            {
                res+=high*digit;
            }else if (cur>2)
            {
                res+=(high+1)*digit;
            }else
            {
                res+=high*digit+low+1;
            }
            low=cur*digit+low;
            digit=digit*10;
            cur=high%10;
            high=high/10;
        }
        return res;

    }
    @Test
    public void test()
    {

        int res= numberOf2sInRange(25);
        System.out.println(res);
    }
}
