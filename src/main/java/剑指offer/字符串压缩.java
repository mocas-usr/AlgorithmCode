package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/5 下午3:33
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-05 15:33
 */
public class 字符串压缩 {
    public String zipString(String iniString) {

        /**
         * 字符串压缩 使用StringBuilder
         * StringBuilder 解决大量拼接字符串时产生很多中间对象问题而提供的类
         * 提供append和add方法，可以将字符串添加到已有序列的末尾或指定位置
         * 例：str ="aaaabbccccddeaaa" 压缩为"4a2b4c2d1e3a"
         * **/
        StringBuilder sb = new StringBuilder();
        int len = iniString.length();
        int low = 0, high = 0;
        int count = 0;
        char c = ' ';

        while(low < len){
            high = low;
            c = iniString.charAt(low);
            while((high < len) && (iniString.charAt(high) == c)){
                high++;
            }
            count = high - low;
            sb.append(c);
            sb.append(count);
            low = high;
        }

        return (sb.toString().length() < len) ? sb.toString() : iniString;
    }
    public String compressString(String S) {
        if (S.length() < 2) {
            return S;
        }
        char[] str = S.toCharArray();

        int left = 0;
        int right = 0;
        int n = S.length();
        StringBuilder res=new StringBuilder();

        while (right < n) {

            if (str[left] == str[right]) {
                right++;
            } else {
                res.append(str[left]).append(right-left);
                left=right;
                right++;
            }

        }
        if (right!=left)
        {
            res.append(str[left]).append(right-left);
        }

        if (res.length()>=n)
        {
            return S;
        }else
        {
            return res.toString();
        }

    }
    @Test
    public void Test()
    {
        String iniString="abbccd";
        String ans=compressString(iniString);
        System.out.println(ans);
        String res=zipString(iniString);
        System.out.println(res);
    }
}
