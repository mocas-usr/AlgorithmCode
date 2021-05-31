package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/30 下午8:37
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-30 20:37
 */
public class 重复叠加字符串匹配 {

    public int repeatedStringMatch(String a, String b) {

        if (a.contains(b)) {
            return 1;

        }
        int max = b.length() / a.length() + 2;
        String str = "";
        for (int i = 0; i <= max + 2; i++) {
            if (str.indexOf(b) > -1) {
                return i;
            } else {
                str += a;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        String a = "abcd";
        String b = "cdabcdab";
        int res = repeatedStringMatch(a,b);
        System.out.println(res);
    }

}
