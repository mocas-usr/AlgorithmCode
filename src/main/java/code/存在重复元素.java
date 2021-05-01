package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/12 下午7:14
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashSet;
import java.util.Set;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-12 19:14
 */
public class 存在重复元素 {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set=new HashSet<>();
        for (int num:nums)
        {
            if (set.contains(num))
            {
                return true;
            }
            set.add(num);
        }
        return false;

    }
}
