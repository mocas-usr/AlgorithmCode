package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/27 下午3:51
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-27 15:51
 */
public class 删除排序数组中的重复项 {
    //排序顺组删除重复项
    public int removeDuplicates(int[] nums)
    {
        if (nums.length==0)
            return 0;
        //双指针
        int index=0;

        for (int j=1;j<nums.length;j++)
        {
            //如果不相等，则记录
            if (nums[index]!=nums[j])
            {
                //index保证不超过原来数组长度
                index++;
                nums[index]=nums[j];
            }
            else//说明相等，因为是排序顺组
            {

            }
        }
        return index+1;//不会超过原来数组长度

    }
}
