package code.计数;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/6 下午4:31
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-06 16:31
 */
public class 拼写单词 {
    public int countCharacters(String[] words, String chars) {
        //拆分
        char[] chars1=chars.toCharArray();
        int n=chars.length();
        int[] count=new int[26];
        int res=0;//存放结果
        //计数
        for (char ch:chars1)
        {
            count[ch-'a']++;
        }


        for (String word:words)
        {
            //每个字符串
            char[] str=word.toCharArray();
            //在这里开辟空间
            int[] num=new int[26];//用于计算每个单词的数量
            int index=0;
            for (int i=0;i<str.length;i++)
            {
                num[str[i]-'a']++;
                //如果单词里面的字母都有，并且数量小于字母表
                if (count[str[i]-'a']>0 &&num[str[i]-'a']<=count[str[i]-'a'])
                {
                    index++;
                }else
                {
                    break;
                }

            }
            if (index==str.length)
            {
                res+=index;
            }

        }

        return res;


    }


    @Test
    public void test()
    {

    }
}
