package one;

public class ThreadTest {
    public static void main(String[] args){
        A a=new A();
        a.start();
    }
}
class A extends Thread{
    @Override
    public void run() {
        System.out.println("线程启动！");
    }
}
