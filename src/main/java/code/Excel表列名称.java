package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/10 下午10:09
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-10 22:09
 */
public class Excel表列名称 {

    public String convertToTitle(int columnNumber) {

        char[] chars={'A','B','C','D','E','F','G','H','I','J','K',
                'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        StringBuilder sb=new StringBuilder();

        while (columnNumber!=0)
        {
            columnNumber--;
            //转换为26进制
            int yu=columnNumber%26;
            sb.append(chars[yu]);
            columnNumber=columnNumber/26;
        }
        return sb.reverse().toString();

    }

    @Test
    public void test()
    {
        String res=convertToTitle(28);
        System.out.println(res);
    }
}
