package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 上午11:28
 * @email: wangyuhang_mocas@163.com
 */

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-17 11:28
 */
public class 把字符串转换成整数 {
    public int StrToInt(String str) {
        long res = 0;
        char[] chars = str.toCharArray();
        int i = 0;

        while (i < str.length() && chars[i] == ' ') {
            i++;
        }
        if (i == str.length()) {
            return 0;
        }
        //默认正数
        boolean flag = true;
        //处理符号
        if (chars[i] == '+' || chars[i] == '-') {
            if (chars[i] == '-') {
                flag = false;
            }
            i++;
        } else {
            if (!Character.isDigit(chars[i])) {

                return 0;
            }
        }

        for (int j = i; j < str.length(); j++) {

            if (Character.isDigit(chars[j]))
            {
                int num=chars[j]-'0';
                res=res*10+num;

            }else
            {
                return 0;
            }
        }
        if (flag)
        {
            if (res>Integer.MAX_VALUE)
            {
                res=Integer.MAX_VALUE;
            }
            return (int) res;
        }else {
            if (res > Integer.MAX_VALUE) {
                res = Integer.MIN_VALUE;
            }
            return (int) -res;
        }

    }

    @Test
    public void test()
    {
        String str="123";
        int res=StrToInt(str);
        System.out.println(res);
    }

}
