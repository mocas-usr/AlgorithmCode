package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/19 下午4:44
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-19 16:44
 */
/*
某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。

        给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。

*/

public class 验证外星语词典 {
    //用于存储字符顺序
    private int[] hash = new int[26];

    public boolean isAlienSorted(String[] words, String order) {

        char[] chars = order.toCharArray();//转换成字符数组

        //字符顺序处理
        for (int i = 0; i < 26; i++) {
            hash[chars[i] - 'a'] = i;//hash[k]=9代表字母k的排在第9位置
        }
        //进行排序
        return sortByRules(words);

    }

    //排序处理
    public boolean sortByRules(String[] words) {
        //拆分并比较
        for (int k = 0; k < words.length - 1; k++) {
            char[] a = words[k].toCharArray();
            char[] b = words[k + 1].toCharArray();
            //遍历
            for (int i = 0; i < 20; i++) {
                if (i >= a.length || i >= b.length)//如果前面字符相等，
                {
                    if (a.length > b.length) {
                        return false;
                    } else {
                        return true;
                    }
                }

                //如果a的顺序在b的前面，a>b,true
                if (hash[a[i] - 'a'] < hash[b[i] - 'a']) {
                    //跳出此次循环，说明此次比较是true
                    break;
                } else if (hash[a[i] - 'a'] == hash[b[i] - 'a']) {
                    //如果相等，则继续比较下一个字符
                    continue;
                } else if (hash[a[i] - 'a'] > hash[b[i] - 'a']) {
                    return false;
                }
            }
        }

        return true;

    }

    @Test
    public void test() {
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        boolean re = isAlienSorted(words, order);
        System.out.println(re);
    }
}
