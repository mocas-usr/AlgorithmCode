package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/4 下午3:32
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-04 15:32
 */
public class 最长不含重复字符的子字符串 {

    //动态规划
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();//记录字符位置

        char[] chars=s.toCharArray();//分割字符串
        int tmp=0;//中转
        int res=0;
        for (int j=0;j<s.length();j++)
        {
            //原本存在的位置
            int key=map.getOrDefault(chars[j],-1);//默认-1/，因为长度+1
            //j现在字符出现的位置
            map.put(chars[j],j);//放入指定位置

            //tmp代表上一个字符结尾的最大长度
            if (tmp<j-key)
            {
                //说明tmp不包含si
                tmp=tmp+1;
            }else
            {
                tmp=j-key;//说明包含了
            }

            res=Math.max(tmp,res);//不断取最大
        }
        return res;

    }


    //双指针，滑动窗口
    public int lengthOfLongestSubstring2(String s)
    {
        Map<Character,Integer> map=new HashMap<>();//记录字符位置

        int res=0;
        int key=-1;
        //遍历
        for (int i=0;i<s.length();i++)
        {
            //保证key+1,i之间没有重复项,一直更新左边界
            if (map.containsKey(s.charAt(i)))
            {
                //以较大的数值为准
                key=Math.max(key,map.get(s.charAt(i)));

            }
            //把字符串定位放入map
            map.put(s.charAt(i),i);
            res=Math.max(res,i-key);
        }
        return res;
    }
}
