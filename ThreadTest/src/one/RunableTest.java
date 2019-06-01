package one;

public class RunableTest {
    public static  void main(String[] args){
        B b=new B(2);
        new Thread(b).start();
    }
}
class  B implements Runnable{
    private int b;
    public B(int b){
        this.b=b;
    }
    @Override
    public void run() {
        System.out.println("我启动了"+b);
    }
}