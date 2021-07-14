package code.字符串;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/3 下午3:24
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-03 15:24
 */
public class Excel表列名称 {

    public String convertToTitle(int columnNumber) {

        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String res="";

        while (columnNumber>0)
        {
            columnNumber--;
            int i=columnNumber%26;
            columnNumber=columnNumber/26;
            res=str.charAt(i)+res;
        }

        return res;


    }

    @Test
    public void test()
    {
        String res=convertToTitle(701);
        System.out.println(res);
    }
}
