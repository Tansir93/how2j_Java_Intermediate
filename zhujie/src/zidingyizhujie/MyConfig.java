package zidingyizhujie;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Target({METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyConfig {
     String AA();
     String BB();
}
