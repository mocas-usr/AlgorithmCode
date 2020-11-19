package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/13 上午8:56
 * @email: wangyuhang_mocas@163.com
 */

import com.sun.java.swing.plaf.windows.WindowsDesktopIconUI;
import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-13 08:56
 */
public class 旋转数组的最小数字 {

    //直接遍历
    public int minArray(int[] numbers) {

        int index=0;
        for (int i=0;i<numbers.length-1;i++)
        {
            if (numbers[i]<=numbers[i+1])
            {
                continue;
            }else
            {
                index=i+1;
                break;
            }
        }
        return numbers[index];

    }


    //二分查找逼近
    public int minArray2(int[] numbers)
    {

        int left=0;
        int right=numbers.length-1;
        while (left<=right)
        {
            int mid=left+(right-left)/2;
            //这个则在左半边
            if (numbers[mid]>numbers[right])
            {
                 left=mid+1;
            }
            //则在右半边
            else if (numbers[mid]<numbers[right])
            {
                //right右边一定不是，right有可能是
                right=mid;
            }else if (numbers[mid]==numbers[right])
            {
                //去除重复
                right--;
            }
        }
        //left==right时，相等
        return numbers[left];
    }

    @Test
    public void test()
    {
        int[] nums={1,3,5};
        minArray2(nums);
    }
}
