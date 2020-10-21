package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/21 上午9:39
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.*;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-21 09:39
 */
public class 重复的DNA序列 {
    public List<String> findRepeatedDnaSequences(String s) {
        int n=s.length();//字符串长度
        char[] str=s.toCharArray();//拆分出字符数组
        //保留的结果集
        List<String> list=new LinkedList<>();

        //双指针，滑动窗口
        for (int i=0;i<n;i++)
        {
            //j指针在i右边
            for (int j=i+1;j<n;j++)
            {
                if (str[j]==str[i])
                {
                    int l1=i;
                    int l2=j;
                    int flag=1;
                    String res="";
                    //循环判断字符串
                    for (int k=0;k<10;k++)
                    {
                        if (l1<n &&l2<n && str[l1]==str[l2] )
                        {
                            res=res+str[l2];
                            l1++;
                            l2++;
                        }
                        else
                        {
                            flag=0;
                            break;
                        }


                    }
                    //循环结束，说明相等
                    if (flag==1)
                    {
                        if (!list.contains(res))
                        {
                            list.add(res);
                        }

                    }
                }

            }
        }

        return list;

    }

    //hashset滑动窗口
    public List<String> findRepeatedDnaSequences2(String s)
    {
        int n=s.length();//字符串长度
        int l=10;
        //保留的结果集
        List<String> list=new LinkedList<>();

        HashSet<String> tmp=new HashSet<>();
        HashSet<String> output=new HashSet<>();//结果集合
        //循环取字符串
        for (int i=0;i<n-l+1;i++)
        {
            String str=s.substring(i,i+l);
            //查看是否已经有
            if (tmp.contains(str))
            {
                //hashset不包括重复元素
                if (!list.contains(str))
                {
                    list.add(str);
                }
            }
            tmp.add(str);
        }
        return list;
    }

    //hash算法
    public List<String> findRepeatedDnaSequences3(String s) {
        int len = s.length();
        if (len == 0 || len < 10) {
            return new ArrayList<>();
        }
        Set<String> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        char map[] = new char[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int key = 0;
        char[] array = s.toCharArray();
        //第一组单独初始化出来
        for (int i = 0; i < 10; i++) {
            key = key << 2 | map[array[i] - 'A'];
        }
        set.add(key);
        for (int i = 10; i < len; i++) {
            key <<= 2;
            key |= map[array[i] - 'A'];
            key &= 0xfffff;
            if (set.contains(key)) {
                res.add(s.substring(i - 9, i + 1));
            } else {
                set.add(key);
            }

        }
        return new ArrayList<>(res);
    }

    @Test
    public void test()
    {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> str=findRepeatedDnaSequences2(s);
        System.out.println(str);
    }
}
