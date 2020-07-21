package main.java.learning;
/*
单例模式：懒汉、恶汉、静态内部类等,写三种比较好理解的
* */
public class singleModel {
}

class Singleton1 {//懒汉,
    private static Singleton1 instance;
    private Singleton1(){}//单例模式必备的构造函数,让别人无法初始化

    public static synchronized Singleton1 getInstance(){//这是加锁的情况，多线程单例
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }
}


class Singleton2{//饿汉
    private static Singleton2 instance = new Singleton2();//instance在类装载时就实例化
    private Singleton2(){}
    public static Singleton2 getInstance(){
        return instance;
    }

}


class Singleton3 {//静态内部类,和饿汉对比的优势在于装载类的时候并不实例化，在调用的时候才初始化
    private static class SingletonHolder {
        private static final Singleton3 INSTANCE = new Singleton3();
    }
    private Singleton3 (){}
    public static final Singleton3 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}



