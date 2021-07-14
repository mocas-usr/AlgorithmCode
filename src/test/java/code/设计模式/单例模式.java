package code.设计模式;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/29 下午7:39
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-29 19:39
 */
public class 单例模式 {


}

//饿汉式
class sigleTon1 {
    private static sigleTon1 instance = new sigleTon1();

    private sigleTon1() {
    }

    public static sigleTon1 getInstance() {
        return instance;
    }
}

//懒汉
//非线程安全的
class noSynSingTon {
    private static noSynSingTon instance;

    private noSynSingTon() {
    }

    public static noSynSingTon getInstance() {
        if (instance == null) {
            instance = new noSynSingTon();
        }
        return instance;
    }
}

//懒汉双重加锁
class synSigleTon {
    private volatile static synSigleTon instance;

    private synSigleTon() {
    }

    public static synSigleTon getInstance() {
        if (instance == null) {
            synchronized (synSigleTon.class) {
                if (instance == null) {
                    instance = new synSigleTon();
                }

            }
        }
        return instance;
    }
}

//懒汉静态内部类
//线程安全
class staticSingleTOn {

    private static class staticInstance {
        private static final staticSingleTOn instance = new staticSingleTOn();
    }

    private staticSingleTOn() {
    }

    public static final staticSingleTOn getInstance() {
        return staticInstance.instance;
    }
}



