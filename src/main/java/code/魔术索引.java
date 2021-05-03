package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/2 下午7:41
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-02 19:41
 */
public class 魔术索引 {
    public int findMagicIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i==nums[i]){
                return i;
            }
        }
        return -1;
    }

}
