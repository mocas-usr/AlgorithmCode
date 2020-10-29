package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/23 下午8:49
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-23 20:49
 */
public class 最大交换 {

    public int maximumSwap(int num) {
        List<Integer> list=new ArrayList<>();//存储各位数
        //取数值
        while(num>0)
        {
            int t=num%10;
            list.add(t);
            num=num/10;
        }

        int n=list.size();//数值的位数
        //交换最大位数

//        int maxVal=Integer.MIN_VALUE;
        for (int i=n-1;i>0;i--)
        {
            int maxIndex=i;
            for (int j=i-1;j>=0;j--)
            {
                //maxindex是最大数的index
                if (list.get(maxIndex)<=list.get(j))
                {
                    maxIndex=j;
                }

            }
            if (maxIndex!=i &&list.get(maxIndex)!=list.get(i))
            {
                int tmp=list.get(i);
                list.set(i,list.get(maxIndex));
                list.set(maxIndex,tmp);
                break;
            }

        }
        //返回数值计算
        num=0;
        int t=1;
        for (int i=0;i<n;i++)
        {
            num=num+list.get(i)*t;
            t=t*10;
        }
        return num;
    }

    //贪心算法
    public int maximumSwap2(int num)
    {
        //转化成数组
        char[] s=String.valueOf(num).toCharArray();
        int n=s.length;
        //arr代表此位数之后的最大索引
        int[] arr=new int[n];
        int maxIndex=n-1;
        int maxVal=Integer.MIN_VALUE;
        //从个位开始
        for (int i=n-1;i>=0;i--)
        {
            //第i位的最大数值
            if (s[i]-'0'>maxVal)
            {
                //最大情况
                maxVal=s[i]-'0';
                maxIndex=i;
            }
            arr[i]=maxIndex;
        }

        //循环替换
        for (int i=0;i<n;i++)
        {
            //如果存在比他大的index，并且数值不相等，则交换
            if (arr[i]!=i && s[arr[i]]!=s[i])
            {
                //交换
                char tmp=s[arr[i]];
                s[arr[i]]=s[i];
                s[i]=tmp;
                break;
            }
        }
        return Integer.valueOf(new String(s));


    }

    @Test
    public void test()
    {
        int n=98368;
        maximumSwap(n);
    }
}
