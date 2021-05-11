package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/6 下午8:06
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-06 20:06
 */
public class 字符串压缩 {
    public String compressString(String S) {
        if (S.length() < 2) {
            return S;
        }
        char[] str = S.toCharArray();

        int left = 0;
        int right = 0;
        int n = S.length();
        StringBuilder res=new StringBuilder();

        while (right < n) {

            if (str[left] == str[right]) {
                right++;
            } else {
                res.append(str[left]).append(right-left);
                left=right;
                right++;
            }

        }
        if (right!=left)
        {
            res.append(str[left]).append(right-left);
        }

        if (res.length()>=n)
        {
            return S;
        }else
        {
            return res.toString();
        }

    }

    @Test
    public void test()
    {
      String s=  "aabcccccaaa";
        String res=compressString(s);
        System.out.println(res);

    }
}
