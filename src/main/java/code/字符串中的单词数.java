package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/14 上午9:01
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-14 09:01
 */
/*统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。

        请注意，你可以假定字符串里不包括任何不可打印的字符。*/
public class 字符串中的单词数 {

    //内置函数
    public int countSegments(String s) {
        //去除头部和尾部的空格
        String s1 = s.trim();
        //排除空
        if (s1.equals("")) {
            return 0;
        }
        //非空时
        int t = s1.split("\\s+").length;
        return t;

    }


    /*时间复杂度o（n）,空间复杂度 o（1）*/
    public int countSegments2(String s) {
        //计数
        int count = 0;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //如果存在空格加字符串的组合，开始计数
            if ((i == 0 || s.charAt(i - 1) == ' ') && (s.charAt(i) != ' ')) {
                count++;
            }
        }

        return count;

    }

    @Test
    public void test() {
        String s = "123,sda asd dwa ,wda a";
        int c = countSegments(s);
        System.out.println(c);
    }
}
