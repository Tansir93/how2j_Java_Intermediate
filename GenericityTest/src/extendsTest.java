import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.util.ArrayList;
import java.util.List;

public class extendsTest {

    public static void main(String[] args) {
    }


    public void testextends() {
        /*接受A以及A的子类型*/
        List<? extends A> list = new ArrayList<B>();
        B b = new B();
        /*不能向里面添加任何对象*/
        //list.add(b)
    }


    public void testsuper() {
        /*接受A及其父类型*/
        List<? super A> list = new ArrayList<A>();
        A a = new A();
        /*可以插入A的子类*/
        list.add(a);
    }

    public void test() {
        /*代表里面可以是任意类型*/
        List<?> list = new ArrayList<>();
        /*返回的都是object*/
        Object obj = list.get(0);

        A a = new A();
        /*不能往里面放对象*/
        //list.add(a);
    }
}

class A {

}

class B extends A {

}


