import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect {


    public static void main(String[] args) throws ClassNotFoundException {

        //BTest1();
        //BTest2();
        //BTest3();
        BTest4();
    }

    //获取类对象
    public static void BTest1() {
        Class B1 = null;
        try {
            B1 = Class.forName("B");//静态属性被初始化
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        Class B2 = B.class;
        Class B3 = new B().getClass();//静态属性被初始化
        //三种方式取出来的类对象，都是一样的。
        System.out.println(B1 == B2 && B2 == B3);
    }


    //创建对象
    public static void BTest2() {
        try {
            Class B1 = Class.forName("B");
            Constructor b1 = B1.getConstructor();
            B b = (B) b1.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException ex) {
            ex.printStackTrace();
        }
    }

    //获取字段
    public static void BTest3() {
        try {
            B b = new B();
            Class B1 = Class.forName("B");
            Field fb1 = B1.getField("b");
            System.out.println(fb1);

            fb1.set(b, "b1");
            System.out.println(b.b);
            System.out.println(B1.getField("b"));
            //System.out.println(B1.getField("bb"));//无法获取私用字段
            System.out.println(B1.getField("a"));//可以获取到父类的公共字段


            System.out.println(B1.getDeclaredField("b"));
            Field fb2 = B1.getDeclaredField("bb");
            System.out.println(fb2);//可以获取私用字段
            //fb2.set(b,"b2");//无法修改私有字段值
            //System.out.println(b.b);
            //System.out.println(B1.getDeclaredField("a"));//不可以获取到父类的公共字段
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //调用方法
    public static void BTest4() {
        try {
            B B=new B();
            Class b = Class.forName("B");
            Method mb = b.getMethod("Bb");
            mb.invoke(B, null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

