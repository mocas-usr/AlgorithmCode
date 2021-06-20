package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/16 下午7:26
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-16 19:26
 */
public class 整数中1出现的次数从1到n整数中1出现的次数 {

    public int NumberOf1Between1AndN_Solution(int n) {

        //初始化
        int high = n / 10;
        int cur = n % 10;
        int low = 0;
        int res=0;
        int dight=1;
        while (high != 0 || cur != 0) {

            if (cur>1)
            {
                res+=dight*(high+1);
            }else if (cur<1)
            {
                res+=(high*dight);
            }else
            {
                res+=high*dight+low+1;
            }
            low=cur*dight+low;
            cur=high%10;
            high=high/10;
            dight*=10;
        }
        return res;

    }
}
