package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/13 下午5:01
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-13 17:01
 */
/*给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。

        注意：整数序列中的每一项将表示为一个字符串。
        */
public class 外观数列 {
    public String countAndSay(int n) {
        String s = "";
        int p1 = 0;
        int cur = 1;
        if (n == 1)
            return "1";
        String str = countAndSay(n - 1);
        for (cur = 1; cur < str.length(); cur++) {
            if (str.charAt(p1) != str.charAt(cur)) {
                int count = cur - p1;
                s = s + count + "" + str.charAt(p1);
                p1 = cur;
            }
        }
        if (p1 != cur) {
            int count = cur - p1;
            s = s + count + "" + str.charAt(p1);
        }
        return s;
    }

    public String countAndSay2(int n) {

        String s = "";
        //用于动态分配字符串
        StringBuilder str = new StringBuilder();
        int count;

        if (n == 1) {
            return "1";
        }
        int pre = 0, cur = 1;
        s = countAndSay2(n - 1);
        //遍历cur++
        for (; cur < s.length(); cur++) {
            //如果双指针，前后不相等，则cur往后移
            while (s.charAt(pre) != s.charAt(cur)) {
                count = cur - pre;
                str.append(count).append(s.charAt(pre));
                pre = cur;

            }
            //如果相等pre不变，curr++；无需操作
        }

        //如果最后一段字符全部相等，会调到如下代码
        if (pre != cur) {
            count = cur - pre;
            str.append(count).append(s.charAt(pre));

        }
        return str.toString();

    }

    @Test
    public void test() {
        String s = countAndSay2(4);
        System.out.println(s);
    }
}
