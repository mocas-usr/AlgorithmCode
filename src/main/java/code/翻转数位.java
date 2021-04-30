package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/22 下午6:46
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-22 18:46
 */
public class 翻转数位 {

    public int reverseBits(int num) {
        if (num==-1)
        {
            return 32;
        }

        int max=1;
        int left=0;
        int right=0;

        while (num!=0)
        {
            if ((num&1)==1)
            {
                left++;
            }else
            {
                right=left;
                left=0;
            }

            max=Math.max(max,right+left+1);
            num>>>=1;
        }
        return max;

    }
}
