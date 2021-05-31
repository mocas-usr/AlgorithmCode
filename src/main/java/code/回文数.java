package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/31 上午10:19
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-31 10:19
 */
public class 回文数 {

    public boolean isPalindrome(int x) {

        String s=String.valueOf(x);
        int left=0;
        int right=s.length()-1;

        while (left<right)
        {
            char leftChar=s.charAt(left);
            char rightChar=s.charAt(right);
            if (leftChar!=rightChar)
            {return false;}
            left++;
            right--;
        }
        return true;

    }
}
