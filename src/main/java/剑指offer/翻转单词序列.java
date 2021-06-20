package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 上午10:38
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-17 10:38
 */
public class 翻转单词序列 {

    public String ReverseSentence(String str) {

        if (str.length()==0)
        {
            return "";
        }

        String[] s=str.split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i=s.length-1;i>=0;i--)
        {
            if (!s[i].isEmpty())
            {
                sb.append(s[i]).append(" ");
            }

        }
        return sb.toString().trim();

    }
}
