package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/17 下午8:44
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-17 20:44
 */
public class 回文排列 {
    public boolean canPermutePalindrome(String s) {

        Set<Character> set = new HashSet<>();

        for (char ch : s.toCharArray()) {
            //已经包含ch
            if (!set.add(ch)) {
                set.remove(ch);
            } else {

            }
        }

        if (set.size() <= 1) {
            return true;
        } else {
            return false;
        }

    }

    public boolean canPermutePalindrome2(String s) {
        int[] count = new int[128];
        int num=0;
        for (char ch : s.toCharArray()) {
            count[ch]++;
        }

        for (int i:count)
        {
            //奇数的个数
            num+=(i%2);
        }

        if (num<2)
        {
            return true;
        }else
        {
            return false;
        }


    }
}
