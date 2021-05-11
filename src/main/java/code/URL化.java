package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/6 下午7:35
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-06 19:35
 */
public class URL化 {

    public String replaceSpaces(String S, int length) {

        char[] s1 = S.toCharArray();
        int i = length - 1;
        int j=S.length()-1;
//        int[] res=
        while (i >= 0) {
            if (s1[i]==' ')
            {
                s1[j--]='0';
                s1[j--]='2';
                s1[j--]='%';
            }else
            {
                s1[j--]=s1[i];
            }
            i--;
        }
        return String.valueOf(s1,j+1,S.length()-j-1);

    }

    @Test
    public void test() {
        String S = "Mr John Smith    ";
        int length = 13;
        String res = replaceSpaces(S, length);
        System.out.println(res);
    }
}
