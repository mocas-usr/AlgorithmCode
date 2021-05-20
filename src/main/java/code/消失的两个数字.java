package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/16 上午9:47
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-16 09:47
 */
public class 消失的两个数字 {
    public int[] missingTwo(int[] nums) {

        //先找a^b的结果, 相同为0，相异为1
        int n = nums.length;
        int x = 0;
        for (int i = 1; i <= n + 2; i++) {
            x ^= i;
        }

        for (int num : nums) {
            x ^= num;
        }


        //得到相异的某位置
        int flag = x & (-x);

        int res = 0;
        for (int i = 1; i <= n + 2; i++) {
            //ab其中有一个为0
            if ((i & flag) != 0) {
                res ^= i;
            }
        }

        for (int num : nums) {
            if ((num & flag) != 0) {
                res^=num;
            }
        }

        return new int[]{res,res^x};

    }
}
