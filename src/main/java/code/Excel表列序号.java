package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/12 下午2:24
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-12 14:24
 */
public class Excel表列序号 {

    public int titleToNumber2(String s) {

        //先位置
        int[] count = new int[26];
        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] chars = string.toCharArray();
        //字典位置
        for (int i = 0; i < 26; i++) {
            char ch = chars[i];
            count[ch - 'A'] = i + 1;
        }

        //26进制求
        char[] str = s.toCharArray();
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int num1 = count[str[i] - 'A'];
            int num = (int) (num1 * Math.pow(26, n - i - 1));
            res = res + num;
        }
        return res;


    }

    public int titleToNumber(String s)
    {
        int res=0;
        for (int i=0;i<s.length();i++)
        {
            int num=s.charAt(i)-'A'+1;
            res=res*26+num;
        }
        return res;
    }

    @Test
    public void test() {
        String s="AB";
        int res=titleToNumber(s);
        System.out.println(res);
    }
}
