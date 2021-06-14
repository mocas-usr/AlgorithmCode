package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/11 下午8:30
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-11 20:30
 */
public class Z字形变换 {
    public String convert(String s, int numRows) {
        if (numRows < 2)
            return s;
        List<StringBuilder> list = new LinkedList<>();

        for (int k = 0; k < numRows; k++) {
            list.add(new StringBuilder());
        }
        int index = 0;//当前行
        int flag = -1;

        for (int i = 0; i < s.length(); i++) {
            list.get(index).append(s.charAt(i));
            if (index == 0 || index == numRows - 1) {
                flag = -flag;
            }
            //换行
            index += flag;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            res.append(list.get(i).toString());
        }

        return res.toString();
    }

    @Test
    public void test() {
        String s="PAYPALISHIRING";
        String res=convert(s,3);
        System.out.println(res);
    }
}
