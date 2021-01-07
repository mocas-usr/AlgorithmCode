package code.递归;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/28 下午6:46
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-28 18:46
 */
public class 电话号码的字母组合 {
    //全局变量
    List<String> combinations = new ArrayList<String>();
    //保存现场变量值
    StringBuilder combination;
    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        combination=new StringBuilder();
        //回溯起点
        dfs(0,digits,phoneMap);
        return combinations;

    }
    //回溯搜索
    public void dfs(int index,String digits,Map phoneMap)
    {
        //终止条件
        if (index==digits.length())
        {
            combinations.add(combination.toString());
            return;
        }

        //剪枝

        //for 选择列表
        char num=digits.charAt(index);//这到了第几个数字
        String letters= (String) phoneMap.get(num);//这个数字包含的几个字符
        //对应letter选择
        for (int i=0;i<letters.length();i++)
        {
            char ch=letters.charAt(i);
            //做选择
            combination.append(ch);
            //下一路径搜寻
            dfs(index+1,digits,phoneMap);
            //恢复现场
            combination.deleteCharAt(combination.length()-1);
        }

    }


    @Test
    public void test()
    {
        letterCombinations("23");
    }

}
