package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/2 下午3:48
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.*;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-02 15:48
 */
public class T9键盘 {

    int l;
    // 建立字母对数字的映射
    //0,0,0说明abc在0上，实际进行了-2处理
    int[] map = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7};

    public List<String> getValidT9Words(String num, String[] words) {

        l = num.length();
        //做-2处理
        int[] nums = new int[l];

        for (int i = 0; i < l; i++) {
            nums[i] = Integer.valueOf(num.charAt(i) - '0') - 2;
        }
        boolean flag = true;
        List<String> res = new LinkedList<>();
        for (String word : words) {
            //遍历是否对应
            for (int i = 0; i < l; i++) {
                //word对应的按键
                if (map[word.charAt(i) - 'a'] != nums[i]) {
                    flag = false;
                    break;
                }else
                {flag=true;}
            }

            if (flag) {
                res.add(word);
            }
        }
        return res;


    }


    @Test
    public void test() {
        String num = "9675973753";
        String[] words = {"alasvnpzur", "znwdgoiwso", "wduzrpnqrv", "ymrkxqdrlf", "epsqjclyqe", "zopjysdqke", "zhfxsdeimz", "eitgrsdnvt"};
        List<String> res = getValidT9Words(num, words);
        System.out.println(res);
    }

}
