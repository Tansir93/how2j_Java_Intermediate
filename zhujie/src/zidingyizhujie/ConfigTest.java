package zidingyizhujie;

import java.lang.reflect.Method;

@MyConfig(AA = "aa", BB = "bb")
public class ConfigTest {

    public static void main(String[] args) {
        // Test1();
        Test2();
    }

    //获取类注解
    public static void Test1() {
        MyConfig myConfig = ConfigTest.class.getAnnotation(MyConfig.class);
        System.out.println(myConfig.AA());
        System.out.println(myConfig.BB());
    }

    //获取方法注解
    public static void Test2() {
        try {
            MyConfig mc = ConfigTest.class.getMethod("test3").getAnnotation(MyConfig.class);
            System.out.println(mc.AA());
            System.out.println(mc.BB());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @MyConfig(AA = "AA", BB = "BB")
    public void test3() {
    }
}
