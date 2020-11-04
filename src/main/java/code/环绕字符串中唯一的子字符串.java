package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/30 上午11:03
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Map;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-30 11:03
 */
public class 环绕字符串中唯一的子字符串 {
    //动态规划
    public int findSubstringInWraproundString(String p) {

        int n=p.length();
        char[] s=p.toCharArray();
        int[] count=new int[26];

        int curMaxLen=1;//初始字符串长度
        //计算以字符s[i]结尾的连续字符长度
        for (int i=0;i<n;i++)
        {
            //字符串相邻判别
            if (i>0 && (s[i]-s[i-1]==1 || s[i-1]-s[i]==25))
            {
                curMaxLen++;//连续长度＋1

            }else
            {
                curMaxLen=1;//如果此字符串与前一个字符串不是连续
            }
            //更新以s[i]结尾的字符串的连续字符串长度
            count[s[i]-'a']= Math.max(curMaxLen,count[s[i]-'a']);
        }
        //更新以26个字符串结尾的字符串长度之和就是个数
        int sum=0;
        for (int tmp:count)
        {
            sum=sum+tmp;
        }
        return sum;

    }
}
