package code.递归;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/3 下午4:08
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-03 16:08
 */
public class 外观数列 {
    public String countAndSay(int n) {
        //终止条件
        if (n == 1) {
            return "1";
        }

        //当前选择
        String s = countAndSay(n - 1);
        char[] str = s.toCharArray();
        //统计
        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        while (right < s.length()) {
            if (str[left] == str[right]) {
                right++;
            } else {

                int count = right - left;
                sb.append(count).append(str[left]);
                left=right;
            }
        }

        if (right>left)
        {
            int count=right-left;
            sb.append(count).append(str[left]);
        }
        return sb.toString();

    }

    @Test
    public void test() {
        String rs = countAndSay(6);
        System.out.println(rs);
    }
}
