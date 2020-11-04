package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/2 上午10:11
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-02 10:11
 */
public class 加一 {
    public int[] plusOne(int[] digits) {
        int len=digits.length;
        //一直查找到进位停止的位数
        for (int i=len-1;i>=0;i++)
        {
            digits[i]++;//末位＋1
            //如果不是9
            digits[i]=digits[i]%10;
            if (digits[i]!=0)
            {
                return digits;//返回数值
            }
        }
        //如果继续执行,说明全是99
        digits=new int[len+1];
        digits[0]=1;
        return digits;

    }
}
