package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/2 下午2:46
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-02 14:46
 */
public class 二进制求和 {
    public String addBinary(String a, String b) {

        int n=a.length();
        int m=b.length();

        char[] str=new char[Math.max(n,m)];
        int i=n-1;
        int j=m-1;
        int index=0;//表示进位
        int count=Math.max(n,m)-1;
        while(i>=0 || j>=0)
        {


            int saVal;
            int sbVal;
            if (i<0)
            {
                saVal=0;
            }
            else
            {
                saVal=Integer.parseInt(a.substring(i,i+1));

            }
            if (j<0)//如果小于0
            {sbVal=0;}
            else
            {
                sbVal=Integer.parseInt(b.substring(j,j+1));
            }



            if (saVal+sbVal+index==2)
            {
                str[count]='0';
                index=1;

            }
            else if (saVal+sbVal+index==3)
            {
                str[count]='1';
                index=1;
            }
            else if (saVal+sbVal+index==1)
            {
                str[count]='1';
                index=0;
            }
            else if (saVal+sbVal+index==0)
            {
                str[count]='0';
                index=0;
            }
            //移位
            i--;
            j--;
            count--;
        }
        //说明最后一位有进位
        if (index>0)
        {
            String res="1"+String.copyValueOf(str);

            return res;
        }
        else
        {
            String.valueOf(str);
        }

        return String.valueOf(str);

    }


    @Test
    public void test()
    {
        String a="1",b="111";
        addBinary(a,b);
    }
}
