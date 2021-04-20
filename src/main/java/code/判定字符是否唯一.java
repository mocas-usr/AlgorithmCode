package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/17 下午3:59
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-17 15:59
 */
public class 判定字符是否唯一 {
    public boolean isUnique(String astr) {

        int sum=0;

        for (int i=0;i<astr.length();i++)
        {
            int index=astr.charAt(i)-'a';
            int temp=1<<index;
            if ((sum&temp)!=0)
            {
                return false;
            }
            sum=sum|temp;

        }
        return true;

    }
}
