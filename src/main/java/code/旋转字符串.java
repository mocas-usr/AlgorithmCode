package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/25 下午8:13
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-25 20:13
 */
public class 旋转字符串 {

    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    @Test
    public void test() {
        String A = "abcde";
        String B = "cdeab";

        boolean res = rotateString(A, B);
        System.out.println(res);
    }
}
