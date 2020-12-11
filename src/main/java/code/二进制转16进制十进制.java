package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/20 下午8:59
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-20 20:59
 */
public class 二进制转16进制十进制 {
    public String changeFormatNumber (String number) {
//        if (number.length()==0)
//        {
//            return
//        }
        // write code here
        //判断字符合法性
        for (int k=0;k<number.length();k++)
        {

           if (Character.isDigit(number.charAt(k)))
            {
                continue;
            }else
           {
               return "INPUTERROR";
           }
        }

        int num=Integer.valueOf(number);
        if (num>=Character.MAX_VALUE || num<=Character.MIN_VALUE)
        {
            return "NODATA";
        }
        //转化数值
        String binary=Integer.toBinaryString(num);
        //处理16进制
        String hex=Integer.toHexString(num);
        String hexStr="";
        if (hex.length()>4)
        {
            return "NODATA";
        }
        else
        {
            char[] hextemp=new char[4-hex.length()];
            for (int i=0;i<4-hex.length();i++)
            {
                hextemp[i]='0';
            }
            hexStr=String.valueOf(hextemp)+hex;//16进制的结果
        }
        //控制字符长度
        char[] temp=new char[16-binary.length()];
        for(int i=0;i<16-binary.length();i++)
        {
            temp[i]='0';
        }
        String binaystr=String.valueOf(temp)+binary;
        String res=binaystr+","+hexStr;
        return res;


    }
    @Test
    public void test()
    {
        String num="15";
        changeFormatNumber(num);
    }

}
