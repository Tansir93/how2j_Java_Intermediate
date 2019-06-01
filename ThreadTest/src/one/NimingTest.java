package one;

public class NimingTest {

    public static void main(String[] args){
        Thread th=new Thread(){
            @Override
            public void run() {
                System.out.println("匿名类");
            }
        };
        th.start();
    }
}
