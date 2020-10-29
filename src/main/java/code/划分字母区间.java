package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/22 上午8:58
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-22 08:58
 */
public class 划分字母区间 {
    //贪心算法双指针
    public List<Integer> partitionLabels(String S) {

        int n=S.length();
        //存储S的字符序列
        int[] letter=new int[26];
        //保存顺序，letter[0]=3代表,S第0位的字符最后位置是3
        for (int i=0;i<n;i++)
        {
            letter[S.charAt(i)-'a']=i;
        }

        //循环遍历结束位置
        int start=0;
        int end=0;
        List<Integer> list=new ArrayList<>();
        int len=0;
        for (int j=0;j<n;j++)
        {
            //不停刷新end数值
            end=Math.max(end,letter[S.charAt(j)-'a']);

            //当指针移动到end时，说明此字符片段结束
            if (j==end)
            {
                //字符段长度
                len=end-start+1;
                list.add(len);
                start=end+1;
            }
        }
        return list;

    }
    @Test
    public void test()
    {
       String S = "vhaagbqkaq";
        partitionLabels(S);
    }
}
