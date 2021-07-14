package code.计数;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/6 下午4:32
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-06 16:32
 */
public class 验证外星语词典 {
    public boolean isAlienSorted(String[] words, String order) {

        int n = order.length();
        int[] count = new int[n];
        //字典顺序
        char[] chars = order.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //顺序
            count[chars[i] - 'a'] = i;

        }


        for (int i = 0; i < words.length - 1; i++) {
            char[] s1 = words[i].toCharArray();
            char[] s2 = words[i + 1].toCharArray();
            boolean flag = compare(s1, s2, count);
            if (!flag) {
                return false;
            }

        }
        return true;


    }

    public boolean compare(char[] s1, char[] s2, int[] count) {

        int flag = 0;
        for (int i = 0; i < s1.length && i < s2.length; i++) {
            if (count[s1[i] - 'a'] > count[s2[i] - 'a']) {
                //说明s1在s2之后
                flag = -1;
                break;
            }else if (count[s1[i] - 'a'] < count[s2[i] - 'a'])
            {
                //s1在s2之前
                flag = 1;
                break;

            }else
            {
                continue;
            }
        }

        if (flag==0) {

            if (s1.length > s2.length) {
                //s1在s2之后
                return false;
            } else {
                return true;
            }

        } else {

            return flag>0?true:false;
        }

    }

    @Test
    public void test() {

        String[] words = {"my","f"};
        String order = "gelyriwxzdupkjctbfnqmsavho";
        boolean flag = isAlienSorted(words, order);
        System.out.println(flag);


    }
}
