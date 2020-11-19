package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/18 下午6:01
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-18 18:01
 */
public class 第一个只出现一次的字符 {
    //哈希表
    public char firstUniqChar(String s) {
        //特殊
        if (s.length()==0)
        {
            return ' ';
        }
        char[] chars=s.toCharArray();
        int[] count=new int[26];
        //计数
        for (char ch:chars)
        {
            count[ch-'a']++;
        }
        //遍历
        for (char ch:chars)
        {
            if (count[ch-'a']==1)
            {
                return ch;
            }
        }
        return ' ';

    }

    //索引函数
    public char firstUniqChar2(String s)
    {
        //特殊
        if (s.length()==0)
        {
            return ' ';
        }
        char[] chars=s.toCharArray();

        for (int i=0;i<s.length();i++)
        {
            char ch=chars[i];
            //如果当前字符的索引是i，并且i+1之后没有字符
            if (s.indexOf(ch)==i &&s.indexOf(ch,i+1)==-1)
            {
                return ch;
            }
        }
        return ' ';


    }

}
