package code.字符串;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/3 下午4:08
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-03 16:08
 */
public class 外观数列 {
    //递归

    public String countAndSay(int n) {
        //终止条件
        if (n == 1) {
            return "1";
        }

        //for 选择列表
        String str = countAndSay(n - 1);
        // 当前操作
        int l = 0;
        int r = 0;
        String countStr = "";
        for (int i = 0; i < str.length(); i++) {
            char chl = str.charAt(l);
            char ch = str.charAt(i);
            if (ch != chl) {
                int count = i - l;
                l = i;
                countStr = countStr + count + chl;
            }
            if (i == str.length() - 1) {
                int count = i - l + 1;
                countStr = countStr + count + ch;
            }
        }
        // 下一路径

        //恢复现场

        return countStr;

    }

    @Test
    public void test() {
        String res = countAndSay(4);
        System.out.println(res);
    }
}
