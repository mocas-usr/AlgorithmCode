package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/2/1 21:36
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-02-01 21:36
 */
public class 找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        //拆分
        char[] charS=s.toCharArray();
        char[] charP=p.toCharArray();
        //用于接收最后的结果
        List<Integer> res=new LinkedList<>();
        //计数统计
        //d定义p的字符集
        int[] needs=new int[26];
        int[] windows=new int[26];
        //统计p字符
        for (char c:charP)
        {
            needs[c-'a']++;
        }

        //定义滑动两端
        int left=0;
        int right=0;
        //右边界开始移动
        while (right<charS.length)
        {
            int curR=charS[right]-'a';
            right++;
            //将右窗口当前访问到的元素curR加1
            windows[curR]+=1;
            //当前Windows数组中字符比need中多时则移动左指针
            while (windows[curR]>needs[curR])
            {
                int curL=charS[left]-'a';
                left++;
                //左窗口
                windows[curL]-=1;
            }

            //将符合结果的放入
            if (right-left==charP.length)
            {
                res.add(left);
            }
        }
        return res;
    }
}
