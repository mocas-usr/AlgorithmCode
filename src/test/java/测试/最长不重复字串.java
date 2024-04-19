package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/20 15:39
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-20 15:39
 */

public class 最长不重复字串 {

    public int findStr(String str) {
        //特殊处理
        if (str.length() == 0) {
            return 0;
        }
        //key代表字符，val代表位置
        Map<Character, Integer> map = new HashMap<>();
        //边界
        int start=-1;
        int len = 0;
        int left = -1;
        for (int i = 0; i < str.length(); i++) {
            //right=i
            char ch = str.charAt(i);
            //扩增窗口
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch));
            }
            //缩减窗口
            //当前选择
            if (i-left>len)
            {
                start=left;
                len = Math.max(len, i - left);
            }
            //更新操作
            map.put(ch, i);

        }
        String res= str.substring(start+1,start+len+1);
        return len;
    }

    @Test
    public void test() {

        String str="abcabcbb";
        int res=findStr(str);
        System.out.println(res);

    }
}
