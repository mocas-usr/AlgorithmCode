package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 上午10:08
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-17 10:08
 */
public class 左旋转字符串 {

    public String LeftRotateString(String str, int n) {
        if (str.length()==0)
        {
            return "";
        }
        char[] s = str.toCharArray();


        int num = n % s.length;
        while (num > 0) {
            char ch = s[0];
            for (int i = 0; i < s.length - 1; i++) {
                s[i] = s[i + 1];
            }
            s[s.length - 1] = ch;
            num--;
        }
        return String.valueOf(s);

    }

    @Test
    public void test()
    {
        String str="abcXYZdef";
        String res =LeftRotateString(str, 3);
        System.out.println(res);
    }
}
