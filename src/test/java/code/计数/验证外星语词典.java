package code.计数;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/6 下午4:32
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-06 16:32
 */
public class 验证外星语词典 {
    public boolean isAlienSorted(String[] words, String order) {

        //先将英文字典排序
        int[] count=new int[26];
        char[] orders=order.toCharArray();
        //排新的序列
        for (int i=0;i<order.length();i++)
        {
            //给定新顺序，count[c]=10,说明c位于第10位置，从0开始
            count[orders[i]-'a']=i;
        }

        for (int j=0;j<words.length-1;j++)
        {
            char[]  word1=words[j].toCharArray();
            char[] word2=words[j+1].toCharArray();
            //进行比较，如果word1>word2,则说明false
            //比较长度
            int min=Math.min(word1.length,word2.length);
            int max=Math.max(word1.length,word2.length);

            for (int k=0;k<min;k++)
            {
                //字符越靠前越小，如果a的顺序在b前面，则count[a]<count[b]
                if (count[word1[k]-'a']>count[word2[k]-'a'])
                {
                    //只要出现不符合，返回false
                    return false;
                }
                //如果这个字符相等，下一个字符
                else if (count[word1[k]-'a']==count[word2[k]-'a'])
                {
                    //如果前面都相等，则长的大
                    if (k==min-1)
                    {
                        if (word1.length>word2.length)
                        {
                            return false;
                        }
                    }
                    continue;
                }
                else //如果满足要求，这个单词就是true
                {
                    break;
                }


            }
        }
        return true;

    }

    @Test
    public void test()
    {
        String[] words = {"apple","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        isAlienSorted(words,order);


    }
}
