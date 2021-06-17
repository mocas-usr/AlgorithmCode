package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/16 下午8:15
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-16 20:15
 */
public class 第一个只出现一次的字符 {

    public int FirstNotRepeatingChar(String str) {
        if (str.length()==0)
        {
            return -1;
        }
        int[] count=new int[128];
        for (char ch:str.toCharArray())
        {
            count[ch-'A']++;
        }
        for (int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if (count[ch-'A']==1)
            {
                return i;
            }
        }
        return -1;
    }
}
