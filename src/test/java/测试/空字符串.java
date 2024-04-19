package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/14 9:25
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-14 09:25
 */
public class 空字符串 {
    public String replace(String str)
    {
        StringBuilder sb=new StringBuilder();
        char[] chars=str.toCharArray();
        for (int i=0;i<str.length();i++)
        {
            if (chars[i]==' ')
            {
                sb.append("%20");
            }else
            {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
