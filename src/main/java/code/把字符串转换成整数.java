package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/6 上午10:23
 * @email: wangyuhang_mocas@163.com
 */


import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-06 10:23
 */
public class 把字符串转换成整数 {
    public int strToInt(String str) {
        //拆分字符串
        long res=0;//long防止越界
        char[] chars=str.toCharArray();
        int i=0;
        boolean flag=true;//是否是负数，false是负数
        while(i<chars.length&&chars[i]==' ')
        {
            //如果第一个字符串是空，则不停的往后移动
            i++;
        }
        //超出界限
        if(i==chars.length)
        {
            return 0;
        }
        //如果是满足条件的字符，则往下进行，如果不是
        if (chars[i]=='-' || chars[i]=='+' ||Character.isDigit(chars[i]) )
        {
            if (chars[i]=='-' || chars[i]=='+')
            {
                if (chars[i]=='-')
                {
                    flag=false;//负数
                }
                i++;
            }

        }//如果不满足条件，则返回0
        else
        {
            return 0;
        }


        //开始找寻数字
        for (int j=i;j<str.length();j++)
        {
            //数字则添加
            if (chars[j]>='0' && chars[j]<='9')
            {
                res*=10;
                res=res+chars[j]-'0';//res为结果数值
                if (res>Integer.MAX_VALUE)
                {
                    //如果是正数，则返回最大值
                    return flag?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }

            }else
            {
                break;
            }
        }

        return (int) (flag?res:-res);

    }


    @Test
    public void test()
    {
        String s="4193 with words";
        strToInt(s);

    }
}
