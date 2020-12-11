package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/29 下午6:44
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-29 18:44
 */
public class 单例模式 {



}

//饿汉式
class singleTon{
    //载入类的时候就静态初始化,保证了 线程安全
    private static singleTon uniSingleTon=new singleTon();
    //构造函数是空，所以不能通过new构造对象
    public singleTon()
    {}
    //保证初始化一次
    public static singleTon getInstance()
    {
        return uniSingleTon;
    }
}

//懒汉式（非线程安全和synchronized关键字线程安全版本 ）
class SingleTon
{
    //只加载一次，但这里不初始化
    public static SingleTon singleTon;

    //同样的空的构造函数
    public SingleTon()
    {}
    //这里调用方法创建实例
    public static SingleTon getInstance()
    {
        if (singleTon==null)
        {
            //判断当前实例是否存在,为空，则进行实例化
            singleTon=new SingleTon();
        }
        return singleTon;
    }
}

// 懒汉式(双重检查加锁版本)
class sigle{
    //同样是单个对象
    public static sigle sigleClass;
    //空的构造函数
    public sigle(){}
    //获取实例
    public static sigle getSigleClass()
    {
        if (sigleClass==null)
        {
            synchronized (sigle.class)
            {
                sigleClass=new sigle();
            }

        }
        return sigleClass;
    }
}
// 懒汉式（登记式/静态内部类方式）
class single{
    //创建静态内部类
    public static class sigleHold
    {
        //相当于单例实例化，但是不是主动实例化
        public static final sigleHold sigleHoldInstance=new sigleHold();
    }
    //
    public single()
    {

    }
    //
    public static sigleHold getInstance()
    {
        return sigleHold.sigleHoldInstance;
    }
}