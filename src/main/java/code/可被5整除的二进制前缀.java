package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/24 下午7:50
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-24 19:50
 */
public class 可被5整除的二进制前缀 {

    public List<Boolean> prefixesDivBy5(int[] nums) {

        List<Boolean> res = new LinkedList<>();
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num * 2 + nums[i];
            num %= 10;
            if (num % 5 == 0) {
                res.add(true);
            } else {
                res.add(false);
            }
        }

        return res;
    }

    @Test
    public void test() {
        int[] nums={0,1,1};
        List<Boolean> res=prefixesDivBy5(nums);
        System.out.println(res);
    }
}
