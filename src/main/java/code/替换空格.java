package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/7 上午9:32
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-07 09:32
 */
public class 替换空格 {
    public String replaceSpace(String s) {
        StringBuilder str=new StringBuilder();
        char[] chars=s.toCharArray();
        for (int i=0;i<s.length();i++)
        {
            //如果是空格
            if (chars[i]==' ')
            {
                str.append("%20");
            }
            else
            {
                str.append(chars[i]);
            }

        }

        return str.toString();

    }
}
