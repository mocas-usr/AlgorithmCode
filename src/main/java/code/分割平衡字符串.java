package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/18 上午10:49
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-18 10:49
 */
/*
在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。

        给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。

        返回可以通过分割得到的平衡字符串的最大数量。
*/

public class 分割平衡字符串 {
    public int balancedStringSplit(String s) {
        int num = 0;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R')
                n++;
            if (s.charAt(i) == 'L')
                n--;
            if (n == 0)
                num++;
        }
        return num;
    }
}
