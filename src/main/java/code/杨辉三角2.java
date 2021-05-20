package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/20 下午9:18
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-20 21:18
 */
public class 杨辉三角2 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new LinkedList<>();
        List<List<Integer>> nums = new LinkedList<>();
        for (int i = 0; i <= rowIndex; i++) {   //此层的数据
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    int num = nums.get(i - 1).get(j - 1) + nums.get(i - 1).get(j);
                    list.add(num);
                }
            }
            nums.add(list);
        }

        return nums.get(rowIndex);

    }

    @Test
    public void test() {
        List<Integer> res=getRow(3);
        System.out.println(res);
    }
}
