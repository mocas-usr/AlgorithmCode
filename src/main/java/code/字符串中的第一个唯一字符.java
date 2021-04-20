package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/16 下午3:43
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-16 15:43
 */
public class 字符串中的第一个唯一字符 {

    public int firstUniqChar(String s) {
        if (s.length()==0)
        {
            return -1;
        }

        char[] str=s.toCharArray();
        int[] count=new int[26];
        for (char ch:str)
        {
            count[ch-'a']++;
        }

        for (int i=0;i<str.length;i++ )
        {
            char ch=str[i];
            if (count[ch-'a']==1)
            {
                return i;
            }
        }
        return -1;

    }
}
