package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/9 下午8:56
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-09 20:56
 */
public class 反转字符串中的单词3 {
    public String reverseWords(String s) {
        char[] cr = s.toCharArray();
        int i = 0;
        int j = 0;
        while(i < cr.length){
            //开始位置
            int l = i;
            //结束位置
            int r = i - 1;
            for(j = i;j < cr.length;j++){
                if(cr[j] == ' '){
                    break;
                }
                //更新结束位置
                r++;
            }
            //更新开始指针
            i = j + 1;
            //原数组上替换
            while(l < r){
                char tmp = cr[l];
                cr[l++] = cr[r];
                cr[r--] = tmp;
            }
        }
        return new String(cr);
    }
}
