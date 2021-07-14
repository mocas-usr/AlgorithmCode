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

        //当前选择
        String s = countAndSay(n - 1);
        char[] str = s.toCharArray();
        int left = 0;
        int right = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (right < str.length) {
            if (str[right] != str[left]) {
                count=right-left;
                sb.append(count).append(str[left]);
                left=right;
            }else
            {
                right++;
            }
        }
        if (right!=left)
        {
            count=right-left;
            sb.append(count).append(str[left]);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String res = countAndSay(4);
        System.out.println(res);
    }
}
