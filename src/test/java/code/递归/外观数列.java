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
    //递归
    public String countAndSay(int n) {
        //终止条件
        if (n == 1) {
            return "1";
        }
        //for 选择列表
        //做选择
        String s = countAndSay(n - 1);
        StringBuilder ans = new StringBuilder();
        int left = 0;
        int right = 0;
        int i = 0;
        for (i = 0; i < s.length(); i++) {
            right = i;
            if (s.charAt(left) != s.charAt(right)) {
                int len = right - left;
                ans.append(len).append(s.charAt(left));
                left = right;
            }

        }

        if (i != left) {
            int len = i - left;
            ans.append(len).append(s.charAt(left));
        }
        //下一路径

        //恢复现场
        return ans.toString();


    }

    @Test
    public void test() {
        String rs = countAndSay(6);
        System.out.println(rs);
    }
}
