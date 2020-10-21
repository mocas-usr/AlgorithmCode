package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/13 下午3:10
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-13 15:10
 */
/*给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。*/
public class 验证回文串 {


    //双指针法
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;

        //字符串处理,只考虑字母和数字，忽略大小写
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                str.append(ch);
            }
        }
        /*处理结束字符串*/

        //双指针办法处理是否相等
        int i = 0, j = str.length() - 1;
        for (; i < str.length(); i++, j--) {

            //如果存在不相等，则false
            if (Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))) {
                return false;
            }

        }
        return true;
    }

    @Test
    public void test() {

        String s = "A man, a plan, a canal: Panama";
        isPalindrome(s);

    }
}
