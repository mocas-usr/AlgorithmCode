package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/16 下午4:04
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-16 16:04
 */
/*给你一个字符串 s 和一个 长度相同 的整数数组 indices 。

        请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。

        返回重新排列后的字符串。*/

public class 重新排列字符串 {

    public String restoreString(String s, int[] indices) {

        //字符串长度
        int length = s.length();

        //存入新的字符数组
        char[] str = new char[length];

        for (int i = 0; i < length; i++) {
//            str[i]=s.charAt(indices[i]);
            //第 i 个字符需要移动到 indices[i] 指示的位置
            str[indices[i]] = s.charAt(i);
        }
        return new String(str);
    }

    //StringBuilder
    public String restoreString2(String s, int[] indices) {
        StringBuilder str = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            str.setCharAt(indices[i], s.charAt(i));
        }
        return str.toString();
    }

    @Test
    public void test() {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        String result = restoreString(s, indices);
        System.out.println(result);
    }
}
