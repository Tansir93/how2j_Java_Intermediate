package HibernateAnnotation;

import java.lang.reflect.Field;
import java.util.stream.Stream;

public class UserTest {

    public static void main(String[] args) {
        test1();
    }
    public static void test1() {
        User user = new User();
        //反射获取注解对象
        shitiduixiang stdx = user.getClass().getAnnotation(shitiduixiang.class);
        if (stdx != null) {
            System.out.println("这是实体对象");
        }
        //反射获取字段
        Field[] fields = user.getClass().getDeclaredFields();
        for (Field field :
                fields) {
            //获取注解对象
            zhujieUser zhujieuser = field.getAnnotation(zhujieUser.class);
            System.out.println(field.getAnnotation(zhujieUser.class).name());
        }
        //Lambda
        Stream.of(user.getClass().getDeclaredFields())
                .forEach(p -> System.out.println(p.getAnnotation(zhujieUser.class).name()));
    }
}
