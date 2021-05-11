package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/6 下午7:07
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-06 19:07
 */
public class 判定是否互为字符重排 {

    public boolean CheckPermutation(String s1, String s2) {

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        if (String.valueOf(str1).equals(String.valueOf(str2))) {
            return true;

        } else {
            return false;
        }

    }

    @Test
    public void test()
    {
        String s1 = "abc";
        String s2 = "bca";
        boolean res=CheckPermutation(s1,s2);
        System.out.println(res);
    }
}
