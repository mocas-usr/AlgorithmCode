package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/6 下午3:48
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-06 15:48
 */
public class 拼写单词 {

    //计数方法
    public int countCharacters(String[] words, String chars) {

        //计数
        int[] count=new int[26];
        char[] s=chars.toCharArray();
        for (char c:s)
        {
            //计数，count[b]=3,说明b有3个
            count[c-'a']++;
        }
        int res=0;
        for (int i=0;i<words.length;i++)
        {
            //拆分单词
            char[] word=words[i].toCharArray();
            int[] time=new int[26];
            int index=0;
            //每个单词的字符
            for (char w:word)
            {
                time[w-'a']++;//字母的次数计数
                //字母表有，并且单词表出现个数小于他
                if (count[w-'a']>0 &&time[w-'a']<=count[w-'a'])
                {
                    index++;
                }else
                {
                    //打破第一层循环，到下一个单词
                    break;
                }
            }
            //说明此字符串符合要求，
            if (index==word.length)
            {
                res+=index;
            }


        }
        return res;


    }

    @Test
    public void test()
    {
        String[] words = {"hello","world","leetcode"};
        String  chars = "welldonehoneyr";
        countCharacters(words,chars);
    }
}
