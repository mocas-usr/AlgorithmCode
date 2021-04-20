package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/12 下午3:49
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-12 15:49
 */
public class 最大数 {

    public String largestNumber(int[] nums) {
        StringBuilder st=new StringBuilder();
        compareSort(nums, 0, nums.length - 1);
        if (nums[0]==0)
        {
            return "0";
        }
        for (int num:nums)
        {
         st.append(num);
        }
        return st.toString();
    }

    //快速排序
    public void compareSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int stand = partion(nums, left, right);
        compareSort(nums, left, stand - 1);
        compareSort(nums, stand + 1, right);
    }

    public int partion(int[] nums, int left, int right) {
        int key = left;
        int temp = nums[left];

        while (left < right) {
            while (left < right&& compareNum(nums[right],temp)<=0) {
                right--;
            }
            while ( left < right&&compareNum(nums[left],temp)>=0) {
                left++;
            }
            if (left<right)
            {
                swap(nums,left,right);
            }
        }
        //l=r
        swap(nums,left,key);
        return left;
    }

    public void swap(int[] nums ,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    //num1>num2,则返1
    public int compareNum(int num1, int num2) {
        String s1 = String.valueOf(num1);
        String s2 = String.valueOf(num2);
        return (s1 + s2).compareTo(s2 + s1);

    }

}
